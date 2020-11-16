package JavaCore.block3.task356;

import java.util.Arrays;

/**
 * Напишите статический класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов (их коды влезают в один байт) в массиве байт. По сравнению с классом String, хранящим каждый символ как char, AsciiCharSequence будет занимать в два раза меньше памяти.
 * Класс AsciiCharSequence должен:
 * реализовывать интерфейс java.lang.CharSequence;
 * иметь конструктор, принимающий массив байт;
 * определять методы length(), charAt(), subSequence() и toString()
 * Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).
 * В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры, поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.
 */

public class Task356 {

    public static void main(String[] args) {
        byte[] qq = new byte[]{(byte)99, (byte)100, (byte)102, (byte)103};
        AsciiCharSequence qw = new AsciiCharSequence(qq);
        System.out.println(qw.toString());
        System.out.println(qw.subSequence(1,3));

    }


    public static class AsciiCharSequence implements CharSequence {
        private byte[] array;

        public AsciiCharSequence(byte[] array){
            this.array = array;
        }

        @Override
        public int length() {
            return array.length;
        }

        @Override
        public char charAt(int i) {
            return (char)array[i];
        }

        @Override
        public CharSequence subSequence(int i, int i1) {
            return new AsciiCharSequence(Arrays.copyOfRange(array, i, i1));
        }

        @Override
        public String toString() {
            return new String(this.array);
        }

    }

}
