export class UpdateDataMaestra{
    nmmaestro: number;
    nmdato: number;
    cddato: String;
    dsdato: String;
    cddato1: String;
    cddato2: String;
    cddato3: String;
    feregitro: String;
    febaja: String;

    constructor(nmdato:number, cddato:String, dsdato:String, 
        cddato1:String, cddato2:String, cddato3:String){
    this.nmdato=nmdato;
    this.cddato=cddato;
    this.dsdato=dsdato;
    this.cddato1=cddato1;
    this.cddato2=cddato2;
    this.cddato3=cddato3;
    }
}