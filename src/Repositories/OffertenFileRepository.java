package Repositories;

import Model.Offerten;
import Model.Ort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OffertenFileRepository {

    OffertenRepository offertenRepository;

    public OffertenRepository getOffertenRepository() {
        return offertenRepository;
    }

    public void setOffertenRepository(OffertenRepository offertenRepository) {
        this.offertenRepository = offertenRepository;
    }

    /**
     * Constructor, also reads from file
     * This method loads all the questions from the file into a list
     * @param current - tiereRepository
     * @return nothing
     * @exception IOException on invalid questions
     * @see IOException
     */
    public OffertenFileRepository(OffertenRepository current) {
        try {
            offertenRepository = current;
            List<String> questionLines = Files.readAllLines(Paths.get("F:/tiere.txt"));
            String[] lineList;
            for (String line : questionLines) {
                lineList = line.split("\\&");

                //id, unternehmen, preis, mehrwertst, addresse, ort
                Offerten temp = new Offerten(Integer.parseInt(lineList[0]),lineList[1], Long.parseLong(lineList[2]), Double.valueOf(lineList[3]),lineList[4], Ort.valueOf(lineList[5]));

                offertenRepository.addOne(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
