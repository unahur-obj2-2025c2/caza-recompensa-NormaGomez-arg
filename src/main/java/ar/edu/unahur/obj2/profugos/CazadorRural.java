package ar.edu.unahur.obj2.profugos;

public class CazadorRural extends Cazador{
    public CazadorRural (Integer experiencia){
        super(experiencia);
    }

    @Override
    protected Boolean cumpleCondicionEspecifica(IProfugo profugo) {
        
        return profugo.esNervioso();
    }
    @Override
    protected void intimidar(IProfugo profugo) {
        profugo.volverseNervioso();
    }
    


}

