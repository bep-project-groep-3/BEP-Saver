package org.nl.hu.sie.bep.business.adapter;

import org.nl.hu.sie.bep.business.dto.BedrijfRow;

public interface Adapter {
    void save(int maand, BedrijfRow bedrijfRow);
}


