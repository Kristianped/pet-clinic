package no.kristianped.petclinic.services.map;

import no.kristianped.petclinic.model.Visit;
import no.kristianped.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Visit save(Visit object) {
        if (object == null)
            return null;

        if (object.getPet() == null || object.getPet().getOwner() == null
                || object.getPet().getId() == null || object.getPet().getOwner().getId() == null)
            throw new RuntimeException("Invalid visit");

        return super.save(object);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
