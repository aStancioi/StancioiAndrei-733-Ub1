package Repositories;

import Model.Offerten;
import Model.Ort;

import java.util.List;

public class OffertenRepository {
    private List<Offerten> offertenList;

    public OffertenRepository(List<Offerten> offertenList) {
        this.offertenList = offertenList;
    }

    public List<Offerten> getOffertenList() {
        return offertenList;
    }

    public void setOffertenList(List<Offerten> offertenList) {
        this.offertenList = offertenList;
    }

    /**
     * add an offer
     * @param entity must be not null
     * @return null- if the given entity is saved otherwise returns the entity (id already exists)
     */
    public Offerten addOne(Offerten entity) {
        for (Offerten i : offertenList)
        {
            if (i.getId() == entity.getId())
                return entity;
        }
        offertenList.add(entity);
        return null;
    }

    /**
     * find an offer by id
     * @param id valid id
     * @return element with the given id(position)
     */
    public Offerten getOne(int id) {
        if(offertenList.size()>id)
            return offertenList.get(id);
        return null;
    }
}
