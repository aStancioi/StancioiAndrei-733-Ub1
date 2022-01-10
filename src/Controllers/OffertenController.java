package Controllers;

import Model.Offerten;
import Repositories.OffertenFileRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<String[]> listToStatistic(List<Offerten> landList){
        List<String[]> strings = new ArrayList<String[]>();
        for (Offerten i : landList)
            strings.add(new String[]{String.valueOf(i.getOrt().getNotation()) + ": ", String.valueOf(i.getPreis())});
        return strings;
    }

    public void sortLines(){
        List<Offerten> temp;

        temp = this.offertenFileRepository.getOffertenRepository().getOffertenList();
        temp = temp.stream().sorted(Comparator.comparing(Offerten::getPreis).reversed()).collect(Collectors.toList());

        //1. b)
        MyFileWriter w = new MyFileWriter();
        try {
            w.writeToFile(listToString(temp),"offertensortiert.txt");
            System.out.println("Sort Complete");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void statistik(){
        List<Offerten> temp;

        temp = this.offertenFileRepository.getOffertenRepository().getOffertenList();
        temp = temp.stream().sorted(Comparator.comparing(Offerten::getPreis).thenComparing(Offerten::getMehrwertsteuer).reversed()).collect(Collectors.toList());

        MyFileWriter w = new MyFileWriter();
        try {
            w.writeToStatistic(listToStatistic(temp),"statistik.txt");
            System.out.println("Statistic Generated");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
