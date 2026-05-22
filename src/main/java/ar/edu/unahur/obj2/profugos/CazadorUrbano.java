package ar.edu.unahur.obj2.profugos;

public class CazadorUrbano extends Cazador{

    public CazadorUrbano (Integer experiencia){
        super(experiencia);
    }

    @Override
    protected Boolean cumpleCondicionEspecifica(IProfugo profugo) {
        
        return !profugo.esNervioso();
    }

    @Override
    protected void intimidar(IProfugo profugo) {
    profugo.disminuirInocencia();
    profugo.dejarDeEstarNervioso();
    }   
    }
    
    



