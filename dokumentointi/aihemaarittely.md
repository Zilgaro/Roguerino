**Aihe**: Roguelike-pelin alusta. 

Alkuperäinen aihemäärittely: *Toteutetaan ylhäältä alaspäin kuvattu vuoropohjainen peli, jossa pelaajan on tarkoitus erilaisissa satunnaisgeneroiduissa tasoissa päihittää vihollisia, etsiä aarteita, kehittää hahmoaan ja päihittää lopulta päävihollinen. Pelaamisen tulee tapahtua graafisessa ikkunassa, ohjaaminen tapahtuu hiirellä/nuolinäppäimillä. Kentät tulevat olemaan vaihtelevan kokoisia, pelaaja aloittaa valmiiksimääritellystä paikasta ja kentällä olevat talot ja viholliset generoidaan joka tason alussa.*

Toteutettiin ylhäältä alaspäin kuvattu reaaliajassa pyörivä peli, jossa tavoitteena on hiirellä liikkumalla metsästää kartalle satunnaisiin paikkoihin generoidut ja satunnaisiin suuntiin liikkuvat viholliset. Kenttä on defaulttina 30 blockia leveä ja 30 blockia korkea. Kentälle on satunnaisesti generoitu myös 4x3 kokoisia taloja tai "huoneita". Kuten mainittu, pelin tarkoituksena on metsästää kaikki 20 kentälle generoitua vihollista, jotka liikkuvat satunnaisiin suuntiin. Jotta vihollisia voi "tappaa" on liikuttava niiden viereen (liikkuminen tapahtuu yksi blocki kerrallaan hiireä haluttuun suuntaan klikkaamalla) ja klikata blockia, jolla vihollinen sillä hetkellä sattuu olemaan. Kun kaikki 20 vihollista on saatu hengiltä, promptataan käyttäjää onnitteluviestillä ja ohjelma sulkee itse itsensä.


**Käyttäjät**: Pelaaja

**Yleinen käyttötapahtuma**: 

1. Ohjelman käynnistys
2. Ohjelma promptaa käyttäjää JOptionpanen avulla toteutetulla informaatioikkunalla
  * Pelaaja klikkaa ikkunan 'OK' näppäintä
3. Pelaaja liikkuu kentässä haluamiinsa suuntiin hiiren avulla ja metsästää punaisella ympyrällä merkattuja vihollisia
4. Peli päättyy kun kaikki viholliset on poistettu kentältä
  * Tai kun pelaaja painaa ruksia ikkunan oikeassa ylälaidassa
5. Pelin päättymisen (kaikkien vihollisten kuoltua) yhteydessä pelaajaa onnittelaan jälleen JOptionpanen avulla toteutulla informaatioikkunalla
  * Peli sulkee itse itsensä kun pelaaja klikkaa ikkunan 'OK' näppäintä.
