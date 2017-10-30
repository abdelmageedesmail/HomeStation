package com.brand.homestation.db;

import android.provider.BaseColumns;

/**
 * Created by abdelmageed on 7/24/2016.
 */
public class Contract {

    public static final String userId = "userId";



    public static class OffersTable implements BaseColumns {
        public static final String TABLENAME = "offersTable";

        public static final String id = "id";
        public static final String offerDescription = "offerDescription";
        public static final String offerImg = "offerImg";
        public static final String offerName="offerName";
        public static final String offerPrice="offerPrice";
        public static final String rate="rate";
        public static final String component="component";
        public static final String delivery="delivery";
        public static final String addotion="addition";
    }

}
