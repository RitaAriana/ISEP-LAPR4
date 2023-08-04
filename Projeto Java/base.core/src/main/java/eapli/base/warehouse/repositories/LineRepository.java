package eapli.base.warehouse.repositories;

import eapli.base.warehouse.domain.Line;
import eapli.base.warehouse.domain.LineId;
import eapli.framework.domain.repositories.DomainRepository;

public interface LineRepository extends DomainRepository<LineId, Line> {}
