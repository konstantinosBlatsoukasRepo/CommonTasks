package kon.blats.javaEight.optionalExample;

import kon.blats.javaEight.optionalExample.pojosWithOptional.ComputerOptional;
import kon.blats.javaEight.optionalExample.pojosWithOptional.SoundCardOptional;
import kon.blats.javaEight.optionalExample.pojosWithOptional.UsbOptional;
import kon.blats.javaEight.optionalExample.pojosWithoutOptional.Computer;
import kon.blats.javaEight.optionalExample.pojosWithoutOptional.SoundCard;
import kon.blats.javaEight.optionalExample.pojosWithoutOptional.Usb;
import org.junit.Test;

import java.util.Optional;

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

    @Test
    public void testWithOptional() {
        UsbOptional usb = new UsbOptional();
        SoundCardOptional soundCardOptional = new SoundCardOptional();
        Optional<SoundCardOptional> soundCardOptionalSec = Optional.of(soundCardOptional);
        soundCardOptional.setUsb(Optional.of(usb)); // Optional creation
        ComputerOptional computer = new ComputerOptional();
        computer.setSoundCard(soundCardOptionalSec);
        String usbVersion = Optional.of(computer)
                .flatMap(computerOptional -> computerOptional.getSoundCard())
                .flatMap(SoundCardOptional::getUsb)
                .map(UsbOptional::getVersion).orElse("NOT KNOWN");
        System.out.println(usbVersion);
    }
}
