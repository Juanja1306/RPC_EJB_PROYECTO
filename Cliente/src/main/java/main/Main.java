package main;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import model.Member;
import service.MemberRegistrationRemote;

public class Main {
    private MemberRegistrationRemote memberRegistration;

    public void initialize() throws Exception {
        Hashtable<String, Object> jndiProps = new Hashtable<>();
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProps.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

        try {
            Context context = new InitialContext(jndiProps);
            memberRegistration = (MemberRegistrationRemote) context.lookup(
                "ejb:/Server/MemberRegistration!service.MemberRegistrationRemote"
            );
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error JNDI lookup. ");
            throw e;
        }
    }

    public void registerMember(String name, String email, String phone) throws Exception {
        Member member = new Member();
        member.setName(name);
        member.setEmail(email);
        member.setPhoneNumber(phone);

        memberRegistration.register(member);
        System.out.println("Member registered: " + name);
    }

    public static void main(String[] args) {
        try {
            Main client = new Main();
            client.initialize();
            client.registerMember("Juan", "Jan@example.com", "0989765438");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}