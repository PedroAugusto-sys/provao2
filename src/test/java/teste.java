import controler.onibusControler;
import model.onibus.onibus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class teste {

    controler.onibusControler onibusControler = new onibusControler();
    List<onibus> onibusTeste = onibusControler.listarOnibus();


    @Test
    void setOnibusTeste() {
        onibus onibus = new onibus();
        onibus.setAssentos(15);
        onibus.setPlaca("ABC-500");
        onibus.setAno(2021);

        List<onibus> onibusList = onibusControler.listarOnibus();

        assertTrue(!onibusList.isEmpty());





    }
}
