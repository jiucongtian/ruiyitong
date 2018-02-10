package com.example.baselibrary.common;

import android.content.Context;
import android.graphics.Typeface;

import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by howard on 2018/1/13.
 * Email 158988127@qq.com
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
        fon_840('\ue840'),
        fon_841('\ue841'),
        fon_842('\ue842'),
        fon_843('\ue843'),
        fon_844('\ue844'),
        fon_845('\ue845'),
        fon_846('\ue846'),
        fon_847('\ue847'),
        fon_848('\ue848'),
        fon_849('\ue849'),
        fon_84a('\ue84a'),
        fon_84b('\ue84b'),
        fon_84c('\ue84c'),
        fon_84d('\ue84d'),
        fon_84e('\ue84e'),
        fon_84f('\ue84f'),
        fon_850('\ue850'),
        fon_851('\ue851'),
        fon_852('\ue852'),
        fon_853('\ue853'),
        fon_854('\ue854'),
        fon_855('\ue855'),
        fon_856('\ue856'),
        fon_857('\ue857'),
        fon_858('\ue858'),
        fon_859('\ue859'),
        fon_85a('\ue85a'),
        fon_85b('\ue85b'),
        fon_85c('\ue85c'),
        fon_85d('\ue85d'),
        fon_85e('\ue85e'),
        fon_85f('\ue85f'),
        fon_860('\ue860'),
        fon_861('\ue861'),
        fon_862('\ue862'),
        fon_863('\ue863'),
        fon_864('\ue864'),
        fon_865('\ue865'),
        fon_866('\ue866'),
        fon_867('\ue867'),
        fon_868('\ue868'),
        fon_869('\ue869'),
        fon_86a('\ue86a'),
        fon_86b('\ue86b'),
        fon_86c('\ue86c'),
        fon_86d('\ue86d'),
        fon_86e('\ue86e'),
        fon_86f('\ue86f'),
        fon_870('\ue870'),
        fon_871('\ue871'),
        fon_872('\ue872'),
        fon_873('\ue873'),
        fon_874('\ue874'),
        fon_875('\ue875'),
        fon_876('\ue876'),
        fon_877('\ue877'),
        fon_878('\ue878'),
        fon_879('\ue879'),
        fon_87a('\ue87a'),
        fon_87b('\ue87b'),
        fon_87c('\ue87c'),
        fon_87d('\ue87d'),
        fon_87e('\ue87e'),
        fon_87f('\ue87f');
                
                

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
