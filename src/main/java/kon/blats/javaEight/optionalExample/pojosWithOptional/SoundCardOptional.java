package kon.blats.javaEight.optionalExample.pojosWithOptional;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/**
 * Created by k.blatsoukas on 9/20/2017.
 */
@Getter
@Setter
public class SoundCardOptional {
    private Optional<UsbOptional> usb;
}
