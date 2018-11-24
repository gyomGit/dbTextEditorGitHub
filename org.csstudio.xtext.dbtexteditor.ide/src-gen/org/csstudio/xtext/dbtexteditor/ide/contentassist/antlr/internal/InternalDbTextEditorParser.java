package org.csstudio.xtext.dbtexteditor.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.csstudio.xtext.dbtexteditor.services.DbTextEditorGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDbTextEditorParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_SL_COMMENT", "RULE_ID", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'NAME'", "'DESC'", "'ASG'", "'SCAN'", "'PHAS'", "'PINI'", "'SDIS'", "'PROC'", "'PACT'", "'SEVR'", "'STAT'", "'TIME'", "'DTYP'", "'ONAM'", "'OSV'", "'OUT'", "'SIML'", "'ZNAM'", "'ZSV'", "'INP'", "'EGU'", "'LINR'", "'EGUL'", "'EGUF'", "'HIGH'", "'HSV'", "'HIHI'", "'HHSV'", "'EIST'", "'EISV'", "'EIVL'", "'ELST'", "'ELSV'", "'ELVL'", "'FRST'", "'FRSV'", "'FRVL'", "'FVST'", "'HYST'", "'LLSV'", "'FVSV'", "'FVVL'", "'MASK'", "'NIST'", "'NISV'", "'NIVL'", "'NOBT'", "'ONST'", "'ONSV'", "'ONVL'", "'SHFT'", "'SVST'", "'SVSV'", "'SVVL'", "'SXST'", "'SXSV'", "'SXVL'", "'TEST'", "'TESV'", "'TEVL'", "'THST'", "'THSV'", "'THVL'", "'TWST'", "'TWSV'", "'TWVL'", "'UNSV'", "'ZRST'", "'ZRSV'", "'ZRVL'", "'LOLO'", "'LOW'", "'LSV'", "'SSCN'", "'TSE'", "'PREC'", "'DRVH'", "'LOPR'", "'DRVL'", "'HOPR'", "'CALC'", "'INPA'", "'INPB'", "'INPC'", "'INPD'", "'FLNK'", "'INPE'", "'INPF'", "'INPG'", "'INPH'", "'INPI'", "'INPJ'", "'INPK'", "'INAA'", "'INBB'", "'INCC'", "'SIOL'", "'ai'", "'ao'", "'longin'", "'longout'", "'stringin'", "'stringout'", "'lsi'", "'lso'", "'waveform'", "'bi'", "'bo'", "'mbbi'", "'mbbo'", "'mbbiDirect'", "'mbboDirect'", "'calcout'", "'scalcout'", "'calc'", "'('", "','", "')'", "'{'", "'}'", "'info'", "'.'", "'record'", "'field'", "'asyn:READBACK'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=7;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=4;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=6;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalDbTextEditorParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDbTextEditorParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDbTextEditorParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDbTextEditor.g"; }


    	private DbTextEditorGrammarAccess grammarAccess;

    	public void setGrammarAccess(DbTextEditorGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuledbModel"
    // InternalDbTextEditor.g:53:1: entryRuledbModel : ruledbModel EOF ;
    public final void entryRuledbModel() throws RecognitionException {
        try {
            // InternalDbTextEditor.g:54:1: ( ruledbModel EOF )
            // InternalDbTextEditor.g:55:1: ruledbModel EOF
            {
             before(grammarAccess.getDbModelRule()); 
            pushFollow(FOLLOW_1);
            ruledbModel();

            state._fsp--;

             after(grammarAccess.getDbModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuledbModel"


    // $ANTLR start "ruledbModel"
    // InternalDbTextEditor.g:62:1: ruledbModel : ( ( rule__DbModel__RecordsAssignment )* ) ;
    public final void ruledbModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:66:2: ( ( ( rule__DbModel__RecordsAssignment )* ) )
            // InternalDbTextEditor.g:67:2: ( ( rule__DbModel__RecordsAssignment )* )
            {
            // InternalDbTextEditor.g:67:2: ( ( rule__DbModel__RecordsAssignment )* )
            // InternalDbTextEditor.g:68:3: ( rule__DbModel__RecordsAssignment )*
            {
             before(grammarAccess.getDbModelAccess().getRecordsAssignment()); 
            // InternalDbTextEditor.g:69:3: ( rule__DbModel__RecordsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==133) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDbTextEditor.g:69:4: rule__DbModel__RecordsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__DbModel__RecordsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getDbModelAccess().getRecordsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruledbModel"


    // $ANTLR start "entryRuleRecord"
    // InternalDbTextEditor.g:78:1: entryRuleRecord : ruleRecord EOF ;
    public final void entryRuleRecord() throws RecognitionException {
        try {
            // InternalDbTextEditor.g:79:1: ( ruleRecord EOF )
            // InternalDbTextEditor.g:80:1: ruleRecord EOF
            {
             before(grammarAccess.getRecordRule()); 
            pushFollow(FOLLOW_1);
            ruleRecord();

            state._fsp--;

             after(grammarAccess.getRecordRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRecord"


    // $ANTLR start "ruleRecord"
    // InternalDbTextEditor.g:87:1: ruleRecord : ( ( rule__Record__Group__0 ) ) ;
    public final void ruleRecord() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:91:2: ( ( ( rule__Record__Group__0 ) ) )
            // InternalDbTextEditor.g:92:2: ( ( rule__Record__Group__0 ) )
            {
            // InternalDbTextEditor.g:92:2: ( ( rule__Record__Group__0 ) )
            // InternalDbTextEditor.g:93:3: ( rule__Record__Group__0 )
            {
             before(grammarAccess.getRecordAccess().getGroup()); 
            // InternalDbTextEditor.g:94:3: ( rule__Record__Group__0 )
            // InternalDbTextEditor.g:94:4: rule__Record__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Record__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRecordAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRecord"


    // $ANTLR start "entryRuleField"
    // InternalDbTextEditor.g:103:1: entryRuleField : ruleField EOF ;
    public final void entryRuleField() throws RecognitionException {
        try {
            // InternalDbTextEditor.g:104:1: ( ruleField EOF )
            // InternalDbTextEditor.g:105:1: ruleField EOF
            {
             before(grammarAccess.getFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleField();

            state._fsp--;

             after(grammarAccess.getFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // InternalDbTextEditor.g:112:1: ruleField : ( ( rule__Field__Group__0 ) ) ;
    public final void ruleField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:116:2: ( ( ( rule__Field__Group__0 ) ) )
            // InternalDbTextEditor.g:117:2: ( ( rule__Field__Group__0 ) )
            {
            // InternalDbTextEditor.g:117:2: ( ( rule__Field__Group__0 ) )
            // InternalDbTextEditor.g:118:3: ( rule__Field__Group__0 )
            {
             before(grammarAccess.getFieldAccess().getGroup()); 
            // InternalDbTextEditor.g:119:3: ( rule__Field__Group__0 )
            // InternalDbTextEditor.g:119:4: rule__Field__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Field__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFieldAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleInfo"
    // InternalDbTextEditor.g:128:1: entryRuleInfo : ruleInfo EOF ;
    public final void entryRuleInfo() throws RecognitionException {
        try {
            // InternalDbTextEditor.g:129:1: ( ruleInfo EOF )
            // InternalDbTextEditor.g:130:1: ruleInfo EOF
            {
             before(grammarAccess.getInfoRule()); 
            pushFollow(FOLLOW_1);
            ruleInfo();

            state._fsp--;

             after(grammarAccess.getInfoRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInfo"


    // $ANTLR start "ruleInfo"
    // InternalDbTextEditor.g:137:1: ruleInfo : ( ( rule__Info__Group__0 ) ) ;
    public final void ruleInfo() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:141:2: ( ( ( rule__Info__Group__0 ) ) )
            // InternalDbTextEditor.g:142:2: ( ( rule__Info__Group__0 ) )
            {
            // InternalDbTextEditor.g:142:2: ( ( rule__Info__Group__0 ) )
            // InternalDbTextEditor.g:143:3: ( rule__Info__Group__0 )
            {
             before(grammarAccess.getInfoAccess().getGroup()); 
            // InternalDbTextEditor.g:144:3: ( rule__Info__Group__0 )
            // InternalDbTextEditor.g:144:4: rule__Info__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Info__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInfoAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInfo"


    // $ANTLR start "entryRuleDOUBLE"
    // InternalDbTextEditor.g:153:1: entryRuleDOUBLE : ruleDOUBLE EOF ;
    public final void entryRuleDOUBLE() throws RecognitionException {
        try {
            // InternalDbTextEditor.g:154:1: ( ruleDOUBLE EOF )
            // InternalDbTextEditor.g:155:1: ruleDOUBLE EOF
            {
             before(grammarAccess.getDOUBLERule()); 
            pushFollow(FOLLOW_1);
            ruleDOUBLE();

            state._fsp--;

             after(grammarAccess.getDOUBLERule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDOUBLE"


    // $ANTLR start "ruleDOUBLE"
    // InternalDbTextEditor.g:162:1: ruleDOUBLE : ( ( rule__DOUBLE__Group__0 ) ) ;
    public final void ruleDOUBLE() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:166:2: ( ( ( rule__DOUBLE__Group__0 ) ) )
            // InternalDbTextEditor.g:167:2: ( ( rule__DOUBLE__Group__0 ) )
            {
            // InternalDbTextEditor.g:167:2: ( ( rule__DOUBLE__Group__0 ) )
            // InternalDbTextEditor.g:168:3: ( rule__DOUBLE__Group__0 )
            {
             before(grammarAccess.getDOUBLEAccess().getGroup()); 
            // InternalDbTextEditor.g:169:3: ( rule__DOUBLE__Group__0 )
            // InternalDbTextEditor.g:169:4: rule__DOUBLE__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DOUBLE__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDOUBLEAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDOUBLE"


    // $ANTLR start "ruleFieldnames"
    // InternalDbTextEditor.g:178:1: ruleFieldnames : ( ( rule__Fieldnames__Alternatives ) ) ;
    public final void ruleFieldnames() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:182:1: ( ( ( rule__Fieldnames__Alternatives ) ) )
            // InternalDbTextEditor.g:183:2: ( ( rule__Fieldnames__Alternatives ) )
            {
            // InternalDbTextEditor.g:183:2: ( ( rule__Fieldnames__Alternatives ) )
            // InternalDbTextEditor.g:184:3: ( rule__Fieldnames__Alternatives )
            {
             before(grammarAccess.getFieldnamesAccess().getAlternatives()); 
            // InternalDbTextEditor.g:185:3: ( rule__Fieldnames__Alternatives )
            // InternalDbTextEditor.g:185:4: rule__Fieldnames__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Fieldnames__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFieldnamesAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFieldnames"


    // $ANTLR start "ruleRecordnames"
    // InternalDbTextEditor.g:194:1: ruleRecordnames : ( ( rule__Recordnames__Alternatives ) ) ;
    public final void ruleRecordnames() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:198:1: ( ( ( rule__Recordnames__Alternatives ) ) )
            // InternalDbTextEditor.g:199:2: ( ( rule__Recordnames__Alternatives ) )
            {
            // InternalDbTextEditor.g:199:2: ( ( rule__Recordnames__Alternatives ) )
            // InternalDbTextEditor.g:200:3: ( rule__Recordnames__Alternatives )
            {
             before(grammarAccess.getRecordnamesAccess().getAlternatives()); 
            // InternalDbTextEditor.g:201:3: ( rule__Recordnames__Alternatives )
            // InternalDbTextEditor.g:201:4: rule__Recordnames__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Recordnames__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getRecordnamesAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRecordnames"


    // $ANTLR start "rule__Record__InfosfieldsAlternatives_7_0"
    // InternalDbTextEditor.g:209:1: rule__Record__InfosfieldsAlternatives_7_0 : ( ( ruleInfo ) | ( ruleField ) );
    public final void rule__Record__InfosfieldsAlternatives_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:213:1: ( ( ruleInfo ) | ( ruleField ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==131) ) {
                alt2=1;
            }
            else if ( (LA2_0==134) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalDbTextEditor.g:214:2: ( ruleInfo )
                    {
                    // InternalDbTextEditor.g:214:2: ( ruleInfo )
                    // InternalDbTextEditor.g:215:3: ruleInfo
                    {
                     before(grammarAccess.getRecordAccess().getInfosfieldsInfoParserRuleCall_7_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleInfo();

                    state._fsp--;

                     after(grammarAccess.getRecordAccess().getInfosfieldsInfoParserRuleCall_7_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDbTextEditor.g:220:2: ( ruleField )
                    {
                    // InternalDbTextEditor.g:220:2: ( ruleField )
                    // InternalDbTextEditor.g:221:3: ruleField
                    {
                     before(grammarAccess.getRecordAccess().getInfosfieldsFieldParserRuleCall_7_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleField();

                    state._fsp--;

                     after(grammarAccess.getRecordAccess().getInfosfieldsFieldParserRuleCall_7_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__InfosfieldsAlternatives_7_0"


    // $ANTLR start "rule__Field__Alternatives_4"
    // InternalDbTextEditor.g:230:1: rule__Field__Alternatives_4 : ( ( ( rule__Field__FieldstringAssignment_4_0 ) ) | ( ( rule__Field__FieldintAssignment_4_1 ) ) | ( ( rule__Field__FielddoubleAssignment_4_2 ) ) );
    public final void rule__Field__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:234:1: ( ( ( rule__Field__FieldstringAssignment_4_0 ) ) | ( ( rule__Field__FieldintAssignment_4_1 ) ) | ( ( rule__Field__FielddoubleAssignment_4_2 ) ) )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_INT) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==128) ) {
                    alt3=2;
                }
                else if ( (LA3_2==132) ) {
                    alt3=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalDbTextEditor.g:235:2: ( ( rule__Field__FieldstringAssignment_4_0 ) )
                    {
                    // InternalDbTextEditor.g:235:2: ( ( rule__Field__FieldstringAssignment_4_0 ) )
                    // InternalDbTextEditor.g:236:3: ( rule__Field__FieldstringAssignment_4_0 )
                    {
                     before(grammarAccess.getFieldAccess().getFieldstringAssignment_4_0()); 
                    // InternalDbTextEditor.g:237:3: ( rule__Field__FieldstringAssignment_4_0 )
                    // InternalDbTextEditor.g:237:4: rule__Field__FieldstringAssignment_4_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Field__FieldstringAssignment_4_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFieldAccess().getFieldstringAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDbTextEditor.g:241:2: ( ( rule__Field__FieldintAssignment_4_1 ) )
                    {
                    // InternalDbTextEditor.g:241:2: ( ( rule__Field__FieldintAssignment_4_1 ) )
                    // InternalDbTextEditor.g:242:3: ( rule__Field__FieldintAssignment_4_1 )
                    {
                     before(grammarAccess.getFieldAccess().getFieldintAssignment_4_1()); 
                    // InternalDbTextEditor.g:243:3: ( rule__Field__FieldintAssignment_4_1 )
                    // InternalDbTextEditor.g:243:4: rule__Field__FieldintAssignment_4_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Field__FieldintAssignment_4_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getFieldAccess().getFieldintAssignment_4_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDbTextEditor.g:247:2: ( ( rule__Field__FielddoubleAssignment_4_2 ) )
                    {
                    // InternalDbTextEditor.g:247:2: ( ( rule__Field__FielddoubleAssignment_4_2 ) )
                    // InternalDbTextEditor.g:248:3: ( rule__Field__FielddoubleAssignment_4_2 )
                    {
                     before(grammarAccess.getFieldAccess().getFielddoubleAssignment_4_2()); 
                    // InternalDbTextEditor.g:249:3: ( rule__Field__FielddoubleAssignment_4_2 )
                    // InternalDbTextEditor.g:249:4: rule__Field__FielddoubleAssignment_4_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Field__FielddoubleAssignment_4_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getFieldAccess().getFielddoubleAssignment_4_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Alternatives_4"


    // $ANTLR start "rule__Fieldnames__Alternatives"
    // InternalDbTextEditor.g:257:1: rule__Fieldnames__Alternatives : ( ( ( 'NAME' ) ) | ( ( 'DESC' ) ) | ( ( 'ASG' ) ) | ( ( 'SCAN' ) ) | ( ( 'PHAS' ) ) | ( ( 'PINI' ) ) | ( ( 'SDIS' ) ) | ( ( 'PROC' ) ) | ( ( 'PACT' ) ) | ( ( 'SEVR' ) ) | ( ( 'STAT' ) ) | ( ( 'TIME' ) ) | ( ( 'DTYP' ) ) | ( ( 'ONAM' ) ) | ( ( 'OSV' ) ) | ( ( 'OUT' ) ) | ( ( 'SIML' ) ) | ( ( 'ZNAM' ) ) | ( ( 'ZSV' ) ) | ( ( 'INP' ) ) | ( ( 'EGU' ) ) | ( ( 'LINR' ) ) | ( ( 'EGUL' ) ) | ( ( 'EGUF' ) ) | ( ( 'HIGH' ) ) | ( ( 'HSV' ) ) | ( ( 'HIHI' ) ) | ( ( 'HHSV' ) ) | ( ( 'EIST' ) ) | ( ( 'EISV' ) ) | ( ( 'EIVL' ) ) | ( ( 'ELST' ) ) | ( ( 'ELSV' ) ) | ( ( 'ELVL' ) ) | ( ( 'FRST' ) ) | ( ( 'FRSV' ) ) | ( ( 'FRVL' ) ) | ( ( 'FVST' ) ) | ( ( 'HYST' ) ) | ( ( 'LLSV' ) ) | ( ( 'FVSV' ) ) | ( ( 'FVVL' ) ) | ( ( 'MASK' ) ) | ( ( 'NIST' ) ) | ( ( 'NISV' ) ) | ( ( 'NIVL' ) ) | ( ( 'NOBT' ) ) | ( ( 'ONST' ) ) | ( ( 'ONSV' ) ) | ( ( 'ONVL' ) ) | ( ( 'SHFT' ) ) | ( ( 'SVST' ) ) | ( ( 'SVSV' ) ) | ( ( 'SVVL' ) ) | ( ( 'SXST' ) ) | ( ( 'SXSV' ) ) | ( ( 'SXVL' ) ) | ( ( 'TEST' ) ) | ( ( 'TESV' ) ) | ( ( 'TEVL' ) ) | ( ( 'THST' ) ) | ( ( 'THSV' ) ) | ( ( 'THVL' ) ) | ( ( 'TWST' ) ) | ( ( 'TWSV' ) ) | ( ( 'TWVL' ) ) | ( ( 'UNSV' ) ) | ( ( 'ZRST' ) ) | ( ( 'ZRSV' ) ) | ( ( 'ZRVL' ) ) | ( ( 'LOLO' ) ) | ( ( 'LOW' ) ) | ( ( 'LSV' ) ) | ( ( 'SSCN' ) ) | ( ( 'TSE' ) ) | ( ( 'PREC' ) ) | ( ( 'DRVH' ) ) | ( ( 'LOPR' ) ) | ( ( 'DRVL' ) ) | ( ( 'HOPR' ) ) | ( ( 'CALC' ) ) | ( ( 'INPA' ) ) | ( ( 'INPB' ) ) | ( ( 'INPC' ) ) | ( ( 'INPD' ) ) | ( ( 'FLNK' ) ) | ( ( 'INPE' ) ) | ( ( 'INPF' ) ) | ( ( 'INPG' ) ) | ( ( 'INPH' ) ) | ( ( 'INPI' ) ) | ( ( 'INPJ' ) ) | ( ( 'INPK' ) ) | ( ( 'INAA' ) ) | ( ( 'INBB' ) ) | ( ( 'INCC' ) ) | ( ( 'SIOL' ) ) );
    public final void rule__Fieldnames__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:261:1: ( ( ( 'NAME' ) ) | ( ( 'DESC' ) ) | ( ( 'ASG' ) ) | ( ( 'SCAN' ) ) | ( ( 'PHAS' ) ) | ( ( 'PINI' ) ) | ( ( 'SDIS' ) ) | ( ( 'PROC' ) ) | ( ( 'PACT' ) ) | ( ( 'SEVR' ) ) | ( ( 'STAT' ) ) | ( ( 'TIME' ) ) | ( ( 'DTYP' ) ) | ( ( 'ONAM' ) ) | ( ( 'OSV' ) ) | ( ( 'OUT' ) ) | ( ( 'SIML' ) ) | ( ( 'ZNAM' ) ) | ( ( 'ZSV' ) ) | ( ( 'INP' ) ) | ( ( 'EGU' ) ) | ( ( 'LINR' ) ) | ( ( 'EGUL' ) ) | ( ( 'EGUF' ) ) | ( ( 'HIGH' ) ) | ( ( 'HSV' ) ) | ( ( 'HIHI' ) ) | ( ( 'HHSV' ) ) | ( ( 'EIST' ) ) | ( ( 'EISV' ) ) | ( ( 'EIVL' ) ) | ( ( 'ELST' ) ) | ( ( 'ELSV' ) ) | ( ( 'ELVL' ) ) | ( ( 'FRST' ) ) | ( ( 'FRSV' ) ) | ( ( 'FRVL' ) ) | ( ( 'FVST' ) ) | ( ( 'HYST' ) ) | ( ( 'LLSV' ) ) | ( ( 'FVSV' ) ) | ( ( 'FVVL' ) ) | ( ( 'MASK' ) ) | ( ( 'NIST' ) ) | ( ( 'NISV' ) ) | ( ( 'NIVL' ) ) | ( ( 'NOBT' ) ) | ( ( 'ONST' ) ) | ( ( 'ONSV' ) ) | ( ( 'ONVL' ) ) | ( ( 'SHFT' ) ) | ( ( 'SVST' ) ) | ( ( 'SVSV' ) ) | ( ( 'SVVL' ) ) | ( ( 'SXST' ) ) | ( ( 'SXSV' ) ) | ( ( 'SXVL' ) ) | ( ( 'TEST' ) ) | ( ( 'TESV' ) ) | ( ( 'TEVL' ) ) | ( ( 'THST' ) ) | ( ( 'THSV' ) ) | ( ( 'THVL' ) ) | ( ( 'TWST' ) ) | ( ( 'TWSV' ) ) | ( ( 'TWVL' ) ) | ( ( 'UNSV' ) ) | ( ( 'ZRST' ) ) | ( ( 'ZRSV' ) ) | ( ( 'ZRVL' ) ) | ( ( 'LOLO' ) ) | ( ( 'LOW' ) ) | ( ( 'LSV' ) ) | ( ( 'SSCN' ) ) | ( ( 'TSE' ) ) | ( ( 'PREC' ) ) | ( ( 'DRVH' ) ) | ( ( 'LOPR' ) ) | ( ( 'DRVL' ) ) | ( ( 'HOPR' ) ) | ( ( 'CALC' ) ) | ( ( 'INPA' ) ) | ( ( 'INPB' ) ) | ( ( 'INPC' ) ) | ( ( 'INPD' ) ) | ( ( 'FLNK' ) ) | ( ( 'INPE' ) ) | ( ( 'INPF' ) ) | ( ( 'INPG' ) ) | ( ( 'INPH' ) ) | ( ( 'INPI' ) ) | ( ( 'INPJ' ) ) | ( ( 'INPK' ) ) | ( ( 'INAA' ) ) | ( ( 'INBB' ) ) | ( ( 'INCC' ) ) | ( ( 'SIOL' ) ) )
            int alt4=97;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt4=1;
                }
                break;
            case 12:
                {
                alt4=2;
                }
                break;
            case 13:
                {
                alt4=3;
                }
                break;
            case 14:
                {
                alt4=4;
                }
                break;
            case 15:
                {
                alt4=5;
                }
                break;
            case 16:
                {
                alt4=6;
                }
                break;
            case 17:
                {
                alt4=7;
                }
                break;
            case 18:
                {
                alt4=8;
                }
                break;
            case 19:
                {
                alt4=9;
                }
                break;
            case 20:
                {
                alt4=10;
                }
                break;
            case 21:
                {
                alt4=11;
                }
                break;
            case 22:
                {
                alt4=12;
                }
                break;
            case 23:
                {
                alt4=13;
                }
                break;
            case 24:
                {
                alt4=14;
                }
                break;
            case 25:
                {
                alt4=15;
                }
                break;
            case 26:
                {
                alt4=16;
                }
                break;
            case 27:
                {
                alt4=17;
                }
                break;
            case 28:
                {
                alt4=18;
                }
                break;
            case 29:
                {
                alt4=19;
                }
                break;
            case 30:
                {
                alt4=20;
                }
                break;
            case 31:
                {
                alt4=21;
                }
                break;
            case 32:
                {
                alt4=22;
                }
                break;
            case 33:
                {
                alt4=23;
                }
                break;
            case 34:
                {
                alt4=24;
                }
                break;
            case 35:
                {
                alt4=25;
                }
                break;
            case 36:
                {
                alt4=26;
                }
                break;
            case 37:
                {
                alt4=27;
                }
                break;
            case 38:
                {
                alt4=28;
                }
                break;
            case 39:
                {
                alt4=29;
                }
                break;
            case 40:
                {
                alt4=30;
                }
                break;
            case 41:
                {
                alt4=31;
                }
                break;
            case 42:
                {
                alt4=32;
                }
                break;
            case 43:
                {
                alt4=33;
                }
                break;
            case 44:
                {
                alt4=34;
                }
                break;
            case 45:
                {
                alt4=35;
                }
                break;
            case 46:
                {
                alt4=36;
                }
                break;
            case 47:
                {
                alt4=37;
                }
                break;
            case 48:
                {
                alt4=38;
                }
                break;
            case 49:
                {
                alt4=39;
                }
                break;
            case 50:
                {
                alt4=40;
                }
                break;
            case 51:
                {
                alt4=41;
                }
                break;
            case 52:
                {
                alt4=42;
                }
                break;
            case 53:
                {
                alt4=43;
                }
                break;
            case 54:
                {
                alt4=44;
                }
                break;
            case 55:
                {
                alt4=45;
                }
                break;
            case 56:
                {
                alt4=46;
                }
                break;
            case 57:
                {
                alt4=47;
                }
                break;
            case 58:
                {
                alt4=48;
                }
                break;
            case 59:
                {
                alt4=49;
                }
                break;
            case 60:
                {
                alt4=50;
                }
                break;
            case 61:
                {
                alt4=51;
                }
                break;
            case 62:
                {
                alt4=52;
                }
                break;
            case 63:
                {
                alt4=53;
                }
                break;
            case 64:
                {
                alt4=54;
                }
                break;
            case 65:
                {
                alt4=55;
                }
                break;
            case 66:
                {
                alt4=56;
                }
                break;
            case 67:
                {
                alt4=57;
                }
                break;
            case 68:
                {
                alt4=58;
                }
                break;
            case 69:
                {
                alt4=59;
                }
                break;
            case 70:
                {
                alt4=60;
                }
                break;
            case 71:
                {
                alt4=61;
                }
                break;
            case 72:
                {
                alt4=62;
                }
                break;
            case 73:
                {
                alt4=63;
                }
                break;
            case 74:
                {
                alt4=64;
                }
                break;
            case 75:
                {
                alt4=65;
                }
                break;
            case 76:
                {
                alt4=66;
                }
                break;
            case 77:
                {
                alt4=67;
                }
                break;
            case 78:
                {
                alt4=68;
                }
                break;
            case 79:
                {
                alt4=69;
                }
                break;
            case 80:
                {
                alt4=70;
                }
                break;
            case 81:
                {
                alt4=71;
                }
                break;
            case 82:
                {
                alt4=72;
                }
                break;
            case 83:
                {
                alt4=73;
                }
                break;
            case 84:
                {
                alt4=74;
                }
                break;
            case 85:
                {
                alt4=75;
                }
                break;
            case 86:
                {
                alt4=76;
                }
                break;
            case 87:
                {
                alt4=77;
                }
                break;
            case 88:
                {
                alt4=78;
                }
                break;
            case 89:
                {
                alt4=79;
                }
                break;
            case 90:
                {
                alt4=80;
                }
                break;
            case 91:
                {
                alt4=81;
                }
                break;
            case 92:
                {
                alt4=82;
                }
                break;
            case 93:
                {
                alt4=83;
                }
                break;
            case 94:
                {
                alt4=84;
                }
                break;
            case 95:
                {
                alt4=85;
                }
                break;
            case 96:
                {
                alt4=86;
                }
                break;
            case 97:
                {
                alt4=87;
                }
                break;
            case 98:
                {
                alt4=88;
                }
                break;
            case 99:
                {
                alt4=89;
                }
                break;
            case 100:
                {
                alt4=90;
                }
                break;
            case 101:
                {
                alt4=91;
                }
                break;
            case 102:
                {
                alt4=92;
                }
                break;
            case 103:
                {
                alt4=93;
                }
                break;
            case 104:
                {
                alt4=94;
                }
                break;
            case 105:
                {
                alt4=95;
                }
                break;
            case 106:
                {
                alt4=96;
                }
                break;
            case 107:
                {
                alt4=97;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalDbTextEditor.g:262:2: ( ( 'NAME' ) )
                    {
                    // InternalDbTextEditor.g:262:2: ( ( 'NAME' ) )
                    // InternalDbTextEditor.g:263:3: ( 'NAME' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getNAMEEnumLiteralDeclaration_0()); 
                    // InternalDbTextEditor.g:264:3: ( 'NAME' )
                    // InternalDbTextEditor.g:264:4: 'NAME'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getNAMEEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDbTextEditor.g:268:2: ( ( 'DESC' ) )
                    {
                    // InternalDbTextEditor.g:268:2: ( ( 'DESC' ) )
                    // InternalDbTextEditor.g:269:3: ( 'DESC' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getDESCEnumLiteralDeclaration_1()); 
                    // InternalDbTextEditor.g:270:3: ( 'DESC' )
                    // InternalDbTextEditor.g:270:4: 'DESC'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getDESCEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDbTextEditor.g:274:2: ( ( 'ASG' ) )
                    {
                    // InternalDbTextEditor.g:274:2: ( ( 'ASG' ) )
                    // InternalDbTextEditor.g:275:3: ( 'ASG' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getASGEnumLiteralDeclaration_2()); 
                    // InternalDbTextEditor.g:276:3: ( 'ASG' )
                    // InternalDbTextEditor.g:276:4: 'ASG'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getASGEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDbTextEditor.g:280:2: ( ( 'SCAN' ) )
                    {
                    // InternalDbTextEditor.g:280:2: ( ( 'SCAN' ) )
                    // InternalDbTextEditor.g:281:3: ( 'SCAN' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSCANEnumLiteralDeclaration_3()); 
                    // InternalDbTextEditor.g:282:3: ( 'SCAN' )
                    // InternalDbTextEditor.g:282:4: 'SCAN'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSCANEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDbTextEditor.g:286:2: ( ( 'PHAS' ) )
                    {
                    // InternalDbTextEditor.g:286:2: ( ( 'PHAS' ) )
                    // InternalDbTextEditor.g:287:3: ( 'PHAS' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getPHASEnumLiteralDeclaration_4()); 
                    // InternalDbTextEditor.g:288:3: ( 'PHAS' )
                    // InternalDbTextEditor.g:288:4: 'PHAS'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getPHASEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDbTextEditor.g:292:2: ( ( 'PINI' ) )
                    {
                    // InternalDbTextEditor.g:292:2: ( ( 'PINI' ) )
                    // InternalDbTextEditor.g:293:3: ( 'PINI' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getPINIEnumLiteralDeclaration_5()); 
                    // InternalDbTextEditor.g:294:3: ( 'PINI' )
                    // InternalDbTextEditor.g:294:4: 'PINI'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getPINIEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDbTextEditor.g:298:2: ( ( 'SDIS' ) )
                    {
                    // InternalDbTextEditor.g:298:2: ( ( 'SDIS' ) )
                    // InternalDbTextEditor.g:299:3: ( 'SDIS' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSDISEnumLiteralDeclaration_6()); 
                    // InternalDbTextEditor.g:300:3: ( 'SDIS' )
                    // InternalDbTextEditor.g:300:4: 'SDIS'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSDISEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDbTextEditor.g:304:2: ( ( 'PROC' ) )
                    {
                    // InternalDbTextEditor.g:304:2: ( ( 'PROC' ) )
                    // InternalDbTextEditor.g:305:3: ( 'PROC' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getPROCEnumLiteralDeclaration_7()); 
                    // InternalDbTextEditor.g:306:3: ( 'PROC' )
                    // InternalDbTextEditor.g:306:4: 'PROC'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getPROCEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDbTextEditor.g:310:2: ( ( 'PACT' ) )
                    {
                    // InternalDbTextEditor.g:310:2: ( ( 'PACT' ) )
                    // InternalDbTextEditor.g:311:3: ( 'PACT' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getPACTEnumLiteralDeclaration_8()); 
                    // InternalDbTextEditor.g:312:3: ( 'PACT' )
                    // InternalDbTextEditor.g:312:4: 'PACT'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getPACTEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDbTextEditor.g:316:2: ( ( 'SEVR' ) )
                    {
                    // InternalDbTextEditor.g:316:2: ( ( 'SEVR' ) )
                    // InternalDbTextEditor.g:317:3: ( 'SEVR' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSEVREnumLiteralDeclaration_9()); 
                    // InternalDbTextEditor.g:318:3: ( 'SEVR' )
                    // InternalDbTextEditor.g:318:4: 'SEVR'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSEVREnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalDbTextEditor.g:322:2: ( ( 'STAT' ) )
                    {
                    // InternalDbTextEditor.g:322:2: ( ( 'STAT' ) )
                    // InternalDbTextEditor.g:323:3: ( 'STAT' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSTATEnumLiteralDeclaration_10()); 
                    // InternalDbTextEditor.g:324:3: ( 'STAT' )
                    // InternalDbTextEditor.g:324:4: 'STAT'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSTATEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalDbTextEditor.g:328:2: ( ( 'TIME' ) )
                    {
                    // InternalDbTextEditor.g:328:2: ( ( 'TIME' ) )
                    // InternalDbTextEditor.g:329:3: ( 'TIME' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getTIMEEnumLiteralDeclaration_11()); 
                    // InternalDbTextEditor.g:330:3: ( 'TIME' )
                    // InternalDbTextEditor.g:330:4: 'TIME'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getTIMEEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalDbTextEditor.g:334:2: ( ( 'DTYP' ) )
                    {
                    // InternalDbTextEditor.g:334:2: ( ( 'DTYP' ) )
                    // InternalDbTextEditor.g:335:3: ( 'DTYP' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getDTYPEnumLiteralDeclaration_12()); 
                    // InternalDbTextEditor.g:336:3: ( 'DTYP' )
                    // InternalDbTextEditor.g:336:4: 'DTYP'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getDTYPEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalDbTextEditor.g:340:2: ( ( 'ONAM' ) )
                    {
                    // InternalDbTextEditor.g:340:2: ( ( 'ONAM' ) )
                    // InternalDbTextEditor.g:341:3: ( 'ONAM' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getONAMEnumLiteralDeclaration_13()); 
                    // InternalDbTextEditor.g:342:3: ( 'ONAM' )
                    // InternalDbTextEditor.g:342:4: 'ONAM'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getONAMEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalDbTextEditor.g:346:2: ( ( 'OSV' ) )
                    {
                    // InternalDbTextEditor.g:346:2: ( ( 'OSV' ) )
                    // InternalDbTextEditor.g:347:3: ( 'OSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getOSVEnumLiteralDeclaration_14()); 
                    // InternalDbTextEditor.g:348:3: ( 'OSV' )
                    // InternalDbTextEditor.g:348:4: 'OSV'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getOSVEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalDbTextEditor.g:352:2: ( ( 'OUT' ) )
                    {
                    // InternalDbTextEditor.g:352:2: ( ( 'OUT' ) )
                    // InternalDbTextEditor.g:353:3: ( 'OUT' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getOUTEnumLiteralDeclaration_15()); 
                    // InternalDbTextEditor.g:354:3: ( 'OUT' )
                    // InternalDbTextEditor.g:354:4: 'OUT'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getOUTEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalDbTextEditor.g:358:2: ( ( 'SIML' ) )
                    {
                    // InternalDbTextEditor.g:358:2: ( ( 'SIML' ) )
                    // InternalDbTextEditor.g:359:3: ( 'SIML' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSIMLEnumLiteralDeclaration_16()); 
                    // InternalDbTextEditor.g:360:3: ( 'SIML' )
                    // InternalDbTextEditor.g:360:4: 'SIML'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSIMLEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalDbTextEditor.g:364:2: ( ( 'ZNAM' ) )
                    {
                    // InternalDbTextEditor.g:364:2: ( ( 'ZNAM' ) )
                    // InternalDbTextEditor.g:365:3: ( 'ZNAM' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getZNAMEnumLiteralDeclaration_17()); 
                    // InternalDbTextEditor.g:366:3: ( 'ZNAM' )
                    // InternalDbTextEditor.g:366:4: 'ZNAM'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getZNAMEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalDbTextEditor.g:370:2: ( ( 'ZSV' ) )
                    {
                    // InternalDbTextEditor.g:370:2: ( ( 'ZSV' ) )
                    // InternalDbTextEditor.g:371:3: ( 'ZSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getZSVEnumLiteralDeclaration_18()); 
                    // InternalDbTextEditor.g:372:3: ( 'ZSV' )
                    // InternalDbTextEditor.g:372:4: 'ZSV'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getZSVEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalDbTextEditor.g:376:2: ( ( 'INP' ) )
                    {
                    // InternalDbTextEditor.g:376:2: ( ( 'INP' ) )
                    // InternalDbTextEditor.g:377:3: ( 'INP' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPEnumLiteralDeclaration_19()); 
                    // InternalDbTextEditor.g:378:3: ( 'INP' )
                    // InternalDbTextEditor.g:378:4: 'INP'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPEnumLiteralDeclaration_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalDbTextEditor.g:382:2: ( ( 'EGU' ) )
                    {
                    // InternalDbTextEditor.g:382:2: ( ( 'EGU' ) )
                    // InternalDbTextEditor.g:383:3: ( 'EGU' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getEGUEnumLiteralDeclaration_20()); 
                    // InternalDbTextEditor.g:384:3: ( 'EGU' )
                    // InternalDbTextEditor.g:384:4: 'EGU'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getEGUEnumLiteralDeclaration_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalDbTextEditor.g:388:2: ( ( 'LINR' ) )
                    {
                    // InternalDbTextEditor.g:388:2: ( ( 'LINR' ) )
                    // InternalDbTextEditor.g:389:3: ( 'LINR' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLINREnumLiteralDeclaration_21()); 
                    // InternalDbTextEditor.g:390:3: ( 'LINR' )
                    // InternalDbTextEditor.g:390:4: 'LINR'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLINREnumLiteralDeclaration_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalDbTextEditor.g:394:2: ( ( 'EGUL' ) )
                    {
                    // InternalDbTextEditor.g:394:2: ( ( 'EGUL' ) )
                    // InternalDbTextEditor.g:395:3: ( 'EGUL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getEGULEnumLiteralDeclaration_22()); 
                    // InternalDbTextEditor.g:396:3: ( 'EGUL' )
                    // InternalDbTextEditor.g:396:4: 'EGUL'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getEGULEnumLiteralDeclaration_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalDbTextEditor.g:400:2: ( ( 'EGUF' ) )
                    {
                    // InternalDbTextEditor.g:400:2: ( ( 'EGUF' ) )
                    // InternalDbTextEditor.g:401:3: ( 'EGUF' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getEGUFEnumLiteralDeclaration_23()); 
                    // InternalDbTextEditor.g:402:3: ( 'EGUF' )
                    // InternalDbTextEditor.g:402:4: 'EGUF'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getEGUFEnumLiteralDeclaration_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalDbTextEditor.g:406:2: ( ( 'HIGH' ) )
                    {
                    // InternalDbTextEditor.g:406:2: ( ( 'HIGH' ) )
                    // InternalDbTextEditor.g:407:3: ( 'HIGH' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getHIGHEnumLiteralDeclaration_24()); 
                    // InternalDbTextEditor.g:408:3: ( 'HIGH' )
                    // InternalDbTextEditor.g:408:4: 'HIGH'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getHIGHEnumLiteralDeclaration_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalDbTextEditor.g:412:2: ( ( 'HSV' ) )
                    {
                    // InternalDbTextEditor.g:412:2: ( ( 'HSV' ) )
                    // InternalDbTextEditor.g:413:3: ( 'HSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getHSVEnumLiteralDeclaration_25()); 
                    // InternalDbTextEditor.g:414:3: ( 'HSV' )
                    // InternalDbTextEditor.g:414:4: 'HSV'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getHSVEnumLiteralDeclaration_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalDbTextEditor.g:418:2: ( ( 'HIHI' ) )
                    {
                    // InternalDbTextEditor.g:418:2: ( ( 'HIHI' ) )
                    // InternalDbTextEditor.g:419:3: ( 'HIHI' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getHIHIEnumLiteralDeclaration_26()); 
                    // InternalDbTextEditor.g:420:3: ( 'HIHI' )
                    // InternalDbTextEditor.g:420:4: 'HIHI'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getHIHIEnumLiteralDeclaration_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalDbTextEditor.g:424:2: ( ( 'HHSV' ) )
                    {
                    // InternalDbTextEditor.g:424:2: ( ( 'HHSV' ) )
                    // InternalDbTextEditor.g:425:3: ( 'HHSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getHHSVEnumLiteralDeclaration_27()); 
                    // InternalDbTextEditor.g:426:3: ( 'HHSV' )
                    // InternalDbTextEditor.g:426:4: 'HHSV'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getHHSVEnumLiteralDeclaration_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalDbTextEditor.g:430:2: ( ( 'EIST' ) )
                    {
                    // InternalDbTextEditor.g:430:2: ( ( 'EIST' ) )
                    // InternalDbTextEditor.g:431:3: ( 'EIST' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getEISTEnumLiteralDeclaration_28()); 
                    // InternalDbTextEditor.g:432:3: ( 'EIST' )
                    // InternalDbTextEditor.g:432:4: 'EIST'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getEISTEnumLiteralDeclaration_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalDbTextEditor.g:436:2: ( ( 'EISV' ) )
                    {
                    // InternalDbTextEditor.g:436:2: ( ( 'EISV' ) )
                    // InternalDbTextEditor.g:437:3: ( 'EISV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getEISVEnumLiteralDeclaration_29()); 
                    // InternalDbTextEditor.g:438:3: ( 'EISV' )
                    // InternalDbTextEditor.g:438:4: 'EISV'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getEISVEnumLiteralDeclaration_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalDbTextEditor.g:442:2: ( ( 'EIVL' ) )
                    {
                    // InternalDbTextEditor.g:442:2: ( ( 'EIVL' ) )
                    // InternalDbTextEditor.g:443:3: ( 'EIVL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getEIVLEnumLiteralDeclaration_30()); 
                    // InternalDbTextEditor.g:444:3: ( 'EIVL' )
                    // InternalDbTextEditor.g:444:4: 'EIVL'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getEIVLEnumLiteralDeclaration_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalDbTextEditor.g:448:2: ( ( 'ELST' ) )
                    {
                    // InternalDbTextEditor.g:448:2: ( ( 'ELST' ) )
                    // InternalDbTextEditor.g:449:3: ( 'ELST' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getELSTEnumLiteralDeclaration_31()); 
                    // InternalDbTextEditor.g:450:3: ( 'ELST' )
                    // InternalDbTextEditor.g:450:4: 'ELST'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getELSTEnumLiteralDeclaration_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalDbTextEditor.g:454:2: ( ( 'ELSV' ) )
                    {
                    // InternalDbTextEditor.g:454:2: ( ( 'ELSV' ) )
                    // InternalDbTextEditor.g:455:3: ( 'ELSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getELSVEnumLiteralDeclaration_32()); 
                    // InternalDbTextEditor.g:456:3: ( 'ELSV' )
                    // InternalDbTextEditor.g:456:4: 'ELSV'
                    {
                    match(input,43,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getELSVEnumLiteralDeclaration_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalDbTextEditor.g:460:2: ( ( 'ELVL' ) )
                    {
                    // InternalDbTextEditor.g:460:2: ( ( 'ELVL' ) )
                    // InternalDbTextEditor.g:461:3: ( 'ELVL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getELVLEnumLiteralDeclaration_33()); 
                    // InternalDbTextEditor.g:462:3: ( 'ELVL' )
                    // InternalDbTextEditor.g:462:4: 'ELVL'
                    {
                    match(input,44,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getELVLEnumLiteralDeclaration_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalDbTextEditor.g:466:2: ( ( 'FRST' ) )
                    {
                    // InternalDbTextEditor.g:466:2: ( ( 'FRST' ) )
                    // InternalDbTextEditor.g:467:3: ( 'FRST' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getFRSTEnumLiteralDeclaration_34()); 
                    // InternalDbTextEditor.g:468:3: ( 'FRST' )
                    // InternalDbTextEditor.g:468:4: 'FRST'
                    {
                    match(input,45,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getFRSTEnumLiteralDeclaration_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalDbTextEditor.g:472:2: ( ( 'FRSV' ) )
                    {
                    // InternalDbTextEditor.g:472:2: ( ( 'FRSV' ) )
                    // InternalDbTextEditor.g:473:3: ( 'FRSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getFRSVEnumLiteralDeclaration_35()); 
                    // InternalDbTextEditor.g:474:3: ( 'FRSV' )
                    // InternalDbTextEditor.g:474:4: 'FRSV'
                    {
                    match(input,46,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getFRSVEnumLiteralDeclaration_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalDbTextEditor.g:478:2: ( ( 'FRVL' ) )
                    {
                    // InternalDbTextEditor.g:478:2: ( ( 'FRVL' ) )
                    // InternalDbTextEditor.g:479:3: ( 'FRVL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getFRVLEnumLiteralDeclaration_36()); 
                    // InternalDbTextEditor.g:480:3: ( 'FRVL' )
                    // InternalDbTextEditor.g:480:4: 'FRVL'
                    {
                    match(input,47,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getFRVLEnumLiteralDeclaration_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalDbTextEditor.g:484:2: ( ( 'FVST' ) )
                    {
                    // InternalDbTextEditor.g:484:2: ( ( 'FVST' ) )
                    // InternalDbTextEditor.g:485:3: ( 'FVST' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getFVSTEnumLiteralDeclaration_37()); 
                    // InternalDbTextEditor.g:486:3: ( 'FVST' )
                    // InternalDbTextEditor.g:486:4: 'FVST'
                    {
                    match(input,48,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getFVSTEnumLiteralDeclaration_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalDbTextEditor.g:490:2: ( ( 'HYST' ) )
                    {
                    // InternalDbTextEditor.g:490:2: ( ( 'HYST' ) )
                    // InternalDbTextEditor.g:491:3: ( 'HYST' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getHYSTEnumLiteralDeclaration_38()); 
                    // InternalDbTextEditor.g:492:3: ( 'HYST' )
                    // InternalDbTextEditor.g:492:4: 'HYST'
                    {
                    match(input,49,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getHYSTEnumLiteralDeclaration_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalDbTextEditor.g:496:2: ( ( 'LLSV' ) )
                    {
                    // InternalDbTextEditor.g:496:2: ( ( 'LLSV' ) )
                    // InternalDbTextEditor.g:497:3: ( 'LLSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLLSVEnumLiteralDeclaration_39()); 
                    // InternalDbTextEditor.g:498:3: ( 'LLSV' )
                    // InternalDbTextEditor.g:498:4: 'LLSV'
                    {
                    match(input,50,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLLSVEnumLiteralDeclaration_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalDbTextEditor.g:502:2: ( ( 'FVSV' ) )
                    {
                    // InternalDbTextEditor.g:502:2: ( ( 'FVSV' ) )
                    // InternalDbTextEditor.g:503:3: ( 'FVSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getFVSVEnumLiteralDeclaration_40()); 
                    // InternalDbTextEditor.g:504:3: ( 'FVSV' )
                    // InternalDbTextEditor.g:504:4: 'FVSV'
                    {
                    match(input,51,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getFVSVEnumLiteralDeclaration_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalDbTextEditor.g:508:2: ( ( 'FVVL' ) )
                    {
                    // InternalDbTextEditor.g:508:2: ( ( 'FVVL' ) )
                    // InternalDbTextEditor.g:509:3: ( 'FVVL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getFVVLEnumLiteralDeclaration_41()); 
                    // InternalDbTextEditor.g:510:3: ( 'FVVL' )
                    // InternalDbTextEditor.g:510:4: 'FVVL'
                    {
                    match(input,52,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getFVVLEnumLiteralDeclaration_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalDbTextEditor.g:514:2: ( ( 'MASK' ) )
                    {
                    // InternalDbTextEditor.g:514:2: ( ( 'MASK' ) )
                    // InternalDbTextEditor.g:515:3: ( 'MASK' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getMASKEnumLiteralDeclaration_42()); 
                    // InternalDbTextEditor.g:516:3: ( 'MASK' )
                    // InternalDbTextEditor.g:516:4: 'MASK'
                    {
                    match(input,53,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getMASKEnumLiteralDeclaration_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalDbTextEditor.g:520:2: ( ( 'NIST' ) )
                    {
                    // InternalDbTextEditor.g:520:2: ( ( 'NIST' ) )
                    // InternalDbTextEditor.g:521:3: ( 'NIST' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getNISTEnumLiteralDeclaration_43()); 
                    // InternalDbTextEditor.g:522:3: ( 'NIST' )
                    // InternalDbTextEditor.g:522:4: 'NIST'
                    {
                    match(input,54,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getNISTEnumLiteralDeclaration_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalDbTextEditor.g:526:2: ( ( 'NISV' ) )
                    {
                    // InternalDbTextEditor.g:526:2: ( ( 'NISV' ) )
                    // InternalDbTextEditor.g:527:3: ( 'NISV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getNISVEnumLiteralDeclaration_44()); 
                    // InternalDbTextEditor.g:528:3: ( 'NISV' )
                    // InternalDbTextEditor.g:528:4: 'NISV'
                    {
                    match(input,55,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getNISVEnumLiteralDeclaration_44()); 

                    }


                    }
                    break;
                case 46 :
                    // InternalDbTextEditor.g:532:2: ( ( 'NIVL' ) )
                    {
                    // InternalDbTextEditor.g:532:2: ( ( 'NIVL' ) )
                    // InternalDbTextEditor.g:533:3: ( 'NIVL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getNIVLEnumLiteralDeclaration_45()); 
                    // InternalDbTextEditor.g:534:3: ( 'NIVL' )
                    // InternalDbTextEditor.g:534:4: 'NIVL'
                    {
                    match(input,56,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getNIVLEnumLiteralDeclaration_45()); 

                    }


                    }
                    break;
                case 47 :
                    // InternalDbTextEditor.g:538:2: ( ( 'NOBT' ) )
                    {
                    // InternalDbTextEditor.g:538:2: ( ( 'NOBT' ) )
                    // InternalDbTextEditor.g:539:3: ( 'NOBT' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getNOBTEnumLiteralDeclaration_46()); 
                    // InternalDbTextEditor.g:540:3: ( 'NOBT' )
                    // InternalDbTextEditor.g:540:4: 'NOBT'
                    {
                    match(input,57,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getNOBTEnumLiteralDeclaration_46()); 

                    }


                    }
                    break;
                case 48 :
                    // InternalDbTextEditor.g:544:2: ( ( 'ONST' ) )
                    {
                    // InternalDbTextEditor.g:544:2: ( ( 'ONST' ) )
                    // InternalDbTextEditor.g:545:3: ( 'ONST' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getONSTEnumLiteralDeclaration_47()); 
                    // InternalDbTextEditor.g:546:3: ( 'ONST' )
                    // InternalDbTextEditor.g:546:4: 'ONST'
                    {
                    match(input,58,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getONSTEnumLiteralDeclaration_47()); 

                    }


                    }
                    break;
                case 49 :
                    // InternalDbTextEditor.g:550:2: ( ( 'ONSV' ) )
                    {
                    // InternalDbTextEditor.g:550:2: ( ( 'ONSV' ) )
                    // InternalDbTextEditor.g:551:3: ( 'ONSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getONSVEnumLiteralDeclaration_48()); 
                    // InternalDbTextEditor.g:552:3: ( 'ONSV' )
                    // InternalDbTextEditor.g:552:4: 'ONSV'
                    {
                    match(input,59,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getONSVEnumLiteralDeclaration_48()); 

                    }


                    }
                    break;
                case 50 :
                    // InternalDbTextEditor.g:556:2: ( ( 'ONVL' ) )
                    {
                    // InternalDbTextEditor.g:556:2: ( ( 'ONVL' ) )
                    // InternalDbTextEditor.g:557:3: ( 'ONVL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getONVLEnumLiteralDeclaration_49()); 
                    // InternalDbTextEditor.g:558:3: ( 'ONVL' )
                    // InternalDbTextEditor.g:558:4: 'ONVL'
                    {
                    match(input,60,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getONVLEnumLiteralDeclaration_49()); 

                    }


                    }
                    break;
                case 51 :
                    // InternalDbTextEditor.g:562:2: ( ( 'SHFT' ) )
                    {
                    // InternalDbTextEditor.g:562:2: ( ( 'SHFT' ) )
                    // InternalDbTextEditor.g:563:3: ( 'SHFT' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSHFTEnumLiteralDeclaration_50()); 
                    // InternalDbTextEditor.g:564:3: ( 'SHFT' )
                    // InternalDbTextEditor.g:564:4: 'SHFT'
                    {
                    match(input,61,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSHFTEnumLiteralDeclaration_50()); 

                    }


                    }
                    break;
                case 52 :
                    // InternalDbTextEditor.g:568:2: ( ( 'SVST' ) )
                    {
                    // InternalDbTextEditor.g:568:2: ( ( 'SVST' ) )
                    // InternalDbTextEditor.g:569:3: ( 'SVST' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSVSTEnumLiteralDeclaration_51()); 
                    // InternalDbTextEditor.g:570:3: ( 'SVST' )
                    // InternalDbTextEditor.g:570:4: 'SVST'
                    {
                    match(input,62,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSVSTEnumLiteralDeclaration_51()); 

                    }


                    }
                    break;
                case 53 :
                    // InternalDbTextEditor.g:574:2: ( ( 'SVSV' ) )
                    {
                    // InternalDbTextEditor.g:574:2: ( ( 'SVSV' ) )
                    // InternalDbTextEditor.g:575:3: ( 'SVSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSVSVEnumLiteralDeclaration_52()); 
                    // InternalDbTextEditor.g:576:3: ( 'SVSV' )
                    // InternalDbTextEditor.g:576:4: 'SVSV'
                    {
                    match(input,63,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSVSVEnumLiteralDeclaration_52()); 

                    }


                    }
                    break;
                case 54 :
                    // InternalDbTextEditor.g:580:2: ( ( 'SVVL' ) )
                    {
                    // InternalDbTextEditor.g:580:2: ( ( 'SVVL' ) )
                    // InternalDbTextEditor.g:581:3: ( 'SVVL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSVVLEnumLiteralDeclaration_53()); 
                    // InternalDbTextEditor.g:582:3: ( 'SVVL' )
                    // InternalDbTextEditor.g:582:4: 'SVVL'
                    {
                    match(input,64,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSVVLEnumLiteralDeclaration_53()); 

                    }


                    }
                    break;
                case 55 :
                    // InternalDbTextEditor.g:586:2: ( ( 'SXST' ) )
                    {
                    // InternalDbTextEditor.g:586:2: ( ( 'SXST' ) )
                    // InternalDbTextEditor.g:587:3: ( 'SXST' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSXSTEnumLiteralDeclaration_54()); 
                    // InternalDbTextEditor.g:588:3: ( 'SXST' )
                    // InternalDbTextEditor.g:588:4: 'SXST'
                    {
                    match(input,65,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSXSTEnumLiteralDeclaration_54()); 

                    }


                    }
                    break;
                case 56 :
                    // InternalDbTextEditor.g:592:2: ( ( 'SXSV' ) )
                    {
                    // InternalDbTextEditor.g:592:2: ( ( 'SXSV' ) )
                    // InternalDbTextEditor.g:593:3: ( 'SXSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSXSVEnumLiteralDeclaration_55()); 
                    // InternalDbTextEditor.g:594:3: ( 'SXSV' )
                    // InternalDbTextEditor.g:594:4: 'SXSV'
                    {
                    match(input,66,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSXSVEnumLiteralDeclaration_55()); 

                    }


                    }
                    break;
                case 57 :
                    // InternalDbTextEditor.g:598:2: ( ( 'SXVL' ) )
                    {
                    // InternalDbTextEditor.g:598:2: ( ( 'SXVL' ) )
                    // InternalDbTextEditor.g:599:3: ( 'SXVL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSXVLEnumLiteralDeclaration_56()); 
                    // InternalDbTextEditor.g:600:3: ( 'SXVL' )
                    // InternalDbTextEditor.g:600:4: 'SXVL'
                    {
                    match(input,67,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSXVLEnumLiteralDeclaration_56()); 

                    }


                    }
                    break;
                case 58 :
                    // InternalDbTextEditor.g:604:2: ( ( 'TEST' ) )
                    {
                    // InternalDbTextEditor.g:604:2: ( ( 'TEST' ) )
                    // InternalDbTextEditor.g:605:3: ( 'TEST' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getTESTEnumLiteralDeclaration_57()); 
                    // InternalDbTextEditor.g:606:3: ( 'TEST' )
                    // InternalDbTextEditor.g:606:4: 'TEST'
                    {
                    match(input,68,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getTESTEnumLiteralDeclaration_57()); 

                    }


                    }
                    break;
                case 59 :
                    // InternalDbTextEditor.g:610:2: ( ( 'TESV' ) )
                    {
                    // InternalDbTextEditor.g:610:2: ( ( 'TESV' ) )
                    // InternalDbTextEditor.g:611:3: ( 'TESV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getTESVEnumLiteralDeclaration_58()); 
                    // InternalDbTextEditor.g:612:3: ( 'TESV' )
                    // InternalDbTextEditor.g:612:4: 'TESV'
                    {
                    match(input,69,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getTESVEnumLiteralDeclaration_58()); 

                    }


                    }
                    break;
                case 60 :
                    // InternalDbTextEditor.g:616:2: ( ( 'TEVL' ) )
                    {
                    // InternalDbTextEditor.g:616:2: ( ( 'TEVL' ) )
                    // InternalDbTextEditor.g:617:3: ( 'TEVL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getTEVLEnumLiteralDeclaration_59()); 
                    // InternalDbTextEditor.g:618:3: ( 'TEVL' )
                    // InternalDbTextEditor.g:618:4: 'TEVL'
                    {
                    match(input,70,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getTEVLEnumLiteralDeclaration_59()); 

                    }


                    }
                    break;
                case 61 :
                    // InternalDbTextEditor.g:622:2: ( ( 'THST' ) )
                    {
                    // InternalDbTextEditor.g:622:2: ( ( 'THST' ) )
                    // InternalDbTextEditor.g:623:3: ( 'THST' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getTHSTEnumLiteralDeclaration_60()); 
                    // InternalDbTextEditor.g:624:3: ( 'THST' )
                    // InternalDbTextEditor.g:624:4: 'THST'
                    {
                    match(input,71,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getTHSTEnumLiteralDeclaration_60()); 

                    }


                    }
                    break;
                case 62 :
                    // InternalDbTextEditor.g:628:2: ( ( 'THSV' ) )
                    {
                    // InternalDbTextEditor.g:628:2: ( ( 'THSV' ) )
                    // InternalDbTextEditor.g:629:3: ( 'THSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getTHSVEnumLiteralDeclaration_61()); 
                    // InternalDbTextEditor.g:630:3: ( 'THSV' )
                    // InternalDbTextEditor.g:630:4: 'THSV'
                    {
                    match(input,72,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getTHSVEnumLiteralDeclaration_61()); 

                    }


                    }
                    break;
                case 63 :
                    // InternalDbTextEditor.g:634:2: ( ( 'THVL' ) )
                    {
                    // InternalDbTextEditor.g:634:2: ( ( 'THVL' ) )
                    // InternalDbTextEditor.g:635:3: ( 'THVL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getTHVLEnumLiteralDeclaration_62()); 
                    // InternalDbTextEditor.g:636:3: ( 'THVL' )
                    // InternalDbTextEditor.g:636:4: 'THVL'
                    {
                    match(input,73,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getTHVLEnumLiteralDeclaration_62()); 

                    }


                    }
                    break;
                case 64 :
                    // InternalDbTextEditor.g:640:2: ( ( 'TWST' ) )
                    {
                    // InternalDbTextEditor.g:640:2: ( ( 'TWST' ) )
                    // InternalDbTextEditor.g:641:3: ( 'TWST' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getTWSTEnumLiteralDeclaration_63()); 
                    // InternalDbTextEditor.g:642:3: ( 'TWST' )
                    // InternalDbTextEditor.g:642:4: 'TWST'
                    {
                    match(input,74,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getTWSTEnumLiteralDeclaration_63()); 

                    }


                    }
                    break;
                case 65 :
                    // InternalDbTextEditor.g:646:2: ( ( 'TWSV' ) )
                    {
                    // InternalDbTextEditor.g:646:2: ( ( 'TWSV' ) )
                    // InternalDbTextEditor.g:647:3: ( 'TWSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getTWSVEnumLiteralDeclaration_64()); 
                    // InternalDbTextEditor.g:648:3: ( 'TWSV' )
                    // InternalDbTextEditor.g:648:4: 'TWSV'
                    {
                    match(input,75,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getTWSVEnumLiteralDeclaration_64()); 

                    }


                    }
                    break;
                case 66 :
                    // InternalDbTextEditor.g:652:2: ( ( 'TWVL' ) )
                    {
                    // InternalDbTextEditor.g:652:2: ( ( 'TWVL' ) )
                    // InternalDbTextEditor.g:653:3: ( 'TWVL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getTWVLEnumLiteralDeclaration_65()); 
                    // InternalDbTextEditor.g:654:3: ( 'TWVL' )
                    // InternalDbTextEditor.g:654:4: 'TWVL'
                    {
                    match(input,76,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getTWVLEnumLiteralDeclaration_65()); 

                    }


                    }
                    break;
                case 67 :
                    // InternalDbTextEditor.g:658:2: ( ( 'UNSV' ) )
                    {
                    // InternalDbTextEditor.g:658:2: ( ( 'UNSV' ) )
                    // InternalDbTextEditor.g:659:3: ( 'UNSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getUNSVEnumLiteralDeclaration_66()); 
                    // InternalDbTextEditor.g:660:3: ( 'UNSV' )
                    // InternalDbTextEditor.g:660:4: 'UNSV'
                    {
                    match(input,77,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getUNSVEnumLiteralDeclaration_66()); 

                    }


                    }
                    break;
                case 68 :
                    // InternalDbTextEditor.g:664:2: ( ( 'ZRST' ) )
                    {
                    // InternalDbTextEditor.g:664:2: ( ( 'ZRST' ) )
                    // InternalDbTextEditor.g:665:3: ( 'ZRST' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getZRSTEnumLiteralDeclaration_67()); 
                    // InternalDbTextEditor.g:666:3: ( 'ZRST' )
                    // InternalDbTextEditor.g:666:4: 'ZRST'
                    {
                    match(input,78,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getZRSTEnumLiteralDeclaration_67()); 

                    }


                    }
                    break;
                case 69 :
                    // InternalDbTextEditor.g:670:2: ( ( 'ZRSV' ) )
                    {
                    // InternalDbTextEditor.g:670:2: ( ( 'ZRSV' ) )
                    // InternalDbTextEditor.g:671:3: ( 'ZRSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getZRSVEnumLiteralDeclaration_68()); 
                    // InternalDbTextEditor.g:672:3: ( 'ZRSV' )
                    // InternalDbTextEditor.g:672:4: 'ZRSV'
                    {
                    match(input,79,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getZRSVEnumLiteralDeclaration_68()); 

                    }


                    }
                    break;
                case 70 :
                    // InternalDbTextEditor.g:676:2: ( ( 'ZRVL' ) )
                    {
                    // InternalDbTextEditor.g:676:2: ( ( 'ZRVL' ) )
                    // InternalDbTextEditor.g:677:3: ( 'ZRVL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getZRVLEnumLiteralDeclaration_69()); 
                    // InternalDbTextEditor.g:678:3: ( 'ZRVL' )
                    // InternalDbTextEditor.g:678:4: 'ZRVL'
                    {
                    match(input,80,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getZRVLEnumLiteralDeclaration_69()); 

                    }


                    }
                    break;
                case 71 :
                    // InternalDbTextEditor.g:682:2: ( ( 'LOLO' ) )
                    {
                    // InternalDbTextEditor.g:682:2: ( ( 'LOLO' ) )
                    // InternalDbTextEditor.g:683:3: ( 'LOLO' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLOLOEnumLiteralDeclaration_70()); 
                    // InternalDbTextEditor.g:684:3: ( 'LOLO' )
                    // InternalDbTextEditor.g:684:4: 'LOLO'
                    {
                    match(input,81,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLOLOEnumLiteralDeclaration_70()); 

                    }


                    }
                    break;
                case 72 :
                    // InternalDbTextEditor.g:688:2: ( ( 'LOW' ) )
                    {
                    // InternalDbTextEditor.g:688:2: ( ( 'LOW' ) )
                    // InternalDbTextEditor.g:689:3: ( 'LOW' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLOWEnumLiteralDeclaration_71()); 
                    // InternalDbTextEditor.g:690:3: ( 'LOW' )
                    // InternalDbTextEditor.g:690:4: 'LOW'
                    {
                    match(input,82,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLOWEnumLiteralDeclaration_71()); 

                    }


                    }
                    break;
                case 73 :
                    // InternalDbTextEditor.g:694:2: ( ( 'LSV' ) )
                    {
                    // InternalDbTextEditor.g:694:2: ( ( 'LSV' ) )
                    // InternalDbTextEditor.g:695:3: ( 'LSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLSVEnumLiteralDeclaration_72()); 
                    // InternalDbTextEditor.g:696:3: ( 'LSV' )
                    // InternalDbTextEditor.g:696:4: 'LSV'
                    {
                    match(input,83,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLSVEnumLiteralDeclaration_72()); 

                    }


                    }
                    break;
                case 74 :
                    // InternalDbTextEditor.g:700:2: ( ( 'SSCN' ) )
                    {
                    // InternalDbTextEditor.g:700:2: ( ( 'SSCN' ) )
                    // InternalDbTextEditor.g:701:3: ( 'SSCN' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSSCNEnumLiteralDeclaration_73()); 
                    // InternalDbTextEditor.g:702:3: ( 'SSCN' )
                    // InternalDbTextEditor.g:702:4: 'SSCN'
                    {
                    match(input,84,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSSCNEnumLiteralDeclaration_73()); 

                    }


                    }
                    break;
                case 75 :
                    // InternalDbTextEditor.g:706:2: ( ( 'TSE' ) )
                    {
                    // InternalDbTextEditor.g:706:2: ( ( 'TSE' ) )
                    // InternalDbTextEditor.g:707:3: ( 'TSE' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getTSEEnumLiteralDeclaration_74()); 
                    // InternalDbTextEditor.g:708:3: ( 'TSE' )
                    // InternalDbTextEditor.g:708:4: 'TSE'
                    {
                    match(input,85,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getTSEEnumLiteralDeclaration_74()); 

                    }


                    }
                    break;
                case 76 :
                    // InternalDbTextEditor.g:712:2: ( ( 'PREC' ) )
                    {
                    // InternalDbTextEditor.g:712:2: ( ( 'PREC' ) )
                    // InternalDbTextEditor.g:713:3: ( 'PREC' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getPRECEnumLiteralDeclaration_75()); 
                    // InternalDbTextEditor.g:714:3: ( 'PREC' )
                    // InternalDbTextEditor.g:714:4: 'PREC'
                    {
                    match(input,86,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getPRECEnumLiteralDeclaration_75()); 

                    }


                    }
                    break;
                case 77 :
                    // InternalDbTextEditor.g:718:2: ( ( 'DRVH' ) )
                    {
                    // InternalDbTextEditor.g:718:2: ( ( 'DRVH' ) )
                    // InternalDbTextEditor.g:719:3: ( 'DRVH' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getDRVHEnumLiteralDeclaration_76()); 
                    // InternalDbTextEditor.g:720:3: ( 'DRVH' )
                    // InternalDbTextEditor.g:720:4: 'DRVH'
                    {
                    match(input,87,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getDRVHEnumLiteralDeclaration_76()); 

                    }


                    }
                    break;
                case 78 :
                    // InternalDbTextEditor.g:724:2: ( ( 'LOPR' ) )
                    {
                    // InternalDbTextEditor.g:724:2: ( ( 'LOPR' ) )
                    // InternalDbTextEditor.g:725:3: ( 'LOPR' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLOPREnumLiteralDeclaration_77()); 
                    // InternalDbTextEditor.g:726:3: ( 'LOPR' )
                    // InternalDbTextEditor.g:726:4: 'LOPR'
                    {
                    match(input,88,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLOPREnumLiteralDeclaration_77()); 

                    }


                    }
                    break;
                case 79 :
                    // InternalDbTextEditor.g:730:2: ( ( 'DRVL' ) )
                    {
                    // InternalDbTextEditor.g:730:2: ( ( 'DRVL' ) )
                    // InternalDbTextEditor.g:731:3: ( 'DRVL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getDRVLEnumLiteralDeclaration_78()); 
                    // InternalDbTextEditor.g:732:3: ( 'DRVL' )
                    // InternalDbTextEditor.g:732:4: 'DRVL'
                    {
                    match(input,89,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getDRVLEnumLiteralDeclaration_78()); 

                    }


                    }
                    break;
                case 80 :
                    // InternalDbTextEditor.g:736:2: ( ( 'HOPR' ) )
                    {
                    // InternalDbTextEditor.g:736:2: ( ( 'HOPR' ) )
                    // InternalDbTextEditor.g:737:3: ( 'HOPR' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getHOPREnumLiteralDeclaration_79()); 
                    // InternalDbTextEditor.g:738:3: ( 'HOPR' )
                    // InternalDbTextEditor.g:738:4: 'HOPR'
                    {
                    match(input,90,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getHOPREnumLiteralDeclaration_79()); 

                    }


                    }
                    break;
                case 81 :
                    // InternalDbTextEditor.g:742:2: ( ( 'CALC' ) )
                    {
                    // InternalDbTextEditor.g:742:2: ( ( 'CALC' ) )
                    // InternalDbTextEditor.g:743:3: ( 'CALC' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getCALCEnumLiteralDeclaration_80()); 
                    // InternalDbTextEditor.g:744:3: ( 'CALC' )
                    // InternalDbTextEditor.g:744:4: 'CALC'
                    {
                    match(input,91,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getCALCEnumLiteralDeclaration_80()); 

                    }


                    }
                    break;
                case 82 :
                    // InternalDbTextEditor.g:748:2: ( ( 'INPA' ) )
                    {
                    // InternalDbTextEditor.g:748:2: ( ( 'INPA' ) )
                    // InternalDbTextEditor.g:749:3: ( 'INPA' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPAEnumLiteralDeclaration_81()); 
                    // InternalDbTextEditor.g:750:3: ( 'INPA' )
                    // InternalDbTextEditor.g:750:4: 'INPA'
                    {
                    match(input,92,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPAEnumLiteralDeclaration_81()); 

                    }


                    }
                    break;
                case 83 :
                    // InternalDbTextEditor.g:754:2: ( ( 'INPB' ) )
                    {
                    // InternalDbTextEditor.g:754:2: ( ( 'INPB' ) )
                    // InternalDbTextEditor.g:755:3: ( 'INPB' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPBEnumLiteralDeclaration_82()); 
                    // InternalDbTextEditor.g:756:3: ( 'INPB' )
                    // InternalDbTextEditor.g:756:4: 'INPB'
                    {
                    match(input,93,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPBEnumLiteralDeclaration_82()); 

                    }


                    }
                    break;
                case 84 :
                    // InternalDbTextEditor.g:760:2: ( ( 'INPC' ) )
                    {
                    // InternalDbTextEditor.g:760:2: ( ( 'INPC' ) )
                    // InternalDbTextEditor.g:761:3: ( 'INPC' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPCEnumLiteralDeclaration_83()); 
                    // InternalDbTextEditor.g:762:3: ( 'INPC' )
                    // InternalDbTextEditor.g:762:4: 'INPC'
                    {
                    match(input,94,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPCEnumLiteralDeclaration_83()); 

                    }


                    }
                    break;
                case 85 :
                    // InternalDbTextEditor.g:766:2: ( ( 'INPD' ) )
                    {
                    // InternalDbTextEditor.g:766:2: ( ( 'INPD' ) )
                    // InternalDbTextEditor.g:767:3: ( 'INPD' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPDEnumLiteralDeclaration_84()); 
                    // InternalDbTextEditor.g:768:3: ( 'INPD' )
                    // InternalDbTextEditor.g:768:4: 'INPD'
                    {
                    match(input,95,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPDEnumLiteralDeclaration_84()); 

                    }


                    }
                    break;
                case 86 :
                    // InternalDbTextEditor.g:772:2: ( ( 'FLNK' ) )
                    {
                    // InternalDbTextEditor.g:772:2: ( ( 'FLNK' ) )
                    // InternalDbTextEditor.g:773:3: ( 'FLNK' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getFLNKEnumLiteralDeclaration_85()); 
                    // InternalDbTextEditor.g:774:3: ( 'FLNK' )
                    // InternalDbTextEditor.g:774:4: 'FLNK'
                    {
                    match(input,96,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getFLNKEnumLiteralDeclaration_85()); 

                    }


                    }
                    break;
                case 87 :
                    // InternalDbTextEditor.g:778:2: ( ( 'INPE' ) )
                    {
                    // InternalDbTextEditor.g:778:2: ( ( 'INPE' ) )
                    // InternalDbTextEditor.g:779:3: ( 'INPE' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPEEnumLiteralDeclaration_86()); 
                    // InternalDbTextEditor.g:780:3: ( 'INPE' )
                    // InternalDbTextEditor.g:780:4: 'INPE'
                    {
                    match(input,97,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPEEnumLiteralDeclaration_86()); 

                    }


                    }
                    break;
                case 88 :
                    // InternalDbTextEditor.g:784:2: ( ( 'INPF' ) )
                    {
                    // InternalDbTextEditor.g:784:2: ( ( 'INPF' ) )
                    // InternalDbTextEditor.g:785:3: ( 'INPF' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPFEnumLiteralDeclaration_87()); 
                    // InternalDbTextEditor.g:786:3: ( 'INPF' )
                    // InternalDbTextEditor.g:786:4: 'INPF'
                    {
                    match(input,98,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPFEnumLiteralDeclaration_87()); 

                    }


                    }
                    break;
                case 89 :
                    // InternalDbTextEditor.g:790:2: ( ( 'INPG' ) )
                    {
                    // InternalDbTextEditor.g:790:2: ( ( 'INPG' ) )
                    // InternalDbTextEditor.g:791:3: ( 'INPG' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPGEnumLiteralDeclaration_88()); 
                    // InternalDbTextEditor.g:792:3: ( 'INPG' )
                    // InternalDbTextEditor.g:792:4: 'INPG'
                    {
                    match(input,99,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPGEnumLiteralDeclaration_88()); 

                    }


                    }
                    break;
                case 90 :
                    // InternalDbTextEditor.g:796:2: ( ( 'INPH' ) )
                    {
                    // InternalDbTextEditor.g:796:2: ( ( 'INPH' ) )
                    // InternalDbTextEditor.g:797:3: ( 'INPH' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPHEnumLiteralDeclaration_89()); 
                    // InternalDbTextEditor.g:798:3: ( 'INPH' )
                    // InternalDbTextEditor.g:798:4: 'INPH'
                    {
                    match(input,100,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPHEnumLiteralDeclaration_89()); 

                    }


                    }
                    break;
                case 91 :
                    // InternalDbTextEditor.g:802:2: ( ( 'INPI' ) )
                    {
                    // InternalDbTextEditor.g:802:2: ( ( 'INPI' ) )
                    // InternalDbTextEditor.g:803:3: ( 'INPI' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPIEnumLiteralDeclaration_90()); 
                    // InternalDbTextEditor.g:804:3: ( 'INPI' )
                    // InternalDbTextEditor.g:804:4: 'INPI'
                    {
                    match(input,101,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPIEnumLiteralDeclaration_90()); 

                    }


                    }
                    break;
                case 92 :
                    // InternalDbTextEditor.g:808:2: ( ( 'INPJ' ) )
                    {
                    // InternalDbTextEditor.g:808:2: ( ( 'INPJ' ) )
                    // InternalDbTextEditor.g:809:3: ( 'INPJ' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPJEnumLiteralDeclaration_91()); 
                    // InternalDbTextEditor.g:810:3: ( 'INPJ' )
                    // InternalDbTextEditor.g:810:4: 'INPJ'
                    {
                    match(input,102,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPJEnumLiteralDeclaration_91()); 

                    }


                    }
                    break;
                case 93 :
                    // InternalDbTextEditor.g:814:2: ( ( 'INPK' ) )
                    {
                    // InternalDbTextEditor.g:814:2: ( ( 'INPK' ) )
                    // InternalDbTextEditor.g:815:3: ( 'INPK' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPKEnumLiteralDeclaration_92()); 
                    // InternalDbTextEditor.g:816:3: ( 'INPK' )
                    // InternalDbTextEditor.g:816:4: 'INPK'
                    {
                    match(input,103,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPKEnumLiteralDeclaration_92()); 

                    }


                    }
                    break;
                case 94 :
                    // InternalDbTextEditor.g:820:2: ( ( 'INAA' ) )
                    {
                    // InternalDbTextEditor.g:820:2: ( ( 'INAA' ) )
                    // InternalDbTextEditor.g:821:3: ( 'INAA' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINAAEnumLiteralDeclaration_93()); 
                    // InternalDbTextEditor.g:822:3: ( 'INAA' )
                    // InternalDbTextEditor.g:822:4: 'INAA'
                    {
                    match(input,104,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINAAEnumLiteralDeclaration_93()); 

                    }


                    }
                    break;
                case 95 :
                    // InternalDbTextEditor.g:826:2: ( ( 'INBB' ) )
                    {
                    // InternalDbTextEditor.g:826:2: ( ( 'INBB' ) )
                    // InternalDbTextEditor.g:827:3: ( 'INBB' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINBBEnumLiteralDeclaration_94()); 
                    // InternalDbTextEditor.g:828:3: ( 'INBB' )
                    // InternalDbTextEditor.g:828:4: 'INBB'
                    {
                    match(input,105,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINBBEnumLiteralDeclaration_94()); 

                    }


                    }
                    break;
                case 96 :
                    // InternalDbTextEditor.g:832:2: ( ( 'INCC' ) )
                    {
                    // InternalDbTextEditor.g:832:2: ( ( 'INCC' ) )
                    // InternalDbTextEditor.g:833:3: ( 'INCC' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINCCEnumLiteralDeclaration_95()); 
                    // InternalDbTextEditor.g:834:3: ( 'INCC' )
                    // InternalDbTextEditor.g:834:4: 'INCC'
                    {
                    match(input,106,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINCCEnumLiteralDeclaration_95()); 

                    }


                    }
                    break;
                case 97 :
                    // InternalDbTextEditor.g:838:2: ( ( 'SIOL' ) )
                    {
                    // InternalDbTextEditor.g:838:2: ( ( 'SIOL' ) )
                    // InternalDbTextEditor.g:839:3: ( 'SIOL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSIOLEnumLiteralDeclaration_96()); 
                    // InternalDbTextEditor.g:840:3: ( 'SIOL' )
                    // InternalDbTextEditor.g:840:4: 'SIOL'
                    {
                    match(input,107,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSIOLEnumLiteralDeclaration_96()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Fieldnames__Alternatives"


    // $ANTLR start "rule__Recordnames__Alternatives"
    // InternalDbTextEditor.g:848:1: rule__Recordnames__Alternatives : ( ( ( 'ai' ) ) | ( ( 'ao' ) ) | ( ( 'longin' ) ) | ( ( 'longout' ) ) | ( ( 'stringin' ) ) | ( ( 'stringout' ) ) | ( ( 'lsi' ) ) | ( ( 'lso' ) ) | ( ( 'waveform' ) ) | ( ( 'bi' ) ) | ( ( 'bo' ) ) | ( ( 'mbbi' ) ) | ( ( 'mbbo' ) ) | ( ( 'mbbiDirect' ) ) | ( ( 'mbboDirect' ) ) | ( ( 'calcout' ) ) | ( ( 'scalcout' ) ) | ( ( 'calc' ) ) );
    public final void rule__Recordnames__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:852:1: ( ( ( 'ai' ) ) | ( ( 'ao' ) ) | ( ( 'longin' ) ) | ( ( 'longout' ) ) | ( ( 'stringin' ) ) | ( ( 'stringout' ) ) | ( ( 'lsi' ) ) | ( ( 'lso' ) ) | ( ( 'waveform' ) ) | ( ( 'bi' ) ) | ( ( 'bo' ) ) | ( ( 'mbbi' ) ) | ( ( 'mbbo' ) ) | ( ( 'mbbiDirect' ) ) | ( ( 'mbboDirect' ) ) | ( ( 'calcout' ) ) | ( ( 'scalcout' ) ) | ( ( 'calc' ) ) )
            int alt5=18;
            switch ( input.LA(1) ) {
            case 108:
                {
                alt5=1;
                }
                break;
            case 109:
                {
                alt5=2;
                }
                break;
            case 110:
                {
                alt5=3;
                }
                break;
            case 111:
                {
                alt5=4;
                }
                break;
            case 112:
                {
                alt5=5;
                }
                break;
            case 113:
                {
                alt5=6;
                }
                break;
            case 114:
                {
                alt5=7;
                }
                break;
            case 115:
                {
                alt5=8;
                }
                break;
            case 116:
                {
                alt5=9;
                }
                break;
            case 117:
                {
                alt5=10;
                }
                break;
            case 118:
                {
                alt5=11;
                }
                break;
            case 119:
                {
                alt5=12;
                }
                break;
            case 120:
                {
                alt5=13;
                }
                break;
            case 121:
                {
                alt5=14;
                }
                break;
            case 122:
                {
                alt5=15;
                }
                break;
            case 123:
                {
                alt5=16;
                }
                break;
            case 124:
                {
                alt5=17;
                }
                break;
            case 125:
                {
                alt5=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalDbTextEditor.g:853:2: ( ( 'ai' ) )
                    {
                    // InternalDbTextEditor.g:853:2: ( ( 'ai' ) )
                    // InternalDbTextEditor.g:854:3: ( 'ai' )
                    {
                     before(grammarAccess.getRecordnamesAccess().getAiEnumLiteralDeclaration_0()); 
                    // InternalDbTextEditor.g:855:3: ( 'ai' )
                    // InternalDbTextEditor.g:855:4: 'ai'
                    {
                    match(input,108,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordnamesAccess().getAiEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDbTextEditor.g:859:2: ( ( 'ao' ) )
                    {
                    // InternalDbTextEditor.g:859:2: ( ( 'ao' ) )
                    // InternalDbTextEditor.g:860:3: ( 'ao' )
                    {
                     before(grammarAccess.getRecordnamesAccess().getAoEnumLiteralDeclaration_1()); 
                    // InternalDbTextEditor.g:861:3: ( 'ao' )
                    // InternalDbTextEditor.g:861:4: 'ao'
                    {
                    match(input,109,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordnamesAccess().getAoEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDbTextEditor.g:865:2: ( ( 'longin' ) )
                    {
                    // InternalDbTextEditor.g:865:2: ( ( 'longin' ) )
                    // InternalDbTextEditor.g:866:3: ( 'longin' )
                    {
                     before(grammarAccess.getRecordnamesAccess().getLonginEnumLiteralDeclaration_2()); 
                    // InternalDbTextEditor.g:867:3: ( 'longin' )
                    // InternalDbTextEditor.g:867:4: 'longin'
                    {
                    match(input,110,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordnamesAccess().getLonginEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDbTextEditor.g:871:2: ( ( 'longout' ) )
                    {
                    // InternalDbTextEditor.g:871:2: ( ( 'longout' ) )
                    // InternalDbTextEditor.g:872:3: ( 'longout' )
                    {
                     before(grammarAccess.getRecordnamesAccess().getLongoutEnumLiteralDeclaration_3()); 
                    // InternalDbTextEditor.g:873:3: ( 'longout' )
                    // InternalDbTextEditor.g:873:4: 'longout'
                    {
                    match(input,111,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordnamesAccess().getLongoutEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDbTextEditor.g:877:2: ( ( 'stringin' ) )
                    {
                    // InternalDbTextEditor.g:877:2: ( ( 'stringin' ) )
                    // InternalDbTextEditor.g:878:3: ( 'stringin' )
                    {
                     before(grammarAccess.getRecordnamesAccess().getStringinEnumLiteralDeclaration_4()); 
                    // InternalDbTextEditor.g:879:3: ( 'stringin' )
                    // InternalDbTextEditor.g:879:4: 'stringin'
                    {
                    match(input,112,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordnamesAccess().getStringinEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDbTextEditor.g:883:2: ( ( 'stringout' ) )
                    {
                    // InternalDbTextEditor.g:883:2: ( ( 'stringout' ) )
                    // InternalDbTextEditor.g:884:3: ( 'stringout' )
                    {
                     before(grammarAccess.getRecordnamesAccess().getStringoutEnumLiteralDeclaration_5()); 
                    // InternalDbTextEditor.g:885:3: ( 'stringout' )
                    // InternalDbTextEditor.g:885:4: 'stringout'
                    {
                    match(input,113,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordnamesAccess().getStringoutEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDbTextEditor.g:889:2: ( ( 'lsi' ) )
                    {
                    // InternalDbTextEditor.g:889:2: ( ( 'lsi' ) )
                    // InternalDbTextEditor.g:890:3: ( 'lsi' )
                    {
                     before(grammarAccess.getRecordnamesAccess().getLsiEnumLiteralDeclaration_6()); 
                    // InternalDbTextEditor.g:891:3: ( 'lsi' )
                    // InternalDbTextEditor.g:891:4: 'lsi'
                    {
                    match(input,114,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordnamesAccess().getLsiEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDbTextEditor.g:895:2: ( ( 'lso' ) )
                    {
                    // InternalDbTextEditor.g:895:2: ( ( 'lso' ) )
                    // InternalDbTextEditor.g:896:3: ( 'lso' )
                    {
                     before(grammarAccess.getRecordnamesAccess().getLsoEnumLiteralDeclaration_7()); 
                    // InternalDbTextEditor.g:897:3: ( 'lso' )
                    // InternalDbTextEditor.g:897:4: 'lso'
                    {
                    match(input,115,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordnamesAccess().getLsoEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDbTextEditor.g:901:2: ( ( 'waveform' ) )
                    {
                    // InternalDbTextEditor.g:901:2: ( ( 'waveform' ) )
                    // InternalDbTextEditor.g:902:3: ( 'waveform' )
                    {
                     before(grammarAccess.getRecordnamesAccess().getWaveformEnumLiteralDeclaration_8()); 
                    // InternalDbTextEditor.g:903:3: ( 'waveform' )
                    // InternalDbTextEditor.g:903:4: 'waveform'
                    {
                    match(input,116,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordnamesAccess().getWaveformEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDbTextEditor.g:907:2: ( ( 'bi' ) )
                    {
                    // InternalDbTextEditor.g:907:2: ( ( 'bi' ) )
                    // InternalDbTextEditor.g:908:3: ( 'bi' )
                    {
                     before(grammarAccess.getRecordnamesAccess().getBiEnumLiteralDeclaration_9()); 
                    // InternalDbTextEditor.g:909:3: ( 'bi' )
                    // InternalDbTextEditor.g:909:4: 'bi'
                    {
                    match(input,117,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordnamesAccess().getBiEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalDbTextEditor.g:913:2: ( ( 'bo' ) )
                    {
                    // InternalDbTextEditor.g:913:2: ( ( 'bo' ) )
                    // InternalDbTextEditor.g:914:3: ( 'bo' )
                    {
                     before(grammarAccess.getRecordnamesAccess().getBoEnumLiteralDeclaration_10()); 
                    // InternalDbTextEditor.g:915:3: ( 'bo' )
                    // InternalDbTextEditor.g:915:4: 'bo'
                    {
                    match(input,118,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordnamesAccess().getBoEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalDbTextEditor.g:919:2: ( ( 'mbbi' ) )
                    {
                    // InternalDbTextEditor.g:919:2: ( ( 'mbbi' ) )
                    // InternalDbTextEditor.g:920:3: ( 'mbbi' )
                    {
                     before(grammarAccess.getRecordnamesAccess().getMbbiEnumLiteralDeclaration_11()); 
                    // InternalDbTextEditor.g:921:3: ( 'mbbi' )
                    // InternalDbTextEditor.g:921:4: 'mbbi'
                    {
                    match(input,119,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordnamesAccess().getMbbiEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalDbTextEditor.g:925:2: ( ( 'mbbo' ) )
                    {
                    // InternalDbTextEditor.g:925:2: ( ( 'mbbo' ) )
                    // InternalDbTextEditor.g:926:3: ( 'mbbo' )
                    {
                     before(grammarAccess.getRecordnamesAccess().getMbboEnumLiteralDeclaration_12()); 
                    // InternalDbTextEditor.g:927:3: ( 'mbbo' )
                    // InternalDbTextEditor.g:927:4: 'mbbo'
                    {
                    match(input,120,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordnamesAccess().getMbboEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalDbTextEditor.g:931:2: ( ( 'mbbiDirect' ) )
                    {
                    // InternalDbTextEditor.g:931:2: ( ( 'mbbiDirect' ) )
                    // InternalDbTextEditor.g:932:3: ( 'mbbiDirect' )
                    {
                     before(grammarAccess.getRecordnamesAccess().getMbbiDirectEnumLiteralDeclaration_13()); 
                    // InternalDbTextEditor.g:933:3: ( 'mbbiDirect' )
                    // InternalDbTextEditor.g:933:4: 'mbbiDirect'
                    {
                    match(input,121,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordnamesAccess().getMbbiDirectEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalDbTextEditor.g:937:2: ( ( 'mbboDirect' ) )
                    {
                    // InternalDbTextEditor.g:937:2: ( ( 'mbboDirect' ) )
                    // InternalDbTextEditor.g:938:3: ( 'mbboDirect' )
                    {
                     before(grammarAccess.getRecordnamesAccess().getMbboDirectEnumLiteralDeclaration_14()); 
                    // InternalDbTextEditor.g:939:3: ( 'mbboDirect' )
                    // InternalDbTextEditor.g:939:4: 'mbboDirect'
                    {
                    match(input,122,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordnamesAccess().getMbboDirectEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalDbTextEditor.g:943:2: ( ( 'calcout' ) )
                    {
                    // InternalDbTextEditor.g:943:2: ( ( 'calcout' ) )
                    // InternalDbTextEditor.g:944:3: ( 'calcout' )
                    {
                     before(grammarAccess.getRecordnamesAccess().getCalcoutEnumLiteralDeclaration_15()); 
                    // InternalDbTextEditor.g:945:3: ( 'calcout' )
                    // InternalDbTextEditor.g:945:4: 'calcout'
                    {
                    match(input,123,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordnamesAccess().getCalcoutEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalDbTextEditor.g:949:2: ( ( 'scalcout' ) )
                    {
                    // InternalDbTextEditor.g:949:2: ( ( 'scalcout' ) )
                    // InternalDbTextEditor.g:950:3: ( 'scalcout' )
                    {
                     before(grammarAccess.getRecordnamesAccess().getScalcoutEnumLiteralDeclaration_16()); 
                    // InternalDbTextEditor.g:951:3: ( 'scalcout' )
                    // InternalDbTextEditor.g:951:4: 'scalcout'
                    {
                    match(input,124,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordnamesAccess().getScalcoutEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalDbTextEditor.g:955:2: ( ( 'calc' ) )
                    {
                    // InternalDbTextEditor.g:955:2: ( ( 'calc' ) )
                    // InternalDbTextEditor.g:956:3: ( 'calc' )
                    {
                     before(grammarAccess.getRecordnamesAccess().getCalcEnumLiteralDeclaration_17()); 
                    // InternalDbTextEditor.g:957:3: ( 'calc' )
                    // InternalDbTextEditor.g:957:4: 'calc'
                    {
                    match(input,125,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordnamesAccess().getCalcEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Recordnames__Alternatives"


    // $ANTLR start "rule__Record__Group__0"
    // InternalDbTextEditor.g:965:1: rule__Record__Group__0 : rule__Record__Group__0__Impl rule__Record__Group__1 ;
    public final void rule__Record__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:969:1: ( rule__Record__Group__0__Impl rule__Record__Group__1 )
            // InternalDbTextEditor.g:970:2: rule__Record__Group__0__Impl rule__Record__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Record__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Record__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__Group__0"


    // $ANTLR start "rule__Record__Group__0__Impl"
    // InternalDbTextEditor.g:977:1: rule__Record__Group__0__Impl : ( ( rule__Record__NameAssignment_0 ) ) ;
    public final void rule__Record__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:981:1: ( ( ( rule__Record__NameAssignment_0 ) ) )
            // InternalDbTextEditor.g:982:1: ( ( rule__Record__NameAssignment_0 ) )
            {
            // InternalDbTextEditor.g:982:1: ( ( rule__Record__NameAssignment_0 ) )
            // InternalDbTextEditor.g:983:2: ( rule__Record__NameAssignment_0 )
            {
             before(grammarAccess.getRecordAccess().getNameAssignment_0()); 
            // InternalDbTextEditor.g:984:2: ( rule__Record__NameAssignment_0 )
            // InternalDbTextEditor.g:984:3: rule__Record__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Record__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRecordAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__Group__0__Impl"


    // $ANTLR start "rule__Record__Group__1"
    // InternalDbTextEditor.g:992:1: rule__Record__Group__1 : rule__Record__Group__1__Impl rule__Record__Group__2 ;
    public final void rule__Record__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:996:1: ( rule__Record__Group__1__Impl rule__Record__Group__2 )
            // InternalDbTextEditor.g:997:2: rule__Record__Group__1__Impl rule__Record__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Record__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Record__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__Group__1"


    // $ANTLR start "rule__Record__Group__1__Impl"
    // InternalDbTextEditor.g:1004:1: rule__Record__Group__1__Impl : ( '(' ) ;
    public final void rule__Record__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1008:1: ( ( '(' ) )
            // InternalDbTextEditor.g:1009:1: ( '(' )
            {
            // InternalDbTextEditor.g:1009:1: ( '(' )
            // InternalDbTextEditor.g:1010:2: '('
            {
             before(grammarAccess.getRecordAccess().getLeftParenthesisKeyword_1()); 
            match(input,126,FOLLOW_2); 
             after(grammarAccess.getRecordAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__Group__1__Impl"


    // $ANTLR start "rule__Record__Group__2"
    // InternalDbTextEditor.g:1019:1: rule__Record__Group__2 : rule__Record__Group__2__Impl rule__Record__Group__3 ;
    public final void rule__Record__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1023:1: ( rule__Record__Group__2__Impl rule__Record__Group__3 )
            // InternalDbTextEditor.g:1024:2: rule__Record__Group__2__Impl rule__Record__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Record__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Record__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__Group__2"


    // $ANTLR start "rule__Record__Group__2__Impl"
    // InternalDbTextEditor.g:1031:1: rule__Record__Group__2__Impl : ( ( rule__Record__RecordnameAssignment_2 ) ) ;
    public final void rule__Record__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1035:1: ( ( ( rule__Record__RecordnameAssignment_2 ) ) )
            // InternalDbTextEditor.g:1036:1: ( ( rule__Record__RecordnameAssignment_2 ) )
            {
            // InternalDbTextEditor.g:1036:1: ( ( rule__Record__RecordnameAssignment_2 ) )
            // InternalDbTextEditor.g:1037:2: ( rule__Record__RecordnameAssignment_2 )
            {
             before(grammarAccess.getRecordAccess().getRecordnameAssignment_2()); 
            // InternalDbTextEditor.g:1038:2: ( rule__Record__RecordnameAssignment_2 )
            // InternalDbTextEditor.g:1038:3: rule__Record__RecordnameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Record__RecordnameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRecordAccess().getRecordnameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__Group__2__Impl"


    // $ANTLR start "rule__Record__Group__3"
    // InternalDbTextEditor.g:1046:1: rule__Record__Group__3 : rule__Record__Group__3__Impl rule__Record__Group__4 ;
    public final void rule__Record__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1050:1: ( rule__Record__Group__3__Impl rule__Record__Group__4 )
            // InternalDbTextEditor.g:1051:2: rule__Record__Group__3__Impl rule__Record__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Record__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Record__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__Group__3"


    // $ANTLR start "rule__Record__Group__3__Impl"
    // InternalDbTextEditor.g:1058:1: rule__Record__Group__3__Impl : ( ',' ) ;
    public final void rule__Record__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1062:1: ( ( ',' ) )
            // InternalDbTextEditor.g:1063:1: ( ',' )
            {
            // InternalDbTextEditor.g:1063:1: ( ',' )
            // InternalDbTextEditor.g:1064:2: ','
            {
             before(grammarAccess.getRecordAccess().getCommaKeyword_3()); 
            match(input,127,FOLLOW_2); 
             after(grammarAccess.getRecordAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__Group__3__Impl"


    // $ANTLR start "rule__Record__Group__4"
    // InternalDbTextEditor.g:1073:1: rule__Record__Group__4 : rule__Record__Group__4__Impl rule__Record__Group__5 ;
    public final void rule__Record__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1077:1: ( rule__Record__Group__4__Impl rule__Record__Group__5 )
            // InternalDbTextEditor.g:1078:2: rule__Record__Group__4__Impl rule__Record__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__Record__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Record__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__Group__4"


    // $ANTLR start "rule__Record__Group__4__Impl"
    // InternalDbTextEditor.g:1085:1: rule__Record__Group__4__Impl : ( ( rule__Record__RecordLinkAssignment_4 ) ) ;
    public final void rule__Record__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1089:1: ( ( ( rule__Record__RecordLinkAssignment_4 ) ) )
            // InternalDbTextEditor.g:1090:1: ( ( rule__Record__RecordLinkAssignment_4 ) )
            {
            // InternalDbTextEditor.g:1090:1: ( ( rule__Record__RecordLinkAssignment_4 ) )
            // InternalDbTextEditor.g:1091:2: ( rule__Record__RecordLinkAssignment_4 )
            {
             before(grammarAccess.getRecordAccess().getRecordLinkAssignment_4()); 
            // InternalDbTextEditor.g:1092:2: ( rule__Record__RecordLinkAssignment_4 )
            // InternalDbTextEditor.g:1092:3: rule__Record__RecordLinkAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Record__RecordLinkAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getRecordAccess().getRecordLinkAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__Group__4__Impl"


    // $ANTLR start "rule__Record__Group__5"
    // InternalDbTextEditor.g:1100:1: rule__Record__Group__5 : rule__Record__Group__5__Impl rule__Record__Group__6 ;
    public final void rule__Record__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1104:1: ( rule__Record__Group__5__Impl rule__Record__Group__6 )
            // InternalDbTextEditor.g:1105:2: rule__Record__Group__5__Impl rule__Record__Group__6
            {
            pushFollow(FOLLOW_9);
            rule__Record__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Record__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__Group__5"


    // $ANTLR start "rule__Record__Group__5__Impl"
    // InternalDbTextEditor.g:1112:1: rule__Record__Group__5__Impl : ( ')' ) ;
    public final void rule__Record__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1116:1: ( ( ')' ) )
            // InternalDbTextEditor.g:1117:1: ( ')' )
            {
            // InternalDbTextEditor.g:1117:1: ( ')' )
            // InternalDbTextEditor.g:1118:2: ')'
            {
             before(grammarAccess.getRecordAccess().getRightParenthesisKeyword_5()); 
            match(input,128,FOLLOW_2); 
             after(grammarAccess.getRecordAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__Group__5__Impl"


    // $ANTLR start "rule__Record__Group__6"
    // InternalDbTextEditor.g:1127:1: rule__Record__Group__6 : rule__Record__Group__6__Impl rule__Record__Group__7 ;
    public final void rule__Record__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1131:1: ( rule__Record__Group__6__Impl rule__Record__Group__7 )
            // InternalDbTextEditor.g:1132:2: rule__Record__Group__6__Impl rule__Record__Group__7
            {
            pushFollow(FOLLOW_10);
            rule__Record__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Record__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__Group__6"


    // $ANTLR start "rule__Record__Group__6__Impl"
    // InternalDbTextEditor.g:1139:1: rule__Record__Group__6__Impl : ( '{' ) ;
    public final void rule__Record__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1143:1: ( ( '{' ) )
            // InternalDbTextEditor.g:1144:1: ( '{' )
            {
            // InternalDbTextEditor.g:1144:1: ( '{' )
            // InternalDbTextEditor.g:1145:2: '{'
            {
             before(grammarAccess.getRecordAccess().getLeftCurlyBracketKeyword_6()); 
            match(input,129,FOLLOW_2); 
             after(grammarAccess.getRecordAccess().getLeftCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__Group__6__Impl"


    // $ANTLR start "rule__Record__Group__7"
    // InternalDbTextEditor.g:1154:1: rule__Record__Group__7 : rule__Record__Group__7__Impl rule__Record__Group__8 ;
    public final void rule__Record__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1158:1: ( rule__Record__Group__7__Impl rule__Record__Group__8 )
            // InternalDbTextEditor.g:1159:2: rule__Record__Group__7__Impl rule__Record__Group__8
            {
            pushFollow(FOLLOW_10);
            rule__Record__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Record__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__Group__7"


    // $ANTLR start "rule__Record__Group__7__Impl"
    // InternalDbTextEditor.g:1166:1: rule__Record__Group__7__Impl : ( ( rule__Record__InfosfieldsAssignment_7 )* ) ;
    public final void rule__Record__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1170:1: ( ( ( rule__Record__InfosfieldsAssignment_7 )* ) )
            // InternalDbTextEditor.g:1171:1: ( ( rule__Record__InfosfieldsAssignment_7 )* )
            {
            // InternalDbTextEditor.g:1171:1: ( ( rule__Record__InfosfieldsAssignment_7 )* )
            // InternalDbTextEditor.g:1172:2: ( rule__Record__InfosfieldsAssignment_7 )*
            {
             before(grammarAccess.getRecordAccess().getInfosfieldsAssignment_7()); 
            // InternalDbTextEditor.g:1173:2: ( rule__Record__InfosfieldsAssignment_7 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==131||LA6_0==134) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalDbTextEditor.g:1173:3: rule__Record__InfosfieldsAssignment_7
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Record__InfosfieldsAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getRecordAccess().getInfosfieldsAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__Group__7__Impl"


    // $ANTLR start "rule__Record__Group__8"
    // InternalDbTextEditor.g:1181:1: rule__Record__Group__8 : rule__Record__Group__8__Impl ;
    public final void rule__Record__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1185:1: ( rule__Record__Group__8__Impl )
            // InternalDbTextEditor.g:1186:2: rule__Record__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Record__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__Group__8"


    // $ANTLR start "rule__Record__Group__8__Impl"
    // InternalDbTextEditor.g:1192:1: rule__Record__Group__8__Impl : ( '}' ) ;
    public final void rule__Record__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1196:1: ( ( '}' ) )
            // InternalDbTextEditor.g:1197:1: ( '}' )
            {
            // InternalDbTextEditor.g:1197:1: ( '}' )
            // InternalDbTextEditor.g:1198:2: '}'
            {
             before(grammarAccess.getRecordAccess().getRightCurlyBracketKeyword_8()); 
            match(input,130,FOLLOW_2); 
             after(grammarAccess.getRecordAccess().getRightCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__Group__8__Impl"


    // $ANTLR start "rule__Field__Group__0"
    // InternalDbTextEditor.g:1208:1: rule__Field__Group__0 : rule__Field__Group__0__Impl rule__Field__Group__1 ;
    public final void rule__Field__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1212:1: ( rule__Field__Group__0__Impl rule__Field__Group__1 )
            // InternalDbTextEditor.g:1213:2: rule__Field__Group__0__Impl rule__Field__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Field__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Field__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__0"


    // $ANTLR start "rule__Field__Group__0__Impl"
    // InternalDbTextEditor.g:1220:1: rule__Field__Group__0__Impl : ( ( rule__Field__NameAssignment_0 ) ) ;
    public final void rule__Field__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1224:1: ( ( ( rule__Field__NameAssignment_0 ) ) )
            // InternalDbTextEditor.g:1225:1: ( ( rule__Field__NameAssignment_0 ) )
            {
            // InternalDbTextEditor.g:1225:1: ( ( rule__Field__NameAssignment_0 ) )
            // InternalDbTextEditor.g:1226:2: ( rule__Field__NameAssignment_0 )
            {
             before(grammarAccess.getFieldAccess().getNameAssignment_0()); 
            // InternalDbTextEditor.g:1227:2: ( rule__Field__NameAssignment_0 )
            // InternalDbTextEditor.g:1227:3: rule__Field__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Field__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFieldAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__0__Impl"


    // $ANTLR start "rule__Field__Group__1"
    // InternalDbTextEditor.g:1235:1: rule__Field__Group__1 : rule__Field__Group__1__Impl rule__Field__Group__2 ;
    public final void rule__Field__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1239:1: ( rule__Field__Group__1__Impl rule__Field__Group__2 )
            // InternalDbTextEditor.g:1240:2: rule__Field__Group__1__Impl rule__Field__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__Field__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Field__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__1"


    // $ANTLR start "rule__Field__Group__1__Impl"
    // InternalDbTextEditor.g:1247:1: rule__Field__Group__1__Impl : ( '(' ) ;
    public final void rule__Field__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1251:1: ( ( '(' ) )
            // InternalDbTextEditor.g:1252:1: ( '(' )
            {
            // InternalDbTextEditor.g:1252:1: ( '(' )
            // InternalDbTextEditor.g:1253:2: '('
            {
             before(grammarAccess.getFieldAccess().getLeftParenthesisKeyword_1()); 
            match(input,126,FOLLOW_2); 
             after(grammarAccess.getFieldAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__1__Impl"


    // $ANTLR start "rule__Field__Group__2"
    // InternalDbTextEditor.g:1262:1: rule__Field__Group__2 : rule__Field__Group__2__Impl rule__Field__Group__3 ;
    public final void rule__Field__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1266:1: ( rule__Field__Group__2__Impl rule__Field__Group__3 )
            // InternalDbTextEditor.g:1267:2: rule__Field__Group__2__Impl rule__Field__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Field__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Field__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__2"


    // $ANTLR start "rule__Field__Group__2__Impl"
    // InternalDbTextEditor.g:1274:1: rule__Field__Group__2__Impl : ( ( rule__Field__FieldnameAssignment_2 ) ) ;
    public final void rule__Field__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1278:1: ( ( ( rule__Field__FieldnameAssignment_2 ) ) )
            // InternalDbTextEditor.g:1279:1: ( ( rule__Field__FieldnameAssignment_2 ) )
            {
            // InternalDbTextEditor.g:1279:1: ( ( rule__Field__FieldnameAssignment_2 ) )
            // InternalDbTextEditor.g:1280:2: ( rule__Field__FieldnameAssignment_2 )
            {
             before(grammarAccess.getFieldAccess().getFieldnameAssignment_2()); 
            // InternalDbTextEditor.g:1281:2: ( rule__Field__FieldnameAssignment_2 )
            // InternalDbTextEditor.g:1281:3: rule__Field__FieldnameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Field__FieldnameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFieldAccess().getFieldnameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__2__Impl"


    // $ANTLR start "rule__Field__Group__3"
    // InternalDbTextEditor.g:1289:1: rule__Field__Group__3 : rule__Field__Group__3__Impl rule__Field__Group__4 ;
    public final void rule__Field__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1293:1: ( rule__Field__Group__3__Impl rule__Field__Group__4 )
            // InternalDbTextEditor.g:1294:2: rule__Field__Group__3__Impl rule__Field__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__Field__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Field__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__3"


    // $ANTLR start "rule__Field__Group__3__Impl"
    // InternalDbTextEditor.g:1301:1: rule__Field__Group__3__Impl : ( ',' ) ;
    public final void rule__Field__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1305:1: ( ( ',' ) )
            // InternalDbTextEditor.g:1306:1: ( ',' )
            {
            // InternalDbTextEditor.g:1306:1: ( ',' )
            // InternalDbTextEditor.g:1307:2: ','
            {
             before(grammarAccess.getFieldAccess().getCommaKeyword_3()); 
            match(input,127,FOLLOW_2); 
             after(grammarAccess.getFieldAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__3__Impl"


    // $ANTLR start "rule__Field__Group__4"
    // InternalDbTextEditor.g:1316:1: rule__Field__Group__4 : rule__Field__Group__4__Impl rule__Field__Group__5 ;
    public final void rule__Field__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1320:1: ( rule__Field__Group__4__Impl rule__Field__Group__5 )
            // InternalDbTextEditor.g:1321:2: rule__Field__Group__4__Impl rule__Field__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__Field__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Field__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__4"


    // $ANTLR start "rule__Field__Group__4__Impl"
    // InternalDbTextEditor.g:1328:1: rule__Field__Group__4__Impl : ( ( rule__Field__Alternatives_4 ) ) ;
    public final void rule__Field__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1332:1: ( ( ( rule__Field__Alternatives_4 ) ) )
            // InternalDbTextEditor.g:1333:1: ( ( rule__Field__Alternatives_4 ) )
            {
            // InternalDbTextEditor.g:1333:1: ( ( rule__Field__Alternatives_4 ) )
            // InternalDbTextEditor.g:1334:2: ( rule__Field__Alternatives_4 )
            {
             before(grammarAccess.getFieldAccess().getAlternatives_4()); 
            // InternalDbTextEditor.g:1335:2: ( rule__Field__Alternatives_4 )
            // InternalDbTextEditor.g:1335:3: rule__Field__Alternatives_4
            {
            pushFollow(FOLLOW_2);
            rule__Field__Alternatives_4();

            state._fsp--;


            }

             after(grammarAccess.getFieldAccess().getAlternatives_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__4__Impl"


    // $ANTLR start "rule__Field__Group__5"
    // InternalDbTextEditor.g:1343:1: rule__Field__Group__5 : rule__Field__Group__5__Impl ;
    public final void rule__Field__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1347:1: ( rule__Field__Group__5__Impl )
            // InternalDbTextEditor.g:1348:2: rule__Field__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Field__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__5"


    // $ANTLR start "rule__Field__Group__5__Impl"
    // InternalDbTextEditor.g:1354:1: rule__Field__Group__5__Impl : ( ')' ) ;
    public final void rule__Field__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1358:1: ( ( ')' ) )
            // InternalDbTextEditor.g:1359:1: ( ')' )
            {
            // InternalDbTextEditor.g:1359:1: ( ')' )
            // InternalDbTextEditor.g:1360:2: ')'
            {
             before(grammarAccess.getFieldAccess().getRightParenthesisKeyword_5()); 
            match(input,128,FOLLOW_2); 
             after(grammarAccess.getFieldAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__5__Impl"


    // $ANTLR start "rule__Info__Group__0"
    // InternalDbTextEditor.g:1370:1: rule__Info__Group__0 : rule__Info__Group__0__Impl rule__Info__Group__1 ;
    public final void rule__Info__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1374:1: ( rule__Info__Group__0__Impl rule__Info__Group__1 )
            // InternalDbTextEditor.g:1375:2: rule__Info__Group__0__Impl rule__Info__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Info__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Info__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Info__Group__0"


    // $ANTLR start "rule__Info__Group__0__Impl"
    // InternalDbTextEditor.g:1382:1: rule__Info__Group__0__Impl : ( 'info' ) ;
    public final void rule__Info__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1386:1: ( ( 'info' ) )
            // InternalDbTextEditor.g:1387:1: ( 'info' )
            {
            // InternalDbTextEditor.g:1387:1: ( 'info' )
            // InternalDbTextEditor.g:1388:2: 'info'
            {
             before(grammarAccess.getInfoAccess().getInfoKeyword_0()); 
            match(input,131,FOLLOW_2); 
             after(grammarAccess.getInfoAccess().getInfoKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Info__Group__0__Impl"


    // $ANTLR start "rule__Info__Group__1"
    // InternalDbTextEditor.g:1397:1: rule__Info__Group__1 : rule__Info__Group__1__Impl rule__Info__Group__2 ;
    public final void rule__Info__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1401:1: ( rule__Info__Group__1__Impl rule__Info__Group__2 )
            // InternalDbTextEditor.g:1402:2: rule__Info__Group__1__Impl rule__Info__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__Info__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Info__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Info__Group__1"


    // $ANTLR start "rule__Info__Group__1__Impl"
    // InternalDbTextEditor.g:1409:1: rule__Info__Group__1__Impl : ( '(' ) ;
    public final void rule__Info__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1413:1: ( ( '(' ) )
            // InternalDbTextEditor.g:1414:1: ( '(' )
            {
            // InternalDbTextEditor.g:1414:1: ( '(' )
            // InternalDbTextEditor.g:1415:2: '('
            {
             before(grammarAccess.getInfoAccess().getLeftParenthesisKeyword_1()); 
            match(input,126,FOLLOW_2); 
             after(grammarAccess.getInfoAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Info__Group__1__Impl"


    // $ANTLR start "rule__Info__Group__2"
    // InternalDbTextEditor.g:1424:1: rule__Info__Group__2 : rule__Info__Group__2__Impl rule__Info__Group__3 ;
    public final void rule__Info__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1428:1: ( rule__Info__Group__2__Impl rule__Info__Group__3 )
            // InternalDbTextEditor.g:1429:2: rule__Info__Group__2__Impl rule__Info__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Info__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Info__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Info__Group__2"


    // $ANTLR start "rule__Info__Group__2__Impl"
    // InternalDbTextEditor.g:1436:1: rule__Info__Group__2__Impl : ( ( rule__Info__NameAssignment_2 ) ) ;
    public final void rule__Info__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1440:1: ( ( ( rule__Info__NameAssignment_2 ) ) )
            // InternalDbTextEditor.g:1441:1: ( ( rule__Info__NameAssignment_2 ) )
            {
            // InternalDbTextEditor.g:1441:1: ( ( rule__Info__NameAssignment_2 ) )
            // InternalDbTextEditor.g:1442:2: ( rule__Info__NameAssignment_2 )
            {
             before(grammarAccess.getInfoAccess().getNameAssignment_2()); 
            // InternalDbTextEditor.g:1443:2: ( rule__Info__NameAssignment_2 )
            // InternalDbTextEditor.g:1443:3: rule__Info__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Info__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getInfoAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Info__Group__2__Impl"


    // $ANTLR start "rule__Info__Group__3"
    // InternalDbTextEditor.g:1451:1: rule__Info__Group__3 : rule__Info__Group__3__Impl rule__Info__Group__4 ;
    public final void rule__Info__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1455:1: ( rule__Info__Group__3__Impl rule__Info__Group__4 )
            // InternalDbTextEditor.g:1456:2: rule__Info__Group__3__Impl rule__Info__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Info__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Info__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Info__Group__3"


    // $ANTLR start "rule__Info__Group__3__Impl"
    // InternalDbTextEditor.g:1463:1: rule__Info__Group__3__Impl : ( ',' ) ;
    public final void rule__Info__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1467:1: ( ( ',' ) )
            // InternalDbTextEditor.g:1468:1: ( ',' )
            {
            // InternalDbTextEditor.g:1468:1: ( ',' )
            // InternalDbTextEditor.g:1469:2: ','
            {
             before(grammarAccess.getInfoAccess().getCommaKeyword_3()); 
            match(input,127,FOLLOW_2); 
             after(grammarAccess.getInfoAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Info__Group__3__Impl"


    // $ANTLR start "rule__Info__Group__4"
    // InternalDbTextEditor.g:1478:1: rule__Info__Group__4 : rule__Info__Group__4__Impl rule__Info__Group__5 ;
    public final void rule__Info__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1482:1: ( rule__Info__Group__4__Impl rule__Info__Group__5 )
            // InternalDbTextEditor.g:1483:2: rule__Info__Group__4__Impl rule__Info__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__Info__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Info__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Info__Group__4"


    // $ANTLR start "rule__Info__Group__4__Impl"
    // InternalDbTextEditor.g:1490:1: rule__Info__Group__4__Impl : ( ( rule__Info__InfoValueAssignment_4 ) ) ;
    public final void rule__Info__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1494:1: ( ( ( rule__Info__InfoValueAssignment_4 ) ) )
            // InternalDbTextEditor.g:1495:1: ( ( rule__Info__InfoValueAssignment_4 ) )
            {
            // InternalDbTextEditor.g:1495:1: ( ( rule__Info__InfoValueAssignment_4 ) )
            // InternalDbTextEditor.g:1496:2: ( rule__Info__InfoValueAssignment_4 )
            {
             before(grammarAccess.getInfoAccess().getInfoValueAssignment_4()); 
            // InternalDbTextEditor.g:1497:2: ( rule__Info__InfoValueAssignment_4 )
            // InternalDbTextEditor.g:1497:3: rule__Info__InfoValueAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Info__InfoValueAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getInfoAccess().getInfoValueAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Info__Group__4__Impl"


    // $ANTLR start "rule__Info__Group__5"
    // InternalDbTextEditor.g:1505:1: rule__Info__Group__5 : rule__Info__Group__5__Impl ;
    public final void rule__Info__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1509:1: ( rule__Info__Group__5__Impl )
            // InternalDbTextEditor.g:1510:2: rule__Info__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Info__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Info__Group__5"


    // $ANTLR start "rule__Info__Group__5__Impl"
    // InternalDbTextEditor.g:1516:1: rule__Info__Group__5__Impl : ( ')' ) ;
    public final void rule__Info__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1520:1: ( ( ')' ) )
            // InternalDbTextEditor.g:1521:1: ( ')' )
            {
            // InternalDbTextEditor.g:1521:1: ( ')' )
            // InternalDbTextEditor.g:1522:2: ')'
            {
             before(grammarAccess.getInfoAccess().getRightParenthesisKeyword_5()); 
            match(input,128,FOLLOW_2); 
             after(grammarAccess.getInfoAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Info__Group__5__Impl"


    // $ANTLR start "rule__DOUBLE__Group__0"
    // InternalDbTextEditor.g:1532:1: rule__DOUBLE__Group__0 : rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 ;
    public final void rule__DOUBLE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1536:1: ( rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 )
            // InternalDbTextEditor.g:1537:2: rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__DOUBLE__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DOUBLE__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__0"


    // $ANTLR start "rule__DOUBLE__Group__0__Impl"
    // InternalDbTextEditor.g:1544:1: rule__DOUBLE__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__DOUBLE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1548:1: ( ( RULE_INT ) )
            // InternalDbTextEditor.g:1549:1: ( RULE_INT )
            {
            // InternalDbTextEditor.g:1549:1: ( RULE_INT )
            // InternalDbTextEditor.g:1550:2: RULE_INT
            {
             before(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__0__Impl"


    // $ANTLR start "rule__DOUBLE__Group__1"
    // InternalDbTextEditor.g:1559:1: rule__DOUBLE__Group__1 : rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2 ;
    public final void rule__DOUBLE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1563:1: ( rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2 )
            // InternalDbTextEditor.g:1564:2: rule__DOUBLE__Group__1__Impl rule__DOUBLE__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__DOUBLE__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DOUBLE__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__1"


    // $ANTLR start "rule__DOUBLE__Group__1__Impl"
    // InternalDbTextEditor.g:1571:1: rule__DOUBLE__Group__1__Impl : ( '.' ) ;
    public final void rule__DOUBLE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1575:1: ( ( '.' ) )
            // InternalDbTextEditor.g:1576:1: ( '.' )
            {
            // InternalDbTextEditor.g:1576:1: ( '.' )
            // InternalDbTextEditor.g:1577:2: '.'
            {
             before(grammarAccess.getDOUBLEAccess().getFullStopKeyword_1()); 
            match(input,132,FOLLOW_2); 
             after(grammarAccess.getDOUBLEAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__1__Impl"


    // $ANTLR start "rule__DOUBLE__Group__2"
    // InternalDbTextEditor.g:1586:1: rule__DOUBLE__Group__2 : rule__DOUBLE__Group__2__Impl ;
    public final void rule__DOUBLE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1590:1: ( rule__DOUBLE__Group__2__Impl )
            // InternalDbTextEditor.g:1591:2: rule__DOUBLE__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DOUBLE__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__2"


    // $ANTLR start "rule__DOUBLE__Group__2__Impl"
    // InternalDbTextEditor.g:1597:1: rule__DOUBLE__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__DOUBLE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1601:1: ( ( RULE_INT ) )
            // InternalDbTextEditor.g:1602:1: ( RULE_INT )
            {
            // InternalDbTextEditor.g:1602:1: ( RULE_INT )
            // InternalDbTextEditor.g:1603:2: RULE_INT
            {
             before(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_2()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__2__Impl"


    // $ANTLR start "rule__DbModel__RecordsAssignment"
    // InternalDbTextEditor.g:1613:1: rule__DbModel__RecordsAssignment : ( ruleRecord ) ;
    public final void rule__DbModel__RecordsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1617:1: ( ( ruleRecord ) )
            // InternalDbTextEditor.g:1618:2: ( ruleRecord )
            {
            // InternalDbTextEditor.g:1618:2: ( ruleRecord )
            // InternalDbTextEditor.g:1619:3: ruleRecord
            {
             before(grammarAccess.getDbModelAccess().getRecordsRecordParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleRecord();

            state._fsp--;

             after(grammarAccess.getDbModelAccess().getRecordsRecordParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DbModel__RecordsAssignment"


    // $ANTLR start "rule__Record__NameAssignment_0"
    // InternalDbTextEditor.g:1628:1: rule__Record__NameAssignment_0 : ( ( 'record' ) ) ;
    public final void rule__Record__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1632:1: ( ( ( 'record' ) ) )
            // InternalDbTextEditor.g:1633:2: ( ( 'record' ) )
            {
            // InternalDbTextEditor.g:1633:2: ( ( 'record' ) )
            // InternalDbTextEditor.g:1634:3: ( 'record' )
            {
             before(grammarAccess.getRecordAccess().getNameRecordKeyword_0_0()); 
            // InternalDbTextEditor.g:1635:3: ( 'record' )
            // InternalDbTextEditor.g:1636:4: 'record'
            {
             before(grammarAccess.getRecordAccess().getNameRecordKeyword_0_0()); 
            match(input,133,FOLLOW_2); 
             after(grammarAccess.getRecordAccess().getNameRecordKeyword_0_0()); 

            }

             after(grammarAccess.getRecordAccess().getNameRecordKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__NameAssignment_0"


    // $ANTLR start "rule__Record__RecordnameAssignment_2"
    // InternalDbTextEditor.g:1647:1: rule__Record__RecordnameAssignment_2 : ( ruleRecordnames ) ;
    public final void rule__Record__RecordnameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1651:1: ( ( ruleRecordnames ) )
            // InternalDbTextEditor.g:1652:2: ( ruleRecordnames )
            {
            // InternalDbTextEditor.g:1652:2: ( ruleRecordnames )
            // InternalDbTextEditor.g:1653:3: ruleRecordnames
            {
             before(grammarAccess.getRecordAccess().getRecordnameRecordnamesEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleRecordnames();

            state._fsp--;

             after(grammarAccess.getRecordAccess().getRecordnameRecordnamesEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__RecordnameAssignment_2"


    // $ANTLR start "rule__Record__RecordLinkAssignment_4"
    // InternalDbTextEditor.g:1662:1: rule__Record__RecordLinkAssignment_4 : ( RULE_STRING ) ;
    public final void rule__Record__RecordLinkAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1666:1: ( ( RULE_STRING ) )
            // InternalDbTextEditor.g:1667:2: ( RULE_STRING )
            {
            // InternalDbTextEditor.g:1667:2: ( RULE_STRING )
            // InternalDbTextEditor.g:1668:3: RULE_STRING
            {
             before(grammarAccess.getRecordAccess().getRecordLinkSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getRecordAccess().getRecordLinkSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__RecordLinkAssignment_4"


    // $ANTLR start "rule__Record__InfosfieldsAssignment_7"
    // InternalDbTextEditor.g:1677:1: rule__Record__InfosfieldsAssignment_7 : ( ( rule__Record__InfosfieldsAlternatives_7_0 ) ) ;
    public final void rule__Record__InfosfieldsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1681:1: ( ( ( rule__Record__InfosfieldsAlternatives_7_0 ) ) )
            // InternalDbTextEditor.g:1682:2: ( ( rule__Record__InfosfieldsAlternatives_7_0 ) )
            {
            // InternalDbTextEditor.g:1682:2: ( ( rule__Record__InfosfieldsAlternatives_7_0 ) )
            // InternalDbTextEditor.g:1683:3: ( rule__Record__InfosfieldsAlternatives_7_0 )
            {
             before(grammarAccess.getRecordAccess().getInfosfieldsAlternatives_7_0()); 
            // InternalDbTextEditor.g:1684:3: ( rule__Record__InfosfieldsAlternatives_7_0 )
            // InternalDbTextEditor.g:1684:4: rule__Record__InfosfieldsAlternatives_7_0
            {
            pushFollow(FOLLOW_2);
            rule__Record__InfosfieldsAlternatives_7_0();

            state._fsp--;


            }

             after(grammarAccess.getRecordAccess().getInfosfieldsAlternatives_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Record__InfosfieldsAssignment_7"


    // $ANTLR start "rule__Field__NameAssignment_0"
    // InternalDbTextEditor.g:1692:1: rule__Field__NameAssignment_0 : ( ( 'field' ) ) ;
    public final void rule__Field__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1696:1: ( ( ( 'field' ) ) )
            // InternalDbTextEditor.g:1697:2: ( ( 'field' ) )
            {
            // InternalDbTextEditor.g:1697:2: ( ( 'field' ) )
            // InternalDbTextEditor.g:1698:3: ( 'field' )
            {
             before(grammarAccess.getFieldAccess().getNameFieldKeyword_0_0()); 
            // InternalDbTextEditor.g:1699:3: ( 'field' )
            // InternalDbTextEditor.g:1700:4: 'field'
            {
             before(grammarAccess.getFieldAccess().getNameFieldKeyword_0_0()); 
            match(input,134,FOLLOW_2); 
             after(grammarAccess.getFieldAccess().getNameFieldKeyword_0_0()); 

            }

             after(grammarAccess.getFieldAccess().getNameFieldKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__NameAssignment_0"


    // $ANTLR start "rule__Field__FieldnameAssignment_2"
    // InternalDbTextEditor.g:1711:1: rule__Field__FieldnameAssignment_2 : ( ruleFieldnames ) ;
    public final void rule__Field__FieldnameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1715:1: ( ( ruleFieldnames ) )
            // InternalDbTextEditor.g:1716:2: ( ruleFieldnames )
            {
            // InternalDbTextEditor.g:1716:2: ( ruleFieldnames )
            // InternalDbTextEditor.g:1717:3: ruleFieldnames
            {
             before(grammarAccess.getFieldAccess().getFieldnameFieldnamesEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleFieldnames();

            state._fsp--;

             after(grammarAccess.getFieldAccess().getFieldnameFieldnamesEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__FieldnameAssignment_2"


    // $ANTLR start "rule__Field__FieldstringAssignment_4_0"
    // InternalDbTextEditor.g:1726:1: rule__Field__FieldstringAssignment_4_0 : ( RULE_STRING ) ;
    public final void rule__Field__FieldstringAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1730:1: ( ( RULE_STRING ) )
            // InternalDbTextEditor.g:1731:2: ( RULE_STRING )
            {
            // InternalDbTextEditor.g:1731:2: ( RULE_STRING )
            // InternalDbTextEditor.g:1732:3: RULE_STRING
            {
             before(grammarAccess.getFieldAccess().getFieldstringSTRINGTerminalRuleCall_4_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getFieldAccess().getFieldstringSTRINGTerminalRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__FieldstringAssignment_4_0"


    // $ANTLR start "rule__Field__FieldintAssignment_4_1"
    // InternalDbTextEditor.g:1741:1: rule__Field__FieldintAssignment_4_1 : ( RULE_INT ) ;
    public final void rule__Field__FieldintAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1745:1: ( ( RULE_INT ) )
            // InternalDbTextEditor.g:1746:2: ( RULE_INT )
            {
            // InternalDbTextEditor.g:1746:2: ( RULE_INT )
            // InternalDbTextEditor.g:1747:3: RULE_INT
            {
             before(grammarAccess.getFieldAccess().getFieldintINTTerminalRuleCall_4_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getFieldAccess().getFieldintINTTerminalRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__FieldintAssignment_4_1"


    // $ANTLR start "rule__Field__FielddoubleAssignment_4_2"
    // InternalDbTextEditor.g:1756:1: rule__Field__FielddoubleAssignment_4_2 : ( ruleDOUBLE ) ;
    public final void rule__Field__FielddoubleAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1760:1: ( ( ruleDOUBLE ) )
            // InternalDbTextEditor.g:1761:2: ( ruleDOUBLE )
            {
            // InternalDbTextEditor.g:1761:2: ( ruleDOUBLE )
            // InternalDbTextEditor.g:1762:3: ruleDOUBLE
            {
             before(grammarAccess.getFieldAccess().getFielddoubleDOUBLEParserRuleCall_4_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDOUBLE();

            state._fsp--;

             after(grammarAccess.getFieldAccess().getFielddoubleDOUBLEParserRuleCall_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__FielddoubleAssignment_4_2"


    // $ANTLR start "rule__Info__NameAssignment_2"
    // InternalDbTextEditor.g:1771:1: rule__Info__NameAssignment_2 : ( ( 'asyn:READBACK' ) ) ;
    public final void rule__Info__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1775:1: ( ( ( 'asyn:READBACK' ) ) )
            // InternalDbTextEditor.g:1776:2: ( ( 'asyn:READBACK' ) )
            {
            // InternalDbTextEditor.g:1776:2: ( ( 'asyn:READBACK' ) )
            // InternalDbTextEditor.g:1777:3: ( 'asyn:READBACK' )
            {
             before(grammarAccess.getInfoAccess().getNameAsynREADBACKKeyword_2_0()); 
            // InternalDbTextEditor.g:1778:3: ( 'asyn:READBACK' )
            // InternalDbTextEditor.g:1779:4: 'asyn:READBACK'
            {
             before(grammarAccess.getInfoAccess().getNameAsynREADBACKKeyword_2_0()); 
            match(input,135,FOLLOW_2); 
             after(grammarAccess.getInfoAccess().getNameAsynREADBACKKeyword_2_0()); 

            }

             after(grammarAccess.getInfoAccess().getNameAsynREADBACKKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Info__NameAssignment_2"


    // $ANTLR start "rule__Info__InfoValueAssignment_4"
    // InternalDbTextEditor.g:1790:1: rule__Info__InfoValueAssignment_4 : ( RULE_STRING ) ;
    public final void rule__Info__InfoValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbTextEditor.g:1794:1: ( ( RULE_STRING ) )
            // InternalDbTextEditor.g:1795:2: ( RULE_STRING )
            {
            // InternalDbTextEditor.g:1795:2: ( RULE_STRING )
            // InternalDbTextEditor.g:1796:3: RULE_STRING
            {
             before(grammarAccess.getInfoAccess().getInfoValueSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getInfoAccess().getInfoValueSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Info__InfoValueAssignment_4"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x3FFFF00000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x000000000000004CL});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0xFFFFFFFFFFFFF800L,0x00000FFFFFFFFFFFL});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000010L});

}