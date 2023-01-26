package ma.nacer.custumermicroservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "projectionCostumer",types = Costumer.class)
public interface CostumerProjection {
    public Long getId();
    public String getName();
}
