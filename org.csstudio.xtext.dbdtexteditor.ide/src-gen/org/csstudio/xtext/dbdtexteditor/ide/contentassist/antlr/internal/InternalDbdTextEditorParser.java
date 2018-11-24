package org.csstudio.xtext.dbdtexteditor.ide.contentassist.antlr.internal;

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
import org.csstudio.xtext.dbdtexteditor.services.DbdTextEditorGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDbdTextEditorParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INT", "RULE_SL_COMMENT", "RULE_ID", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'serialPRTY'", "'waveformPOST'", "'aaoPOST'", "'menuPriority'", "'serialSBIT'", "'calcoutDOPT'", "'SDIS'", "'menuOmsl'", "'menuFtype'", "'stringinPOST'", "'menuPini'", "'dfanoutSELM'", "'menuScan'", "'gpibACMD'", "'aSubLFLG'", "'asynTMOD'", "'scalerD1'", "'menuPost'", "'asynINTERFACE'", "'menuAlarmStat'", "'aoOIF'", "'bufferingALG'", "'aaiPOST'", "'epidFeedbackState'", "'calcoutINAV'", "'asynAUTOCONNECT'", "'asynFMT'", "'asynCONNECT'", "'gpibUCMD'", "'serialBAUD'", "'histogramCMD'", "'asynTRACE'", "'scalerG1'", "'asynEOMREASON'", "'scalerCONT'", "'menuIvoa'", "'stringoutPOST'", "'menuAlarmSevr'", "'serialMCTL'", "'serialFCTL'", "'menuSimm'", "'compressALG'", "'aSubEFLG'", "'fanoutSELM'", "'calcoutOOPT'", "'asynENABLE'", "'epidFeedbackMode'", "'menuConvert'", "'scalerCNT'", "'serialIX'", "'menuYesNo'", "'timestampTST'", "'serialDBIT'", "'selSELM'", "'serialPRTY_unknown'", "'serialPRTY_None'", "'serialPRTY_Even'", "'serialPRTY_Odd'", "'waveformPOST_Always'", "'waveformPOST_OnChange'", "'aaoPOST_Always'", "'aaoPOST_OnChange'", "'menuPriorityLOW'", "'menuPriorityMEDIUM'", "'menuPriorityHIGH'", "'serialSBIT_unknown'", "'serialSBIT_1'", "'serialSBIT_2'", "'calcoutDOPT_Use_VAL'", "'calcoutDOPT_Use_OVAL'", "'menuOmslsupervisory'", "'menuOmslclosed_loop'", "'menuFtypeSTRING'", "'menuFtypeCHAR'", "'menuFtypeUCHAR'", "'menuFtypeSHORT'", "'menuFtypeUSHORT'", "'menuFtypeLONG'", "'menuFtypeULONG'", "'menuFtypeINT64'", "'menuFtypeUINT64'", "'menuFtypeFLOAT'", "'menuFtypeDOUBLE'", "'menuFtypeENUM'", "'stringinPOST_OnChange'", "'stringinPOST_Always'", "'menuPiniNO'", "'menuPiniYES'", "'menuPiniRUN'", "'menuPiniRUNNING'", "'menuPiniPAUSE'", "'menuPiniPAUSED'", "'dfanoutSELM_All'", "'dfanoutSELM_Specified'", "'dfanoutSELM_Mask'", "'menuScanPassive'", "'menuScanEvent'", "'menuScanI_O_Intr'", "'menuScan10_second'", "'menuScan5_second'", "'menuScan2_second'", "'menuScan1_second'", "'menuScan_5_second'", "'menuScan_2_second'", "'menuScan_1_second'", "'gpibACMD_None'", "'gpibACMD_Group_Execute_Trig___GET_'", "'gpibACMD_Go_To_Local__GTL_'", "'gpibACMD_Selected_Dev__Clear__SDC_'", "'gpibACMD_Take_Control__TCT_'", "'gpibACMD_Serial_Poll'", "'aSubLFLG_IGNORE'", "'aSubLFLG_READ'", "'asynTMOD_Write_Read'", "'asynTMOD_Write'", "'asynTMOD_Read'", "'asynTMOD_Flush'", "'asynTMOD_NoIO'", "'ipDRTO_unknown'", "'ipDRTO_No'", "'ipDRTO_Yes'", "'scalerD1_Up'", "'scalerD1_Dn'", "'menuPost_OnChange'", "'menuPost_Always'", "'asynINTERFACE_OCTET'", "'asynINTERFACE_INT32'", "'asynINTERFACE_UINT32'", "'asynINTERFACE_FLOAT64'", "'menuAlarmStatNO_ALARM'", "'menuAlarmStatREAD'", "'menuAlarmStatWRITE'", "'menuAlarmStatHIHI'", "'menuAlarmStatHIGH'", "'menuAlarmStatLOLO'", "'menuAlarmStatLOW'", "'menuAlarmStatSTATE'", "'menuAlarmStatCOS'", "'menuAlarmStatCOMM'", "'menuAlarmStatTIMEOUT'", "'menuAlarmStatHWLIMIT'", "'menuAlarmStatCALC'", "'menuAlarmStatSCAN'", "'menuAlarmStatLINK'", "'menuAlarmStatSOFT'", "'menuAlarmStatBAD_SUB'", "'menuAlarmStatUDF'", "'menuAlarmStatDISABLE'", "'menuAlarmStatSIMM'", "'menuAlarmStatREAD_ACCESS'", "'menuAlarmStatWRITE_ACCESS'", "'aoOIF_Full'", "'aoOIF_Incremental'", "'bufferingALG_FIFO'", "'bufferingALG_LIFO'", "'aaiPOST_Always'", "'aaiPOST_OnChange'", "'epidFeedbackState_Off'", "'epidFeedbackState_On'", "'calcoutINAV_EXT_NC'", "'calcoutINAV_EXT'", "'calcoutINAV_LOC'", "'calcoutINAV_CON'", "'asynAUTOCONNECT_noAutoConnect'", "'asynAUTOCONNECT_autoConnect'", "'asynFMT_ASCII'", "'asynFMT_Hybrid'", "'asynFMT_Binary'", "'seqSELM_All'", "'seqSELM_Specified'", "'seqSELM_Mask'", "'asynCONNECT_Disconnect'", "'asynCONNECT_Connect'", "'gpibUCMD_None'", "'gpibUCMD_Device_Clear__DCL_'", "'gpibUCMD_Local_Lockout__LL0_'", "'gpibUCMD_Serial_Poll_Disable__SPD_'", "'gpibUCMD_Serial_Poll_Enable__SPE_'", "'gpibUCMD_Unlisten__UNL_'", "'gpibUCMD_Untalk__UNT_'", "'serialBAUD_unknown'", "'serialBAUD_300'", "'serialBAUD_600'", "'serialBAUD_1200'", "'serialBAUD_2400'", "'serialBAUD_4800'", "'serialBAUD_9600'", "'serialBAUD_19200'", "'serialBAUD_38400'", "'serialBAUD_57600'", "'serialBAUD_115200'", "'serialBAUD_230400'", "'serialBAUD_460800'", "'serialBAUD_576000'", "'serialBAUD_921600'", "'serialBAUD_1152000'", "'histogramCMD_Read'", "'histogramCMD_Clear'", "'histogramCMD_Start'", "'histogramCMD_Stop'", "'asynTRACE_Off'", "'asynTRACE_On'", "'scalerG1_N'", "'scalerG1_Y'", "'asynEOMREASONNone'", "'calcout'", "'state'", "'histogram'", "'lsi'", "'int64out'", "'seq'", "'stringout'", "'aai'", "'permissive'", "'bo'", "'dfanout'", "'mbbi'", "'event'", "'compress'", "'mbbo'", "'epid'", "'ao'", "'aao'", "'mbbiDirect'", "'asyn'", "'waveform'", "'scaler'", "'timestamp'", "'fanout'", "'longin'", "'printf'", "'sel'", "'bi'", "'lso'", "'subArray'", "'calc'", "'mbboDirect'", "'longout'", "'aSub'", "'sub'", "'int64in'", "'ai'", "'NAME'", "'DESC'", "'ASG'", "'SCAN'", "'PINI'", "'PHAS'", "'EVNT'", "'TSE'", "'TSEL'", "'DTYP'", "'DISV'", "'DISA'", "'MLOK'", "'MLIS'", "'BKLNK'", "'DISP'", "'PROC'", "'STAT'", "'SEVR'", "'NSTA'", "'NSEV'", "'ACKS'", "'ACKT'", "'DISS'", "'PACT'", "'PUTF'", "'RPRO'", "'ASP'", "'PPN'", "'PPNR'", "'SPVT'", "'RSET'", "'DSET'", "'DPVT'", "'RDES'", "'LSET'", "'PRIO'", "'TPRO'", "'BKPT'", "'UDF'", "'UDFS'", "'TIME'", "'FLNK'", "'RPVT'", "'VAL'", "'PVAL'", "'CALC'", "'CLCV'", "'INPA'", "'INPB'", "'INPC'", "'INPD'", "'INPE'", "'INPF'", "'INPG'", "'INPH'", "'INPI'", "'INPJ'", "'INPK'", "'INPL'", "'OUT'", "'INAV'", "'INBV'", "'INCV'", "'INDV'", "'INEV'", "'INFV'", "'INGV'", "'INHV'", "'INIV'", "'INJV'", "'INKV'", "'INLV'", "'OOPT'", "'DLYA'", "'DOPT'", "'OCAL'", "'OCLV'", "'OEVT'", "'EPVT'", "'IVOA'", "'IVOV'", "'PREC'", "'HOPR'", "'LOPR'", "'HIHI'", "'LOLO'", "'HIGH'", "'LOW'", "'HHSV'", "'LLSV'", "'HSV'", "'LSV'", "'HYST'", "'ADEL'", "'MDEL'", "'A'", "'B'", "'C'", "'D'", "'E'", "'F'", "'G'", "'H'", "'I'", "'J'", "'K'", "'L'", "'OVAL'", "'LA'", "'LB'", "'LC'", "'LD'", "'LE'", "'LF'", "'LG'", "'LH'", "'LI'", "'LJ'", "'LK'", "'LL'", "'POVL'", "'LALM'", "'ALST'", "'MLST'", "'RPCL'", "'ORPC'", "'DBF_STRING'", "'DBF_MENU'", "'DBF_INLINK'", "'DBF_FWDLINK'", "'DBF_SHORT'", "'DBF_DEVICE'", "'DBF_NOACCESS'", "'DBF_UCHAR'", "'DBF_OUTLINK'", "'DBF_USHORT'", "'DBF_DOUBLE'", "'DBF_ULONG'", "'INT64'", "'size'", "'prompt'", "'promptgroup'", "'menu'", "'interest'", "'('", "')'", "'{'", "'}'", "'choice'", "','", "'recordtype'", "'field'"
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
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_INT=5;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
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
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
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
    public static final int EOF=-1;
    public static final int T__300=300;
    public static final int T__405=405;
    public static final int T__404=404;
    public static final int T__401=401;
    public static final int T__400=400;
    public static final int T__403=403;
    public static final int T__402=402;
    public static final int T__320=320;
    public static final int T__201=201;
    public static final int T__322=322;
    public static final int T__200=200;
    public static final int T__321=321;
    public static final int T__317=317;
    public static final int T__316=316;
    public static final int T__319=319;
    public static final int T__318=318;
    public static final int T__313=313;
    public static final int T__312=312;
    public static final int T__315=315;
    public static final int T__314=314;
    public static final int T__311=311;
    public static final int T__310=310;
    public static final int T__309=309;
    public static final int T__306=306;
    public static final int T__305=305;
    public static final int T__308=308;
    public static final int T__307=307;
    public static final int T__302=302;
    public static final int T__301=301;
    public static final int T__304=304;
    public static final int T__303=303;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__90=90;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;
    public static final int T__144=144;
    public static final int T__265=265;
    public static final int T__386=386;
    public static final int T__143=143;
    public static final int T__264=264;
    public static final int T__385=385;
    public static final int T__146=146;
    public static final int T__267=267;
    public static final int T__388=388;
    public static final int T__145=145;
    public static final int T__266=266;
    public static final int T__387=387;
    public static final int T__140=140;
    public static final int T__261=261;
    public static final int T__382=382;
    public static final int T__260=260;
    public static final int T__381=381;
    public static final int T__142=142;
    public static final int T__263=263;
    public static final int T__384=384;
    public static final int T__141=141;
    public static final int T__262=262;
    public static final int T__383=383;
    public static final int T__380=380;
    public static final int T__137=137;
    public static final int T__258=258;
    public static final int T__379=379;
    public static final int T__136=136;
    public static final int T__257=257;
    public static final int T__378=378;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__259=259;
    public static final int T__133=133;
    public static final int T__254=254;
    public static final int T__375=375;
    public static final int T__132=132;
    public static final int T__253=253;
    public static final int T__374=374;
    public static final int T__135=135;
    public static final int T__256=256;
    public static final int T__377=377;
    public static final int T__134=134;
    public static final int T__255=255;
    public static final int T__376=376;
    public static final int T__250=250;
    public static final int T__371=371;
    public static final int RULE_ID=7;
    public static final int T__370=370;
    public static final int T__131=131;
    public static final int T__252=252;
    public static final int T__373=373;
    public static final int T__130=130;
    public static final int T__251=251;
    public static final int T__372=372;
    public static final int T__129=129;
    public static final int T__126=126;
    public static final int T__247=247;
    public static final int T__368=368;
    public static final int T__125=125;
    public static final int T__246=246;
    public static final int T__367=367;
    public static final int T__128=128;
    public static final int T__249=249;
    public static final int T__127=127;
    public static final int T__248=248;
    public static final int T__369=369;
    public static final int T__166=166;
    public static final int T__287=287;
    public static final int T__165=165;
    public static final int T__286=286;
    public static final int T__168=168;
    public static final int T__289=289;
    public static final int T__167=167;
    public static final int T__288=288;
    public static final int T__162=162;
    public static final int T__283=283;
    public static final int T__161=161;
    public static final int T__282=282;
    public static final int T__164=164;
    public static final int T__285=285;
    public static final int T__163=163;
    public static final int T__284=284;
    public static final int T__160=160;
    public static final int T__281=281;
    public static final int T__280=280;
    public static final int T__159=159;
    public static final int T__158=158;
    public static final int T__279=279;
    public static final int T__155=155;
    public static final int T__276=276;
    public static final int T__397=397;
    public static final int T__154=154;
    public static final int T__275=275;
    public static final int T__396=396;
    public static final int T__157=157;
    public static final int T__278=278;
    public static final int T__399=399;
    public static final int T__156=156;
    public static final int T__277=277;
    public static final int T__398=398;
    public static final int T__151=151;
    public static final int T__272=272;
    public static final int T__393=393;
    public static final int T__150=150;
    public static final int T__271=271;
    public static final int T__392=392;
    public static final int T__153=153;
    public static final int T__274=274;
    public static final int T__395=395;
    public static final int T__152=152;
    public static final int T__273=273;
    public static final int T__394=394;
    public static final int T__270=270;
    public static final int T__391=391;
    public static final int T__390=390;
    public static final int T__148=148;
    public static final int T__269=269;
    public static final int T__147=147;
    public static final int T__268=268;
    public static final int T__389=389;
    public static final int T__149=149;
    public static final int T__100=100;
    public static final int T__221=221;
    public static final int T__342=342;
    public static final int T__220=220;
    public static final int T__341=341;
    public static final int T__102=102;
    public static final int T__223=223;
    public static final int T__344=344;
    public static final int T__101=101;
    public static final int T__222=222;
    public static final int T__343=343;
    public static final int T__340=340;
    public static final int T__218=218;
    public static final int T__339=339;
    public static final int T__217=217;
    public static final int T__338=338;
    public static final int T__219=219;
    public static final int T__214=214;
    public static final int T__335=335;
    public static final int T__213=213;
    public static final int T__334=334;
    public static final int T__216=216;
    public static final int T__337=337;
    public static final int T__215=215;
    public static final int T__336=336;
    public static final int T__210=210;
    public static final int T__331=331;
    public static final int T__330=330;
    public static final int T__212=212;
    public static final int T__333=333;
    public static final int T__211=211;
    public static final int T__332=332;
    public static final int T__207=207;
    public static final int T__328=328;
    public static final int T__206=206;
    public static final int T__327=327;
    public static final int T__209=209;
    public static final int T__208=208;
    public static final int T__329=329;
    public static final int T__203=203;
    public static final int T__324=324;
    public static final int T__202=202;
    public static final int T__323=323;
    public static final int T__205=205;
    public static final int T__326=326;
    public static final int T__204=204;
    public static final int T__325=325;
    public static final int T__122=122;
    public static final int T__243=243;
    public static final int T__364=364;
    public static final int T__121=121;
    public static final int T__242=242;
    public static final int T__363=363;
    public static final int T__124=124;
    public static final int T__245=245;
    public static final int T__366=366;
    public static final int T__123=123;
    public static final int T__244=244;
    public static final int T__365=365;
    public static final int T__360=360;
    public static final int T__120=120;
    public static final int T__241=241;
    public static final int T__362=362;
    public static final int T__240=240;
    public static final int T__361=361;
    public static final int RULE_SL_COMMENT=6;
    public static final int T__119=119;
    public static final int T__118=118;
    public static final int T__239=239;
    public static final int T__115=115;
    public static final int T__236=236;
    public static final int T__357=357;
    public static final int T__114=114;
    public static final int T__235=235;
    public static final int T__356=356;
    public static final int T__117=117;
    public static final int T__238=238;
    public static final int T__359=359;
    public static final int T__116=116;
    public static final int T__237=237;
    public static final int T__358=358;
    public static final int T__111=111;
    public static final int T__232=232;
    public static final int T__353=353;
    public static final int T__110=110;
    public static final int T__231=231;
    public static final int T__352=352;
    public static final int T__113=113;
    public static final int T__234=234;
    public static final int T__355=355;
    public static final int T__112=112;
    public static final int T__233=233;
    public static final int T__354=354;
    public static final int T__230=230;
    public static final int T__351=351;
    public static final int T__350=350;
    public static final int T__108=108;
    public static final int T__229=229;
    public static final int T__107=107;
    public static final int T__228=228;
    public static final int T__349=349;
    public static final int T__109=109;
    public static final int T__104=104;
    public static final int T__225=225;
    public static final int T__346=346;
    public static final int T__103=103;
    public static final int T__224=224;
    public static final int T__345=345;
    public static final int T__106=106;
    public static final int T__227=227;
    public static final int T__348=348;
    public static final int T__105=105;
    public static final int T__226=226;
    public static final int T__347=347;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__188=188;
    public static final int T__187=187;
    public static final int T__189=189;
    public static final int T__184=184;
    public static final int T__183=183;
    public static final int T__186=186;
    public static final int T__185=185;
    public static final int T__180=180;
    public static final int T__182=182;
    public static final int T__181=181;
    public static final int T__177=177;
    public static final int T__298=298;
    public static final int T__176=176;
    public static final int T__297=297;
    public static final int T__179=179;
    public static final int T__178=178;
    public static final int T__299=299;
    public static final int T__173=173;
    public static final int T__294=294;
    public static final int T__172=172;
    public static final int T__293=293;
    public static final int T__175=175;
    public static final int T__296=296;
    public static final int T__174=174;
    public static final int T__295=295;
    public static final int T__290=290;
    public static final int T__171=171;
    public static final int T__292=292;
    public static final int T__170=170;
    public static final int T__291=291;
    public static final int T__169=169;
    public static final int RULE_STRING=4;
    public static final int T__199=199;
    public static final int T__198=198;
    public static final int T__195=195;
    public static final int T__194=194;
    public static final int T__197=197;
    public static final int T__196=196;
    public static final int T__191=191;
    public static final int T__190=190;
    public static final int T__193=193;
    public static final int T__192=192;
    public static final int RULE_ANY_OTHER=10;

    // delegates
    // delegators


        public InternalDbdTextEditorParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDbdTextEditorParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDbdTextEditorParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDbdTextEditor.g"; }


    	private DbdTextEditorGrammarAccess grammarAccess;

    	public void setGrammarAccess(DbdTextEditorGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuledbdModel"
    // InternalDbdTextEditor.g:53:1: entryRuledbdModel : ruledbdModel EOF ;
    public final void entryRuledbdModel() throws RecognitionException {
        try {
            // InternalDbdTextEditor.g:54:1: ( ruledbdModel EOF )
            // InternalDbdTextEditor.g:55:1: ruledbdModel EOF
            {
             before(grammarAccess.getDbdModelRule()); 
            pushFollow(FOLLOW_1);
            ruledbdModel();

            state._fsp--;

             after(grammarAccess.getDbdModelRule()); 
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
    // $ANTLR end "entryRuledbdModel"


    // $ANTLR start "ruledbdModel"
    // InternalDbdTextEditor.g:62:1: ruledbdModel : ( ( rule__DbdModel__Group__0 ) ) ;
    public final void ruledbdModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:66:2: ( ( ( rule__DbdModel__Group__0 ) ) )
            // InternalDbdTextEditor.g:67:2: ( ( rule__DbdModel__Group__0 ) )
            {
            // InternalDbdTextEditor.g:67:2: ( ( rule__DbdModel__Group__0 ) )
            // InternalDbdTextEditor.g:68:3: ( rule__DbdModel__Group__0 )
            {
             before(grammarAccess.getDbdModelAccess().getGroup()); 
            // InternalDbdTextEditor.g:69:3: ( rule__DbdModel__Group__0 )
            // InternalDbdTextEditor.g:69:4: rule__DbdModel__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DbdModel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDbdModelAccess().getGroup()); 

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
    // $ANTLR end "ruledbdModel"


    // $ANTLR start "entryRuleMenu"
    // InternalDbdTextEditor.g:78:1: entryRuleMenu : ruleMenu EOF ;
    public final void entryRuleMenu() throws RecognitionException {
        try {
            // InternalDbdTextEditor.g:79:1: ( ruleMenu EOF )
            // InternalDbdTextEditor.g:80:1: ruleMenu EOF
            {
             before(grammarAccess.getMenuRule()); 
            pushFollow(FOLLOW_1);
            ruleMenu();

            state._fsp--;

             after(grammarAccess.getMenuRule()); 
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
    // $ANTLR end "entryRuleMenu"


    // $ANTLR start "ruleMenu"
    // InternalDbdTextEditor.g:87:1: ruleMenu : ( ( rule__Menu__Group__0 ) ) ;
    public final void ruleMenu() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:91:2: ( ( ( rule__Menu__Group__0 ) ) )
            // InternalDbdTextEditor.g:92:2: ( ( rule__Menu__Group__0 ) )
            {
            // InternalDbdTextEditor.g:92:2: ( ( rule__Menu__Group__0 ) )
            // InternalDbdTextEditor.g:93:3: ( rule__Menu__Group__0 )
            {
             before(grammarAccess.getMenuAccess().getGroup()); 
            // InternalDbdTextEditor.g:94:3: ( rule__Menu__Group__0 )
            // InternalDbdTextEditor.g:94:4: rule__Menu__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Menu__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMenuAccess().getGroup()); 

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
    // $ANTLR end "ruleMenu"


    // $ANTLR start "entryRuleChoice"
    // InternalDbdTextEditor.g:103:1: entryRuleChoice : ruleChoice EOF ;
    public final void entryRuleChoice() throws RecognitionException {
        try {
            // InternalDbdTextEditor.g:104:1: ( ruleChoice EOF )
            // InternalDbdTextEditor.g:105:1: ruleChoice EOF
            {
             before(grammarAccess.getChoiceRule()); 
            pushFollow(FOLLOW_1);
            ruleChoice();

            state._fsp--;

             after(grammarAccess.getChoiceRule()); 
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
    // $ANTLR end "entryRuleChoice"


    // $ANTLR start "ruleChoice"
    // InternalDbdTextEditor.g:112:1: ruleChoice : ( ( rule__Choice__Group__0 ) ) ;
    public final void ruleChoice() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:116:2: ( ( ( rule__Choice__Group__0 ) ) )
            // InternalDbdTextEditor.g:117:2: ( ( rule__Choice__Group__0 ) )
            {
            // InternalDbdTextEditor.g:117:2: ( ( rule__Choice__Group__0 ) )
            // InternalDbdTextEditor.g:118:3: ( rule__Choice__Group__0 )
            {
             before(grammarAccess.getChoiceAccess().getGroup()); 
            // InternalDbdTextEditor.g:119:3: ( rule__Choice__Group__0 )
            // InternalDbdTextEditor.g:119:4: rule__Choice__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Choice__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getChoiceAccess().getGroup()); 

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
    // $ANTLR end "ruleChoice"


    // $ANTLR start "entryRuleRecordtype"
    // InternalDbdTextEditor.g:128:1: entryRuleRecordtype : ruleRecordtype EOF ;
    public final void entryRuleRecordtype() throws RecognitionException {
        try {
            // InternalDbdTextEditor.g:129:1: ( ruleRecordtype EOF )
            // InternalDbdTextEditor.g:130:1: ruleRecordtype EOF
            {
             before(grammarAccess.getRecordtypeRule()); 
            pushFollow(FOLLOW_1);
            ruleRecordtype();

            state._fsp--;

             after(grammarAccess.getRecordtypeRule()); 
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
    // $ANTLR end "entryRuleRecordtype"


    // $ANTLR start "ruleRecordtype"
    // InternalDbdTextEditor.g:137:1: ruleRecordtype : ( ( rule__Recordtype__Group__0 ) ) ;
    public final void ruleRecordtype() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:141:2: ( ( ( rule__Recordtype__Group__0 ) ) )
            // InternalDbdTextEditor.g:142:2: ( ( rule__Recordtype__Group__0 ) )
            {
            // InternalDbdTextEditor.g:142:2: ( ( rule__Recordtype__Group__0 ) )
            // InternalDbdTextEditor.g:143:3: ( rule__Recordtype__Group__0 )
            {
             before(grammarAccess.getRecordtypeAccess().getGroup()); 
            // InternalDbdTextEditor.g:144:3: ( rule__Recordtype__Group__0 )
            // InternalDbdTextEditor.g:144:4: rule__Recordtype__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Recordtype__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRecordtypeAccess().getGroup()); 

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
    // $ANTLR end "ruleRecordtype"


    // $ANTLR start "entryRuleField"
    // InternalDbdTextEditor.g:153:1: entryRuleField : ruleField EOF ;
    public final void entryRuleField() throws RecognitionException {
        try {
            // InternalDbdTextEditor.g:154:1: ( ruleField EOF )
            // InternalDbdTextEditor.g:155:1: ruleField EOF
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
    // InternalDbdTextEditor.g:162:1: ruleField : ( ( rule__Field__Group__0 ) ) ;
    public final void ruleField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:166:2: ( ( ( rule__Field__Group__0 ) ) )
            // InternalDbdTextEditor.g:167:2: ( ( rule__Field__Group__0 ) )
            {
            // InternalDbdTextEditor.g:167:2: ( ( rule__Field__Group__0 ) )
            // InternalDbdTextEditor.g:168:3: ( rule__Field__Group__0 )
            {
             before(grammarAccess.getFieldAccess().getGroup()); 
            // InternalDbdTextEditor.g:169:3: ( rule__Field__Group__0 )
            // InternalDbdTextEditor.g:169:4: rule__Field__Group__0
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


    // $ANTLR start "entryRuleFieldattribute"
    // InternalDbdTextEditor.g:178:1: entryRuleFieldattribute : ruleFieldattribute EOF ;
    public final void entryRuleFieldattribute() throws RecognitionException {
        try {
            // InternalDbdTextEditor.g:179:1: ( ruleFieldattribute EOF )
            // InternalDbdTextEditor.g:180:1: ruleFieldattribute EOF
            {
             before(grammarAccess.getFieldattributeRule()); 
            pushFollow(FOLLOW_1);
            ruleFieldattribute();

            state._fsp--;

             after(grammarAccess.getFieldattributeRule()); 
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
    // $ANTLR end "entryRuleFieldattribute"


    // $ANTLR start "ruleFieldattribute"
    // InternalDbdTextEditor.g:187:1: ruleFieldattribute : ( ( rule__Fieldattribute__Group__0 ) ) ;
    public final void ruleFieldattribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:191:2: ( ( ( rule__Fieldattribute__Group__0 ) ) )
            // InternalDbdTextEditor.g:192:2: ( ( rule__Fieldattribute__Group__0 ) )
            {
            // InternalDbdTextEditor.g:192:2: ( ( rule__Fieldattribute__Group__0 ) )
            // InternalDbdTextEditor.g:193:3: ( rule__Fieldattribute__Group__0 )
            {
             before(grammarAccess.getFieldattributeAccess().getGroup()); 
            // InternalDbdTextEditor.g:194:3: ( rule__Fieldattribute__Group__0 )
            // InternalDbdTextEditor.g:194:4: rule__Fieldattribute__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Fieldattribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFieldattributeAccess().getGroup()); 

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
    // $ANTLR end "ruleFieldattribute"


    // $ANTLR start "ruleMenunames"
    // InternalDbdTextEditor.g:203:1: ruleMenunames : ( ( rule__Menunames__Alternatives ) ) ;
    public final void ruleMenunames() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:207:1: ( ( ( rule__Menunames__Alternatives ) ) )
            // InternalDbdTextEditor.g:208:2: ( ( rule__Menunames__Alternatives ) )
            {
            // InternalDbdTextEditor.g:208:2: ( ( rule__Menunames__Alternatives ) )
            // InternalDbdTextEditor.g:209:3: ( rule__Menunames__Alternatives )
            {
             before(grammarAccess.getMenunamesAccess().getAlternatives()); 
            // InternalDbdTextEditor.g:210:3: ( rule__Menunames__Alternatives )
            // InternalDbdTextEditor.g:210:4: rule__Menunames__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Menunames__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMenunamesAccess().getAlternatives()); 

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
    // $ANTLR end "ruleMenunames"


    // $ANTLR start "ruleChoicenames"
    // InternalDbdTextEditor.g:219:1: ruleChoicenames : ( ( rule__Choicenames__Alternatives ) ) ;
    public final void ruleChoicenames() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:223:1: ( ( ( rule__Choicenames__Alternatives ) ) )
            // InternalDbdTextEditor.g:224:2: ( ( rule__Choicenames__Alternatives ) )
            {
            // InternalDbdTextEditor.g:224:2: ( ( rule__Choicenames__Alternatives ) )
            // InternalDbdTextEditor.g:225:3: ( rule__Choicenames__Alternatives )
            {
             before(grammarAccess.getChoicenamesAccess().getAlternatives()); 
            // InternalDbdTextEditor.g:226:3: ( rule__Choicenames__Alternatives )
            // InternalDbdTextEditor.g:226:4: rule__Choicenames__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Choicenames__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getChoicenamesAccess().getAlternatives()); 

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
    // $ANTLR end "ruleChoicenames"


    // $ANTLR start "ruleRecordtypenames"
    // InternalDbdTextEditor.g:235:1: ruleRecordtypenames : ( ( rule__Recordtypenames__Alternatives ) ) ;
    public final void ruleRecordtypenames() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:239:1: ( ( ( rule__Recordtypenames__Alternatives ) ) )
            // InternalDbdTextEditor.g:240:2: ( ( rule__Recordtypenames__Alternatives ) )
            {
            // InternalDbdTextEditor.g:240:2: ( ( rule__Recordtypenames__Alternatives ) )
            // InternalDbdTextEditor.g:241:3: ( rule__Recordtypenames__Alternatives )
            {
             before(grammarAccess.getRecordtypenamesAccess().getAlternatives()); 
            // InternalDbdTextEditor.g:242:3: ( rule__Recordtypenames__Alternatives )
            // InternalDbdTextEditor.g:242:4: rule__Recordtypenames__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Recordtypenames__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getRecordtypenamesAccess().getAlternatives()); 

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
    // $ANTLR end "ruleRecordtypenames"


    // $ANTLR start "ruleFieldnames"
    // InternalDbdTextEditor.g:251:1: ruleFieldnames : ( ( rule__Fieldnames__Alternatives ) ) ;
    public final void ruleFieldnames() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:255:1: ( ( ( rule__Fieldnames__Alternatives ) ) )
            // InternalDbdTextEditor.g:256:2: ( ( rule__Fieldnames__Alternatives ) )
            {
            // InternalDbdTextEditor.g:256:2: ( ( rule__Fieldnames__Alternatives ) )
            // InternalDbdTextEditor.g:257:3: ( rule__Fieldnames__Alternatives )
            {
             before(grammarAccess.getFieldnamesAccess().getAlternatives()); 
            // InternalDbdTextEditor.g:258:3: ( rule__Fieldnames__Alternatives )
            // InternalDbdTextEditor.g:258:4: rule__Fieldnames__Alternatives
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


    // $ANTLR start "ruleDbfnames"
    // InternalDbdTextEditor.g:267:1: ruleDbfnames : ( ( rule__Dbfnames__Alternatives ) ) ;
    public final void ruleDbfnames() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:271:1: ( ( ( rule__Dbfnames__Alternatives ) ) )
            // InternalDbdTextEditor.g:272:2: ( ( rule__Dbfnames__Alternatives ) )
            {
            // InternalDbdTextEditor.g:272:2: ( ( rule__Dbfnames__Alternatives ) )
            // InternalDbdTextEditor.g:273:3: ( rule__Dbfnames__Alternatives )
            {
             before(grammarAccess.getDbfnamesAccess().getAlternatives()); 
            // InternalDbdTextEditor.g:274:3: ( rule__Dbfnames__Alternatives )
            // InternalDbdTextEditor.g:274:4: rule__Dbfnames__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Dbfnames__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDbfnamesAccess().getAlternatives()); 

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
    // $ANTLR end "ruleDbfnames"


    // $ANTLR start "ruleFieldattributenames"
    // InternalDbdTextEditor.g:283:1: ruleFieldattributenames : ( ( rule__Fieldattributenames__Alternatives ) ) ;
    public final void ruleFieldattributenames() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:287:1: ( ( ( rule__Fieldattributenames__Alternatives ) ) )
            // InternalDbdTextEditor.g:288:2: ( ( rule__Fieldattributenames__Alternatives ) )
            {
            // InternalDbdTextEditor.g:288:2: ( ( rule__Fieldattributenames__Alternatives ) )
            // InternalDbdTextEditor.g:289:3: ( rule__Fieldattributenames__Alternatives )
            {
             before(grammarAccess.getFieldattributenamesAccess().getAlternatives()); 
            // InternalDbdTextEditor.g:290:3: ( rule__Fieldattributenames__Alternatives )
            // InternalDbdTextEditor.g:290:4: rule__Fieldattributenames__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Fieldattributenames__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFieldattributenamesAccess().getAlternatives()); 

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
    // $ANTLR end "ruleFieldattributenames"


    // $ANTLR start "rule__Fieldattribute__Alternatives_2"
    // InternalDbdTextEditor.g:298:1: rule__Fieldattribute__Alternatives_2 : ( ( ( rule__Fieldattribute__FieldattributestringAssignment_2_0 ) ) | ( ( rule__Fieldattribute__FieldattributeintAssignment_2_1 ) ) );
    public final void rule__Fieldattribute__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:302:1: ( ( ( rule__Fieldattribute__FieldattributestringAssignment_2_0 ) ) | ( ( rule__Fieldattribute__FieldattributeintAssignment_2_1 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_STRING) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_INT) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalDbdTextEditor.g:303:2: ( ( rule__Fieldattribute__FieldattributestringAssignment_2_0 ) )
                    {
                    // InternalDbdTextEditor.g:303:2: ( ( rule__Fieldattribute__FieldattributestringAssignment_2_0 ) )
                    // InternalDbdTextEditor.g:304:3: ( rule__Fieldattribute__FieldattributestringAssignment_2_0 )
                    {
                     before(grammarAccess.getFieldattributeAccess().getFieldattributestringAssignment_2_0()); 
                    // InternalDbdTextEditor.g:305:3: ( rule__Fieldattribute__FieldattributestringAssignment_2_0 )
                    // InternalDbdTextEditor.g:305:4: rule__Fieldattribute__FieldattributestringAssignment_2_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Fieldattribute__FieldattributestringAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFieldattributeAccess().getFieldattributestringAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDbdTextEditor.g:309:2: ( ( rule__Fieldattribute__FieldattributeintAssignment_2_1 ) )
                    {
                    // InternalDbdTextEditor.g:309:2: ( ( rule__Fieldattribute__FieldattributeintAssignment_2_1 ) )
                    // InternalDbdTextEditor.g:310:3: ( rule__Fieldattribute__FieldattributeintAssignment_2_1 )
                    {
                     before(grammarAccess.getFieldattributeAccess().getFieldattributeintAssignment_2_1()); 
                    // InternalDbdTextEditor.g:311:3: ( rule__Fieldattribute__FieldattributeintAssignment_2_1 )
                    // InternalDbdTextEditor.g:311:4: rule__Fieldattribute__FieldattributeintAssignment_2_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Fieldattribute__FieldattributeintAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getFieldattributeAccess().getFieldattributeintAssignment_2_1()); 

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
    // $ANTLR end "rule__Fieldattribute__Alternatives_2"


    // $ANTLR start "rule__Menunames__Alternatives"
    // InternalDbdTextEditor.g:319:1: rule__Menunames__Alternatives : ( ( ( 'serialPRTY' ) ) | ( ( 'waveformPOST' ) ) | ( ( 'aaoPOST' ) ) | ( ( 'menuPriority' ) ) | ( ( 'serialSBIT' ) ) | ( ( 'calcoutDOPT' ) ) | ( ( 'SDIS' ) ) | ( ( 'menuOmsl' ) ) | ( ( 'menuFtype' ) ) | ( ( 'stringinPOST' ) ) | ( ( 'menuPini' ) ) | ( ( 'dfanoutSELM' ) ) | ( ( 'menuScan' ) ) | ( ( 'gpibACMD' ) ) | ( ( 'aSubLFLG' ) ) | ( ( 'asynTMOD' ) ) | ( ( 'scalerD1' ) ) | ( ( 'menuPost' ) ) | ( ( 'asynINTERFACE' ) ) | ( ( 'menuAlarmStat' ) ) | ( ( 'aoOIF' ) ) | ( ( 'bufferingALG' ) ) | ( ( 'aaiPOST' ) ) | ( ( 'epidFeedbackState' ) ) | ( ( 'calcoutINAV' ) ) | ( ( 'asynAUTOCONNECT' ) ) | ( ( 'asynFMT' ) ) | ( ( 'asynCONNECT' ) ) | ( ( 'gpibUCMD' ) ) | ( ( 'serialBAUD' ) ) | ( ( 'histogramCMD' ) ) | ( ( 'asynTRACE' ) ) | ( ( 'scalerG1' ) ) | ( ( 'asynEOMREASON' ) ) | ( ( 'scalerCONT' ) ) | ( ( 'menuIvoa' ) ) | ( ( 'stringoutPOST' ) ) | ( ( 'menuAlarmSevr' ) ) | ( ( 'serialMCTL' ) ) | ( ( 'serialFCTL' ) ) | ( ( 'menuSimm' ) ) | ( ( 'compressALG' ) ) | ( ( 'aSubEFLG' ) ) | ( ( 'fanoutSELM' ) ) | ( ( 'calcoutOOPT' ) ) | ( ( 'asynENABLE' ) ) | ( ( 'epidFeedbackMode' ) ) | ( ( 'menuConvert' ) ) | ( ( 'scalerCNT' ) ) | ( ( 'serialIX' ) ) | ( ( 'menuYesNo' ) ) | ( ( 'timestampTST' ) ) | ( ( 'serialDBIT' ) ) | ( ( 'selSELM' ) ) );
    public final void rule__Menunames__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:323:1: ( ( ( 'serialPRTY' ) ) | ( ( 'waveformPOST' ) ) | ( ( 'aaoPOST' ) ) | ( ( 'menuPriority' ) ) | ( ( 'serialSBIT' ) ) | ( ( 'calcoutDOPT' ) ) | ( ( 'SDIS' ) ) | ( ( 'menuOmsl' ) ) | ( ( 'menuFtype' ) ) | ( ( 'stringinPOST' ) ) | ( ( 'menuPini' ) ) | ( ( 'dfanoutSELM' ) ) | ( ( 'menuScan' ) ) | ( ( 'gpibACMD' ) ) | ( ( 'aSubLFLG' ) ) | ( ( 'asynTMOD' ) ) | ( ( 'scalerD1' ) ) | ( ( 'menuPost' ) ) | ( ( 'asynINTERFACE' ) ) | ( ( 'menuAlarmStat' ) ) | ( ( 'aoOIF' ) ) | ( ( 'bufferingALG' ) ) | ( ( 'aaiPOST' ) ) | ( ( 'epidFeedbackState' ) ) | ( ( 'calcoutINAV' ) ) | ( ( 'asynAUTOCONNECT' ) ) | ( ( 'asynFMT' ) ) | ( ( 'asynCONNECT' ) ) | ( ( 'gpibUCMD' ) ) | ( ( 'serialBAUD' ) ) | ( ( 'histogramCMD' ) ) | ( ( 'asynTRACE' ) ) | ( ( 'scalerG1' ) ) | ( ( 'asynEOMREASON' ) ) | ( ( 'scalerCONT' ) ) | ( ( 'menuIvoa' ) ) | ( ( 'stringoutPOST' ) ) | ( ( 'menuAlarmSevr' ) ) | ( ( 'serialMCTL' ) ) | ( ( 'serialFCTL' ) ) | ( ( 'menuSimm' ) ) | ( ( 'compressALG' ) ) | ( ( 'aSubEFLG' ) ) | ( ( 'fanoutSELM' ) ) | ( ( 'calcoutOOPT' ) ) | ( ( 'asynENABLE' ) ) | ( ( 'epidFeedbackMode' ) ) | ( ( 'menuConvert' ) ) | ( ( 'scalerCNT' ) ) | ( ( 'serialIX' ) ) | ( ( 'menuYesNo' ) ) | ( ( 'timestampTST' ) ) | ( ( 'serialDBIT' ) ) | ( ( 'selSELM' ) ) )
            int alt2=54;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            case 14:
                {
                alt2=4;
                }
                break;
            case 15:
                {
                alt2=5;
                }
                break;
            case 16:
                {
                alt2=6;
                }
                break;
            case 17:
                {
                alt2=7;
                }
                break;
            case 18:
                {
                alt2=8;
                }
                break;
            case 19:
                {
                alt2=9;
                }
                break;
            case 20:
                {
                alt2=10;
                }
                break;
            case 21:
                {
                alt2=11;
                }
                break;
            case 22:
                {
                alt2=12;
                }
                break;
            case 23:
                {
                alt2=13;
                }
                break;
            case 24:
                {
                alt2=14;
                }
                break;
            case 25:
                {
                alt2=15;
                }
                break;
            case 26:
                {
                alt2=16;
                }
                break;
            case 27:
                {
                alt2=17;
                }
                break;
            case 28:
                {
                alt2=18;
                }
                break;
            case 29:
                {
                alt2=19;
                }
                break;
            case 30:
                {
                alt2=20;
                }
                break;
            case 31:
                {
                alt2=21;
                }
                break;
            case 32:
                {
                alt2=22;
                }
                break;
            case 33:
                {
                alt2=23;
                }
                break;
            case 34:
                {
                alt2=24;
                }
                break;
            case 35:
                {
                alt2=25;
                }
                break;
            case 36:
                {
                alt2=26;
                }
                break;
            case 37:
                {
                alt2=27;
                }
                break;
            case 38:
                {
                alt2=28;
                }
                break;
            case 39:
                {
                alt2=29;
                }
                break;
            case 40:
                {
                alt2=30;
                }
                break;
            case 41:
                {
                alt2=31;
                }
                break;
            case 42:
                {
                alt2=32;
                }
                break;
            case 43:
                {
                alt2=33;
                }
                break;
            case 44:
                {
                alt2=34;
                }
                break;
            case 45:
                {
                alt2=35;
                }
                break;
            case 46:
                {
                alt2=36;
                }
                break;
            case 47:
                {
                alt2=37;
                }
                break;
            case 48:
                {
                alt2=38;
                }
                break;
            case 49:
                {
                alt2=39;
                }
                break;
            case 50:
                {
                alt2=40;
                }
                break;
            case 51:
                {
                alt2=41;
                }
                break;
            case 52:
                {
                alt2=42;
                }
                break;
            case 53:
                {
                alt2=43;
                }
                break;
            case 54:
                {
                alt2=44;
                }
                break;
            case 55:
                {
                alt2=45;
                }
                break;
            case 56:
                {
                alt2=46;
                }
                break;
            case 57:
                {
                alt2=47;
                }
                break;
            case 58:
                {
                alt2=48;
                }
                break;
            case 59:
                {
                alt2=49;
                }
                break;
            case 60:
                {
                alt2=50;
                }
                break;
            case 61:
                {
                alt2=51;
                }
                break;
            case 62:
                {
                alt2=52;
                }
                break;
            case 63:
                {
                alt2=53;
                }
                break;
            case 64:
                {
                alt2=54;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalDbdTextEditor.g:324:2: ( ( 'serialPRTY' ) )
                    {
                    // InternalDbdTextEditor.g:324:2: ( ( 'serialPRTY' ) )
                    // InternalDbdTextEditor.g:325:3: ( 'serialPRTY' )
                    {
                     before(grammarAccess.getMenunamesAccess().getSerialPRTYEnumLiteralDeclaration_0()); 
                    // InternalDbdTextEditor.g:326:3: ( 'serialPRTY' )
                    // InternalDbdTextEditor.g:326:4: 'serialPRTY'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getSerialPRTYEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDbdTextEditor.g:330:2: ( ( 'waveformPOST' ) )
                    {
                    // InternalDbdTextEditor.g:330:2: ( ( 'waveformPOST' ) )
                    // InternalDbdTextEditor.g:331:3: ( 'waveformPOST' )
                    {
                     before(grammarAccess.getMenunamesAccess().getWaveformPOSTEnumLiteralDeclaration_1()); 
                    // InternalDbdTextEditor.g:332:3: ( 'waveformPOST' )
                    // InternalDbdTextEditor.g:332:4: 'waveformPOST'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getWaveformPOSTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDbdTextEditor.g:336:2: ( ( 'aaoPOST' ) )
                    {
                    // InternalDbdTextEditor.g:336:2: ( ( 'aaoPOST' ) )
                    // InternalDbdTextEditor.g:337:3: ( 'aaoPOST' )
                    {
                     before(grammarAccess.getMenunamesAccess().getAaoPOSTEnumLiteralDeclaration_2()); 
                    // InternalDbdTextEditor.g:338:3: ( 'aaoPOST' )
                    // InternalDbdTextEditor.g:338:4: 'aaoPOST'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getAaoPOSTEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDbdTextEditor.g:342:2: ( ( 'menuPriority' ) )
                    {
                    // InternalDbdTextEditor.g:342:2: ( ( 'menuPriority' ) )
                    // InternalDbdTextEditor.g:343:3: ( 'menuPriority' )
                    {
                     before(grammarAccess.getMenunamesAccess().getMenuPriorityEnumLiteralDeclaration_3()); 
                    // InternalDbdTextEditor.g:344:3: ( 'menuPriority' )
                    // InternalDbdTextEditor.g:344:4: 'menuPriority'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getMenuPriorityEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDbdTextEditor.g:348:2: ( ( 'serialSBIT' ) )
                    {
                    // InternalDbdTextEditor.g:348:2: ( ( 'serialSBIT' ) )
                    // InternalDbdTextEditor.g:349:3: ( 'serialSBIT' )
                    {
                     before(grammarAccess.getMenunamesAccess().getSerialSBITEnumLiteralDeclaration_4()); 
                    // InternalDbdTextEditor.g:350:3: ( 'serialSBIT' )
                    // InternalDbdTextEditor.g:350:4: 'serialSBIT'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getSerialSBITEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDbdTextEditor.g:354:2: ( ( 'calcoutDOPT' ) )
                    {
                    // InternalDbdTextEditor.g:354:2: ( ( 'calcoutDOPT' ) )
                    // InternalDbdTextEditor.g:355:3: ( 'calcoutDOPT' )
                    {
                     before(grammarAccess.getMenunamesAccess().getCalcoutDOPTEnumLiteralDeclaration_5()); 
                    // InternalDbdTextEditor.g:356:3: ( 'calcoutDOPT' )
                    // InternalDbdTextEditor.g:356:4: 'calcoutDOPT'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getCalcoutDOPTEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDbdTextEditor.g:360:2: ( ( 'SDIS' ) )
                    {
                    // InternalDbdTextEditor.g:360:2: ( ( 'SDIS' ) )
                    // InternalDbdTextEditor.g:361:3: ( 'SDIS' )
                    {
                     before(grammarAccess.getMenunamesAccess().getSDISEnumLiteralDeclaration_6()); 
                    // InternalDbdTextEditor.g:362:3: ( 'SDIS' )
                    // InternalDbdTextEditor.g:362:4: 'SDIS'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getSDISEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDbdTextEditor.g:366:2: ( ( 'menuOmsl' ) )
                    {
                    // InternalDbdTextEditor.g:366:2: ( ( 'menuOmsl' ) )
                    // InternalDbdTextEditor.g:367:3: ( 'menuOmsl' )
                    {
                     before(grammarAccess.getMenunamesAccess().getMenuOmslEnumLiteralDeclaration_7()); 
                    // InternalDbdTextEditor.g:368:3: ( 'menuOmsl' )
                    // InternalDbdTextEditor.g:368:4: 'menuOmsl'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getMenuOmslEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDbdTextEditor.g:372:2: ( ( 'menuFtype' ) )
                    {
                    // InternalDbdTextEditor.g:372:2: ( ( 'menuFtype' ) )
                    // InternalDbdTextEditor.g:373:3: ( 'menuFtype' )
                    {
                     before(grammarAccess.getMenunamesAccess().getMenuFtypeEnumLiteralDeclaration_8()); 
                    // InternalDbdTextEditor.g:374:3: ( 'menuFtype' )
                    // InternalDbdTextEditor.g:374:4: 'menuFtype'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getMenuFtypeEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDbdTextEditor.g:378:2: ( ( 'stringinPOST' ) )
                    {
                    // InternalDbdTextEditor.g:378:2: ( ( 'stringinPOST' ) )
                    // InternalDbdTextEditor.g:379:3: ( 'stringinPOST' )
                    {
                     before(grammarAccess.getMenunamesAccess().getStringinPOSTEnumLiteralDeclaration_9()); 
                    // InternalDbdTextEditor.g:380:3: ( 'stringinPOST' )
                    // InternalDbdTextEditor.g:380:4: 'stringinPOST'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getStringinPOSTEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalDbdTextEditor.g:384:2: ( ( 'menuPini' ) )
                    {
                    // InternalDbdTextEditor.g:384:2: ( ( 'menuPini' ) )
                    // InternalDbdTextEditor.g:385:3: ( 'menuPini' )
                    {
                     before(grammarAccess.getMenunamesAccess().getMenuPiniEnumLiteralDeclaration_10()); 
                    // InternalDbdTextEditor.g:386:3: ( 'menuPini' )
                    // InternalDbdTextEditor.g:386:4: 'menuPini'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getMenuPiniEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalDbdTextEditor.g:390:2: ( ( 'dfanoutSELM' ) )
                    {
                    // InternalDbdTextEditor.g:390:2: ( ( 'dfanoutSELM' ) )
                    // InternalDbdTextEditor.g:391:3: ( 'dfanoutSELM' )
                    {
                     before(grammarAccess.getMenunamesAccess().getDfanoutSELMEnumLiteralDeclaration_11()); 
                    // InternalDbdTextEditor.g:392:3: ( 'dfanoutSELM' )
                    // InternalDbdTextEditor.g:392:4: 'dfanoutSELM'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getDfanoutSELMEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalDbdTextEditor.g:396:2: ( ( 'menuScan' ) )
                    {
                    // InternalDbdTextEditor.g:396:2: ( ( 'menuScan' ) )
                    // InternalDbdTextEditor.g:397:3: ( 'menuScan' )
                    {
                     before(grammarAccess.getMenunamesAccess().getMenuScanEnumLiteralDeclaration_12()); 
                    // InternalDbdTextEditor.g:398:3: ( 'menuScan' )
                    // InternalDbdTextEditor.g:398:4: 'menuScan'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getMenuScanEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalDbdTextEditor.g:402:2: ( ( 'gpibACMD' ) )
                    {
                    // InternalDbdTextEditor.g:402:2: ( ( 'gpibACMD' ) )
                    // InternalDbdTextEditor.g:403:3: ( 'gpibACMD' )
                    {
                     before(grammarAccess.getMenunamesAccess().getGpibACMDEnumLiteralDeclaration_13()); 
                    // InternalDbdTextEditor.g:404:3: ( 'gpibACMD' )
                    // InternalDbdTextEditor.g:404:4: 'gpibACMD'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getGpibACMDEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalDbdTextEditor.g:408:2: ( ( 'aSubLFLG' ) )
                    {
                    // InternalDbdTextEditor.g:408:2: ( ( 'aSubLFLG' ) )
                    // InternalDbdTextEditor.g:409:3: ( 'aSubLFLG' )
                    {
                     before(grammarAccess.getMenunamesAccess().getASubLFLGEnumLiteralDeclaration_14()); 
                    // InternalDbdTextEditor.g:410:3: ( 'aSubLFLG' )
                    // InternalDbdTextEditor.g:410:4: 'aSubLFLG'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getASubLFLGEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalDbdTextEditor.g:414:2: ( ( 'asynTMOD' ) )
                    {
                    // InternalDbdTextEditor.g:414:2: ( ( 'asynTMOD' ) )
                    // InternalDbdTextEditor.g:415:3: ( 'asynTMOD' )
                    {
                     before(grammarAccess.getMenunamesAccess().getAsynTMODEnumLiteralDeclaration_15()); 
                    // InternalDbdTextEditor.g:416:3: ( 'asynTMOD' )
                    // InternalDbdTextEditor.g:416:4: 'asynTMOD'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getAsynTMODEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalDbdTextEditor.g:420:2: ( ( 'scalerD1' ) )
                    {
                    // InternalDbdTextEditor.g:420:2: ( ( 'scalerD1' ) )
                    // InternalDbdTextEditor.g:421:3: ( 'scalerD1' )
                    {
                     before(grammarAccess.getMenunamesAccess().getScalerD1EnumLiteralDeclaration_16()); 
                    // InternalDbdTextEditor.g:422:3: ( 'scalerD1' )
                    // InternalDbdTextEditor.g:422:4: 'scalerD1'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getScalerD1EnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalDbdTextEditor.g:426:2: ( ( 'menuPost' ) )
                    {
                    // InternalDbdTextEditor.g:426:2: ( ( 'menuPost' ) )
                    // InternalDbdTextEditor.g:427:3: ( 'menuPost' )
                    {
                     before(grammarAccess.getMenunamesAccess().getMenuPostEnumLiteralDeclaration_17()); 
                    // InternalDbdTextEditor.g:428:3: ( 'menuPost' )
                    // InternalDbdTextEditor.g:428:4: 'menuPost'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getMenuPostEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalDbdTextEditor.g:432:2: ( ( 'asynINTERFACE' ) )
                    {
                    // InternalDbdTextEditor.g:432:2: ( ( 'asynINTERFACE' ) )
                    // InternalDbdTextEditor.g:433:3: ( 'asynINTERFACE' )
                    {
                     before(grammarAccess.getMenunamesAccess().getAsynINTERFACEEnumLiteralDeclaration_18()); 
                    // InternalDbdTextEditor.g:434:3: ( 'asynINTERFACE' )
                    // InternalDbdTextEditor.g:434:4: 'asynINTERFACE'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getAsynINTERFACEEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalDbdTextEditor.g:438:2: ( ( 'menuAlarmStat' ) )
                    {
                    // InternalDbdTextEditor.g:438:2: ( ( 'menuAlarmStat' ) )
                    // InternalDbdTextEditor.g:439:3: ( 'menuAlarmStat' )
                    {
                     before(grammarAccess.getMenunamesAccess().getMenuAlarmStatEnumLiteralDeclaration_19()); 
                    // InternalDbdTextEditor.g:440:3: ( 'menuAlarmStat' )
                    // InternalDbdTextEditor.g:440:4: 'menuAlarmStat'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getMenuAlarmStatEnumLiteralDeclaration_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalDbdTextEditor.g:444:2: ( ( 'aoOIF' ) )
                    {
                    // InternalDbdTextEditor.g:444:2: ( ( 'aoOIF' ) )
                    // InternalDbdTextEditor.g:445:3: ( 'aoOIF' )
                    {
                     before(grammarAccess.getMenunamesAccess().getAoOIFEnumLiteralDeclaration_20()); 
                    // InternalDbdTextEditor.g:446:3: ( 'aoOIF' )
                    // InternalDbdTextEditor.g:446:4: 'aoOIF'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getAoOIFEnumLiteralDeclaration_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalDbdTextEditor.g:450:2: ( ( 'bufferingALG' ) )
                    {
                    // InternalDbdTextEditor.g:450:2: ( ( 'bufferingALG' ) )
                    // InternalDbdTextEditor.g:451:3: ( 'bufferingALG' )
                    {
                     before(grammarAccess.getMenunamesAccess().getBufferingALGEnumLiteralDeclaration_21()); 
                    // InternalDbdTextEditor.g:452:3: ( 'bufferingALG' )
                    // InternalDbdTextEditor.g:452:4: 'bufferingALG'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getBufferingALGEnumLiteralDeclaration_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalDbdTextEditor.g:456:2: ( ( 'aaiPOST' ) )
                    {
                    // InternalDbdTextEditor.g:456:2: ( ( 'aaiPOST' ) )
                    // InternalDbdTextEditor.g:457:3: ( 'aaiPOST' )
                    {
                     before(grammarAccess.getMenunamesAccess().getAaiPOSTEnumLiteralDeclaration_22()); 
                    // InternalDbdTextEditor.g:458:3: ( 'aaiPOST' )
                    // InternalDbdTextEditor.g:458:4: 'aaiPOST'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getAaiPOSTEnumLiteralDeclaration_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalDbdTextEditor.g:462:2: ( ( 'epidFeedbackState' ) )
                    {
                    // InternalDbdTextEditor.g:462:2: ( ( 'epidFeedbackState' ) )
                    // InternalDbdTextEditor.g:463:3: ( 'epidFeedbackState' )
                    {
                     before(grammarAccess.getMenunamesAccess().getEpidFeedbackStateEnumLiteralDeclaration_23()); 
                    // InternalDbdTextEditor.g:464:3: ( 'epidFeedbackState' )
                    // InternalDbdTextEditor.g:464:4: 'epidFeedbackState'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getEpidFeedbackStateEnumLiteralDeclaration_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalDbdTextEditor.g:468:2: ( ( 'calcoutINAV' ) )
                    {
                    // InternalDbdTextEditor.g:468:2: ( ( 'calcoutINAV' ) )
                    // InternalDbdTextEditor.g:469:3: ( 'calcoutINAV' )
                    {
                     before(grammarAccess.getMenunamesAccess().getCalcoutINAVEnumLiteralDeclaration_24()); 
                    // InternalDbdTextEditor.g:470:3: ( 'calcoutINAV' )
                    // InternalDbdTextEditor.g:470:4: 'calcoutINAV'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getCalcoutINAVEnumLiteralDeclaration_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalDbdTextEditor.g:474:2: ( ( 'asynAUTOCONNECT' ) )
                    {
                    // InternalDbdTextEditor.g:474:2: ( ( 'asynAUTOCONNECT' ) )
                    // InternalDbdTextEditor.g:475:3: ( 'asynAUTOCONNECT' )
                    {
                     before(grammarAccess.getMenunamesAccess().getAsynAUTOCONNECTEnumLiteralDeclaration_25()); 
                    // InternalDbdTextEditor.g:476:3: ( 'asynAUTOCONNECT' )
                    // InternalDbdTextEditor.g:476:4: 'asynAUTOCONNECT'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getAsynAUTOCONNECTEnumLiteralDeclaration_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalDbdTextEditor.g:480:2: ( ( 'asynFMT' ) )
                    {
                    // InternalDbdTextEditor.g:480:2: ( ( 'asynFMT' ) )
                    // InternalDbdTextEditor.g:481:3: ( 'asynFMT' )
                    {
                     before(grammarAccess.getMenunamesAccess().getAsynFMTEnumLiteralDeclaration_26()); 
                    // InternalDbdTextEditor.g:482:3: ( 'asynFMT' )
                    // InternalDbdTextEditor.g:482:4: 'asynFMT'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getAsynFMTEnumLiteralDeclaration_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalDbdTextEditor.g:486:2: ( ( 'asynCONNECT' ) )
                    {
                    // InternalDbdTextEditor.g:486:2: ( ( 'asynCONNECT' ) )
                    // InternalDbdTextEditor.g:487:3: ( 'asynCONNECT' )
                    {
                     before(grammarAccess.getMenunamesAccess().getAsynCONNECTEnumLiteralDeclaration_27()); 
                    // InternalDbdTextEditor.g:488:3: ( 'asynCONNECT' )
                    // InternalDbdTextEditor.g:488:4: 'asynCONNECT'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getAsynCONNECTEnumLiteralDeclaration_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalDbdTextEditor.g:492:2: ( ( 'gpibUCMD' ) )
                    {
                    // InternalDbdTextEditor.g:492:2: ( ( 'gpibUCMD' ) )
                    // InternalDbdTextEditor.g:493:3: ( 'gpibUCMD' )
                    {
                     before(grammarAccess.getMenunamesAccess().getGpibUCMDEnumLiteralDeclaration_28()); 
                    // InternalDbdTextEditor.g:494:3: ( 'gpibUCMD' )
                    // InternalDbdTextEditor.g:494:4: 'gpibUCMD'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getGpibUCMDEnumLiteralDeclaration_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalDbdTextEditor.g:498:2: ( ( 'serialBAUD' ) )
                    {
                    // InternalDbdTextEditor.g:498:2: ( ( 'serialBAUD' ) )
                    // InternalDbdTextEditor.g:499:3: ( 'serialBAUD' )
                    {
                     before(grammarAccess.getMenunamesAccess().getSerialBAUDEnumLiteralDeclaration_29()); 
                    // InternalDbdTextEditor.g:500:3: ( 'serialBAUD' )
                    // InternalDbdTextEditor.g:500:4: 'serialBAUD'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getSerialBAUDEnumLiteralDeclaration_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalDbdTextEditor.g:504:2: ( ( 'histogramCMD' ) )
                    {
                    // InternalDbdTextEditor.g:504:2: ( ( 'histogramCMD' ) )
                    // InternalDbdTextEditor.g:505:3: ( 'histogramCMD' )
                    {
                     before(grammarAccess.getMenunamesAccess().getHistogramCMDEnumLiteralDeclaration_30()); 
                    // InternalDbdTextEditor.g:506:3: ( 'histogramCMD' )
                    // InternalDbdTextEditor.g:506:4: 'histogramCMD'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getHistogramCMDEnumLiteralDeclaration_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalDbdTextEditor.g:510:2: ( ( 'asynTRACE' ) )
                    {
                    // InternalDbdTextEditor.g:510:2: ( ( 'asynTRACE' ) )
                    // InternalDbdTextEditor.g:511:3: ( 'asynTRACE' )
                    {
                     before(grammarAccess.getMenunamesAccess().getAsynTRACEEnumLiteralDeclaration_31()); 
                    // InternalDbdTextEditor.g:512:3: ( 'asynTRACE' )
                    // InternalDbdTextEditor.g:512:4: 'asynTRACE'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getAsynTRACEEnumLiteralDeclaration_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalDbdTextEditor.g:516:2: ( ( 'scalerG1' ) )
                    {
                    // InternalDbdTextEditor.g:516:2: ( ( 'scalerG1' ) )
                    // InternalDbdTextEditor.g:517:3: ( 'scalerG1' )
                    {
                     before(grammarAccess.getMenunamesAccess().getScalerG1EnumLiteralDeclaration_32()); 
                    // InternalDbdTextEditor.g:518:3: ( 'scalerG1' )
                    // InternalDbdTextEditor.g:518:4: 'scalerG1'
                    {
                    match(input,43,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getScalerG1EnumLiteralDeclaration_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalDbdTextEditor.g:522:2: ( ( 'asynEOMREASON' ) )
                    {
                    // InternalDbdTextEditor.g:522:2: ( ( 'asynEOMREASON' ) )
                    // InternalDbdTextEditor.g:523:3: ( 'asynEOMREASON' )
                    {
                     before(grammarAccess.getMenunamesAccess().getAsynEOMREASONEnumLiteralDeclaration_33()); 
                    // InternalDbdTextEditor.g:524:3: ( 'asynEOMREASON' )
                    // InternalDbdTextEditor.g:524:4: 'asynEOMREASON'
                    {
                    match(input,44,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getAsynEOMREASONEnumLiteralDeclaration_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalDbdTextEditor.g:528:2: ( ( 'scalerCONT' ) )
                    {
                    // InternalDbdTextEditor.g:528:2: ( ( 'scalerCONT' ) )
                    // InternalDbdTextEditor.g:529:3: ( 'scalerCONT' )
                    {
                     before(grammarAccess.getMenunamesAccess().getScalerCONTEnumLiteralDeclaration_34()); 
                    // InternalDbdTextEditor.g:530:3: ( 'scalerCONT' )
                    // InternalDbdTextEditor.g:530:4: 'scalerCONT'
                    {
                    match(input,45,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getScalerCONTEnumLiteralDeclaration_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalDbdTextEditor.g:534:2: ( ( 'menuIvoa' ) )
                    {
                    // InternalDbdTextEditor.g:534:2: ( ( 'menuIvoa' ) )
                    // InternalDbdTextEditor.g:535:3: ( 'menuIvoa' )
                    {
                     before(grammarAccess.getMenunamesAccess().getMenuIvoaEnumLiteralDeclaration_35()); 
                    // InternalDbdTextEditor.g:536:3: ( 'menuIvoa' )
                    // InternalDbdTextEditor.g:536:4: 'menuIvoa'
                    {
                    match(input,46,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getMenuIvoaEnumLiteralDeclaration_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalDbdTextEditor.g:540:2: ( ( 'stringoutPOST' ) )
                    {
                    // InternalDbdTextEditor.g:540:2: ( ( 'stringoutPOST' ) )
                    // InternalDbdTextEditor.g:541:3: ( 'stringoutPOST' )
                    {
                     before(grammarAccess.getMenunamesAccess().getStringoutPOSTEnumLiteralDeclaration_36()); 
                    // InternalDbdTextEditor.g:542:3: ( 'stringoutPOST' )
                    // InternalDbdTextEditor.g:542:4: 'stringoutPOST'
                    {
                    match(input,47,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getStringoutPOSTEnumLiteralDeclaration_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalDbdTextEditor.g:546:2: ( ( 'menuAlarmSevr' ) )
                    {
                    // InternalDbdTextEditor.g:546:2: ( ( 'menuAlarmSevr' ) )
                    // InternalDbdTextEditor.g:547:3: ( 'menuAlarmSevr' )
                    {
                     before(grammarAccess.getMenunamesAccess().getMenuAlarmSevrEnumLiteralDeclaration_37()); 
                    // InternalDbdTextEditor.g:548:3: ( 'menuAlarmSevr' )
                    // InternalDbdTextEditor.g:548:4: 'menuAlarmSevr'
                    {
                    match(input,48,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getMenuAlarmSevrEnumLiteralDeclaration_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalDbdTextEditor.g:552:2: ( ( 'serialMCTL' ) )
                    {
                    // InternalDbdTextEditor.g:552:2: ( ( 'serialMCTL' ) )
                    // InternalDbdTextEditor.g:553:3: ( 'serialMCTL' )
                    {
                     before(grammarAccess.getMenunamesAccess().getSerialMCTLEnumLiteralDeclaration_38()); 
                    // InternalDbdTextEditor.g:554:3: ( 'serialMCTL' )
                    // InternalDbdTextEditor.g:554:4: 'serialMCTL'
                    {
                    match(input,49,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getSerialMCTLEnumLiteralDeclaration_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalDbdTextEditor.g:558:2: ( ( 'serialFCTL' ) )
                    {
                    // InternalDbdTextEditor.g:558:2: ( ( 'serialFCTL' ) )
                    // InternalDbdTextEditor.g:559:3: ( 'serialFCTL' )
                    {
                     before(grammarAccess.getMenunamesAccess().getSerialFCTLEnumLiteralDeclaration_39()); 
                    // InternalDbdTextEditor.g:560:3: ( 'serialFCTL' )
                    // InternalDbdTextEditor.g:560:4: 'serialFCTL'
                    {
                    match(input,50,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getSerialFCTLEnumLiteralDeclaration_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalDbdTextEditor.g:564:2: ( ( 'menuSimm' ) )
                    {
                    // InternalDbdTextEditor.g:564:2: ( ( 'menuSimm' ) )
                    // InternalDbdTextEditor.g:565:3: ( 'menuSimm' )
                    {
                     before(grammarAccess.getMenunamesAccess().getMenuSimmEnumLiteralDeclaration_40()); 
                    // InternalDbdTextEditor.g:566:3: ( 'menuSimm' )
                    // InternalDbdTextEditor.g:566:4: 'menuSimm'
                    {
                    match(input,51,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getMenuSimmEnumLiteralDeclaration_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalDbdTextEditor.g:570:2: ( ( 'compressALG' ) )
                    {
                    // InternalDbdTextEditor.g:570:2: ( ( 'compressALG' ) )
                    // InternalDbdTextEditor.g:571:3: ( 'compressALG' )
                    {
                     before(grammarAccess.getMenunamesAccess().getCompressALGEnumLiteralDeclaration_41()); 
                    // InternalDbdTextEditor.g:572:3: ( 'compressALG' )
                    // InternalDbdTextEditor.g:572:4: 'compressALG'
                    {
                    match(input,52,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getCompressALGEnumLiteralDeclaration_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalDbdTextEditor.g:576:2: ( ( 'aSubEFLG' ) )
                    {
                    // InternalDbdTextEditor.g:576:2: ( ( 'aSubEFLG' ) )
                    // InternalDbdTextEditor.g:577:3: ( 'aSubEFLG' )
                    {
                     before(grammarAccess.getMenunamesAccess().getASubEFLGEnumLiteralDeclaration_42()); 
                    // InternalDbdTextEditor.g:578:3: ( 'aSubEFLG' )
                    // InternalDbdTextEditor.g:578:4: 'aSubEFLG'
                    {
                    match(input,53,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getASubEFLGEnumLiteralDeclaration_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalDbdTextEditor.g:582:2: ( ( 'fanoutSELM' ) )
                    {
                    // InternalDbdTextEditor.g:582:2: ( ( 'fanoutSELM' ) )
                    // InternalDbdTextEditor.g:583:3: ( 'fanoutSELM' )
                    {
                     before(grammarAccess.getMenunamesAccess().getFanoutSELMEnumLiteralDeclaration_43()); 
                    // InternalDbdTextEditor.g:584:3: ( 'fanoutSELM' )
                    // InternalDbdTextEditor.g:584:4: 'fanoutSELM'
                    {
                    match(input,54,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getFanoutSELMEnumLiteralDeclaration_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalDbdTextEditor.g:588:2: ( ( 'calcoutOOPT' ) )
                    {
                    // InternalDbdTextEditor.g:588:2: ( ( 'calcoutOOPT' ) )
                    // InternalDbdTextEditor.g:589:3: ( 'calcoutOOPT' )
                    {
                     before(grammarAccess.getMenunamesAccess().getCalcoutOOPTEnumLiteralDeclaration_44()); 
                    // InternalDbdTextEditor.g:590:3: ( 'calcoutOOPT' )
                    // InternalDbdTextEditor.g:590:4: 'calcoutOOPT'
                    {
                    match(input,55,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getCalcoutOOPTEnumLiteralDeclaration_44()); 

                    }


                    }
                    break;
                case 46 :
                    // InternalDbdTextEditor.g:594:2: ( ( 'asynENABLE' ) )
                    {
                    // InternalDbdTextEditor.g:594:2: ( ( 'asynENABLE' ) )
                    // InternalDbdTextEditor.g:595:3: ( 'asynENABLE' )
                    {
                     before(grammarAccess.getMenunamesAccess().getAsynENABLEEnumLiteralDeclaration_45()); 
                    // InternalDbdTextEditor.g:596:3: ( 'asynENABLE' )
                    // InternalDbdTextEditor.g:596:4: 'asynENABLE'
                    {
                    match(input,56,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getAsynENABLEEnumLiteralDeclaration_45()); 

                    }


                    }
                    break;
                case 47 :
                    // InternalDbdTextEditor.g:600:2: ( ( 'epidFeedbackMode' ) )
                    {
                    // InternalDbdTextEditor.g:600:2: ( ( 'epidFeedbackMode' ) )
                    // InternalDbdTextEditor.g:601:3: ( 'epidFeedbackMode' )
                    {
                     before(grammarAccess.getMenunamesAccess().getEpidFeedbackModeEnumLiteralDeclaration_46()); 
                    // InternalDbdTextEditor.g:602:3: ( 'epidFeedbackMode' )
                    // InternalDbdTextEditor.g:602:4: 'epidFeedbackMode'
                    {
                    match(input,57,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getEpidFeedbackModeEnumLiteralDeclaration_46()); 

                    }


                    }
                    break;
                case 48 :
                    // InternalDbdTextEditor.g:606:2: ( ( 'menuConvert' ) )
                    {
                    // InternalDbdTextEditor.g:606:2: ( ( 'menuConvert' ) )
                    // InternalDbdTextEditor.g:607:3: ( 'menuConvert' )
                    {
                     before(grammarAccess.getMenunamesAccess().getMenuConvertEnumLiteralDeclaration_47()); 
                    // InternalDbdTextEditor.g:608:3: ( 'menuConvert' )
                    // InternalDbdTextEditor.g:608:4: 'menuConvert'
                    {
                    match(input,58,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getMenuConvertEnumLiteralDeclaration_47()); 

                    }


                    }
                    break;
                case 49 :
                    // InternalDbdTextEditor.g:612:2: ( ( 'scalerCNT' ) )
                    {
                    // InternalDbdTextEditor.g:612:2: ( ( 'scalerCNT' ) )
                    // InternalDbdTextEditor.g:613:3: ( 'scalerCNT' )
                    {
                     before(grammarAccess.getMenunamesAccess().getScalerCNTEnumLiteralDeclaration_48()); 
                    // InternalDbdTextEditor.g:614:3: ( 'scalerCNT' )
                    // InternalDbdTextEditor.g:614:4: 'scalerCNT'
                    {
                    match(input,59,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getScalerCNTEnumLiteralDeclaration_48()); 

                    }


                    }
                    break;
                case 50 :
                    // InternalDbdTextEditor.g:618:2: ( ( 'serialIX' ) )
                    {
                    // InternalDbdTextEditor.g:618:2: ( ( 'serialIX' ) )
                    // InternalDbdTextEditor.g:619:3: ( 'serialIX' )
                    {
                     before(grammarAccess.getMenunamesAccess().getSerialIXEnumLiteralDeclaration_49()); 
                    // InternalDbdTextEditor.g:620:3: ( 'serialIX' )
                    // InternalDbdTextEditor.g:620:4: 'serialIX'
                    {
                    match(input,60,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getSerialIXEnumLiteralDeclaration_49()); 

                    }


                    }
                    break;
                case 51 :
                    // InternalDbdTextEditor.g:624:2: ( ( 'menuYesNo' ) )
                    {
                    // InternalDbdTextEditor.g:624:2: ( ( 'menuYesNo' ) )
                    // InternalDbdTextEditor.g:625:3: ( 'menuYesNo' )
                    {
                     before(grammarAccess.getMenunamesAccess().getMenuYesNoEnumLiteralDeclaration_50()); 
                    // InternalDbdTextEditor.g:626:3: ( 'menuYesNo' )
                    // InternalDbdTextEditor.g:626:4: 'menuYesNo'
                    {
                    match(input,61,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getMenuYesNoEnumLiteralDeclaration_50()); 

                    }


                    }
                    break;
                case 52 :
                    // InternalDbdTextEditor.g:630:2: ( ( 'timestampTST' ) )
                    {
                    // InternalDbdTextEditor.g:630:2: ( ( 'timestampTST' ) )
                    // InternalDbdTextEditor.g:631:3: ( 'timestampTST' )
                    {
                     before(grammarAccess.getMenunamesAccess().getTimestampTSTEnumLiteralDeclaration_51()); 
                    // InternalDbdTextEditor.g:632:3: ( 'timestampTST' )
                    // InternalDbdTextEditor.g:632:4: 'timestampTST'
                    {
                    match(input,62,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getTimestampTSTEnumLiteralDeclaration_51()); 

                    }


                    }
                    break;
                case 53 :
                    // InternalDbdTextEditor.g:636:2: ( ( 'serialDBIT' ) )
                    {
                    // InternalDbdTextEditor.g:636:2: ( ( 'serialDBIT' ) )
                    // InternalDbdTextEditor.g:637:3: ( 'serialDBIT' )
                    {
                     before(grammarAccess.getMenunamesAccess().getSerialDBITEnumLiteralDeclaration_52()); 
                    // InternalDbdTextEditor.g:638:3: ( 'serialDBIT' )
                    // InternalDbdTextEditor.g:638:4: 'serialDBIT'
                    {
                    match(input,63,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getSerialDBITEnumLiteralDeclaration_52()); 

                    }


                    }
                    break;
                case 54 :
                    // InternalDbdTextEditor.g:642:2: ( ( 'selSELM' ) )
                    {
                    // InternalDbdTextEditor.g:642:2: ( ( 'selSELM' ) )
                    // InternalDbdTextEditor.g:643:3: ( 'selSELM' )
                    {
                     before(grammarAccess.getMenunamesAccess().getSelSELMEnumLiteralDeclaration_53()); 
                    // InternalDbdTextEditor.g:644:3: ( 'selSELM' )
                    // InternalDbdTextEditor.g:644:4: 'selSELM'
                    {
                    match(input,64,FOLLOW_2); 

                    }

                     after(grammarAccess.getMenunamesAccess().getSelSELMEnumLiteralDeclaration_53()); 

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
    // $ANTLR end "rule__Menunames__Alternatives"


    // $ANTLR start "rule__Choicenames__Alternatives"
    // InternalDbdTextEditor.g:652:1: rule__Choicenames__Alternatives : ( ( ( 'serialPRTY_unknown' ) ) | ( ( 'serialPRTY_None' ) ) | ( ( 'serialPRTY_Even' ) ) | ( ( 'serialPRTY_Odd' ) ) | ( ( 'waveformPOST_Always' ) ) | ( ( 'waveformPOST_OnChange' ) ) | ( ( 'aaoPOST_Always' ) ) | ( ( 'aaoPOST_OnChange' ) ) | ( ( 'menuPriorityLOW' ) ) | ( ( 'menuPriorityMEDIUM' ) ) | ( ( 'menuPriorityHIGH' ) ) | ( ( 'serialSBIT_unknown' ) ) | ( ( 'serialSBIT_1' ) ) | ( ( 'serialSBIT_2' ) ) | ( ( 'calcoutDOPT_Use_VAL' ) ) | ( ( 'calcoutDOPT_Use_OVAL' ) ) | ( ( 'menuOmslsupervisory' ) ) | ( ( 'menuOmslclosed_loop' ) ) | ( ( 'menuFtypeSTRING' ) ) | ( ( 'menuFtypeCHAR' ) ) | ( ( 'menuFtypeUCHAR' ) ) | ( ( 'menuFtypeSHORT' ) ) | ( ( 'menuFtypeUSHORT' ) ) | ( ( 'menuFtypeLONG' ) ) | ( ( 'menuFtypeULONG' ) ) | ( ( 'menuFtypeINT64' ) ) | ( ( 'menuFtypeUINT64' ) ) | ( ( 'menuFtypeFLOAT' ) ) | ( ( 'menuFtypeDOUBLE' ) ) | ( ( 'menuFtypeENUM' ) ) | ( ( 'stringinPOST_OnChange' ) ) | ( ( 'stringinPOST_Always' ) ) | ( ( 'menuPiniNO' ) ) | ( ( 'menuPiniYES' ) ) | ( ( 'menuPiniRUN' ) ) | ( ( 'menuPiniRUNNING' ) ) | ( ( 'menuPiniPAUSE' ) ) | ( ( 'menuPiniPAUSED' ) ) | ( ( 'dfanoutSELM_All' ) ) | ( ( 'dfanoutSELM_Specified' ) ) | ( ( 'dfanoutSELM_Mask' ) ) | ( ( 'menuScanPassive' ) ) | ( ( 'menuScanEvent' ) ) | ( ( 'menuScanI_O_Intr' ) ) | ( ( 'menuScan10_second' ) ) | ( ( 'menuScan5_second' ) ) | ( ( 'menuScan2_second' ) ) | ( ( 'menuScan1_second' ) ) | ( ( 'menuScan_5_second' ) ) | ( ( 'menuScan_2_second' ) ) | ( ( 'menuScan_1_second' ) ) | ( ( 'gpibACMD_None' ) ) | ( ( 'gpibACMD_Group_Execute_Trig___GET_' ) ) | ( ( 'gpibACMD_Go_To_Local__GTL_' ) ) | ( ( 'gpibACMD_Selected_Dev__Clear__SDC_' ) ) | ( ( 'gpibACMD_Take_Control__TCT_' ) ) | ( ( 'gpibACMD_Serial_Poll' ) ) | ( ( 'aSubLFLG_IGNORE' ) ) | ( ( 'aSubLFLG_READ' ) ) | ( ( 'asynTMOD_Write_Read' ) ) | ( ( 'asynTMOD_Write' ) ) | ( ( 'asynTMOD_Read' ) ) | ( ( 'asynTMOD_Flush' ) ) | ( ( 'asynTMOD_NoIO' ) ) | ( ( 'ipDRTO_unknown' ) ) | ( ( 'ipDRTO_No' ) ) | ( ( 'ipDRTO_Yes' ) ) | ( ( 'scalerD1_Up' ) ) | ( ( 'scalerD1_Dn' ) ) | ( ( 'menuPost_OnChange' ) ) | ( ( 'menuPost_Always' ) ) | ( ( 'asynINTERFACE_OCTET' ) ) | ( ( 'asynINTERFACE_INT32' ) ) | ( ( 'asynINTERFACE_UINT32' ) ) | ( ( 'asynINTERFACE_FLOAT64' ) ) | ( ( 'menuAlarmStatNO_ALARM' ) ) | ( ( 'menuAlarmStatREAD' ) ) | ( ( 'menuAlarmStatWRITE' ) ) | ( ( 'menuAlarmStatHIHI' ) ) | ( ( 'menuAlarmStatHIGH' ) ) | ( ( 'menuAlarmStatLOLO' ) ) | ( ( 'menuAlarmStatLOW' ) ) | ( ( 'menuAlarmStatSTATE' ) ) | ( ( 'menuAlarmStatCOS' ) ) | ( ( 'menuAlarmStatCOMM' ) ) | ( ( 'menuAlarmStatTIMEOUT' ) ) | ( ( 'menuAlarmStatHWLIMIT' ) ) | ( ( 'menuAlarmStatCALC' ) ) | ( ( 'menuAlarmStatSCAN' ) ) | ( ( 'menuAlarmStatLINK' ) ) | ( ( 'menuAlarmStatSOFT' ) ) | ( ( 'menuAlarmStatBAD_SUB' ) ) | ( ( 'menuAlarmStatUDF' ) ) | ( ( 'menuAlarmStatDISABLE' ) ) | ( ( 'menuAlarmStatSIMM' ) ) | ( ( 'menuAlarmStatREAD_ACCESS' ) ) | ( ( 'menuAlarmStatWRITE_ACCESS' ) ) | ( ( 'aoOIF_Full' ) ) | ( ( 'aoOIF_Incremental' ) ) | ( ( 'bufferingALG_FIFO' ) ) | ( ( 'bufferingALG_LIFO' ) ) | ( ( 'aaiPOST_Always' ) ) | ( ( 'aaiPOST_OnChange' ) ) | ( ( 'epidFeedbackState_Off' ) ) | ( ( 'epidFeedbackState_On' ) ) | ( ( 'calcoutINAV_EXT_NC' ) ) | ( ( 'calcoutINAV_EXT' ) ) | ( ( 'calcoutINAV_LOC' ) ) | ( ( 'calcoutINAV_CON' ) ) | ( ( 'asynAUTOCONNECT_noAutoConnect' ) ) | ( ( 'asynAUTOCONNECT_autoConnect' ) ) | ( ( 'asynFMT_ASCII' ) ) | ( ( 'asynFMT_Hybrid' ) ) | ( ( 'asynFMT_Binary' ) ) | ( ( 'seqSELM_All' ) ) | ( ( 'seqSELM_Specified' ) ) | ( ( 'seqSELM_Mask' ) ) | ( ( 'asynCONNECT_Disconnect' ) ) | ( ( 'asynCONNECT_Connect' ) ) | ( ( 'gpibUCMD_None' ) ) | ( ( 'gpibUCMD_Device_Clear__DCL_' ) ) | ( ( 'gpibUCMD_Local_Lockout__LL0_' ) ) | ( ( 'gpibUCMD_Serial_Poll_Disable__SPD_' ) ) | ( ( 'gpibUCMD_Serial_Poll_Enable__SPE_' ) ) | ( ( 'gpibUCMD_Unlisten__UNL_' ) ) | ( ( 'gpibUCMD_Untalk__UNT_' ) ) | ( ( 'serialBAUD_unknown' ) ) | ( ( 'serialBAUD_300' ) ) | ( ( 'serialBAUD_600' ) ) | ( ( 'serialBAUD_1200' ) ) | ( ( 'serialBAUD_2400' ) ) | ( ( 'serialBAUD_4800' ) ) | ( ( 'serialBAUD_9600' ) ) | ( ( 'serialBAUD_19200' ) ) | ( ( 'serialBAUD_38400' ) ) | ( ( 'serialBAUD_57600' ) ) | ( ( 'serialBAUD_115200' ) ) | ( ( 'serialBAUD_230400' ) ) | ( ( 'serialBAUD_460800' ) ) | ( ( 'serialBAUD_576000' ) ) | ( ( 'serialBAUD_921600' ) ) | ( ( 'serialBAUD_1152000' ) ) | ( ( 'histogramCMD_Read' ) ) | ( ( 'histogramCMD_Clear' ) ) | ( ( 'histogramCMD_Start' ) ) | ( ( 'histogramCMD_Stop' ) ) | ( ( 'asynTRACE_Off' ) ) | ( ( 'asynTRACE_On' ) ) | ( ( 'scalerG1_N' ) ) | ( ( 'scalerG1_Y' ) ) | ( ( 'asynEOMREASONNone' ) ) );
    public final void rule__Choicenames__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:656:1: ( ( ( 'serialPRTY_unknown' ) ) | ( ( 'serialPRTY_None' ) ) | ( ( 'serialPRTY_Even' ) ) | ( ( 'serialPRTY_Odd' ) ) | ( ( 'waveformPOST_Always' ) ) | ( ( 'waveformPOST_OnChange' ) ) | ( ( 'aaoPOST_Always' ) ) | ( ( 'aaoPOST_OnChange' ) ) | ( ( 'menuPriorityLOW' ) ) | ( ( 'menuPriorityMEDIUM' ) ) | ( ( 'menuPriorityHIGH' ) ) | ( ( 'serialSBIT_unknown' ) ) | ( ( 'serialSBIT_1' ) ) | ( ( 'serialSBIT_2' ) ) | ( ( 'calcoutDOPT_Use_VAL' ) ) | ( ( 'calcoutDOPT_Use_OVAL' ) ) | ( ( 'menuOmslsupervisory' ) ) | ( ( 'menuOmslclosed_loop' ) ) | ( ( 'menuFtypeSTRING' ) ) | ( ( 'menuFtypeCHAR' ) ) | ( ( 'menuFtypeUCHAR' ) ) | ( ( 'menuFtypeSHORT' ) ) | ( ( 'menuFtypeUSHORT' ) ) | ( ( 'menuFtypeLONG' ) ) | ( ( 'menuFtypeULONG' ) ) | ( ( 'menuFtypeINT64' ) ) | ( ( 'menuFtypeUINT64' ) ) | ( ( 'menuFtypeFLOAT' ) ) | ( ( 'menuFtypeDOUBLE' ) ) | ( ( 'menuFtypeENUM' ) ) | ( ( 'stringinPOST_OnChange' ) ) | ( ( 'stringinPOST_Always' ) ) | ( ( 'menuPiniNO' ) ) | ( ( 'menuPiniYES' ) ) | ( ( 'menuPiniRUN' ) ) | ( ( 'menuPiniRUNNING' ) ) | ( ( 'menuPiniPAUSE' ) ) | ( ( 'menuPiniPAUSED' ) ) | ( ( 'dfanoutSELM_All' ) ) | ( ( 'dfanoutSELM_Specified' ) ) | ( ( 'dfanoutSELM_Mask' ) ) | ( ( 'menuScanPassive' ) ) | ( ( 'menuScanEvent' ) ) | ( ( 'menuScanI_O_Intr' ) ) | ( ( 'menuScan10_second' ) ) | ( ( 'menuScan5_second' ) ) | ( ( 'menuScan2_second' ) ) | ( ( 'menuScan1_second' ) ) | ( ( 'menuScan_5_second' ) ) | ( ( 'menuScan_2_second' ) ) | ( ( 'menuScan_1_second' ) ) | ( ( 'gpibACMD_None' ) ) | ( ( 'gpibACMD_Group_Execute_Trig___GET_' ) ) | ( ( 'gpibACMD_Go_To_Local__GTL_' ) ) | ( ( 'gpibACMD_Selected_Dev__Clear__SDC_' ) ) | ( ( 'gpibACMD_Take_Control__TCT_' ) ) | ( ( 'gpibACMD_Serial_Poll' ) ) | ( ( 'aSubLFLG_IGNORE' ) ) | ( ( 'aSubLFLG_READ' ) ) | ( ( 'asynTMOD_Write_Read' ) ) | ( ( 'asynTMOD_Write' ) ) | ( ( 'asynTMOD_Read' ) ) | ( ( 'asynTMOD_Flush' ) ) | ( ( 'asynTMOD_NoIO' ) ) | ( ( 'ipDRTO_unknown' ) ) | ( ( 'ipDRTO_No' ) ) | ( ( 'ipDRTO_Yes' ) ) | ( ( 'scalerD1_Up' ) ) | ( ( 'scalerD1_Dn' ) ) | ( ( 'menuPost_OnChange' ) ) | ( ( 'menuPost_Always' ) ) | ( ( 'asynINTERFACE_OCTET' ) ) | ( ( 'asynINTERFACE_INT32' ) ) | ( ( 'asynINTERFACE_UINT32' ) ) | ( ( 'asynINTERFACE_FLOAT64' ) ) | ( ( 'menuAlarmStatNO_ALARM' ) ) | ( ( 'menuAlarmStatREAD' ) ) | ( ( 'menuAlarmStatWRITE' ) ) | ( ( 'menuAlarmStatHIHI' ) ) | ( ( 'menuAlarmStatHIGH' ) ) | ( ( 'menuAlarmStatLOLO' ) ) | ( ( 'menuAlarmStatLOW' ) ) | ( ( 'menuAlarmStatSTATE' ) ) | ( ( 'menuAlarmStatCOS' ) ) | ( ( 'menuAlarmStatCOMM' ) ) | ( ( 'menuAlarmStatTIMEOUT' ) ) | ( ( 'menuAlarmStatHWLIMIT' ) ) | ( ( 'menuAlarmStatCALC' ) ) | ( ( 'menuAlarmStatSCAN' ) ) | ( ( 'menuAlarmStatLINK' ) ) | ( ( 'menuAlarmStatSOFT' ) ) | ( ( 'menuAlarmStatBAD_SUB' ) ) | ( ( 'menuAlarmStatUDF' ) ) | ( ( 'menuAlarmStatDISABLE' ) ) | ( ( 'menuAlarmStatSIMM' ) ) | ( ( 'menuAlarmStatREAD_ACCESS' ) ) | ( ( 'menuAlarmStatWRITE_ACCESS' ) ) | ( ( 'aoOIF_Full' ) ) | ( ( 'aoOIF_Incremental' ) ) | ( ( 'bufferingALG_FIFO' ) ) | ( ( 'bufferingALG_LIFO' ) ) | ( ( 'aaiPOST_Always' ) ) | ( ( 'aaiPOST_OnChange' ) ) | ( ( 'epidFeedbackState_Off' ) ) | ( ( 'epidFeedbackState_On' ) ) | ( ( 'calcoutINAV_EXT_NC' ) ) | ( ( 'calcoutINAV_EXT' ) ) | ( ( 'calcoutINAV_LOC' ) ) | ( ( 'calcoutINAV_CON' ) ) | ( ( 'asynAUTOCONNECT_noAutoConnect' ) ) | ( ( 'asynAUTOCONNECT_autoConnect' ) ) | ( ( 'asynFMT_ASCII' ) ) | ( ( 'asynFMT_Hybrid' ) ) | ( ( 'asynFMT_Binary' ) ) | ( ( 'seqSELM_All' ) ) | ( ( 'seqSELM_Specified' ) ) | ( ( 'seqSELM_Mask' ) ) | ( ( 'asynCONNECT_Disconnect' ) ) | ( ( 'asynCONNECT_Connect' ) ) | ( ( 'gpibUCMD_None' ) ) | ( ( 'gpibUCMD_Device_Clear__DCL_' ) ) | ( ( 'gpibUCMD_Local_Lockout__LL0_' ) ) | ( ( 'gpibUCMD_Serial_Poll_Disable__SPD_' ) ) | ( ( 'gpibUCMD_Serial_Poll_Enable__SPE_' ) ) | ( ( 'gpibUCMD_Unlisten__UNL_' ) ) | ( ( 'gpibUCMD_Untalk__UNT_' ) ) | ( ( 'serialBAUD_unknown' ) ) | ( ( 'serialBAUD_300' ) ) | ( ( 'serialBAUD_600' ) ) | ( ( 'serialBAUD_1200' ) ) | ( ( 'serialBAUD_2400' ) ) | ( ( 'serialBAUD_4800' ) ) | ( ( 'serialBAUD_9600' ) ) | ( ( 'serialBAUD_19200' ) ) | ( ( 'serialBAUD_38400' ) ) | ( ( 'serialBAUD_57600' ) ) | ( ( 'serialBAUD_115200' ) ) | ( ( 'serialBAUD_230400' ) ) | ( ( 'serialBAUD_460800' ) ) | ( ( 'serialBAUD_576000' ) ) | ( ( 'serialBAUD_921600' ) ) | ( ( 'serialBAUD_1152000' ) ) | ( ( 'histogramCMD_Read' ) ) | ( ( 'histogramCMD_Clear' ) ) | ( ( 'histogramCMD_Start' ) ) | ( ( 'histogramCMD_Stop' ) ) | ( ( 'asynTRACE_Off' ) ) | ( ( 'asynTRACE_On' ) ) | ( ( 'scalerG1_N' ) ) | ( ( 'scalerG1_Y' ) ) | ( ( 'asynEOMREASONNone' ) ) )
            int alt3=151;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt3=1;
                }
                break;
            case 66:
                {
                alt3=2;
                }
                break;
            case 67:
                {
                alt3=3;
                }
                break;
            case 68:
                {
                alt3=4;
                }
                break;
            case 69:
                {
                alt3=5;
                }
                break;
            case 70:
                {
                alt3=6;
                }
                break;
            case 71:
                {
                alt3=7;
                }
                break;
            case 72:
                {
                alt3=8;
                }
                break;
            case 73:
                {
                alt3=9;
                }
                break;
            case 74:
                {
                alt3=10;
                }
                break;
            case 75:
                {
                alt3=11;
                }
                break;
            case 76:
                {
                alt3=12;
                }
                break;
            case 77:
                {
                alt3=13;
                }
                break;
            case 78:
                {
                alt3=14;
                }
                break;
            case 79:
                {
                alt3=15;
                }
                break;
            case 80:
                {
                alt3=16;
                }
                break;
            case 81:
                {
                alt3=17;
                }
                break;
            case 82:
                {
                alt3=18;
                }
                break;
            case 83:
                {
                alt3=19;
                }
                break;
            case 84:
                {
                alt3=20;
                }
                break;
            case 85:
                {
                alt3=21;
                }
                break;
            case 86:
                {
                alt3=22;
                }
                break;
            case 87:
                {
                alt3=23;
                }
                break;
            case 88:
                {
                alt3=24;
                }
                break;
            case 89:
                {
                alt3=25;
                }
                break;
            case 90:
                {
                alt3=26;
                }
                break;
            case 91:
                {
                alt3=27;
                }
                break;
            case 92:
                {
                alt3=28;
                }
                break;
            case 93:
                {
                alt3=29;
                }
                break;
            case 94:
                {
                alt3=30;
                }
                break;
            case 95:
                {
                alt3=31;
                }
                break;
            case 96:
                {
                alt3=32;
                }
                break;
            case 97:
                {
                alt3=33;
                }
                break;
            case 98:
                {
                alt3=34;
                }
                break;
            case 99:
                {
                alt3=35;
                }
                break;
            case 100:
                {
                alt3=36;
                }
                break;
            case 101:
                {
                alt3=37;
                }
                break;
            case 102:
                {
                alt3=38;
                }
                break;
            case 103:
                {
                alt3=39;
                }
                break;
            case 104:
                {
                alt3=40;
                }
                break;
            case 105:
                {
                alt3=41;
                }
                break;
            case 106:
                {
                alt3=42;
                }
                break;
            case 107:
                {
                alt3=43;
                }
                break;
            case 108:
                {
                alt3=44;
                }
                break;
            case 109:
                {
                alt3=45;
                }
                break;
            case 110:
                {
                alt3=46;
                }
                break;
            case 111:
                {
                alt3=47;
                }
                break;
            case 112:
                {
                alt3=48;
                }
                break;
            case 113:
                {
                alt3=49;
                }
                break;
            case 114:
                {
                alt3=50;
                }
                break;
            case 115:
                {
                alt3=51;
                }
                break;
            case 116:
                {
                alt3=52;
                }
                break;
            case 117:
                {
                alt3=53;
                }
                break;
            case 118:
                {
                alt3=54;
                }
                break;
            case 119:
                {
                alt3=55;
                }
                break;
            case 120:
                {
                alt3=56;
                }
                break;
            case 121:
                {
                alt3=57;
                }
                break;
            case 122:
                {
                alt3=58;
                }
                break;
            case 123:
                {
                alt3=59;
                }
                break;
            case 124:
                {
                alt3=60;
                }
                break;
            case 125:
                {
                alt3=61;
                }
                break;
            case 126:
                {
                alt3=62;
                }
                break;
            case 127:
                {
                alt3=63;
                }
                break;
            case 128:
                {
                alt3=64;
                }
                break;
            case 129:
                {
                alt3=65;
                }
                break;
            case 130:
                {
                alt3=66;
                }
                break;
            case 131:
                {
                alt3=67;
                }
                break;
            case 132:
                {
                alt3=68;
                }
                break;
            case 133:
                {
                alt3=69;
                }
                break;
            case 134:
                {
                alt3=70;
                }
                break;
            case 135:
                {
                alt3=71;
                }
                break;
            case 136:
                {
                alt3=72;
                }
                break;
            case 137:
                {
                alt3=73;
                }
                break;
            case 138:
                {
                alt3=74;
                }
                break;
            case 139:
                {
                alt3=75;
                }
                break;
            case 140:
                {
                alt3=76;
                }
                break;
            case 141:
                {
                alt3=77;
                }
                break;
            case 142:
                {
                alt3=78;
                }
                break;
            case 143:
                {
                alt3=79;
                }
                break;
            case 144:
                {
                alt3=80;
                }
                break;
            case 145:
                {
                alt3=81;
                }
                break;
            case 146:
                {
                alt3=82;
                }
                break;
            case 147:
                {
                alt3=83;
                }
                break;
            case 148:
                {
                alt3=84;
                }
                break;
            case 149:
                {
                alt3=85;
                }
                break;
            case 150:
                {
                alt3=86;
                }
                break;
            case 151:
                {
                alt3=87;
                }
                break;
            case 152:
                {
                alt3=88;
                }
                break;
            case 153:
                {
                alt3=89;
                }
                break;
            case 154:
                {
                alt3=90;
                }
                break;
            case 155:
                {
                alt3=91;
                }
                break;
            case 156:
                {
                alt3=92;
                }
                break;
            case 157:
                {
                alt3=93;
                }
                break;
            case 158:
                {
                alt3=94;
                }
                break;
            case 159:
                {
                alt3=95;
                }
                break;
            case 160:
                {
                alt3=96;
                }
                break;
            case 161:
                {
                alt3=97;
                }
                break;
            case 162:
                {
                alt3=98;
                }
                break;
            case 163:
                {
                alt3=99;
                }
                break;
            case 164:
                {
                alt3=100;
                }
                break;
            case 165:
                {
                alt3=101;
                }
                break;
            case 166:
                {
                alt3=102;
                }
                break;
            case 167:
                {
                alt3=103;
                }
                break;
            case 168:
                {
                alt3=104;
                }
                break;
            case 169:
                {
                alt3=105;
                }
                break;
            case 170:
                {
                alt3=106;
                }
                break;
            case 171:
                {
                alt3=107;
                }
                break;
            case 172:
                {
                alt3=108;
                }
                break;
            case 173:
                {
                alt3=109;
                }
                break;
            case 174:
                {
                alt3=110;
                }
                break;
            case 175:
                {
                alt3=111;
                }
                break;
            case 176:
                {
                alt3=112;
                }
                break;
            case 177:
                {
                alt3=113;
                }
                break;
            case 178:
                {
                alt3=114;
                }
                break;
            case 179:
                {
                alt3=115;
                }
                break;
            case 180:
                {
                alt3=116;
                }
                break;
            case 181:
                {
                alt3=117;
                }
                break;
            case 182:
                {
                alt3=118;
                }
                break;
            case 183:
                {
                alt3=119;
                }
                break;
            case 184:
                {
                alt3=120;
                }
                break;
            case 185:
                {
                alt3=121;
                }
                break;
            case 186:
                {
                alt3=122;
                }
                break;
            case 187:
                {
                alt3=123;
                }
                break;
            case 188:
                {
                alt3=124;
                }
                break;
            case 189:
                {
                alt3=125;
                }
                break;
            case 190:
                {
                alt3=126;
                }
                break;
            case 191:
                {
                alt3=127;
                }
                break;
            case 192:
                {
                alt3=128;
                }
                break;
            case 193:
                {
                alt3=129;
                }
                break;
            case 194:
                {
                alt3=130;
                }
                break;
            case 195:
                {
                alt3=131;
                }
                break;
            case 196:
                {
                alt3=132;
                }
                break;
            case 197:
                {
                alt3=133;
                }
                break;
            case 198:
                {
                alt3=134;
                }
                break;
            case 199:
                {
                alt3=135;
                }
                break;
            case 200:
                {
                alt3=136;
                }
                break;
            case 201:
                {
                alt3=137;
                }
                break;
            case 202:
                {
                alt3=138;
                }
                break;
            case 203:
                {
                alt3=139;
                }
                break;
            case 204:
                {
                alt3=140;
                }
                break;
            case 205:
                {
                alt3=141;
                }
                break;
            case 206:
                {
                alt3=142;
                }
                break;
            case 207:
                {
                alt3=143;
                }
                break;
            case 208:
                {
                alt3=144;
                }
                break;
            case 209:
                {
                alt3=145;
                }
                break;
            case 210:
                {
                alt3=146;
                }
                break;
            case 211:
                {
                alt3=147;
                }
                break;
            case 212:
                {
                alt3=148;
                }
                break;
            case 213:
                {
                alt3=149;
                }
                break;
            case 214:
                {
                alt3=150;
                }
                break;
            case 215:
                {
                alt3=151;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalDbdTextEditor.g:657:2: ( ( 'serialPRTY_unknown' ) )
                    {
                    // InternalDbdTextEditor.g:657:2: ( ( 'serialPRTY_unknown' ) )
                    // InternalDbdTextEditor.g:658:3: ( 'serialPRTY_unknown' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialPRTY_unknownEnumLiteralDeclaration_0()); 
                    // InternalDbdTextEditor.g:659:3: ( 'serialPRTY_unknown' )
                    // InternalDbdTextEditor.g:659:4: 'serialPRTY_unknown'
                    {
                    match(input,65,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialPRTY_unknownEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDbdTextEditor.g:663:2: ( ( 'serialPRTY_None' ) )
                    {
                    // InternalDbdTextEditor.g:663:2: ( ( 'serialPRTY_None' ) )
                    // InternalDbdTextEditor.g:664:3: ( 'serialPRTY_None' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialPRTY_NoneEnumLiteralDeclaration_1()); 
                    // InternalDbdTextEditor.g:665:3: ( 'serialPRTY_None' )
                    // InternalDbdTextEditor.g:665:4: 'serialPRTY_None'
                    {
                    match(input,66,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialPRTY_NoneEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDbdTextEditor.g:669:2: ( ( 'serialPRTY_Even' ) )
                    {
                    // InternalDbdTextEditor.g:669:2: ( ( 'serialPRTY_Even' ) )
                    // InternalDbdTextEditor.g:670:3: ( 'serialPRTY_Even' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialPRTY_EvenEnumLiteralDeclaration_2()); 
                    // InternalDbdTextEditor.g:671:3: ( 'serialPRTY_Even' )
                    // InternalDbdTextEditor.g:671:4: 'serialPRTY_Even'
                    {
                    match(input,67,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialPRTY_EvenEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDbdTextEditor.g:675:2: ( ( 'serialPRTY_Odd' ) )
                    {
                    // InternalDbdTextEditor.g:675:2: ( ( 'serialPRTY_Odd' ) )
                    // InternalDbdTextEditor.g:676:3: ( 'serialPRTY_Odd' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialPRTY_OddEnumLiteralDeclaration_3()); 
                    // InternalDbdTextEditor.g:677:3: ( 'serialPRTY_Odd' )
                    // InternalDbdTextEditor.g:677:4: 'serialPRTY_Odd'
                    {
                    match(input,68,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialPRTY_OddEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDbdTextEditor.g:681:2: ( ( 'waveformPOST_Always' ) )
                    {
                    // InternalDbdTextEditor.g:681:2: ( ( 'waveformPOST_Always' ) )
                    // InternalDbdTextEditor.g:682:3: ( 'waveformPOST_Always' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getWaveformPOST_AlwaysEnumLiteralDeclaration_4()); 
                    // InternalDbdTextEditor.g:683:3: ( 'waveformPOST_Always' )
                    // InternalDbdTextEditor.g:683:4: 'waveformPOST_Always'
                    {
                    match(input,69,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getWaveformPOST_AlwaysEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDbdTextEditor.g:687:2: ( ( 'waveformPOST_OnChange' ) )
                    {
                    // InternalDbdTextEditor.g:687:2: ( ( 'waveformPOST_OnChange' ) )
                    // InternalDbdTextEditor.g:688:3: ( 'waveformPOST_OnChange' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getWaveformPOST_OnChangeEnumLiteralDeclaration_5()); 
                    // InternalDbdTextEditor.g:689:3: ( 'waveformPOST_OnChange' )
                    // InternalDbdTextEditor.g:689:4: 'waveformPOST_OnChange'
                    {
                    match(input,70,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getWaveformPOST_OnChangeEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDbdTextEditor.g:693:2: ( ( 'aaoPOST_Always' ) )
                    {
                    // InternalDbdTextEditor.g:693:2: ( ( 'aaoPOST_Always' ) )
                    // InternalDbdTextEditor.g:694:3: ( 'aaoPOST_Always' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAaoPOST_AlwaysEnumLiteralDeclaration_6()); 
                    // InternalDbdTextEditor.g:695:3: ( 'aaoPOST_Always' )
                    // InternalDbdTextEditor.g:695:4: 'aaoPOST_Always'
                    {
                    match(input,71,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAaoPOST_AlwaysEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDbdTextEditor.g:699:2: ( ( 'aaoPOST_OnChange' ) )
                    {
                    // InternalDbdTextEditor.g:699:2: ( ( 'aaoPOST_OnChange' ) )
                    // InternalDbdTextEditor.g:700:3: ( 'aaoPOST_OnChange' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAaoPOST_OnChangeEnumLiteralDeclaration_7()); 
                    // InternalDbdTextEditor.g:701:3: ( 'aaoPOST_OnChange' )
                    // InternalDbdTextEditor.g:701:4: 'aaoPOST_OnChange'
                    {
                    match(input,72,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAaoPOST_OnChangeEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDbdTextEditor.g:705:2: ( ( 'menuPriorityLOW' ) )
                    {
                    // InternalDbdTextEditor.g:705:2: ( ( 'menuPriorityLOW' ) )
                    // InternalDbdTextEditor.g:706:3: ( 'menuPriorityLOW' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuPriorityLOWEnumLiteralDeclaration_8()); 
                    // InternalDbdTextEditor.g:707:3: ( 'menuPriorityLOW' )
                    // InternalDbdTextEditor.g:707:4: 'menuPriorityLOW'
                    {
                    match(input,73,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuPriorityLOWEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDbdTextEditor.g:711:2: ( ( 'menuPriorityMEDIUM' ) )
                    {
                    // InternalDbdTextEditor.g:711:2: ( ( 'menuPriorityMEDIUM' ) )
                    // InternalDbdTextEditor.g:712:3: ( 'menuPriorityMEDIUM' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuPriorityMEDIUMEnumLiteralDeclaration_9()); 
                    // InternalDbdTextEditor.g:713:3: ( 'menuPriorityMEDIUM' )
                    // InternalDbdTextEditor.g:713:4: 'menuPriorityMEDIUM'
                    {
                    match(input,74,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuPriorityMEDIUMEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalDbdTextEditor.g:717:2: ( ( 'menuPriorityHIGH' ) )
                    {
                    // InternalDbdTextEditor.g:717:2: ( ( 'menuPriorityHIGH' ) )
                    // InternalDbdTextEditor.g:718:3: ( 'menuPriorityHIGH' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuPriorityHIGHEnumLiteralDeclaration_10()); 
                    // InternalDbdTextEditor.g:719:3: ( 'menuPriorityHIGH' )
                    // InternalDbdTextEditor.g:719:4: 'menuPriorityHIGH'
                    {
                    match(input,75,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuPriorityHIGHEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalDbdTextEditor.g:723:2: ( ( 'serialSBIT_unknown' ) )
                    {
                    // InternalDbdTextEditor.g:723:2: ( ( 'serialSBIT_unknown' ) )
                    // InternalDbdTextEditor.g:724:3: ( 'serialSBIT_unknown' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialSBIT_unknownEnumLiteralDeclaration_11()); 
                    // InternalDbdTextEditor.g:725:3: ( 'serialSBIT_unknown' )
                    // InternalDbdTextEditor.g:725:4: 'serialSBIT_unknown'
                    {
                    match(input,76,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialSBIT_unknownEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalDbdTextEditor.g:729:2: ( ( 'serialSBIT_1' ) )
                    {
                    // InternalDbdTextEditor.g:729:2: ( ( 'serialSBIT_1' ) )
                    // InternalDbdTextEditor.g:730:3: ( 'serialSBIT_1' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialSBIT_1EnumLiteralDeclaration_12()); 
                    // InternalDbdTextEditor.g:731:3: ( 'serialSBIT_1' )
                    // InternalDbdTextEditor.g:731:4: 'serialSBIT_1'
                    {
                    match(input,77,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialSBIT_1EnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalDbdTextEditor.g:735:2: ( ( 'serialSBIT_2' ) )
                    {
                    // InternalDbdTextEditor.g:735:2: ( ( 'serialSBIT_2' ) )
                    // InternalDbdTextEditor.g:736:3: ( 'serialSBIT_2' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialSBIT_2EnumLiteralDeclaration_13()); 
                    // InternalDbdTextEditor.g:737:3: ( 'serialSBIT_2' )
                    // InternalDbdTextEditor.g:737:4: 'serialSBIT_2'
                    {
                    match(input,78,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialSBIT_2EnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalDbdTextEditor.g:741:2: ( ( 'calcoutDOPT_Use_VAL' ) )
                    {
                    // InternalDbdTextEditor.g:741:2: ( ( 'calcoutDOPT_Use_VAL' ) )
                    // InternalDbdTextEditor.g:742:3: ( 'calcoutDOPT_Use_VAL' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getCalcoutDOPT_Use_VALEnumLiteralDeclaration_14()); 
                    // InternalDbdTextEditor.g:743:3: ( 'calcoutDOPT_Use_VAL' )
                    // InternalDbdTextEditor.g:743:4: 'calcoutDOPT_Use_VAL'
                    {
                    match(input,79,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getCalcoutDOPT_Use_VALEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalDbdTextEditor.g:747:2: ( ( 'calcoutDOPT_Use_OVAL' ) )
                    {
                    // InternalDbdTextEditor.g:747:2: ( ( 'calcoutDOPT_Use_OVAL' ) )
                    // InternalDbdTextEditor.g:748:3: ( 'calcoutDOPT_Use_OVAL' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getCalcoutDOPT_Use_OVALEnumLiteralDeclaration_15()); 
                    // InternalDbdTextEditor.g:749:3: ( 'calcoutDOPT_Use_OVAL' )
                    // InternalDbdTextEditor.g:749:4: 'calcoutDOPT_Use_OVAL'
                    {
                    match(input,80,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getCalcoutDOPT_Use_OVALEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalDbdTextEditor.g:753:2: ( ( 'menuOmslsupervisory' ) )
                    {
                    // InternalDbdTextEditor.g:753:2: ( ( 'menuOmslsupervisory' ) )
                    // InternalDbdTextEditor.g:754:3: ( 'menuOmslsupervisory' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuOmslsupervisoryEnumLiteralDeclaration_16()); 
                    // InternalDbdTextEditor.g:755:3: ( 'menuOmslsupervisory' )
                    // InternalDbdTextEditor.g:755:4: 'menuOmslsupervisory'
                    {
                    match(input,81,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuOmslsupervisoryEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalDbdTextEditor.g:759:2: ( ( 'menuOmslclosed_loop' ) )
                    {
                    // InternalDbdTextEditor.g:759:2: ( ( 'menuOmslclosed_loop' ) )
                    // InternalDbdTextEditor.g:760:3: ( 'menuOmslclosed_loop' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuOmslclosed_loopEnumLiteralDeclaration_17()); 
                    // InternalDbdTextEditor.g:761:3: ( 'menuOmslclosed_loop' )
                    // InternalDbdTextEditor.g:761:4: 'menuOmslclosed_loop'
                    {
                    match(input,82,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuOmslclosed_loopEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalDbdTextEditor.g:765:2: ( ( 'menuFtypeSTRING' ) )
                    {
                    // InternalDbdTextEditor.g:765:2: ( ( 'menuFtypeSTRING' ) )
                    // InternalDbdTextEditor.g:766:3: ( 'menuFtypeSTRING' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuFtypeSTRINGEnumLiteralDeclaration_18()); 
                    // InternalDbdTextEditor.g:767:3: ( 'menuFtypeSTRING' )
                    // InternalDbdTextEditor.g:767:4: 'menuFtypeSTRING'
                    {
                    match(input,83,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuFtypeSTRINGEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalDbdTextEditor.g:771:2: ( ( 'menuFtypeCHAR' ) )
                    {
                    // InternalDbdTextEditor.g:771:2: ( ( 'menuFtypeCHAR' ) )
                    // InternalDbdTextEditor.g:772:3: ( 'menuFtypeCHAR' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuFtypeCHAREnumLiteralDeclaration_19()); 
                    // InternalDbdTextEditor.g:773:3: ( 'menuFtypeCHAR' )
                    // InternalDbdTextEditor.g:773:4: 'menuFtypeCHAR'
                    {
                    match(input,84,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuFtypeCHAREnumLiteralDeclaration_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalDbdTextEditor.g:777:2: ( ( 'menuFtypeUCHAR' ) )
                    {
                    // InternalDbdTextEditor.g:777:2: ( ( 'menuFtypeUCHAR' ) )
                    // InternalDbdTextEditor.g:778:3: ( 'menuFtypeUCHAR' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuFtypeUCHAREnumLiteralDeclaration_20()); 
                    // InternalDbdTextEditor.g:779:3: ( 'menuFtypeUCHAR' )
                    // InternalDbdTextEditor.g:779:4: 'menuFtypeUCHAR'
                    {
                    match(input,85,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuFtypeUCHAREnumLiteralDeclaration_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalDbdTextEditor.g:783:2: ( ( 'menuFtypeSHORT' ) )
                    {
                    // InternalDbdTextEditor.g:783:2: ( ( 'menuFtypeSHORT' ) )
                    // InternalDbdTextEditor.g:784:3: ( 'menuFtypeSHORT' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuFtypeSHORTEnumLiteralDeclaration_21()); 
                    // InternalDbdTextEditor.g:785:3: ( 'menuFtypeSHORT' )
                    // InternalDbdTextEditor.g:785:4: 'menuFtypeSHORT'
                    {
                    match(input,86,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuFtypeSHORTEnumLiteralDeclaration_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalDbdTextEditor.g:789:2: ( ( 'menuFtypeUSHORT' ) )
                    {
                    // InternalDbdTextEditor.g:789:2: ( ( 'menuFtypeUSHORT' ) )
                    // InternalDbdTextEditor.g:790:3: ( 'menuFtypeUSHORT' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuFtypeUSHORTEnumLiteralDeclaration_22()); 
                    // InternalDbdTextEditor.g:791:3: ( 'menuFtypeUSHORT' )
                    // InternalDbdTextEditor.g:791:4: 'menuFtypeUSHORT'
                    {
                    match(input,87,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuFtypeUSHORTEnumLiteralDeclaration_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalDbdTextEditor.g:795:2: ( ( 'menuFtypeLONG' ) )
                    {
                    // InternalDbdTextEditor.g:795:2: ( ( 'menuFtypeLONG' ) )
                    // InternalDbdTextEditor.g:796:3: ( 'menuFtypeLONG' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuFtypeLONGEnumLiteralDeclaration_23()); 
                    // InternalDbdTextEditor.g:797:3: ( 'menuFtypeLONG' )
                    // InternalDbdTextEditor.g:797:4: 'menuFtypeLONG'
                    {
                    match(input,88,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuFtypeLONGEnumLiteralDeclaration_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalDbdTextEditor.g:801:2: ( ( 'menuFtypeULONG' ) )
                    {
                    // InternalDbdTextEditor.g:801:2: ( ( 'menuFtypeULONG' ) )
                    // InternalDbdTextEditor.g:802:3: ( 'menuFtypeULONG' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuFtypeULONGEnumLiteralDeclaration_24()); 
                    // InternalDbdTextEditor.g:803:3: ( 'menuFtypeULONG' )
                    // InternalDbdTextEditor.g:803:4: 'menuFtypeULONG'
                    {
                    match(input,89,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuFtypeULONGEnumLiteralDeclaration_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalDbdTextEditor.g:807:2: ( ( 'menuFtypeINT64' ) )
                    {
                    // InternalDbdTextEditor.g:807:2: ( ( 'menuFtypeINT64' ) )
                    // InternalDbdTextEditor.g:808:3: ( 'menuFtypeINT64' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuFtypeINT64EnumLiteralDeclaration_25()); 
                    // InternalDbdTextEditor.g:809:3: ( 'menuFtypeINT64' )
                    // InternalDbdTextEditor.g:809:4: 'menuFtypeINT64'
                    {
                    match(input,90,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuFtypeINT64EnumLiteralDeclaration_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalDbdTextEditor.g:813:2: ( ( 'menuFtypeUINT64' ) )
                    {
                    // InternalDbdTextEditor.g:813:2: ( ( 'menuFtypeUINT64' ) )
                    // InternalDbdTextEditor.g:814:3: ( 'menuFtypeUINT64' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuFtypeUINT64EnumLiteralDeclaration_26()); 
                    // InternalDbdTextEditor.g:815:3: ( 'menuFtypeUINT64' )
                    // InternalDbdTextEditor.g:815:4: 'menuFtypeUINT64'
                    {
                    match(input,91,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuFtypeUINT64EnumLiteralDeclaration_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalDbdTextEditor.g:819:2: ( ( 'menuFtypeFLOAT' ) )
                    {
                    // InternalDbdTextEditor.g:819:2: ( ( 'menuFtypeFLOAT' ) )
                    // InternalDbdTextEditor.g:820:3: ( 'menuFtypeFLOAT' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuFtypeFLOATEnumLiteralDeclaration_27()); 
                    // InternalDbdTextEditor.g:821:3: ( 'menuFtypeFLOAT' )
                    // InternalDbdTextEditor.g:821:4: 'menuFtypeFLOAT'
                    {
                    match(input,92,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuFtypeFLOATEnumLiteralDeclaration_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalDbdTextEditor.g:825:2: ( ( 'menuFtypeDOUBLE' ) )
                    {
                    // InternalDbdTextEditor.g:825:2: ( ( 'menuFtypeDOUBLE' ) )
                    // InternalDbdTextEditor.g:826:3: ( 'menuFtypeDOUBLE' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuFtypeDOUBLEEnumLiteralDeclaration_28()); 
                    // InternalDbdTextEditor.g:827:3: ( 'menuFtypeDOUBLE' )
                    // InternalDbdTextEditor.g:827:4: 'menuFtypeDOUBLE'
                    {
                    match(input,93,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuFtypeDOUBLEEnumLiteralDeclaration_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalDbdTextEditor.g:831:2: ( ( 'menuFtypeENUM' ) )
                    {
                    // InternalDbdTextEditor.g:831:2: ( ( 'menuFtypeENUM' ) )
                    // InternalDbdTextEditor.g:832:3: ( 'menuFtypeENUM' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuFtypeENUMEnumLiteralDeclaration_29()); 
                    // InternalDbdTextEditor.g:833:3: ( 'menuFtypeENUM' )
                    // InternalDbdTextEditor.g:833:4: 'menuFtypeENUM'
                    {
                    match(input,94,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuFtypeENUMEnumLiteralDeclaration_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalDbdTextEditor.g:837:2: ( ( 'stringinPOST_OnChange' ) )
                    {
                    // InternalDbdTextEditor.g:837:2: ( ( 'stringinPOST_OnChange' ) )
                    // InternalDbdTextEditor.g:838:3: ( 'stringinPOST_OnChange' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getStringinPOST_OnChangeEnumLiteralDeclaration_30()); 
                    // InternalDbdTextEditor.g:839:3: ( 'stringinPOST_OnChange' )
                    // InternalDbdTextEditor.g:839:4: 'stringinPOST_OnChange'
                    {
                    match(input,95,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getStringinPOST_OnChangeEnumLiteralDeclaration_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalDbdTextEditor.g:843:2: ( ( 'stringinPOST_Always' ) )
                    {
                    // InternalDbdTextEditor.g:843:2: ( ( 'stringinPOST_Always' ) )
                    // InternalDbdTextEditor.g:844:3: ( 'stringinPOST_Always' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getStringinPOST_AlwaysEnumLiteralDeclaration_31()); 
                    // InternalDbdTextEditor.g:845:3: ( 'stringinPOST_Always' )
                    // InternalDbdTextEditor.g:845:4: 'stringinPOST_Always'
                    {
                    match(input,96,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getStringinPOST_AlwaysEnumLiteralDeclaration_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalDbdTextEditor.g:849:2: ( ( 'menuPiniNO' ) )
                    {
                    // InternalDbdTextEditor.g:849:2: ( ( 'menuPiniNO' ) )
                    // InternalDbdTextEditor.g:850:3: ( 'menuPiniNO' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuPiniNOEnumLiteralDeclaration_32()); 
                    // InternalDbdTextEditor.g:851:3: ( 'menuPiniNO' )
                    // InternalDbdTextEditor.g:851:4: 'menuPiniNO'
                    {
                    match(input,97,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuPiniNOEnumLiteralDeclaration_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalDbdTextEditor.g:855:2: ( ( 'menuPiniYES' ) )
                    {
                    // InternalDbdTextEditor.g:855:2: ( ( 'menuPiniYES' ) )
                    // InternalDbdTextEditor.g:856:3: ( 'menuPiniYES' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuPiniYESEnumLiteralDeclaration_33()); 
                    // InternalDbdTextEditor.g:857:3: ( 'menuPiniYES' )
                    // InternalDbdTextEditor.g:857:4: 'menuPiniYES'
                    {
                    match(input,98,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuPiniYESEnumLiteralDeclaration_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalDbdTextEditor.g:861:2: ( ( 'menuPiniRUN' ) )
                    {
                    // InternalDbdTextEditor.g:861:2: ( ( 'menuPiniRUN' ) )
                    // InternalDbdTextEditor.g:862:3: ( 'menuPiniRUN' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuPiniRUNEnumLiteralDeclaration_34()); 
                    // InternalDbdTextEditor.g:863:3: ( 'menuPiniRUN' )
                    // InternalDbdTextEditor.g:863:4: 'menuPiniRUN'
                    {
                    match(input,99,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuPiniRUNEnumLiteralDeclaration_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalDbdTextEditor.g:867:2: ( ( 'menuPiniRUNNING' ) )
                    {
                    // InternalDbdTextEditor.g:867:2: ( ( 'menuPiniRUNNING' ) )
                    // InternalDbdTextEditor.g:868:3: ( 'menuPiniRUNNING' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuPiniRUNNINGEnumLiteralDeclaration_35()); 
                    // InternalDbdTextEditor.g:869:3: ( 'menuPiniRUNNING' )
                    // InternalDbdTextEditor.g:869:4: 'menuPiniRUNNING'
                    {
                    match(input,100,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuPiniRUNNINGEnumLiteralDeclaration_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalDbdTextEditor.g:873:2: ( ( 'menuPiniPAUSE' ) )
                    {
                    // InternalDbdTextEditor.g:873:2: ( ( 'menuPiniPAUSE' ) )
                    // InternalDbdTextEditor.g:874:3: ( 'menuPiniPAUSE' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuPiniPAUSEEnumLiteralDeclaration_36()); 
                    // InternalDbdTextEditor.g:875:3: ( 'menuPiniPAUSE' )
                    // InternalDbdTextEditor.g:875:4: 'menuPiniPAUSE'
                    {
                    match(input,101,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuPiniPAUSEEnumLiteralDeclaration_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalDbdTextEditor.g:879:2: ( ( 'menuPiniPAUSED' ) )
                    {
                    // InternalDbdTextEditor.g:879:2: ( ( 'menuPiniPAUSED' ) )
                    // InternalDbdTextEditor.g:880:3: ( 'menuPiniPAUSED' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuPiniPAUSEDEnumLiteralDeclaration_37()); 
                    // InternalDbdTextEditor.g:881:3: ( 'menuPiniPAUSED' )
                    // InternalDbdTextEditor.g:881:4: 'menuPiniPAUSED'
                    {
                    match(input,102,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuPiniPAUSEDEnumLiteralDeclaration_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalDbdTextEditor.g:885:2: ( ( 'dfanoutSELM_All' ) )
                    {
                    // InternalDbdTextEditor.g:885:2: ( ( 'dfanoutSELM_All' ) )
                    // InternalDbdTextEditor.g:886:3: ( 'dfanoutSELM_All' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getDfanoutSELM_AllEnumLiteralDeclaration_38()); 
                    // InternalDbdTextEditor.g:887:3: ( 'dfanoutSELM_All' )
                    // InternalDbdTextEditor.g:887:4: 'dfanoutSELM_All'
                    {
                    match(input,103,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getDfanoutSELM_AllEnumLiteralDeclaration_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalDbdTextEditor.g:891:2: ( ( 'dfanoutSELM_Specified' ) )
                    {
                    // InternalDbdTextEditor.g:891:2: ( ( 'dfanoutSELM_Specified' ) )
                    // InternalDbdTextEditor.g:892:3: ( 'dfanoutSELM_Specified' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getDfanoutSELM_SpecifiedEnumLiteralDeclaration_39()); 
                    // InternalDbdTextEditor.g:893:3: ( 'dfanoutSELM_Specified' )
                    // InternalDbdTextEditor.g:893:4: 'dfanoutSELM_Specified'
                    {
                    match(input,104,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getDfanoutSELM_SpecifiedEnumLiteralDeclaration_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalDbdTextEditor.g:897:2: ( ( 'dfanoutSELM_Mask' ) )
                    {
                    // InternalDbdTextEditor.g:897:2: ( ( 'dfanoutSELM_Mask' ) )
                    // InternalDbdTextEditor.g:898:3: ( 'dfanoutSELM_Mask' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getDfanoutSELM_MaskEnumLiteralDeclaration_40()); 
                    // InternalDbdTextEditor.g:899:3: ( 'dfanoutSELM_Mask' )
                    // InternalDbdTextEditor.g:899:4: 'dfanoutSELM_Mask'
                    {
                    match(input,105,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getDfanoutSELM_MaskEnumLiteralDeclaration_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalDbdTextEditor.g:903:2: ( ( 'menuScanPassive' ) )
                    {
                    // InternalDbdTextEditor.g:903:2: ( ( 'menuScanPassive' ) )
                    // InternalDbdTextEditor.g:904:3: ( 'menuScanPassive' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuScanPassiveEnumLiteralDeclaration_41()); 
                    // InternalDbdTextEditor.g:905:3: ( 'menuScanPassive' )
                    // InternalDbdTextEditor.g:905:4: 'menuScanPassive'
                    {
                    match(input,106,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuScanPassiveEnumLiteralDeclaration_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalDbdTextEditor.g:909:2: ( ( 'menuScanEvent' ) )
                    {
                    // InternalDbdTextEditor.g:909:2: ( ( 'menuScanEvent' ) )
                    // InternalDbdTextEditor.g:910:3: ( 'menuScanEvent' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuScanEventEnumLiteralDeclaration_42()); 
                    // InternalDbdTextEditor.g:911:3: ( 'menuScanEvent' )
                    // InternalDbdTextEditor.g:911:4: 'menuScanEvent'
                    {
                    match(input,107,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuScanEventEnumLiteralDeclaration_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalDbdTextEditor.g:915:2: ( ( 'menuScanI_O_Intr' ) )
                    {
                    // InternalDbdTextEditor.g:915:2: ( ( 'menuScanI_O_Intr' ) )
                    // InternalDbdTextEditor.g:916:3: ( 'menuScanI_O_Intr' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuScanI_O_IntrEnumLiteralDeclaration_43()); 
                    // InternalDbdTextEditor.g:917:3: ( 'menuScanI_O_Intr' )
                    // InternalDbdTextEditor.g:917:4: 'menuScanI_O_Intr'
                    {
                    match(input,108,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuScanI_O_IntrEnumLiteralDeclaration_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalDbdTextEditor.g:921:2: ( ( 'menuScan10_second' ) )
                    {
                    // InternalDbdTextEditor.g:921:2: ( ( 'menuScan10_second' ) )
                    // InternalDbdTextEditor.g:922:3: ( 'menuScan10_second' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuScan10_secondEnumLiteralDeclaration_44()); 
                    // InternalDbdTextEditor.g:923:3: ( 'menuScan10_second' )
                    // InternalDbdTextEditor.g:923:4: 'menuScan10_second'
                    {
                    match(input,109,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuScan10_secondEnumLiteralDeclaration_44()); 

                    }


                    }
                    break;
                case 46 :
                    // InternalDbdTextEditor.g:927:2: ( ( 'menuScan5_second' ) )
                    {
                    // InternalDbdTextEditor.g:927:2: ( ( 'menuScan5_second' ) )
                    // InternalDbdTextEditor.g:928:3: ( 'menuScan5_second' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuScan5_secondEnumLiteralDeclaration_45()); 
                    // InternalDbdTextEditor.g:929:3: ( 'menuScan5_second' )
                    // InternalDbdTextEditor.g:929:4: 'menuScan5_second'
                    {
                    match(input,110,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuScan5_secondEnumLiteralDeclaration_45()); 

                    }


                    }
                    break;
                case 47 :
                    // InternalDbdTextEditor.g:933:2: ( ( 'menuScan2_second' ) )
                    {
                    // InternalDbdTextEditor.g:933:2: ( ( 'menuScan2_second' ) )
                    // InternalDbdTextEditor.g:934:3: ( 'menuScan2_second' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuScan2_secondEnumLiteralDeclaration_46()); 
                    // InternalDbdTextEditor.g:935:3: ( 'menuScan2_second' )
                    // InternalDbdTextEditor.g:935:4: 'menuScan2_second'
                    {
                    match(input,111,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuScan2_secondEnumLiteralDeclaration_46()); 

                    }


                    }
                    break;
                case 48 :
                    // InternalDbdTextEditor.g:939:2: ( ( 'menuScan1_second' ) )
                    {
                    // InternalDbdTextEditor.g:939:2: ( ( 'menuScan1_second' ) )
                    // InternalDbdTextEditor.g:940:3: ( 'menuScan1_second' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuScan1_secondEnumLiteralDeclaration_47()); 
                    // InternalDbdTextEditor.g:941:3: ( 'menuScan1_second' )
                    // InternalDbdTextEditor.g:941:4: 'menuScan1_second'
                    {
                    match(input,112,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuScan1_secondEnumLiteralDeclaration_47()); 

                    }


                    }
                    break;
                case 49 :
                    // InternalDbdTextEditor.g:945:2: ( ( 'menuScan_5_second' ) )
                    {
                    // InternalDbdTextEditor.g:945:2: ( ( 'menuScan_5_second' ) )
                    // InternalDbdTextEditor.g:946:3: ( 'menuScan_5_second' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuScan_5_secondEnumLiteralDeclaration_48()); 
                    // InternalDbdTextEditor.g:947:3: ( 'menuScan_5_second' )
                    // InternalDbdTextEditor.g:947:4: 'menuScan_5_second'
                    {
                    match(input,113,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuScan_5_secondEnumLiteralDeclaration_48()); 

                    }


                    }
                    break;
                case 50 :
                    // InternalDbdTextEditor.g:951:2: ( ( 'menuScan_2_second' ) )
                    {
                    // InternalDbdTextEditor.g:951:2: ( ( 'menuScan_2_second' ) )
                    // InternalDbdTextEditor.g:952:3: ( 'menuScan_2_second' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuScan_2_secondEnumLiteralDeclaration_49()); 
                    // InternalDbdTextEditor.g:953:3: ( 'menuScan_2_second' )
                    // InternalDbdTextEditor.g:953:4: 'menuScan_2_second'
                    {
                    match(input,114,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuScan_2_secondEnumLiteralDeclaration_49()); 

                    }


                    }
                    break;
                case 51 :
                    // InternalDbdTextEditor.g:957:2: ( ( 'menuScan_1_second' ) )
                    {
                    // InternalDbdTextEditor.g:957:2: ( ( 'menuScan_1_second' ) )
                    // InternalDbdTextEditor.g:958:3: ( 'menuScan_1_second' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuScan_1_secondEnumLiteralDeclaration_50()); 
                    // InternalDbdTextEditor.g:959:3: ( 'menuScan_1_second' )
                    // InternalDbdTextEditor.g:959:4: 'menuScan_1_second'
                    {
                    match(input,115,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuScan_1_secondEnumLiteralDeclaration_50()); 

                    }


                    }
                    break;
                case 52 :
                    // InternalDbdTextEditor.g:963:2: ( ( 'gpibACMD_None' ) )
                    {
                    // InternalDbdTextEditor.g:963:2: ( ( 'gpibACMD_None' ) )
                    // InternalDbdTextEditor.g:964:3: ( 'gpibACMD_None' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getGpibACMD_NoneEnumLiteralDeclaration_51()); 
                    // InternalDbdTextEditor.g:965:3: ( 'gpibACMD_None' )
                    // InternalDbdTextEditor.g:965:4: 'gpibACMD_None'
                    {
                    match(input,116,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getGpibACMD_NoneEnumLiteralDeclaration_51()); 

                    }


                    }
                    break;
                case 53 :
                    // InternalDbdTextEditor.g:969:2: ( ( 'gpibACMD_Group_Execute_Trig___GET_' ) )
                    {
                    // InternalDbdTextEditor.g:969:2: ( ( 'gpibACMD_Group_Execute_Trig___GET_' ) )
                    // InternalDbdTextEditor.g:970:3: ( 'gpibACMD_Group_Execute_Trig___GET_' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getGpibACMD_Group_Execute_Trig___GET_EnumLiteralDeclaration_52()); 
                    // InternalDbdTextEditor.g:971:3: ( 'gpibACMD_Group_Execute_Trig___GET_' )
                    // InternalDbdTextEditor.g:971:4: 'gpibACMD_Group_Execute_Trig___GET_'
                    {
                    match(input,117,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getGpibACMD_Group_Execute_Trig___GET_EnumLiteralDeclaration_52()); 

                    }


                    }
                    break;
                case 54 :
                    // InternalDbdTextEditor.g:975:2: ( ( 'gpibACMD_Go_To_Local__GTL_' ) )
                    {
                    // InternalDbdTextEditor.g:975:2: ( ( 'gpibACMD_Go_To_Local__GTL_' ) )
                    // InternalDbdTextEditor.g:976:3: ( 'gpibACMD_Go_To_Local__GTL_' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getGpibACMD_Go_To_Local__GTL_EnumLiteralDeclaration_53()); 
                    // InternalDbdTextEditor.g:977:3: ( 'gpibACMD_Go_To_Local__GTL_' )
                    // InternalDbdTextEditor.g:977:4: 'gpibACMD_Go_To_Local__GTL_'
                    {
                    match(input,118,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getGpibACMD_Go_To_Local__GTL_EnumLiteralDeclaration_53()); 

                    }


                    }
                    break;
                case 55 :
                    // InternalDbdTextEditor.g:981:2: ( ( 'gpibACMD_Selected_Dev__Clear__SDC_' ) )
                    {
                    // InternalDbdTextEditor.g:981:2: ( ( 'gpibACMD_Selected_Dev__Clear__SDC_' ) )
                    // InternalDbdTextEditor.g:982:3: ( 'gpibACMD_Selected_Dev__Clear__SDC_' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getGpibACMD_Selected_Dev__Clear__SDC_EnumLiteralDeclaration_54()); 
                    // InternalDbdTextEditor.g:983:3: ( 'gpibACMD_Selected_Dev__Clear__SDC_' )
                    // InternalDbdTextEditor.g:983:4: 'gpibACMD_Selected_Dev__Clear__SDC_'
                    {
                    match(input,119,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getGpibACMD_Selected_Dev__Clear__SDC_EnumLiteralDeclaration_54()); 

                    }


                    }
                    break;
                case 56 :
                    // InternalDbdTextEditor.g:987:2: ( ( 'gpibACMD_Take_Control__TCT_' ) )
                    {
                    // InternalDbdTextEditor.g:987:2: ( ( 'gpibACMD_Take_Control__TCT_' ) )
                    // InternalDbdTextEditor.g:988:3: ( 'gpibACMD_Take_Control__TCT_' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getGpibACMD_Take_Control__TCT_EnumLiteralDeclaration_55()); 
                    // InternalDbdTextEditor.g:989:3: ( 'gpibACMD_Take_Control__TCT_' )
                    // InternalDbdTextEditor.g:989:4: 'gpibACMD_Take_Control__TCT_'
                    {
                    match(input,120,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getGpibACMD_Take_Control__TCT_EnumLiteralDeclaration_55()); 

                    }


                    }
                    break;
                case 57 :
                    // InternalDbdTextEditor.g:993:2: ( ( 'gpibACMD_Serial_Poll' ) )
                    {
                    // InternalDbdTextEditor.g:993:2: ( ( 'gpibACMD_Serial_Poll' ) )
                    // InternalDbdTextEditor.g:994:3: ( 'gpibACMD_Serial_Poll' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getGpibACMD_Serial_PollEnumLiteralDeclaration_56()); 
                    // InternalDbdTextEditor.g:995:3: ( 'gpibACMD_Serial_Poll' )
                    // InternalDbdTextEditor.g:995:4: 'gpibACMD_Serial_Poll'
                    {
                    match(input,121,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getGpibACMD_Serial_PollEnumLiteralDeclaration_56()); 

                    }


                    }
                    break;
                case 58 :
                    // InternalDbdTextEditor.g:999:2: ( ( 'aSubLFLG_IGNORE' ) )
                    {
                    // InternalDbdTextEditor.g:999:2: ( ( 'aSubLFLG_IGNORE' ) )
                    // InternalDbdTextEditor.g:1000:3: ( 'aSubLFLG_IGNORE' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getASubLFLG_IGNOREEnumLiteralDeclaration_57()); 
                    // InternalDbdTextEditor.g:1001:3: ( 'aSubLFLG_IGNORE' )
                    // InternalDbdTextEditor.g:1001:4: 'aSubLFLG_IGNORE'
                    {
                    match(input,122,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getASubLFLG_IGNOREEnumLiteralDeclaration_57()); 

                    }


                    }
                    break;
                case 59 :
                    // InternalDbdTextEditor.g:1005:2: ( ( 'aSubLFLG_READ' ) )
                    {
                    // InternalDbdTextEditor.g:1005:2: ( ( 'aSubLFLG_READ' ) )
                    // InternalDbdTextEditor.g:1006:3: ( 'aSubLFLG_READ' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getASubLFLG_READEnumLiteralDeclaration_58()); 
                    // InternalDbdTextEditor.g:1007:3: ( 'aSubLFLG_READ' )
                    // InternalDbdTextEditor.g:1007:4: 'aSubLFLG_READ'
                    {
                    match(input,123,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getASubLFLG_READEnumLiteralDeclaration_58()); 

                    }


                    }
                    break;
                case 60 :
                    // InternalDbdTextEditor.g:1011:2: ( ( 'asynTMOD_Write_Read' ) )
                    {
                    // InternalDbdTextEditor.g:1011:2: ( ( 'asynTMOD_Write_Read' ) )
                    // InternalDbdTextEditor.g:1012:3: ( 'asynTMOD_Write_Read' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynTMOD_Write_ReadEnumLiteralDeclaration_59()); 
                    // InternalDbdTextEditor.g:1013:3: ( 'asynTMOD_Write_Read' )
                    // InternalDbdTextEditor.g:1013:4: 'asynTMOD_Write_Read'
                    {
                    match(input,124,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynTMOD_Write_ReadEnumLiteralDeclaration_59()); 

                    }


                    }
                    break;
                case 61 :
                    // InternalDbdTextEditor.g:1017:2: ( ( 'asynTMOD_Write' ) )
                    {
                    // InternalDbdTextEditor.g:1017:2: ( ( 'asynTMOD_Write' ) )
                    // InternalDbdTextEditor.g:1018:3: ( 'asynTMOD_Write' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynTMOD_WriteEnumLiteralDeclaration_60()); 
                    // InternalDbdTextEditor.g:1019:3: ( 'asynTMOD_Write' )
                    // InternalDbdTextEditor.g:1019:4: 'asynTMOD_Write'
                    {
                    match(input,125,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynTMOD_WriteEnumLiteralDeclaration_60()); 

                    }


                    }
                    break;
                case 62 :
                    // InternalDbdTextEditor.g:1023:2: ( ( 'asynTMOD_Read' ) )
                    {
                    // InternalDbdTextEditor.g:1023:2: ( ( 'asynTMOD_Read' ) )
                    // InternalDbdTextEditor.g:1024:3: ( 'asynTMOD_Read' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynTMOD_ReadEnumLiteralDeclaration_61()); 
                    // InternalDbdTextEditor.g:1025:3: ( 'asynTMOD_Read' )
                    // InternalDbdTextEditor.g:1025:4: 'asynTMOD_Read'
                    {
                    match(input,126,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynTMOD_ReadEnumLiteralDeclaration_61()); 

                    }


                    }
                    break;
                case 63 :
                    // InternalDbdTextEditor.g:1029:2: ( ( 'asynTMOD_Flush' ) )
                    {
                    // InternalDbdTextEditor.g:1029:2: ( ( 'asynTMOD_Flush' ) )
                    // InternalDbdTextEditor.g:1030:3: ( 'asynTMOD_Flush' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynTMOD_FlushEnumLiteralDeclaration_62()); 
                    // InternalDbdTextEditor.g:1031:3: ( 'asynTMOD_Flush' )
                    // InternalDbdTextEditor.g:1031:4: 'asynTMOD_Flush'
                    {
                    match(input,127,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynTMOD_FlushEnumLiteralDeclaration_62()); 

                    }


                    }
                    break;
                case 64 :
                    // InternalDbdTextEditor.g:1035:2: ( ( 'asynTMOD_NoIO' ) )
                    {
                    // InternalDbdTextEditor.g:1035:2: ( ( 'asynTMOD_NoIO' ) )
                    // InternalDbdTextEditor.g:1036:3: ( 'asynTMOD_NoIO' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynTMOD_NoIOEnumLiteralDeclaration_63()); 
                    // InternalDbdTextEditor.g:1037:3: ( 'asynTMOD_NoIO' )
                    // InternalDbdTextEditor.g:1037:4: 'asynTMOD_NoIO'
                    {
                    match(input,128,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynTMOD_NoIOEnumLiteralDeclaration_63()); 

                    }


                    }
                    break;
                case 65 :
                    // InternalDbdTextEditor.g:1041:2: ( ( 'ipDRTO_unknown' ) )
                    {
                    // InternalDbdTextEditor.g:1041:2: ( ( 'ipDRTO_unknown' ) )
                    // InternalDbdTextEditor.g:1042:3: ( 'ipDRTO_unknown' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getIpDRTO_unknownEnumLiteralDeclaration_64()); 
                    // InternalDbdTextEditor.g:1043:3: ( 'ipDRTO_unknown' )
                    // InternalDbdTextEditor.g:1043:4: 'ipDRTO_unknown'
                    {
                    match(input,129,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getIpDRTO_unknownEnumLiteralDeclaration_64()); 

                    }


                    }
                    break;
                case 66 :
                    // InternalDbdTextEditor.g:1047:2: ( ( 'ipDRTO_No' ) )
                    {
                    // InternalDbdTextEditor.g:1047:2: ( ( 'ipDRTO_No' ) )
                    // InternalDbdTextEditor.g:1048:3: ( 'ipDRTO_No' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getIpDRTO_NoEnumLiteralDeclaration_65()); 
                    // InternalDbdTextEditor.g:1049:3: ( 'ipDRTO_No' )
                    // InternalDbdTextEditor.g:1049:4: 'ipDRTO_No'
                    {
                    match(input,130,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getIpDRTO_NoEnumLiteralDeclaration_65()); 

                    }


                    }
                    break;
                case 67 :
                    // InternalDbdTextEditor.g:1053:2: ( ( 'ipDRTO_Yes' ) )
                    {
                    // InternalDbdTextEditor.g:1053:2: ( ( 'ipDRTO_Yes' ) )
                    // InternalDbdTextEditor.g:1054:3: ( 'ipDRTO_Yes' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getIpDRTO_YesEnumLiteralDeclaration_66()); 
                    // InternalDbdTextEditor.g:1055:3: ( 'ipDRTO_Yes' )
                    // InternalDbdTextEditor.g:1055:4: 'ipDRTO_Yes'
                    {
                    match(input,131,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getIpDRTO_YesEnumLiteralDeclaration_66()); 

                    }


                    }
                    break;
                case 68 :
                    // InternalDbdTextEditor.g:1059:2: ( ( 'scalerD1_Up' ) )
                    {
                    // InternalDbdTextEditor.g:1059:2: ( ( 'scalerD1_Up' ) )
                    // InternalDbdTextEditor.g:1060:3: ( 'scalerD1_Up' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getScalerD1_UpEnumLiteralDeclaration_67()); 
                    // InternalDbdTextEditor.g:1061:3: ( 'scalerD1_Up' )
                    // InternalDbdTextEditor.g:1061:4: 'scalerD1_Up'
                    {
                    match(input,132,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getScalerD1_UpEnumLiteralDeclaration_67()); 

                    }


                    }
                    break;
                case 69 :
                    // InternalDbdTextEditor.g:1065:2: ( ( 'scalerD1_Dn' ) )
                    {
                    // InternalDbdTextEditor.g:1065:2: ( ( 'scalerD1_Dn' ) )
                    // InternalDbdTextEditor.g:1066:3: ( 'scalerD1_Dn' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getScalerD1_DnEnumLiteralDeclaration_68()); 
                    // InternalDbdTextEditor.g:1067:3: ( 'scalerD1_Dn' )
                    // InternalDbdTextEditor.g:1067:4: 'scalerD1_Dn'
                    {
                    match(input,133,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getScalerD1_DnEnumLiteralDeclaration_68()); 

                    }


                    }
                    break;
                case 70 :
                    // InternalDbdTextEditor.g:1071:2: ( ( 'menuPost_OnChange' ) )
                    {
                    // InternalDbdTextEditor.g:1071:2: ( ( 'menuPost_OnChange' ) )
                    // InternalDbdTextEditor.g:1072:3: ( 'menuPost_OnChange' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuPost_OnChangeEnumLiteralDeclaration_69()); 
                    // InternalDbdTextEditor.g:1073:3: ( 'menuPost_OnChange' )
                    // InternalDbdTextEditor.g:1073:4: 'menuPost_OnChange'
                    {
                    match(input,134,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuPost_OnChangeEnumLiteralDeclaration_69()); 

                    }


                    }
                    break;
                case 71 :
                    // InternalDbdTextEditor.g:1077:2: ( ( 'menuPost_Always' ) )
                    {
                    // InternalDbdTextEditor.g:1077:2: ( ( 'menuPost_Always' ) )
                    // InternalDbdTextEditor.g:1078:3: ( 'menuPost_Always' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuPost_AlwaysEnumLiteralDeclaration_70()); 
                    // InternalDbdTextEditor.g:1079:3: ( 'menuPost_Always' )
                    // InternalDbdTextEditor.g:1079:4: 'menuPost_Always'
                    {
                    match(input,135,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuPost_AlwaysEnumLiteralDeclaration_70()); 

                    }


                    }
                    break;
                case 72 :
                    // InternalDbdTextEditor.g:1083:2: ( ( 'asynINTERFACE_OCTET' ) )
                    {
                    // InternalDbdTextEditor.g:1083:2: ( ( 'asynINTERFACE_OCTET' ) )
                    // InternalDbdTextEditor.g:1084:3: ( 'asynINTERFACE_OCTET' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynINTERFACE_OCTETEnumLiteralDeclaration_71()); 
                    // InternalDbdTextEditor.g:1085:3: ( 'asynINTERFACE_OCTET' )
                    // InternalDbdTextEditor.g:1085:4: 'asynINTERFACE_OCTET'
                    {
                    match(input,136,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynINTERFACE_OCTETEnumLiteralDeclaration_71()); 

                    }


                    }
                    break;
                case 73 :
                    // InternalDbdTextEditor.g:1089:2: ( ( 'asynINTERFACE_INT32' ) )
                    {
                    // InternalDbdTextEditor.g:1089:2: ( ( 'asynINTERFACE_INT32' ) )
                    // InternalDbdTextEditor.g:1090:3: ( 'asynINTERFACE_INT32' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynINTERFACE_INT32EnumLiteralDeclaration_72()); 
                    // InternalDbdTextEditor.g:1091:3: ( 'asynINTERFACE_INT32' )
                    // InternalDbdTextEditor.g:1091:4: 'asynINTERFACE_INT32'
                    {
                    match(input,137,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynINTERFACE_INT32EnumLiteralDeclaration_72()); 

                    }


                    }
                    break;
                case 74 :
                    // InternalDbdTextEditor.g:1095:2: ( ( 'asynINTERFACE_UINT32' ) )
                    {
                    // InternalDbdTextEditor.g:1095:2: ( ( 'asynINTERFACE_UINT32' ) )
                    // InternalDbdTextEditor.g:1096:3: ( 'asynINTERFACE_UINT32' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynINTERFACE_UINT32EnumLiteralDeclaration_73()); 
                    // InternalDbdTextEditor.g:1097:3: ( 'asynINTERFACE_UINT32' )
                    // InternalDbdTextEditor.g:1097:4: 'asynINTERFACE_UINT32'
                    {
                    match(input,138,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynINTERFACE_UINT32EnumLiteralDeclaration_73()); 

                    }


                    }
                    break;
                case 75 :
                    // InternalDbdTextEditor.g:1101:2: ( ( 'asynINTERFACE_FLOAT64' ) )
                    {
                    // InternalDbdTextEditor.g:1101:2: ( ( 'asynINTERFACE_FLOAT64' ) )
                    // InternalDbdTextEditor.g:1102:3: ( 'asynINTERFACE_FLOAT64' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynINTERFACE_FLOAT64EnumLiteralDeclaration_74()); 
                    // InternalDbdTextEditor.g:1103:3: ( 'asynINTERFACE_FLOAT64' )
                    // InternalDbdTextEditor.g:1103:4: 'asynINTERFACE_FLOAT64'
                    {
                    match(input,139,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynINTERFACE_FLOAT64EnumLiteralDeclaration_74()); 

                    }


                    }
                    break;
                case 76 :
                    // InternalDbdTextEditor.g:1107:2: ( ( 'menuAlarmStatNO_ALARM' ) )
                    {
                    // InternalDbdTextEditor.g:1107:2: ( ( 'menuAlarmStatNO_ALARM' ) )
                    // InternalDbdTextEditor.g:1108:3: ( 'menuAlarmStatNO_ALARM' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatNO_ALARMEnumLiteralDeclaration_75()); 
                    // InternalDbdTextEditor.g:1109:3: ( 'menuAlarmStatNO_ALARM' )
                    // InternalDbdTextEditor.g:1109:4: 'menuAlarmStatNO_ALARM'
                    {
                    match(input,140,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatNO_ALARMEnumLiteralDeclaration_75()); 

                    }


                    }
                    break;
                case 77 :
                    // InternalDbdTextEditor.g:1113:2: ( ( 'menuAlarmStatREAD' ) )
                    {
                    // InternalDbdTextEditor.g:1113:2: ( ( 'menuAlarmStatREAD' ) )
                    // InternalDbdTextEditor.g:1114:3: ( 'menuAlarmStatREAD' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatREADEnumLiteralDeclaration_76()); 
                    // InternalDbdTextEditor.g:1115:3: ( 'menuAlarmStatREAD' )
                    // InternalDbdTextEditor.g:1115:4: 'menuAlarmStatREAD'
                    {
                    match(input,141,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatREADEnumLiteralDeclaration_76()); 

                    }


                    }
                    break;
                case 78 :
                    // InternalDbdTextEditor.g:1119:2: ( ( 'menuAlarmStatWRITE' ) )
                    {
                    // InternalDbdTextEditor.g:1119:2: ( ( 'menuAlarmStatWRITE' ) )
                    // InternalDbdTextEditor.g:1120:3: ( 'menuAlarmStatWRITE' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatWRITEEnumLiteralDeclaration_77()); 
                    // InternalDbdTextEditor.g:1121:3: ( 'menuAlarmStatWRITE' )
                    // InternalDbdTextEditor.g:1121:4: 'menuAlarmStatWRITE'
                    {
                    match(input,142,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatWRITEEnumLiteralDeclaration_77()); 

                    }


                    }
                    break;
                case 79 :
                    // InternalDbdTextEditor.g:1125:2: ( ( 'menuAlarmStatHIHI' ) )
                    {
                    // InternalDbdTextEditor.g:1125:2: ( ( 'menuAlarmStatHIHI' ) )
                    // InternalDbdTextEditor.g:1126:3: ( 'menuAlarmStatHIHI' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatHIHIEnumLiteralDeclaration_78()); 
                    // InternalDbdTextEditor.g:1127:3: ( 'menuAlarmStatHIHI' )
                    // InternalDbdTextEditor.g:1127:4: 'menuAlarmStatHIHI'
                    {
                    match(input,143,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatHIHIEnumLiteralDeclaration_78()); 

                    }


                    }
                    break;
                case 80 :
                    // InternalDbdTextEditor.g:1131:2: ( ( 'menuAlarmStatHIGH' ) )
                    {
                    // InternalDbdTextEditor.g:1131:2: ( ( 'menuAlarmStatHIGH' ) )
                    // InternalDbdTextEditor.g:1132:3: ( 'menuAlarmStatHIGH' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatHIGHEnumLiteralDeclaration_79()); 
                    // InternalDbdTextEditor.g:1133:3: ( 'menuAlarmStatHIGH' )
                    // InternalDbdTextEditor.g:1133:4: 'menuAlarmStatHIGH'
                    {
                    match(input,144,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatHIGHEnumLiteralDeclaration_79()); 

                    }


                    }
                    break;
                case 81 :
                    // InternalDbdTextEditor.g:1137:2: ( ( 'menuAlarmStatLOLO' ) )
                    {
                    // InternalDbdTextEditor.g:1137:2: ( ( 'menuAlarmStatLOLO' ) )
                    // InternalDbdTextEditor.g:1138:3: ( 'menuAlarmStatLOLO' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatLOLOEnumLiteralDeclaration_80()); 
                    // InternalDbdTextEditor.g:1139:3: ( 'menuAlarmStatLOLO' )
                    // InternalDbdTextEditor.g:1139:4: 'menuAlarmStatLOLO'
                    {
                    match(input,145,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatLOLOEnumLiteralDeclaration_80()); 

                    }


                    }
                    break;
                case 82 :
                    // InternalDbdTextEditor.g:1143:2: ( ( 'menuAlarmStatLOW' ) )
                    {
                    // InternalDbdTextEditor.g:1143:2: ( ( 'menuAlarmStatLOW' ) )
                    // InternalDbdTextEditor.g:1144:3: ( 'menuAlarmStatLOW' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatLOWEnumLiteralDeclaration_81()); 
                    // InternalDbdTextEditor.g:1145:3: ( 'menuAlarmStatLOW' )
                    // InternalDbdTextEditor.g:1145:4: 'menuAlarmStatLOW'
                    {
                    match(input,146,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatLOWEnumLiteralDeclaration_81()); 

                    }


                    }
                    break;
                case 83 :
                    // InternalDbdTextEditor.g:1149:2: ( ( 'menuAlarmStatSTATE' ) )
                    {
                    // InternalDbdTextEditor.g:1149:2: ( ( 'menuAlarmStatSTATE' ) )
                    // InternalDbdTextEditor.g:1150:3: ( 'menuAlarmStatSTATE' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatSTATEEnumLiteralDeclaration_82()); 
                    // InternalDbdTextEditor.g:1151:3: ( 'menuAlarmStatSTATE' )
                    // InternalDbdTextEditor.g:1151:4: 'menuAlarmStatSTATE'
                    {
                    match(input,147,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatSTATEEnumLiteralDeclaration_82()); 

                    }


                    }
                    break;
                case 84 :
                    // InternalDbdTextEditor.g:1155:2: ( ( 'menuAlarmStatCOS' ) )
                    {
                    // InternalDbdTextEditor.g:1155:2: ( ( 'menuAlarmStatCOS' ) )
                    // InternalDbdTextEditor.g:1156:3: ( 'menuAlarmStatCOS' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatCOSEnumLiteralDeclaration_83()); 
                    // InternalDbdTextEditor.g:1157:3: ( 'menuAlarmStatCOS' )
                    // InternalDbdTextEditor.g:1157:4: 'menuAlarmStatCOS'
                    {
                    match(input,148,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatCOSEnumLiteralDeclaration_83()); 

                    }


                    }
                    break;
                case 85 :
                    // InternalDbdTextEditor.g:1161:2: ( ( 'menuAlarmStatCOMM' ) )
                    {
                    // InternalDbdTextEditor.g:1161:2: ( ( 'menuAlarmStatCOMM' ) )
                    // InternalDbdTextEditor.g:1162:3: ( 'menuAlarmStatCOMM' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatCOMMEnumLiteralDeclaration_84()); 
                    // InternalDbdTextEditor.g:1163:3: ( 'menuAlarmStatCOMM' )
                    // InternalDbdTextEditor.g:1163:4: 'menuAlarmStatCOMM'
                    {
                    match(input,149,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatCOMMEnumLiteralDeclaration_84()); 

                    }


                    }
                    break;
                case 86 :
                    // InternalDbdTextEditor.g:1167:2: ( ( 'menuAlarmStatTIMEOUT' ) )
                    {
                    // InternalDbdTextEditor.g:1167:2: ( ( 'menuAlarmStatTIMEOUT' ) )
                    // InternalDbdTextEditor.g:1168:3: ( 'menuAlarmStatTIMEOUT' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatTIMEOUTEnumLiteralDeclaration_85()); 
                    // InternalDbdTextEditor.g:1169:3: ( 'menuAlarmStatTIMEOUT' )
                    // InternalDbdTextEditor.g:1169:4: 'menuAlarmStatTIMEOUT'
                    {
                    match(input,150,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatTIMEOUTEnumLiteralDeclaration_85()); 

                    }


                    }
                    break;
                case 87 :
                    // InternalDbdTextEditor.g:1173:2: ( ( 'menuAlarmStatHWLIMIT' ) )
                    {
                    // InternalDbdTextEditor.g:1173:2: ( ( 'menuAlarmStatHWLIMIT' ) )
                    // InternalDbdTextEditor.g:1174:3: ( 'menuAlarmStatHWLIMIT' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatHWLIMITEnumLiteralDeclaration_86()); 
                    // InternalDbdTextEditor.g:1175:3: ( 'menuAlarmStatHWLIMIT' )
                    // InternalDbdTextEditor.g:1175:4: 'menuAlarmStatHWLIMIT'
                    {
                    match(input,151,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatHWLIMITEnumLiteralDeclaration_86()); 

                    }


                    }
                    break;
                case 88 :
                    // InternalDbdTextEditor.g:1179:2: ( ( 'menuAlarmStatCALC' ) )
                    {
                    // InternalDbdTextEditor.g:1179:2: ( ( 'menuAlarmStatCALC' ) )
                    // InternalDbdTextEditor.g:1180:3: ( 'menuAlarmStatCALC' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatCALCEnumLiteralDeclaration_87()); 
                    // InternalDbdTextEditor.g:1181:3: ( 'menuAlarmStatCALC' )
                    // InternalDbdTextEditor.g:1181:4: 'menuAlarmStatCALC'
                    {
                    match(input,152,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatCALCEnumLiteralDeclaration_87()); 

                    }


                    }
                    break;
                case 89 :
                    // InternalDbdTextEditor.g:1185:2: ( ( 'menuAlarmStatSCAN' ) )
                    {
                    // InternalDbdTextEditor.g:1185:2: ( ( 'menuAlarmStatSCAN' ) )
                    // InternalDbdTextEditor.g:1186:3: ( 'menuAlarmStatSCAN' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatSCANEnumLiteralDeclaration_88()); 
                    // InternalDbdTextEditor.g:1187:3: ( 'menuAlarmStatSCAN' )
                    // InternalDbdTextEditor.g:1187:4: 'menuAlarmStatSCAN'
                    {
                    match(input,153,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatSCANEnumLiteralDeclaration_88()); 

                    }


                    }
                    break;
                case 90 :
                    // InternalDbdTextEditor.g:1191:2: ( ( 'menuAlarmStatLINK' ) )
                    {
                    // InternalDbdTextEditor.g:1191:2: ( ( 'menuAlarmStatLINK' ) )
                    // InternalDbdTextEditor.g:1192:3: ( 'menuAlarmStatLINK' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatLINKEnumLiteralDeclaration_89()); 
                    // InternalDbdTextEditor.g:1193:3: ( 'menuAlarmStatLINK' )
                    // InternalDbdTextEditor.g:1193:4: 'menuAlarmStatLINK'
                    {
                    match(input,154,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatLINKEnumLiteralDeclaration_89()); 

                    }


                    }
                    break;
                case 91 :
                    // InternalDbdTextEditor.g:1197:2: ( ( 'menuAlarmStatSOFT' ) )
                    {
                    // InternalDbdTextEditor.g:1197:2: ( ( 'menuAlarmStatSOFT' ) )
                    // InternalDbdTextEditor.g:1198:3: ( 'menuAlarmStatSOFT' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatSOFTEnumLiteralDeclaration_90()); 
                    // InternalDbdTextEditor.g:1199:3: ( 'menuAlarmStatSOFT' )
                    // InternalDbdTextEditor.g:1199:4: 'menuAlarmStatSOFT'
                    {
                    match(input,155,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatSOFTEnumLiteralDeclaration_90()); 

                    }


                    }
                    break;
                case 92 :
                    // InternalDbdTextEditor.g:1203:2: ( ( 'menuAlarmStatBAD_SUB' ) )
                    {
                    // InternalDbdTextEditor.g:1203:2: ( ( 'menuAlarmStatBAD_SUB' ) )
                    // InternalDbdTextEditor.g:1204:3: ( 'menuAlarmStatBAD_SUB' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatBAD_SUBEnumLiteralDeclaration_91()); 
                    // InternalDbdTextEditor.g:1205:3: ( 'menuAlarmStatBAD_SUB' )
                    // InternalDbdTextEditor.g:1205:4: 'menuAlarmStatBAD_SUB'
                    {
                    match(input,156,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatBAD_SUBEnumLiteralDeclaration_91()); 

                    }


                    }
                    break;
                case 93 :
                    // InternalDbdTextEditor.g:1209:2: ( ( 'menuAlarmStatUDF' ) )
                    {
                    // InternalDbdTextEditor.g:1209:2: ( ( 'menuAlarmStatUDF' ) )
                    // InternalDbdTextEditor.g:1210:3: ( 'menuAlarmStatUDF' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatUDFEnumLiteralDeclaration_92()); 
                    // InternalDbdTextEditor.g:1211:3: ( 'menuAlarmStatUDF' )
                    // InternalDbdTextEditor.g:1211:4: 'menuAlarmStatUDF'
                    {
                    match(input,157,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatUDFEnumLiteralDeclaration_92()); 

                    }


                    }
                    break;
                case 94 :
                    // InternalDbdTextEditor.g:1215:2: ( ( 'menuAlarmStatDISABLE' ) )
                    {
                    // InternalDbdTextEditor.g:1215:2: ( ( 'menuAlarmStatDISABLE' ) )
                    // InternalDbdTextEditor.g:1216:3: ( 'menuAlarmStatDISABLE' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatDISABLEEnumLiteralDeclaration_93()); 
                    // InternalDbdTextEditor.g:1217:3: ( 'menuAlarmStatDISABLE' )
                    // InternalDbdTextEditor.g:1217:4: 'menuAlarmStatDISABLE'
                    {
                    match(input,158,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatDISABLEEnumLiteralDeclaration_93()); 

                    }


                    }
                    break;
                case 95 :
                    // InternalDbdTextEditor.g:1221:2: ( ( 'menuAlarmStatSIMM' ) )
                    {
                    // InternalDbdTextEditor.g:1221:2: ( ( 'menuAlarmStatSIMM' ) )
                    // InternalDbdTextEditor.g:1222:3: ( 'menuAlarmStatSIMM' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatSIMMEnumLiteralDeclaration_94()); 
                    // InternalDbdTextEditor.g:1223:3: ( 'menuAlarmStatSIMM' )
                    // InternalDbdTextEditor.g:1223:4: 'menuAlarmStatSIMM'
                    {
                    match(input,159,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatSIMMEnumLiteralDeclaration_94()); 

                    }


                    }
                    break;
                case 96 :
                    // InternalDbdTextEditor.g:1227:2: ( ( 'menuAlarmStatREAD_ACCESS' ) )
                    {
                    // InternalDbdTextEditor.g:1227:2: ( ( 'menuAlarmStatREAD_ACCESS' ) )
                    // InternalDbdTextEditor.g:1228:3: ( 'menuAlarmStatREAD_ACCESS' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatREAD_ACCESSEnumLiteralDeclaration_95()); 
                    // InternalDbdTextEditor.g:1229:3: ( 'menuAlarmStatREAD_ACCESS' )
                    // InternalDbdTextEditor.g:1229:4: 'menuAlarmStatREAD_ACCESS'
                    {
                    match(input,160,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatREAD_ACCESSEnumLiteralDeclaration_95()); 

                    }


                    }
                    break;
                case 97 :
                    // InternalDbdTextEditor.g:1233:2: ( ( 'menuAlarmStatWRITE_ACCESS' ) )
                    {
                    // InternalDbdTextEditor.g:1233:2: ( ( 'menuAlarmStatWRITE_ACCESS' ) )
                    // InternalDbdTextEditor.g:1234:3: ( 'menuAlarmStatWRITE_ACCESS' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getMenuAlarmStatWRITE_ACCESSEnumLiteralDeclaration_96()); 
                    // InternalDbdTextEditor.g:1235:3: ( 'menuAlarmStatWRITE_ACCESS' )
                    // InternalDbdTextEditor.g:1235:4: 'menuAlarmStatWRITE_ACCESS'
                    {
                    match(input,161,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getMenuAlarmStatWRITE_ACCESSEnumLiteralDeclaration_96()); 

                    }


                    }
                    break;
                case 98 :
                    // InternalDbdTextEditor.g:1239:2: ( ( 'aoOIF_Full' ) )
                    {
                    // InternalDbdTextEditor.g:1239:2: ( ( 'aoOIF_Full' ) )
                    // InternalDbdTextEditor.g:1240:3: ( 'aoOIF_Full' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAoOIF_FullEnumLiteralDeclaration_97()); 
                    // InternalDbdTextEditor.g:1241:3: ( 'aoOIF_Full' )
                    // InternalDbdTextEditor.g:1241:4: 'aoOIF_Full'
                    {
                    match(input,162,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAoOIF_FullEnumLiteralDeclaration_97()); 

                    }


                    }
                    break;
                case 99 :
                    // InternalDbdTextEditor.g:1245:2: ( ( 'aoOIF_Incremental' ) )
                    {
                    // InternalDbdTextEditor.g:1245:2: ( ( 'aoOIF_Incremental' ) )
                    // InternalDbdTextEditor.g:1246:3: ( 'aoOIF_Incremental' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAoOIF_IncrementalEnumLiteralDeclaration_98()); 
                    // InternalDbdTextEditor.g:1247:3: ( 'aoOIF_Incremental' )
                    // InternalDbdTextEditor.g:1247:4: 'aoOIF_Incremental'
                    {
                    match(input,163,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAoOIF_IncrementalEnumLiteralDeclaration_98()); 

                    }


                    }
                    break;
                case 100 :
                    // InternalDbdTextEditor.g:1251:2: ( ( 'bufferingALG_FIFO' ) )
                    {
                    // InternalDbdTextEditor.g:1251:2: ( ( 'bufferingALG_FIFO' ) )
                    // InternalDbdTextEditor.g:1252:3: ( 'bufferingALG_FIFO' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getBufferingALG_FIFOEnumLiteralDeclaration_99()); 
                    // InternalDbdTextEditor.g:1253:3: ( 'bufferingALG_FIFO' )
                    // InternalDbdTextEditor.g:1253:4: 'bufferingALG_FIFO'
                    {
                    match(input,164,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getBufferingALG_FIFOEnumLiteralDeclaration_99()); 

                    }


                    }
                    break;
                case 101 :
                    // InternalDbdTextEditor.g:1257:2: ( ( 'bufferingALG_LIFO' ) )
                    {
                    // InternalDbdTextEditor.g:1257:2: ( ( 'bufferingALG_LIFO' ) )
                    // InternalDbdTextEditor.g:1258:3: ( 'bufferingALG_LIFO' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getBufferingALG_LIFOEnumLiteralDeclaration_100()); 
                    // InternalDbdTextEditor.g:1259:3: ( 'bufferingALG_LIFO' )
                    // InternalDbdTextEditor.g:1259:4: 'bufferingALG_LIFO'
                    {
                    match(input,165,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getBufferingALG_LIFOEnumLiteralDeclaration_100()); 

                    }


                    }
                    break;
                case 102 :
                    // InternalDbdTextEditor.g:1263:2: ( ( 'aaiPOST_Always' ) )
                    {
                    // InternalDbdTextEditor.g:1263:2: ( ( 'aaiPOST_Always' ) )
                    // InternalDbdTextEditor.g:1264:3: ( 'aaiPOST_Always' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAaiPOST_AlwaysEnumLiteralDeclaration_101()); 
                    // InternalDbdTextEditor.g:1265:3: ( 'aaiPOST_Always' )
                    // InternalDbdTextEditor.g:1265:4: 'aaiPOST_Always'
                    {
                    match(input,166,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAaiPOST_AlwaysEnumLiteralDeclaration_101()); 

                    }


                    }
                    break;
                case 103 :
                    // InternalDbdTextEditor.g:1269:2: ( ( 'aaiPOST_OnChange' ) )
                    {
                    // InternalDbdTextEditor.g:1269:2: ( ( 'aaiPOST_OnChange' ) )
                    // InternalDbdTextEditor.g:1270:3: ( 'aaiPOST_OnChange' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAaiPOST_OnChangeEnumLiteralDeclaration_102()); 
                    // InternalDbdTextEditor.g:1271:3: ( 'aaiPOST_OnChange' )
                    // InternalDbdTextEditor.g:1271:4: 'aaiPOST_OnChange'
                    {
                    match(input,167,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAaiPOST_OnChangeEnumLiteralDeclaration_102()); 

                    }


                    }
                    break;
                case 104 :
                    // InternalDbdTextEditor.g:1275:2: ( ( 'epidFeedbackState_Off' ) )
                    {
                    // InternalDbdTextEditor.g:1275:2: ( ( 'epidFeedbackState_Off' ) )
                    // InternalDbdTextEditor.g:1276:3: ( 'epidFeedbackState_Off' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getEpidFeedbackState_OffEnumLiteralDeclaration_103()); 
                    // InternalDbdTextEditor.g:1277:3: ( 'epidFeedbackState_Off' )
                    // InternalDbdTextEditor.g:1277:4: 'epidFeedbackState_Off'
                    {
                    match(input,168,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getEpidFeedbackState_OffEnumLiteralDeclaration_103()); 

                    }


                    }
                    break;
                case 105 :
                    // InternalDbdTextEditor.g:1281:2: ( ( 'epidFeedbackState_On' ) )
                    {
                    // InternalDbdTextEditor.g:1281:2: ( ( 'epidFeedbackState_On' ) )
                    // InternalDbdTextEditor.g:1282:3: ( 'epidFeedbackState_On' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getEpidFeedbackState_OnEnumLiteralDeclaration_104()); 
                    // InternalDbdTextEditor.g:1283:3: ( 'epidFeedbackState_On' )
                    // InternalDbdTextEditor.g:1283:4: 'epidFeedbackState_On'
                    {
                    match(input,169,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getEpidFeedbackState_OnEnumLiteralDeclaration_104()); 

                    }


                    }
                    break;
                case 106 :
                    // InternalDbdTextEditor.g:1287:2: ( ( 'calcoutINAV_EXT_NC' ) )
                    {
                    // InternalDbdTextEditor.g:1287:2: ( ( 'calcoutINAV_EXT_NC' ) )
                    // InternalDbdTextEditor.g:1288:3: ( 'calcoutINAV_EXT_NC' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getCalcoutINAV_EXT_NCEnumLiteralDeclaration_105()); 
                    // InternalDbdTextEditor.g:1289:3: ( 'calcoutINAV_EXT_NC' )
                    // InternalDbdTextEditor.g:1289:4: 'calcoutINAV_EXT_NC'
                    {
                    match(input,170,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getCalcoutINAV_EXT_NCEnumLiteralDeclaration_105()); 

                    }


                    }
                    break;
                case 107 :
                    // InternalDbdTextEditor.g:1293:2: ( ( 'calcoutINAV_EXT' ) )
                    {
                    // InternalDbdTextEditor.g:1293:2: ( ( 'calcoutINAV_EXT' ) )
                    // InternalDbdTextEditor.g:1294:3: ( 'calcoutINAV_EXT' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getCalcoutINAV_EXTEnumLiteralDeclaration_106()); 
                    // InternalDbdTextEditor.g:1295:3: ( 'calcoutINAV_EXT' )
                    // InternalDbdTextEditor.g:1295:4: 'calcoutINAV_EXT'
                    {
                    match(input,171,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getCalcoutINAV_EXTEnumLiteralDeclaration_106()); 

                    }


                    }
                    break;
                case 108 :
                    // InternalDbdTextEditor.g:1299:2: ( ( 'calcoutINAV_LOC' ) )
                    {
                    // InternalDbdTextEditor.g:1299:2: ( ( 'calcoutINAV_LOC' ) )
                    // InternalDbdTextEditor.g:1300:3: ( 'calcoutINAV_LOC' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getCalcoutINAV_LOCEnumLiteralDeclaration_107()); 
                    // InternalDbdTextEditor.g:1301:3: ( 'calcoutINAV_LOC' )
                    // InternalDbdTextEditor.g:1301:4: 'calcoutINAV_LOC'
                    {
                    match(input,172,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getCalcoutINAV_LOCEnumLiteralDeclaration_107()); 

                    }


                    }
                    break;
                case 109 :
                    // InternalDbdTextEditor.g:1305:2: ( ( 'calcoutINAV_CON' ) )
                    {
                    // InternalDbdTextEditor.g:1305:2: ( ( 'calcoutINAV_CON' ) )
                    // InternalDbdTextEditor.g:1306:3: ( 'calcoutINAV_CON' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getCalcoutINAV_CONEnumLiteralDeclaration_108()); 
                    // InternalDbdTextEditor.g:1307:3: ( 'calcoutINAV_CON' )
                    // InternalDbdTextEditor.g:1307:4: 'calcoutINAV_CON'
                    {
                    match(input,173,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getCalcoutINAV_CONEnumLiteralDeclaration_108()); 

                    }


                    }
                    break;
                case 110 :
                    // InternalDbdTextEditor.g:1311:2: ( ( 'asynAUTOCONNECT_noAutoConnect' ) )
                    {
                    // InternalDbdTextEditor.g:1311:2: ( ( 'asynAUTOCONNECT_noAutoConnect' ) )
                    // InternalDbdTextEditor.g:1312:3: ( 'asynAUTOCONNECT_noAutoConnect' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynAUTOCONNECT_noAutoConnectEnumLiteralDeclaration_109()); 
                    // InternalDbdTextEditor.g:1313:3: ( 'asynAUTOCONNECT_noAutoConnect' )
                    // InternalDbdTextEditor.g:1313:4: 'asynAUTOCONNECT_noAutoConnect'
                    {
                    match(input,174,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynAUTOCONNECT_noAutoConnectEnumLiteralDeclaration_109()); 

                    }


                    }
                    break;
                case 111 :
                    // InternalDbdTextEditor.g:1317:2: ( ( 'asynAUTOCONNECT_autoConnect' ) )
                    {
                    // InternalDbdTextEditor.g:1317:2: ( ( 'asynAUTOCONNECT_autoConnect' ) )
                    // InternalDbdTextEditor.g:1318:3: ( 'asynAUTOCONNECT_autoConnect' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynAUTOCONNECT_autoConnectEnumLiteralDeclaration_110()); 
                    // InternalDbdTextEditor.g:1319:3: ( 'asynAUTOCONNECT_autoConnect' )
                    // InternalDbdTextEditor.g:1319:4: 'asynAUTOCONNECT_autoConnect'
                    {
                    match(input,175,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynAUTOCONNECT_autoConnectEnumLiteralDeclaration_110()); 

                    }


                    }
                    break;
                case 112 :
                    // InternalDbdTextEditor.g:1323:2: ( ( 'asynFMT_ASCII' ) )
                    {
                    // InternalDbdTextEditor.g:1323:2: ( ( 'asynFMT_ASCII' ) )
                    // InternalDbdTextEditor.g:1324:3: ( 'asynFMT_ASCII' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynFMT_ASCIIEnumLiteralDeclaration_111()); 
                    // InternalDbdTextEditor.g:1325:3: ( 'asynFMT_ASCII' )
                    // InternalDbdTextEditor.g:1325:4: 'asynFMT_ASCII'
                    {
                    match(input,176,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynFMT_ASCIIEnumLiteralDeclaration_111()); 

                    }


                    }
                    break;
                case 113 :
                    // InternalDbdTextEditor.g:1329:2: ( ( 'asynFMT_Hybrid' ) )
                    {
                    // InternalDbdTextEditor.g:1329:2: ( ( 'asynFMT_Hybrid' ) )
                    // InternalDbdTextEditor.g:1330:3: ( 'asynFMT_Hybrid' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynFMT_HybridEnumLiteralDeclaration_112()); 
                    // InternalDbdTextEditor.g:1331:3: ( 'asynFMT_Hybrid' )
                    // InternalDbdTextEditor.g:1331:4: 'asynFMT_Hybrid'
                    {
                    match(input,177,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynFMT_HybridEnumLiteralDeclaration_112()); 

                    }


                    }
                    break;
                case 114 :
                    // InternalDbdTextEditor.g:1335:2: ( ( 'asynFMT_Binary' ) )
                    {
                    // InternalDbdTextEditor.g:1335:2: ( ( 'asynFMT_Binary' ) )
                    // InternalDbdTextEditor.g:1336:3: ( 'asynFMT_Binary' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynFMT_BinaryEnumLiteralDeclaration_113()); 
                    // InternalDbdTextEditor.g:1337:3: ( 'asynFMT_Binary' )
                    // InternalDbdTextEditor.g:1337:4: 'asynFMT_Binary'
                    {
                    match(input,178,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynFMT_BinaryEnumLiteralDeclaration_113()); 

                    }


                    }
                    break;
                case 115 :
                    // InternalDbdTextEditor.g:1341:2: ( ( 'seqSELM_All' ) )
                    {
                    // InternalDbdTextEditor.g:1341:2: ( ( 'seqSELM_All' ) )
                    // InternalDbdTextEditor.g:1342:3: ( 'seqSELM_All' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSeqSELM_AllEnumLiteralDeclaration_114()); 
                    // InternalDbdTextEditor.g:1343:3: ( 'seqSELM_All' )
                    // InternalDbdTextEditor.g:1343:4: 'seqSELM_All'
                    {
                    match(input,179,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSeqSELM_AllEnumLiteralDeclaration_114()); 

                    }


                    }
                    break;
                case 116 :
                    // InternalDbdTextEditor.g:1347:2: ( ( 'seqSELM_Specified' ) )
                    {
                    // InternalDbdTextEditor.g:1347:2: ( ( 'seqSELM_Specified' ) )
                    // InternalDbdTextEditor.g:1348:3: ( 'seqSELM_Specified' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSeqSELM_SpecifiedEnumLiteralDeclaration_115()); 
                    // InternalDbdTextEditor.g:1349:3: ( 'seqSELM_Specified' )
                    // InternalDbdTextEditor.g:1349:4: 'seqSELM_Specified'
                    {
                    match(input,180,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSeqSELM_SpecifiedEnumLiteralDeclaration_115()); 

                    }


                    }
                    break;
                case 117 :
                    // InternalDbdTextEditor.g:1353:2: ( ( 'seqSELM_Mask' ) )
                    {
                    // InternalDbdTextEditor.g:1353:2: ( ( 'seqSELM_Mask' ) )
                    // InternalDbdTextEditor.g:1354:3: ( 'seqSELM_Mask' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSeqSELM_MaskEnumLiteralDeclaration_116()); 
                    // InternalDbdTextEditor.g:1355:3: ( 'seqSELM_Mask' )
                    // InternalDbdTextEditor.g:1355:4: 'seqSELM_Mask'
                    {
                    match(input,181,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSeqSELM_MaskEnumLiteralDeclaration_116()); 

                    }


                    }
                    break;
                case 118 :
                    // InternalDbdTextEditor.g:1359:2: ( ( 'asynCONNECT_Disconnect' ) )
                    {
                    // InternalDbdTextEditor.g:1359:2: ( ( 'asynCONNECT_Disconnect' ) )
                    // InternalDbdTextEditor.g:1360:3: ( 'asynCONNECT_Disconnect' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynCONNECT_DisconnectEnumLiteralDeclaration_117()); 
                    // InternalDbdTextEditor.g:1361:3: ( 'asynCONNECT_Disconnect' )
                    // InternalDbdTextEditor.g:1361:4: 'asynCONNECT_Disconnect'
                    {
                    match(input,182,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynCONNECT_DisconnectEnumLiteralDeclaration_117()); 

                    }


                    }
                    break;
                case 119 :
                    // InternalDbdTextEditor.g:1365:2: ( ( 'asynCONNECT_Connect' ) )
                    {
                    // InternalDbdTextEditor.g:1365:2: ( ( 'asynCONNECT_Connect' ) )
                    // InternalDbdTextEditor.g:1366:3: ( 'asynCONNECT_Connect' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynCONNECT_ConnectEnumLiteralDeclaration_118()); 
                    // InternalDbdTextEditor.g:1367:3: ( 'asynCONNECT_Connect' )
                    // InternalDbdTextEditor.g:1367:4: 'asynCONNECT_Connect'
                    {
                    match(input,183,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynCONNECT_ConnectEnumLiteralDeclaration_118()); 

                    }


                    }
                    break;
                case 120 :
                    // InternalDbdTextEditor.g:1371:2: ( ( 'gpibUCMD_None' ) )
                    {
                    // InternalDbdTextEditor.g:1371:2: ( ( 'gpibUCMD_None' ) )
                    // InternalDbdTextEditor.g:1372:3: ( 'gpibUCMD_None' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getGpibUCMD_NoneEnumLiteralDeclaration_119()); 
                    // InternalDbdTextEditor.g:1373:3: ( 'gpibUCMD_None' )
                    // InternalDbdTextEditor.g:1373:4: 'gpibUCMD_None'
                    {
                    match(input,184,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getGpibUCMD_NoneEnumLiteralDeclaration_119()); 

                    }


                    }
                    break;
                case 121 :
                    // InternalDbdTextEditor.g:1377:2: ( ( 'gpibUCMD_Device_Clear__DCL_' ) )
                    {
                    // InternalDbdTextEditor.g:1377:2: ( ( 'gpibUCMD_Device_Clear__DCL_' ) )
                    // InternalDbdTextEditor.g:1378:3: ( 'gpibUCMD_Device_Clear__DCL_' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getGpibUCMD_Device_Clear__DCL_EnumLiteralDeclaration_120()); 
                    // InternalDbdTextEditor.g:1379:3: ( 'gpibUCMD_Device_Clear__DCL_' )
                    // InternalDbdTextEditor.g:1379:4: 'gpibUCMD_Device_Clear__DCL_'
                    {
                    match(input,185,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getGpibUCMD_Device_Clear__DCL_EnumLiteralDeclaration_120()); 

                    }


                    }
                    break;
                case 122 :
                    // InternalDbdTextEditor.g:1383:2: ( ( 'gpibUCMD_Local_Lockout__LL0_' ) )
                    {
                    // InternalDbdTextEditor.g:1383:2: ( ( 'gpibUCMD_Local_Lockout__LL0_' ) )
                    // InternalDbdTextEditor.g:1384:3: ( 'gpibUCMD_Local_Lockout__LL0_' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getGpibUCMD_Local_Lockout__LL0_EnumLiteralDeclaration_121()); 
                    // InternalDbdTextEditor.g:1385:3: ( 'gpibUCMD_Local_Lockout__LL0_' )
                    // InternalDbdTextEditor.g:1385:4: 'gpibUCMD_Local_Lockout__LL0_'
                    {
                    match(input,186,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getGpibUCMD_Local_Lockout__LL0_EnumLiteralDeclaration_121()); 

                    }


                    }
                    break;
                case 123 :
                    // InternalDbdTextEditor.g:1389:2: ( ( 'gpibUCMD_Serial_Poll_Disable__SPD_' ) )
                    {
                    // InternalDbdTextEditor.g:1389:2: ( ( 'gpibUCMD_Serial_Poll_Disable__SPD_' ) )
                    // InternalDbdTextEditor.g:1390:3: ( 'gpibUCMD_Serial_Poll_Disable__SPD_' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getGpibUCMD_Serial_Poll_Disable__SPD_EnumLiteralDeclaration_122()); 
                    // InternalDbdTextEditor.g:1391:3: ( 'gpibUCMD_Serial_Poll_Disable__SPD_' )
                    // InternalDbdTextEditor.g:1391:4: 'gpibUCMD_Serial_Poll_Disable__SPD_'
                    {
                    match(input,187,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getGpibUCMD_Serial_Poll_Disable__SPD_EnumLiteralDeclaration_122()); 

                    }


                    }
                    break;
                case 124 :
                    // InternalDbdTextEditor.g:1395:2: ( ( 'gpibUCMD_Serial_Poll_Enable__SPE_' ) )
                    {
                    // InternalDbdTextEditor.g:1395:2: ( ( 'gpibUCMD_Serial_Poll_Enable__SPE_' ) )
                    // InternalDbdTextEditor.g:1396:3: ( 'gpibUCMD_Serial_Poll_Enable__SPE_' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getGpibUCMD_Serial_Poll_Enable__SPE_EnumLiteralDeclaration_123()); 
                    // InternalDbdTextEditor.g:1397:3: ( 'gpibUCMD_Serial_Poll_Enable__SPE_' )
                    // InternalDbdTextEditor.g:1397:4: 'gpibUCMD_Serial_Poll_Enable__SPE_'
                    {
                    match(input,188,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getGpibUCMD_Serial_Poll_Enable__SPE_EnumLiteralDeclaration_123()); 

                    }


                    }
                    break;
                case 125 :
                    // InternalDbdTextEditor.g:1401:2: ( ( 'gpibUCMD_Unlisten__UNL_' ) )
                    {
                    // InternalDbdTextEditor.g:1401:2: ( ( 'gpibUCMD_Unlisten__UNL_' ) )
                    // InternalDbdTextEditor.g:1402:3: ( 'gpibUCMD_Unlisten__UNL_' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getGpibUCMD_Unlisten__UNL_EnumLiteralDeclaration_124()); 
                    // InternalDbdTextEditor.g:1403:3: ( 'gpibUCMD_Unlisten__UNL_' )
                    // InternalDbdTextEditor.g:1403:4: 'gpibUCMD_Unlisten__UNL_'
                    {
                    match(input,189,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getGpibUCMD_Unlisten__UNL_EnumLiteralDeclaration_124()); 

                    }


                    }
                    break;
                case 126 :
                    // InternalDbdTextEditor.g:1407:2: ( ( 'gpibUCMD_Untalk__UNT_' ) )
                    {
                    // InternalDbdTextEditor.g:1407:2: ( ( 'gpibUCMD_Untalk__UNT_' ) )
                    // InternalDbdTextEditor.g:1408:3: ( 'gpibUCMD_Untalk__UNT_' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getGpibUCMD_Untalk__UNT_EnumLiteralDeclaration_125()); 
                    // InternalDbdTextEditor.g:1409:3: ( 'gpibUCMD_Untalk__UNT_' )
                    // InternalDbdTextEditor.g:1409:4: 'gpibUCMD_Untalk__UNT_'
                    {
                    match(input,190,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getGpibUCMD_Untalk__UNT_EnumLiteralDeclaration_125()); 

                    }


                    }
                    break;
                case 127 :
                    // InternalDbdTextEditor.g:1413:2: ( ( 'serialBAUD_unknown' ) )
                    {
                    // InternalDbdTextEditor.g:1413:2: ( ( 'serialBAUD_unknown' ) )
                    // InternalDbdTextEditor.g:1414:3: ( 'serialBAUD_unknown' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialBAUD_unknownEnumLiteralDeclaration_126()); 
                    // InternalDbdTextEditor.g:1415:3: ( 'serialBAUD_unknown' )
                    // InternalDbdTextEditor.g:1415:4: 'serialBAUD_unknown'
                    {
                    match(input,191,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialBAUD_unknownEnumLiteralDeclaration_126()); 

                    }


                    }
                    break;
                case 128 :
                    // InternalDbdTextEditor.g:1419:2: ( ( 'serialBAUD_300' ) )
                    {
                    // InternalDbdTextEditor.g:1419:2: ( ( 'serialBAUD_300' ) )
                    // InternalDbdTextEditor.g:1420:3: ( 'serialBAUD_300' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialBAUD_300EnumLiteralDeclaration_127()); 
                    // InternalDbdTextEditor.g:1421:3: ( 'serialBAUD_300' )
                    // InternalDbdTextEditor.g:1421:4: 'serialBAUD_300'
                    {
                    match(input,192,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialBAUD_300EnumLiteralDeclaration_127()); 

                    }


                    }
                    break;
                case 129 :
                    // InternalDbdTextEditor.g:1425:2: ( ( 'serialBAUD_600' ) )
                    {
                    // InternalDbdTextEditor.g:1425:2: ( ( 'serialBAUD_600' ) )
                    // InternalDbdTextEditor.g:1426:3: ( 'serialBAUD_600' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialBAUD_600EnumLiteralDeclaration_128()); 
                    // InternalDbdTextEditor.g:1427:3: ( 'serialBAUD_600' )
                    // InternalDbdTextEditor.g:1427:4: 'serialBAUD_600'
                    {
                    match(input,193,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialBAUD_600EnumLiteralDeclaration_128()); 

                    }


                    }
                    break;
                case 130 :
                    // InternalDbdTextEditor.g:1431:2: ( ( 'serialBAUD_1200' ) )
                    {
                    // InternalDbdTextEditor.g:1431:2: ( ( 'serialBAUD_1200' ) )
                    // InternalDbdTextEditor.g:1432:3: ( 'serialBAUD_1200' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialBAUD_1200EnumLiteralDeclaration_129()); 
                    // InternalDbdTextEditor.g:1433:3: ( 'serialBAUD_1200' )
                    // InternalDbdTextEditor.g:1433:4: 'serialBAUD_1200'
                    {
                    match(input,194,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialBAUD_1200EnumLiteralDeclaration_129()); 

                    }


                    }
                    break;
                case 131 :
                    // InternalDbdTextEditor.g:1437:2: ( ( 'serialBAUD_2400' ) )
                    {
                    // InternalDbdTextEditor.g:1437:2: ( ( 'serialBAUD_2400' ) )
                    // InternalDbdTextEditor.g:1438:3: ( 'serialBAUD_2400' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialBAUD_2400EnumLiteralDeclaration_130()); 
                    // InternalDbdTextEditor.g:1439:3: ( 'serialBAUD_2400' )
                    // InternalDbdTextEditor.g:1439:4: 'serialBAUD_2400'
                    {
                    match(input,195,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialBAUD_2400EnumLiteralDeclaration_130()); 

                    }


                    }
                    break;
                case 132 :
                    // InternalDbdTextEditor.g:1443:2: ( ( 'serialBAUD_4800' ) )
                    {
                    // InternalDbdTextEditor.g:1443:2: ( ( 'serialBAUD_4800' ) )
                    // InternalDbdTextEditor.g:1444:3: ( 'serialBAUD_4800' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialBAUD_4800EnumLiteralDeclaration_131()); 
                    // InternalDbdTextEditor.g:1445:3: ( 'serialBAUD_4800' )
                    // InternalDbdTextEditor.g:1445:4: 'serialBAUD_4800'
                    {
                    match(input,196,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialBAUD_4800EnumLiteralDeclaration_131()); 

                    }


                    }
                    break;
                case 133 :
                    // InternalDbdTextEditor.g:1449:2: ( ( 'serialBAUD_9600' ) )
                    {
                    // InternalDbdTextEditor.g:1449:2: ( ( 'serialBAUD_9600' ) )
                    // InternalDbdTextEditor.g:1450:3: ( 'serialBAUD_9600' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialBAUD_9600EnumLiteralDeclaration_132()); 
                    // InternalDbdTextEditor.g:1451:3: ( 'serialBAUD_9600' )
                    // InternalDbdTextEditor.g:1451:4: 'serialBAUD_9600'
                    {
                    match(input,197,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialBAUD_9600EnumLiteralDeclaration_132()); 

                    }


                    }
                    break;
                case 134 :
                    // InternalDbdTextEditor.g:1455:2: ( ( 'serialBAUD_19200' ) )
                    {
                    // InternalDbdTextEditor.g:1455:2: ( ( 'serialBAUD_19200' ) )
                    // InternalDbdTextEditor.g:1456:3: ( 'serialBAUD_19200' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialBAUD_19200EnumLiteralDeclaration_133()); 
                    // InternalDbdTextEditor.g:1457:3: ( 'serialBAUD_19200' )
                    // InternalDbdTextEditor.g:1457:4: 'serialBAUD_19200'
                    {
                    match(input,198,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialBAUD_19200EnumLiteralDeclaration_133()); 

                    }


                    }
                    break;
                case 135 :
                    // InternalDbdTextEditor.g:1461:2: ( ( 'serialBAUD_38400' ) )
                    {
                    // InternalDbdTextEditor.g:1461:2: ( ( 'serialBAUD_38400' ) )
                    // InternalDbdTextEditor.g:1462:3: ( 'serialBAUD_38400' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialBAUD_38400EnumLiteralDeclaration_134()); 
                    // InternalDbdTextEditor.g:1463:3: ( 'serialBAUD_38400' )
                    // InternalDbdTextEditor.g:1463:4: 'serialBAUD_38400'
                    {
                    match(input,199,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialBAUD_38400EnumLiteralDeclaration_134()); 

                    }


                    }
                    break;
                case 136 :
                    // InternalDbdTextEditor.g:1467:2: ( ( 'serialBAUD_57600' ) )
                    {
                    // InternalDbdTextEditor.g:1467:2: ( ( 'serialBAUD_57600' ) )
                    // InternalDbdTextEditor.g:1468:3: ( 'serialBAUD_57600' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialBAUD_57600EnumLiteralDeclaration_135()); 
                    // InternalDbdTextEditor.g:1469:3: ( 'serialBAUD_57600' )
                    // InternalDbdTextEditor.g:1469:4: 'serialBAUD_57600'
                    {
                    match(input,200,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialBAUD_57600EnumLiteralDeclaration_135()); 

                    }


                    }
                    break;
                case 137 :
                    // InternalDbdTextEditor.g:1473:2: ( ( 'serialBAUD_115200' ) )
                    {
                    // InternalDbdTextEditor.g:1473:2: ( ( 'serialBAUD_115200' ) )
                    // InternalDbdTextEditor.g:1474:3: ( 'serialBAUD_115200' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialBAUD_115200EnumLiteralDeclaration_136()); 
                    // InternalDbdTextEditor.g:1475:3: ( 'serialBAUD_115200' )
                    // InternalDbdTextEditor.g:1475:4: 'serialBAUD_115200'
                    {
                    match(input,201,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialBAUD_115200EnumLiteralDeclaration_136()); 

                    }


                    }
                    break;
                case 138 :
                    // InternalDbdTextEditor.g:1479:2: ( ( 'serialBAUD_230400' ) )
                    {
                    // InternalDbdTextEditor.g:1479:2: ( ( 'serialBAUD_230400' ) )
                    // InternalDbdTextEditor.g:1480:3: ( 'serialBAUD_230400' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialBAUD_230400EnumLiteralDeclaration_137()); 
                    // InternalDbdTextEditor.g:1481:3: ( 'serialBAUD_230400' )
                    // InternalDbdTextEditor.g:1481:4: 'serialBAUD_230400'
                    {
                    match(input,202,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialBAUD_230400EnumLiteralDeclaration_137()); 

                    }


                    }
                    break;
                case 139 :
                    // InternalDbdTextEditor.g:1485:2: ( ( 'serialBAUD_460800' ) )
                    {
                    // InternalDbdTextEditor.g:1485:2: ( ( 'serialBAUD_460800' ) )
                    // InternalDbdTextEditor.g:1486:3: ( 'serialBAUD_460800' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialBAUD_460800EnumLiteralDeclaration_138()); 
                    // InternalDbdTextEditor.g:1487:3: ( 'serialBAUD_460800' )
                    // InternalDbdTextEditor.g:1487:4: 'serialBAUD_460800'
                    {
                    match(input,203,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialBAUD_460800EnumLiteralDeclaration_138()); 

                    }


                    }
                    break;
                case 140 :
                    // InternalDbdTextEditor.g:1491:2: ( ( 'serialBAUD_576000' ) )
                    {
                    // InternalDbdTextEditor.g:1491:2: ( ( 'serialBAUD_576000' ) )
                    // InternalDbdTextEditor.g:1492:3: ( 'serialBAUD_576000' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialBAUD_576000EnumLiteralDeclaration_139()); 
                    // InternalDbdTextEditor.g:1493:3: ( 'serialBAUD_576000' )
                    // InternalDbdTextEditor.g:1493:4: 'serialBAUD_576000'
                    {
                    match(input,204,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialBAUD_576000EnumLiteralDeclaration_139()); 

                    }


                    }
                    break;
                case 141 :
                    // InternalDbdTextEditor.g:1497:2: ( ( 'serialBAUD_921600' ) )
                    {
                    // InternalDbdTextEditor.g:1497:2: ( ( 'serialBAUD_921600' ) )
                    // InternalDbdTextEditor.g:1498:3: ( 'serialBAUD_921600' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialBAUD_921600EnumLiteralDeclaration_140()); 
                    // InternalDbdTextEditor.g:1499:3: ( 'serialBAUD_921600' )
                    // InternalDbdTextEditor.g:1499:4: 'serialBAUD_921600'
                    {
                    match(input,205,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialBAUD_921600EnumLiteralDeclaration_140()); 

                    }


                    }
                    break;
                case 142 :
                    // InternalDbdTextEditor.g:1503:2: ( ( 'serialBAUD_1152000' ) )
                    {
                    // InternalDbdTextEditor.g:1503:2: ( ( 'serialBAUD_1152000' ) )
                    // InternalDbdTextEditor.g:1504:3: ( 'serialBAUD_1152000' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getSerialBAUD_1152000EnumLiteralDeclaration_141()); 
                    // InternalDbdTextEditor.g:1505:3: ( 'serialBAUD_1152000' )
                    // InternalDbdTextEditor.g:1505:4: 'serialBAUD_1152000'
                    {
                    match(input,206,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getSerialBAUD_1152000EnumLiteralDeclaration_141()); 

                    }


                    }
                    break;
                case 143 :
                    // InternalDbdTextEditor.g:1509:2: ( ( 'histogramCMD_Read' ) )
                    {
                    // InternalDbdTextEditor.g:1509:2: ( ( 'histogramCMD_Read' ) )
                    // InternalDbdTextEditor.g:1510:3: ( 'histogramCMD_Read' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getHistogramCMD_ReadEnumLiteralDeclaration_142()); 
                    // InternalDbdTextEditor.g:1511:3: ( 'histogramCMD_Read' )
                    // InternalDbdTextEditor.g:1511:4: 'histogramCMD_Read'
                    {
                    match(input,207,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getHistogramCMD_ReadEnumLiteralDeclaration_142()); 

                    }


                    }
                    break;
                case 144 :
                    // InternalDbdTextEditor.g:1515:2: ( ( 'histogramCMD_Clear' ) )
                    {
                    // InternalDbdTextEditor.g:1515:2: ( ( 'histogramCMD_Clear' ) )
                    // InternalDbdTextEditor.g:1516:3: ( 'histogramCMD_Clear' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getHistogramCMD_ClearEnumLiteralDeclaration_143()); 
                    // InternalDbdTextEditor.g:1517:3: ( 'histogramCMD_Clear' )
                    // InternalDbdTextEditor.g:1517:4: 'histogramCMD_Clear'
                    {
                    match(input,208,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getHistogramCMD_ClearEnumLiteralDeclaration_143()); 

                    }


                    }
                    break;
                case 145 :
                    // InternalDbdTextEditor.g:1521:2: ( ( 'histogramCMD_Start' ) )
                    {
                    // InternalDbdTextEditor.g:1521:2: ( ( 'histogramCMD_Start' ) )
                    // InternalDbdTextEditor.g:1522:3: ( 'histogramCMD_Start' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getHistogramCMD_StartEnumLiteralDeclaration_144()); 
                    // InternalDbdTextEditor.g:1523:3: ( 'histogramCMD_Start' )
                    // InternalDbdTextEditor.g:1523:4: 'histogramCMD_Start'
                    {
                    match(input,209,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getHistogramCMD_StartEnumLiteralDeclaration_144()); 

                    }


                    }
                    break;
                case 146 :
                    // InternalDbdTextEditor.g:1527:2: ( ( 'histogramCMD_Stop' ) )
                    {
                    // InternalDbdTextEditor.g:1527:2: ( ( 'histogramCMD_Stop' ) )
                    // InternalDbdTextEditor.g:1528:3: ( 'histogramCMD_Stop' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getHistogramCMD_StopEnumLiteralDeclaration_145()); 
                    // InternalDbdTextEditor.g:1529:3: ( 'histogramCMD_Stop' )
                    // InternalDbdTextEditor.g:1529:4: 'histogramCMD_Stop'
                    {
                    match(input,210,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getHistogramCMD_StopEnumLiteralDeclaration_145()); 

                    }


                    }
                    break;
                case 147 :
                    // InternalDbdTextEditor.g:1533:2: ( ( 'asynTRACE_Off' ) )
                    {
                    // InternalDbdTextEditor.g:1533:2: ( ( 'asynTRACE_Off' ) )
                    // InternalDbdTextEditor.g:1534:3: ( 'asynTRACE_Off' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynTRACE_OffEnumLiteralDeclaration_146()); 
                    // InternalDbdTextEditor.g:1535:3: ( 'asynTRACE_Off' )
                    // InternalDbdTextEditor.g:1535:4: 'asynTRACE_Off'
                    {
                    match(input,211,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynTRACE_OffEnumLiteralDeclaration_146()); 

                    }


                    }
                    break;
                case 148 :
                    // InternalDbdTextEditor.g:1539:2: ( ( 'asynTRACE_On' ) )
                    {
                    // InternalDbdTextEditor.g:1539:2: ( ( 'asynTRACE_On' ) )
                    // InternalDbdTextEditor.g:1540:3: ( 'asynTRACE_On' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynTRACE_OnEnumLiteralDeclaration_147()); 
                    // InternalDbdTextEditor.g:1541:3: ( 'asynTRACE_On' )
                    // InternalDbdTextEditor.g:1541:4: 'asynTRACE_On'
                    {
                    match(input,212,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynTRACE_OnEnumLiteralDeclaration_147()); 

                    }


                    }
                    break;
                case 149 :
                    // InternalDbdTextEditor.g:1545:2: ( ( 'scalerG1_N' ) )
                    {
                    // InternalDbdTextEditor.g:1545:2: ( ( 'scalerG1_N' ) )
                    // InternalDbdTextEditor.g:1546:3: ( 'scalerG1_N' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getScalerG1_NEnumLiteralDeclaration_148()); 
                    // InternalDbdTextEditor.g:1547:3: ( 'scalerG1_N' )
                    // InternalDbdTextEditor.g:1547:4: 'scalerG1_N'
                    {
                    match(input,213,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getScalerG1_NEnumLiteralDeclaration_148()); 

                    }


                    }
                    break;
                case 150 :
                    // InternalDbdTextEditor.g:1551:2: ( ( 'scalerG1_Y' ) )
                    {
                    // InternalDbdTextEditor.g:1551:2: ( ( 'scalerG1_Y' ) )
                    // InternalDbdTextEditor.g:1552:3: ( 'scalerG1_Y' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getScalerG1_YEnumLiteralDeclaration_149()); 
                    // InternalDbdTextEditor.g:1553:3: ( 'scalerG1_Y' )
                    // InternalDbdTextEditor.g:1553:4: 'scalerG1_Y'
                    {
                    match(input,214,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getScalerG1_YEnumLiteralDeclaration_149()); 

                    }


                    }
                    break;
                case 151 :
                    // InternalDbdTextEditor.g:1557:2: ( ( 'asynEOMREASONNone' ) )
                    {
                    // InternalDbdTextEditor.g:1557:2: ( ( 'asynEOMREASONNone' ) )
                    // InternalDbdTextEditor.g:1558:3: ( 'asynEOMREASONNone' )
                    {
                     before(grammarAccess.getChoicenamesAccess().getAsynEOMREASONNoneEnumLiteralDeclaration_150()); 
                    // InternalDbdTextEditor.g:1559:3: ( 'asynEOMREASONNone' )
                    // InternalDbdTextEditor.g:1559:4: 'asynEOMREASONNone'
                    {
                    match(input,215,FOLLOW_2); 

                    }

                     after(grammarAccess.getChoicenamesAccess().getAsynEOMREASONNoneEnumLiteralDeclaration_150()); 

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
    // $ANTLR end "rule__Choicenames__Alternatives"


    // $ANTLR start "rule__Recordtypenames__Alternatives"
    // InternalDbdTextEditor.g:1567:1: rule__Recordtypenames__Alternatives : ( ( ( 'calcout' ) ) | ( ( 'state' ) ) | ( ( 'histogram' ) ) | ( ( 'lsi' ) ) | ( ( 'int64out' ) ) | ( ( 'seq' ) ) | ( ( 'stringout' ) ) | ( ( 'aai' ) ) | ( ( 'permissive' ) ) | ( ( 'bo' ) ) | ( ( 'dfanout' ) ) | ( ( 'mbbi' ) ) | ( ( 'event' ) ) | ( ( 'compress' ) ) | ( ( 'mbbo' ) ) | ( ( 'epid' ) ) | ( ( 'ao' ) ) | ( ( 'aao' ) ) | ( ( 'mbbiDirect' ) ) | ( ( 'asyn' ) ) | ( ( 'waveform' ) ) | ( ( 'scaler' ) ) | ( ( 'timestamp' ) ) | ( ( 'fanout' ) ) | ( ( 'longin' ) ) | ( ( 'printf' ) ) | ( ( 'sel' ) ) | ( ( 'bi' ) ) | ( ( 'lso' ) ) | ( ( 'subArray' ) ) | ( ( 'calc' ) ) | ( ( 'mbboDirect' ) ) | ( ( 'longout' ) ) | ( ( 'aSub' ) ) | ( ( 'sub' ) ) | ( ( 'int64in' ) ) | ( ( 'ai' ) ) );
    public final void rule__Recordtypenames__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:1571:1: ( ( ( 'calcout' ) ) | ( ( 'state' ) ) | ( ( 'histogram' ) ) | ( ( 'lsi' ) ) | ( ( 'int64out' ) ) | ( ( 'seq' ) ) | ( ( 'stringout' ) ) | ( ( 'aai' ) ) | ( ( 'permissive' ) ) | ( ( 'bo' ) ) | ( ( 'dfanout' ) ) | ( ( 'mbbi' ) ) | ( ( 'event' ) ) | ( ( 'compress' ) ) | ( ( 'mbbo' ) ) | ( ( 'epid' ) ) | ( ( 'ao' ) ) | ( ( 'aao' ) ) | ( ( 'mbbiDirect' ) ) | ( ( 'asyn' ) ) | ( ( 'waveform' ) ) | ( ( 'scaler' ) ) | ( ( 'timestamp' ) ) | ( ( 'fanout' ) ) | ( ( 'longin' ) ) | ( ( 'printf' ) ) | ( ( 'sel' ) ) | ( ( 'bi' ) ) | ( ( 'lso' ) ) | ( ( 'subArray' ) ) | ( ( 'calc' ) ) | ( ( 'mbboDirect' ) ) | ( ( 'longout' ) ) | ( ( 'aSub' ) ) | ( ( 'sub' ) ) | ( ( 'int64in' ) ) | ( ( 'ai' ) ) )
            int alt4=37;
            switch ( input.LA(1) ) {
            case 216:
                {
                alt4=1;
                }
                break;
            case 217:
                {
                alt4=2;
                }
                break;
            case 218:
                {
                alt4=3;
                }
                break;
            case 219:
                {
                alt4=4;
                }
                break;
            case 220:
                {
                alt4=5;
                }
                break;
            case 221:
                {
                alt4=6;
                }
                break;
            case 222:
                {
                alt4=7;
                }
                break;
            case 223:
                {
                alt4=8;
                }
                break;
            case 224:
                {
                alt4=9;
                }
                break;
            case 225:
                {
                alt4=10;
                }
                break;
            case 226:
                {
                alt4=11;
                }
                break;
            case 227:
                {
                alt4=12;
                }
                break;
            case 228:
                {
                alt4=13;
                }
                break;
            case 229:
                {
                alt4=14;
                }
                break;
            case 230:
                {
                alt4=15;
                }
                break;
            case 231:
                {
                alt4=16;
                }
                break;
            case 232:
                {
                alt4=17;
                }
                break;
            case 233:
                {
                alt4=18;
                }
                break;
            case 234:
                {
                alt4=19;
                }
                break;
            case 235:
                {
                alt4=20;
                }
                break;
            case 236:
                {
                alt4=21;
                }
                break;
            case 237:
                {
                alt4=22;
                }
                break;
            case 238:
                {
                alt4=23;
                }
                break;
            case 239:
                {
                alt4=24;
                }
                break;
            case 240:
                {
                alt4=25;
                }
                break;
            case 241:
                {
                alt4=26;
                }
                break;
            case 242:
                {
                alt4=27;
                }
                break;
            case 243:
                {
                alt4=28;
                }
                break;
            case 244:
                {
                alt4=29;
                }
                break;
            case 245:
                {
                alt4=30;
                }
                break;
            case 246:
                {
                alt4=31;
                }
                break;
            case 247:
                {
                alt4=32;
                }
                break;
            case 248:
                {
                alt4=33;
                }
                break;
            case 249:
                {
                alt4=34;
                }
                break;
            case 250:
                {
                alt4=35;
                }
                break;
            case 251:
                {
                alt4=36;
                }
                break;
            case 252:
                {
                alt4=37;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalDbdTextEditor.g:1572:2: ( ( 'calcout' ) )
                    {
                    // InternalDbdTextEditor.g:1572:2: ( ( 'calcout' ) )
                    // InternalDbdTextEditor.g:1573:3: ( 'calcout' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getCalcoutEnumLiteralDeclaration_0()); 
                    // InternalDbdTextEditor.g:1574:3: ( 'calcout' )
                    // InternalDbdTextEditor.g:1574:4: 'calcout'
                    {
                    match(input,216,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getCalcoutEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDbdTextEditor.g:1578:2: ( ( 'state' ) )
                    {
                    // InternalDbdTextEditor.g:1578:2: ( ( 'state' ) )
                    // InternalDbdTextEditor.g:1579:3: ( 'state' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getStateEnumLiteralDeclaration_1()); 
                    // InternalDbdTextEditor.g:1580:3: ( 'state' )
                    // InternalDbdTextEditor.g:1580:4: 'state'
                    {
                    match(input,217,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getStateEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDbdTextEditor.g:1584:2: ( ( 'histogram' ) )
                    {
                    // InternalDbdTextEditor.g:1584:2: ( ( 'histogram' ) )
                    // InternalDbdTextEditor.g:1585:3: ( 'histogram' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getHistogramEnumLiteralDeclaration_2()); 
                    // InternalDbdTextEditor.g:1586:3: ( 'histogram' )
                    // InternalDbdTextEditor.g:1586:4: 'histogram'
                    {
                    match(input,218,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getHistogramEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDbdTextEditor.g:1590:2: ( ( 'lsi' ) )
                    {
                    // InternalDbdTextEditor.g:1590:2: ( ( 'lsi' ) )
                    // InternalDbdTextEditor.g:1591:3: ( 'lsi' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getLsiEnumLiteralDeclaration_3()); 
                    // InternalDbdTextEditor.g:1592:3: ( 'lsi' )
                    // InternalDbdTextEditor.g:1592:4: 'lsi'
                    {
                    match(input,219,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getLsiEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDbdTextEditor.g:1596:2: ( ( 'int64out' ) )
                    {
                    // InternalDbdTextEditor.g:1596:2: ( ( 'int64out' ) )
                    // InternalDbdTextEditor.g:1597:3: ( 'int64out' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getInt64outEnumLiteralDeclaration_4()); 
                    // InternalDbdTextEditor.g:1598:3: ( 'int64out' )
                    // InternalDbdTextEditor.g:1598:4: 'int64out'
                    {
                    match(input,220,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getInt64outEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDbdTextEditor.g:1602:2: ( ( 'seq' ) )
                    {
                    // InternalDbdTextEditor.g:1602:2: ( ( 'seq' ) )
                    // InternalDbdTextEditor.g:1603:3: ( 'seq' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getSeqEnumLiteralDeclaration_5()); 
                    // InternalDbdTextEditor.g:1604:3: ( 'seq' )
                    // InternalDbdTextEditor.g:1604:4: 'seq'
                    {
                    match(input,221,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getSeqEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDbdTextEditor.g:1608:2: ( ( 'stringout' ) )
                    {
                    // InternalDbdTextEditor.g:1608:2: ( ( 'stringout' ) )
                    // InternalDbdTextEditor.g:1609:3: ( 'stringout' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getStringoutEnumLiteralDeclaration_6()); 
                    // InternalDbdTextEditor.g:1610:3: ( 'stringout' )
                    // InternalDbdTextEditor.g:1610:4: 'stringout'
                    {
                    match(input,222,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getStringoutEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDbdTextEditor.g:1614:2: ( ( 'aai' ) )
                    {
                    // InternalDbdTextEditor.g:1614:2: ( ( 'aai' ) )
                    // InternalDbdTextEditor.g:1615:3: ( 'aai' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getAaiEnumLiteralDeclaration_7()); 
                    // InternalDbdTextEditor.g:1616:3: ( 'aai' )
                    // InternalDbdTextEditor.g:1616:4: 'aai'
                    {
                    match(input,223,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getAaiEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDbdTextEditor.g:1620:2: ( ( 'permissive' ) )
                    {
                    // InternalDbdTextEditor.g:1620:2: ( ( 'permissive' ) )
                    // InternalDbdTextEditor.g:1621:3: ( 'permissive' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getPermissiveEnumLiteralDeclaration_8()); 
                    // InternalDbdTextEditor.g:1622:3: ( 'permissive' )
                    // InternalDbdTextEditor.g:1622:4: 'permissive'
                    {
                    match(input,224,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getPermissiveEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDbdTextEditor.g:1626:2: ( ( 'bo' ) )
                    {
                    // InternalDbdTextEditor.g:1626:2: ( ( 'bo' ) )
                    // InternalDbdTextEditor.g:1627:3: ( 'bo' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getBoEnumLiteralDeclaration_9()); 
                    // InternalDbdTextEditor.g:1628:3: ( 'bo' )
                    // InternalDbdTextEditor.g:1628:4: 'bo'
                    {
                    match(input,225,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getBoEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalDbdTextEditor.g:1632:2: ( ( 'dfanout' ) )
                    {
                    // InternalDbdTextEditor.g:1632:2: ( ( 'dfanout' ) )
                    // InternalDbdTextEditor.g:1633:3: ( 'dfanout' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getDfanoutEnumLiteralDeclaration_10()); 
                    // InternalDbdTextEditor.g:1634:3: ( 'dfanout' )
                    // InternalDbdTextEditor.g:1634:4: 'dfanout'
                    {
                    match(input,226,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getDfanoutEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalDbdTextEditor.g:1638:2: ( ( 'mbbi' ) )
                    {
                    // InternalDbdTextEditor.g:1638:2: ( ( 'mbbi' ) )
                    // InternalDbdTextEditor.g:1639:3: ( 'mbbi' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getMbbiEnumLiteralDeclaration_11()); 
                    // InternalDbdTextEditor.g:1640:3: ( 'mbbi' )
                    // InternalDbdTextEditor.g:1640:4: 'mbbi'
                    {
                    match(input,227,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getMbbiEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalDbdTextEditor.g:1644:2: ( ( 'event' ) )
                    {
                    // InternalDbdTextEditor.g:1644:2: ( ( 'event' ) )
                    // InternalDbdTextEditor.g:1645:3: ( 'event' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getEventEnumLiteralDeclaration_12()); 
                    // InternalDbdTextEditor.g:1646:3: ( 'event' )
                    // InternalDbdTextEditor.g:1646:4: 'event'
                    {
                    match(input,228,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getEventEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalDbdTextEditor.g:1650:2: ( ( 'compress' ) )
                    {
                    // InternalDbdTextEditor.g:1650:2: ( ( 'compress' ) )
                    // InternalDbdTextEditor.g:1651:3: ( 'compress' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getCompressEnumLiteralDeclaration_13()); 
                    // InternalDbdTextEditor.g:1652:3: ( 'compress' )
                    // InternalDbdTextEditor.g:1652:4: 'compress'
                    {
                    match(input,229,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getCompressEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalDbdTextEditor.g:1656:2: ( ( 'mbbo' ) )
                    {
                    // InternalDbdTextEditor.g:1656:2: ( ( 'mbbo' ) )
                    // InternalDbdTextEditor.g:1657:3: ( 'mbbo' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getMbboEnumLiteralDeclaration_14()); 
                    // InternalDbdTextEditor.g:1658:3: ( 'mbbo' )
                    // InternalDbdTextEditor.g:1658:4: 'mbbo'
                    {
                    match(input,230,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getMbboEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalDbdTextEditor.g:1662:2: ( ( 'epid' ) )
                    {
                    // InternalDbdTextEditor.g:1662:2: ( ( 'epid' ) )
                    // InternalDbdTextEditor.g:1663:3: ( 'epid' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getEpidEnumLiteralDeclaration_15()); 
                    // InternalDbdTextEditor.g:1664:3: ( 'epid' )
                    // InternalDbdTextEditor.g:1664:4: 'epid'
                    {
                    match(input,231,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getEpidEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalDbdTextEditor.g:1668:2: ( ( 'ao' ) )
                    {
                    // InternalDbdTextEditor.g:1668:2: ( ( 'ao' ) )
                    // InternalDbdTextEditor.g:1669:3: ( 'ao' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getAoEnumLiteralDeclaration_16()); 
                    // InternalDbdTextEditor.g:1670:3: ( 'ao' )
                    // InternalDbdTextEditor.g:1670:4: 'ao'
                    {
                    match(input,232,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getAoEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalDbdTextEditor.g:1674:2: ( ( 'aao' ) )
                    {
                    // InternalDbdTextEditor.g:1674:2: ( ( 'aao' ) )
                    // InternalDbdTextEditor.g:1675:3: ( 'aao' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getAaoEnumLiteralDeclaration_17()); 
                    // InternalDbdTextEditor.g:1676:3: ( 'aao' )
                    // InternalDbdTextEditor.g:1676:4: 'aao'
                    {
                    match(input,233,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getAaoEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalDbdTextEditor.g:1680:2: ( ( 'mbbiDirect' ) )
                    {
                    // InternalDbdTextEditor.g:1680:2: ( ( 'mbbiDirect' ) )
                    // InternalDbdTextEditor.g:1681:3: ( 'mbbiDirect' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getMbbiDirectEnumLiteralDeclaration_18()); 
                    // InternalDbdTextEditor.g:1682:3: ( 'mbbiDirect' )
                    // InternalDbdTextEditor.g:1682:4: 'mbbiDirect'
                    {
                    match(input,234,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getMbbiDirectEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalDbdTextEditor.g:1686:2: ( ( 'asyn' ) )
                    {
                    // InternalDbdTextEditor.g:1686:2: ( ( 'asyn' ) )
                    // InternalDbdTextEditor.g:1687:3: ( 'asyn' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getAsynEnumLiteralDeclaration_19()); 
                    // InternalDbdTextEditor.g:1688:3: ( 'asyn' )
                    // InternalDbdTextEditor.g:1688:4: 'asyn'
                    {
                    match(input,235,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getAsynEnumLiteralDeclaration_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalDbdTextEditor.g:1692:2: ( ( 'waveform' ) )
                    {
                    // InternalDbdTextEditor.g:1692:2: ( ( 'waveform' ) )
                    // InternalDbdTextEditor.g:1693:3: ( 'waveform' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getWaveformEnumLiteralDeclaration_20()); 
                    // InternalDbdTextEditor.g:1694:3: ( 'waveform' )
                    // InternalDbdTextEditor.g:1694:4: 'waveform'
                    {
                    match(input,236,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getWaveformEnumLiteralDeclaration_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalDbdTextEditor.g:1698:2: ( ( 'scaler' ) )
                    {
                    // InternalDbdTextEditor.g:1698:2: ( ( 'scaler' ) )
                    // InternalDbdTextEditor.g:1699:3: ( 'scaler' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getScalerEnumLiteralDeclaration_21()); 
                    // InternalDbdTextEditor.g:1700:3: ( 'scaler' )
                    // InternalDbdTextEditor.g:1700:4: 'scaler'
                    {
                    match(input,237,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getScalerEnumLiteralDeclaration_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalDbdTextEditor.g:1704:2: ( ( 'timestamp' ) )
                    {
                    // InternalDbdTextEditor.g:1704:2: ( ( 'timestamp' ) )
                    // InternalDbdTextEditor.g:1705:3: ( 'timestamp' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getTimestampEnumLiteralDeclaration_22()); 
                    // InternalDbdTextEditor.g:1706:3: ( 'timestamp' )
                    // InternalDbdTextEditor.g:1706:4: 'timestamp'
                    {
                    match(input,238,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getTimestampEnumLiteralDeclaration_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalDbdTextEditor.g:1710:2: ( ( 'fanout' ) )
                    {
                    // InternalDbdTextEditor.g:1710:2: ( ( 'fanout' ) )
                    // InternalDbdTextEditor.g:1711:3: ( 'fanout' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getFanoutEnumLiteralDeclaration_23()); 
                    // InternalDbdTextEditor.g:1712:3: ( 'fanout' )
                    // InternalDbdTextEditor.g:1712:4: 'fanout'
                    {
                    match(input,239,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getFanoutEnumLiteralDeclaration_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalDbdTextEditor.g:1716:2: ( ( 'longin' ) )
                    {
                    // InternalDbdTextEditor.g:1716:2: ( ( 'longin' ) )
                    // InternalDbdTextEditor.g:1717:3: ( 'longin' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getLonginEnumLiteralDeclaration_24()); 
                    // InternalDbdTextEditor.g:1718:3: ( 'longin' )
                    // InternalDbdTextEditor.g:1718:4: 'longin'
                    {
                    match(input,240,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getLonginEnumLiteralDeclaration_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalDbdTextEditor.g:1722:2: ( ( 'printf' ) )
                    {
                    // InternalDbdTextEditor.g:1722:2: ( ( 'printf' ) )
                    // InternalDbdTextEditor.g:1723:3: ( 'printf' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getPrintfEnumLiteralDeclaration_25()); 
                    // InternalDbdTextEditor.g:1724:3: ( 'printf' )
                    // InternalDbdTextEditor.g:1724:4: 'printf'
                    {
                    match(input,241,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getPrintfEnumLiteralDeclaration_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalDbdTextEditor.g:1728:2: ( ( 'sel' ) )
                    {
                    // InternalDbdTextEditor.g:1728:2: ( ( 'sel' ) )
                    // InternalDbdTextEditor.g:1729:3: ( 'sel' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getSelEnumLiteralDeclaration_26()); 
                    // InternalDbdTextEditor.g:1730:3: ( 'sel' )
                    // InternalDbdTextEditor.g:1730:4: 'sel'
                    {
                    match(input,242,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getSelEnumLiteralDeclaration_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalDbdTextEditor.g:1734:2: ( ( 'bi' ) )
                    {
                    // InternalDbdTextEditor.g:1734:2: ( ( 'bi' ) )
                    // InternalDbdTextEditor.g:1735:3: ( 'bi' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getBiEnumLiteralDeclaration_27()); 
                    // InternalDbdTextEditor.g:1736:3: ( 'bi' )
                    // InternalDbdTextEditor.g:1736:4: 'bi'
                    {
                    match(input,243,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getBiEnumLiteralDeclaration_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalDbdTextEditor.g:1740:2: ( ( 'lso' ) )
                    {
                    // InternalDbdTextEditor.g:1740:2: ( ( 'lso' ) )
                    // InternalDbdTextEditor.g:1741:3: ( 'lso' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getLsoEnumLiteralDeclaration_28()); 
                    // InternalDbdTextEditor.g:1742:3: ( 'lso' )
                    // InternalDbdTextEditor.g:1742:4: 'lso'
                    {
                    match(input,244,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getLsoEnumLiteralDeclaration_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalDbdTextEditor.g:1746:2: ( ( 'subArray' ) )
                    {
                    // InternalDbdTextEditor.g:1746:2: ( ( 'subArray' ) )
                    // InternalDbdTextEditor.g:1747:3: ( 'subArray' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getSubArrayEnumLiteralDeclaration_29()); 
                    // InternalDbdTextEditor.g:1748:3: ( 'subArray' )
                    // InternalDbdTextEditor.g:1748:4: 'subArray'
                    {
                    match(input,245,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getSubArrayEnumLiteralDeclaration_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalDbdTextEditor.g:1752:2: ( ( 'calc' ) )
                    {
                    // InternalDbdTextEditor.g:1752:2: ( ( 'calc' ) )
                    // InternalDbdTextEditor.g:1753:3: ( 'calc' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getCalcEnumLiteralDeclaration_30()); 
                    // InternalDbdTextEditor.g:1754:3: ( 'calc' )
                    // InternalDbdTextEditor.g:1754:4: 'calc'
                    {
                    match(input,246,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getCalcEnumLiteralDeclaration_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalDbdTextEditor.g:1758:2: ( ( 'mbboDirect' ) )
                    {
                    // InternalDbdTextEditor.g:1758:2: ( ( 'mbboDirect' ) )
                    // InternalDbdTextEditor.g:1759:3: ( 'mbboDirect' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getMbboDirectEnumLiteralDeclaration_31()); 
                    // InternalDbdTextEditor.g:1760:3: ( 'mbboDirect' )
                    // InternalDbdTextEditor.g:1760:4: 'mbboDirect'
                    {
                    match(input,247,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getMbboDirectEnumLiteralDeclaration_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalDbdTextEditor.g:1764:2: ( ( 'longout' ) )
                    {
                    // InternalDbdTextEditor.g:1764:2: ( ( 'longout' ) )
                    // InternalDbdTextEditor.g:1765:3: ( 'longout' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getLongoutEnumLiteralDeclaration_32()); 
                    // InternalDbdTextEditor.g:1766:3: ( 'longout' )
                    // InternalDbdTextEditor.g:1766:4: 'longout'
                    {
                    match(input,248,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getLongoutEnumLiteralDeclaration_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalDbdTextEditor.g:1770:2: ( ( 'aSub' ) )
                    {
                    // InternalDbdTextEditor.g:1770:2: ( ( 'aSub' ) )
                    // InternalDbdTextEditor.g:1771:3: ( 'aSub' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getASubEnumLiteralDeclaration_33()); 
                    // InternalDbdTextEditor.g:1772:3: ( 'aSub' )
                    // InternalDbdTextEditor.g:1772:4: 'aSub'
                    {
                    match(input,249,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getASubEnumLiteralDeclaration_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalDbdTextEditor.g:1776:2: ( ( 'sub' ) )
                    {
                    // InternalDbdTextEditor.g:1776:2: ( ( 'sub' ) )
                    // InternalDbdTextEditor.g:1777:3: ( 'sub' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getSubEnumLiteralDeclaration_34()); 
                    // InternalDbdTextEditor.g:1778:3: ( 'sub' )
                    // InternalDbdTextEditor.g:1778:4: 'sub'
                    {
                    match(input,250,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getSubEnumLiteralDeclaration_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalDbdTextEditor.g:1782:2: ( ( 'int64in' ) )
                    {
                    // InternalDbdTextEditor.g:1782:2: ( ( 'int64in' ) )
                    // InternalDbdTextEditor.g:1783:3: ( 'int64in' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getInt64inEnumLiteralDeclaration_35()); 
                    // InternalDbdTextEditor.g:1784:3: ( 'int64in' )
                    // InternalDbdTextEditor.g:1784:4: 'int64in'
                    {
                    match(input,251,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getInt64inEnumLiteralDeclaration_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalDbdTextEditor.g:1788:2: ( ( 'ai' ) )
                    {
                    // InternalDbdTextEditor.g:1788:2: ( ( 'ai' ) )
                    // InternalDbdTextEditor.g:1789:3: ( 'ai' )
                    {
                     before(grammarAccess.getRecordtypenamesAccess().getAiEnumLiteralDeclaration_36()); 
                    // InternalDbdTextEditor.g:1790:3: ( 'ai' )
                    // InternalDbdTextEditor.g:1790:4: 'ai'
                    {
                    match(input,252,FOLLOW_2); 

                    }

                     after(grammarAccess.getRecordtypenamesAccess().getAiEnumLiteralDeclaration_36()); 

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
    // $ANTLR end "rule__Recordtypenames__Alternatives"


    // $ANTLR start "rule__Fieldnames__Alternatives"
    // InternalDbdTextEditor.g:1798:1: rule__Fieldnames__Alternatives : ( ( ( 'NAME' ) ) | ( ( 'DESC' ) ) | ( ( 'ASG' ) ) | ( ( 'SCAN' ) ) | ( ( 'PINI' ) ) | ( ( 'PHAS' ) ) | ( ( 'EVNT' ) ) | ( ( 'TSE' ) ) | ( ( 'TSEL' ) ) | ( ( 'DTYP' ) ) | ( ( 'DISV' ) ) | ( ( 'DISA' ) ) | ( ( 'SDIS' ) ) | ( ( 'MLOK' ) ) | ( ( 'MLIS' ) ) | ( ( 'BKLNK' ) ) | ( ( 'DISP' ) ) | ( ( 'PROC' ) ) | ( ( 'STAT' ) ) | ( ( 'SEVR' ) ) | ( ( 'NSTA' ) ) | ( ( 'NSEV' ) ) | ( ( 'ACKS' ) ) | ( ( 'ACKT' ) ) | ( ( 'DISS' ) ) | ( ( 'PACT' ) ) | ( ( 'PUTF' ) ) | ( ( 'RPRO' ) ) | ( ( 'ASP' ) ) | ( ( 'PPN' ) ) | ( ( 'PPNR' ) ) | ( ( 'SPVT' ) ) | ( ( 'RSET' ) ) | ( ( 'DSET' ) ) | ( ( 'DPVT' ) ) | ( ( 'RDES' ) ) | ( ( 'LSET' ) ) | ( ( 'PRIO' ) ) | ( ( 'TPRO' ) ) | ( ( 'BKPT' ) ) | ( ( 'UDF' ) ) | ( ( 'UDFS' ) ) | ( ( 'TIME' ) ) | ( ( 'FLNK' ) ) | ( ( 'RPVT' ) ) | ( ( 'VAL' ) ) | ( ( 'PVAL' ) ) | ( ( 'CALC' ) ) | ( ( 'CLCV' ) ) | ( ( 'INPA' ) ) | ( ( 'INPB' ) ) | ( ( 'INPC' ) ) | ( ( 'INPD' ) ) | ( ( 'INPE' ) ) | ( ( 'INPF' ) ) | ( ( 'INPG' ) ) | ( ( 'INPH' ) ) | ( ( 'INPI' ) ) | ( ( 'INPJ' ) ) | ( ( 'INPK' ) ) | ( ( 'INPL' ) ) | ( ( 'OUT' ) ) | ( ( 'INAV' ) ) | ( ( 'INBV' ) ) | ( ( 'INCV' ) ) | ( ( 'INDV' ) ) | ( ( 'INEV' ) ) | ( ( 'INFV' ) ) | ( ( 'INGV' ) ) | ( ( 'INHV' ) ) | ( ( 'INIV' ) ) | ( ( 'INJV' ) ) | ( ( 'INKV' ) ) | ( ( 'INLV' ) ) | ( ( 'OOPT' ) ) | ( ( 'DLYA' ) ) | ( ( 'DOPT' ) ) | ( ( 'OCAL' ) ) | ( ( 'OCLV' ) ) | ( ( 'OEVT' ) ) | ( ( 'EPVT' ) ) | ( ( 'IVOA' ) ) | ( ( 'IVOV' ) ) | ( ( 'PREC' ) ) | ( ( 'HOPR' ) ) | ( ( 'LOPR' ) ) | ( ( 'HIHI' ) ) | ( ( 'LOLO' ) ) | ( ( 'HIGH' ) ) | ( ( 'LOW' ) ) | ( ( 'HHSV' ) ) | ( ( 'LLSV' ) ) | ( ( 'HSV' ) ) | ( ( 'LSV' ) ) | ( ( 'HYST' ) ) | ( ( 'ADEL' ) ) | ( ( 'MDEL' ) ) | ( ( 'A' ) ) | ( ( 'B' ) ) | ( ( 'C' ) ) | ( ( 'D' ) ) | ( ( 'E' ) ) | ( ( 'F' ) ) | ( ( 'G' ) ) | ( ( 'H' ) ) | ( ( 'I' ) ) | ( ( 'J' ) ) | ( ( 'K' ) ) | ( ( 'L' ) ) | ( ( 'OVAL' ) ) | ( ( 'LA' ) ) | ( ( 'LB' ) ) | ( ( 'LC' ) ) | ( ( 'LD' ) ) | ( ( 'LE' ) ) | ( ( 'LF' ) ) | ( ( 'LG' ) ) | ( ( 'LH' ) ) | ( ( 'LI' ) ) | ( ( 'LJ' ) ) | ( ( 'LK' ) ) | ( ( 'LL' ) ) | ( ( 'POVL' ) ) | ( ( 'LALM' ) ) | ( ( 'ALST' ) ) | ( ( 'MLST' ) ) | ( ( 'RPCL' ) ) | ( ( 'ORPC' ) ) );
    public final void rule__Fieldnames__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:1802:1: ( ( ( 'NAME' ) ) | ( ( 'DESC' ) ) | ( ( 'ASG' ) ) | ( ( 'SCAN' ) ) | ( ( 'PINI' ) ) | ( ( 'PHAS' ) ) | ( ( 'EVNT' ) ) | ( ( 'TSE' ) ) | ( ( 'TSEL' ) ) | ( ( 'DTYP' ) ) | ( ( 'DISV' ) ) | ( ( 'DISA' ) ) | ( ( 'SDIS' ) ) | ( ( 'MLOK' ) ) | ( ( 'MLIS' ) ) | ( ( 'BKLNK' ) ) | ( ( 'DISP' ) ) | ( ( 'PROC' ) ) | ( ( 'STAT' ) ) | ( ( 'SEVR' ) ) | ( ( 'NSTA' ) ) | ( ( 'NSEV' ) ) | ( ( 'ACKS' ) ) | ( ( 'ACKT' ) ) | ( ( 'DISS' ) ) | ( ( 'PACT' ) ) | ( ( 'PUTF' ) ) | ( ( 'RPRO' ) ) | ( ( 'ASP' ) ) | ( ( 'PPN' ) ) | ( ( 'PPNR' ) ) | ( ( 'SPVT' ) ) | ( ( 'RSET' ) ) | ( ( 'DSET' ) ) | ( ( 'DPVT' ) ) | ( ( 'RDES' ) ) | ( ( 'LSET' ) ) | ( ( 'PRIO' ) ) | ( ( 'TPRO' ) ) | ( ( 'BKPT' ) ) | ( ( 'UDF' ) ) | ( ( 'UDFS' ) ) | ( ( 'TIME' ) ) | ( ( 'FLNK' ) ) | ( ( 'RPVT' ) ) | ( ( 'VAL' ) ) | ( ( 'PVAL' ) ) | ( ( 'CALC' ) ) | ( ( 'CLCV' ) ) | ( ( 'INPA' ) ) | ( ( 'INPB' ) ) | ( ( 'INPC' ) ) | ( ( 'INPD' ) ) | ( ( 'INPE' ) ) | ( ( 'INPF' ) ) | ( ( 'INPG' ) ) | ( ( 'INPH' ) ) | ( ( 'INPI' ) ) | ( ( 'INPJ' ) ) | ( ( 'INPK' ) ) | ( ( 'INPL' ) ) | ( ( 'OUT' ) ) | ( ( 'INAV' ) ) | ( ( 'INBV' ) ) | ( ( 'INCV' ) ) | ( ( 'INDV' ) ) | ( ( 'INEV' ) ) | ( ( 'INFV' ) ) | ( ( 'INGV' ) ) | ( ( 'INHV' ) ) | ( ( 'INIV' ) ) | ( ( 'INJV' ) ) | ( ( 'INKV' ) ) | ( ( 'INLV' ) ) | ( ( 'OOPT' ) ) | ( ( 'DLYA' ) ) | ( ( 'DOPT' ) ) | ( ( 'OCAL' ) ) | ( ( 'OCLV' ) ) | ( ( 'OEVT' ) ) | ( ( 'EPVT' ) ) | ( ( 'IVOA' ) ) | ( ( 'IVOV' ) ) | ( ( 'PREC' ) ) | ( ( 'HOPR' ) ) | ( ( 'LOPR' ) ) | ( ( 'HIHI' ) ) | ( ( 'LOLO' ) ) | ( ( 'HIGH' ) ) | ( ( 'LOW' ) ) | ( ( 'HHSV' ) ) | ( ( 'LLSV' ) ) | ( ( 'HSV' ) ) | ( ( 'LSV' ) ) | ( ( 'HYST' ) ) | ( ( 'ADEL' ) ) | ( ( 'MDEL' ) ) | ( ( 'A' ) ) | ( ( 'B' ) ) | ( ( 'C' ) ) | ( ( 'D' ) ) | ( ( 'E' ) ) | ( ( 'F' ) ) | ( ( 'G' ) ) | ( ( 'H' ) ) | ( ( 'I' ) ) | ( ( 'J' ) ) | ( ( 'K' ) ) | ( ( 'L' ) ) | ( ( 'OVAL' ) ) | ( ( 'LA' ) ) | ( ( 'LB' ) ) | ( ( 'LC' ) ) | ( ( 'LD' ) ) | ( ( 'LE' ) ) | ( ( 'LF' ) ) | ( ( 'LG' ) ) | ( ( 'LH' ) ) | ( ( 'LI' ) ) | ( ( 'LJ' ) ) | ( ( 'LK' ) ) | ( ( 'LL' ) ) | ( ( 'POVL' ) ) | ( ( 'LALM' ) ) | ( ( 'ALST' ) ) | ( ( 'MLST' ) ) | ( ( 'RPCL' ) ) | ( ( 'ORPC' ) ) )
            int alt5=128;
            switch ( input.LA(1) ) {
            case 253:
                {
                alt5=1;
                }
                break;
            case 254:
                {
                alt5=2;
                }
                break;
            case 255:
                {
                alt5=3;
                }
                break;
            case 256:
                {
                alt5=4;
                }
                break;
            case 257:
                {
                alt5=5;
                }
                break;
            case 258:
                {
                alt5=6;
                }
                break;
            case 259:
                {
                alt5=7;
                }
                break;
            case 260:
                {
                alt5=8;
                }
                break;
            case 261:
                {
                alt5=9;
                }
                break;
            case 262:
                {
                alt5=10;
                }
                break;
            case 263:
                {
                alt5=11;
                }
                break;
            case 264:
                {
                alt5=12;
                }
                break;
            case 17:
                {
                alt5=13;
                }
                break;
            case 265:
                {
                alt5=14;
                }
                break;
            case 266:
                {
                alt5=15;
                }
                break;
            case 267:
                {
                alt5=16;
                }
                break;
            case 268:
                {
                alt5=17;
                }
                break;
            case 269:
                {
                alt5=18;
                }
                break;
            case 270:
                {
                alt5=19;
                }
                break;
            case 271:
                {
                alt5=20;
                }
                break;
            case 272:
                {
                alt5=21;
                }
                break;
            case 273:
                {
                alt5=22;
                }
                break;
            case 274:
                {
                alt5=23;
                }
                break;
            case 275:
                {
                alt5=24;
                }
                break;
            case 276:
                {
                alt5=25;
                }
                break;
            case 277:
                {
                alt5=26;
                }
                break;
            case 278:
                {
                alt5=27;
                }
                break;
            case 279:
                {
                alt5=28;
                }
                break;
            case 280:
                {
                alt5=29;
                }
                break;
            case 281:
                {
                alt5=30;
                }
                break;
            case 282:
                {
                alt5=31;
                }
                break;
            case 283:
                {
                alt5=32;
                }
                break;
            case 284:
                {
                alt5=33;
                }
                break;
            case 285:
                {
                alt5=34;
                }
                break;
            case 286:
                {
                alt5=35;
                }
                break;
            case 287:
                {
                alt5=36;
                }
                break;
            case 288:
                {
                alt5=37;
                }
                break;
            case 289:
                {
                alt5=38;
                }
                break;
            case 290:
                {
                alt5=39;
                }
                break;
            case 291:
                {
                alt5=40;
                }
                break;
            case 292:
                {
                alt5=41;
                }
                break;
            case 293:
                {
                alt5=42;
                }
                break;
            case 294:
                {
                alt5=43;
                }
                break;
            case 295:
                {
                alt5=44;
                }
                break;
            case 296:
                {
                alt5=45;
                }
                break;
            case 297:
                {
                alt5=46;
                }
                break;
            case 298:
                {
                alt5=47;
                }
                break;
            case 299:
                {
                alt5=48;
                }
                break;
            case 300:
                {
                alt5=49;
                }
                break;
            case 301:
                {
                alt5=50;
                }
                break;
            case 302:
                {
                alt5=51;
                }
                break;
            case 303:
                {
                alt5=52;
                }
                break;
            case 304:
                {
                alt5=53;
                }
                break;
            case 305:
                {
                alt5=54;
                }
                break;
            case 306:
                {
                alt5=55;
                }
                break;
            case 307:
                {
                alt5=56;
                }
                break;
            case 308:
                {
                alt5=57;
                }
                break;
            case 309:
                {
                alt5=58;
                }
                break;
            case 310:
                {
                alt5=59;
                }
                break;
            case 311:
                {
                alt5=60;
                }
                break;
            case 312:
                {
                alt5=61;
                }
                break;
            case 313:
                {
                alt5=62;
                }
                break;
            case 314:
                {
                alt5=63;
                }
                break;
            case 315:
                {
                alt5=64;
                }
                break;
            case 316:
                {
                alt5=65;
                }
                break;
            case 317:
                {
                alt5=66;
                }
                break;
            case 318:
                {
                alt5=67;
                }
                break;
            case 319:
                {
                alt5=68;
                }
                break;
            case 320:
                {
                alt5=69;
                }
                break;
            case 321:
                {
                alt5=70;
                }
                break;
            case 322:
                {
                alt5=71;
                }
                break;
            case 323:
                {
                alt5=72;
                }
                break;
            case 324:
                {
                alt5=73;
                }
                break;
            case 325:
                {
                alt5=74;
                }
                break;
            case 326:
                {
                alt5=75;
                }
                break;
            case 327:
                {
                alt5=76;
                }
                break;
            case 328:
                {
                alt5=77;
                }
                break;
            case 329:
                {
                alt5=78;
                }
                break;
            case 330:
                {
                alt5=79;
                }
                break;
            case 331:
                {
                alt5=80;
                }
                break;
            case 332:
                {
                alt5=81;
                }
                break;
            case 333:
                {
                alt5=82;
                }
                break;
            case 334:
                {
                alt5=83;
                }
                break;
            case 335:
                {
                alt5=84;
                }
                break;
            case 336:
                {
                alt5=85;
                }
                break;
            case 337:
                {
                alt5=86;
                }
                break;
            case 338:
                {
                alt5=87;
                }
                break;
            case 339:
                {
                alt5=88;
                }
                break;
            case 340:
                {
                alt5=89;
                }
                break;
            case 341:
                {
                alt5=90;
                }
                break;
            case 342:
                {
                alt5=91;
                }
                break;
            case 343:
                {
                alt5=92;
                }
                break;
            case 344:
                {
                alt5=93;
                }
                break;
            case 345:
                {
                alt5=94;
                }
                break;
            case 346:
                {
                alt5=95;
                }
                break;
            case 347:
                {
                alt5=96;
                }
                break;
            case 348:
                {
                alt5=97;
                }
                break;
            case 349:
                {
                alt5=98;
                }
                break;
            case 350:
                {
                alt5=99;
                }
                break;
            case 351:
                {
                alt5=100;
                }
                break;
            case 352:
                {
                alt5=101;
                }
                break;
            case 353:
                {
                alt5=102;
                }
                break;
            case 354:
                {
                alt5=103;
                }
                break;
            case 355:
                {
                alt5=104;
                }
                break;
            case 356:
                {
                alt5=105;
                }
                break;
            case 357:
                {
                alt5=106;
                }
                break;
            case 358:
                {
                alt5=107;
                }
                break;
            case 359:
                {
                alt5=108;
                }
                break;
            case 360:
                {
                alt5=109;
                }
                break;
            case 361:
                {
                alt5=110;
                }
                break;
            case 362:
                {
                alt5=111;
                }
                break;
            case 363:
                {
                alt5=112;
                }
                break;
            case 364:
                {
                alt5=113;
                }
                break;
            case 365:
                {
                alt5=114;
                }
                break;
            case 366:
                {
                alt5=115;
                }
                break;
            case 367:
                {
                alt5=116;
                }
                break;
            case 368:
                {
                alt5=117;
                }
                break;
            case 369:
                {
                alt5=118;
                }
                break;
            case 370:
                {
                alt5=119;
                }
                break;
            case 371:
                {
                alt5=120;
                }
                break;
            case 372:
                {
                alt5=121;
                }
                break;
            case 373:
                {
                alt5=122;
                }
                break;
            case 374:
                {
                alt5=123;
                }
                break;
            case 375:
                {
                alt5=124;
                }
                break;
            case 376:
                {
                alt5=125;
                }
                break;
            case 377:
                {
                alt5=126;
                }
                break;
            case 378:
                {
                alt5=127;
                }
                break;
            case 379:
                {
                alt5=128;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalDbdTextEditor.g:1803:2: ( ( 'NAME' ) )
                    {
                    // InternalDbdTextEditor.g:1803:2: ( ( 'NAME' ) )
                    // InternalDbdTextEditor.g:1804:3: ( 'NAME' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getNAMEEnumLiteralDeclaration_0()); 
                    // InternalDbdTextEditor.g:1805:3: ( 'NAME' )
                    // InternalDbdTextEditor.g:1805:4: 'NAME'
                    {
                    match(input,253,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getNAMEEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDbdTextEditor.g:1809:2: ( ( 'DESC' ) )
                    {
                    // InternalDbdTextEditor.g:1809:2: ( ( 'DESC' ) )
                    // InternalDbdTextEditor.g:1810:3: ( 'DESC' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getDESCEnumLiteralDeclaration_1()); 
                    // InternalDbdTextEditor.g:1811:3: ( 'DESC' )
                    // InternalDbdTextEditor.g:1811:4: 'DESC'
                    {
                    match(input,254,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getDESCEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDbdTextEditor.g:1815:2: ( ( 'ASG' ) )
                    {
                    // InternalDbdTextEditor.g:1815:2: ( ( 'ASG' ) )
                    // InternalDbdTextEditor.g:1816:3: ( 'ASG' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getASGEnumLiteralDeclaration_2()); 
                    // InternalDbdTextEditor.g:1817:3: ( 'ASG' )
                    // InternalDbdTextEditor.g:1817:4: 'ASG'
                    {
                    match(input,255,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getASGEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDbdTextEditor.g:1821:2: ( ( 'SCAN' ) )
                    {
                    // InternalDbdTextEditor.g:1821:2: ( ( 'SCAN' ) )
                    // InternalDbdTextEditor.g:1822:3: ( 'SCAN' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSCANEnumLiteralDeclaration_3()); 
                    // InternalDbdTextEditor.g:1823:3: ( 'SCAN' )
                    // InternalDbdTextEditor.g:1823:4: 'SCAN'
                    {
                    match(input,256,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSCANEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDbdTextEditor.g:1827:2: ( ( 'PINI' ) )
                    {
                    // InternalDbdTextEditor.g:1827:2: ( ( 'PINI' ) )
                    // InternalDbdTextEditor.g:1828:3: ( 'PINI' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getPINIEnumLiteralDeclaration_4()); 
                    // InternalDbdTextEditor.g:1829:3: ( 'PINI' )
                    // InternalDbdTextEditor.g:1829:4: 'PINI'
                    {
                    match(input,257,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getPINIEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDbdTextEditor.g:1833:2: ( ( 'PHAS' ) )
                    {
                    // InternalDbdTextEditor.g:1833:2: ( ( 'PHAS' ) )
                    // InternalDbdTextEditor.g:1834:3: ( 'PHAS' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getPHASEnumLiteralDeclaration_5()); 
                    // InternalDbdTextEditor.g:1835:3: ( 'PHAS' )
                    // InternalDbdTextEditor.g:1835:4: 'PHAS'
                    {
                    match(input,258,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getPHASEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDbdTextEditor.g:1839:2: ( ( 'EVNT' ) )
                    {
                    // InternalDbdTextEditor.g:1839:2: ( ( 'EVNT' ) )
                    // InternalDbdTextEditor.g:1840:3: ( 'EVNT' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getEVNTEnumLiteralDeclaration_6()); 
                    // InternalDbdTextEditor.g:1841:3: ( 'EVNT' )
                    // InternalDbdTextEditor.g:1841:4: 'EVNT'
                    {
                    match(input,259,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getEVNTEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDbdTextEditor.g:1845:2: ( ( 'TSE' ) )
                    {
                    // InternalDbdTextEditor.g:1845:2: ( ( 'TSE' ) )
                    // InternalDbdTextEditor.g:1846:3: ( 'TSE' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getTSEEnumLiteralDeclaration_7()); 
                    // InternalDbdTextEditor.g:1847:3: ( 'TSE' )
                    // InternalDbdTextEditor.g:1847:4: 'TSE'
                    {
                    match(input,260,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getTSEEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDbdTextEditor.g:1851:2: ( ( 'TSEL' ) )
                    {
                    // InternalDbdTextEditor.g:1851:2: ( ( 'TSEL' ) )
                    // InternalDbdTextEditor.g:1852:3: ( 'TSEL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getTSELEnumLiteralDeclaration_8()); 
                    // InternalDbdTextEditor.g:1853:3: ( 'TSEL' )
                    // InternalDbdTextEditor.g:1853:4: 'TSEL'
                    {
                    match(input,261,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getTSELEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDbdTextEditor.g:1857:2: ( ( 'DTYP' ) )
                    {
                    // InternalDbdTextEditor.g:1857:2: ( ( 'DTYP' ) )
                    // InternalDbdTextEditor.g:1858:3: ( 'DTYP' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getDTYPEnumLiteralDeclaration_9()); 
                    // InternalDbdTextEditor.g:1859:3: ( 'DTYP' )
                    // InternalDbdTextEditor.g:1859:4: 'DTYP'
                    {
                    match(input,262,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getDTYPEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalDbdTextEditor.g:1863:2: ( ( 'DISV' ) )
                    {
                    // InternalDbdTextEditor.g:1863:2: ( ( 'DISV' ) )
                    // InternalDbdTextEditor.g:1864:3: ( 'DISV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getDISVEnumLiteralDeclaration_10()); 
                    // InternalDbdTextEditor.g:1865:3: ( 'DISV' )
                    // InternalDbdTextEditor.g:1865:4: 'DISV'
                    {
                    match(input,263,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getDISVEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalDbdTextEditor.g:1869:2: ( ( 'DISA' ) )
                    {
                    // InternalDbdTextEditor.g:1869:2: ( ( 'DISA' ) )
                    // InternalDbdTextEditor.g:1870:3: ( 'DISA' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getDISAEnumLiteralDeclaration_11()); 
                    // InternalDbdTextEditor.g:1871:3: ( 'DISA' )
                    // InternalDbdTextEditor.g:1871:4: 'DISA'
                    {
                    match(input,264,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getDISAEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalDbdTextEditor.g:1875:2: ( ( 'SDIS' ) )
                    {
                    // InternalDbdTextEditor.g:1875:2: ( ( 'SDIS' ) )
                    // InternalDbdTextEditor.g:1876:3: ( 'SDIS' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSDISEnumLiteralDeclaration_12()); 
                    // InternalDbdTextEditor.g:1877:3: ( 'SDIS' )
                    // InternalDbdTextEditor.g:1877:4: 'SDIS'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSDISEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalDbdTextEditor.g:1881:2: ( ( 'MLOK' ) )
                    {
                    // InternalDbdTextEditor.g:1881:2: ( ( 'MLOK' ) )
                    // InternalDbdTextEditor.g:1882:3: ( 'MLOK' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getMLOKEnumLiteralDeclaration_13()); 
                    // InternalDbdTextEditor.g:1883:3: ( 'MLOK' )
                    // InternalDbdTextEditor.g:1883:4: 'MLOK'
                    {
                    match(input,265,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getMLOKEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalDbdTextEditor.g:1887:2: ( ( 'MLIS' ) )
                    {
                    // InternalDbdTextEditor.g:1887:2: ( ( 'MLIS' ) )
                    // InternalDbdTextEditor.g:1888:3: ( 'MLIS' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getMLISEnumLiteralDeclaration_14()); 
                    // InternalDbdTextEditor.g:1889:3: ( 'MLIS' )
                    // InternalDbdTextEditor.g:1889:4: 'MLIS'
                    {
                    match(input,266,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getMLISEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalDbdTextEditor.g:1893:2: ( ( 'BKLNK' ) )
                    {
                    // InternalDbdTextEditor.g:1893:2: ( ( 'BKLNK' ) )
                    // InternalDbdTextEditor.g:1894:3: ( 'BKLNK' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getBKLNKEnumLiteralDeclaration_15()); 
                    // InternalDbdTextEditor.g:1895:3: ( 'BKLNK' )
                    // InternalDbdTextEditor.g:1895:4: 'BKLNK'
                    {
                    match(input,267,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getBKLNKEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalDbdTextEditor.g:1899:2: ( ( 'DISP' ) )
                    {
                    // InternalDbdTextEditor.g:1899:2: ( ( 'DISP' ) )
                    // InternalDbdTextEditor.g:1900:3: ( 'DISP' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getDISPEnumLiteralDeclaration_16()); 
                    // InternalDbdTextEditor.g:1901:3: ( 'DISP' )
                    // InternalDbdTextEditor.g:1901:4: 'DISP'
                    {
                    match(input,268,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getDISPEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalDbdTextEditor.g:1905:2: ( ( 'PROC' ) )
                    {
                    // InternalDbdTextEditor.g:1905:2: ( ( 'PROC' ) )
                    // InternalDbdTextEditor.g:1906:3: ( 'PROC' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getPROCEnumLiteralDeclaration_17()); 
                    // InternalDbdTextEditor.g:1907:3: ( 'PROC' )
                    // InternalDbdTextEditor.g:1907:4: 'PROC'
                    {
                    match(input,269,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getPROCEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalDbdTextEditor.g:1911:2: ( ( 'STAT' ) )
                    {
                    // InternalDbdTextEditor.g:1911:2: ( ( 'STAT' ) )
                    // InternalDbdTextEditor.g:1912:3: ( 'STAT' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSTATEnumLiteralDeclaration_18()); 
                    // InternalDbdTextEditor.g:1913:3: ( 'STAT' )
                    // InternalDbdTextEditor.g:1913:4: 'STAT'
                    {
                    match(input,270,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSTATEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalDbdTextEditor.g:1917:2: ( ( 'SEVR' ) )
                    {
                    // InternalDbdTextEditor.g:1917:2: ( ( 'SEVR' ) )
                    // InternalDbdTextEditor.g:1918:3: ( 'SEVR' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSEVREnumLiteralDeclaration_19()); 
                    // InternalDbdTextEditor.g:1919:3: ( 'SEVR' )
                    // InternalDbdTextEditor.g:1919:4: 'SEVR'
                    {
                    match(input,271,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSEVREnumLiteralDeclaration_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalDbdTextEditor.g:1923:2: ( ( 'NSTA' ) )
                    {
                    // InternalDbdTextEditor.g:1923:2: ( ( 'NSTA' ) )
                    // InternalDbdTextEditor.g:1924:3: ( 'NSTA' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getNSTAEnumLiteralDeclaration_20()); 
                    // InternalDbdTextEditor.g:1925:3: ( 'NSTA' )
                    // InternalDbdTextEditor.g:1925:4: 'NSTA'
                    {
                    match(input,272,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getNSTAEnumLiteralDeclaration_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalDbdTextEditor.g:1929:2: ( ( 'NSEV' ) )
                    {
                    // InternalDbdTextEditor.g:1929:2: ( ( 'NSEV' ) )
                    // InternalDbdTextEditor.g:1930:3: ( 'NSEV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getNSEVEnumLiteralDeclaration_21()); 
                    // InternalDbdTextEditor.g:1931:3: ( 'NSEV' )
                    // InternalDbdTextEditor.g:1931:4: 'NSEV'
                    {
                    match(input,273,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getNSEVEnumLiteralDeclaration_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalDbdTextEditor.g:1935:2: ( ( 'ACKS' ) )
                    {
                    // InternalDbdTextEditor.g:1935:2: ( ( 'ACKS' ) )
                    // InternalDbdTextEditor.g:1936:3: ( 'ACKS' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getACKSEnumLiteralDeclaration_22()); 
                    // InternalDbdTextEditor.g:1937:3: ( 'ACKS' )
                    // InternalDbdTextEditor.g:1937:4: 'ACKS'
                    {
                    match(input,274,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getACKSEnumLiteralDeclaration_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalDbdTextEditor.g:1941:2: ( ( 'ACKT' ) )
                    {
                    // InternalDbdTextEditor.g:1941:2: ( ( 'ACKT' ) )
                    // InternalDbdTextEditor.g:1942:3: ( 'ACKT' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getACKTEnumLiteralDeclaration_23()); 
                    // InternalDbdTextEditor.g:1943:3: ( 'ACKT' )
                    // InternalDbdTextEditor.g:1943:4: 'ACKT'
                    {
                    match(input,275,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getACKTEnumLiteralDeclaration_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalDbdTextEditor.g:1947:2: ( ( 'DISS' ) )
                    {
                    // InternalDbdTextEditor.g:1947:2: ( ( 'DISS' ) )
                    // InternalDbdTextEditor.g:1948:3: ( 'DISS' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getDISSEnumLiteralDeclaration_24()); 
                    // InternalDbdTextEditor.g:1949:3: ( 'DISS' )
                    // InternalDbdTextEditor.g:1949:4: 'DISS'
                    {
                    match(input,276,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getDISSEnumLiteralDeclaration_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalDbdTextEditor.g:1953:2: ( ( 'PACT' ) )
                    {
                    // InternalDbdTextEditor.g:1953:2: ( ( 'PACT' ) )
                    // InternalDbdTextEditor.g:1954:3: ( 'PACT' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getPACTEnumLiteralDeclaration_25()); 
                    // InternalDbdTextEditor.g:1955:3: ( 'PACT' )
                    // InternalDbdTextEditor.g:1955:4: 'PACT'
                    {
                    match(input,277,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getPACTEnumLiteralDeclaration_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalDbdTextEditor.g:1959:2: ( ( 'PUTF' ) )
                    {
                    // InternalDbdTextEditor.g:1959:2: ( ( 'PUTF' ) )
                    // InternalDbdTextEditor.g:1960:3: ( 'PUTF' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getPUTFEnumLiteralDeclaration_26()); 
                    // InternalDbdTextEditor.g:1961:3: ( 'PUTF' )
                    // InternalDbdTextEditor.g:1961:4: 'PUTF'
                    {
                    match(input,278,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getPUTFEnumLiteralDeclaration_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalDbdTextEditor.g:1965:2: ( ( 'RPRO' ) )
                    {
                    // InternalDbdTextEditor.g:1965:2: ( ( 'RPRO' ) )
                    // InternalDbdTextEditor.g:1966:3: ( 'RPRO' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getRPROEnumLiteralDeclaration_27()); 
                    // InternalDbdTextEditor.g:1967:3: ( 'RPRO' )
                    // InternalDbdTextEditor.g:1967:4: 'RPRO'
                    {
                    match(input,279,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getRPROEnumLiteralDeclaration_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalDbdTextEditor.g:1971:2: ( ( 'ASP' ) )
                    {
                    // InternalDbdTextEditor.g:1971:2: ( ( 'ASP' ) )
                    // InternalDbdTextEditor.g:1972:3: ( 'ASP' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getASPEnumLiteralDeclaration_28()); 
                    // InternalDbdTextEditor.g:1973:3: ( 'ASP' )
                    // InternalDbdTextEditor.g:1973:4: 'ASP'
                    {
                    match(input,280,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getASPEnumLiteralDeclaration_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalDbdTextEditor.g:1977:2: ( ( 'PPN' ) )
                    {
                    // InternalDbdTextEditor.g:1977:2: ( ( 'PPN' ) )
                    // InternalDbdTextEditor.g:1978:3: ( 'PPN' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getPPNEnumLiteralDeclaration_29()); 
                    // InternalDbdTextEditor.g:1979:3: ( 'PPN' )
                    // InternalDbdTextEditor.g:1979:4: 'PPN'
                    {
                    match(input,281,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getPPNEnumLiteralDeclaration_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalDbdTextEditor.g:1983:2: ( ( 'PPNR' ) )
                    {
                    // InternalDbdTextEditor.g:1983:2: ( ( 'PPNR' ) )
                    // InternalDbdTextEditor.g:1984:3: ( 'PPNR' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getPPNREnumLiteralDeclaration_30()); 
                    // InternalDbdTextEditor.g:1985:3: ( 'PPNR' )
                    // InternalDbdTextEditor.g:1985:4: 'PPNR'
                    {
                    match(input,282,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getPPNREnumLiteralDeclaration_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalDbdTextEditor.g:1989:2: ( ( 'SPVT' ) )
                    {
                    // InternalDbdTextEditor.g:1989:2: ( ( 'SPVT' ) )
                    // InternalDbdTextEditor.g:1990:3: ( 'SPVT' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getSPVTEnumLiteralDeclaration_31()); 
                    // InternalDbdTextEditor.g:1991:3: ( 'SPVT' )
                    // InternalDbdTextEditor.g:1991:4: 'SPVT'
                    {
                    match(input,283,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getSPVTEnumLiteralDeclaration_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalDbdTextEditor.g:1995:2: ( ( 'RSET' ) )
                    {
                    // InternalDbdTextEditor.g:1995:2: ( ( 'RSET' ) )
                    // InternalDbdTextEditor.g:1996:3: ( 'RSET' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getRSETEnumLiteralDeclaration_32()); 
                    // InternalDbdTextEditor.g:1997:3: ( 'RSET' )
                    // InternalDbdTextEditor.g:1997:4: 'RSET'
                    {
                    match(input,284,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getRSETEnumLiteralDeclaration_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalDbdTextEditor.g:2001:2: ( ( 'DSET' ) )
                    {
                    // InternalDbdTextEditor.g:2001:2: ( ( 'DSET' ) )
                    // InternalDbdTextEditor.g:2002:3: ( 'DSET' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getDSETEnumLiteralDeclaration_33()); 
                    // InternalDbdTextEditor.g:2003:3: ( 'DSET' )
                    // InternalDbdTextEditor.g:2003:4: 'DSET'
                    {
                    match(input,285,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getDSETEnumLiteralDeclaration_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalDbdTextEditor.g:2007:2: ( ( 'DPVT' ) )
                    {
                    // InternalDbdTextEditor.g:2007:2: ( ( 'DPVT' ) )
                    // InternalDbdTextEditor.g:2008:3: ( 'DPVT' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getDPVTEnumLiteralDeclaration_34()); 
                    // InternalDbdTextEditor.g:2009:3: ( 'DPVT' )
                    // InternalDbdTextEditor.g:2009:4: 'DPVT'
                    {
                    match(input,286,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getDPVTEnumLiteralDeclaration_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalDbdTextEditor.g:2013:2: ( ( 'RDES' ) )
                    {
                    // InternalDbdTextEditor.g:2013:2: ( ( 'RDES' ) )
                    // InternalDbdTextEditor.g:2014:3: ( 'RDES' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getRDESEnumLiteralDeclaration_35()); 
                    // InternalDbdTextEditor.g:2015:3: ( 'RDES' )
                    // InternalDbdTextEditor.g:2015:4: 'RDES'
                    {
                    match(input,287,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getRDESEnumLiteralDeclaration_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalDbdTextEditor.g:2019:2: ( ( 'LSET' ) )
                    {
                    // InternalDbdTextEditor.g:2019:2: ( ( 'LSET' ) )
                    // InternalDbdTextEditor.g:2020:3: ( 'LSET' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLSETEnumLiteralDeclaration_36()); 
                    // InternalDbdTextEditor.g:2021:3: ( 'LSET' )
                    // InternalDbdTextEditor.g:2021:4: 'LSET'
                    {
                    match(input,288,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLSETEnumLiteralDeclaration_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalDbdTextEditor.g:2025:2: ( ( 'PRIO' ) )
                    {
                    // InternalDbdTextEditor.g:2025:2: ( ( 'PRIO' ) )
                    // InternalDbdTextEditor.g:2026:3: ( 'PRIO' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getPRIOEnumLiteralDeclaration_37()); 
                    // InternalDbdTextEditor.g:2027:3: ( 'PRIO' )
                    // InternalDbdTextEditor.g:2027:4: 'PRIO'
                    {
                    match(input,289,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getPRIOEnumLiteralDeclaration_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalDbdTextEditor.g:2031:2: ( ( 'TPRO' ) )
                    {
                    // InternalDbdTextEditor.g:2031:2: ( ( 'TPRO' ) )
                    // InternalDbdTextEditor.g:2032:3: ( 'TPRO' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getTPROEnumLiteralDeclaration_38()); 
                    // InternalDbdTextEditor.g:2033:3: ( 'TPRO' )
                    // InternalDbdTextEditor.g:2033:4: 'TPRO'
                    {
                    match(input,290,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getTPROEnumLiteralDeclaration_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalDbdTextEditor.g:2037:2: ( ( 'BKPT' ) )
                    {
                    // InternalDbdTextEditor.g:2037:2: ( ( 'BKPT' ) )
                    // InternalDbdTextEditor.g:2038:3: ( 'BKPT' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getBKPTEnumLiteralDeclaration_39()); 
                    // InternalDbdTextEditor.g:2039:3: ( 'BKPT' )
                    // InternalDbdTextEditor.g:2039:4: 'BKPT'
                    {
                    match(input,291,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getBKPTEnumLiteralDeclaration_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalDbdTextEditor.g:2043:2: ( ( 'UDF' ) )
                    {
                    // InternalDbdTextEditor.g:2043:2: ( ( 'UDF' ) )
                    // InternalDbdTextEditor.g:2044:3: ( 'UDF' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getUDFEnumLiteralDeclaration_40()); 
                    // InternalDbdTextEditor.g:2045:3: ( 'UDF' )
                    // InternalDbdTextEditor.g:2045:4: 'UDF'
                    {
                    match(input,292,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getUDFEnumLiteralDeclaration_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalDbdTextEditor.g:2049:2: ( ( 'UDFS' ) )
                    {
                    // InternalDbdTextEditor.g:2049:2: ( ( 'UDFS' ) )
                    // InternalDbdTextEditor.g:2050:3: ( 'UDFS' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getUDFSEnumLiteralDeclaration_41()); 
                    // InternalDbdTextEditor.g:2051:3: ( 'UDFS' )
                    // InternalDbdTextEditor.g:2051:4: 'UDFS'
                    {
                    match(input,293,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getUDFSEnumLiteralDeclaration_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalDbdTextEditor.g:2055:2: ( ( 'TIME' ) )
                    {
                    // InternalDbdTextEditor.g:2055:2: ( ( 'TIME' ) )
                    // InternalDbdTextEditor.g:2056:3: ( 'TIME' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getTIMEEnumLiteralDeclaration_42()); 
                    // InternalDbdTextEditor.g:2057:3: ( 'TIME' )
                    // InternalDbdTextEditor.g:2057:4: 'TIME'
                    {
                    match(input,294,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getTIMEEnumLiteralDeclaration_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalDbdTextEditor.g:2061:2: ( ( 'FLNK' ) )
                    {
                    // InternalDbdTextEditor.g:2061:2: ( ( 'FLNK' ) )
                    // InternalDbdTextEditor.g:2062:3: ( 'FLNK' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getFLNKEnumLiteralDeclaration_43()); 
                    // InternalDbdTextEditor.g:2063:3: ( 'FLNK' )
                    // InternalDbdTextEditor.g:2063:4: 'FLNK'
                    {
                    match(input,295,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getFLNKEnumLiteralDeclaration_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalDbdTextEditor.g:2067:2: ( ( 'RPVT' ) )
                    {
                    // InternalDbdTextEditor.g:2067:2: ( ( 'RPVT' ) )
                    // InternalDbdTextEditor.g:2068:3: ( 'RPVT' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getRPVTEnumLiteralDeclaration_44()); 
                    // InternalDbdTextEditor.g:2069:3: ( 'RPVT' )
                    // InternalDbdTextEditor.g:2069:4: 'RPVT'
                    {
                    match(input,296,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getRPVTEnumLiteralDeclaration_44()); 

                    }


                    }
                    break;
                case 46 :
                    // InternalDbdTextEditor.g:2073:2: ( ( 'VAL' ) )
                    {
                    // InternalDbdTextEditor.g:2073:2: ( ( 'VAL' ) )
                    // InternalDbdTextEditor.g:2074:3: ( 'VAL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getVALEnumLiteralDeclaration_45()); 
                    // InternalDbdTextEditor.g:2075:3: ( 'VAL' )
                    // InternalDbdTextEditor.g:2075:4: 'VAL'
                    {
                    match(input,297,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getVALEnumLiteralDeclaration_45()); 

                    }


                    }
                    break;
                case 47 :
                    // InternalDbdTextEditor.g:2079:2: ( ( 'PVAL' ) )
                    {
                    // InternalDbdTextEditor.g:2079:2: ( ( 'PVAL' ) )
                    // InternalDbdTextEditor.g:2080:3: ( 'PVAL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getPVALEnumLiteralDeclaration_46()); 
                    // InternalDbdTextEditor.g:2081:3: ( 'PVAL' )
                    // InternalDbdTextEditor.g:2081:4: 'PVAL'
                    {
                    match(input,298,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getPVALEnumLiteralDeclaration_46()); 

                    }


                    }
                    break;
                case 48 :
                    // InternalDbdTextEditor.g:2085:2: ( ( 'CALC' ) )
                    {
                    // InternalDbdTextEditor.g:2085:2: ( ( 'CALC' ) )
                    // InternalDbdTextEditor.g:2086:3: ( 'CALC' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getCALCEnumLiteralDeclaration_47()); 
                    // InternalDbdTextEditor.g:2087:3: ( 'CALC' )
                    // InternalDbdTextEditor.g:2087:4: 'CALC'
                    {
                    match(input,299,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getCALCEnumLiteralDeclaration_47()); 

                    }


                    }
                    break;
                case 49 :
                    // InternalDbdTextEditor.g:2091:2: ( ( 'CLCV' ) )
                    {
                    // InternalDbdTextEditor.g:2091:2: ( ( 'CLCV' ) )
                    // InternalDbdTextEditor.g:2092:3: ( 'CLCV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getCLCVEnumLiteralDeclaration_48()); 
                    // InternalDbdTextEditor.g:2093:3: ( 'CLCV' )
                    // InternalDbdTextEditor.g:2093:4: 'CLCV'
                    {
                    match(input,300,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getCLCVEnumLiteralDeclaration_48()); 

                    }


                    }
                    break;
                case 50 :
                    // InternalDbdTextEditor.g:2097:2: ( ( 'INPA' ) )
                    {
                    // InternalDbdTextEditor.g:2097:2: ( ( 'INPA' ) )
                    // InternalDbdTextEditor.g:2098:3: ( 'INPA' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPAEnumLiteralDeclaration_49()); 
                    // InternalDbdTextEditor.g:2099:3: ( 'INPA' )
                    // InternalDbdTextEditor.g:2099:4: 'INPA'
                    {
                    match(input,301,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPAEnumLiteralDeclaration_49()); 

                    }


                    }
                    break;
                case 51 :
                    // InternalDbdTextEditor.g:2103:2: ( ( 'INPB' ) )
                    {
                    // InternalDbdTextEditor.g:2103:2: ( ( 'INPB' ) )
                    // InternalDbdTextEditor.g:2104:3: ( 'INPB' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPBEnumLiteralDeclaration_50()); 
                    // InternalDbdTextEditor.g:2105:3: ( 'INPB' )
                    // InternalDbdTextEditor.g:2105:4: 'INPB'
                    {
                    match(input,302,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPBEnumLiteralDeclaration_50()); 

                    }


                    }
                    break;
                case 52 :
                    // InternalDbdTextEditor.g:2109:2: ( ( 'INPC' ) )
                    {
                    // InternalDbdTextEditor.g:2109:2: ( ( 'INPC' ) )
                    // InternalDbdTextEditor.g:2110:3: ( 'INPC' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPCEnumLiteralDeclaration_51()); 
                    // InternalDbdTextEditor.g:2111:3: ( 'INPC' )
                    // InternalDbdTextEditor.g:2111:4: 'INPC'
                    {
                    match(input,303,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPCEnumLiteralDeclaration_51()); 

                    }


                    }
                    break;
                case 53 :
                    // InternalDbdTextEditor.g:2115:2: ( ( 'INPD' ) )
                    {
                    // InternalDbdTextEditor.g:2115:2: ( ( 'INPD' ) )
                    // InternalDbdTextEditor.g:2116:3: ( 'INPD' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPDEnumLiteralDeclaration_52()); 
                    // InternalDbdTextEditor.g:2117:3: ( 'INPD' )
                    // InternalDbdTextEditor.g:2117:4: 'INPD'
                    {
                    match(input,304,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPDEnumLiteralDeclaration_52()); 

                    }


                    }
                    break;
                case 54 :
                    // InternalDbdTextEditor.g:2121:2: ( ( 'INPE' ) )
                    {
                    // InternalDbdTextEditor.g:2121:2: ( ( 'INPE' ) )
                    // InternalDbdTextEditor.g:2122:3: ( 'INPE' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPEEnumLiteralDeclaration_53()); 
                    // InternalDbdTextEditor.g:2123:3: ( 'INPE' )
                    // InternalDbdTextEditor.g:2123:4: 'INPE'
                    {
                    match(input,305,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPEEnumLiteralDeclaration_53()); 

                    }


                    }
                    break;
                case 55 :
                    // InternalDbdTextEditor.g:2127:2: ( ( 'INPF' ) )
                    {
                    // InternalDbdTextEditor.g:2127:2: ( ( 'INPF' ) )
                    // InternalDbdTextEditor.g:2128:3: ( 'INPF' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPFEnumLiteralDeclaration_54()); 
                    // InternalDbdTextEditor.g:2129:3: ( 'INPF' )
                    // InternalDbdTextEditor.g:2129:4: 'INPF'
                    {
                    match(input,306,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPFEnumLiteralDeclaration_54()); 

                    }


                    }
                    break;
                case 56 :
                    // InternalDbdTextEditor.g:2133:2: ( ( 'INPG' ) )
                    {
                    // InternalDbdTextEditor.g:2133:2: ( ( 'INPG' ) )
                    // InternalDbdTextEditor.g:2134:3: ( 'INPG' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPGEnumLiteralDeclaration_55()); 
                    // InternalDbdTextEditor.g:2135:3: ( 'INPG' )
                    // InternalDbdTextEditor.g:2135:4: 'INPG'
                    {
                    match(input,307,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPGEnumLiteralDeclaration_55()); 

                    }


                    }
                    break;
                case 57 :
                    // InternalDbdTextEditor.g:2139:2: ( ( 'INPH' ) )
                    {
                    // InternalDbdTextEditor.g:2139:2: ( ( 'INPH' ) )
                    // InternalDbdTextEditor.g:2140:3: ( 'INPH' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPHEnumLiteralDeclaration_56()); 
                    // InternalDbdTextEditor.g:2141:3: ( 'INPH' )
                    // InternalDbdTextEditor.g:2141:4: 'INPH'
                    {
                    match(input,308,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPHEnumLiteralDeclaration_56()); 

                    }


                    }
                    break;
                case 58 :
                    // InternalDbdTextEditor.g:2145:2: ( ( 'INPI' ) )
                    {
                    // InternalDbdTextEditor.g:2145:2: ( ( 'INPI' ) )
                    // InternalDbdTextEditor.g:2146:3: ( 'INPI' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPIEnumLiteralDeclaration_57()); 
                    // InternalDbdTextEditor.g:2147:3: ( 'INPI' )
                    // InternalDbdTextEditor.g:2147:4: 'INPI'
                    {
                    match(input,309,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPIEnumLiteralDeclaration_57()); 

                    }


                    }
                    break;
                case 59 :
                    // InternalDbdTextEditor.g:2151:2: ( ( 'INPJ' ) )
                    {
                    // InternalDbdTextEditor.g:2151:2: ( ( 'INPJ' ) )
                    // InternalDbdTextEditor.g:2152:3: ( 'INPJ' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPJEnumLiteralDeclaration_58()); 
                    // InternalDbdTextEditor.g:2153:3: ( 'INPJ' )
                    // InternalDbdTextEditor.g:2153:4: 'INPJ'
                    {
                    match(input,310,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPJEnumLiteralDeclaration_58()); 

                    }


                    }
                    break;
                case 60 :
                    // InternalDbdTextEditor.g:2157:2: ( ( 'INPK' ) )
                    {
                    // InternalDbdTextEditor.g:2157:2: ( ( 'INPK' ) )
                    // InternalDbdTextEditor.g:2158:3: ( 'INPK' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPKEnumLiteralDeclaration_59()); 
                    // InternalDbdTextEditor.g:2159:3: ( 'INPK' )
                    // InternalDbdTextEditor.g:2159:4: 'INPK'
                    {
                    match(input,311,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPKEnumLiteralDeclaration_59()); 

                    }


                    }
                    break;
                case 61 :
                    // InternalDbdTextEditor.g:2163:2: ( ( 'INPL' ) )
                    {
                    // InternalDbdTextEditor.g:2163:2: ( ( 'INPL' ) )
                    // InternalDbdTextEditor.g:2164:3: ( 'INPL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINPLEnumLiteralDeclaration_60()); 
                    // InternalDbdTextEditor.g:2165:3: ( 'INPL' )
                    // InternalDbdTextEditor.g:2165:4: 'INPL'
                    {
                    match(input,312,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINPLEnumLiteralDeclaration_60()); 

                    }


                    }
                    break;
                case 62 :
                    // InternalDbdTextEditor.g:2169:2: ( ( 'OUT' ) )
                    {
                    // InternalDbdTextEditor.g:2169:2: ( ( 'OUT' ) )
                    // InternalDbdTextEditor.g:2170:3: ( 'OUT' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getOUTEnumLiteralDeclaration_61()); 
                    // InternalDbdTextEditor.g:2171:3: ( 'OUT' )
                    // InternalDbdTextEditor.g:2171:4: 'OUT'
                    {
                    match(input,313,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getOUTEnumLiteralDeclaration_61()); 

                    }


                    }
                    break;
                case 63 :
                    // InternalDbdTextEditor.g:2175:2: ( ( 'INAV' ) )
                    {
                    // InternalDbdTextEditor.g:2175:2: ( ( 'INAV' ) )
                    // InternalDbdTextEditor.g:2176:3: ( 'INAV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINAVEnumLiteralDeclaration_62()); 
                    // InternalDbdTextEditor.g:2177:3: ( 'INAV' )
                    // InternalDbdTextEditor.g:2177:4: 'INAV'
                    {
                    match(input,314,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINAVEnumLiteralDeclaration_62()); 

                    }


                    }
                    break;
                case 64 :
                    // InternalDbdTextEditor.g:2181:2: ( ( 'INBV' ) )
                    {
                    // InternalDbdTextEditor.g:2181:2: ( ( 'INBV' ) )
                    // InternalDbdTextEditor.g:2182:3: ( 'INBV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINBVEnumLiteralDeclaration_63()); 
                    // InternalDbdTextEditor.g:2183:3: ( 'INBV' )
                    // InternalDbdTextEditor.g:2183:4: 'INBV'
                    {
                    match(input,315,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINBVEnumLiteralDeclaration_63()); 

                    }


                    }
                    break;
                case 65 :
                    // InternalDbdTextEditor.g:2187:2: ( ( 'INCV' ) )
                    {
                    // InternalDbdTextEditor.g:2187:2: ( ( 'INCV' ) )
                    // InternalDbdTextEditor.g:2188:3: ( 'INCV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINCVEnumLiteralDeclaration_64()); 
                    // InternalDbdTextEditor.g:2189:3: ( 'INCV' )
                    // InternalDbdTextEditor.g:2189:4: 'INCV'
                    {
                    match(input,316,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINCVEnumLiteralDeclaration_64()); 

                    }


                    }
                    break;
                case 66 :
                    // InternalDbdTextEditor.g:2193:2: ( ( 'INDV' ) )
                    {
                    // InternalDbdTextEditor.g:2193:2: ( ( 'INDV' ) )
                    // InternalDbdTextEditor.g:2194:3: ( 'INDV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINDVEnumLiteralDeclaration_65()); 
                    // InternalDbdTextEditor.g:2195:3: ( 'INDV' )
                    // InternalDbdTextEditor.g:2195:4: 'INDV'
                    {
                    match(input,317,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINDVEnumLiteralDeclaration_65()); 

                    }


                    }
                    break;
                case 67 :
                    // InternalDbdTextEditor.g:2199:2: ( ( 'INEV' ) )
                    {
                    // InternalDbdTextEditor.g:2199:2: ( ( 'INEV' ) )
                    // InternalDbdTextEditor.g:2200:3: ( 'INEV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINEVEnumLiteralDeclaration_66()); 
                    // InternalDbdTextEditor.g:2201:3: ( 'INEV' )
                    // InternalDbdTextEditor.g:2201:4: 'INEV'
                    {
                    match(input,318,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINEVEnumLiteralDeclaration_66()); 

                    }


                    }
                    break;
                case 68 :
                    // InternalDbdTextEditor.g:2205:2: ( ( 'INFV' ) )
                    {
                    // InternalDbdTextEditor.g:2205:2: ( ( 'INFV' ) )
                    // InternalDbdTextEditor.g:2206:3: ( 'INFV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINFVEnumLiteralDeclaration_67()); 
                    // InternalDbdTextEditor.g:2207:3: ( 'INFV' )
                    // InternalDbdTextEditor.g:2207:4: 'INFV'
                    {
                    match(input,319,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINFVEnumLiteralDeclaration_67()); 

                    }


                    }
                    break;
                case 69 :
                    // InternalDbdTextEditor.g:2211:2: ( ( 'INGV' ) )
                    {
                    // InternalDbdTextEditor.g:2211:2: ( ( 'INGV' ) )
                    // InternalDbdTextEditor.g:2212:3: ( 'INGV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINGVEnumLiteralDeclaration_68()); 
                    // InternalDbdTextEditor.g:2213:3: ( 'INGV' )
                    // InternalDbdTextEditor.g:2213:4: 'INGV'
                    {
                    match(input,320,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINGVEnumLiteralDeclaration_68()); 

                    }


                    }
                    break;
                case 70 :
                    // InternalDbdTextEditor.g:2217:2: ( ( 'INHV' ) )
                    {
                    // InternalDbdTextEditor.g:2217:2: ( ( 'INHV' ) )
                    // InternalDbdTextEditor.g:2218:3: ( 'INHV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINHVEnumLiteralDeclaration_69()); 
                    // InternalDbdTextEditor.g:2219:3: ( 'INHV' )
                    // InternalDbdTextEditor.g:2219:4: 'INHV'
                    {
                    match(input,321,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINHVEnumLiteralDeclaration_69()); 

                    }


                    }
                    break;
                case 71 :
                    // InternalDbdTextEditor.g:2223:2: ( ( 'INIV' ) )
                    {
                    // InternalDbdTextEditor.g:2223:2: ( ( 'INIV' ) )
                    // InternalDbdTextEditor.g:2224:3: ( 'INIV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINIVEnumLiteralDeclaration_70()); 
                    // InternalDbdTextEditor.g:2225:3: ( 'INIV' )
                    // InternalDbdTextEditor.g:2225:4: 'INIV'
                    {
                    match(input,322,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINIVEnumLiteralDeclaration_70()); 

                    }


                    }
                    break;
                case 72 :
                    // InternalDbdTextEditor.g:2229:2: ( ( 'INJV' ) )
                    {
                    // InternalDbdTextEditor.g:2229:2: ( ( 'INJV' ) )
                    // InternalDbdTextEditor.g:2230:3: ( 'INJV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINJVEnumLiteralDeclaration_71()); 
                    // InternalDbdTextEditor.g:2231:3: ( 'INJV' )
                    // InternalDbdTextEditor.g:2231:4: 'INJV'
                    {
                    match(input,323,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINJVEnumLiteralDeclaration_71()); 

                    }


                    }
                    break;
                case 73 :
                    // InternalDbdTextEditor.g:2235:2: ( ( 'INKV' ) )
                    {
                    // InternalDbdTextEditor.g:2235:2: ( ( 'INKV' ) )
                    // InternalDbdTextEditor.g:2236:3: ( 'INKV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINKVEnumLiteralDeclaration_72()); 
                    // InternalDbdTextEditor.g:2237:3: ( 'INKV' )
                    // InternalDbdTextEditor.g:2237:4: 'INKV'
                    {
                    match(input,324,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINKVEnumLiteralDeclaration_72()); 

                    }


                    }
                    break;
                case 74 :
                    // InternalDbdTextEditor.g:2241:2: ( ( 'INLV' ) )
                    {
                    // InternalDbdTextEditor.g:2241:2: ( ( 'INLV' ) )
                    // InternalDbdTextEditor.g:2242:3: ( 'INLV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getINLVEnumLiteralDeclaration_73()); 
                    // InternalDbdTextEditor.g:2243:3: ( 'INLV' )
                    // InternalDbdTextEditor.g:2243:4: 'INLV'
                    {
                    match(input,325,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getINLVEnumLiteralDeclaration_73()); 

                    }


                    }
                    break;
                case 75 :
                    // InternalDbdTextEditor.g:2247:2: ( ( 'OOPT' ) )
                    {
                    // InternalDbdTextEditor.g:2247:2: ( ( 'OOPT' ) )
                    // InternalDbdTextEditor.g:2248:3: ( 'OOPT' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getOOPTEnumLiteralDeclaration_74()); 
                    // InternalDbdTextEditor.g:2249:3: ( 'OOPT' )
                    // InternalDbdTextEditor.g:2249:4: 'OOPT'
                    {
                    match(input,326,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getOOPTEnumLiteralDeclaration_74()); 

                    }


                    }
                    break;
                case 76 :
                    // InternalDbdTextEditor.g:2253:2: ( ( 'DLYA' ) )
                    {
                    // InternalDbdTextEditor.g:2253:2: ( ( 'DLYA' ) )
                    // InternalDbdTextEditor.g:2254:3: ( 'DLYA' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getDLYAEnumLiteralDeclaration_75()); 
                    // InternalDbdTextEditor.g:2255:3: ( 'DLYA' )
                    // InternalDbdTextEditor.g:2255:4: 'DLYA'
                    {
                    match(input,327,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getDLYAEnumLiteralDeclaration_75()); 

                    }


                    }
                    break;
                case 77 :
                    // InternalDbdTextEditor.g:2259:2: ( ( 'DOPT' ) )
                    {
                    // InternalDbdTextEditor.g:2259:2: ( ( 'DOPT' ) )
                    // InternalDbdTextEditor.g:2260:3: ( 'DOPT' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getDOPTEnumLiteralDeclaration_76()); 
                    // InternalDbdTextEditor.g:2261:3: ( 'DOPT' )
                    // InternalDbdTextEditor.g:2261:4: 'DOPT'
                    {
                    match(input,328,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getDOPTEnumLiteralDeclaration_76()); 

                    }


                    }
                    break;
                case 78 :
                    // InternalDbdTextEditor.g:2265:2: ( ( 'OCAL' ) )
                    {
                    // InternalDbdTextEditor.g:2265:2: ( ( 'OCAL' ) )
                    // InternalDbdTextEditor.g:2266:3: ( 'OCAL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getOCALEnumLiteralDeclaration_77()); 
                    // InternalDbdTextEditor.g:2267:3: ( 'OCAL' )
                    // InternalDbdTextEditor.g:2267:4: 'OCAL'
                    {
                    match(input,329,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getOCALEnumLiteralDeclaration_77()); 

                    }


                    }
                    break;
                case 79 :
                    // InternalDbdTextEditor.g:2271:2: ( ( 'OCLV' ) )
                    {
                    // InternalDbdTextEditor.g:2271:2: ( ( 'OCLV' ) )
                    // InternalDbdTextEditor.g:2272:3: ( 'OCLV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getOCLVEnumLiteralDeclaration_78()); 
                    // InternalDbdTextEditor.g:2273:3: ( 'OCLV' )
                    // InternalDbdTextEditor.g:2273:4: 'OCLV'
                    {
                    match(input,330,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getOCLVEnumLiteralDeclaration_78()); 

                    }


                    }
                    break;
                case 80 :
                    // InternalDbdTextEditor.g:2277:2: ( ( 'OEVT' ) )
                    {
                    // InternalDbdTextEditor.g:2277:2: ( ( 'OEVT' ) )
                    // InternalDbdTextEditor.g:2278:3: ( 'OEVT' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getOEVTEnumLiteralDeclaration_79()); 
                    // InternalDbdTextEditor.g:2279:3: ( 'OEVT' )
                    // InternalDbdTextEditor.g:2279:4: 'OEVT'
                    {
                    match(input,331,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getOEVTEnumLiteralDeclaration_79()); 

                    }


                    }
                    break;
                case 81 :
                    // InternalDbdTextEditor.g:2283:2: ( ( 'EPVT' ) )
                    {
                    // InternalDbdTextEditor.g:2283:2: ( ( 'EPVT' ) )
                    // InternalDbdTextEditor.g:2284:3: ( 'EPVT' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getEPVTEnumLiteralDeclaration_80()); 
                    // InternalDbdTextEditor.g:2285:3: ( 'EPVT' )
                    // InternalDbdTextEditor.g:2285:4: 'EPVT'
                    {
                    match(input,332,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getEPVTEnumLiteralDeclaration_80()); 

                    }


                    }
                    break;
                case 82 :
                    // InternalDbdTextEditor.g:2289:2: ( ( 'IVOA' ) )
                    {
                    // InternalDbdTextEditor.g:2289:2: ( ( 'IVOA' ) )
                    // InternalDbdTextEditor.g:2290:3: ( 'IVOA' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getIVOAEnumLiteralDeclaration_81()); 
                    // InternalDbdTextEditor.g:2291:3: ( 'IVOA' )
                    // InternalDbdTextEditor.g:2291:4: 'IVOA'
                    {
                    match(input,333,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getIVOAEnumLiteralDeclaration_81()); 

                    }


                    }
                    break;
                case 83 :
                    // InternalDbdTextEditor.g:2295:2: ( ( 'IVOV' ) )
                    {
                    // InternalDbdTextEditor.g:2295:2: ( ( 'IVOV' ) )
                    // InternalDbdTextEditor.g:2296:3: ( 'IVOV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getIVOVEnumLiteralDeclaration_82()); 
                    // InternalDbdTextEditor.g:2297:3: ( 'IVOV' )
                    // InternalDbdTextEditor.g:2297:4: 'IVOV'
                    {
                    match(input,334,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getIVOVEnumLiteralDeclaration_82()); 

                    }


                    }
                    break;
                case 84 :
                    // InternalDbdTextEditor.g:2301:2: ( ( 'PREC' ) )
                    {
                    // InternalDbdTextEditor.g:2301:2: ( ( 'PREC' ) )
                    // InternalDbdTextEditor.g:2302:3: ( 'PREC' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getPRECEnumLiteralDeclaration_83()); 
                    // InternalDbdTextEditor.g:2303:3: ( 'PREC' )
                    // InternalDbdTextEditor.g:2303:4: 'PREC'
                    {
                    match(input,335,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getPRECEnumLiteralDeclaration_83()); 

                    }


                    }
                    break;
                case 85 :
                    // InternalDbdTextEditor.g:2307:2: ( ( 'HOPR' ) )
                    {
                    // InternalDbdTextEditor.g:2307:2: ( ( 'HOPR' ) )
                    // InternalDbdTextEditor.g:2308:3: ( 'HOPR' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getHOPREnumLiteralDeclaration_84()); 
                    // InternalDbdTextEditor.g:2309:3: ( 'HOPR' )
                    // InternalDbdTextEditor.g:2309:4: 'HOPR'
                    {
                    match(input,336,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getHOPREnumLiteralDeclaration_84()); 

                    }


                    }
                    break;
                case 86 :
                    // InternalDbdTextEditor.g:2313:2: ( ( 'LOPR' ) )
                    {
                    // InternalDbdTextEditor.g:2313:2: ( ( 'LOPR' ) )
                    // InternalDbdTextEditor.g:2314:3: ( 'LOPR' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLOPREnumLiteralDeclaration_85()); 
                    // InternalDbdTextEditor.g:2315:3: ( 'LOPR' )
                    // InternalDbdTextEditor.g:2315:4: 'LOPR'
                    {
                    match(input,337,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLOPREnumLiteralDeclaration_85()); 

                    }


                    }
                    break;
                case 87 :
                    // InternalDbdTextEditor.g:2319:2: ( ( 'HIHI' ) )
                    {
                    // InternalDbdTextEditor.g:2319:2: ( ( 'HIHI' ) )
                    // InternalDbdTextEditor.g:2320:3: ( 'HIHI' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getHIHIEnumLiteralDeclaration_86()); 
                    // InternalDbdTextEditor.g:2321:3: ( 'HIHI' )
                    // InternalDbdTextEditor.g:2321:4: 'HIHI'
                    {
                    match(input,338,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getHIHIEnumLiteralDeclaration_86()); 

                    }


                    }
                    break;
                case 88 :
                    // InternalDbdTextEditor.g:2325:2: ( ( 'LOLO' ) )
                    {
                    // InternalDbdTextEditor.g:2325:2: ( ( 'LOLO' ) )
                    // InternalDbdTextEditor.g:2326:3: ( 'LOLO' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLOLOEnumLiteralDeclaration_87()); 
                    // InternalDbdTextEditor.g:2327:3: ( 'LOLO' )
                    // InternalDbdTextEditor.g:2327:4: 'LOLO'
                    {
                    match(input,339,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLOLOEnumLiteralDeclaration_87()); 

                    }


                    }
                    break;
                case 89 :
                    // InternalDbdTextEditor.g:2331:2: ( ( 'HIGH' ) )
                    {
                    // InternalDbdTextEditor.g:2331:2: ( ( 'HIGH' ) )
                    // InternalDbdTextEditor.g:2332:3: ( 'HIGH' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getHIGHEnumLiteralDeclaration_88()); 
                    // InternalDbdTextEditor.g:2333:3: ( 'HIGH' )
                    // InternalDbdTextEditor.g:2333:4: 'HIGH'
                    {
                    match(input,340,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getHIGHEnumLiteralDeclaration_88()); 

                    }


                    }
                    break;
                case 90 :
                    // InternalDbdTextEditor.g:2337:2: ( ( 'LOW' ) )
                    {
                    // InternalDbdTextEditor.g:2337:2: ( ( 'LOW' ) )
                    // InternalDbdTextEditor.g:2338:3: ( 'LOW' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLOWEnumLiteralDeclaration_89()); 
                    // InternalDbdTextEditor.g:2339:3: ( 'LOW' )
                    // InternalDbdTextEditor.g:2339:4: 'LOW'
                    {
                    match(input,341,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLOWEnumLiteralDeclaration_89()); 

                    }


                    }
                    break;
                case 91 :
                    // InternalDbdTextEditor.g:2343:2: ( ( 'HHSV' ) )
                    {
                    // InternalDbdTextEditor.g:2343:2: ( ( 'HHSV' ) )
                    // InternalDbdTextEditor.g:2344:3: ( 'HHSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getHHSVEnumLiteralDeclaration_90()); 
                    // InternalDbdTextEditor.g:2345:3: ( 'HHSV' )
                    // InternalDbdTextEditor.g:2345:4: 'HHSV'
                    {
                    match(input,342,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getHHSVEnumLiteralDeclaration_90()); 

                    }


                    }
                    break;
                case 92 :
                    // InternalDbdTextEditor.g:2349:2: ( ( 'LLSV' ) )
                    {
                    // InternalDbdTextEditor.g:2349:2: ( ( 'LLSV' ) )
                    // InternalDbdTextEditor.g:2350:3: ( 'LLSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLLSVEnumLiteralDeclaration_91()); 
                    // InternalDbdTextEditor.g:2351:3: ( 'LLSV' )
                    // InternalDbdTextEditor.g:2351:4: 'LLSV'
                    {
                    match(input,343,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLLSVEnumLiteralDeclaration_91()); 

                    }


                    }
                    break;
                case 93 :
                    // InternalDbdTextEditor.g:2355:2: ( ( 'HSV' ) )
                    {
                    // InternalDbdTextEditor.g:2355:2: ( ( 'HSV' ) )
                    // InternalDbdTextEditor.g:2356:3: ( 'HSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getHSVEnumLiteralDeclaration_92()); 
                    // InternalDbdTextEditor.g:2357:3: ( 'HSV' )
                    // InternalDbdTextEditor.g:2357:4: 'HSV'
                    {
                    match(input,344,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getHSVEnumLiteralDeclaration_92()); 

                    }


                    }
                    break;
                case 94 :
                    // InternalDbdTextEditor.g:2361:2: ( ( 'LSV' ) )
                    {
                    // InternalDbdTextEditor.g:2361:2: ( ( 'LSV' ) )
                    // InternalDbdTextEditor.g:2362:3: ( 'LSV' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLSVEnumLiteralDeclaration_93()); 
                    // InternalDbdTextEditor.g:2363:3: ( 'LSV' )
                    // InternalDbdTextEditor.g:2363:4: 'LSV'
                    {
                    match(input,345,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLSVEnumLiteralDeclaration_93()); 

                    }


                    }
                    break;
                case 95 :
                    // InternalDbdTextEditor.g:2367:2: ( ( 'HYST' ) )
                    {
                    // InternalDbdTextEditor.g:2367:2: ( ( 'HYST' ) )
                    // InternalDbdTextEditor.g:2368:3: ( 'HYST' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getHYSTEnumLiteralDeclaration_94()); 
                    // InternalDbdTextEditor.g:2369:3: ( 'HYST' )
                    // InternalDbdTextEditor.g:2369:4: 'HYST'
                    {
                    match(input,346,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getHYSTEnumLiteralDeclaration_94()); 

                    }


                    }
                    break;
                case 96 :
                    // InternalDbdTextEditor.g:2373:2: ( ( 'ADEL' ) )
                    {
                    // InternalDbdTextEditor.g:2373:2: ( ( 'ADEL' ) )
                    // InternalDbdTextEditor.g:2374:3: ( 'ADEL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getADELEnumLiteralDeclaration_95()); 
                    // InternalDbdTextEditor.g:2375:3: ( 'ADEL' )
                    // InternalDbdTextEditor.g:2375:4: 'ADEL'
                    {
                    match(input,347,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getADELEnumLiteralDeclaration_95()); 

                    }


                    }
                    break;
                case 97 :
                    // InternalDbdTextEditor.g:2379:2: ( ( 'MDEL' ) )
                    {
                    // InternalDbdTextEditor.g:2379:2: ( ( 'MDEL' ) )
                    // InternalDbdTextEditor.g:2380:3: ( 'MDEL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getMDELEnumLiteralDeclaration_96()); 
                    // InternalDbdTextEditor.g:2381:3: ( 'MDEL' )
                    // InternalDbdTextEditor.g:2381:4: 'MDEL'
                    {
                    match(input,348,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getMDELEnumLiteralDeclaration_96()); 

                    }


                    }
                    break;
                case 98 :
                    // InternalDbdTextEditor.g:2385:2: ( ( 'A' ) )
                    {
                    // InternalDbdTextEditor.g:2385:2: ( ( 'A' ) )
                    // InternalDbdTextEditor.g:2386:3: ( 'A' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getAEnumLiteralDeclaration_97()); 
                    // InternalDbdTextEditor.g:2387:3: ( 'A' )
                    // InternalDbdTextEditor.g:2387:4: 'A'
                    {
                    match(input,349,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getAEnumLiteralDeclaration_97()); 

                    }


                    }
                    break;
                case 99 :
                    // InternalDbdTextEditor.g:2391:2: ( ( 'B' ) )
                    {
                    // InternalDbdTextEditor.g:2391:2: ( ( 'B' ) )
                    // InternalDbdTextEditor.g:2392:3: ( 'B' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getBEnumLiteralDeclaration_98()); 
                    // InternalDbdTextEditor.g:2393:3: ( 'B' )
                    // InternalDbdTextEditor.g:2393:4: 'B'
                    {
                    match(input,350,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getBEnumLiteralDeclaration_98()); 

                    }


                    }
                    break;
                case 100 :
                    // InternalDbdTextEditor.g:2397:2: ( ( 'C' ) )
                    {
                    // InternalDbdTextEditor.g:2397:2: ( ( 'C' ) )
                    // InternalDbdTextEditor.g:2398:3: ( 'C' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getCEnumLiteralDeclaration_99()); 
                    // InternalDbdTextEditor.g:2399:3: ( 'C' )
                    // InternalDbdTextEditor.g:2399:4: 'C'
                    {
                    match(input,351,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getCEnumLiteralDeclaration_99()); 

                    }


                    }
                    break;
                case 101 :
                    // InternalDbdTextEditor.g:2403:2: ( ( 'D' ) )
                    {
                    // InternalDbdTextEditor.g:2403:2: ( ( 'D' ) )
                    // InternalDbdTextEditor.g:2404:3: ( 'D' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getDEnumLiteralDeclaration_100()); 
                    // InternalDbdTextEditor.g:2405:3: ( 'D' )
                    // InternalDbdTextEditor.g:2405:4: 'D'
                    {
                    match(input,352,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getDEnumLiteralDeclaration_100()); 

                    }


                    }
                    break;
                case 102 :
                    // InternalDbdTextEditor.g:2409:2: ( ( 'E' ) )
                    {
                    // InternalDbdTextEditor.g:2409:2: ( ( 'E' ) )
                    // InternalDbdTextEditor.g:2410:3: ( 'E' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getEEnumLiteralDeclaration_101()); 
                    // InternalDbdTextEditor.g:2411:3: ( 'E' )
                    // InternalDbdTextEditor.g:2411:4: 'E'
                    {
                    match(input,353,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getEEnumLiteralDeclaration_101()); 

                    }


                    }
                    break;
                case 103 :
                    // InternalDbdTextEditor.g:2415:2: ( ( 'F' ) )
                    {
                    // InternalDbdTextEditor.g:2415:2: ( ( 'F' ) )
                    // InternalDbdTextEditor.g:2416:3: ( 'F' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getFEnumLiteralDeclaration_102()); 
                    // InternalDbdTextEditor.g:2417:3: ( 'F' )
                    // InternalDbdTextEditor.g:2417:4: 'F'
                    {
                    match(input,354,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getFEnumLiteralDeclaration_102()); 

                    }


                    }
                    break;
                case 104 :
                    // InternalDbdTextEditor.g:2421:2: ( ( 'G' ) )
                    {
                    // InternalDbdTextEditor.g:2421:2: ( ( 'G' ) )
                    // InternalDbdTextEditor.g:2422:3: ( 'G' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getGEnumLiteralDeclaration_103()); 
                    // InternalDbdTextEditor.g:2423:3: ( 'G' )
                    // InternalDbdTextEditor.g:2423:4: 'G'
                    {
                    match(input,355,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getGEnumLiteralDeclaration_103()); 

                    }


                    }
                    break;
                case 105 :
                    // InternalDbdTextEditor.g:2427:2: ( ( 'H' ) )
                    {
                    // InternalDbdTextEditor.g:2427:2: ( ( 'H' ) )
                    // InternalDbdTextEditor.g:2428:3: ( 'H' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getHEnumLiteralDeclaration_104()); 
                    // InternalDbdTextEditor.g:2429:3: ( 'H' )
                    // InternalDbdTextEditor.g:2429:4: 'H'
                    {
                    match(input,356,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getHEnumLiteralDeclaration_104()); 

                    }


                    }
                    break;
                case 106 :
                    // InternalDbdTextEditor.g:2433:2: ( ( 'I' ) )
                    {
                    // InternalDbdTextEditor.g:2433:2: ( ( 'I' ) )
                    // InternalDbdTextEditor.g:2434:3: ( 'I' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getIEnumLiteralDeclaration_105()); 
                    // InternalDbdTextEditor.g:2435:3: ( 'I' )
                    // InternalDbdTextEditor.g:2435:4: 'I'
                    {
                    match(input,357,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getIEnumLiteralDeclaration_105()); 

                    }


                    }
                    break;
                case 107 :
                    // InternalDbdTextEditor.g:2439:2: ( ( 'J' ) )
                    {
                    // InternalDbdTextEditor.g:2439:2: ( ( 'J' ) )
                    // InternalDbdTextEditor.g:2440:3: ( 'J' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getJEnumLiteralDeclaration_106()); 
                    // InternalDbdTextEditor.g:2441:3: ( 'J' )
                    // InternalDbdTextEditor.g:2441:4: 'J'
                    {
                    match(input,358,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getJEnumLiteralDeclaration_106()); 

                    }


                    }
                    break;
                case 108 :
                    // InternalDbdTextEditor.g:2445:2: ( ( 'K' ) )
                    {
                    // InternalDbdTextEditor.g:2445:2: ( ( 'K' ) )
                    // InternalDbdTextEditor.g:2446:3: ( 'K' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getKEnumLiteralDeclaration_107()); 
                    // InternalDbdTextEditor.g:2447:3: ( 'K' )
                    // InternalDbdTextEditor.g:2447:4: 'K'
                    {
                    match(input,359,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getKEnumLiteralDeclaration_107()); 

                    }


                    }
                    break;
                case 109 :
                    // InternalDbdTextEditor.g:2451:2: ( ( 'L' ) )
                    {
                    // InternalDbdTextEditor.g:2451:2: ( ( 'L' ) )
                    // InternalDbdTextEditor.g:2452:3: ( 'L' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLEnumLiteralDeclaration_108()); 
                    // InternalDbdTextEditor.g:2453:3: ( 'L' )
                    // InternalDbdTextEditor.g:2453:4: 'L'
                    {
                    match(input,360,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLEnumLiteralDeclaration_108()); 

                    }


                    }
                    break;
                case 110 :
                    // InternalDbdTextEditor.g:2457:2: ( ( 'OVAL' ) )
                    {
                    // InternalDbdTextEditor.g:2457:2: ( ( 'OVAL' ) )
                    // InternalDbdTextEditor.g:2458:3: ( 'OVAL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getOVALEnumLiteralDeclaration_109()); 
                    // InternalDbdTextEditor.g:2459:3: ( 'OVAL' )
                    // InternalDbdTextEditor.g:2459:4: 'OVAL'
                    {
                    match(input,361,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getOVALEnumLiteralDeclaration_109()); 

                    }


                    }
                    break;
                case 111 :
                    // InternalDbdTextEditor.g:2463:2: ( ( 'LA' ) )
                    {
                    // InternalDbdTextEditor.g:2463:2: ( ( 'LA' ) )
                    // InternalDbdTextEditor.g:2464:3: ( 'LA' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLAEnumLiteralDeclaration_110()); 
                    // InternalDbdTextEditor.g:2465:3: ( 'LA' )
                    // InternalDbdTextEditor.g:2465:4: 'LA'
                    {
                    match(input,362,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLAEnumLiteralDeclaration_110()); 

                    }


                    }
                    break;
                case 112 :
                    // InternalDbdTextEditor.g:2469:2: ( ( 'LB' ) )
                    {
                    // InternalDbdTextEditor.g:2469:2: ( ( 'LB' ) )
                    // InternalDbdTextEditor.g:2470:3: ( 'LB' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLBEnumLiteralDeclaration_111()); 
                    // InternalDbdTextEditor.g:2471:3: ( 'LB' )
                    // InternalDbdTextEditor.g:2471:4: 'LB'
                    {
                    match(input,363,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLBEnumLiteralDeclaration_111()); 

                    }


                    }
                    break;
                case 113 :
                    // InternalDbdTextEditor.g:2475:2: ( ( 'LC' ) )
                    {
                    // InternalDbdTextEditor.g:2475:2: ( ( 'LC' ) )
                    // InternalDbdTextEditor.g:2476:3: ( 'LC' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLCEnumLiteralDeclaration_112()); 
                    // InternalDbdTextEditor.g:2477:3: ( 'LC' )
                    // InternalDbdTextEditor.g:2477:4: 'LC'
                    {
                    match(input,364,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLCEnumLiteralDeclaration_112()); 

                    }


                    }
                    break;
                case 114 :
                    // InternalDbdTextEditor.g:2481:2: ( ( 'LD' ) )
                    {
                    // InternalDbdTextEditor.g:2481:2: ( ( 'LD' ) )
                    // InternalDbdTextEditor.g:2482:3: ( 'LD' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLDEnumLiteralDeclaration_113()); 
                    // InternalDbdTextEditor.g:2483:3: ( 'LD' )
                    // InternalDbdTextEditor.g:2483:4: 'LD'
                    {
                    match(input,365,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLDEnumLiteralDeclaration_113()); 

                    }


                    }
                    break;
                case 115 :
                    // InternalDbdTextEditor.g:2487:2: ( ( 'LE' ) )
                    {
                    // InternalDbdTextEditor.g:2487:2: ( ( 'LE' ) )
                    // InternalDbdTextEditor.g:2488:3: ( 'LE' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLEEnumLiteralDeclaration_114()); 
                    // InternalDbdTextEditor.g:2489:3: ( 'LE' )
                    // InternalDbdTextEditor.g:2489:4: 'LE'
                    {
                    match(input,366,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLEEnumLiteralDeclaration_114()); 

                    }


                    }
                    break;
                case 116 :
                    // InternalDbdTextEditor.g:2493:2: ( ( 'LF' ) )
                    {
                    // InternalDbdTextEditor.g:2493:2: ( ( 'LF' ) )
                    // InternalDbdTextEditor.g:2494:3: ( 'LF' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLFEnumLiteralDeclaration_115()); 
                    // InternalDbdTextEditor.g:2495:3: ( 'LF' )
                    // InternalDbdTextEditor.g:2495:4: 'LF'
                    {
                    match(input,367,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLFEnumLiteralDeclaration_115()); 

                    }


                    }
                    break;
                case 117 :
                    // InternalDbdTextEditor.g:2499:2: ( ( 'LG' ) )
                    {
                    // InternalDbdTextEditor.g:2499:2: ( ( 'LG' ) )
                    // InternalDbdTextEditor.g:2500:3: ( 'LG' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLGEnumLiteralDeclaration_116()); 
                    // InternalDbdTextEditor.g:2501:3: ( 'LG' )
                    // InternalDbdTextEditor.g:2501:4: 'LG'
                    {
                    match(input,368,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLGEnumLiteralDeclaration_116()); 

                    }


                    }
                    break;
                case 118 :
                    // InternalDbdTextEditor.g:2505:2: ( ( 'LH' ) )
                    {
                    // InternalDbdTextEditor.g:2505:2: ( ( 'LH' ) )
                    // InternalDbdTextEditor.g:2506:3: ( 'LH' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLHEnumLiteralDeclaration_117()); 
                    // InternalDbdTextEditor.g:2507:3: ( 'LH' )
                    // InternalDbdTextEditor.g:2507:4: 'LH'
                    {
                    match(input,369,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLHEnumLiteralDeclaration_117()); 

                    }


                    }
                    break;
                case 119 :
                    // InternalDbdTextEditor.g:2511:2: ( ( 'LI' ) )
                    {
                    // InternalDbdTextEditor.g:2511:2: ( ( 'LI' ) )
                    // InternalDbdTextEditor.g:2512:3: ( 'LI' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLIEnumLiteralDeclaration_118()); 
                    // InternalDbdTextEditor.g:2513:3: ( 'LI' )
                    // InternalDbdTextEditor.g:2513:4: 'LI'
                    {
                    match(input,370,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLIEnumLiteralDeclaration_118()); 

                    }


                    }
                    break;
                case 120 :
                    // InternalDbdTextEditor.g:2517:2: ( ( 'LJ' ) )
                    {
                    // InternalDbdTextEditor.g:2517:2: ( ( 'LJ' ) )
                    // InternalDbdTextEditor.g:2518:3: ( 'LJ' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLJEnumLiteralDeclaration_119()); 
                    // InternalDbdTextEditor.g:2519:3: ( 'LJ' )
                    // InternalDbdTextEditor.g:2519:4: 'LJ'
                    {
                    match(input,371,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLJEnumLiteralDeclaration_119()); 

                    }


                    }
                    break;
                case 121 :
                    // InternalDbdTextEditor.g:2523:2: ( ( 'LK' ) )
                    {
                    // InternalDbdTextEditor.g:2523:2: ( ( 'LK' ) )
                    // InternalDbdTextEditor.g:2524:3: ( 'LK' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLKEnumLiteralDeclaration_120()); 
                    // InternalDbdTextEditor.g:2525:3: ( 'LK' )
                    // InternalDbdTextEditor.g:2525:4: 'LK'
                    {
                    match(input,372,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLKEnumLiteralDeclaration_120()); 

                    }


                    }
                    break;
                case 122 :
                    // InternalDbdTextEditor.g:2529:2: ( ( 'LL' ) )
                    {
                    // InternalDbdTextEditor.g:2529:2: ( ( 'LL' ) )
                    // InternalDbdTextEditor.g:2530:3: ( 'LL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLLEnumLiteralDeclaration_121()); 
                    // InternalDbdTextEditor.g:2531:3: ( 'LL' )
                    // InternalDbdTextEditor.g:2531:4: 'LL'
                    {
                    match(input,373,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLLEnumLiteralDeclaration_121()); 

                    }


                    }
                    break;
                case 123 :
                    // InternalDbdTextEditor.g:2535:2: ( ( 'POVL' ) )
                    {
                    // InternalDbdTextEditor.g:2535:2: ( ( 'POVL' ) )
                    // InternalDbdTextEditor.g:2536:3: ( 'POVL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getPOVLEnumLiteralDeclaration_122()); 
                    // InternalDbdTextEditor.g:2537:3: ( 'POVL' )
                    // InternalDbdTextEditor.g:2537:4: 'POVL'
                    {
                    match(input,374,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getPOVLEnumLiteralDeclaration_122()); 

                    }


                    }
                    break;
                case 124 :
                    // InternalDbdTextEditor.g:2541:2: ( ( 'LALM' ) )
                    {
                    // InternalDbdTextEditor.g:2541:2: ( ( 'LALM' ) )
                    // InternalDbdTextEditor.g:2542:3: ( 'LALM' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getLALMEnumLiteralDeclaration_123()); 
                    // InternalDbdTextEditor.g:2543:3: ( 'LALM' )
                    // InternalDbdTextEditor.g:2543:4: 'LALM'
                    {
                    match(input,375,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getLALMEnumLiteralDeclaration_123()); 

                    }


                    }
                    break;
                case 125 :
                    // InternalDbdTextEditor.g:2547:2: ( ( 'ALST' ) )
                    {
                    // InternalDbdTextEditor.g:2547:2: ( ( 'ALST' ) )
                    // InternalDbdTextEditor.g:2548:3: ( 'ALST' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getALSTEnumLiteralDeclaration_124()); 
                    // InternalDbdTextEditor.g:2549:3: ( 'ALST' )
                    // InternalDbdTextEditor.g:2549:4: 'ALST'
                    {
                    match(input,376,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getALSTEnumLiteralDeclaration_124()); 

                    }


                    }
                    break;
                case 126 :
                    // InternalDbdTextEditor.g:2553:2: ( ( 'MLST' ) )
                    {
                    // InternalDbdTextEditor.g:2553:2: ( ( 'MLST' ) )
                    // InternalDbdTextEditor.g:2554:3: ( 'MLST' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getMLSTEnumLiteralDeclaration_125()); 
                    // InternalDbdTextEditor.g:2555:3: ( 'MLST' )
                    // InternalDbdTextEditor.g:2555:4: 'MLST'
                    {
                    match(input,377,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getMLSTEnumLiteralDeclaration_125()); 

                    }


                    }
                    break;
                case 127 :
                    // InternalDbdTextEditor.g:2559:2: ( ( 'RPCL' ) )
                    {
                    // InternalDbdTextEditor.g:2559:2: ( ( 'RPCL' ) )
                    // InternalDbdTextEditor.g:2560:3: ( 'RPCL' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getRPCLEnumLiteralDeclaration_126()); 
                    // InternalDbdTextEditor.g:2561:3: ( 'RPCL' )
                    // InternalDbdTextEditor.g:2561:4: 'RPCL'
                    {
                    match(input,378,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getRPCLEnumLiteralDeclaration_126()); 

                    }


                    }
                    break;
                case 128 :
                    // InternalDbdTextEditor.g:2565:2: ( ( 'ORPC' ) )
                    {
                    // InternalDbdTextEditor.g:2565:2: ( ( 'ORPC' ) )
                    // InternalDbdTextEditor.g:2566:3: ( 'ORPC' )
                    {
                     before(grammarAccess.getFieldnamesAccess().getORPCEnumLiteralDeclaration_127()); 
                    // InternalDbdTextEditor.g:2567:3: ( 'ORPC' )
                    // InternalDbdTextEditor.g:2567:4: 'ORPC'
                    {
                    match(input,379,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldnamesAccess().getORPCEnumLiteralDeclaration_127()); 

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


    // $ANTLR start "rule__Dbfnames__Alternatives"
    // InternalDbdTextEditor.g:2575:1: rule__Dbfnames__Alternatives : ( ( ( 'DBF_STRING' ) ) | ( ( 'DBF_MENU' ) ) | ( ( 'DBF_INLINK' ) ) | ( ( 'DBF_FWDLINK' ) ) | ( ( 'DBF_SHORT' ) ) | ( ( 'DBF_DEVICE' ) ) | ( ( 'DBF_NOACCESS' ) ) | ( ( 'DBF_UCHAR' ) ) | ( ( 'DBF_OUTLINK' ) ) | ( ( 'DBF_USHORT' ) ) | ( ( 'DBF_DOUBLE' ) ) | ( ( 'DBF_ULONG' ) ) | ( ( 'INT64' ) ) );
    public final void rule__Dbfnames__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2579:1: ( ( ( 'DBF_STRING' ) ) | ( ( 'DBF_MENU' ) ) | ( ( 'DBF_INLINK' ) ) | ( ( 'DBF_FWDLINK' ) ) | ( ( 'DBF_SHORT' ) ) | ( ( 'DBF_DEVICE' ) ) | ( ( 'DBF_NOACCESS' ) ) | ( ( 'DBF_UCHAR' ) ) | ( ( 'DBF_OUTLINK' ) ) | ( ( 'DBF_USHORT' ) ) | ( ( 'DBF_DOUBLE' ) ) | ( ( 'DBF_ULONG' ) ) | ( ( 'INT64' ) ) )
            int alt6=13;
            switch ( input.LA(1) ) {
            case 380:
                {
                alt6=1;
                }
                break;
            case 381:
                {
                alt6=2;
                }
                break;
            case 382:
                {
                alt6=3;
                }
                break;
            case 383:
                {
                alt6=4;
                }
                break;
            case 384:
                {
                alt6=5;
                }
                break;
            case 385:
                {
                alt6=6;
                }
                break;
            case 386:
                {
                alt6=7;
                }
                break;
            case 387:
                {
                alt6=8;
                }
                break;
            case 388:
                {
                alt6=9;
                }
                break;
            case 389:
                {
                alt6=10;
                }
                break;
            case 390:
                {
                alt6=11;
                }
                break;
            case 391:
                {
                alt6=12;
                }
                break;
            case 392:
                {
                alt6=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalDbdTextEditor.g:2580:2: ( ( 'DBF_STRING' ) )
                    {
                    // InternalDbdTextEditor.g:2580:2: ( ( 'DBF_STRING' ) )
                    // InternalDbdTextEditor.g:2581:3: ( 'DBF_STRING' )
                    {
                     before(grammarAccess.getDbfnamesAccess().getDBF_STRINGEnumLiteralDeclaration_0()); 
                    // InternalDbdTextEditor.g:2582:3: ( 'DBF_STRING' )
                    // InternalDbdTextEditor.g:2582:4: 'DBF_STRING'
                    {
                    match(input,380,FOLLOW_2); 

                    }

                     after(grammarAccess.getDbfnamesAccess().getDBF_STRINGEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDbdTextEditor.g:2586:2: ( ( 'DBF_MENU' ) )
                    {
                    // InternalDbdTextEditor.g:2586:2: ( ( 'DBF_MENU' ) )
                    // InternalDbdTextEditor.g:2587:3: ( 'DBF_MENU' )
                    {
                     before(grammarAccess.getDbfnamesAccess().getDBF_MENUEnumLiteralDeclaration_1()); 
                    // InternalDbdTextEditor.g:2588:3: ( 'DBF_MENU' )
                    // InternalDbdTextEditor.g:2588:4: 'DBF_MENU'
                    {
                    match(input,381,FOLLOW_2); 

                    }

                     after(grammarAccess.getDbfnamesAccess().getDBF_MENUEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDbdTextEditor.g:2592:2: ( ( 'DBF_INLINK' ) )
                    {
                    // InternalDbdTextEditor.g:2592:2: ( ( 'DBF_INLINK' ) )
                    // InternalDbdTextEditor.g:2593:3: ( 'DBF_INLINK' )
                    {
                     before(grammarAccess.getDbfnamesAccess().getDBF_INLINKEnumLiteralDeclaration_2()); 
                    // InternalDbdTextEditor.g:2594:3: ( 'DBF_INLINK' )
                    // InternalDbdTextEditor.g:2594:4: 'DBF_INLINK'
                    {
                    match(input,382,FOLLOW_2); 

                    }

                     after(grammarAccess.getDbfnamesAccess().getDBF_INLINKEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDbdTextEditor.g:2598:2: ( ( 'DBF_FWDLINK' ) )
                    {
                    // InternalDbdTextEditor.g:2598:2: ( ( 'DBF_FWDLINK' ) )
                    // InternalDbdTextEditor.g:2599:3: ( 'DBF_FWDLINK' )
                    {
                     before(grammarAccess.getDbfnamesAccess().getDBF_FWDLINKEnumLiteralDeclaration_3()); 
                    // InternalDbdTextEditor.g:2600:3: ( 'DBF_FWDLINK' )
                    // InternalDbdTextEditor.g:2600:4: 'DBF_FWDLINK'
                    {
                    match(input,383,FOLLOW_2); 

                    }

                     after(grammarAccess.getDbfnamesAccess().getDBF_FWDLINKEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDbdTextEditor.g:2604:2: ( ( 'DBF_SHORT' ) )
                    {
                    // InternalDbdTextEditor.g:2604:2: ( ( 'DBF_SHORT' ) )
                    // InternalDbdTextEditor.g:2605:3: ( 'DBF_SHORT' )
                    {
                     before(grammarAccess.getDbfnamesAccess().getDBF_SHORTEnumLiteralDeclaration_4()); 
                    // InternalDbdTextEditor.g:2606:3: ( 'DBF_SHORT' )
                    // InternalDbdTextEditor.g:2606:4: 'DBF_SHORT'
                    {
                    match(input,384,FOLLOW_2); 

                    }

                     after(grammarAccess.getDbfnamesAccess().getDBF_SHORTEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDbdTextEditor.g:2610:2: ( ( 'DBF_DEVICE' ) )
                    {
                    // InternalDbdTextEditor.g:2610:2: ( ( 'DBF_DEVICE' ) )
                    // InternalDbdTextEditor.g:2611:3: ( 'DBF_DEVICE' )
                    {
                     before(grammarAccess.getDbfnamesAccess().getDBF_DEVICEEnumLiteralDeclaration_5()); 
                    // InternalDbdTextEditor.g:2612:3: ( 'DBF_DEVICE' )
                    // InternalDbdTextEditor.g:2612:4: 'DBF_DEVICE'
                    {
                    match(input,385,FOLLOW_2); 

                    }

                     after(grammarAccess.getDbfnamesAccess().getDBF_DEVICEEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDbdTextEditor.g:2616:2: ( ( 'DBF_NOACCESS' ) )
                    {
                    // InternalDbdTextEditor.g:2616:2: ( ( 'DBF_NOACCESS' ) )
                    // InternalDbdTextEditor.g:2617:3: ( 'DBF_NOACCESS' )
                    {
                     before(grammarAccess.getDbfnamesAccess().getDBF_NOACCESSEnumLiteralDeclaration_6()); 
                    // InternalDbdTextEditor.g:2618:3: ( 'DBF_NOACCESS' )
                    // InternalDbdTextEditor.g:2618:4: 'DBF_NOACCESS'
                    {
                    match(input,386,FOLLOW_2); 

                    }

                     after(grammarAccess.getDbfnamesAccess().getDBF_NOACCESSEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDbdTextEditor.g:2622:2: ( ( 'DBF_UCHAR' ) )
                    {
                    // InternalDbdTextEditor.g:2622:2: ( ( 'DBF_UCHAR' ) )
                    // InternalDbdTextEditor.g:2623:3: ( 'DBF_UCHAR' )
                    {
                     before(grammarAccess.getDbfnamesAccess().getDBF_UCHAREnumLiteralDeclaration_7()); 
                    // InternalDbdTextEditor.g:2624:3: ( 'DBF_UCHAR' )
                    // InternalDbdTextEditor.g:2624:4: 'DBF_UCHAR'
                    {
                    match(input,387,FOLLOW_2); 

                    }

                     after(grammarAccess.getDbfnamesAccess().getDBF_UCHAREnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDbdTextEditor.g:2628:2: ( ( 'DBF_OUTLINK' ) )
                    {
                    // InternalDbdTextEditor.g:2628:2: ( ( 'DBF_OUTLINK' ) )
                    // InternalDbdTextEditor.g:2629:3: ( 'DBF_OUTLINK' )
                    {
                     before(grammarAccess.getDbfnamesAccess().getDBF_OUTLINKEnumLiteralDeclaration_8()); 
                    // InternalDbdTextEditor.g:2630:3: ( 'DBF_OUTLINK' )
                    // InternalDbdTextEditor.g:2630:4: 'DBF_OUTLINK'
                    {
                    match(input,388,FOLLOW_2); 

                    }

                     after(grammarAccess.getDbfnamesAccess().getDBF_OUTLINKEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDbdTextEditor.g:2634:2: ( ( 'DBF_USHORT' ) )
                    {
                    // InternalDbdTextEditor.g:2634:2: ( ( 'DBF_USHORT' ) )
                    // InternalDbdTextEditor.g:2635:3: ( 'DBF_USHORT' )
                    {
                     before(grammarAccess.getDbfnamesAccess().getDBF_USHORTEnumLiteralDeclaration_9()); 
                    // InternalDbdTextEditor.g:2636:3: ( 'DBF_USHORT' )
                    // InternalDbdTextEditor.g:2636:4: 'DBF_USHORT'
                    {
                    match(input,389,FOLLOW_2); 

                    }

                     after(grammarAccess.getDbfnamesAccess().getDBF_USHORTEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalDbdTextEditor.g:2640:2: ( ( 'DBF_DOUBLE' ) )
                    {
                    // InternalDbdTextEditor.g:2640:2: ( ( 'DBF_DOUBLE' ) )
                    // InternalDbdTextEditor.g:2641:3: ( 'DBF_DOUBLE' )
                    {
                     before(grammarAccess.getDbfnamesAccess().getDBF_DOUBLEEnumLiteralDeclaration_10()); 
                    // InternalDbdTextEditor.g:2642:3: ( 'DBF_DOUBLE' )
                    // InternalDbdTextEditor.g:2642:4: 'DBF_DOUBLE'
                    {
                    match(input,390,FOLLOW_2); 

                    }

                     after(grammarAccess.getDbfnamesAccess().getDBF_DOUBLEEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalDbdTextEditor.g:2646:2: ( ( 'DBF_ULONG' ) )
                    {
                    // InternalDbdTextEditor.g:2646:2: ( ( 'DBF_ULONG' ) )
                    // InternalDbdTextEditor.g:2647:3: ( 'DBF_ULONG' )
                    {
                     before(grammarAccess.getDbfnamesAccess().getDBF_ULONGEnumLiteralDeclaration_11()); 
                    // InternalDbdTextEditor.g:2648:3: ( 'DBF_ULONG' )
                    // InternalDbdTextEditor.g:2648:4: 'DBF_ULONG'
                    {
                    match(input,391,FOLLOW_2); 

                    }

                     after(grammarAccess.getDbfnamesAccess().getDBF_ULONGEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalDbdTextEditor.g:2652:2: ( ( 'INT64' ) )
                    {
                    // InternalDbdTextEditor.g:2652:2: ( ( 'INT64' ) )
                    // InternalDbdTextEditor.g:2653:3: ( 'INT64' )
                    {
                     before(grammarAccess.getDbfnamesAccess().getINT64EnumLiteralDeclaration_12()); 
                    // InternalDbdTextEditor.g:2654:3: ( 'INT64' )
                    // InternalDbdTextEditor.g:2654:4: 'INT64'
                    {
                    match(input,392,FOLLOW_2); 

                    }

                     after(grammarAccess.getDbfnamesAccess().getINT64EnumLiteralDeclaration_12()); 

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
    // $ANTLR end "rule__Dbfnames__Alternatives"


    // $ANTLR start "rule__Fieldattributenames__Alternatives"
    // InternalDbdTextEditor.g:2662:1: rule__Fieldattributenames__Alternatives : ( ( ( 'size' ) ) | ( ( 'prompt' ) ) | ( ( 'promptgroup' ) ) | ( ( 'menu' ) ) | ( ( 'interest' ) ) );
    public final void rule__Fieldattributenames__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2666:1: ( ( ( 'size' ) ) | ( ( 'prompt' ) ) | ( ( 'promptgroup' ) ) | ( ( 'menu' ) ) | ( ( 'interest' ) ) )
            int alt7=5;
            switch ( input.LA(1) ) {
            case 393:
                {
                alt7=1;
                }
                break;
            case 394:
                {
                alt7=2;
                }
                break;
            case 395:
                {
                alt7=3;
                }
                break;
            case 396:
                {
                alt7=4;
                }
                break;
            case 397:
                {
                alt7=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalDbdTextEditor.g:2667:2: ( ( 'size' ) )
                    {
                    // InternalDbdTextEditor.g:2667:2: ( ( 'size' ) )
                    // InternalDbdTextEditor.g:2668:3: ( 'size' )
                    {
                     before(grammarAccess.getFieldattributenamesAccess().getSizeEnumLiteralDeclaration_0()); 
                    // InternalDbdTextEditor.g:2669:3: ( 'size' )
                    // InternalDbdTextEditor.g:2669:4: 'size'
                    {
                    match(input,393,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldattributenamesAccess().getSizeEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDbdTextEditor.g:2673:2: ( ( 'prompt' ) )
                    {
                    // InternalDbdTextEditor.g:2673:2: ( ( 'prompt' ) )
                    // InternalDbdTextEditor.g:2674:3: ( 'prompt' )
                    {
                     before(grammarAccess.getFieldattributenamesAccess().getPromptEnumLiteralDeclaration_1()); 
                    // InternalDbdTextEditor.g:2675:3: ( 'prompt' )
                    // InternalDbdTextEditor.g:2675:4: 'prompt'
                    {
                    match(input,394,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldattributenamesAccess().getPromptEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDbdTextEditor.g:2679:2: ( ( 'promptgroup' ) )
                    {
                    // InternalDbdTextEditor.g:2679:2: ( ( 'promptgroup' ) )
                    // InternalDbdTextEditor.g:2680:3: ( 'promptgroup' )
                    {
                     before(grammarAccess.getFieldattributenamesAccess().getPromptgroupEnumLiteralDeclaration_2()); 
                    // InternalDbdTextEditor.g:2681:3: ( 'promptgroup' )
                    // InternalDbdTextEditor.g:2681:4: 'promptgroup'
                    {
                    match(input,395,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldattributenamesAccess().getPromptgroupEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDbdTextEditor.g:2685:2: ( ( 'menu' ) )
                    {
                    // InternalDbdTextEditor.g:2685:2: ( ( 'menu' ) )
                    // InternalDbdTextEditor.g:2686:3: ( 'menu' )
                    {
                     before(grammarAccess.getFieldattributenamesAccess().getMenuEnumLiteralDeclaration_3()); 
                    // InternalDbdTextEditor.g:2687:3: ( 'menu' )
                    // InternalDbdTextEditor.g:2687:4: 'menu'
                    {
                    match(input,396,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldattributenamesAccess().getMenuEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDbdTextEditor.g:2691:2: ( ( 'interest' ) )
                    {
                    // InternalDbdTextEditor.g:2691:2: ( ( 'interest' ) )
                    // InternalDbdTextEditor.g:2692:3: ( 'interest' )
                    {
                     before(grammarAccess.getFieldattributenamesAccess().getInterestEnumLiteralDeclaration_4()); 
                    // InternalDbdTextEditor.g:2693:3: ( 'interest' )
                    // InternalDbdTextEditor.g:2693:4: 'interest'
                    {
                    match(input,397,FOLLOW_2); 

                    }

                     after(grammarAccess.getFieldattributenamesAccess().getInterestEnumLiteralDeclaration_4()); 

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
    // $ANTLR end "rule__Fieldattributenames__Alternatives"


    // $ANTLR start "rule__DbdModel__Group__0"
    // InternalDbdTextEditor.g:2701:1: rule__DbdModel__Group__0 : rule__DbdModel__Group__0__Impl rule__DbdModel__Group__1 ;
    public final void rule__DbdModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2705:1: ( rule__DbdModel__Group__0__Impl rule__DbdModel__Group__1 )
            // InternalDbdTextEditor.g:2706:2: rule__DbdModel__Group__0__Impl rule__DbdModel__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__DbdModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DbdModel__Group__1();

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
    // $ANTLR end "rule__DbdModel__Group__0"


    // $ANTLR start "rule__DbdModel__Group__0__Impl"
    // InternalDbdTextEditor.g:2713:1: rule__DbdModel__Group__0__Impl : ( ( rule__DbdModel__MenusAssignment_0 )* ) ;
    public final void rule__DbdModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2717:1: ( ( ( rule__DbdModel__MenusAssignment_0 )* ) )
            // InternalDbdTextEditor.g:2718:1: ( ( rule__DbdModel__MenusAssignment_0 )* )
            {
            // InternalDbdTextEditor.g:2718:1: ( ( rule__DbdModel__MenusAssignment_0 )* )
            // InternalDbdTextEditor.g:2719:2: ( rule__DbdModel__MenusAssignment_0 )*
            {
             before(grammarAccess.getDbdModelAccess().getMenusAssignment_0()); 
            // InternalDbdTextEditor.g:2720:2: ( rule__DbdModel__MenusAssignment_0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==396) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalDbdTextEditor.g:2720:3: rule__DbdModel__MenusAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__DbdModel__MenusAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getDbdModelAccess().getMenusAssignment_0()); 

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
    // $ANTLR end "rule__DbdModel__Group__0__Impl"


    // $ANTLR start "rule__DbdModel__Group__1"
    // InternalDbdTextEditor.g:2728:1: rule__DbdModel__Group__1 : rule__DbdModel__Group__1__Impl ;
    public final void rule__DbdModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2732:1: ( rule__DbdModel__Group__1__Impl )
            // InternalDbdTextEditor.g:2733:2: rule__DbdModel__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DbdModel__Group__1__Impl();

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
    // $ANTLR end "rule__DbdModel__Group__1"


    // $ANTLR start "rule__DbdModel__Group__1__Impl"
    // InternalDbdTextEditor.g:2739:1: rule__DbdModel__Group__1__Impl : ( ( rule__DbdModel__RecordtypesAssignment_1 )* ) ;
    public final void rule__DbdModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2743:1: ( ( ( rule__DbdModel__RecordtypesAssignment_1 )* ) )
            // InternalDbdTextEditor.g:2744:1: ( ( rule__DbdModel__RecordtypesAssignment_1 )* )
            {
            // InternalDbdTextEditor.g:2744:1: ( ( rule__DbdModel__RecordtypesAssignment_1 )* )
            // InternalDbdTextEditor.g:2745:2: ( rule__DbdModel__RecordtypesAssignment_1 )*
            {
             before(grammarAccess.getDbdModelAccess().getRecordtypesAssignment_1()); 
            // InternalDbdTextEditor.g:2746:2: ( rule__DbdModel__RecordtypesAssignment_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==404) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalDbdTextEditor.g:2746:3: rule__DbdModel__RecordtypesAssignment_1
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__DbdModel__RecordtypesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getDbdModelAccess().getRecordtypesAssignment_1()); 

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
    // $ANTLR end "rule__DbdModel__Group__1__Impl"


    // $ANTLR start "rule__Menu__Group__0"
    // InternalDbdTextEditor.g:2755:1: rule__Menu__Group__0 : rule__Menu__Group__0__Impl rule__Menu__Group__1 ;
    public final void rule__Menu__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2759:1: ( rule__Menu__Group__0__Impl rule__Menu__Group__1 )
            // InternalDbdTextEditor.g:2760:2: rule__Menu__Group__0__Impl rule__Menu__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Menu__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Menu__Group__1();

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
    // $ANTLR end "rule__Menu__Group__0"


    // $ANTLR start "rule__Menu__Group__0__Impl"
    // InternalDbdTextEditor.g:2767:1: rule__Menu__Group__0__Impl : ( ( rule__Menu__NameAssignment_0 ) ) ;
    public final void rule__Menu__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2771:1: ( ( ( rule__Menu__NameAssignment_0 ) ) )
            // InternalDbdTextEditor.g:2772:1: ( ( rule__Menu__NameAssignment_0 ) )
            {
            // InternalDbdTextEditor.g:2772:1: ( ( rule__Menu__NameAssignment_0 ) )
            // InternalDbdTextEditor.g:2773:2: ( rule__Menu__NameAssignment_0 )
            {
             before(grammarAccess.getMenuAccess().getNameAssignment_0()); 
            // InternalDbdTextEditor.g:2774:2: ( rule__Menu__NameAssignment_0 )
            // InternalDbdTextEditor.g:2774:3: rule__Menu__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Menu__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMenuAccess().getNameAssignment_0()); 

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
    // $ANTLR end "rule__Menu__Group__0__Impl"


    // $ANTLR start "rule__Menu__Group__1"
    // InternalDbdTextEditor.g:2782:1: rule__Menu__Group__1 : rule__Menu__Group__1__Impl rule__Menu__Group__2 ;
    public final void rule__Menu__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2786:1: ( rule__Menu__Group__1__Impl rule__Menu__Group__2 )
            // InternalDbdTextEditor.g:2787:2: rule__Menu__Group__1__Impl rule__Menu__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Menu__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Menu__Group__2();

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
    // $ANTLR end "rule__Menu__Group__1"


    // $ANTLR start "rule__Menu__Group__1__Impl"
    // InternalDbdTextEditor.g:2794:1: rule__Menu__Group__1__Impl : ( '(' ) ;
    public final void rule__Menu__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2798:1: ( ( '(' ) )
            // InternalDbdTextEditor.g:2799:1: ( '(' )
            {
            // InternalDbdTextEditor.g:2799:1: ( '(' )
            // InternalDbdTextEditor.g:2800:2: '('
            {
             before(grammarAccess.getMenuAccess().getLeftParenthesisKeyword_1()); 
            match(input,398,FOLLOW_2); 
             after(grammarAccess.getMenuAccess().getLeftParenthesisKeyword_1()); 

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
    // $ANTLR end "rule__Menu__Group__1__Impl"


    // $ANTLR start "rule__Menu__Group__2"
    // InternalDbdTextEditor.g:2809:1: rule__Menu__Group__2 : rule__Menu__Group__2__Impl rule__Menu__Group__3 ;
    public final void rule__Menu__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2813:1: ( rule__Menu__Group__2__Impl rule__Menu__Group__3 )
            // InternalDbdTextEditor.g:2814:2: rule__Menu__Group__2__Impl rule__Menu__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__Menu__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Menu__Group__3();

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
    // $ANTLR end "rule__Menu__Group__2"


    // $ANTLR start "rule__Menu__Group__2__Impl"
    // InternalDbdTextEditor.g:2821:1: rule__Menu__Group__2__Impl : ( ( rule__Menu__MenunameAssignment_2 ) ) ;
    public final void rule__Menu__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2825:1: ( ( ( rule__Menu__MenunameAssignment_2 ) ) )
            // InternalDbdTextEditor.g:2826:1: ( ( rule__Menu__MenunameAssignment_2 ) )
            {
            // InternalDbdTextEditor.g:2826:1: ( ( rule__Menu__MenunameAssignment_2 ) )
            // InternalDbdTextEditor.g:2827:2: ( rule__Menu__MenunameAssignment_2 )
            {
             before(grammarAccess.getMenuAccess().getMenunameAssignment_2()); 
            // InternalDbdTextEditor.g:2828:2: ( rule__Menu__MenunameAssignment_2 )
            // InternalDbdTextEditor.g:2828:3: rule__Menu__MenunameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Menu__MenunameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMenuAccess().getMenunameAssignment_2()); 

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
    // $ANTLR end "rule__Menu__Group__2__Impl"


    // $ANTLR start "rule__Menu__Group__3"
    // InternalDbdTextEditor.g:2836:1: rule__Menu__Group__3 : rule__Menu__Group__3__Impl rule__Menu__Group__4 ;
    public final void rule__Menu__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2840:1: ( rule__Menu__Group__3__Impl rule__Menu__Group__4 )
            // InternalDbdTextEditor.g:2841:2: rule__Menu__Group__3__Impl rule__Menu__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__Menu__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Menu__Group__4();

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
    // $ANTLR end "rule__Menu__Group__3"


    // $ANTLR start "rule__Menu__Group__3__Impl"
    // InternalDbdTextEditor.g:2848:1: rule__Menu__Group__3__Impl : ( ')' ) ;
    public final void rule__Menu__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2852:1: ( ( ')' ) )
            // InternalDbdTextEditor.g:2853:1: ( ')' )
            {
            // InternalDbdTextEditor.g:2853:1: ( ')' )
            // InternalDbdTextEditor.g:2854:2: ')'
            {
             before(grammarAccess.getMenuAccess().getRightParenthesisKeyword_3()); 
            match(input,399,FOLLOW_2); 
             after(grammarAccess.getMenuAccess().getRightParenthesisKeyword_3()); 

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
    // $ANTLR end "rule__Menu__Group__3__Impl"


    // $ANTLR start "rule__Menu__Group__4"
    // InternalDbdTextEditor.g:2863:1: rule__Menu__Group__4 : rule__Menu__Group__4__Impl rule__Menu__Group__5 ;
    public final void rule__Menu__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2867:1: ( rule__Menu__Group__4__Impl rule__Menu__Group__5 )
            // InternalDbdTextEditor.g:2868:2: rule__Menu__Group__4__Impl rule__Menu__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__Menu__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Menu__Group__5();

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
    // $ANTLR end "rule__Menu__Group__4"


    // $ANTLR start "rule__Menu__Group__4__Impl"
    // InternalDbdTextEditor.g:2875:1: rule__Menu__Group__4__Impl : ( '{' ) ;
    public final void rule__Menu__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2879:1: ( ( '{' ) )
            // InternalDbdTextEditor.g:2880:1: ( '{' )
            {
            // InternalDbdTextEditor.g:2880:1: ( '{' )
            // InternalDbdTextEditor.g:2881:2: '{'
            {
             before(grammarAccess.getMenuAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,400,FOLLOW_2); 
             after(grammarAccess.getMenuAccess().getLeftCurlyBracketKeyword_4()); 

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
    // $ANTLR end "rule__Menu__Group__4__Impl"


    // $ANTLR start "rule__Menu__Group__5"
    // InternalDbdTextEditor.g:2890:1: rule__Menu__Group__5 : rule__Menu__Group__5__Impl rule__Menu__Group__6 ;
    public final void rule__Menu__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2894:1: ( rule__Menu__Group__5__Impl rule__Menu__Group__6 )
            // InternalDbdTextEditor.g:2895:2: rule__Menu__Group__5__Impl rule__Menu__Group__6
            {
            pushFollow(FOLLOW_10);
            rule__Menu__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Menu__Group__6();

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
    // $ANTLR end "rule__Menu__Group__5"


    // $ANTLR start "rule__Menu__Group__5__Impl"
    // InternalDbdTextEditor.g:2902:1: rule__Menu__Group__5__Impl : ( ( rule__Menu__ChoicesAssignment_5 )* ) ;
    public final void rule__Menu__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2906:1: ( ( ( rule__Menu__ChoicesAssignment_5 )* ) )
            // InternalDbdTextEditor.g:2907:1: ( ( rule__Menu__ChoicesAssignment_5 )* )
            {
            // InternalDbdTextEditor.g:2907:1: ( ( rule__Menu__ChoicesAssignment_5 )* )
            // InternalDbdTextEditor.g:2908:2: ( rule__Menu__ChoicesAssignment_5 )*
            {
             before(grammarAccess.getMenuAccess().getChoicesAssignment_5()); 
            // InternalDbdTextEditor.g:2909:2: ( rule__Menu__ChoicesAssignment_5 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==402) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalDbdTextEditor.g:2909:3: rule__Menu__ChoicesAssignment_5
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Menu__ChoicesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getMenuAccess().getChoicesAssignment_5()); 

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
    // $ANTLR end "rule__Menu__Group__5__Impl"


    // $ANTLR start "rule__Menu__Group__6"
    // InternalDbdTextEditor.g:2917:1: rule__Menu__Group__6 : rule__Menu__Group__6__Impl ;
    public final void rule__Menu__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2921:1: ( rule__Menu__Group__6__Impl )
            // InternalDbdTextEditor.g:2922:2: rule__Menu__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Menu__Group__6__Impl();

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
    // $ANTLR end "rule__Menu__Group__6"


    // $ANTLR start "rule__Menu__Group__6__Impl"
    // InternalDbdTextEditor.g:2928:1: rule__Menu__Group__6__Impl : ( '}' ) ;
    public final void rule__Menu__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2932:1: ( ( '}' ) )
            // InternalDbdTextEditor.g:2933:1: ( '}' )
            {
            // InternalDbdTextEditor.g:2933:1: ( '}' )
            // InternalDbdTextEditor.g:2934:2: '}'
            {
             before(grammarAccess.getMenuAccess().getRightCurlyBracketKeyword_6()); 
            match(input,401,FOLLOW_2); 
             after(grammarAccess.getMenuAccess().getRightCurlyBracketKeyword_6()); 

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
    // $ANTLR end "rule__Menu__Group__6__Impl"


    // $ANTLR start "rule__Choice__Group__0"
    // InternalDbdTextEditor.g:2944:1: rule__Choice__Group__0 : rule__Choice__Group__0__Impl rule__Choice__Group__1 ;
    public final void rule__Choice__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2948:1: ( rule__Choice__Group__0__Impl rule__Choice__Group__1 )
            // InternalDbdTextEditor.g:2949:2: rule__Choice__Group__0__Impl rule__Choice__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Choice__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Choice__Group__1();

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
    // $ANTLR end "rule__Choice__Group__0"


    // $ANTLR start "rule__Choice__Group__0__Impl"
    // InternalDbdTextEditor.g:2956:1: rule__Choice__Group__0__Impl : ( 'choice' ) ;
    public final void rule__Choice__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2960:1: ( ( 'choice' ) )
            // InternalDbdTextEditor.g:2961:1: ( 'choice' )
            {
            // InternalDbdTextEditor.g:2961:1: ( 'choice' )
            // InternalDbdTextEditor.g:2962:2: 'choice'
            {
             before(grammarAccess.getChoiceAccess().getChoiceKeyword_0()); 
            match(input,402,FOLLOW_2); 
             after(grammarAccess.getChoiceAccess().getChoiceKeyword_0()); 

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
    // $ANTLR end "rule__Choice__Group__0__Impl"


    // $ANTLR start "rule__Choice__Group__1"
    // InternalDbdTextEditor.g:2971:1: rule__Choice__Group__1 : rule__Choice__Group__1__Impl rule__Choice__Group__2 ;
    public final void rule__Choice__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2975:1: ( rule__Choice__Group__1__Impl rule__Choice__Group__2 )
            // InternalDbdTextEditor.g:2976:2: rule__Choice__Group__1__Impl rule__Choice__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__Choice__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Choice__Group__2();

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
    // $ANTLR end "rule__Choice__Group__1"


    // $ANTLR start "rule__Choice__Group__1__Impl"
    // InternalDbdTextEditor.g:2983:1: rule__Choice__Group__1__Impl : ( '(' ) ;
    public final void rule__Choice__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:2987:1: ( ( '(' ) )
            // InternalDbdTextEditor.g:2988:1: ( '(' )
            {
            // InternalDbdTextEditor.g:2988:1: ( '(' )
            // InternalDbdTextEditor.g:2989:2: '('
            {
             before(grammarAccess.getChoiceAccess().getLeftParenthesisKeyword_1()); 
            match(input,398,FOLLOW_2); 
             after(grammarAccess.getChoiceAccess().getLeftParenthesisKeyword_1()); 

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
    // $ANTLR end "rule__Choice__Group__1__Impl"


    // $ANTLR start "rule__Choice__Group__2"
    // InternalDbdTextEditor.g:2998:1: rule__Choice__Group__2 : rule__Choice__Group__2__Impl rule__Choice__Group__3 ;
    public final void rule__Choice__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3002:1: ( rule__Choice__Group__2__Impl rule__Choice__Group__3 )
            // InternalDbdTextEditor.g:3003:2: rule__Choice__Group__2__Impl rule__Choice__Group__3
            {
            pushFollow(FOLLOW_13);
            rule__Choice__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Choice__Group__3();

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
    // $ANTLR end "rule__Choice__Group__2"


    // $ANTLR start "rule__Choice__Group__2__Impl"
    // InternalDbdTextEditor.g:3010:1: rule__Choice__Group__2__Impl : ( ( rule__Choice__ChoicenameAssignment_2 ) ) ;
    public final void rule__Choice__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3014:1: ( ( ( rule__Choice__ChoicenameAssignment_2 ) ) )
            // InternalDbdTextEditor.g:3015:1: ( ( rule__Choice__ChoicenameAssignment_2 ) )
            {
            // InternalDbdTextEditor.g:3015:1: ( ( rule__Choice__ChoicenameAssignment_2 ) )
            // InternalDbdTextEditor.g:3016:2: ( rule__Choice__ChoicenameAssignment_2 )
            {
             before(grammarAccess.getChoiceAccess().getChoicenameAssignment_2()); 
            // InternalDbdTextEditor.g:3017:2: ( rule__Choice__ChoicenameAssignment_2 )
            // InternalDbdTextEditor.g:3017:3: rule__Choice__ChoicenameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Choice__ChoicenameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getChoiceAccess().getChoicenameAssignment_2()); 

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
    // $ANTLR end "rule__Choice__Group__2__Impl"


    // $ANTLR start "rule__Choice__Group__3"
    // InternalDbdTextEditor.g:3025:1: rule__Choice__Group__3 : rule__Choice__Group__3__Impl rule__Choice__Group__4 ;
    public final void rule__Choice__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3029:1: ( rule__Choice__Group__3__Impl rule__Choice__Group__4 )
            // InternalDbdTextEditor.g:3030:2: rule__Choice__Group__3__Impl rule__Choice__Group__4
            {
            pushFollow(FOLLOW_14);
            rule__Choice__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Choice__Group__4();

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
    // $ANTLR end "rule__Choice__Group__3"


    // $ANTLR start "rule__Choice__Group__3__Impl"
    // InternalDbdTextEditor.g:3037:1: rule__Choice__Group__3__Impl : ( ',' ) ;
    public final void rule__Choice__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3041:1: ( ( ',' ) )
            // InternalDbdTextEditor.g:3042:1: ( ',' )
            {
            // InternalDbdTextEditor.g:3042:1: ( ',' )
            // InternalDbdTextEditor.g:3043:2: ','
            {
             before(grammarAccess.getChoiceAccess().getCommaKeyword_3()); 
            match(input,403,FOLLOW_2); 
             after(grammarAccess.getChoiceAccess().getCommaKeyword_3()); 

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
    // $ANTLR end "rule__Choice__Group__3__Impl"


    // $ANTLR start "rule__Choice__Group__4"
    // InternalDbdTextEditor.g:3052:1: rule__Choice__Group__4 : rule__Choice__Group__4__Impl rule__Choice__Group__5 ;
    public final void rule__Choice__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3056:1: ( rule__Choice__Group__4__Impl rule__Choice__Group__5 )
            // InternalDbdTextEditor.g:3057:2: rule__Choice__Group__4__Impl rule__Choice__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__Choice__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Choice__Group__5();

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
    // $ANTLR end "rule__Choice__Group__4"


    // $ANTLR start "rule__Choice__Group__4__Impl"
    // InternalDbdTextEditor.g:3064:1: rule__Choice__Group__4__Impl : ( ( rule__Choice__ChoicestringAssignment_4 ) ) ;
    public final void rule__Choice__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3068:1: ( ( ( rule__Choice__ChoicestringAssignment_4 ) ) )
            // InternalDbdTextEditor.g:3069:1: ( ( rule__Choice__ChoicestringAssignment_4 ) )
            {
            // InternalDbdTextEditor.g:3069:1: ( ( rule__Choice__ChoicestringAssignment_4 ) )
            // InternalDbdTextEditor.g:3070:2: ( rule__Choice__ChoicestringAssignment_4 )
            {
             before(grammarAccess.getChoiceAccess().getChoicestringAssignment_4()); 
            // InternalDbdTextEditor.g:3071:2: ( rule__Choice__ChoicestringAssignment_4 )
            // InternalDbdTextEditor.g:3071:3: rule__Choice__ChoicestringAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Choice__ChoicestringAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getChoiceAccess().getChoicestringAssignment_4()); 

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
    // $ANTLR end "rule__Choice__Group__4__Impl"


    // $ANTLR start "rule__Choice__Group__5"
    // InternalDbdTextEditor.g:3079:1: rule__Choice__Group__5 : rule__Choice__Group__5__Impl ;
    public final void rule__Choice__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3083:1: ( rule__Choice__Group__5__Impl )
            // InternalDbdTextEditor.g:3084:2: rule__Choice__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Choice__Group__5__Impl();

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
    // $ANTLR end "rule__Choice__Group__5"


    // $ANTLR start "rule__Choice__Group__5__Impl"
    // InternalDbdTextEditor.g:3090:1: rule__Choice__Group__5__Impl : ( ')' ) ;
    public final void rule__Choice__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3094:1: ( ( ')' ) )
            // InternalDbdTextEditor.g:3095:1: ( ')' )
            {
            // InternalDbdTextEditor.g:3095:1: ( ')' )
            // InternalDbdTextEditor.g:3096:2: ')'
            {
             before(grammarAccess.getChoiceAccess().getRightParenthesisKeyword_5()); 
            match(input,399,FOLLOW_2); 
             after(grammarAccess.getChoiceAccess().getRightParenthesisKeyword_5()); 

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
    // $ANTLR end "rule__Choice__Group__5__Impl"


    // $ANTLR start "rule__Recordtype__Group__0"
    // InternalDbdTextEditor.g:3106:1: rule__Recordtype__Group__0 : rule__Recordtype__Group__0__Impl rule__Recordtype__Group__1 ;
    public final void rule__Recordtype__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3110:1: ( rule__Recordtype__Group__0__Impl rule__Recordtype__Group__1 )
            // InternalDbdTextEditor.g:3111:2: rule__Recordtype__Group__0__Impl rule__Recordtype__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Recordtype__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Recordtype__Group__1();

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
    // $ANTLR end "rule__Recordtype__Group__0"


    // $ANTLR start "rule__Recordtype__Group__0__Impl"
    // InternalDbdTextEditor.g:3118:1: rule__Recordtype__Group__0__Impl : ( ( rule__Recordtype__NameAssignment_0 ) ) ;
    public final void rule__Recordtype__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3122:1: ( ( ( rule__Recordtype__NameAssignment_0 ) ) )
            // InternalDbdTextEditor.g:3123:1: ( ( rule__Recordtype__NameAssignment_0 ) )
            {
            // InternalDbdTextEditor.g:3123:1: ( ( rule__Recordtype__NameAssignment_0 ) )
            // InternalDbdTextEditor.g:3124:2: ( rule__Recordtype__NameAssignment_0 )
            {
             before(grammarAccess.getRecordtypeAccess().getNameAssignment_0()); 
            // InternalDbdTextEditor.g:3125:2: ( rule__Recordtype__NameAssignment_0 )
            // InternalDbdTextEditor.g:3125:3: rule__Recordtype__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Recordtype__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRecordtypeAccess().getNameAssignment_0()); 

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
    // $ANTLR end "rule__Recordtype__Group__0__Impl"


    // $ANTLR start "rule__Recordtype__Group__1"
    // InternalDbdTextEditor.g:3133:1: rule__Recordtype__Group__1 : rule__Recordtype__Group__1__Impl rule__Recordtype__Group__2 ;
    public final void rule__Recordtype__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3137:1: ( rule__Recordtype__Group__1__Impl rule__Recordtype__Group__2 )
            // InternalDbdTextEditor.g:3138:2: rule__Recordtype__Group__1__Impl rule__Recordtype__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__Recordtype__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Recordtype__Group__2();

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
    // $ANTLR end "rule__Recordtype__Group__1"


    // $ANTLR start "rule__Recordtype__Group__1__Impl"
    // InternalDbdTextEditor.g:3145:1: rule__Recordtype__Group__1__Impl : ( '(' ) ;
    public final void rule__Recordtype__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3149:1: ( ( '(' ) )
            // InternalDbdTextEditor.g:3150:1: ( '(' )
            {
            // InternalDbdTextEditor.g:3150:1: ( '(' )
            // InternalDbdTextEditor.g:3151:2: '('
            {
             before(grammarAccess.getRecordtypeAccess().getLeftParenthesisKeyword_1()); 
            match(input,398,FOLLOW_2); 
             after(grammarAccess.getRecordtypeAccess().getLeftParenthesisKeyword_1()); 

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
    // $ANTLR end "rule__Recordtype__Group__1__Impl"


    // $ANTLR start "rule__Recordtype__Group__2"
    // InternalDbdTextEditor.g:3160:1: rule__Recordtype__Group__2 : rule__Recordtype__Group__2__Impl rule__Recordtype__Group__3 ;
    public final void rule__Recordtype__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3164:1: ( rule__Recordtype__Group__2__Impl rule__Recordtype__Group__3 )
            // InternalDbdTextEditor.g:3165:2: rule__Recordtype__Group__2__Impl rule__Recordtype__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__Recordtype__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Recordtype__Group__3();

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
    // $ANTLR end "rule__Recordtype__Group__2"


    // $ANTLR start "rule__Recordtype__Group__2__Impl"
    // InternalDbdTextEditor.g:3172:1: rule__Recordtype__Group__2__Impl : ( ( rule__Recordtype__RecordtypenameAssignment_2 ) ) ;
    public final void rule__Recordtype__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3176:1: ( ( ( rule__Recordtype__RecordtypenameAssignment_2 ) ) )
            // InternalDbdTextEditor.g:3177:1: ( ( rule__Recordtype__RecordtypenameAssignment_2 ) )
            {
            // InternalDbdTextEditor.g:3177:1: ( ( rule__Recordtype__RecordtypenameAssignment_2 ) )
            // InternalDbdTextEditor.g:3178:2: ( rule__Recordtype__RecordtypenameAssignment_2 )
            {
             before(grammarAccess.getRecordtypeAccess().getRecordtypenameAssignment_2()); 
            // InternalDbdTextEditor.g:3179:2: ( rule__Recordtype__RecordtypenameAssignment_2 )
            // InternalDbdTextEditor.g:3179:3: rule__Recordtype__RecordtypenameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Recordtype__RecordtypenameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRecordtypeAccess().getRecordtypenameAssignment_2()); 

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
    // $ANTLR end "rule__Recordtype__Group__2__Impl"


    // $ANTLR start "rule__Recordtype__Group__3"
    // InternalDbdTextEditor.g:3187:1: rule__Recordtype__Group__3 : rule__Recordtype__Group__3__Impl rule__Recordtype__Group__4 ;
    public final void rule__Recordtype__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3191:1: ( rule__Recordtype__Group__3__Impl rule__Recordtype__Group__4 )
            // InternalDbdTextEditor.g:3192:2: rule__Recordtype__Group__3__Impl rule__Recordtype__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__Recordtype__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Recordtype__Group__4();

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
    // $ANTLR end "rule__Recordtype__Group__3"


    // $ANTLR start "rule__Recordtype__Group__3__Impl"
    // InternalDbdTextEditor.g:3199:1: rule__Recordtype__Group__3__Impl : ( ')' ) ;
    public final void rule__Recordtype__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3203:1: ( ( ')' ) )
            // InternalDbdTextEditor.g:3204:1: ( ')' )
            {
            // InternalDbdTextEditor.g:3204:1: ( ')' )
            // InternalDbdTextEditor.g:3205:2: ')'
            {
             before(grammarAccess.getRecordtypeAccess().getRightParenthesisKeyword_3()); 
            match(input,399,FOLLOW_2); 
             after(grammarAccess.getRecordtypeAccess().getRightParenthesisKeyword_3()); 

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
    // $ANTLR end "rule__Recordtype__Group__3__Impl"


    // $ANTLR start "rule__Recordtype__Group__4"
    // InternalDbdTextEditor.g:3214:1: rule__Recordtype__Group__4 : rule__Recordtype__Group__4__Impl rule__Recordtype__Group__5 ;
    public final void rule__Recordtype__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3218:1: ( rule__Recordtype__Group__4__Impl rule__Recordtype__Group__5 )
            // InternalDbdTextEditor.g:3219:2: rule__Recordtype__Group__4__Impl rule__Recordtype__Group__5
            {
            pushFollow(FOLLOW_16);
            rule__Recordtype__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Recordtype__Group__5();

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
    // $ANTLR end "rule__Recordtype__Group__4"


    // $ANTLR start "rule__Recordtype__Group__4__Impl"
    // InternalDbdTextEditor.g:3226:1: rule__Recordtype__Group__4__Impl : ( '{' ) ;
    public final void rule__Recordtype__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3230:1: ( ( '{' ) )
            // InternalDbdTextEditor.g:3231:1: ( '{' )
            {
            // InternalDbdTextEditor.g:3231:1: ( '{' )
            // InternalDbdTextEditor.g:3232:2: '{'
            {
             before(grammarAccess.getRecordtypeAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,400,FOLLOW_2); 
             after(grammarAccess.getRecordtypeAccess().getLeftCurlyBracketKeyword_4()); 

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
    // $ANTLR end "rule__Recordtype__Group__4__Impl"


    // $ANTLR start "rule__Recordtype__Group__5"
    // InternalDbdTextEditor.g:3241:1: rule__Recordtype__Group__5 : rule__Recordtype__Group__5__Impl rule__Recordtype__Group__6 ;
    public final void rule__Recordtype__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3245:1: ( rule__Recordtype__Group__5__Impl rule__Recordtype__Group__6 )
            // InternalDbdTextEditor.g:3246:2: rule__Recordtype__Group__5__Impl rule__Recordtype__Group__6
            {
            pushFollow(FOLLOW_16);
            rule__Recordtype__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Recordtype__Group__6();

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
    // $ANTLR end "rule__Recordtype__Group__5"


    // $ANTLR start "rule__Recordtype__Group__5__Impl"
    // InternalDbdTextEditor.g:3253:1: rule__Recordtype__Group__5__Impl : ( ( rule__Recordtype__FieldsAssignment_5 )* ) ;
    public final void rule__Recordtype__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3257:1: ( ( ( rule__Recordtype__FieldsAssignment_5 )* ) )
            // InternalDbdTextEditor.g:3258:1: ( ( rule__Recordtype__FieldsAssignment_5 )* )
            {
            // InternalDbdTextEditor.g:3258:1: ( ( rule__Recordtype__FieldsAssignment_5 )* )
            // InternalDbdTextEditor.g:3259:2: ( rule__Recordtype__FieldsAssignment_5 )*
            {
             before(grammarAccess.getRecordtypeAccess().getFieldsAssignment_5()); 
            // InternalDbdTextEditor.g:3260:2: ( rule__Recordtype__FieldsAssignment_5 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==405) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalDbdTextEditor.g:3260:3: rule__Recordtype__FieldsAssignment_5
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__Recordtype__FieldsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getRecordtypeAccess().getFieldsAssignment_5()); 

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
    // $ANTLR end "rule__Recordtype__Group__5__Impl"


    // $ANTLR start "rule__Recordtype__Group__6"
    // InternalDbdTextEditor.g:3268:1: rule__Recordtype__Group__6 : rule__Recordtype__Group__6__Impl ;
    public final void rule__Recordtype__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3272:1: ( rule__Recordtype__Group__6__Impl )
            // InternalDbdTextEditor.g:3273:2: rule__Recordtype__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Recordtype__Group__6__Impl();

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
    // $ANTLR end "rule__Recordtype__Group__6"


    // $ANTLR start "rule__Recordtype__Group__6__Impl"
    // InternalDbdTextEditor.g:3279:1: rule__Recordtype__Group__6__Impl : ( '}' ) ;
    public final void rule__Recordtype__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3283:1: ( ( '}' ) )
            // InternalDbdTextEditor.g:3284:1: ( '}' )
            {
            // InternalDbdTextEditor.g:3284:1: ( '}' )
            // InternalDbdTextEditor.g:3285:2: '}'
            {
             before(grammarAccess.getRecordtypeAccess().getRightCurlyBracketKeyword_6()); 
            match(input,401,FOLLOW_2); 
             after(grammarAccess.getRecordtypeAccess().getRightCurlyBracketKeyword_6()); 

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
    // $ANTLR end "rule__Recordtype__Group__6__Impl"


    // $ANTLR start "rule__Field__Group__0"
    // InternalDbdTextEditor.g:3295:1: rule__Field__Group__0 : rule__Field__Group__0__Impl rule__Field__Group__1 ;
    public final void rule__Field__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3299:1: ( rule__Field__Group__0__Impl rule__Field__Group__1 )
            // InternalDbdTextEditor.g:3300:2: rule__Field__Group__0__Impl rule__Field__Group__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalDbdTextEditor.g:3307:1: rule__Field__Group__0__Impl : ( ( rule__Field__NameAssignment_0 ) ) ;
    public final void rule__Field__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3311:1: ( ( ( rule__Field__NameAssignment_0 ) ) )
            // InternalDbdTextEditor.g:3312:1: ( ( rule__Field__NameAssignment_0 ) )
            {
            // InternalDbdTextEditor.g:3312:1: ( ( rule__Field__NameAssignment_0 ) )
            // InternalDbdTextEditor.g:3313:2: ( rule__Field__NameAssignment_0 )
            {
             before(grammarAccess.getFieldAccess().getNameAssignment_0()); 
            // InternalDbdTextEditor.g:3314:2: ( rule__Field__NameAssignment_0 )
            // InternalDbdTextEditor.g:3314:3: rule__Field__NameAssignment_0
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
    // InternalDbdTextEditor.g:3322:1: rule__Field__Group__1 : rule__Field__Group__1__Impl rule__Field__Group__2 ;
    public final void rule__Field__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3326:1: ( rule__Field__Group__1__Impl rule__Field__Group__2 )
            // InternalDbdTextEditor.g:3327:2: rule__Field__Group__1__Impl rule__Field__Group__2
            {
            pushFollow(FOLLOW_18);
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
    // InternalDbdTextEditor.g:3334:1: rule__Field__Group__1__Impl : ( '(' ) ;
    public final void rule__Field__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3338:1: ( ( '(' ) )
            // InternalDbdTextEditor.g:3339:1: ( '(' )
            {
            // InternalDbdTextEditor.g:3339:1: ( '(' )
            // InternalDbdTextEditor.g:3340:2: '('
            {
             before(grammarAccess.getFieldAccess().getLeftParenthesisKeyword_1()); 
            match(input,398,FOLLOW_2); 
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
    // InternalDbdTextEditor.g:3349:1: rule__Field__Group__2 : rule__Field__Group__2__Impl rule__Field__Group__3 ;
    public final void rule__Field__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3353:1: ( rule__Field__Group__2__Impl rule__Field__Group__3 )
            // InternalDbdTextEditor.g:3354:2: rule__Field__Group__2__Impl rule__Field__Group__3
            {
            pushFollow(FOLLOW_13);
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
    // InternalDbdTextEditor.g:3361:1: rule__Field__Group__2__Impl : ( ( rule__Field__FieldnameAssignment_2 ) ) ;
    public final void rule__Field__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3365:1: ( ( ( rule__Field__FieldnameAssignment_2 ) ) )
            // InternalDbdTextEditor.g:3366:1: ( ( rule__Field__FieldnameAssignment_2 ) )
            {
            // InternalDbdTextEditor.g:3366:1: ( ( rule__Field__FieldnameAssignment_2 ) )
            // InternalDbdTextEditor.g:3367:2: ( rule__Field__FieldnameAssignment_2 )
            {
             before(grammarAccess.getFieldAccess().getFieldnameAssignment_2()); 
            // InternalDbdTextEditor.g:3368:2: ( rule__Field__FieldnameAssignment_2 )
            // InternalDbdTextEditor.g:3368:3: rule__Field__FieldnameAssignment_2
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
    // InternalDbdTextEditor.g:3376:1: rule__Field__Group__3 : rule__Field__Group__3__Impl rule__Field__Group__4 ;
    public final void rule__Field__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3380:1: ( rule__Field__Group__3__Impl rule__Field__Group__4 )
            // InternalDbdTextEditor.g:3381:2: rule__Field__Group__3__Impl rule__Field__Group__4
            {
            pushFollow(FOLLOW_19);
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
    // InternalDbdTextEditor.g:3388:1: rule__Field__Group__3__Impl : ( ',' ) ;
    public final void rule__Field__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3392:1: ( ( ',' ) )
            // InternalDbdTextEditor.g:3393:1: ( ',' )
            {
            // InternalDbdTextEditor.g:3393:1: ( ',' )
            // InternalDbdTextEditor.g:3394:2: ','
            {
             before(grammarAccess.getFieldAccess().getCommaKeyword_3()); 
            match(input,403,FOLLOW_2); 
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
    // InternalDbdTextEditor.g:3403:1: rule__Field__Group__4 : rule__Field__Group__4__Impl rule__Field__Group__5 ;
    public final void rule__Field__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3407:1: ( rule__Field__Group__4__Impl rule__Field__Group__5 )
            // InternalDbdTextEditor.g:3408:2: rule__Field__Group__4__Impl rule__Field__Group__5
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
    // InternalDbdTextEditor.g:3415:1: rule__Field__Group__4__Impl : ( ( rule__Field__DbfAssignment_4 ) ) ;
    public final void rule__Field__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3419:1: ( ( ( rule__Field__DbfAssignment_4 ) ) )
            // InternalDbdTextEditor.g:3420:1: ( ( rule__Field__DbfAssignment_4 ) )
            {
            // InternalDbdTextEditor.g:3420:1: ( ( rule__Field__DbfAssignment_4 ) )
            // InternalDbdTextEditor.g:3421:2: ( rule__Field__DbfAssignment_4 )
            {
             before(grammarAccess.getFieldAccess().getDbfAssignment_4()); 
            // InternalDbdTextEditor.g:3422:2: ( rule__Field__DbfAssignment_4 )
            // InternalDbdTextEditor.g:3422:3: rule__Field__DbfAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Field__DbfAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getFieldAccess().getDbfAssignment_4()); 

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
    // InternalDbdTextEditor.g:3430:1: rule__Field__Group__5 : rule__Field__Group__5__Impl rule__Field__Group__6 ;
    public final void rule__Field__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3434:1: ( rule__Field__Group__5__Impl rule__Field__Group__6 )
            // InternalDbdTextEditor.g:3435:2: rule__Field__Group__5__Impl rule__Field__Group__6
            {
            pushFollow(FOLLOW_9);
            rule__Field__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Field__Group__6();

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
    // InternalDbdTextEditor.g:3442:1: rule__Field__Group__5__Impl : ( ')' ) ;
    public final void rule__Field__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3446:1: ( ( ')' ) )
            // InternalDbdTextEditor.g:3447:1: ( ')' )
            {
            // InternalDbdTextEditor.g:3447:1: ( ')' )
            // InternalDbdTextEditor.g:3448:2: ')'
            {
             before(grammarAccess.getFieldAccess().getRightParenthesisKeyword_5()); 
            match(input,399,FOLLOW_2); 
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


    // $ANTLR start "rule__Field__Group__6"
    // InternalDbdTextEditor.g:3457:1: rule__Field__Group__6 : rule__Field__Group__6__Impl rule__Field__Group__7 ;
    public final void rule__Field__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3461:1: ( rule__Field__Group__6__Impl rule__Field__Group__7 )
            // InternalDbdTextEditor.g:3462:2: rule__Field__Group__6__Impl rule__Field__Group__7
            {
            pushFollow(FOLLOW_20);
            rule__Field__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Field__Group__7();

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
    // $ANTLR end "rule__Field__Group__6"


    // $ANTLR start "rule__Field__Group__6__Impl"
    // InternalDbdTextEditor.g:3469:1: rule__Field__Group__6__Impl : ( '{' ) ;
    public final void rule__Field__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3473:1: ( ( '{' ) )
            // InternalDbdTextEditor.g:3474:1: ( '{' )
            {
            // InternalDbdTextEditor.g:3474:1: ( '{' )
            // InternalDbdTextEditor.g:3475:2: '{'
            {
             before(grammarAccess.getFieldAccess().getLeftCurlyBracketKeyword_6()); 
            match(input,400,FOLLOW_2); 
             after(grammarAccess.getFieldAccess().getLeftCurlyBracketKeyword_6()); 

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
    // $ANTLR end "rule__Field__Group__6__Impl"


    // $ANTLR start "rule__Field__Group__7"
    // InternalDbdTextEditor.g:3484:1: rule__Field__Group__7 : rule__Field__Group__7__Impl rule__Field__Group__8 ;
    public final void rule__Field__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3488:1: ( rule__Field__Group__7__Impl rule__Field__Group__8 )
            // InternalDbdTextEditor.g:3489:2: rule__Field__Group__7__Impl rule__Field__Group__8
            {
            pushFollow(FOLLOW_20);
            rule__Field__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Field__Group__8();

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
    // $ANTLR end "rule__Field__Group__7"


    // $ANTLR start "rule__Field__Group__7__Impl"
    // InternalDbdTextEditor.g:3496:1: rule__Field__Group__7__Impl : ( ( rule__Field__FieldattributesAssignment_7 )* ) ;
    public final void rule__Field__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3500:1: ( ( ( rule__Field__FieldattributesAssignment_7 )* ) )
            // InternalDbdTextEditor.g:3501:1: ( ( rule__Field__FieldattributesAssignment_7 )* )
            {
            // InternalDbdTextEditor.g:3501:1: ( ( rule__Field__FieldattributesAssignment_7 )* )
            // InternalDbdTextEditor.g:3502:2: ( rule__Field__FieldattributesAssignment_7 )*
            {
             before(grammarAccess.getFieldAccess().getFieldattributesAssignment_7()); 
            // InternalDbdTextEditor.g:3503:2: ( rule__Field__FieldattributesAssignment_7 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=393 && LA12_0<=397)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalDbdTextEditor.g:3503:3: rule__Field__FieldattributesAssignment_7
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__Field__FieldattributesAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getFieldAccess().getFieldattributesAssignment_7()); 

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
    // $ANTLR end "rule__Field__Group__7__Impl"


    // $ANTLR start "rule__Field__Group__8"
    // InternalDbdTextEditor.g:3511:1: rule__Field__Group__8 : rule__Field__Group__8__Impl ;
    public final void rule__Field__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3515:1: ( rule__Field__Group__8__Impl )
            // InternalDbdTextEditor.g:3516:2: rule__Field__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Field__Group__8__Impl();

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
    // $ANTLR end "rule__Field__Group__8"


    // $ANTLR start "rule__Field__Group__8__Impl"
    // InternalDbdTextEditor.g:3522:1: rule__Field__Group__8__Impl : ( '}' ) ;
    public final void rule__Field__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3526:1: ( ( '}' ) )
            // InternalDbdTextEditor.g:3527:1: ( '}' )
            {
            // InternalDbdTextEditor.g:3527:1: ( '}' )
            // InternalDbdTextEditor.g:3528:2: '}'
            {
             before(grammarAccess.getFieldAccess().getRightCurlyBracketKeyword_8()); 
            match(input,401,FOLLOW_2); 
             after(grammarAccess.getFieldAccess().getRightCurlyBracketKeyword_8()); 

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
    // $ANTLR end "rule__Field__Group__8__Impl"


    // $ANTLR start "rule__Fieldattribute__Group__0"
    // InternalDbdTextEditor.g:3538:1: rule__Fieldattribute__Group__0 : rule__Fieldattribute__Group__0__Impl rule__Fieldattribute__Group__1 ;
    public final void rule__Fieldattribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3542:1: ( rule__Fieldattribute__Group__0__Impl rule__Fieldattribute__Group__1 )
            // InternalDbdTextEditor.g:3543:2: rule__Fieldattribute__Group__0__Impl rule__Fieldattribute__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Fieldattribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Fieldattribute__Group__1();

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
    // $ANTLR end "rule__Fieldattribute__Group__0"


    // $ANTLR start "rule__Fieldattribute__Group__0__Impl"
    // InternalDbdTextEditor.g:3550:1: rule__Fieldattribute__Group__0__Impl : ( ( rule__Fieldattribute__FieldattributeAssignment_0 ) ) ;
    public final void rule__Fieldattribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3554:1: ( ( ( rule__Fieldattribute__FieldattributeAssignment_0 ) ) )
            // InternalDbdTextEditor.g:3555:1: ( ( rule__Fieldattribute__FieldattributeAssignment_0 ) )
            {
            // InternalDbdTextEditor.g:3555:1: ( ( rule__Fieldattribute__FieldattributeAssignment_0 ) )
            // InternalDbdTextEditor.g:3556:2: ( rule__Fieldattribute__FieldattributeAssignment_0 )
            {
             before(grammarAccess.getFieldattributeAccess().getFieldattributeAssignment_0()); 
            // InternalDbdTextEditor.g:3557:2: ( rule__Fieldattribute__FieldattributeAssignment_0 )
            // InternalDbdTextEditor.g:3557:3: rule__Fieldattribute__FieldattributeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Fieldattribute__FieldattributeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFieldattributeAccess().getFieldattributeAssignment_0()); 

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
    // $ANTLR end "rule__Fieldattribute__Group__0__Impl"


    // $ANTLR start "rule__Fieldattribute__Group__1"
    // InternalDbdTextEditor.g:3565:1: rule__Fieldattribute__Group__1 : rule__Fieldattribute__Group__1__Impl rule__Fieldattribute__Group__2 ;
    public final void rule__Fieldattribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3569:1: ( rule__Fieldattribute__Group__1__Impl rule__Fieldattribute__Group__2 )
            // InternalDbdTextEditor.g:3570:2: rule__Fieldattribute__Group__1__Impl rule__Fieldattribute__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__Fieldattribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Fieldattribute__Group__2();

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
    // $ANTLR end "rule__Fieldattribute__Group__1"


    // $ANTLR start "rule__Fieldattribute__Group__1__Impl"
    // InternalDbdTextEditor.g:3577:1: rule__Fieldattribute__Group__1__Impl : ( '(' ) ;
    public final void rule__Fieldattribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3581:1: ( ( '(' ) )
            // InternalDbdTextEditor.g:3582:1: ( '(' )
            {
            // InternalDbdTextEditor.g:3582:1: ( '(' )
            // InternalDbdTextEditor.g:3583:2: '('
            {
             before(grammarAccess.getFieldattributeAccess().getLeftParenthesisKeyword_1()); 
            match(input,398,FOLLOW_2); 
             after(grammarAccess.getFieldattributeAccess().getLeftParenthesisKeyword_1()); 

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
    // $ANTLR end "rule__Fieldattribute__Group__1__Impl"


    // $ANTLR start "rule__Fieldattribute__Group__2"
    // InternalDbdTextEditor.g:3592:1: rule__Fieldattribute__Group__2 : rule__Fieldattribute__Group__2__Impl rule__Fieldattribute__Group__3 ;
    public final void rule__Fieldattribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3596:1: ( rule__Fieldattribute__Group__2__Impl rule__Fieldattribute__Group__3 )
            // InternalDbdTextEditor.g:3597:2: rule__Fieldattribute__Group__2__Impl rule__Fieldattribute__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__Fieldattribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Fieldattribute__Group__3();

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
    // $ANTLR end "rule__Fieldattribute__Group__2"


    // $ANTLR start "rule__Fieldattribute__Group__2__Impl"
    // InternalDbdTextEditor.g:3604:1: rule__Fieldattribute__Group__2__Impl : ( ( rule__Fieldattribute__Alternatives_2 ) ) ;
    public final void rule__Fieldattribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3608:1: ( ( ( rule__Fieldattribute__Alternatives_2 ) ) )
            // InternalDbdTextEditor.g:3609:1: ( ( rule__Fieldattribute__Alternatives_2 ) )
            {
            // InternalDbdTextEditor.g:3609:1: ( ( rule__Fieldattribute__Alternatives_2 ) )
            // InternalDbdTextEditor.g:3610:2: ( rule__Fieldattribute__Alternatives_2 )
            {
             before(grammarAccess.getFieldattributeAccess().getAlternatives_2()); 
            // InternalDbdTextEditor.g:3611:2: ( rule__Fieldattribute__Alternatives_2 )
            // InternalDbdTextEditor.g:3611:3: rule__Fieldattribute__Alternatives_2
            {
            pushFollow(FOLLOW_2);
            rule__Fieldattribute__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getFieldattributeAccess().getAlternatives_2()); 

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
    // $ANTLR end "rule__Fieldattribute__Group__2__Impl"


    // $ANTLR start "rule__Fieldattribute__Group__3"
    // InternalDbdTextEditor.g:3619:1: rule__Fieldattribute__Group__3 : rule__Fieldattribute__Group__3__Impl ;
    public final void rule__Fieldattribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3623:1: ( rule__Fieldattribute__Group__3__Impl )
            // InternalDbdTextEditor.g:3624:2: rule__Fieldattribute__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Fieldattribute__Group__3__Impl();

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
    // $ANTLR end "rule__Fieldattribute__Group__3"


    // $ANTLR start "rule__Fieldattribute__Group__3__Impl"
    // InternalDbdTextEditor.g:3630:1: rule__Fieldattribute__Group__3__Impl : ( ')' ) ;
    public final void rule__Fieldattribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3634:1: ( ( ')' ) )
            // InternalDbdTextEditor.g:3635:1: ( ')' )
            {
            // InternalDbdTextEditor.g:3635:1: ( ')' )
            // InternalDbdTextEditor.g:3636:2: ')'
            {
             before(grammarAccess.getFieldattributeAccess().getRightParenthesisKeyword_3()); 
            match(input,399,FOLLOW_2); 
             after(grammarAccess.getFieldattributeAccess().getRightParenthesisKeyword_3()); 

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
    // $ANTLR end "rule__Fieldattribute__Group__3__Impl"


    // $ANTLR start "rule__DbdModel__MenusAssignment_0"
    // InternalDbdTextEditor.g:3646:1: rule__DbdModel__MenusAssignment_0 : ( ruleMenu ) ;
    public final void rule__DbdModel__MenusAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3650:1: ( ( ruleMenu ) )
            // InternalDbdTextEditor.g:3651:2: ( ruleMenu )
            {
            // InternalDbdTextEditor.g:3651:2: ( ruleMenu )
            // InternalDbdTextEditor.g:3652:3: ruleMenu
            {
             before(grammarAccess.getDbdModelAccess().getMenusMenuParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMenu();

            state._fsp--;

             after(grammarAccess.getDbdModelAccess().getMenusMenuParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__DbdModel__MenusAssignment_0"


    // $ANTLR start "rule__DbdModel__RecordtypesAssignment_1"
    // InternalDbdTextEditor.g:3661:1: rule__DbdModel__RecordtypesAssignment_1 : ( ruleRecordtype ) ;
    public final void rule__DbdModel__RecordtypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3665:1: ( ( ruleRecordtype ) )
            // InternalDbdTextEditor.g:3666:2: ( ruleRecordtype )
            {
            // InternalDbdTextEditor.g:3666:2: ( ruleRecordtype )
            // InternalDbdTextEditor.g:3667:3: ruleRecordtype
            {
             before(grammarAccess.getDbdModelAccess().getRecordtypesRecordtypeParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleRecordtype();

            state._fsp--;

             after(grammarAccess.getDbdModelAccess().getRecordtypesRecordtypeParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__DbdModel__RecordtypesAssignment_1"


    // $ANTLR start "rule__Menu__NameAssignment_0"
    // InternalDbdTextEditor.g:3676:1: rule__Menu__NameAssignment_0 : ( ( 'menu' ) ) ;
    public final void rule__Menu__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3680:1: ( ( ( 'menu' ) ) )
            // InternalDbdTextEditor.g:3681:2: ( ( 'menu' ) )
            {
            // InternalDbdTextEditor.g:3681:2: ( ( 'menu' ) )
            // InternalDbdTextEditor.g:3682:3: ( 'menu' )
            {
             before(grammarAccess.getMenuAccess().getNameMenuKeyword_0_0()); 
            // InternalDbdTextEditor.g:3683:3: ( 'menu' )
            // InternalDbdTextEditor.g:3684:4: 'menu'
            {
             before(grammarAccess.getMenuAccess().getNameMenuKeyword_0_0()); 
            match(input,396,FOLLOW_2); 
             after(grammarAccess.getMenuAccess().getNameMenuKeyword_0_0()); 

            }

             after(grammarAccess.getMenuAccess().getNameMenuKeyword_0_0()); 

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
    // $ANTLR end "rule__Menu__NameAssignment_0"


    // $ANTLR start "rule__Menu__MenunameAssignment_2"
    // InternalDbdTextEditor.g:3695:1: rule__Menu__MenunameAssignment_2 : ( ruleMenunames ) ;
    public final void rule__Menu__MenunameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3699:1: ( ( ruleMenunames ) )
            // InternalDbdTextEditor.g:3700:2: ( ruleMenunames )
            {
            // InternalDbdTextEditor.g:3700:2: ( ruleMenunames )
            // InternalDbdTextEditor.g:3701:3: ruleMenunames
            {
             before(grammarAccess.getMenuAccess().getMenunameMenunamesEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleMenunames();

            state._fsp--;

             after(grammarAccess.getMenuAccess().getMenunameMenunamesEnumRuleCall_2_0()); 

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
    // $ANTLR end "rule__Menu__MenunameAssignment_2"


    // $ANTLR start "rule__Menu__ChoicesAssignment_5"
    // InternalDbdTextEditor.g:3710:1: rule__Menu__ChoicesAssignment_5 : ( ruleChoice ) ;
    public final void rule__Menu__ChoicesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3714:1: ( ( ruleChoice ) )
            // InternalDbdTextEditor.g:3715:2: ( ruleChoice )
            {
            // InternalDbdTextEditor.g:3715:2: ( ruleChoice )
            // InternalDbdTextEditor.g:3716:3: ruleChoice
            {
             before(grammarAccess.getMenuAccess().getChoicesChoiceParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleChoice();

            state._fsp--;

             after(grammarAccess.getMenuAccess().getChoicesChoiceParserRuleCall_5_0()); 

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
    // $ANTLR end "rule__Menu__ChoicesAssignment_5"


    // $ANTLR start "rule__Choice__ChoicenameAssignment_2"
    // InternalDbdTextEditor.g:3725:1: rule__Choice__ChoicenameAssignment_2 : ( ruleChoicenames ) ;
    public final void rule__Choice__ChoicenameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3729:1: ( ( ruleChoicenames ) )
            // InternalDbdTextEditor.g:3730:2: ( ruleChoicenames )
            {
            // InternalDbdTextEditor.g:3730:2: ( ruleChoicenames )
            // InternalDbdTextEditor.g:3731:3: ruleChoicenames
            {
             before(grammarAccess.getChoiceAccess().getChoicenameChoicenamesEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleChoicenames();

            state._fsp--;

             after(grammarAccess.getChoiceAccess().getChoicenameChoicenamesEnumRuleCall_2_0()); 

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
    // $ANTLR end "rule__Choice__ChoicenameAssignment_2"


    // $ANTLR start "rule__Choice__ChoicestringAssignment_4"
    // InternalDbdTextEditor.g:3740:1: rule__Choice__ChoicestringAssignment_4 : ( RULE_STRING ) ;
    public final void rule__Choice__ChoicestringAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3744:1: ( ( RULE_STRING ) )
            // InternalDbdTextEditor.g:3745:2: ( RULE_STRING )
            {
            // InternalDbdTextEditor.g:3745:2: ( RULE_STRING )
            // InternalDbdTextEditor.g:3746:3: RULE_STRING
            {
             before(grammarAccess.getChoiceAccess().getChoicestringSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getChoiceAccess().getChoicestringSTRINGTerminalRuleCall_4_0()); 

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
    // $ANTLR end "rule__Choice__ChoicestringAssignment_4"


    // $ANTLR start "rule__Recordtype__NameAssignment_0"
    // InternalDbdTextEditor.g:3755:1: rule__Recordtype__NameAssignment_0 : ( ( 'recordtype' ) ) ;
    public final void rule__Recordtype__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3759:1: ( ( ( 'recordtype' ) ) )
            // InternalDbdTextEditor.g:3760:2: ( ( 'recordtype' ) )
            {
            // InternalDbdTextEditor.g:3760:2: ( ( 'recordtype' ) )
            // InternalDbdTextEditor.g:3761:3: ( 'recordtype' )
            {
             before(grammarAccess.getRecordtypeAccess().getNameRecordtypeKeyword_0_0()); 
            // InternalDbdTextEditor.g:3762:3: ( 'recordtype' )
            // InternalDbdTextEditor.g:3763:4: 'recordtype'
            {
             before(grammarAccess.getRecordtypeAccess().getNameRecordtypeKeyword_0_0()); 
            match(input,404,FOLLOW_2); 
             after(grammarAccess.getRecordtypeAccess().getNameRecordtypeKeyword_0_0()); 

            }

             after(grammarAccess.getRecordtypeAccess().getNameRecordtypeKeyword_0_0()); 

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
    // $ANTLR end "rule__Recordtype__NameAssignment_0"


    // $ANTLR start "rule__Recordtype__RecordtypenameAssignment_2"
    // InternalDbdTextEditor.g:3774:1: rule__Recordtype__RecordtypenameAssignment_2 : ( ruleRecordtypenames ) ;
    public final void rule__Recordtype__RecordtypenameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3778:1: ( ( ruleRecordtypenames ) )
            // InternalDbdTextEditor.g:3779:2: ( ruleRecordtypenames )
            {
            // InternalDbdTextEditor.g:3779:2: ( ruleRecordtypenames )
            // InternalDbdTextEditor.g:3780:3: ruleRecordtypenames
            {
             before(grammarAccess.getRecordtypeAccess().getRecordtypenameRecordtypenamesEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleRecordtypenames();

            state._fsp--;

             after(grammarAccess.getRecordtypeAccess().getRecordtypenameRecordtypenamesEnumRuleCall_2_0()); 

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
    // $ANTLR end "rule__Recordtype__RecordtypenameAssignment_2"


    // $ANTLR start "rule__Recordtype__FieldsAssignment_5"
    // InternalDbdTextEditor.g:3789:1: rule__Recordtype__FieldsAssignment_5 : ( ruleField ) ;
    public final void rule__Recordtype__FieldsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3793:1: ( ( ruleField ) )
            // InternalDbdTextEditor.g:3794:2: ( ruleField )
            {
            // InternalDbdTextEditor.g:3794:2: ( ruleField )
            // InternalDbdTextEditor.g:3795:3: ruleField
            {
             before(grammarAccess.getRecordtypeAccess().getFieldsFieldParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleField();

            state._fsp--;

             after(grammarAccess.getRecordtypeAccess().getFieldsFieldParserRuleCall_5_0()); 

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
    // $ANTLR end "rule__Recordtype__FieldsAssignment_5"


    // $ANTLR start "rule__Field__NameAssignment_0"
    // InternalDbdTextEditor.g:3804:1: rule__Field__NameAssignment_0 : ( ( 'field' ) ) ;
    public final void rule__Field__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3808:1: ( ( ( 'field' ) ) )
            // InternalDbdTextEditor.g:3809:2: ( ( 'field' ) )
            {
            // InternalDbdTextEditor.g:3809:2: ( ( 'field' ) )
            // InternalDbdTextEditor.g:3810:3: ( 'field' )
            {
             before(grammarAccess.getFieldAccess().getNameFieldKeyword_0_0()); 
            // InternalDbdTextEditor.g:3811:3: ( 'field' )
            // InternalDbdTextEditor.g:3812:4: 'field'
            {
             before(grammarAccess.getFieldAccess().getNameFieldKeyword_0_0()); 
            match(input,405,FOLLOW_2); 
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
    // InternalDbdTextEditor.g:3823:1: rule__Field__FieldnameAssignment_2 : ( ruleFieldnames ) ;
    public final void rule__Field__FieldnameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3827:1: ( ( ruleFieldnames ) )
            // InternalDbdTextEditor.g:3828:2: ( ruleFieldnames )
            {
            // InternalDbdTextEditor.g:3828:2: ( ruleFieldnames )
            // InternalDbdTextEditor.g:3829:3: ruleFieldnames
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


    // $ANTLR start "rule__Field__DbfAssignment_4"
    // InternalDbdTextEditor.g:3838:1: rule__Field__DbfAssignment_4 : ( ruleDbfnames ) ;
    public final void rule__Field__DbfAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3842:1: ( ( ruleDbfnames ) )
            // InternalDbdTextEditor.g:3843:2: ( ruleDbfnames )
            {
            // InternalDbdTextEditor.g:3843:2: ( ruleDbfnames )
            // InternalDbdTextEditor.g:3844:3: ruleDbfnames
            {
             before(grammarAccess.getFieldAccess().getDbfDbfnamesEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleDbfnames();

            state._fsp--;

             after(grammarAccess.getFieldAccess().getDbfDbfnamesEnumRuleCall_4_0()); 

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
    // $ANTLR end "rule__Field__DbfAssignment_4"


    // $ANTLR start "rule__Field__FieldattributesAssignment_7"
    // InternalDbdTextEditor.g:3853:1: rule__Field__FieldattributesAssignment_7 : ( ruleFieldattribute ) ;
    public final void rule__Field__FieldattributesAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3857:1: ( ( ruleFieldattribute ) )
            // InternalDbdTextEditor.g:3858:2: ( ruleFieldattribute )
            {
            // InternalDbdTextEditor.g:3858:2: ( ruleFieldattribute )
            // InternalDbdTextEditor.g:3859:3: ruleFieldattribute
            {
             before(grammarAccess.getFieldAccess().getFieldattributesFieldattributeParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleFieldattribute();

            state._fsp--;

             after(grammarAccess.getFieldAccess().getFieldattributesFieldattributeParserRuleCall_7_0()); 

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
    // $ANTLR end "rule__Field__FieldattributesAssignment_7"


    // $ANTLR start "rule__Fieldattribute__FieldattributeAssignment_0"
    // InternalDbdTextEditor.g:3868:1: rule__Fieldattribute__FieldattributeAssignment_0 : ( ruleFieldattributenames ) ;
    public final void rule__Fieldattribute__FieldattributeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3872:1: ( ( ruleFieldattributenames ) )
            // InternalDbdTextEditor.g:3873:2: ( ruleFieldattributenames )
            {
            // InternalDbdTextEditor.g:3873:2: ( ruleFieldattributenames )
            // InternalDbdTextEditor.g:3874:3: ruleFieldattributenames
            {
             before(grammarAccess.getFieldattributeAccess().getFieldattributeFieldattributenamesEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleFieldattributenames();

            state._fsp--;

             after(grammarAccess.getFieldattributeAccess().getFieldattributeFieldattributenamesEnumRuleCall_0_0()); 

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
    // $ANTLR end "rule__Fieldattribute__FieldattributeAssignment_0"


    // $ANTLR start "rule__Fieldattribute__FieldattributestringAssignment_2_0"
    // InternalDbdTextEditor.g:3883:1: rule__Fieldattribute__FieldattributestringAssignment_2_0 : ( RULE_STRING ) ;
    public final void rule__Fieldattribute__FieldattributestringAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3887:1: ( ( RULE_STRING ) )
            // InternalDbdTextEditor.g:3888:2: ( RULE_STRING )
            {
            // InternalDbdTextEditor.g:3888:2: ( RULE_STRING )
            // InternalDbdTextEditor.g:3889:3: RULE_STRING
            {
             before(grammarAccess.getFieldattributeAccess().getFieldattributestringSTRINGTerminalRuleCall_2_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getFieldattributeAccess().getFieldattributestringSTRINGTerminalRuleCall_2_0_0()); 

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
    // $ANTLR end "rule__Fieldattribute__FieldattributestringAssignment_2_0"


    // $ANTLR start "rule__Fieldattribute__FieldattributeintAssignment_2_1"
    // InternalDbdTextEditor.g:3898:1: rule__Fieldattribute__FieldattributeintAssignment_2_1 : ( RULE_INT ) ;
    public final void rule__Fieldattribute__FieldattributeintAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDbdTextEditor.g:3902:1: ( ( RULE_INT ) )
            // InternalDbdTextEditor.g:3903:2: ( RULE_INT )
            {
            // InternalDbdTextEditor.g:3903:2: ( RULE_INT )
            // InternalDbdTextEditor.g:3904:3: RULE_INT
            {
             before(grammarAccess.getFieldattributeAccess().getFieldattributeintINTTerminalRuleCall_2_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getFieldattributeAccess().getFieldattributeintINTTerminalRuleCall_2_1_0()); 

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
    // $ANTLR end "rule__Fieldattribute__FieldattributeintAssignment_2_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0xFFFFFFFFFFFFF800L,0x0000000000000001L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000060000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0xFFFFFFFFFFFFFFFEL,0xFFFFFFFFFFFFFFFFL,0x0000000000FFFFFFL});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x1FFFFFFFFF000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000220000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000000L,0x0000000000000000L,0xE000000000000000L,0xFFFFFFFFFFFFFFFFL,0x0FFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0xF000000000000000L,0x00000000000001FFL});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000023E00L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000003E00L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000030L});

}