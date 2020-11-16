package JavaCore.block4.task437;

import JavaCore.block4.task428.Task428;

import java.util.Arrays;
import java.util.logging.*;

/**
 * Вам необходимо описать набор классов, каждый из которых является MailService:
 *
 * 1) UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того, чтобы передать почтовый объект непосредственно в сервис почты, последовательно передает этот объект набору третьих лиц, а затем, в конце концов, передает получившийся объект непосредственно экземпляру RealMailService. У UntrustworthyMailWorker должен быть конструктор от массива MailService (результат вызова processMail первого элемента массива передается на вход processMail второго элемента, и т. д.) и метод getRealMailService, который возвращает ссылку на внутренний экземпляр RealMailService, он не приходит масивом в конструкторе и не настраивается извне класса.
 *
 * 2) Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки. Объект конструируется от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях. Он следит только за объектами класса MailMessage и пишет в логгер следующие сообщения (в выражениях нужно заменить части в фигурных скобках на значения полей почты):
 * 2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с уровнем WARN: Detected target mail correspondence: from {from} to {to} "{message}"
 * 2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
 *
 * 3) Thief – вор, который ворует самые ценные посылки и игнорирует все остальное. Вор принимает в конструкторе переменную int – минимальную стоимость посылки, которую он будет воровать. Также, в данном классе должен присутствовать метод getStolenValue, который возвращает суммарную стоимость всех посылок, которые он своровал. Воровство происходит следующим образом: вместо посылки, которая пришла вору, он отдает новую, такую же, только с нулевой ценностью и содержимым посылки "stones instead of {content}".
 *
 * 4) Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения, если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных содержимым ("weapons" и "banned substance"), то он бросает IllegalPackageException. Если он находит посылку, состоящую из камней (содержит слово "stones"), то тревога прозвучит в виде StolenPackageException. Оба исключения вы должны объявить самостоятельно в виде непроверяемых исключений.
 *
 * Все классы должны быть определены как публичные и статические, так как в процессе проверки ваш код будет подставлен во внешний класс, который занимается тестированием и проверкой структуры. Для удобства во внешнем классе объявлено несколько удобных констант и импортировано все содержимое пакета java.util.logging. Для определения, посылкой или письмом является Sendable объект воспользуйтесь оператором instanceof.
 */

public class Task437 {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Task428.class.getName());
        logger.setLevel(Level.INFO);
        Inspector inspector = new Inspector();
        Spy spy = new Spy(logger);
        Thief thief = new Thief(10000);
        MailService variousWorkers[] = new MailService[]{spy, thief, inspector};
        UntrustworthyMailWorker worker = new UntrustworthyMailWorker(variousWorkers);
        Package pack1 = new Package("ВВЖ", 32);
        Package pack2 = new Package("рпакетный двигатель ", 2500000);
        Package pack3 = new Package("stones", 1000);
        Package pack4 = new Package("banned substance", 99);
        Package pack5 = new Package("tiny bomb", 9000);
        AbstractSendable correspondence[] = {
                new MailMessage("Oxxxymiron", "Гнойный", "Я здесь чисто по фану, поглумиться над слабым\n" +
                        "Ты же вылез из мамы под мой дисс на Бабана...."),
                new MailMessage("Гнойный", "Oxxxymiron", "....Что? Так болел за Россию, что на нервах терял ганглии.\n" +
                        "Но когда тут проходили митинги, где ты сидел? В Англии!...."),
                new MailMessage("Жриновский", AUSTIN_POWERS, "Бери пацанов, и несите меня к воде."),
                new MailMessage(AUSTIN_POWERS, "Пацаны", "Го, потаскаем Вольфовича как Клеопатру"),
                new MailPackage("берег", "море", pack1),
                new MailMessage("NASA", AUSTIN_POWERS, "Найди в России ракетные двигатели и лунные stones"),
                new MailPackage(AUSTIN_POWERS, "NASA", pack2),
                new MailPackage(AUSTIN_POWERS, "NASA", pack3),
                new MailPackage("Китай", "КНДР", pack4),
                new MailPackage(AUSTIN_POWERS, "ИГИЛ (запрещенная группировка", pack5),
                new MailMessage(AUSTIN_POWERS, "Психиатр", "Помогите"),
        };
        Arrays.stream(correspondence).forEach(parcell -> {
            try {
                worker.processMail(parcell);
            } catch (StolenPackageException e) {
                logger.log(Level.WARNING, "Inspector found stolen package: " + e);
            } catch (IllegalPackageException e) {
                logger.log(Level.WARNING, "Inspector found illegal package: " + e);
            }
        });

        System.out.println(thief.getStolenValue());
    }







    /*
    Интерфейс: сущность, которую можно отправить по почте.
    У такой сущности можно получить от кого и кому направляется письмо.
    */
    public static interface Sendable {
        String getFrom();
        String getTo();
    }

    //У Sendable есть два наследника, объединенные следующим абстрактным классом:

    /*
    Абстрактный класс,который позволяет абстрагировать логику хранения
    источника и получателя письма в соответствующих полях класса.
    */
    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;

            return true;
        }

    }

    //Первый класс описывает обычное письмо, в котором находится только текстовое сообщение.

    /*
    Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
    */
    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            if (message != null ? !message.equals(that.message) : that.message != null) return false;

            return true;
        }

    }

    //Второй класс описывает почтовую посылку:

    /*
    Посылка, содержимое которой можно получить с помощью метода `getContent`
    */
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            if (!content.equals(that.content)) return false;

            return true;
        }

    }

    //При этом сама посылка описывается следующим классом:

    /*
    Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
    */
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;

            return true;
        }
    }

    //Теперь рассмотрим классы, которые моделируют работу почтового сервиса:

    /*
    Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
    */
    public static interface MailService {
        Sendable processMail(Sendable mail);
    }

    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }

    /*
    2) Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки.
    Объект конструируется от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях.
    Он следит только за объектами класса MailMessage и пишет в логгер следующие сообщения (в выражениях нужно
    заменить части в фигурных скобках на значения полей почты):
    2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение
    с уровнем WARN: Detected target mail correspondence: from {from} to {to} "{message}"
    2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
    */

    public static class Spy implements MailService {
        Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
            logger.setLevel(Level.INFO);
            Handler handler = new ConsoleHandler();
            this.logger.addHandler(handler);
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                MailMessage message = (MailMessage) mail;
                if (message.getFrom().equals(AUSTIN_POWERS) || message.getTo().equals(AUSTIN_POWERS)) {
                    logger.log(Level.WARNING, "Detected target mail correspondence: from " +
                            message.getFrom() + " to " + message.getTo() + " \"" + message.getMessage() + "\"");
                } else {
                    logger.log(Level.INFO, "Usual correspondence: from " +
                            message.getFrom() + " to " + message.getTo());
                }
            }
            return mail;
        }
    }

    /*
    Thief – вор, который ворует самые ценные посылки и игнорирует все остальное.
    Вор принимает в конструкторе переменную int – минимальную стоимость посылки, которую он будет воровать.
    Также, в данном классе должен присутствовать метод getStolenValue, который возвращает суммарную стоимость
    всех посылок, которые он своровал. Воровство происходит следующим образом: вместо посылки, которая пришла вору,
    он отдает новую, такую же, только с нулевой ценностью и содержимым посылки "stones instead of {content}".
    */

    public static class Thief implements MailService {
        private int minimalPrice;
        private int stolenValue;


        public Thief(int minimalPrice) {
            this.minimalPrice = minimalPrice;
            stolenValue = 0;
        }

        @Override
        public Sendable processMail(Sendable mail) {

            if (mail instanceof MailPackage) {
                MailPackage mailPackage = (MailPackage) mail;
                if (mailPackage.getContent().getPrice() >= minimalPrice) {
                    stolenValue += mailPackage.getContent().getPrice();
                    return new MailPackage(mailPackage.getFrom(), mailPackage.getTo(),
                            new Package("stones instead of " + mailPackage.getContent().getContent(), 0));
                }
            }
            return mail;
        }

        public int getStolenValue() {
            return stolenValue;
        }
    }

    /*
    Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
    если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных содержимым
    ("weapons" и "banned substance"), то он бросает IllegalPackageException. Если он находит посылку,
    состоящую из камней (содержит слово "stones"), то тревога прозвучит в виде StolenPackageException.
    Оба исключения вы должны объявить самостоятельно в виде непроверяемых исключений.
    */

    public static class Inspector implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                MailPackage mailPackage = (MailPackage) mail;
                String contentIn = mailPackage.getContent().getContent();
                if (contentIn.contains("stones")) {
                    throw new StolenPackageException();
                }
                if (contentIn.contains(WEAPONS) || contentIn.contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                }

            }
            return mail;
        }
    }

    public static class IllegalPackageException extends RuntimeException {
    }

    public static class StolenPackageException extends RuntimeException {
    }

    /*
    UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того,
    чтобы передать почтовый объект непосредственно в сервис почты, последовательно передает этот объект набору
    третьих лиц, а затем, в конце концов, передает получившийся объект непосредственно экземпляру RealMailService.
    У UntrustworthyMailWorker должен быть конструктор от массива MailService (результат вызова processMail первого
    элемента массива передается на вход processMail второго элемента, и т. д.) и метод getRealMailService,
    который возвращает ссылку на внутренний экземпляр RealMailService, он не приходит масивом в конструкторе и
    не настраивается извне класса.
    */

    public static class UntrustworthyMailWorker implements MailService {
        private MailService[] postOfRussia;
        private RealMailService realMailService;

        public UntrustworthyMailWorker(MailService[] postOfRussia) {
            this.postOfRussia = postOfRussia;
            realMailService = new RealMailService();
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for (MailService lost : postOfRussia) {
                mail = lost.processMail(mail);
            }
            return realMailService.processMail(mail);
        }

        public MailService getRealMailService() {
            return realMailService;
        }

    }
}
