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
        fon_825('\ue825'),
        fon_826('\ue826'),
        fon_827('\ue827'),
        fon_828('\ue828'),
        fon_829('\ue829'),
        fon_82a('\ue82a'),
        fon_82b('\ue82b'),
        fon_82c('\ue82c'),
        fon_82d('\ue82d'),
        fon_82e('\ue82e'),
        fon_82f('\ue82f'),
        fon_830('\ue830'),
        fon_831('\ue831'),
        fon_832('\ue832'),
        fon_833('\ue833'),
        fon_834('\ue834'),
        fon_835('\ue835'),
        fon_836('\ue836'),
        fon_837('\ue837'),
        fon_838('\ue838'),
        fon_839('\ue839'),
        fon_83a('\ue83a'),
        fon_83b('\ue83b'),
        fon_83c('\ue83c'),
        fon_83d('\ue83d'),
        fon_83e('\ue83e'),
        fon_83f('\ue83f'),
        fon_830('\ue840'),
        fon_831('\ue841'),
        fon_832('\ue842'),
        fon_833('\ue843'),
        fon_834('\ue844'),
        fon_835('\ue845'),
        fon_836('\ue846'),
        fon_837('\ue847'),
        fon_838('\ue848'),
        fon_839('\ue849'),
        fon_83a('\ue84a'),
        fon_83b('\ue84b'),
        fon_83c('\ue84c'),
        fon_83d('\ue84d'),
        fon_83e('\ue84e'),
        fon_83f('\ue84f');
                
                

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
