package dev.obscuria.accents.fabric.content;

import dev.obscuria.accents.content.IVanityProvider;
import dev.obscuria.accents.content.item.VanityItem;
import dev.obscuria.accents.fabric.content.item.*;

public final class FabricVanityProvider implements IVanityProvider {

    @Override
    public VanityItem createCaptainHat() {
        return new CaptainHatItem();
    }

    @Override
    public VanityItem createPumpkinHat() {
        return new PumpkinHatItem();
    }

    @Override
    public VanityItem createQuiver() {
        return new QuiverItem();
    }

    @Override
    public VanityItem createBandolier() {
        return new BandolierItem();
    }

    @Override
    public VanityItem createCakemanPlushie() {
        return new CakemanPlushieItem();
    }

    @Override
    public VanityItem createChristmasHat() {
        return new ChristmasHatItem();
    }

    @Override
    public VanityItem createCowboyHat() {
        return new CowboyHatItem();
    }

    @Override
    public VanityItem createCrown() {
        return new CrownItem();
    }

    @Override
    public VanityItem createDragonSkull() {
        return new DragonSkullItem();
    }

    @Override
    public VanityItem createHermesBoots() {
        return new HermesBootsItem();
    }

    @Override
    public VanityItem createHolsteredBelt() {
        return new HolsteredBeltItem();
    }

    @Override
    public VanityItem createHorns() {
        return new HornsItem();
    }

    @Override
    public VanityItem createKasaHat() {
        return new KasaHatItem();
    }

    @Override
    public VanityItem createOvertopHat() {
        return new OvertopHatItem();
    }

    @Override
    public VanityItem createPickelhaube() {
        return new PickelhaubeItem();
    }

    @Override
    public VanityItem createPirateHat() {
        return new PirateHatItem();
    }

    @Override
    public VanityItem createSheathedKatana() {
        return new SheathedKatanaItem();
    }

    @Override
    public VanityItem createSkull() {
        return new SkullItem();
    }

    @Override
    public VanityItem createSombrero() {
        return new SombreroItem();
    }

    @Override
    public VanityItem createStrawHat() {
        return new StrawHatItem();
    }

    @Override
    public VanityItem createTopHat() {
        return new TopHatItem();
    }

    @Override
    public VanityItem createWings() {
        return new WingsItem();
    }

    @Override
    public VanityItem createWizardHat() {
        return new WizardHatItem();
    }
}
