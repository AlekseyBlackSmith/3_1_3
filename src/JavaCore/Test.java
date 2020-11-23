package JavaCore;


import java.io.*;

public class Test {


        private String name;
        private int weight;

        public Test(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        // copy constructor
        // copies the fields of other into the new object
        public Test(Test other) {
            this.name = other.name;
            this.weight = other.weight;
        }







    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // create a sheep
        Test sheep = new Test("Dolly", 20);
        // clone the sheep
        Test dolly = new Test(sheep); // dolly.name is "Dolly" and dolly.weight is 20
        sheep.name = "jbkjbhkj";


        System.out.println(sheep.name + " " + sheep.weight);
        System.out.println(dolly.name + " " + dolly.weight);
    }



}