import java.io.*;
import java.lang.reflect.Constructor; //reflection
import java.lang.reflect.InvocationTargetException; //reflection

public class Main {                        //per Class.forName
    public static void main(String[] args) throws ClassNotFoundException {
//        Singleton s1 = Singleton.getInstance();
//        Singleton s2 = Singleton.getInstance();

          //Class.forName("SingletonNoLazy");
          //Class.forName("Singleton");

        //credits: Keval Patel on Medium
        //Singleton istanza1 = Singleton.getInstance();

        //otteniamo una seconda istanza con la reflection
//        Singleton istanza2 = null;
//        try {
//            Class<Singleton> ref = Singleton.class;
//            Constructor<Singleton> costruttore = ref.getDeclaredConstructor();
//            costruttore.setAccessible(true);
//            istanza2 = costruttore.newInstance();
//        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
//            e.printStackTrace();
//        } //fine reflection

        //otteniamo una seconda istanza con serializzazione / deserializzazione della prima
        //credits: Keval Patel on Medium
//        try {
//            ObjectOutput out = null;
//
//            //  serializziamo
//            out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
//            out.writeObject(istanza1);
//            out.close();
//
//            //deserializziamo da file a un un oggetto
//            ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
//            Singleton istanza2 = (Singleton) in.readObject();
//            in.close();
//
//            System.out.println("instance1 hashCode=" + istanza1.hashCode());
//            System.out.println("instance2 hashCode=" + istanza2.hashCode());
//
//        } catch (ClassNotFoundException | IOException e) {
//            e.printStackTrace();
//        }

//        Singleton istanza2 = Singleton.getInstance();

//        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
//
//        EnumSingleton istanza1 = EnumSingleton.INSTANCE;
//        EnumSingleton istanza2 = EnumSingleton.INSTANCE;
//
//        System.out.println("instance1 hashCode=" + istanza1.hashCode());
//        System.out.println("instance2 hashCode=" + istanza2.hashCode());
//
//        System.out.println(enumSingleton.getValue());
//        enumSingleton.setValue(300);
//        System.out.println(enumSingleton.getValue());

          EnumSingleton.f();

    }
}
//--------------------------------------------- fine main --------------------------------------------

    Singleton() {
        // costruttore privato
        System.out.println("Invocato il costruttore");
    }

    public static Singleton getInstance() {
        return ContenitoreIstanza.instance;
    }

    private static class ContenitoreIstanza {
        private static Singleton instance = new Singleton();
    }
}
//---------------------------------------------------------------------------------
public class SingletonNoLazy {
    private SingletonNoLazy() {
        System.out.println("invocato costruttore no Lazy");
    }

    private static SingletonNoLazy instance = new SingletonNoLazy();

    public static SingletonNoLazy getInstance() {
        return instance;
    }
}

//-----------------------------------------------------------------------
public enum EnumSingleton {
    INSTANCE;
    EnumSingleton() {System.out.println("ciao");}

    //public static void f() {}

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}


