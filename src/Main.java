import Controllers.OffertenController;
import Model.Offerten;
import Repositories.OffertenFileRepository;
import Repositories.OffertenRepository;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start here: ");

        OffertenController offertenController = new OffertenController(new OffertenFileRepository(new OffertenRepository(new ArrayList<Offerten>())));
    }
}
