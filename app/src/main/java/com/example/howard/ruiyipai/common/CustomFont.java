package com.example.howard.ruiyipai.common;

import android.content.Context;
import android.graphics.Typeface;

import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by howard on 2018/1/13.
 * Email zh@longhuapuxin.com
 */


public class CustomFont implements ITypeface {

//    private static final String TTF_FILE = "icomoon.ttf";
        private static final String TTF_FILE = "fontello.ttf";
    private static Typeface typeface = null;
    private static HashMap<String, Character> mChars;

    @Override
    public IIcon getIcon(String key) {
        return Icon.valueOf(key);
    }

    @Override
    public HashMap<String, Character> getCharacters() {

        if (mChars == null) {
            HashMap<String, Character> aChars = new HashMap<String, Character>();
            for (Icon v : Icon.values()) {
                aChars.put(v.name(), v.character);
            }
            mChars = aChars;
        }

        return mChars;
    }


    @Override

    public String getMappingPrefix() {
        return "fon";
    }

    @Override
    public String getFontName() {
        return "CustomFont";
    }


    @Override
    public String getVersion() {
        return "1.0.0";
    }


    @Override

    public int getIconCount() {
        return mChars.size();
    }


    @Override
    public Collection<String> getIcons() {
        Collection<String> icons = new LinkedList<String>();
        for (Icon value : Icon.values()) {
            icons.add(value.name());
        }
        return icons;
    }

    @Override

    public String getAuthor() {

        return "SampleCustomFont";

    }


    @Override

    public String getUrl() {

        return "";

    }


    @Override

    public String getDescription() {

        return "";

    }


    @Override

    public String getLicense() {

        return "";

    }


    @Override

    public String getLicenseUrl() {

        return "";

    }


    @Override

    public Typeface getTypeface(Context context) {

        if (typeface == null) {

            try {

                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + TTF_FILE);

            } catch (Exception e) {

                return null;

            }

        }

        return typeface;
    }


    public enum Icon implements IIcon {

        //        fon_test1('\ue800'),
        fon_800('\ue800'),
        fon_801('\ue801'),
        fon_802('\ue802'),
        fon_803('\ue803'),
        fon_804('\ue804'),
        fon_805('\ue805'),
        fon_806('\ue806'),
        fon_807('\ue807'),
        fon_808('\ue808'),
        fon_809('\ue809'),
        fon_80a('\ue80a'),
        fon_80b('\ue80b'),
        fon_80c('\ue80c'),
        fon_80d('\ue80d'),
        fon_80e('\ue80e'),
        fon_80f('\ue80f'),
        fon_810('\ue810'),
        fon_811('\ue811'),
        fon_812('\ue812'),
        fon_813('\ue813'),
        fon_814('\ue814'),
        fon_815('\ue815'),
        fon_816('\ue816'),
        fon_817('\ue817'),
        fon_818('\ue818'),
        fon_819('\ue819'),
        fon_81a('\ue81a'),
        fon_81b('\ue81b'),
        fon_81c('\ue81c'),
        fon_81d('\ue81d'),
        fon_81e('\ue81e'),
        fon_81f('\ue81f'),
        fon_820('\ue820'),
        fon_821('\ue821'),
        fon_822('\ue822'),
        fon_823('\ue823'),
        fon_824('\ue824'),
        fon_825('\ue825');



        char character;

        Icon(char character) {
            this.character = character;
        }


        public String getFormattedName() {

            return "{" + name() + "}";

        }


        public char getCharacter() {

            return character;

        }


        public String getName() {

            return name();

        }


        // remember the typeface so we can use it later

        private static ITypeface typeface;


        public ITypeface getTypeface() {

            if (typeface == null) {

                typeface = new CustomFont();

            }

            return typeface;

        }

    }
}
