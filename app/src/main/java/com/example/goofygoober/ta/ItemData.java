package com.example.goofygoober.ta;

import java.io.Serializable;

/**
 * Created by titih on 17/05/2017.
 */

public class ItemData implements Serializable {
    public String itemTitle;
    public String itemDesc;
    public String itemImg; // optional aja //ini dipake untuk url (dr internet)
    public int itemImgId; //soalnya biasanya resource buat gambar itu pake id dan typenya int
    public String itemLink;
    public String itemDate;

}
