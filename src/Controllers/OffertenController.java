package Controllers;

import Model.Offerten;
import Repositories.OffertenFileRepository;

import java.util.ArrayList;
import java.util.List;

public class OffertenController {

    private OffertenFileRepository offertenFileRepository;

    public OffertenController(OffertenFileRepository offertenFileRepository) {
        this.offertenFileRepository = offertenFileRepository;
    }

    public OffertenFileRepository getOffertenFileRepository() {
        return offertenFileRepository;
    }

    public void setOffertenFileRepository(OffertenFileRepository offertenFileRepository) {
        this.offertenFileRepository = offertenFileRepository;
    }

    public List<String[]> listToString(List<Offerten> landList){
        List<String[]> strings = new ArrayList<String[]>();
        for (Offerten i : landList)
            strings.add(new String[]{String.valueOf(i.getId()), i.getUnternehmensname(), String.valueOf(i.getPreis()), String.valueOf(i.getMehrwertsteuer()), i.getAdresse(), i.getOrt().getNotation()});
        return strings;
    }
}
