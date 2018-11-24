package org.csstudio.xtext.dbtexteditor.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.csstudio.xtext.dbtexteditor.services.DbTextEditorGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDbTextEditorParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INT", "RULE_SL_COMMENT", "RULE_ID", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'record'", "'('", "','", "')'", "'{'", "'}'", "'field'", "'info'", "'asyn:READBACK'", "'.'", "'NAME'", "'DESC'", "'ASG'", "'SCAN'", "'PHAS'", "'PINI'", "'SDIS'", "'PROC'", "'PACT'", "'SEVR'", "'STAT'", "'TIME'", "'DTYP'", "'ONAM'", "'OSV'", "'OUT'", "'SIML'", "'ZNAM'", "'ZSV'", "'INP'", "'EGU'", "'LINR'", "'EGUL'", "'EGUF'", "'HIGH'", "'HSV'", "'HIHI'", "'HHSV'", "'EIST'", "'EISV'", "'EIVL'", "'ELST'", "'ELSV'", "'ELVL'", "'FRST'", "'FRSV'", "'FRVL'", "'FVST'", "'HYST'", "'LLSV'", "'FVSV'", "'FVVL'", "'MASK'", "'NIST'", "'NISV'", "'NIVL'", "'NOBT'", "'ONST'", "'ONSV'", "'ONVL'", "'SHFT'", "'SVST'", "'SVSV'", "'SVVL'", "'SXST'", "'SXSV'", "'SXVL'", "'TEST'", "'TESV'", "'TEVL'", "'THST'", "'THSV'", "'THVL'", "'TWST'", "'TWSV'", "'TWVL'", "'UNSV'", "'ZRST'", "'ZRSV'", "'ZRVL'", "'LOLO'", "'LOW'", "'LSV'", "'SSCN'", "'TSE'", "'PREC'", "'DRVH'", "'LOPR'", "'DRVL'", "'HOPR'", "'CALC'", "'INPA'", "'INPB'", "'INPC'", "'INPD'", "'FLNK'", "'INPE'", "'INPF'", "'INPG'", "'INPH'", "'INPI'", "'INPJ'", "'INPK'", "'INAA'", "'INBB'", "'INCC'", "'SIOL'", "'ai'", "'ao'", "'longin'", "'longout'", "'stringin'", "'stringout'", "'lsi'", "'lso'", "'waveform'", "'bi'", "'bo'", "'mbbi'", "'mbbo'", "'mbbiDirect'", "'mbboDirect'", "'calcout'", "'scalcout'", "'calc'"
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
    public static final int RULE_INT=5;
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
    public static final int RULE_STRING=4;
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

        public InternalDbTextEditorParser(TokenStream input, DbTextEditorGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "dbModel";
       	}

       	@Override
       	protected DbTextEditorGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuledbModel"
    // InternalDbTextEditor.g:65:1: entryRuledbModel returns [EObject current=null] : iv_ruledbModel= ruledbModel EOF ;
    public final EObject entryRuledbModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruledbModel = null;


        try {
            // InternalDbTextEditor.g:65:48: (iv_ruledbModel= ruledbModel EOF )
            // InternalDbTextEditor.g:66:2: iv_ruledbModel= ruledbModel EOF
            {
             newCompositeNode(grammarAccess.getDbModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruledbModel=ruledbModel();

            state._fsp--;

             current =iv_ruledbModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuledbModel"


    // $ANTLR start "ruledbModel"
    // InternalDbTextEditor.g:72:1: ruledbModel returns [EObject current=null] : ( (lv_records_0_0= ruleRecord ) )* ;
    public final EObject ruledbModel() throws RecognitionException {
        EObject current = null;

        EObject lv_records_0_0 = null;



        	enterRule();

        try {
            // InternalDbTextEditor.g:78:2: ( ( (lv_records_0_0= ruleRecord ) )* )
            // InternalDbTextEditor.g:79:2: ( (lv_records_0_0= ruleRecord ) )*
            {
            // InternalDbTextEditor.g:79:2: ( (lv_records_0_0= ruleRecord ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDbTextEditor.g:80:3: (lv_records_0_0= ruleRecord )
            	    {
            	    // InternalDbTextEditor.g:80:3: (lv_records_0_0= ruleRecord )
            	    // InternalDbTextEditor.g:81:4: lv_records_0_0= ruleRecord
            	    {

            	    				newCompositeNode(grammarAccess.getDbModelAccess().getRecordsRecordParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_records_0_0=ruleRecord();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getDbModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"records",
            	    					lv_records_0_0,
            	    					"org.csstudio.xtext.dbtexteditor.DbTextEditor.Record");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruledbModel"


    // $ANTLR start "entryRuleRecord"
    // InternalDbTextEditor.g:101:1: entryRuleRecord returns [EObject current=null] : iv_ruleRecord= ruleRecord EOF ;
    public final EObject entryRuleRecord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecord = null;


        try {
            // InternalDbTextEditor.g:101:47: (iv_ruleRecord= ruleRecord EOF )
            // InternalDbTextEditor.g:102:2: iv_ruleRecord= ruleRecord EOF
            {
             newCompositeNode(grammarAccess.getRecordRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRecord=ruleRecord();

            state._fsp--;

             current =iv_ruleRecord; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRecord"


    // $ANTLR start "ruleRecord"
    // InternalDbTextEditor.g:108:1: ruleRecord returns [EObject current=null] : ( ( (lv_name_0_0= 'record' ) ) otherlv_1= '(' ( (lv_recordname_2_0= ruleRecordnames ) ) otherlv_3= ',' ( (lv_recordLink_4_0= RULE_STRING ) ) otherlv_5= ')' otherlv_6= '{' ( ( (lv_infosfields_7_1= ruleInfo | lv_infosfields_7_2= ruleField ) ) )* otherlv_8= '}' ) ;
    public final EObject ruleRecord() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_recordLink_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Enumerator lv_recordname_2_0 = null;

        EObject lv_infosfields_7_1 = null;

        EObject lv_infosfields_7_2 = null;



        	enterRule();

        try {
            // InternalDbTextEditor.g:114:2: ( ( ( (lv_name_0_0= 'record' ) ) otherlv_1= '(' ( (lv_recordname_2_0= ruleRecordnames ) ) otherlv_3= ',' ( (lv_recordLink_4_0= RULE_STRING ) ) otherlv_5= ')' otherlv_6= '{' ( ( (lv_infosfields_7_1= ruleInfo | lv_infosfields_7_2= ruleField ) ) )* otherlv_8= '}' ) )
            // InternalDbTextEditor.g:115:2: ( ( (lv_name_0_0= 'record' ) ) otherlv_1= '(' ( (lv_recordname_2_0= ruleRecordnames ) ) otherlv_3= ',' ( (lv_recordLink_4_0= RULE_STRING ) ) otherlv_5= ')' otherlv_6= '{' ( ( (lv_infosfields_7_1= ruleInfo | lv_infosfields_7_2= ruleField ) ) )* otherlv_8= '}' )
            {
            // InternalDbTextEditor.g:115:2: ( ( (lv_name_0_0= 'record' ) ) otherlv_1= '(' ( (lv_recordname_2_0= ruleRecordnames ) ) otherlv_3= ',' ( (lv_recordLink_4_0= RULE_STRING ) ) otherlv_5= ')' otherlv_6= '{' ( ( (lv_infosfields_7_1= ruleInfo | lv_infosfields_7_2= ruleField ) ) )* otherlv_8= '}' )
            // InternalDbTextEditor.g:116:3: ( (lv_name_0_0= 'record' ) ) otherlv_1= '(' ( (lv_recordname_2_0= ruleRecordnames ) ) otherlv_3= ',' ( (lv_recordLink_4_0= RULE_STRING ) ) otherlv_5= ')' otherlv_6= '{' ( ( (lv_infosfields_7_1= ruleInfo | lv_infosfields_7_2= ruleField ) ) )* otherlv_8= '}'
            {
            // InternalDbTextEditor.g:116:3: ( (lv_name_0_0= 'record' ) )
            // InternalDbTextEditor.g:117:4: (lv_name_0_0= 'record' )
            {
            // InternalDbTextEditor.g:117:4: (lv_name_0_0= 'record' )
            // InternalDbTextEditor.g:118:5: lv_name_0_0= 'record'
            {
            lv_name_0_0=(Token)match(input,11,FOLLOW_4); 

            					newLeafNode(lv_name_0_0, grammarAccess.getRecordAccess().getNameRecordKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRecordRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "record");
            				

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getRecordAccess().getLeftParenthesisKeyword_1());
            		
            // InternalDbTextEditor.g:134:3: ( (lv_recordname_2_0= ruleRecordnames ) )
            // InternalDbTextEditor.g:135:4: (lv_recordname_2_0= ruleRecordnames )
            {
            // InternalDbTextEditor.g:135:4: (lv_recordname_2_0= ruleRecordnames )
            // InternalDbTextEditor.g:136:5: lv_recordname_2_0= ruleRecordnames
            {

            					newCompositeNode(grammarAccess.getRecordAccess().getRecordnameRecordnamesEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_6);
            lv_recordname_2_0=ruleRecordnames();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRecordRule());
            					}
            					set(
            						current,
            						"recordname",
            						lv_recordname_2_0,
            						"org.csstudio.xtext.dbtexteditor.DbTextEditor.Recordnames");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getRecordAccess().getCommaKeyword_3());
            		
            // InternalDbTextEditor.g:157:3: ( (lv_recordLink_4_0= RULE_STRING ) )
            // InternalDbTextEditor.g:158:4: (lv_recordLink_4_0= RULE_STRING )
            {
            // InternalDbTextEditor.g:158:4: (lv_recordLink_4_0= RULE_STRING )
            // InternalDbTextEditor.g:159:5: lv_recordLink_4_0= RULE_STRING
            {
            lv_recordLink_4_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            					newLeafNode(lv_recordLink_4_0, grammarAccess.getRecordAccess().getRecordLinkSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRecordRule());
            					}
            					setWithLastConsumed(
            						current,
            						"recordLink",
            						lv_recordLink_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,14,FOLLOW_9); 

            			newLeafNode(otherlv_5, grammarAccess.getRecordAccess().getRightParenthesisKeyword_5());
            		
            otherlv_6=(Token)match(input,15,FOLLOW_10); 

            			newLeafNode(otherlv_6, grammarAccess.getRecordAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalDbTextEditor.g:183:3: ( ( (lv_infosfields_7_1= ruleInfo | lv_infosfields_7_2= ruleField ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=17 && LA3_0<=18)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalDbTextEditor.g:184:4: ( (lv_infosfields_7_1= ruleInfo | lv_infosfields_7_2= ruleField ) )
            	    {
            	    // InternalDbTextEditor.g:184:4: ( (lv_infosfields_7_1= ruleInfo | lv_infosfields_7_2= ruleField ) )
            	    // InternalDbTextEditor.g:185:5: (lv_infosfields_7_1= ruleInfo | lv_infosfields_7_2= ruleField )
            	    {
            	    // InternalDbTextEditor.g:185:5: (lv_infosfields_7_1= ruleInfo | lv_infosfields_7_2= ruleField )
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==18) ) {
            	        alt2=1;
            	    }
            	    else if ( (LA2_0==17) ) {
            	        alt2=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // InternalDbTextEditor.g:186:6: lv_infosfields_7_1= ruleInfo
            	            {

            	            						newCompositeNode(grammarAccess.getRecordAccess().getInfosfieldsInfoParserRuleCall_7_0_0());
            	            					
            	            pushFollow(FOLLOW_10);
            	            lv_infosfields_7_1=ruleInfo();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getRecordRule());
            	            						}
            	            						add(
            	            							current,
            	            							"infosfields",
            	            							lv_infosfields_7_1,
            	            							"org.csstudio.xtext.dbtexteditor.DbTextEditor.Info");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // InternalDbTextEditor.g:202:6: lv_infosfields_7_2= ruleField
            	            {

            	            						newCompositeNode(grammarAccess.getRecordAccess().getInfosfieldsFieldParserRuleCall_7_0_1());
            	            					
            	            pushFollow(FOLLOW_10);
            	            lv_infosfields_7_2=ruleField();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getRecordRule());
            	            						}
            	            						add(
            	            							current,
            	            							"infosfields",
            	            							lv_infosfields_7_2,
            	            							"org.csstudio.xtext.dbtexteditor.DbTextEditor.Field");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_8=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getRecordAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRecord"


    // $ANTLR start "entryRuleField"
    // InternalDbTextEditor.g:228:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalDbTextEditor.g:228:46: (iv_ruleField= ruleField EOF )
            // InternalDbTextEditor.g:229:2: iv_ruleField= ruleField EOF
            {
             newCompositeNode(grammarAccess.getFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleField=ruleField();

            state._fsp--;

             current =iv_ruleField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // InternalDbTextEditor.g:235:1: ruleField returns [EObject current=null] : ( ( (lv_name_0_0= 'field' ) ) otherlv_1= '(' ( (lv_fieldname_2_0= ruleFieldnames ) ) otherlv_3= ',' ( ( (lv_fieldstring_4_0= RULE_STRING ) ) | ( (lv_fieldint_5_0= RULE_INT ) ) | ( (lv_fielddouble_6_0= ruleDOUBLE ) ) ) otherlv_7= ')' ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_fieldstring_4_0=null;
        Token lv_fieldint_5_0=null;
        Token otherlv_7=null;
        Enumerator lv_fieldname_2_0 = null;

        AntlrDatatypeRuleToken lv_fielddouble_6_0 = null;



        	enterRule();

        try {
            // InternalDbTextEditor.g:241:2: ( ( ( (lv_name_0_0= 'field' ) ) otherlv_1= '(' ( (lv_fieldname_2_0= ruleFieldnames ) ) otherlv_3= ',' ( ( (lv_fieldstring_4_0= RULE_STRING ) ) | ( (lv_fieldint_5_0= RULE_INT ) ) | ( (lv_fielddouble_6_0= ruleDOUBLE ) ) ) otherlv_7= ')' ) )
            // InternalDbTextEditor.g:242:2: ( ( (lv_name_0_0= 'field' ) ) otherlv_1= '(' ( (lv_fieldname_2_0= ruleFieldnames ) ) otherlv_3= ',' ( ( (lv_fieldstring_4_0= RULE_STRING ) ) | ( (lv_fieldint_5_0= RULE_INT ) ) | ( (lv_fielddouble_6_0= ruleDOUBLE ) ) ) otherlv_7= ')' )
            {
            // InternalDbTextEditor.g:242:2: ( ( (lv_name_0_0= 'field' ) ) otherlv_1= '(' ( (lv_fieldname_2_0= ruleFieldnames ) ) otherlv_3= ',' ( ( (lv_fieldstring_4_0= RULE_STRING ) ) | ( (lv_fieldint_5_0= RULE_INT ) ) | ( (lv_fielddouble_6_0= ruleDOUBLE ) ) ) otherlv_7= ')' )
            // InternalDbTextEditor.g:243:3: ( (lv_name_0_0= 'field' ) ) otherlv_1= '(' ( (lv_fieldname_2_0= ruleFieldnames ) ) otherlv_3= ',' ( ( (lv_fieldstring_4_0= RULE_STRING ) ) | ( (lv_fieldint_5_0= RULE_INT ) ) | ( (lv_fielddouble_6_0= ruleDOUBLE ) ) ) otherlv_7= ')'
            {
            // InternalDbTextEditor.g:243:3: ( (lv_name_0_0= 'field' ) )
            // InternalDbTextEditor.g:244:4: (lv_name_0_0= 'field' )
            {
            // InternalDbTextEditor.g:244:4: (lv_name_0_0= 'field' )
            // InternalDbTextEditor.g:245:5: lv_name_0_0= 'field'
            {
            lv_name_0_0=(Token)match(input,17,FOLLOW_4); 

            					newLeafNode(lv_name_0_0, grammarAccess.getFieldAccess().getNameFieldKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFieldRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "field");
            				

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getFieldAccess().getLeftParenthesisKeyword_1());
            		
            // InternalDbTextEditor.g:261:3: ( (lv_fieldname_2_0= ruleFieldnames ) )
            // InternalDbTextEditor.g:262:4: (lv_fieldname_2_0= ruleFieldnames )
            {
            // InternalDbTextEditor.g:262:4: (lv_fieldname_2_0= ruleFieldnames )
            // InternalDbTextEditor.g:263:5: lv_fieldname_2_0= ruleFieldnames
            {

            					newCompositeNode(grammarAccess.getFieldAccess().getFieldnameFieldnamesEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_6);
            lv_fieldname_2_0=ruleFieldnames();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFieldRule());
            					}
            					set(
            						current,
            						"fieldname",
            						lv_fieldname_2_0,
            						"org.csstudio.xtext.dbtexteditor.DbTextEditor.Fieldnames");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_12); 

            			newLeafNode(otherlv_3, grammarAccess.getFieldAccess().getCommaKeyword_3());
            		
            // InternalDbTextEditor.g:284:3: ( ( (lv_fieldstring_4_0= RULE_STRING ) ) | ( (lv_fieldint_5_0= RULE_INT ) ) | ( (lv_fielddouble_6_0= ruleDOUBLE ) ) )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_INT) ) {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==20) ) {
                    alt4=3;
                }
                else if ( (LA4_2==14) ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalDbTextEditor.g:285:4: ( (lv_fieldstring_4_0= RULE_STRING ) )
                    {
                    // InternalDbTextEditor.g:285:4: ( (lv_fieldstring_4_0= RULE_STRING ) )
                    // InternalDbTextEditor.g:286:5: (lv_fieldstring_4_0= RULE_STRING )
                    {
                    // InternalDbTextEditor.g:286:5: (lv_fieldstring_4_0= RULE_STRING )
                    // InternalDbTextEditor.g:287:6: lv_fieldstring_4_0= RULE_STRING
                    {
                    lv_fieldstring_4_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

                    						newLeafNode(lv_fieldstring_4_0, grammarAccess.getFieldAccess().getFieldstringSTRINGTerminalRuleCall_4_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFieldRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"fieldstring",
                    							lv_fieldstring_4_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalDbTextEditor.g:304:4: ( (lv_fieldint_5_0= RULE_INT ) )
                    {
                    // InternalDbTextEditor.g:304:4: ( (lv_fieldint_5_0= RULE_INT ) )
                    // InternalDbTextEditor.g:305:5: (lv_fieldint_5_0= RULE_INT )
                    {
                    // InternalDbTextEditor.g:305:5: (lv_fieldint_5_0= RULE_INT )
                    // InternalDbTextEditor.g:306:6: lv_fieldint_5_0= RULE_INT
                    {
                    lv_fieldint_5_0=(Token)match(input,RULE_INT,FOLLOW_8); 

                    						newLeafNode(lv_fieldint_5_0, grammarAccess.getFieldAccess().getFieldintINTTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFieldRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"fieldint",
                    							lv_fieldint_5_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalDbTextEditor.g:323:4: ( (lv_fielddouble_6_0= ruleDOUBLE ) )
                    {
                    // InternalDbTextEditor.g:323:4: ( (lv_fielddouble_6_0= ruleDOUBLE ) )
                    // InternalDbTextEditor.g:324:5: (lv_fielddouble_6_0= ruleDOUBLE )
                    {
                    // InternalDbTextEditor.g:324:5: (lv_fielddouble_6_0= ruleDOUBLE )
                    // InternalDbTextEditor.g:325:6: lv_fielddouble_6_0= ruleDOUBLE
                    {

                    						newCompositeNode(grammarAccess.getFieldAccess().getFielddoubleDOUBLEParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_fielddouble_6_0=ruleDOUBLE();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFieldRule());
                    						}
                    						set(
                    							current,
                    							"fielddouble",
                    							lv_fielddouble_6_0,
                    							"org.csstudio.xtext.dbtexteditor.DbTextEditor.DOUBLE");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getFieldAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleInfo"
    // InternalDbTextEditor.g:351:1: entryRuleInfo returns [EObject current=null] : iv_ruleInfo= ruleInfo EOF ;
    public final EObject entryRuleInfo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfo = null;


        try {
            // InternalDbTextEditor.g:351:45: (iv_ruleInfo= ruleInfo EOF )
            // InternalDbTextEditor.g:352:2: iv_ruleInfo= ruleInfo EOF
            {
             newCompositeNode(grammarAccess.getInfoRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInfo=ruleInfo();

            state._fsp--;

             current =iv_ruleInfo; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfo"


    // $ANTLR start "ruleInfo"
    // InternalDbTextEditor.g:358:1: ruleInfo returns [EObject current=null] : (otherlv_0= 'info' otherlv_1= '(' ( (lv_name_2_0= 'asyn:READBACK' ) ) otherlv_3= ',' ( (lv_infoValue_4_0= RULE_STRING ) ) otherlv_5= ')' ) ;
    public final EObject ruleInfo() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_infoValue_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalDbTextEditor.g:364:2: ( (otherlv_0= 'info' otherlv_1= '(' ( (lv_name_2_0= 'asyn:READBACK' ) ) otherlv_3= ',' ( (lv_infoValue_4_0= RULE_STRING ) ) otherlv_5= ')' ) )
            // InternalDbTextEditor.g:365:2: (otherlv_0= 'info' otherlv_1= '(' ( (lv_name_2_0= 'asyn:READBACK' ) ) otherlv_3= ',' ( (lv_infoValue_4_0= RULE_STRING ) ) otherlv_5= ')' )
            {
            // InternalDbTextEditor.g:365:2: (otherlv_0= 'info' otherlv_1= '(' ( (lv_name_2_0= 'asyn:READBACK' ) ) otherlv_3= ',' ( (lv_infoValue_4_0= RULE_STRING ) ) otherlv_5= ')' )
            // InternalDbTextEditor.g:366:3: otherlv_0= 'info' otherlv_1= '(' ( (lv_name_2_0= 'asyn:READBACK' ) ) otherlv_3= ',' ( (lv_infoValue_4_0= RULE_STRING ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getInfoAccess().getInfoKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getInfoAccess().getLeftParenthesisKeyword_1());
            		
            // InternalDbTextEditor.g:374:3: ( (lv_name_2_0= 'asyn:READBACK' ) )
            // InternalDbTextEditor.g:375:4: (lv_name_2_0= 'asyn:READBACK' )
            {
            // InternalDbTextEditor.g:375:4: (lv_name_2_0= 'asyn:READBACK' )
            // InternalDbTextEditor.g:376:5: lv_name_2_0= 'asyn:READBACK'
            {
            lv_name_2_0=(Token)match(input,19,FOLLOW_6); 

            					newLeafNode(lv_name_2_0, grammarAccess.getInfoAccess().getNameAsynREADBACKKeyword_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInfoRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_2_0, "asyn:READBACK");
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getInfoAccess().getCommaKeyword_3());
            		
            // InternalDbTextEditor.g:392:3: ( (lv_infoValue_4_0= RULE_STRING ) )
            // InternalDbTextEditor.g:393:4: (lv_infoValue_4_0= RULE_STRING )
            {
            // InternalDbTextEditor.g:393:4: (lv_infoValue_4_0= RULE_STRING )
            // InternalDbTextEditor.g:394:5: lv_infoValue_4_0= RULE_STRING
            {
            lv_infoValue_4_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            					newLeafNode(lv_infoValue_4_0, grammarAccess.getInfoAccess().getInfoValueSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInfoRule());
            					}
            					setWithLastConsumed(
            						current,
            						"infoValue",
            						lv_infoValue_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getInfoAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfo"


    // $ANTLR start "entryRuleDOUBLE"
    // InternalDbTextEditor.g:418:1: entryRuleDOUBLE returns [String current=null] : iv_ruleDOUBLE= ruleDOUBLE EOF ;
    public final String entryRuleDOUBLE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOUBLE = null;


        try {
            // InternalDbTextEditor.g:418:46: (iv_ruleDOUBLE= ruleDOUBLE EOF )
            // InternalDbTextEditor.g:419:2: iv_ruleDOUBLE= ruleDOUBLE EOF
            {
             newCompositeNode(grammarAccess.getDOUBLERule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDOUBLE=ruleDOUBLE();

            state._fsp--;

             current =iv_ruleDOUBLE.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDOUBLE"


    // $ANTLR start "ruleDOUBLE"
    // InternalDbTextEditor.g:425:1: ruleDOUBLE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDOUBLE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalDbTextEditor.g:431:2: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // InternalDbTextEditor.g:432:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // InternalDbTextEditor.g:432:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // InternalDbTextEditor.g:433:3: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_14); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0());
            		
            kw=(Token)match(input,20,FOLLOW_15); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDOUBLEAccess().getFullStopKeyword_1());
            		
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDOUBLE"


    // $ANTLR start "ruleFieldnames"
    // InternalDbTextEditor.g:456:1: ruleFieldnames returns [Enumerator current=null] : ( (enumLiteral_0= 'NAME' ) | (enumLiteral_1= 'DESC' ) | (enumLiteral_2= 'ASG' ) | (enumLiteral_3= 'SCAN' ) | (enumLiteral_4= 'PHAS' ) | (enumLiteral_5= 'PINI' ) | (enumLiteral_6= 'SDIS' ) | (enumLiteral_7= 'PROC' ) | (enumLiteral_8= 'PACT' ) | (enumLiteral_9= 'SEVR' ) | (enumLiteral_10= 'STAT' ) | (enumLiteral_11= 'TIME' ) | (enumLiteral_12= 'DTYP' ) | (enumLiteral_13= 'ONAM' ) | (enumLiteral_14= 'OSV' ) | (enumLiteral_15= 'OUT' ) | (enumLiteral_16= 'SIML' ) | (enumLiteral_17= 'ZNAM' ) | (enumLiteral_18= 'ZSV' ) | (enumLiteral_19= 'INP' ) | (enumLiteral_20= 'EGU' ) | (enumLiteral_21= 'LINR' ) | (enumLiteral_22= 'EGUL' ) | (enumLiteral_23= 'EGUF' ) | (enumLiteral_24= 'HIGH' ) | (enumLiteral_25= 'HSV' ) | (enumLiteral_26= 'HIHI' ) | (enumLiteral_27= 'HHSV' ) | (enumLiteral_28= 'EIST' ) | (enumLiteral_29= 'EISV' ) | (enumLiteral_30= 'EIVL' ) | (enumLiteral_31= 'ELST' ) | (enumLiteral_32= 'ELSV' ) | (enumLiteral_33= 'ELVL' ) | (enumLiteral_34= 'FRST' ) | (enumLiteral_35= 'FRSV' ) | (enumLiteral_36= 'FRVL' ) | (enumLiteral_37= 'FVST' ) | (enumLiteral_38= 'HYST' ) | (enumLiteral_39= 'LLSV' ) | (enumLiteral_40= 'FVSV' ) | (enumLiteral_41= 'FVVL' ) | (enumLiteral_42= 'MASK' ) | (enumLiteral_43= 'NIST' ) | (enumLiteral_44= 'NISV' ) | (enumLiteral_45= 'NIVL' ) | (enumLiteral_46= 'NOBT' ) | (enumLiteral_47= 'ONST' ) | (enumLiteral_48= 'ONSV' ) | (enumLiteral_49= 'ONVL' ) | (enumLiteral_50= 'SHFT' ) | (enumLiteral_51= 'SVST' ) | (enumLiteral_52= 'SVSV' ) | (enumLiteral_53= 'SVVL' ) | (enumLiteral_54= 'SXST' ) | (enumLiteral_55= 'SXSV' ) | (enumLiteral_56= 'SXVL' ) | (enumLiteral_57= 'TEST' ) | (enumLiteral_58= 'TESV' ) | (enumLiteral_59= 'TEVL' ) | (enumLiteral_60= 'THST' ) | (enumLiteral_61= 'THSV' ) | (enumLiteral_62= 'THVL' ) | (enumLiteral_63= 'TWST' ) | (enumLiteral_64= 'TWSV' ) | (enumLiteral_65= 'TWVL' ) | (enumLiteral_66= 'UNSV' ) | (enumLiteral_67= 'ZRST' ) | (enumLiteral_68= 'ZRSV' ) | (enumLiteral_69= 'ZRVL' ) | (enumLiteral_70= 'LOLO' ) | (enumLiteral_71= 'LOW' ) | (enumLiteral_72= 'LSV' ) | (enumLiteral_73= 'SSCN' ) | (enumLiteral_74= 'TSE' ) | (enumLiteral_75= 'PREC' ) | (enumLiteral_76= 'DRVH' ) | (enumLiteral_77= 'LOPR' ) | (enumLiteral_78= 'DRVL' ) | (enumLiteral_79= 'HOPR' ) | (enumLiteral_80= 'CALC' ) | (enumLiteral_81= 'INPA' ) | (enumLiteral_82= 'INPB' ) | (enumLiteral_83= 'INPC' ) | (enumLiteral_84= 'INPD' ) | (enumLiteral_85= 'FLNK' ) | (enumLiteral_86= 'INPE' ) | (enumLiteral_87= 'INPF' ) | (enumLiteral_88= 'INPG' ) | (enumLiteral_89= 'INPH' ) | (enumLiteral_90= 'INPI' ) | (enumLiteral_91= 'INPJ' ) | (enumLiteral_92= 'INPK' ) | (enumLiteral_93= 'INAA' ) | (enumLiteral_94= 'INBB' ) | (enumLiteral_95= 'INCC' ) | (enumLiteral_96= 'SIOL' ) ) ;
    public final Enumerator ruleFieldnames() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;
        Token enumLiteral_18=null;
        Token enumLiteral_19=null;
        Token enumLiteral_20=null;
        Token enumLiteral_21=null;
        Token enumLiteral_22=null;
        Token enumLiteral_23=null;
        Token enumLiteral_24=null;
        Token enumLiteral_25=null;
        Token enumLiteral_26=null;
        Token enumLiteral_27=null;
        Token enumLiteral_28=null;
        Token enumLiteral_29=null;
        Token enumLiteral_30=null;
        Token enumLiteral_31=null;
        Token enumLiteral_32=null;
        Token enumLiteral_33=null;
        Token enumLiteral_34=null;
        Token enumLiteral_35=null;
        Token enumLiteral_36=null;
        Token enumLiteral_37=null;
        Token enumLiteral_38=null;
        Token enumLiteral_39=null;
        Token enumLiteral_40=null;
        Token enumLiteral_41=null;
        Token enumLiteral_42=null;
        Token enumLiteral_43=null;
        Token enumLiteral_44=null;
        Token enumLiteral_45=null;
        Token enumLiteral_46=null;
        Token enumLiteral_47=null;
        Token enumLiteral_48=null;
        Token enumLiteral_49=null;
        Token enumLiteral_50=null;
        Token enumLiteral_51=null;
        Token enumLiteral_52=null;
        Token enumLiteral_53=null;
        Token enumLiteral_54=null;
        Token enumLiteral_55=null;
        Token enumLiteral_56=null;
        Token enumLiteral_57=null;
        Token enumLiteral_58=null;
        Token enumLiteral_59=null;
        Token enumLiteral_60=null;
        Token enumLiteral_61=null;
        Token enumLiteral_62=null;
        Token enumLiteral_63=null;
        Token enumLiteral_64=null;
        Token enumLiteral_65=null;
        Token enumLiteral_66=null;
        Token enumLiteral_67=null;
        Token enumLiteral_68=null;
        Token enumLiteral_69=null;
        Token enumLiteral_70=null;
        Token enumLiteral_71=null;
        Token enumLiteral_72=null;
        Token enumLiteral_73=null;
        Token enumLiteral_74=null;
        Token enumLiteral_75=null;
        Token enumLiteral_76=null;
        Token enumLiteral_77=null;
        Token enumLiteral_78=null;
        Token enumLiteral_79=null;
        Token enumLiteral_80=null;
        Token enumLiteral_81=null;
        Token enumLiteral_82=null;
        Token enumLiteral_83=null;
        Token enumLiteral_84=null;
        Token enumLiteral_85=null;
        Token enumLiteral_86=null;
        Token enumLiteral_87=null;
        Token enumLiteral_88=null;
        Token enumLiteral_89=null;
        Token enumLiteral_90=null;
        Token enumLiteral_91=null;
        Token enumLiteral_92=null;
        Token enumLiteral_93=null;
        Token enumLiteral_94=null;
        Token enumLiteral_95=null;
        Token enumLiteral_96=null;


        	enterRule();

        try {
            // InternalDbTextEditor.g:462:2: ( ( (enumLiteral_0= 'NAME' ) | (enumLiteral_1= 'DESC' ) | (enumLiteral_2= 'ASG' ) | (enumLiteral_3= 'SCAN' ) | (enumLiteral_4= 'PHAS' ) | (enumLiteral_5= 'PINI' ) | (enumLiteral_6= 'SDIS' ) | (enumLiteral_7= 'PROC' ) | (enumLiteral_8= 'PACT' ) | (enumLiteral_9= 'SEVR' ) | (enumLiteral_10= 'STAT' ) | (enumLiteral_11= 'TIME' ) | (enumLiteral_12= 'DTYP' ) | (enumLiteral_13= 'ONAM' ) | (enumLiteral_14= 'OSV' ) | (enumLiteral_15= 'OUT' ) | (enumLiteral_16= 'SIML' ) | (enumLiteral_17= 'ZNAM' ) | (enumLiteral_18= 'ZSV' ) | (enumLiteral_19= 'INP' ) | (enumLiteral_20= 'EGU' ) | (enumLiteral_21= 'LINR' ) | (enumLiteral_22= 'EGUL' ) | (enumLiteral_23= 'EGUF' ) | (enumLiteral_24= 'HIGH' ) | (enumLiteral_25= 'HSV' ) | (enumLiteral_26= 'HIHI' ) | (enumLiteral_27= 'HHSV' ) | (enumLiteral_28= 'EIST' ) | (enumLiteral_29= 'EISV' ) | (enumLiteral_30= 'EIVL' ) | (enumLiteral_31= 'ELST' ) | (enumLiteral_32= 'ELSV' ) | (enumLiteral_33= 'ELVL' ) | (enumLiteral_34= 'FRST' ) | (enumLiteral_35= 'FRSV' ) | (enumLiteral_36= 'FRVL' ) | (enumLiteral_37= 'FVST' ) | (enumLiteral_38= 'HYST' ) | (enumLiteral_39= 'LLSV' ) | (enumLiteral_40= 'FVSV' ) | (enumLiteral_41= 'FVVL' ) | (enumLiteral_42= 'MASK' ) | (enumLiteral_43= 'NIST' ) | (enumLiteral_44= 'NISV' ) | (enumLiteral_45= 'NIVL' ) | (enumLiteral_46= 'NOBT' ) | (enumLiteral_47= 'ONST' ) | (enumLiteral_48= 'ONSV' ) | (enumLiteral_49= 'ONVL' ) | (enumLiteral_50= 'SHFT' ) | (enumLiteral_51= 'SVST' ) | (enumLiteral_52= 'SVSV' ) | (enumLiteral_53= 'SVVL' ) | (enumLiteral_54= 'SXST' ) | (enumLiteral_55= 'SXSV' ) | (enumLiteral_56= 'SXVL' ) | (enumLiteral_57= 'TEST' ) | (enumLiteral_58= 'TESV' ) | (enumLiteral_59= 'TEVL' ) | (enumLiteral_60= 'THST' ) | (enumLiteral_61= 'THSV' ) | (enumLiteral_62= 'THVL' ) | (enumLiteral_63= 'TWST' ) | (enumLiteral_64= 'TWSV' ) | (enumLiteral_65= 'TWVL' ) | (enumLiteral_66= 'UNSV' ) | (enumLiteral_67= 'ZRST' ) | (enumLiteral_68= 'ZRSV' ) | (enumLiteral_69= 'ZRVL' ) | (enumLiteral_70= 'LOLO' ) | (enumLiteral_71= 'LOW' ) | (enumLiteral_72= 'LSV' ) | (enumLiteral_73= 'SSCN' ) | (enumLiteral_74= 'TSE' ) | (enumLiteral_75= 'PREC' ) | (enumLiteral_76= 'DRVH' ) | (enumLiteral_77= 'LOPR' ) | (enumLiteral_78= 'DRVL' ) | (enumLiteral_79= 'HOPR' ) | (enumLiteral_80= 'CALC' ) | (enumLiteral_81= 'INPA' ) | (enumLiteral_82= 'INPB' ) | (enumLiteral_83= 'INPC' ) | (enumLiteral_84= 'INPD' ) | (enumLiteral_85= 'FLNK' ) | (enumLiteral_86= 'INPE' ) | (enumLiteral_87= 'INPF' ) | (enumLiteral_88= 'INPG' ) | (enumLiteral_89= 'INPH' ) | (enumLiteral_90= 'INPI' ) | (enumLiteral_91= 'INPJ' ) | (enumLiteral_92= 'INPK' ) | (enumLiteral_93= 'INAA' ) | (enumLiteral_94= 'INBB' ) | (enumLiteral_95= 'INCC' ) | (enumLiteral_96= 'SIOL' ) ) )
            // InternalDbTextEditor.g:463:2: ( (enumLiteral_0= 'NAME' ) | (enumLiteral_1= 'DESC' ) | (enumLiteral_2= 'ASG' ) | (enumLiteral_3= 'SCAN' ) | (enumLiteral_4= 'PHAS' ) | (enumLiteral_5= 'PINI' ) | (enumLiteral_6= 'SDIS' ) | (enumLiteral_7= 'PROC' ) | (enumLiteral_8= 'PACT' ) | (enumLiteral_9= 'SEVR' ) | (enumLiteral_10= 'STAT' ) | (enumLiteral_11= 'TIME' ) | (enumLiteral_12= 'DTYP' ) | (enumLiteral_13= 'ONAM' ) | (enumLiteral_14= 'OSV' ) | (enumLiteral_15= 'OUT' ) | (enumLiteral_16= 'SIML' ) | (enumLiteral_17= 'ZNAM' ) | (enumLiteral_18= 'ZSV' ) | (enumLiteral_19= 'INP' ) | (enumLiteral_20= 'EGU' ) | (enumLiteral_21= 'LINR' ) | (enumLiteral_22= 'EGUL' ) | (enumLiteral_23= 'EGUF' ) | (enumLiteral_24= 'HIGH' ) | (enumLiteral_25= 'HSV' ) | (enumLiteral_26= 'HIHI' ) | (enumLiteral_27= 'HHSV' ) | (enumLiteral_28= 'EIST' ) | (enumLiteral_29= 'EISV' ) | (enumLiteral_30= 'EIVL' ) | (enumLiteral_31= 'ELST' ) | (enumLiteral_32= 'ELSV' ) | (enumLiteral_33= 'ELVL' ) | (enumLiteral_34= 'FRST' ) | (enumLiteral_35= 'FRSV' ) | (enumLiteral_36= 'FRVL' ) | (enumLiteral_37= 'FVST' ) | (enumLiteral_38= 'HYST' ) | (enumLiteral_39= 'LLSV' ) | (enumLiteral_40= 'FVSV' ) | (enumLiteral_41= 'FVVL' ) | (enumLiteral_42= 'MASK' ) | (enumLiteral_43= 'NIST' ) | (enumLiteral_44= 'NISV' ) | (enumLiteral_45= 'NIVL' ) | (enumLiteral_46= 'NOBT' ) | (enumLiteral_47= 'ONST' ) | (enumLiteral_48= 'ONSV' ) | (enumLiteral_49= 'ONVL' ) | (enumLiteral_50= 'SHFT' ) | (enumLiteral_51= 'SVST' ) | (enumLiteral_52= 'SVSV' ) | (enumLiteral_53= 'SVVL' ) | (enumLiteral_54= 'SXST' ) | (enumLiteral_55= 'SXSV' ) | (enumLiteral_56= 'SXVL' ) | (enumLiteral_57= 'TEST' ) | (enumLiteral_58= 'TESV' ) | (enumLiteral_59= 'TEVL' ) | (enumLiteral_60= 'THST' ) | (enumLiteral_61= 'THSV' ) | (enumLiteral_62= 'THVL' ) | (enumLiteral_63= 'TWST' ) | (enumLiteral_64= 'TWSV' ) | (enumLiteral_65= 'TWVL' ) | (enumLiteral_66= 'UNSV' ) | (enumLiteral_67= 'ZRST' ) | (enumLiteral_68= 'ZRSV' ) | (enumLiteral_69= 'ZRVL' ) | (enumLiteral_70= 'LOLO' ) | (enumLiteral_71= 'LOW' ) | (enumLiteral_72= 'LSV' ) | (enumLiteral_73= 'SSCN' ) | (enumLiteral_74= 'TSE' ) | (enumLiteral_75= 'PREC' ) | (enumLiteral_76= 'DRVH' ) | (enumLiteral_77= 'LOPR' ) | (enumLiteral_78= 'DRVL' ) | (enumLiteral_79= 'HOPR' ) | (enumLiteral_80= 'CALC' ) | (enumLiteral_81= 'INPA' ) | (enumLiteral_82= 'INPB' ) | (enumLiteral_83= 'INPC' ) | (enumLiteral_84= 'INPD' ) | (enumLiteral_85= 'FLNK' ) | (enumLiteral_86= 'INPE' ) | (enumLiteral_87= 'INPF' ) | (enumLiteral_88= 'INPG' ) | (enumLiteral_89= 'INPH' ) | (enumLiteral_90= 'INPI' ) | (enumLiteral_91= 'INPJ' ) | (enumLiteral_92= 'INPK' ) | (enumLiteral_93= 'INAA' ) | (enumLiteral_94= 'INBB' ) | (enumLiteral_95= 'INCC' ) | (enumLiteral_96= 'SIOL' ) )
            {
            // InternalDbTextEditor.g:463:2: ( (enumLiteral_0= 'NAME' ) | (enumLiteral_1= 'DESC' ) | (enumLiteral_2= 'ASG' ) | (enumLiteral_3= 'SCAN' ) | (enumLiteral_4= 'PHAS' ) | (enumLiteral_5= 'PINI' ) | (enumLiteral_6= 'SDIS' ) | (enumLiteral_7= 'PROC' ) | (enumLiteral_8= 'PACT' ) | (enumLiteral_9= 'SEVR' ) | (enumLiteral_10= 'STAT' ) | (enumLiteral_11= 'TIME' ) | (enumLiteral_12= 'DTYP' ) | (enumLiteral_13= 'ONAM' ) | (enumLiteral_14= 'OSV' ) | (enumLiteral_15= 'OUT' ) | (enumLiteral_16= 'SIML' ) | (enumLiteral_17= 'ZNAM' ) | (enumLiteral_18= 'ZSV' ) | (enumLiteral_19= 'INP' ) | (enumLiteral_20= 'EGU' ) | (enumLiteral_21= 'LINR' ) | (enumLiteral_22= 'EGUL' ) | (enumLiteral_23= 'EGUF' ) | (enumLiteral_24= 'HIGH' ) | (enumLiteral_25= 'HSV' ) | (enumLiteral_26= 'HIHI' ) | (enumLiteral_27= 'HHSV' ) | (enumLiteral_28= 'EIST' ) | (enumLiteral_29= 'EISV' ) | (enumLiteral_30= 'EIVL' ) | (enumLiteral_31= 'ELST' ) | (enumLiteral_32= 'ELSV' ) | (enumLiteral_33= 'ELVL' ) | (enumLiteral_34= 'FRST' ) | (enumLiteral_35= 'FRSV' ) | (enumLiteral_36= 'FRVL' ) | (enumLiteral_37= 'FVST' ) | (enumLiteral_38= 'HYST' ) | (enumLiteral_39= 'LLSV' ) | (enumLiteral_40= 'FVSV' ) | (enumLiteral_41= 'FVVL' ) | (enumLiteral_42= 'MASK' ) | (enumLiteral_43= 'NIST' ) | (enumLiteral_44= 'NISV' ) | (enumLiteral_45= 'NIVL' ) | (enumLiteral_46= 'NOBT' ) | (enumLiteral_47= 'ONST' ) | (enumLiteral_48= 'ONSV' ) | (enumLiteral_49= 'ONVL' ) | (enumLiteral_50= 'SHFT' ) | (enumLiteral_51= 'SVST' ) | (enumLiteral_52= 'SVSV' ) | (enumLiteral_53= 'SVVL' ) | (enumLiteral_54= 'SXST' ) | (enumLiteral_55= 'SXSV' ) | (enumLiteral_56= 'SXVL' ) | (enumLiteral_57= 'TEST' ) | (enumLiteral_58= 'TESV' ) | (enumLiteral_59= 'TEVL' ) | (enumLiteral_60= 'THST' ) | (enumLiteral_61= 'THSV' ) | (enumLiteral_62= 'THVL' ) | (enumLiteral_63= 'TWST' ) | (enumLiteral_64= 'TWSV' ) | (enumLiteral_65= 'TWVL' ) | (enumLiteral_66= 'UNSV' ) | (enumLiteral_67= 'ZRST' ) | (enumLiteral_68= 'ZRSV' ) | (enumLiteral_69= 'ZRVL' ) | (enumLiteral_70= 'LOLO' ) | (enumLiteral_71= 'LOW' ) | (enumLiteral_72= 'LSV' ) | (enumLiteral_73= 'SSCN' ) | (enumLiteral_74= 'TSE' ) | (enumLiteral_75= 'PREC' ) | (enumLiteral_76= 'DRVH' ) | (enumLiteral_77= 'LOPR' ) | (enumLiteral_78= 'DRVL' ) | (enumLiteral_79= 'HOPR' ) | (enumLiteral_80= 'CALC' ) | (enumLiteral_81= 'INPA' ) | (enumLiteral_82= 'INPB' ) | (enumLiteral_83= 'INPC' ) | (enumLiteral_84= 'INPD' ) | (enumLiteral_85= 'FLNK' ) | (enumLiteral_86= 'INPE' ) | (enumLiteral_87= 'INPF' ) | (enumLiteral_88= 'INPG' ) | (enumLiteral_89= 'INPH' ) | (enumLiteral_90= 'INPI' ) | (enumLiteral_91= 'INPJ' ) | (enumLiteral_92= 'INPK' ) | (enumLiteral_93= 'INAA' ) | (enumLiteral_94= 'INBB' ) | (enumLiteral_95= 'INCC' ) | (enumLiteral_96= 'SIOL' ) )
            int alt5=97;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt5=1;
                }
                break;
            case 22:
                {
                alt5=2;
                }
                break;
            case 23:
                {
                alt5=3;
                }
                break;
            case 24:
                {
                alt5=4;
                }
                break;
            case 25:
                {
                alt5=5;
                }
                break;
            case 26:
                {
                alt5=6;
                }
                break;
            case 27:
                {
                alt5=7;
                }
                break;
            case 28:
                {
                alt5=8;
                }
                break;
            case 29:
                {
                alt5=9;
                }
                break;
            case 30:
                {
                alt5=10;
                }
                break;
            case 31:
                {
                alt5=11;
                }
                break;
            case 32:
                {
                alt5=12;
                }
                break;
            case 33:
                {
                alt5=13;
                }
                break;
            case 34:
                {
                alt5=14;
                }
                break;
            case 35:
                {
                alt5=15;
                }
                break;
            case 36:
                {
                alt5=16;
                }
                break;
            case 37:
                {
                alt5=17;
                }
                break;
            case 38:
                {
                alt5=18;
                }
                break;
            case 39:
                {
                alt5=19;
                }
                break;
            case 40:
                {
                alt5=20;
                }
                break;
            case 41:
                {
                alt5=21;
                }
                break;
            case 42:
                {
                alt5=22;
                }
                break;
            case 43:
                {
                alt5=23;
                }
                break;
            case 44:
                {
                alt5=24;
                }
                break;
            case 45:
                {
                alt5=25;
                }
                break;
            case 46:
                {
                alt5=26;
                }
                break;
            case 47:
                {
                alt5=27;
                }
                break;
            case 48:
                {
                alt5=28;
                }
                break;
            case 49:
                {
                alt5=29;
                }
                break;
            case 50:
                {
                alt5=30;
                }
                break;
            case 51:
                {
                alt5=31;
                }
                break;
            case 52:
                {
                alt5=32;
                }
                break;
            case 53:
                {
                alt5=33;
                }
                break;
            case 54:
                {
                alt5=34;
                }
                break;
            case 55:
                {
                alt5=35;
                }
                break;
            case 56:
                {
                alt5=36;
                }
                break;
            case 57:
                {
                alt5=37;
                }
                break;
            case 58:
                {
                alt5=38;
                }
                break;
            case 59:
                {
                alt5=39;
                }
                break;
            case 60:
                {
                alt5=40;
                }
                break;
            case 61:
                {
                alt5=41;
                }
                break;
            case 62:
                {
                alt5=42;
                }
                break;
            case 63:
                {
                alt5=43;
                }
                break;
            case 64:
                {
                alt5=44;
                }
                break;
            case 65:
                {
                alt5=45;
                }
                break;
            case 66:
                {
                alt5=46;
                }
                break;
            case 67:
                {
                alt5=47;
                }
                break;
            case 68:
                {
                alt5=48;
                }
                break;
            case 69:
                {
                alt5=49;
                }
                break;
            case 70:
                {
                alt5=50;
                }
                break;
            case 71:
                {
                alt5=51;
                }
                break;
            case 72:
                {
                alt5=52;
                }
                break;
            case 73:
                {
                alt5=53;
                }
                break;
            case 74:
                {
                alt5=54;
                }
                break;
            case 75:
                {
                alt5=55;
                }
                break;
            case 76:
                {
                alt5=56;
                }
                break;
            case 77:
                {
                alt5=57;
                }
                break;
            case 78:
                {
                alt5=58;
                }
                break;
            case 79:
                {
                alt5=59;
                }
                break;
            case 80:
                {
                alt5=60;
                }
                break;
            case 81:
                {
                alt5=61;
                }
                break;
            case 82:
                {
                alt5=62;
                }
                break;
            case 83:
                {
                alt5=63;
                }
                break;
            case 84:
                {
                alt5=64;
                }
                break;
            case 85:
                {
                alt5=65;
                }
                break;
            case 86:
                {
                alt5=66;
                }
                break;
            case 87:
                {
                alt5=67;
                }
                break;
            case 88:
                {
                alt5=68;
                }
                break;
            case 89:
                {
                alt5=69;
                }
                break;
            case 90:
                {
                alt5=70;
                }
                break;
            case 91:
                {
                alt5=71;
                }
                break;
            case 92:
                {
                alt5=72;
                }
                break;
            case 93:
                {
                alt5=73;
                }
                break;
            case 94:
                {
                alt5=74;
                }
                break;
            case 95:
                {
                alt5=75;
                }
                break;
            case 96:
                {
                alt5=76;
                }
                break;
            case 97:
                {
                alt5=77;
                }
                break;
            case 98:
                {
                alt5=78;
                }
                break;
            case 99:
                {
                alt5=79;
                }
                break;
            case 100:
                {
                alt5=80;
                }
                break;
            case 101:
                {
                alt5=81;
                }
                break;
            case 102:
                {
                alt5=82;
                }
                break;
            case 103:
                {
                alt5=83;
                }
                break;
            case 104:
                {
                alt5=84;
                }
                break;
            case 105:
                {
                alt5=85;
                }
                break;
            case 106:
                {
                alt5=86;
                }
                break;
            case 107:
                {
                alt5=87;
                }
                break;
            case 108:
                {
                alt5=88;
                }
                break;
            case 109:
                {
                alt5=89;
                }
                break;
            case 110:
                {
                alt5=90;
                }
                break;
            case 111:
                {
                alt5=91;
                }
                break;
            case 112:
                {
                alt5=92;
                }
                break;
            case 113:
                {
                alt5=93;
                }
                break;
            case 114:
                {
                alt5=94;
                }
                break;
            case 115:
                {
                alt5=95;
                }
                break;
            case 116:
                {
                alt5=96;
                }
                break;
            case 117:
                {
                alt5=97;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalDbTextEditor.g:464:3: (enumLiteral_0= 'NAME' )
                    {
                    // InternalDbTextEditor.g:464:3: (enumLiteral_0= 'NAME' )
                    // InternalDbTextEditor.g:465:4: enumLiteral_0= 'NAME'
                    {
                    enumLiteral_0=(Token)match(input,21,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getNAMEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getFieldnamesAccess().getNAMEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDbTextEditor.g:472:3: (enumLiteral_1= 'DESC' )
                    {
                    // InternalDbTextEditor.g:472:3: (enumLiteral_1= 'DESC' )
                    // InternalDbTextEditor.g:473:4: enumLiteral_1= 'DESC'
                    {
                    enumLiteral_1=(Token)match(input,22,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getDESCEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getFieldnamesAccess().getDESCEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDbTextEditor.g:480:3: (enumLiteral_2= 'ASG' )
                    {
                    // InternalDbTextEditor.g:480:3: (enumLiteral_2= 'ASG' )
                    // InternalDbTextEditor.g:481:4: enumLiteral_2= 'ASG'
                    {
                    enumLiteral_2=(Token)match(input,23,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getASGEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getFieldnamesAccess().getASGEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDbTextEditor.g:488:3: (enumLiteral_3= 'SCAN' )
                    {
                    // InternalDbTextEditor.g:488:3: (enumLiteral_3= 'SCAN' )
                    // InternalDbTextEditor.g:489:4: enumLiteral_3= 'SCAN'
                    {
                    enumLiteral_3=(Token)match(input,24,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSCANEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getFieldnamesAccess().getSCANEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDbTextEditor.g:496:3: (enumLiteral_4= 'PHAS' )
                    {
                    // InternalDbTextEditor.g:496:3: (enumLiteral_4= 'PHAS' )
                    // InternalDbTextEditor.g:497:4: enumLiteral_4= 'PHAS'
                    {
                    enumLiteral_4=(Token)match(input,25,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getPHASEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getFieldnamesAccess().getPHASEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalDbTextEditor.g:504:3: (enumLiteral_5= 'PINI' )
                    {
                    // InternalDbTextEditor.g:504:3: (enumLiteral_5= 'PINI' )
                    // InternalDbTextEditor.g:505:4: enumLiteral_5= 'PINI'
                    {
                    enumLiteral_5=(Token)match(input,26,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getPINIEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getFieldnamesAccess().getPINIEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalDbTextEditor.g:512:3: (enumLiteral_6= 'SDIS' )
                    {
                    // InternalDbTextEditor.g:512:3: (enumLiteral_6= 'SDIS' )
                    // InternalDbTextEditor.g:513:4: enumLiteral_6= 'SDIS'
                    {
                    enumLiteral_6=(Token)match(input,27,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSDISEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getFieldnamesAccess().getSDISEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalDbTextEditor.g:520:3: (enumLiteral_7= 'PROC' )
                    {
                    // InternalDbTextEditor.g:520:3: (enumLiteral_7= 'PROC' )
                    // InternalDbTextEditor.g:521:4: enumLiteral_7= 'PROC'
                    {
                    enumLiteral_7=(Token)match(input,28,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getPROCEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getFieldnamesAccess().getPROCEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalDbTextEditor.g:528:3: (enumLiteral_8= 'PACT' )
                    {
                    // InternalDbTextEditor.g:528:3: (enumLiteral_8= 'PACT' )
                    // InternalDbTextEditor.g:529:4: enumLiteral_8= 'PACT'
                    {
                    enumLiteral_8=(Token)match(input,29,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getPACTEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getFieldnamesAccess().getPACTEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalDbTextEditor.g:536:3: (enumLiteral_9= 'SEVR' )
                    {
                    // InternalDbTextEditor.g:536:3: (enumLiteral_9= 'SEVR' )
                    // InternalDbTextEditor.g:537:4: enumLiteral_9= 'SEVR'
                    {
                    enumLiteral_9=(Token)match(input,30,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSEVREnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getFieldnamesAccess().getSEVREnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalDbTextEditor.g:544:3: (enumLiteral_10= 'STAT' )
                    {
                    // InternalDbTextEditor.g:544:3: (enumLiteral_10= 'STAT' )
                    // InternalDbTextEditor.g:545:4: enumLiteral_10= 'STAT'
                    {
                    enumLiteral_10=(Token)match(input,31,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSTATEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getFieldnamesAccess().getSTATEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalDbTextEditor.g:552:3: (enumLiteral_11= 'TIME' )
                    {
                    // InternalDbTextEditor.g:552:3: (enumLiteral_11= 'TIME' )
                    // InternalDbTextEditor.g:553:4: enumLiteral_11= 'TIME'
                    {
                    enumLiteral_11=(Token)match(input,32,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getTIMEEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getFieldnamesAccess().getTIMEEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalDbTextEditor.g:560:3: (enumLiteral_12= 'DTYP' )
                    {
                    // InternalDbTextEditor.g:560:3: (enumLiteral_12= 'DTYP' )
                    // InternalDbTextEditor.g:561:4: enumLiteral_12= 'DTYP'
                    {
                    enumLiteral_12=(Token)match(input,33,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getDTYPEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getFieldnamesAccess().getDTYPEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalDbTextEditor.g:568:3: (enumLiteral_13= 'ONAM' )
                    {
                    // InternalDbTextEditor.g:568:3: (enumLiteral_13= 'ONAM' )
                    // InternalDbTextEditor.g:569:4: enumLiteral_13= 'ONAM'
                    {
                    enumLiteral_13=(Token)match(input,34,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getONAMEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getFieldnamesAccess().getONAMEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalDbTextEditor.g:576:3: (enumLiteral_14= 'OSV' )
                    {
                    // InternalDbTextEditor.g:576:3: (enumLiteral_14= 'OSV' )
                    // InternalDbTextEditor.g:577:4: enumLiteral_14= 'OSV'
                    {
                    enumLiteral_14=(Token)match(input,35,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getOSVEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getFieldnamesAccess().getOSVEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalDbTextEditor.g:584:3: (enumLiteral_15= 'OUT' )
                    {
                    // InternalDbTextEditor.g:584:3: (enumLiteral_15= 'OUT' )
                    // InternalDbTextEditor.g:585:4: enumLiteral_15= 'OUT'
                    {
                    enumLiteral_15=(Token)match(input,36,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getOUTEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getFieldnamesAccess().getOUTEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalDbTextEditor.g:592:3: (enumLiteral_16= 'SIML' )
                    {
                    // InternalDbTextEditor.g:592:3: (enumLiteral_16= 'SIML' )
                    // InternalDbTextEditor.g:593:4: enumLiteral_16= 'SIML'
                    {
                    enumLiteral_16=(Token)match(input,37,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSIMLEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getFieldnamesAccess().getSIMLEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalDbTextEditor.g:600:3: (enumLiteral_17= 'ZNAM' )
                    {
                    // InternalDbTextEditor.g:600:3: (enumLiteral_17= 'ZNAM' )
                    // InternalDbTextEditor.g:601:4: enumLiteral_17= 'ZNAM'
                    {
                    enumLiteral_17=(Token)match(input,38,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getZNAMEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getFieldnamesAccess().getZNAMEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalDbTextEditor.g:608:3: (enumLiteral_18= 'ZSV' )
                    {
                    // InternalDbTextEditor.g:608:3: (enumLiteral_18= 'ZSV' )
                    // InternalDbTextEditor.g:609:4: enumLiteral_18= 'ZSV'
                    {
                    enumLiteral_18=(Token)match(input,39,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getZSVEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getFieldnamesAccess().getZSVEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalDbTextEditor.g:616:3: (enumLiteral_19= 'INP' )
                    {
                    // InternalDbTextEditor.g:616:3: (enumLiteral_19= 'INP' )
                    // InternalDbTextEditor.g:617:4: enumLiteral_19= 'INP'
                    {
                    enumLiteral_19=(Token)match(input,40,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getFieldnamesAccess().getINPEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalDbTextEditor.g:624:3: (enumLiteral_20= 'EGU' )
                    {
                    // InternalDbTextEditor.g:624:3: (enumLiteral_20= 'EGU' )
                    // InternalDbTextEditor.g:625:4: enumLiteral_20= 'EGU'
                    {
                    enumLiteral_20=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getEGUEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getFieldnamesAccess().getEGUEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalDbTextEditor.g:632:3: (enumLiteral_21= 'LINR' )
                    {
                    // InternalDbTextEditor.g:632:3: (enumLiteral_21= 'LINR' )
                    // InternalDbTextEditor.g:633:4: enumLiteral_21= 'LINR'
                    {
                    enumLiteral_21=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLINREnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getFieldnamesAccess().getLINREnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalDbTextEditor.g:640:3: (enumLiteral_22= 'EGUL' )
                    {
                    // InternalDbTextEditor.g:640:3: (enumLiteral_22= 'EGUL' )
                    // InternalDbTextEditor.g:641:4: enumLiteral_22= 'EGUL'
                    {
                    enumLiteral_22=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getEGULEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getFieldnamesAccess().getEGULEnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalDbTextEditor.g:648:3: (enumLiteral_23= 'EGUF' )
                    {
                    // InternalDbTextEditor.g:648:3: (enumLiteral_23= 'EGUF' )
                    // InternalDbTextEditor.g:649:4: enumLiteral_23= 'EGUF'
                    {
                    enumLiteral_23=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getEGUFEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getFieldnamesAccess().getEGUFEnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalDbTextEditor.g:656:3: (enumLiteral_24= 'HIGH' )
                    {
                    // InternalDbTextEditor.g:656:3: (enumLiteral_24= 'HIGH' )
                    // InternalDbTextEditor.g:657:4: enumLiteral_24= 'HIGH'
                    {
                    enumLiteral_24=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getHIGHEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getFieldnamesAccess().getHIGHEnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalDbTextEditor.g:664:3: (enumLiteral_25= 'HSV' )
                    {
                    // InternalDbTextEditor.g:664:3: (enumLiteral_25= 'HSV' )
                    // InternalDbTextEditor.g:665:4: enumLiteral_25= 'HSV'
                    {
                    enumLiteral_25=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getHSVEnumLiteralDeclaration_25().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_25, grammarAccess.getFieldnamesAccess().getHSVEnumLiteralDeclaration_25());
                    			

                    }


                    }
                    break;
                case 27 :
                    // InternalDbTextEditor.g:672:3: (enumLiteral_26= 'HIHI' )
                    {
                    // InternalDbTextEditor.g:672:3: (enumLiteral_26= 'HIHI' )
                    // InternalDbTextEditor.g:673:4: enumLiteral_26= 'HIHI'
                    {
                    enumLiteral_26=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getHIHIEnumLiteralDeclaration_26().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_26, grammarAccess.getFieldnamesAccess().getHIHIEnumLiteralDeclaration_26());
                    			

                    }


                    }
                    break;
                case 28 :
                    // InternalDbTextEditor.g:680:3: (enumLiteral_27= 'HHSV' )
                    {
                    // InternalDbTextEditor.g:680:3: (enumLiteral_27= 'HHSV' )
                    // InternalDbTextEditor.g:681:4: enumLiteral_27= 'HHSV'
                    {
                    enumLiteral_27=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getHHSVEnumLiteralDeclaration_27().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_27, grammarAccess.getFieldnamesAccess().getHHSVEnumLiteralDeclaration_27());
                    			

                    }


                    }
                    break;
                case 29 :
                    // InternalDbTextEditor.g:688:3: (enumLiteral_28= 'EIST' )
                    {
                    // InternalDbTextEditor.g:688:3: (enumLiteral_28= 'EIST' )
                    // InternalDbTextEditor.g:689:4: enumLiteral_28= 'EIST'
                    {
                    enumLiteral_28=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getEISTEnumLiteralDeclaration_28().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_28, grammarAccess.getFieldnamesAccess().getEISTEnumLiteralDeclaration_28());
                    			

                    }


                    }
                    break;
                case 30 :
                    // InternalDbTextEditor.g:696:3: (enumLiteral_29= 'EISV' )
                    {
                    // InternalDbTextEditor.g:696:3: (enumLiteral_29= 'EISV' )
                    // InternalDbTextEditor.g:697:4: enumLiteral_29= 'EISV'
                    {
                    enumLiteral_29=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getEISVEnumLiteralDeclaration_29().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_29, grammarAccess.getFieldnamesAccess().getEISVEnumLiteralDeclaration_29());
                    			

                    }


                    }
                    break;
                case 31 :
                    // InternalDbTextEditor.g:704:3: (enumLiteral_30= 'EIVL' )
                    {
                    // InternalDbTextEditor.g:704:3: (enumLiteral_30= 'EIVL' )
                    // InternalDbTextEditor.g:705:4: enumLiteral_30= 'EIVL'
                    {
                    enumLiteral_30=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getEIVLEnumLiteralDeclaration_30().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_30, grammarAccess.getFieldnamesAccess().getEIVLEnumLiteralDeclaration_30());
                    			

                    }


                    }
                    break;
                case 32 :
                    // InternalDbTextEditor.g:712:3: (enumLiteral_31= 'ELST' )
                    {
                    // InternalDbTextEditor.g:712:3: (enumLiteral_31= 'ELST' )
                    // InternalDbTextEditor.g:713:4: enumLiteral_31= 'ELST'
                    {
                    enumLiteral_31=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getELSTEnumLiteralDeclaration_31().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_31, grammarAccess.getFieldnamesAccess().getELSTEnumLiteralDeclaration_31());
                    			

                    }


                    }
                    break;
                case 33 :
                    // InternalDbTextEditor.g:720:3: (enumLiteral_32= 'ELSV' )
                    {
                    // InternalDbTextEditor.g:720:3: (enumLiteral_32= 'ELSV' )
                    // InternalDbTextEditor.g:721:4: enumLiteral_32= 'ELSV'
                    {
                    enumLiteral_32=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getELSVEnumLiteralDeclaration_32().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_32, grammarAccess.getFieldnamesAccess().getELSVEnumLiteralDeclaration_32());
                    			

                    }


                    }
                    break;
                case 34 :
                    // InternalDbTextEditor.g:728:3: (enumLiteral_33= 'ELVL' )
                    {
                    // InternalDbTextEditor.g:728:3: (enumLiteral_33= 'ELVL' )
                    // InternalDbTextEditor.g:729:4: enumLiteral_33= 'ELVL'
                    {
                    enumLiteral_33=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getELVLEnumLiteralDeclaration_33().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_33, grammarAccess.getFieldnamesAccess().getELVLEnumLiteralDeclaration_33());
                    			

                    }


                    }
                    break;
                case 35 :
                    // InternalDbTextEditor.g:736:3: (enumLiteral_34= 'FRST' )
                    {
                    // InternalDbTextEditor.g:736:3: (enumLiteral_34= 'FRST' )
                    // InternalDbTextEditor.g:737:4: enumLiteral_34= 'FRST'
                    {
                    enumLiteral_34=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getFRSTEnumLiteralDeclaration_34().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_34, grammarAccess.getFieldnamesAccess().getFRSTEnumLiteralDeclaration_34());
                    			

                    }


                    }
                    break;
                case 36 :
                    // InternalDbTextEditor.g:744:3: (enumLiteral_35= 'FRSV' )
                    {
                    // InternalDbTextEditor.g:744:3: (enumLiteral_35= 'FRSV' )
                    // InternalDbTextEditor.g:745:4: enumLiteral_35= 'FRSV'
                    {
                    enumLiteral_35=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getFRSVEnumLiteralDeclaration_35().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_35, grammarAccess.getFieldnamesAccess().getFRSVEnumLiteralDeclaration_35());
                    			

                    }


                    }
                    break;
                case 37 :
                    // InternalDbTextEditor.g:752:3: (enumLiteral_36= 'FRVL' )
                    {
                    // InternalDbTextEditor.g:752:3: (enumLiteral_36= 'FRVL' )
                    // InternalDbTextEditor.g:753:4: enumLiteral_36= 'FRVL'
                    {
                    enumLiteral_36=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getFRVLEnumLiteralDeclaration_36().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_36, grammarAccess.getFieldnamesAccess().getFRVLEnumLiteralDeclaration_36());
                    			

                    }


                    }
                    break;
                case 38 :
                    // InternalDbTextEditor.g:760:3: (enumLiteral_37= 'FVST' )
                    {
                    // InternalDbTextEditor.g:760:3: (enumLiteral_37= 'FVST' )
                    // InternalDbTextEditor.g:761:4: enumLiteral_37= 'FVST'
                    {
                    enumLiteral_37=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getFVSTEnumLiteralDeclaration_37().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_37, grammarAccess.getFieldnamesAccess().getFVSTEnumLiteralDeclaration_37());
                    			

                    }


                    }
                    break;
                case 39 :
                    // InternalDbTextEditor.g:768:3: (enumLiteral_38= 'HYST' )
                    {
                    // InternalDbTextEditor.g:768:3: (enumLiteral_38= 'HYST' )
                    // InternalDbTextEditor.g:769:4: enumLiteral_38= 'HYST'
                    {
                    enumLiteral_38=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getHYSTEnumLiteralDeclaration_38().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_38, grammarAccess.getFieldnamesAccess().getHYSTEnumLiteralDeclaration_38());
                    			

                    }


                    }
                    break;
                case 40 :
                    // InternalDbTextEditor.g:776:3: (enumLiteral_39= 'LLSV' )
                    {
                    // InternalDbTextEditor.g:776:3: (enumLiteral_39= 'LLSV' )
                    // InternalDbTextEditor.g:777:4: enumLiteral_39= 'LLSV'
                    {
                    enumLiteral_39=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLLSVEnumLiteralDeclaration_39().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_39, grammarAccess.getFieldnamesAccess().getLLSVEnumLiteralDeclaration_39());
                    			

                    }


                    }
                    break;
                case 41 :
                    // InternalDbTextEditor.g:784:3: (enumLiteral_40= 'FVSV' )
                    {
                    // InternalDbTextEditor.g:784:3: (enumLiteral_40= 'FVSV' )
                    // InternalDbTextEditor.g:785:4: enumLiteral_40= 'FVSV'
                    {
                    enumLiteral_40=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getFVSVEnumLiteralDeclaration_40().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_40, grammarAccess.getFieldnamesAccess().getFVSVEnumLiteralDeclaration_40());
                    			

                    }


                    }
                    break;
                case 42 :
                    // InternalDbTextEditor.g:792:3: (enumLiteral_41= 'FVVL' )
                    {
                    // InternalDbTextEditor.g:792:3: (enumLiteral_41= 'FVVL' )
                    // InternalDbTextEditor.g:793:4: enumLiteral_41= 'FVVL'
                    {
                    enumLiteral_41=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getFVVLEnumLiteralDeclaration_41().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_41, grammarAccess.getFieldnamesAccess().getFVVLEnumLiteralDeclaration_41());
                    			

                    }


                    }
                    break;
                case 43 :
                    // InternalDbTextEditor.g:800:3: (enumLiteral_42= 'MASK' )
                    {
                    // InternalDbTextEditor.g:800:3: (enumLiteral_42= 'MASK' )
                    // InternalDbTextEditor.g:801:4: enumLiteral_42= 'MASK'
                    {
                    enumLiteral_42=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getMASKEnumLiteralDeclaration_42().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_42, grammarAccess.getFieldnamesAccess().getMASKEnumLiteralDeclaration_42());
                    			

                    }


                    }
                    break;
                case 44 :
                    // InternalDbTextEditor.g:808:3: (enumLiteral_43= 'NIST' )
                    {
                    // InternalDbTextEditor.g:808:3: (enumLiteral_43= 'NIST' )
                    // InternalDbTextEditor.g:809:4: enumLiteral_43= 'NIST'
                    {
                    enumLiteral_43=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getNISTEnumLiteralDeclaration_43().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_43, grammarAccess.getFieldnamesAccess().getNISTEnumLiteralDeclaration_43());
                    			

                    }


                    }
                    break;
                case 45 :
                    // InternalDbTextEditor.g:816:3: (enumLiteral_44= 'NISV' )
                    {
                    // InternalDbTextEditor.g:816:3: (enumLiteral_44= 'NISV' )
                    // InternalDbTextEditor.g:817:4: enumLiteral_44= 'NISV'
                    {
                    enumLiteral_44=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getNISVEnumLiteralDeclaration_44().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_44, grammarAccess.getFieldnamesAccess().getNISVEnumLiteralDeclaration_44());
                    			

                    }


                    }
                    break;
                case 46 :
                    // InternalDbTextEditor.g:824:3: (enumLiteral_45= 'NIVL' )
                    {
                    // InternalDbTextEditor.g:824:3: (enumLiteral_45= 'NIVL' )
                    // InternalDbTextEditor.g:825:4: enumLiteral_45= 'NIVL'
                    {
                    enumLiteral_45=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getNIVLEnumLiteralDeclaration_45().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_45, grammarAccess.getFieldnamesAccess().getNIVLEnumLiteralDeclaration_45());
                    			

                    }


                    }
                    break;
                case 47 :
                    // InternalDbTextEditor.g:832:3: (enumLiteral_46= 'NOBT' )
                    {
                    // InternalDbTextEditor.g:832:3: (enumLiteral_46= 'NOBT' )
                    // InternalDbTextEditor.g:833:4: enumLiteral_46= 'NOBT'
                    {
                    enumLiteral_46=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getNOBTEnumLiteralDeclaration_46().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_46, grammarAccess.getFieldnamesAccess().getNOBTEnumLiteralDeclaration_46());
                    			

                    }


                    }
                    break;
                case 48 :
                    // InternalDbTextEditor.g:840:3: (enumLiteral_47= 'ONST' )
                    {
                    // InternalDbTextEditor.g:840:3: (enumLiteral_47= 'ONST' )
                    // InternalDbTextEditor.g:841:4: enumLiteral_47= 'ONST'
                    {
                    enumLiteral_47=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getONSTEnumLiteralDeclaration_47().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_47, grammarAccess.getFieldnamesAccess().getONSTEnumLiteralDeclaration_47());
                    			

                    }


                    }
                    break;
                case 49 :
                    // InternalDbTextEditor.g:848:3: (enumLiteral_48= 'ONSV' )
                    {
                    // InternalDbTextEditor.g:848:3: (enumLiteral_48= 'ONSV' )
                    // InternalDbTextEditor.g:849:4: enumLiteral_48= 'ONSV'
                    {
                    enumLiteral_48=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getONSVEnumLiteralDeclaration_48().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_48, grammarAccess.getFieldnamesAccess().getONSVEnumLiteralDeclaration_48());
                    			

                    }


                    }
                    break;
                case 50 :
                    // InternalDbTextEditor.g:856:3: (enumLiteral_49= 'ONVL' )
                    {
                    // InternalDbTextEditor.g:856:3: (enumLiteral_49= 'ONVL' )
                    // InternalDbTextEditor.g:857:4: enumLiteral_49= 'ONVL'
                    {
                    enumLiteral_49=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getONVLEnumLiteralDeclaration_49().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_49, grammarAccess.getFieldnamesAccess().getONVLEnumLiteralDeclaration_49());
                    			

                    }


                    }
                    break;
                case 51 :
                    // InternalDbTextEditor.g:864:3: (enumLiteral_50= 'SHFT' )
                    {
                    // InternalDbTextEditor.g:864:3: (enumLiteral_50= 'SHFT' )
                    // InternalDbTextEditor.g:865:4: enumLiteral_50= 'SHFT'
                    {
                    enumLiteral_50=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSHFTEnumLiteralDeclaration_50().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_50, grammarAccess.getFieldnamesAccess().getSHFTEnumLiteralDeclaration_50());
                    			

                    }


                    }
                    break;
                case 52 :
                    // InternalDbTextEditor.g:872:3: (enumLiteral_51= 'SVST' )
                    {
                    // InternalDbTextEditor.g:872:3: (enumLiteral_51= 'SVST' )
                    // InternalDbTextEditor.g:873:4: enumLiteral_51= 'SVST'
                    {
                    enumLiteral_51=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSVSTEnumLiteralDeclaration_51().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_51, grammarAccess.getFieldnamesAccess().getSVSTEnumLiteralDeclaration_51());
                    			

                    }


                    }
                    break;
                case 53 :
                    // InternalDbTextEditor.g:880:3: (enumLiteral_52= 'SVSV' )
                    {
                    // InternalDbTextEditor.g:880:3: (enumLiteral_52= 'SVSV' )
                    // InternalDbTextEditor.g:881:4: enumLiteral_52= 'SVSV'
                    {
                    enumLiteral_52=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSVSVEnumLiteralDeclaration_52().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_52, grammarAccess.getFieldnamesAccess().getSVSVEnumLiteralDeclaration_52());
                    			

                    }


                    }
                    break;
                case 54 :
                    // InternalDbTextEditor.g:888:3: (enumLiteral_53= 'SVVL' )
                    {
                    // InternalDbTextEditor.g:888:3: (enumLiteral_53= 'SVVL' )
                    // InternalDbTextEditor.g:889:4: enumLiteral_53= 'SVVL'
                    {
                    enumLiteral_53=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSVVLEnumLiteralDeclaration_53().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_53, grammarAccess.getFieldnamesAccess().getSVVLEnumLiteralDeclaration_53());
                    			

                    }


                    }
                    break;
                case 55 :
                    // InternalDbTextEditor.g:896:3: (enumLiteral_54= 'SXST' )
                    {
                    // InternalDbTextEditor.g:896:3: (enumLiteral_54= 'SXST' )
                    // InternalDbTextEditor.g:897:4: enumLiteral_54= 'SXST'
                    {
                    enumLiteral_54=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSXSTEnumLiteralDeclaration_54().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_54, grammarAccess.getFieldnamesAccess().getSXSTEnumLiteralDeclaration_54());
                    			

                    }


                    }
                    break;
                case 56 :
                    // InternalDbTextEditor.g:904:3: (enumLiteral_55= 'SXSV' )
                    {
                    // InternalDbTextEditor.g:904:3: (enumLiteral_55= 'SXSV' )
                    // InternalDbTextEditor.g:905:4: enumLiteral_55= 'SXSV'
                    {
                    enumLiteral_55=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSXSVEnumLiteralDeclaration_55().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_55, grammarAccess.getFieldnamesAccess().getSXSVEnumLiteralDeclaration_55());
                    			

                    }


                    }
                    break;
                case 57 :
                    // InternalDbTextEditor.g:912:3: (enumLiteral_56= 'SXVL' )
                    {
                    // InternalDbTextEditor.g:912:3: (enumLiteral_56= 'SXVL' )
                    // InternalDbTextEditor.g:913:4: enumLiteral_56= 'SXVL'
                    {
                    enumLiteral_56=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSXVLEnumLiteralDeclaration_56().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_56, grammarAccess.getFieldnamesAccess().getSXVLEnumLiteralDeclaration_56());
                    			

                    }


                    }
                    break;
                case 58 :
                    // InternalDbTextEditor.g:920:3: (enumLiteral_57= 'TEST' )
                    {
                    // InternalDbTextEditor.g:920:3: (enumLiteral_57= 'TEST' )
                    // InternalDbTextEditor.g:921:4: enumLiteral_57= 'TEST'
                    {
                    enumLiteral_57=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getTESTEnumLiteralDeclaration_57().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_57, grammarAccess.getFieldnamesAccess().getTESTEnumLiteralDeclaration_57());
                    			

                    }


                    }
                    break;
                case 59 :
                    // InternalDbTextEditor.g:928:3: (enumLiteral_58= 'TESV' )
                    {
                    // InternalDbTextEditor.g:928:3: (enumLiteral_58= 'TESV' )
                    // InternalDbTextEditor.g:929:4: enumLiteral_58= 'TESV'
                    {
                    enumLiteral_58=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getTESVEnumLiteralDeclaration_58().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_58, grammarAccess.getFieldnamesAccess().getTESVEnumLiteralDeclaration_58());
                    			

                    }


                    }
                    break;
                case 60 :
                    // InternalDbTextEditor.g:936:3: (enumLiteral_59= 'TEVL' )
                    {
                    // InternalDbTextEditor.g:936:3: (enumLiteral_59= 'TEVL' )
                    // InternalDbTextEditor.g:937:4: enumLiteral_59= 'TEVL'
                    {
                    enumLiteral_59=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getTEVLEnumLiteralDeclaration_59().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_59, grammarAccess.getFieldnamesAccess().getTEVLEnumLiteralDeclaration_59());
                    			

                    }


                    }
                    break;
                case 61 :
                    // InternalDbTextEditor.g:944:3: (enumLiteral_60= 'THST' )
                    {
                    // InternalDbTextEditor.g:944:3: (enumLiteral_60= 'THST' )
                    // InternalDbTextEditor.g:945:4: enumLiteral_60= 'THST'
                    {
                    enumLiteral_60=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getTHSTEnumLiteralDeclaration_60().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_60, grammarAccess.getFieldnamesAccess().getTHSTEnumLiteralDeclaration_60());
                    			

                    }


                    }
                    break;
                case 62 :
                    // InternalDbTextEditor.g:952:3: (enumLiteral_61= 'THSV' )
                    {
                    // InternalDbTextEditor.g:952:3: (enumLiteral_61= 'THSV' )
                    // InternalDbTextEditor.g:953:4: enumLiteral_61= 'THSV'
                    {
                    enumLiteral_61=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getTHSVEnumLiteralDeclaration_61().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_61, grammarAccess.getFieldnamesAccess().getTHSVEnumLiteralDeclaration_61());
                    			

                    }


                    }
                    break;
                case 63 :
                    // InternalDbTextEditor.g:960:3: (enumLiteral_62= 'THVL' )
                    {
                    // InternalDbTextEditor.g:960:3: (enumLiteral_62= 'THVL' )
                    // InternalDbTextEditor.g:961:4: enumLiteral_62= 'THVL'
                    {
                    enumLiteral_62=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getTHVLEnumLiteralDeclaration_62().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_62, grammarAccess.getFieldnamesAccess().getTHVLEnumLiteralDeclaration_62());
                    			

                    }


                    }
                    break;
                case 64 :
                    // InternalDbTextEditor.g:968:3: (enumLiteral_63= 'TWST' )
                    {
                    // InternalDbTextEditor.g:968:3: (enumLiteral_63= 'TWST' )
                    // InternalDbTextEditor.g:969:4: enumLiteral_63= 'TWST'
                    {
                    enumLiteral_63=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getTWSTEnumLiteralDeclaration_63().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_63, grammarAccess.getFieldnamesAccess().getTWSTEnumLiteralDeclaration_63());
                    			

                    }


                    }
                    break;
                case 65 :
                    // InternalDbTextEditor.g:976:3: (enumLiteral_64= 'TWSV' )
                    {
                    // InternalDbTextEditor.g:976:3: (enumLiteral_64= 'TWSV' )
                    // InternalDbTextEditor.g:977:4: enumLiteral_64= 'TWSV'
                    {
                    enumLiteral_64=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getTWSVEnumLiteralDeclaration_64().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_64, grammarAccess.getFieldnamesAccess().getTWSVEnumLiteralDeclaration_64());
                    			

                    }


                    }
                    break;
                case 66 :
                    // InternalDbTextEditor.g:984:3: (enumLiteral_65= 'TWVL' )
                    {
                    // InternalDbTextEditor.g:984:3: (enumLiteral_65= 'TWVL' )
                    // InternalDbTextEditor.g:985:4: enumLiteral_65= 'TWVL'
                    {
                    enumLiteral_65=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getTWVLEnumLiteralDeclaration_65().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_65, grammarAccess.getFieldnamesAccess().getTWVLEnumLiteralDeclaration_65());
                    			

                    }


                    }
                    break;
                case 67 :
                    // InternalDbTextEditor.g:992:3: (enumLiteral_66= 'UNSV' )
                    {
                    // InternalDbTextEditor.g:992:3: (enumLiteral_66= 'UNSV' )
                    // InternalDbTextEditor.g:993:4: enumLiteral_66= 'UNSV'
                    {
                    enumLiteral_66=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getUNSVEnumLiteralDeclaration_66().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_66, grammarAccess.getFieldnamesAccess().getUNSVEnumLiteralDeclaration_66());
                    			

                    }


                    }
                    break;
                case 68 :
                    // InternalDbTextEditor.g:1000:3: (enumLiteral_67= 'ZRST' )
                    {
                    // InternalDbTextEditor.g:1000:3: (enumLiteral_67= 'ZRST' )
                    // InternalDbTextEditor.g:1001:4: enumLiteral_67= 'ZRST'
                    {
                    enumLiteral_67=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getZRSTEnumLiteralDeclaration_67().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_67, grammarAccess.getFieldnamesAccess().getZRSTEnumLiteralDeclaration_67());
                    			

                    }


                    }
                    break;
                case 69 :
                    // InternalDbTextEditor.g:1008:3: (enumLiteral_68= 'ZRSV' )
                    {
                    // InternalDbTextEditor.g:1008:3: (enumLiteral_68= 'ZRSV' )
                    // InternalDbTextEditor.g:1009:4: enumLiteral_68= 'ZRSV'
                    {
                    enumLiteral_68=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getZRSVEnumLiteralDeclaration_68().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_68, grammarAccess.getFieldnamesAccess().getZRSVEnumLiteralDeclaration_68());
                    			

                    }


                    }
                    break;
                case 70 :
                    // InternalDbTextEditor.g:1016:3: (enumLiteral_69= 'ZRVL' )
                    {
                    // InternalDbTextEditor.g:1016:3: (enumLiteral_69= 'ZRVL' )
                    // InternalDbTextEditor.g:1017:4: enumLiteral_69= 'ZRVL'
                    {
                    enumLiteral_69=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getZRVLEnumLiteralDeclaration_69().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_69, grammarAccess.getFieldnamesAccess().getZRVLEnumLiteralDeclaration_69());
                    			

                    }


                    }
                    break;
                case 71 :
                    // InternalDbTextEditor.g:1024:3: (enumLiteral_70= 'LOLO' )
                    {
                    // InternalDbTextEditor.g:1024:3: (enumLiteral_70= 'LOLO' )
                    // InternalDbTextEditor.g:1025:4: enumLiteral_70= 'LOLO'
                    {
                    enumLiteral_70=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLOLOEnumLiteralDeclaration_70().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_70, grammarAccess.getFieldnamesAccess().getLOLOEnumLiteralDeclaration_70());
                    			

                    }


                    }
                    break;
                case 72 :
                    // InternalDbTextEditor.g:1032:3: (enumLiteral_71= 'LOW' )
                    {
                    // InternalDbTextEditor.g:1032:3: (enumLiteral_71= 'LOW' )
                    // InternalDbTextEditor.g:1033:4: enumLiteral_71= 'LOW'
                    {
                    enumLiteral_71=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLOWEnumLiteralDeclaration_71().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_71, grammarAccess.getFieldnamesAccess().getLOWEnumLiteralDeclaration_71());
                    			

                    }


                    }
                    break;
                case 73 :
                    // InternalDbTextEditor.g:1040:3: (enumLiteral_72= 'LSV' )
                    {
                    // InternalDbTextEditor.g:1040:3: (enumLiteral_72= 'LSV' )
                    // InternalDbTextEditor.g:1041:4: enumLiteral_72= 'LSV'
                    {
                    enumLiteral_72=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLSVEnumLiteralDeclaration_72().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_72, grammarAccess.getFieldnamesAccess().getLSVEnumLiteralDeclaration_72());
                    			

                    }


                    }
                    break;
                case 74 :
                    // InternalDbTextEditor.g:1048:3: (enumLiteral_73= 'SSCN' )
                    {
                    // InternalDbTextEditor.g:1048:3: (enumLiteral_73= 'SSCN' )
                    // InternalDbTextEditor.g:1049:4: enumLiteral_73= 'SSCN'
                    {
                    enumLiteral_73=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSSCNEnumLiteralDeclaration_73().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_73, grammarAccess.getFieldnamesAccess().getSSCNEnumLiteralDeclaration_73());
                    			

                    }


                    }
                    break;
                case 75 :
                    // InternalDbTextEditor.g:1056:3: (enumLiteral_74= 'TSE' )
                    {
                    // InternalDbTextEditor.g:1056:3: (enumLiteral_74= 'TSE' )
                    // InternalDbTextEditor.g:1057:4: enumLiteral_74= 'TSE'
                    {
                    enumLiteral_74=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getTSEEnumLiteralDeclaration_74().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_74, grammarAccess.getFieldnamesAccess().getTSEEnumLiteralDeclaration_74());
                    			

                    }


                    }
                    break;
                case 76 :
                    // InternalDbTextEditor.g:1064:3: (enumLiteral_75= 'PREC' )
                    {
                    // InternalDbTextEditor.g:1064:3: (enumLiteral_75= 'PREC' )
                    // InternalDbTextEditor.g:1065:4: enumLiteral_75= 'PREC'
                    {
                    enumLiteral_75=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getPRECEnumLiteralDeclaration_75().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_75, grammarAccess.getFieldnamesAccess().getPRECEnumLiteralDeclaration_75());
                    			

                    }


                    }
                    break;
                case 77 :
                    // InternalDbTextEditor.g:1072:3: (enumLiteral_76= 'DRVH' )
                    {
                    // InternalDbTextEditor.g:1072:3: (enumLiteral_76= 'DRVH' )
                    // InternalDbTextEditor.g:1073:4: enumLiteral_76= 'DRVH'
                    {
                    enumLiteral_76=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getDRVHEnumLiteralDeclaration_76().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_76, grammarAccess.getFieldnamesAccess().getDRVHEnumLiteralDeclaration_76());
                    			

                    }


                    }
                    break;
                case 78 :
                    // InternalDbTextEditor.g:1080:3: (enumLiteral_77= 'LOPR' )
                    {
                    // InternalDbTextEditor.g:1080:3: (enumLiteral_77= 'LOPR' )
                    // InternalDbTextEditor.g:1081:4: enumLiteral_77= 'LOPR'
                    {
                    enumLiteral_77=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLOPREnumLiteralDeclaration_77().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_77, grammarAccess.getFieldnamesAccess().getLOPREnumLiteralDeclaration_77());
                    			

                    }


                    }
                    break;
                case 79 :
                    // InternalDbTextEditor.g:1088:3: (enumLiteral_78= 'DRVL' )
                    {
                    // InternalDbTextEditor.g:1088:3: (enumLiteral_78= 'DRVL' )
                    // InternalDbTextEditor.g:1089:4: enumLiteral_78= 'DRVL'
                    {
                    enumLiteral_78=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getDRVLEnumLiteralDeclaration_78().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_78, grammarAccess.getFieldnamesAccess().getDRVLEnumLiteralDeclaration_78());
                    			

                    }


                    }
                    break;
                case 80 :
                    // InternalDbTextEditor.g:1096:3: (enumLiteral_79= 'HOPR' )
                    {
                    // InternalDbTextEditor.g:1096:3: (enumLiteral_79= 'HOPR' )
                    // InternalDbTextEditor.g:1097:4: enumLiteral_79= 'HOPR'
                    {
                    enumLiteral_79=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getHOPREnumLiteralDeclaration_79().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_79, grammarAccess.getFieldnamesAccess().getHOPREnumLiteralDeclaration_79());
                    			

                    }


                    }
                    break;
                case 81 :
                    // InternalDbTextEditor.g:1104:3: (enumLiteral_80= 'CALC' )
                    {
                    // InternalDbTextEditor.g:1104:3: (enumLiteral_80= 'CALC' )
                    // InternalDbTextEditor.g:1105:4: enumLiteral_80= 'CALC'
                    {
                    enumLiteral_80=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getCALCEnumLiteralDeclaration_80().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_80, grammarAccess.getFieldnamesAccess().getCALCEnumLiteralDeclaration_80());
                    			

                    }


                    }
                    break;
                case 82 :
                    // InternalDbTextEditor.g:1112:3: (enumLiteral_81= 'INPA' )
                    {
                    // InternalDbTextEditor.g:1112:3: (enumLiteral_81= 'INPA' )
                    // InternalDbTextEditor.g:1113:4: enumLiteral_81= 'INPA'
                    {
                    enumLiteral_81=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPAEnumLiteralDeclaration_81().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_81, grammarAccess.getFieldnamesAccess().getINPAEnumLiteralDeclaration_81());
                    			

                    }


                    }
                    break;
                case 83 :
                    // InternalDbTextEditor.g:1120:3: (enumLiteral_82= 'INPB' )
                    {
                    // InternalDbTextEditor.g:1120:3: (enumLiteral_82= 'INPB' )
                    // InternalDbTextEditor.g:1121:4: enumLiteral_82= 'INPB'
                    {
                    enumLiteral_82=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPBEnumLiteralDeclaration_82().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_82, grammarAccess.getFieldnamesAccess().getINPBEnumLiteralDeclaration_82());
                    			

                    }


                    }
                    break;
                case 84 :
                    // InternalDbTextEditor.g:1128:3: (enumLiteral_83= 'INPC' )
                    {
                    // InternalDbTextEditor.g:1128:3: (enumLiteral_83= 'INPC' )
                    // InternalDbTextEditor.g:1129:4: enumLiteral_83= 'INPC'
                    {
                    enumLiteral_83=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPCEnumLiteralDeclaration_83().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_83, grammarAccess.getFieldnamesAccess().getINPCEnumLiteralDeclaration_83());
                    			

                    }


                    }
                    break;
                case 85 :
                    // InternalDbTextEditor.g:1136:3: (enumLiteral_84= 'INPD' )
                    {
                    // InternalDbTextEditor.g:1136:3: (enumLiteral_84= 'INPD' )
                    // InternalDbTextEditor.g:1137:4: enumLiteral_84= 'INPD'
                    {
                    enumLiteral_84=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPDEnumLiteralDeclaration_84().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_84, grammarAccess.getFieldnamesAccess().getINPDEnumLiteralDeclaration_84());
                    			

                    }


                    }
                    break;
                case 86 :
                    // InternalDbTextEditor.g:1144:3: (enumLiteral_85= 'FLNK' )
                    {
                    // InternalDbTextEditor.g:1144:3: (enumLiteral_85= 'FLNK' )
                    // InternalDbTextEditor.g:1145:4: enumLiteral_85= 'FLNK'
                    {
                    enumLiteral_85=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getFLNKEnumLiteralDeclaration_85().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_85, grammarAccess.getFieldnamesAccess().getFLNKEnumLiteralDeclaration_85());
                    			

                    }


                    }
                    break;
                case 87 :
                    // InternalDbTextEditor.g:1152:3: (enumLiteral_86= 'INPE' )
                    {
                    // InternalDbTextEditor.g:1152:3: (enumLiteral_86= 'INPE' )
                    // InternalDbTextEditor.g:1153:4: enumLiteral_86= 'INPE'
                    {
                    enumLiteral_86=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPEEnumLiteralDeclaration_86().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_86, grammarAccess.getFieldnamesAccess().getINPEEnumLiteralDeclaration_86());
                    			

                    }


                    }
                    break;
                case 88 :
                    // InternalDbTextEditor.g:1160:3: (enumLiteral_87= 'INPF' )
                    {
                    // InternalDbTextEditor.g:1160:3: (enumLiteral_87= 'INPF' )
                    // InternalDbTextEditor.g:1161:4: enumLiteral_87= 'INPF'
                    {
                    enumLiteral_87=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPFEnumLiteralDeclaration_87().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_87, grammarAccess.getFieldnamesAccess().getINPFEnumLiteralDeclaration_87());
                    			

                    }


                    }
                    break;
                case 89 :
                    // InternalDbTextEditor.g:1168:3: (enumLiteral_88= 'INPG' )
                    {
                    // InternalDbTextEditor.g:1168:3: (enumLiteral_88= 'INPG' )
                    // InternalDbTextEditor.g:1169:4: enumLiteral_88= 'INPG'
                    {
                    enumLiteral_88=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPGEnumLiteralDeclaration_88().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_88, grammarAccess.getFieldnamesAccess().getINPGEnumLiteralDeclaration_88());
                    			

                    }


                    }
                    break;
                case 90 :
                    // InternalDbTextEditor.g:1176:3: (enumLiteral_89= 'INPH' )
                    {
                    // InternalDbTextEditor.g:1176:3: (enumLiteral_89= 'INPH' )
                    // InternalDbTextEditor.g:1177:4: enumLiteral_89= 'INPH'
                    {
                    enumLiteral_89=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPHEnumLiteralDeclaration_89().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_89, grammarAccess.getFieldnamesAccess().getINPHEnumLiteralDeclaration_89());
                    			

                    }


                    }
                    break;
                case 91 :
                    // InternalDbTextEditor.g:1184:3: (enumLiteral_90= 'INPI' )
                    {
                    // InternalDbTextEditor.g:1184:3: (enumLiteral_90= 'INPI' )
                    // InternalDbTextEditor.g:1185:4: enumLiteral_90= 'INPI'
                    {
                    enumLiteral_90=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPIEnumLiteralDeclaration_90().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_90, grammarAccess.getFieldnamesAccess().getINPIEnumLiteralDeclaration_90());
                    			

                    }


                    }
                    break;
                case 92 :
                    // InternalDbTextEditor.g:1192:3: (enumLiteral_91= 'INPJ' )
                    {
                    // InternalDbTextEditor.g:1192:3: (enumLiteral_91= 'INPJ' )
                    // InternalDbTextEditor.g:1193:4: enumLiteral_91= 'INPJ'
                    {
                    enumLiteral_91=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPJEnumLiteralDeclaration_91().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_91, grammarAccess.getFieldnamesAccess().getINPJEnumLiteralDeclaration_91());
                    			

                    }


                    }
                    break;
                case 93 :
                    // InternalDbTextEditor.g:1200:3: (enumLiteral_92= 'INPK' )
                    {
                    // InternalDbTextEditor.g:1200:3: (enumLiteral_92= 'INPK' )
                    // InternalDbTextEditor.g:1201:4: enumLiteral_92= 'INPK'
                    {
                    enumLiteral_92=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPKEnumLiteralDeclaration_92().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_92, grammarAccess.getFieldnamesAccess().getINPKEnumLiteralDeclaration_92());
                    			

                    }


                    }
                    break;
                case 94 :
                    // InternalDbTextEditor.g:1208:3: (enumLiteral_93= 'INAA' )
                    {
                    // InternalDbTextEditor.g:1208:3: (enumLiteral_93= 'INAA' )
                    // InternalDbTextEditor.g:1209:4: enumLiteral_93= 'INAA'
                    {
                    enumLiteral_93=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINAAEnumLiteralDeclaration_93().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_93, grammarAccess.getFieldnamesAccess().getINAAEnumLiteralDeclaration_93());
                    			

                    }


                    }
                    break;
                case 95 :
                    // InternalDbTextEditor.g:1216:3: (enumLiteral_94= 'INBB' )
                    {
                    // InternalDbTextEditor.g:1216:3: (enumLiteral_94= 'INBB' )
                    // InternalDbTextEditor.g:1217:4: enumLiteral_94= 'INBB'
                    {
                    enumLiteral_94=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINBBEnumLiteralDeclaration_94().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_94, grammarAccess.getFieldnamesAccess().getINBBEnumLiteralDeclaration_94());
                    			

                    }


                    }
                    break;
                case 96 :
                    // InternalDbTextEditor.g:1224:3: (enumLiteral_95= 'INCC' )
                    {
                    // InternalDbTextEditor.g:1224:3: (enumLiteral_95= 'INCC' )
                    // InternalDbTextEditor.g:1225:4: enumLiteral_95= 'INCC'
                    {
                    enumLiteral_95=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINCCEnumLiteralDeclaration_95().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_95, grammarAccess.getFieldnamesAccess().getINCCEnumLiteralDeclaration_95());
                    			

                    }


                    }
                    break;
                case 97 :
                    // InternalDbTextEditor.g:1232:3: (enumLiteral_96= 'SIOL' )
                    {
                    // InternalDbTextEditor.g:1232:3: (enumLiteral_96= 'SIOL' )
                    // InternalDbTextEditor.g:1233:4: enumLiteral_96= 'SIOL'
                    {
                    enumLiteral_96=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSIOLEnumLiteralDeclaration_96().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_96, grammarAccess.getFieldnamesAccess().getSIOLEnumLiteralDeclaration_96());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFieldnames"


    // $ANTLR start "ruleRecordnames"
    // InternalDbTextEditor.g:1243:1: ruleRecordnames returns [Enumerator current=null] : ( (enumLiteral_0= 'ai' ) | (enumLiteral_1= 'ao' ) | (enumLiteral_2= 'longin' ) | (enumLiteral_3= 'longout' ) | (enumLiteral_4= 'stringin' ) | (enumLiteral_5= 'stringout' ) | (enumLiteral_6= 'lsi' ) | (enumLiteral_7= 'lso' ) | (enumLiteral_8= 'waveform' ) | (enumLiteral_9= 'bi' ) | (enumLiteral_10= 'bo' ) | (enumLiteral_11= 'mbbi' ) | (enumLiteral_12= 'mbbo' ) | (enumLiteral_13= 'mbbiDirect' ) | (enumLiteral_14= 'mbboDirect' ) | (enumLiteral_15= 'calcout' ) | (enumLiteral_16= 'scalcout' ) | (enumLiteral_17= 'calc' ) ) ;
    public final Enumerator ruleRecordnames() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;


        	enterRule();

        try {
            // InternalDbTextEditor.g:1249:2: ( ( (enumLiteral_0= 'ai' ) | (enumLiteral_1= 'ao' ) | (enumLiteral_2= 'longin' ) | (enumLiteral_3= 'longout' ) | (enumLiteral_4= 'stringin' ) | (enumLiteral_5= 'stringout' ) | (enumLiteral_6= 'lsi' ) | (enumLiteral_7= 'lso' ) | (enumLiteral_8= 'waveform' ) | (enumLiteral_9= 'bi' ) | (enumLiteral_10= 'bo' ) | (enumLiteral_11= 'mbbi' ) | (enumLiteral_12= 'mbbo' ) | (enumLiteral_13= 'mbbiDirect' ) | (enumLiteral_14= 'mbboDirect' ) | (enumLiteral_15= 'calcout' ) | (enumLiteral_16= 'scalcout' ) | (enumLiteral_17= 'calc' ) ) )
            // InternalDbTextEditor.g:1250:2: ( (enumLiteral_0= 'ai' ) | (enumLiteral_1= 'ao' ) | (enumLiteral_2= 'longin' ) | (enumLiteral_3= 'longout' ) | (enumLiteral_4= 'stringin' ) | (enumLiteral_5= 'stringout' ) | (enumLiteral_6= 'lsi' ) | (enumLiteral_7= 'lso' ) | (enumLiteral_8= 'waveform' ) | (enumLiteral_9= 'bi' ) | (enumLiteral_10= 'bo' ) | (enumLiteral_11= 'mbbi' ) | (enumLiteral_12= 'mbbo' ) | (enumLiteral_13= 'mbbiDirect' ) | (enumLiteral_14= 'mbboDirect' ) | (enumLiteral_15= 'calcout' ) | (enumLiteral_16= 'scalcout' ) | (enumLiteral_17= 'calc' ) )
            {
            // InternalDbTextEditor.g:1250:2: ( (enumLiteral_0= 'ai' ) | (enumLiteral_1= 'ao' ) | (enumLiteral_2= 'longin' ) | (enumLiteral_3= 'longout' ) | (enumLiteral_4= 'stringin' ) | (enumLiteral_5= 'stringout' ) | (enumLiteral_6= 'lsi' ) | (enumLiteral_7= 'lso' ) | (enumLiteral_8= 'waveform' ) | (enumLiteral_9= 'bi' ) | (enumLiteral_10= 'bo' ) | (enumLiteral_11= 'mbbi' ) | (enumLiteral_12= 'mbbo' ) | (enumLiteral_13= 'mbbiDirect' ) | (enumLiteral_14= 'mbboDirect' ) | (enumLiteral_15= 'calcout' ) | (enumLiteral_16= 'scalcout' ) | (enumLiteral_17= 'calc' ) )
            int alt6=18;
            switch ( input.LA(1) ) {
            case 118:
                {
                alt6=1;
                }
                break;
            case 119:
                {
                alt6=2;
                }
                break;
            case 120:
                {
                alt6=3;
                }
                break;
            case 121:
                {
                alt6=4;
                }
                break;
            case 122:
                {
                alt6=5;
                }
                break;
            case 123:
                {
                alt6=6;
                }
                break;
            case 124:
                {
                alt6=7;
                }
                break;
            case 125:
                {
                alt6=8;
                }
                break;
            case 126:
                {
                alt6=9;
                }
                break;
            case 127:
                {
                alt6=10;
                }
                break;
            case 128:
                {
                alt6=11;
                }
                break;
            case 129:
                {
                alt6=12;
                }
                break;
            case 130:
                {
                alt6=13;
                }
                break;
            case 131:
                {
                alt6=14;
                }
                break;
            case 132:
                {
                alt6=15;
                }
                break;
            case 133:
                {
                alt6=16;
                }
                break;
            case 134:
                {
                alt6=17;
                }
                break;
            case 135:
                {
                alt6=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalDbTextEditor.g:1251:3: (enumLiteral_0= 'ai' )
                    {
                    // InternalDbTextEditor.g:1251:3: (enumLiteral_0= 'ai' )
                    // InternalDbTextEditor.g:1252:4: enumLiteral_0= 'ai'
                    {
                    enumLiteral_0=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getRecordnamesAccess().getAiEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getRecordnamesAccess().getAiEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDbTextEditor.g:1259:3: (enumLiteral_1= 'ao' )
                    {
                    // InternalDbTextEditor.g:1259:3: (enumLiteral_1= 'ao' )
                    // InternalDbTextEditor.g:1260:4: enumLiteral_1= 'ao'
                    {
                    enumLiteral_1=(Token)match(input,119,FOLLOW_2); 

                    				current = grammarAccess.getRecordnamesAccess().getAoEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getRecordnamesAccess().getAoEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDbTextEditor.g:1267:3: (enumLiteral_2= 'longin' )
                    {
                    // InternalDbTextEditor.g:1267:3: (enumLiteral_2= 'longin' )
                    // InternalDbTextEditor.g:1268:4: enumLiteral_2= 'longin'
                    {
                    enumLiteral_2=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getRecordnamesAccess().getLonginEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getRecordnamesAccess().getLonginEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDbTextEditor.g:1275:3: (enumLiteral_3= 'longout' )
                    {
                    // InternalDbTextEditor.g:1275:3: (enumLiteral_3= 'longout' )
                    // InternalDbTextEditor.g:1276:4: enumLiteral_3= 'longout'
                    {
                    enumLiteral_3=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getRecordnamesAccess().getLongoutEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getRecordnamesAccess().getLongoutEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDbTextEditor.g:1283:3: (enumLiteral_4= 'stringin' )
                    {
                    // InternalDbTextEditor.g:1283:3: (enumLiteral_4= 'stringin' )
                    // InternalDbTextEditor.g:1284:4: enumLiteral_4= 'stringin'
                    {
                    enumLiteral_4=(Token)match(input,122,FOLLOW_2); 

                    				current = grammarAccess.getRecordnamesAccess().getStringinEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getRecordnamesAccess().getStringinEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalDbTextEditor.g:1291:3: (enumLiteral_5= 'stringout' )
                    {
                    // InternalDbTextEditor.g:1291:3: (enumLiteral_5= 'stringout' )
                    // InternalDbTextEditor.g:1292:4: enumLiteral_5= 'stringout'
                    {
                    enumLiteral_5=(Token)match(input,123,FOLLOW_2); 

                    				current = grammarAccess.getRecordnamesAccess().getStringoutEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getRecordnamesAccess().getStringoutEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalDbTextEditor.g:1299:3: (enumLiteral_6= 'lsi' )
                    {
                    // InternalDbTextEditor.g:1299:3: (enumLiteral_6= 'lsi' )
                    // InternalDbTextEditor.g:1300:4: enumLiteral_6= 'lsi'
                    {
                    enumLiteral_6=(Token)match(input,124,FOLLOW_2); 

                    				current = grammarAccess.getRecordnamesAccess().getLsiEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getRecordnamesAccess().getLsiEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalDbTextEditor.g:1307:3: (enumLiteral_7= 'lso' )
                    {
                    // InternalDbTextEditor.g:1307:3: (enumLiteral_7= 'lso' )
                    // InternalDbTextEditor.g:1308:4: enumLiteral_7= 'lso'
                    {
                    enumLiteral_7=(Token)match(input,125,FOLLOW_2); 

                    				current = grammarAccess.getRecordnamesAccess().getLsoEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getRecordnamesAccess().getLsoEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalDbTextEditor.g:1315:3: (enumLiteral_8= 'waveform' )
                    {
                    // InternalDbTextEditor.g:1315:3: (enumLiteral_8= 'waveform' )
                    // InternalDbTextEditor.g:1316:4: enumLiteral_8= 'waveform'
                    {
                    enumLiteral_8=(Token)match(input,126,FOLLOW_2); 

                    				current = grammarAccess.getRecordnamesAccess().getWaveformEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getRecordnamesAccess().getWaveformEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalDbTextEditor.g:1323:3: (enumLiteral_9= 'bi' )
                    {
                    // InternalDbTextEditor.g:1323:3: (enumLiteral_9= 'bi' )
                    // InternalDbTextEditor.g:1324:4: enumLiteral_9= 'bi'
                    {
                    enumLiteral_9=(Token)match(input,127,FOLLOW_2); 

                    				current = grammarAccess.getRecordnamesAccess().getBiEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getRecordnamesAccess().getBiEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalDbTextEditor.g:1331:3: (enumLiteral_10= 'bo' )
                    {
                    // InternalDbTextEditor.g:1331:3: (enumLiteral_10= 'bo' )
                    // InternalDbTextEditor.g:1332:4: enumLiteral_10= 'bo'
                    {
                    enumLiteral_10=(Token)match(input,128,FOLLOW_2); 

                    				current = grammarAccess.getRecordnamesAccess().getBoEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getRecordnamesAccess().getBoEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalDbTextEditor.g:1339:3: (enumLiteral_11= 'mbbi' )
                    {
                    // InternalDbTextEditor.g:1339:3: (enumLiteral_11= 'mbbi' )
                    // InternalDbTextEditor.g:1340:4: enumLiteral_11= 'mbbi'
                    {
                    enumLiteral_11=(Token)match(input,129,FOLLOW_2); 

                    				current = grammarAccess.getRecordnamesAccess().getMbbiEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getRecordnamesAccess().getMbbiEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalDbTextEditor.g:1347:3: (enumLiteral_12= 'mbbo' )
                    {
                    // InternalDbTextEditor.g:1347:3: (enumLiteral_12= 'mbbo' )
                    // InternalDbTextEditor.g:1348:4: enumLiteral_12= 'mbbo'
                    {
                    enumLiteral_12=(Token)match(input,130,FOLLOW_2); 

                    				current = grammarAccess.getRecordnamesAccess().getMbboEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getRecordnamesAccess().getMbboEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalDbTextEditor.g:1355:3: (enumLiteral_13= 'mbbiDirect' )
                    {
                    // InternalDbTextEditor.g:1355:3: (enumLiteral_13= 'mbbiDirect' )
                    // InternalDbTextEditor.g:1356:4: enumLiteral_13= 'mbbiDirect'
                    {
                    enumLiteral_13=(Token)match(input,131,FOLLOW_2); 

                    				current = grammarAccess.getRecordnamesAccess().getMbbiDirectEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getRecordnamesAccess().getMbbiDirectEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalDbTextEditor.g:1363:3: (enumLiteral_14= 'mbboDirect' )
                    {
                    // InternalDbTextEditor.g:1363:3: (enumLiteral_14= 'mbboDirect' )
                    // InternalDbTextEditor.g:1364:4: enumLiteral_14= 'mbboDirect'
                    {
                    enumLiteral_14=(Token)match(input,132,FOLLOW_2); 

                    				current = grammarAccess.getRecordnamesAccess().getMbboDirectEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getRecordnamesAccess().getMbboDirectEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalDbTextEditor.g:1371:3: (enumLiteral_15= 'calcout' )
                    {
                    // InternalDbTextEditor.g:1371:3: (enumLiteral_15= 'calcout' )
                    // InternalDbTextEditor.g:1372:4: enumLiteral_15= 'calcout'
                    {
                    enumLiteral_15=(Token)match(input,133,FOLLOW_2); 

                    				current = grammarAccess.getRecordnamesAccess().getCalcoutEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getRecordnamesAccess().getCalcoutEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalDbTextEditor.g:1379:3: (enumLiteral_16= 'scalcout' )
                    {
                    // InternalDbTextEditor.g:1379:3: (enumLiteral_16= 'scalcout' )
                    // InternalDbTextEditor.g:1380:4: enumLiteral_16= 'scalcout'
                    {
                    enumLiteral_16=(Token)match(input,134,FOLLOW_2); 

                    				current = grammarAccess.getRecordnamesAccess().getScalcoutEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getRecordnamesAccess().getScalcoutEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalDbTextEditor.g:1387:3: (enumLiteral_17= 'calc' )
                    {
                    // InternalDbTextEditor.g:1387:3: (enumLiteral_17= 'calc' )
                    // InternalDbTextEditor.g:1388:4: enumLiteral_17= 'calc'
                    {
                    enumLiteral_17=(Token)match(input,135,FOLLOW_2); 

                    				current = grammarAccess.getRecordnamesAccess().getCalcEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getRecordnamesAccess().getCalcEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRecordnames"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0xFFC0000000000000L,0x00000000000000FFL});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0xFFFFFFFFFFE00000L,0x003FFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000020L});

}