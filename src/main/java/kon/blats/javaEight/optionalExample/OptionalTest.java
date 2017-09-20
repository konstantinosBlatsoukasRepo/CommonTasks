package kon.blats.javaEight.optionalExample;

import org.junit.Test;

/**
 * Created by k.blatsoukas on 9/20/2017.
 */
public class OptionalTest {
    @Test
    public void testWithoutOptional() {
        Usb usb = new Usb();
        usb.setVersion("12.1");
        SoundCard soundCard = new SoundCard();
        soundCard.setUsb(usb);
        Computer computer = new Computer();
        computer.setSoundCard(soundCard);
        if(computer.getSoundCard() != null) {
            if(computer.getSoundCard().getUsb() != null) {
                if(computer.getSoundCard().getUsb().getVersion() != null) {
                    String soundCardVersion = computer.getSoundCard().getUsb().getVersion();
                    System.out.println(soundCardVersion);
                }
            }
        }
    }
}
