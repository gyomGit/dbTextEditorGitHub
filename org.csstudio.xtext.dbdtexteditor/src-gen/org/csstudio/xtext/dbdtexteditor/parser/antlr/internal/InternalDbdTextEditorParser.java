package org.csstudio.xtext.dbdtexteditor.parser.antlr.internal;

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
import org.csstudio.xtext.dbdtexteditor.services.DbdTextEditorGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDbdTextEditorParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INT", "RULE_SL_COMMENT", "RULE_ID", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'menu'", "'('", "')'", "'{'", "'}'", "'choice'", "','", "'recordtype'", "'field'", "'serialPRTY'", "'waveformPOST'", "'aaoPOST'", "'menuPriority'", "'serialSBIT'", "'calcoutDOPT'", "'SDIS'", "'menuOmsl'", "'menuFtype'", "'stringinPOST'", "'menuPini'", "'dfanoutSELM'", "'menuScan'", "'gpibACMD'", "'aSubLFLG'", "'asynTMOD'", "'scalerD1'", "'menuPost'", "'asynINTERFACE'", "'menuAlarmStat'", "'aoOIF'", "'bufferingALG'", "'aaiPOST'", "'epidFeedbackState'", "'calcoutINAV'", "'asynAUTOCONNECT'", "'asynFMT'", "'asynCONNECT'", "'gpibUCMD'", "'serialBAUD'", "'histogramCMD'", "'asynTRACE'", "'scalerG1'", "'asynEOMREASON'", "'scalerCONT'", "'menuIvoa'", "'stringoutPOST'", "'menuAlarmSevr'", "'serialMCTL'", "'serialFCTL'", "'menuSimm'", "'compressALG'", "'aSubEFLG'", "'fanoutSELM'", "'calcoutOOPT'", "'asynENABLE'", "'epidFeedbackMode'", "'menuConvert'", "'scalerCNT'", "'serialIX'", "'menuYesNo'", "'timestampTST'", "'serialDBIT'", "'selSELM'", "'serialPRTY_unknown'", "'serialPRTY_None'", "'serialPRTY_Even'", "'serialPRTY_Odd'", "'waveformPOST_Always'", "'waveformPOST_OnChange'", "'aaoPOST_Always'", "'aaoPOST_OnChange'", "'menuPriorityLOW'", "'menuPriorityMEDIUM'", "'menuPriorityHIGH'", "'serialSBIT_unknown'", "'serialSBIT_1'", "'serialSBIT_2'", "'calcoutDOPT_Use_VAL'", "'calcoutDOPT_Use_OVAL'", "'menuOmslsupervisory'", "'menuOmslclosed_loop'", "'menuFtypeSTRING'", "'menuFtypeCHAR'", "'menuFtypeUCHAR'", "'menuFtypeSHORT'", "'menuFtypeUSHORT'", "'menuFtypeLONG'", "'menuFtypeULONG'", "'menuFtypeINT64'", "'menuFtypeUINT64'", "'menuFtypeFLOAT'", "'menuFtypeDOUBLE'", "'menuFtypeENUM'", "'stringinPOST_OnChange'", "'stringinPOST_Always'", "'menuPiniNO'", "'menuPiniYES'", "'menuPiniRUN'", "'menuPiniRUNNING'", "'menuPiniPAUSE'", "'menuPiniPAUSED'", "'dfanoutSELM_All'", "'dfanoutSELM_Specified'", "'dfanoutSELM_Mask'", "'menuScanPassive'", "'menuScanEvent'", "'menuScanI_O_Intr'", "'menuScan10_second'", "'menuScan5_second'", "'menuScan2_second'", "'menuScan1_second'", "'menuScan_5_second'", "'menuScan_2_second'", "'menuScan_1_second'", "'gpibACMD_None'", "'gpibACMD_Group_Execute_Trig___GET_'", "'gpibACMD_Go_To_Local__GTL_'", "'gpibACMD_Selected_Dev__Clear__SDC_'", "'gpibACMD_Take_Control__TCT_'", "'gpibACMD_Serial_Poll'", "'aSubLFLG_IGNORE'", "'aSubLFLG_READ'", "'asynTMOD_Write_Read'", "'asynTMOD_Write'", "'asynTMOD_Read'", "'asynTMOD_Flush'", "'asynTMOD_NoIO'", "'ipDRTO_unknown'", "'ipDRTO_No'", "'ipDRTO_Yes'", "'scalerD1_Up'", "'scalerD1_Dn'", "'menuPost_OnChange'", "'menuPost_Always'", "'asynINTERFACE_OCTET'", "'asynINTERFACE_INT32'", "'asynINTERFACE_UINT32'", "'asynINTERFACE_FLOAT64'", "'menuAlarmStatNO_ALARM'", "'menuAlarmStatREAD'", "'menuAlarmStatWRITE'", "'menuAlarmStatHIHI'", "'menuAlarmStatHIGH'", "'menuAlarmStatLOLO'", "'menuAlarmStatLOW'", "'menuAlarmStatSTATE'", "'menuAlarmStatCOS'", "'menuAlarmStatCOMM'", "'menuAlarmStatTIMEOUT'", "'menuAlarmStatHWLIMIT'", "'menuAlarmStatCALC'", "'menuAlarmStatSCAN'", "'menuAlarmStatLINK'", "'menuAlarmStatSOFT'", "'menuAlarmStatBAD_SUB'", "'menuAlarmStatUDF'", "'menuAlarmStatDISABLE'", "'menuAlarmStatSIMM'", "'menuAlarmStatREAD_ACCESS'", "'menuAlarmStatWRITE_ACCESS'", "'aoOIF_Full'", "'aoOIF_Incremental'", "'bufferingALG_FIFO'", "'bufferingALG_LIFO'", "'aaiPOST_Always'", "'aaiPOST_OnChange'", "'epidFeedbackState_Off'", "'epidFeedbackState_On'", "'calcoutINAV_EXT_NC'", "'calcoutINAV_EXT'", "'calcoutINAV_LOC'", "'calcoutINAV_CON'", "'asynAUTOCONNECT_noAutoConnect'", "'asynAUTOCONNECT_autoConnect'", "'asynFMT_ASCII'", "'asynFMT_Hybrid'", "'asynFMT_Binary'", "'seqSELM_All'", "'seqSELM_Specified'", "'seqSELM_Mask'", "'asynCONNECT_Disconnect'", "'asynCONNECT_Connect'", "'gpibUCMD_None'", "'gpibUCMD_Device_Clear__DCL_'", "'gpibUCMD_Local_Lockout__LL0_'", "'gpibUCMD_Serial_Poll_Disable__SPD_'", "'gpibUCMD_Serial_Poll_Enable__SPE_'", "'gpibUCMD_Unlisten__UNL_'", "'gpibUCMD_Untalk__UNT_'", "'serialBAUD_unknown'", "'serialBAUD_300'", "'serialBAUD_600'", "'serialBAUD_1200'", "'serialBAUD_2400'", "'serialBAUD_4800'", "'serialBAUD_9600'", "'serialBAUD_19200'", "'serialBAUD_38400'", "'serialBAUD_57600'", "'serialBAUD_115200'", "'serialBAUD_230400'", "'serialBAUD_460800'", "'serialBAUD_576000'", "'serialBAUD_921600'", "'serialBAUD_1152000'", "'histogramCMD_Read'", "'histogramCMD_Clear'", "'histogramCMD_Start'", "'histogramCMD_Stop'", "'asynTRACE_Off'", "'asynTRACE_On'", "'scalerG1_N'", "'scalerG1_Y'", "'asynEOMREASONNone'", "'calcout'", "'state'", "'histogram'", "'lsi'", "'int64out'", "'seq'", "'stringout'", "'aai'", "'permissive'", "'bo'", "'dfanout'", "'mbbi'", "'event'", "'compress'", "'mbbo'", "'epid'", "'ao'", "'aao'", "'mbbiDirect'", "'asyn'", "'waveform'", "'scaler'", "'timestamp'", "'fanout'", "'longin'", "'printf'", "'sel'", "'bi'", "'lso'", "'subArray'", "'calc'", "'mbboDirect'", "'longout'", "'aSub'", "'sub'", "'int64in'", "'ai'", "'NAME'", "'DESC'", "'ASG'", "'SCAN'", "'PINI'", "'PHAS'", "'EVNT'", "'TSE'", "'TSEL'", "'DTYP'", "'DISV'", "'DISA'", "'MLOK'", "'MLIS'", "'BKLNK'", "'DISP'", "'PROC'", "'STAT'", "'SEVR'", "'NSTA'", "'NSEV'", "'ACKS'", "'ACKT'", "'DISS'", "'PACT'", "'PUTF'", "'RPRO'", "'ASP'", "'PPN'", "'PPNR'", "'SPVT'", "'RSET'", "'DSET'", "'DPVT'", "'RDES'", "'LSET'", "'PRIO'", "'TPRO'", "'BKPT'", "'UDF'", "'UDFS'", "'TIME'", "'FLNK'", "'RPVT'", "'VAL'", "'PVAL'", "'CALC'", "'CLCV'", "'INPA'", "'INPB'", "'INPC'", "'INPD'", "'INPE'", "'INPF'", "'INPG'", "'INPH'", "'INPI'", "'INPJ'", "'INPK'", "'INPL'", "'OUT'", "'INAV'", "'INBV'", "'INCV'", "'INDV'", "'INEV'", "'INFV'", "'INGV'", "'INHV'", "'INIV'", "'INJV'", "'INKV'", "'INLV'", "'OOPT'", "'DLYA'", "'DOPT'", "'OCAL'", "'OCLV'", "'OEVT'", "'EPVT'", "'IVOA'", "'IVOV'", "'PREC'", "'HOPR'", "'LOPR'", "'HIHI'", "'LOLO'", "'HIGH'", "'LOW'", "'HHSV'", "'LLSV'", "'HSV'", "'LSV'", "'HYST'", "'ADEL'", "'MDEL'", "'A'", "'B'", "'C'", "'D'", "'E'", "'F'", "'G'", "'H'", "'I'", "'J'", "'K'", "'L'", "'OVAL'", "'LA'", "'LB'", "'LC'", "'LD'", "'LE'", "'LF'", "'LG'", "'LH'", "'LI'", "'LJ'", "'LK'", "'LL'", "'POVL'", "'LALM'", "'ALST'", "'MLST'", "'RPCL'", "'ORPC'", "'DBF_STRING'", "'DBF_MENU'", "'DBF_INLINK'", "'DBF_FWDLINK'", "'DBF_SHORT'", "'DBF_DEVICE'", "'DBF_NOACCESS'", "'DBF_UCHAR'", "'DBF_OUTLINK'", "'DBF_USHORT'", "'DBF_DOUBLE'", "'DBF_ULONG'", "'INT64'", "'size'", "'prompt'", "'promptgroup'", "'interest'"
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

        public InternalDbdTextEditorParser(TokenStream input, DbdTextEditorGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "dbdModel";
       	}

       	@Override
       	protected DbdTextEditorGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuledbdModel"
    // InternalDbdTextEditor.g:65:1: entryRuledbdModel returns [EObject current=null] : iv_ruledbdModel= ruledbdModel EOF ;
    public final EObject entryRuledbdModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruledbdModel = null;


        try {
            // InternalDbdTextEditor.g:65:49: (iv_ruledbdModel= ruledbdModel EOF )
            // InternalDbdTextEditor.g:66:2: iv_ruledbdModel= ruledbdModel EOF
            {
             newCompositeNode(grammarAccess.getDbdModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruledbdModel=ruledbdModel();

            state._fsp--;

             current =iv_ruledbdModel; 
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
    // $ANTLR end "entryRuledbdModel"


    // $ANTLR start "ruledbdModel"
    // InternalDbdTextEditor.g:72:1: ruledbdModel returns [EObject current=null] : ( ( (lv_menus_0_0= ruleMenu ) )* ( (lv_recordtypes_1_0= ruleRecordtype ) )* ) ;
    public final EObject ruledbdModel() throws RecognitionException {
        EObject current = null;

        EObject lv_menus_0_0 = null;

        EObject lv_recordtypes_1_0 = null;



        	enterRule();

        try {
            // InternalDbdTextEditor.g:78:2: ( ( ( (lv_menus_0_0= ruleMenu ) )* ( (lv_recordtypes_1_0= ruleRecordtype ) )* ) )
            // InternalDbdTextEditor.g:79:2: ( ( (lv_menus_0_0= ruleMenu ) )* ( (lv_recordtypes_1_0= ruleRecordtype ) )* )
            {
            // InternalDbdTextEditor.g:79:2: ( ( (lv_menus_0_0= ruleMenu ) )* ( (lv_recordtypes_1_0= ruleRecordtype ) )* )
            // InternalDbdTextEditor.g:80:3: ( (lv_menus_0_0= ruleMenu ) )* ( (lv_recordtypes_1_0= ruleRecordtype ) )*
            {
            // InternalDbdTextEditor.g:80:3: ( (lv_menus_0_0= ruleMenu ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDbdTextEditor.g:81:4: (lv_menus_0_0= ruleMenu )
            	    {
            	    // InternalDbdTextEditor.g:81:4: (lv_menus_0_0= ruleMenu )
            	    // InternalDbdTextEditor.g:82:5: lv_menus_0_0= ruleMenu
            	    {

            	    					newCompositeNode(grammarAccess.getDbdModelAccess().getMenusMenuParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_menus_0_0=ruleMenu();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDbdModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"menus",
            	    						lv_menus_0_0,
            	    						"org.csstudio.xtext.dbdtexteditor.DbdTextEditor.Menu");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalDbdTextEditor.g:99:3: ( (lv_recordtypes_1_0= ruleRecordtype ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==18) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalDbdTextEditor.g:100:4: (lv_recordtypes_1_0= ruleRecordtype )
            	    {
            	    // InternalDbdTextEditor.g:100:4: (lv_recordtypes_1_0= ruleRecordtype )
            	    // InternalDbdTextEditor.g:101:5: lv_recordtypes_1_0= ruleRecordtype
            	    {

            	    					newCompositeNode(grammarAccess.getDbdModelAccess().getRecordtypesRecordtypeParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_recordtypes_1_0=ruleRecordtype();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDbdModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"recordtypes",
            	    						lv_recordtypes_1_0,
            	    						"org.csstudio.xtext.dbdtexteditor.DbdTextEditor.Recordtype");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


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
    // $ANTLR end "ruledbdModel"


    // $ANTLR start "entryRuleMenu"
    // InternalDbdTextEditor.g:122:1: entryRuleMenu returns [EObject current=null] : iv_ruleMenu= ruleMenu EOF ;
    public final EObject entryRuleMenu() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMenu = null;


        try {
            // InternalDbdTextEditor.g:122:45: (iv_ruleMenu= ruleMenu EOF )
            // InternalDbdTextEditor.g:123:2: iv_ruleMenu= ruleMenu EOF
            {
             newCompositeNode(grammarAccess.getMenuRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMenu=ruleMenu();

            state._fsp--;

             current =iv_ruleMenu; 
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
    // $ANTLR end "entryRuleMenu"


    // $ANTLR start "ruleMenu"
    // InternalDbdTextEditor.g:129:1: ruleMenu returns [EObject current=null] : ( ( (lv_name_0_0= 'menu' ) ) otherlv_1= '(' ( (lv_menuname_2_0= ruleMenunames ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_choices_5_0= ruleChoice ) )* otherlv_6= '}' ) ;
    public final EObject ruleMenu() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_menuname_2_0 = null;

        EObject lv_choices_5_0 = null;



        	enterRule();

        try {
            // InternalDbdTextEditor.g:135:2: ( ( ( (lv_name_0_0= 'menu' ) ) otherlv_1= '(' ( (lv_menuname_2_0= ruleMenunames ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_choices_5_0= ruleChoice ) )* otherlv_6= '}' ) )
            // InternalDbdTextEditor.g:136:2: ( ( (lv_name_0_0= 'menu' ) ) otherlv_1= '(' ( (lv_menuname_2_0= ruleMenunames ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_choices_5_0= ruleChoice ) )* otherlv_6= '}' )
            {
            // InternalDbdTextEditor.g:136:2: ( ( (lv_name_0_0= 'menu' ) ) otherlv_1= '(' ( (lv_menuname_2_0= ruleMenunames ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_choices_5_0= ruleChoice ) )* otherlv_6= '}' )
            // InternalDbdTextEditor.g:137:3: ( (lv_name_0_0= 'menu' ) ) otherlv_1= '(' ( (lv_menuname_2_0= ruleMenunames ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_choices_5_0= ruleChoice ) )* otherlv_6= '}'
            {
            // InternalDbdTextEditor.g:137:3: ( (lv_name_0_0= 'menu' ) )
            // InternalDbdTextEditor.g:138:4: (lv_name_0_0= 'menu' )
            {
            // InternalDbdTextEditor.g:138:4: (lv_name_0_0= 'menu' )
            // InternalDbdTextEditor.g:139:5: lv_name_0_0= 'menu'
            {
            lv_name_0_0=(Token)match(input,11,FOLLOW_5); 

            					newLeafNode(lv_name_0_0, grammarAccess.getMenuAccess().getNameMenuKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMenuRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "menu");
            				

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getMenuAccess().getLeftParenthesisKeyword_1());
            		
            // InternalDbdTextEditor.g:155:3: ( (lv_menuname_2_0= ruleMenunames ) )
            // InternalDbdTextEditor.g:156:4: (lv_menuname_2_0= ruleMenunames )
            {
            // InternalDbdTextEditor.g:156:4: (lv_menuname_2_0= ruleMenunames )
            // InternalDbdTextEditor.g:157:5: lv_menuname_2_0= ruleMenunames
            {

            					newCompositeNode(grammarAccess.getMenuAccess().getMenunameMenunamesEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_7);
            lv_menuname_2_0=ruleMenunames();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMenuRule());
            					}
            					set(
            						current,
            						"menuname",
            						lv_menuname_2_0,
            						"org.csstudio.xtext.dbdtexteditor.DbdTextEditor.Menunames");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_3, grammarAccess.getMenuAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,14,FOLLOW_9); 

            			newLeafNode(otherlv_4, grammarAccess.getMenuAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalDbdTextEditor.g:182:3: ( (lv_choices_5_0= ruleChoice ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalDbdTextEditor.g:183:4: (lv_choices_5_0= ruleChoice )
            	    {
            	    // InternalDbdTextEditor.g:183:4: (lv_choices_5_0= ruleChoice )
            	    // InternalDbdTextEditor.g:184:5: lv_choices_5_0= ruleChoice
            	    {

            	    					newCompositeNode(grammarAccess.getMenuAccess().getChoicesChoiceParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_choices_5_0=ruleChoice();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMenuRule());
            	    					}
            	    					add(
            	    						current,
            	    						"choices",
            	    						lv_choices_5_0,
            	    						"org.csstudio.xtext.dbdtexteditor.DbdTextEditor.Choice");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getMenuAccess().getRightCurlyBracketKeyword_6());
            		

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
    // $ANTLR end "ruleMenu"


    // $ANTLR start "entryRuleChoice"
    // InternalDbdTextEditor.g:209:1: entryRuleChoice returns [EObject current=null] : iv_ruleChoice= ruleChoice EOF ;
    public final EObject entryRuleChoice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoice = null;


        try {
            // InternalDbdTextEditor.g:209:47: (iv_ruleChoice= ruleChoice EOF )
            // InternalDbdTextEditor.g:210:2: iv_ruleChoice= ruleChoice EOF
            {
             newCompositeNode(grammarAccess.getChoiceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleChoice=ruleChoice();

            state._fsp--;

             current =iv_ruleChoice; 
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
    // $ANTLR end "entryRuleChoice"


    // $ANTLR start "ruleChoice"
    // InternalDbdTextEditor.g:216:1: ruleChoice returns [EObject current=null] : (otherlv_0= 'choice' otherlv_1= '(' ( (lv_choicename_2_0= ruleChoicenames ) ) otherlv_3= ',' ( (lv_choicestring_4_0= RULE_STRING ) ) otherlv_5= ')' ) ;
    public final EObject ruleChoice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_choicestring_4_0=null;
        Token otherlv_5=null;
        Enumerator lv_choicename_2_0 = null;



        	enterRule();

        try {
            // InternalDbdTextEditor.g:222:2: ( (otherlv_0= 'choice' otherlv_1= '(' ( (lv_choicename_2_0= ruleChoicenames ) ) otherlv_3= ',' ( (lv_choicestring_4_0= RULE_STRING ) ) otherlv_5= ')' ) )
            // InternalDbdTextEditor.g:223:2: (otherlv_0= 'choice' otherlv_1= '(' ( (lv_choicename_2_0= ruleChoicenames ) ) otherlv_3= ',' ( (lv_choicestring_4_0= RULE_STRING ) ) otherlv_5= ')' )
            {
            // InternalDbdTextEditor.g:223:2: (otherlv_0= 'choice' otherlv_1= '(' ( (lv_choicename_2_0= ruleChoicenames ) ) otherlv_3= ',' ( (lv_choicestring_4_0= RULE_STRING ) ) otherlv_5= ')' )
            // InternalDbdTextEditor.g:224:3: otherlv_0= 'choice' otherlv_1= '(' ( (lv_choicename_2_0= ruleChoicenames ) ) otherlv_3= ',' ( (lv_choicestring_4_0= RULE_STRING ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getChoiceAccess().getChoiceKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getChoiceAccess().getLeftParenthesisKeyword_1());
            		
            // InternalDbdTextEditor.g:232:3: ( (lv_choicename_2_0= ruleChoicenames ) )
            // InternalDbdTextEditor.g:233:4: (lv_choicename_2_0= ruleChoicenames )
            {
            // InternalDbdTextEditor.g:233:4: (lv_choicename_2_0= ruleChoicenames )
            // InternalDbdTextEditor.g:234:5: lv_choicename_2_0= ruleChoicenames
            {

            					newCompositeNode(grammarAccess.getChoiceAccess().getChoicenameChoicenamesEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_11);
            lv_choicename_2_0=ruleChoicenames();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getChoiceRule());
            					}
            					set(
            						current,
            						"choicename",
            						lv_choicename_2_0,
            						"org.csstudio.xtext.dbdtexteditor.DbdTextEditor.Choicenames");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_12); 

            			newLeafNode(otherlv_3, grammarAccess.getChoiceAccess().getCommaKeyword_3());
            		
            // InternalDbdTextEditor.g:255:3: ( (lv_choicestring_4_0= RULE_STRING ) )
            // InternalDbdTextEditor.g:256:4: (lv_choicestring_4_0= RULE_STRING )
            {
            // InternalDbdTextEditor.g:256:4: (lv_choicestring_4_0= RULE_STRING )
            // InternalDbdTextEditor.g:257:5: lv_choicestring_4_0= RULE_STRING
            {
            lv_choicestring_4_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_choicestring_4_0, grammarAccess.getChoiceAccess().getChoicestringSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getChoiceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"choicestring",
            						lv_choicestring_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getChoiceAccess().getRightParenthesisKeyword_5());
            		

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
    // $ANTLR end "ruleChoice"


    // $ANTLR start "entryRuleRecordtype"
    // InternalDbdTextEditor.g:281:1: entryRuleRecordtype returns [EObject current=null] : iv_ruleRecordtype= ruleRecordtype EOF ;
    public final EObject entryRuleRecordtype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordtype = null;


        try {
            // InternalDbdTextEditor.g:281:51: (iv_ruleRecordtype= ruleRecordtype EOF )
            // InternalDbdTextEditor.g:282:2: iv_ruleRecordtype= ruleRecordtype EOF
            {
             newCompositeNode(grammarAccess.getRecordtypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRecordtype=ruleRecordtype();

            state._fsp--;

             current =iv_ruleRecordtype; 
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
    // $ANTLR end "entryRuleRecordtype"


    // $ANTLR start "ruleRecordtype"
    // InternalDbdTextEditor.g:288:1: ruleRecordtype returns [EObject current=null] : ( ( (lv_name_0_0= 'recordtype' ) ) otherlv_1= '(' ( (lv_recordtypename_2_0= ruleRecordtypenames ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_fields_5_0= ruleField ) )* otherlv_6= '}' ) ;
    public final EObject ruleRecordtype() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_recordtypename_2_0 = null;

        EObject lv_fields_5_0 = null;



        	enterRule();

        try {
            // InternalDbdTextEditor.g:294:2: ( ( ( (lv_name_0_0= 'recordtype' ) ) otherlv_1= '(' ( (lv_recordtypename_2_0= ruleRecordtypenames ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_fields_5_0= ruleField ) )* otherlv_6= '}' ) )
            // InternalDbdTextEditor.g:295:2: ( ( (lv_name_0_0= 'recordtype' ) ) otherlv_1= '(' ( (lv_recordtypename_2_0= ruleRecordtypenames ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_fields_5_0= ruleField ) )* otherlv_6= '}' )
            {
            // InternalDbdTextEditor.g:295:2: ( ( (lv_name_0_0= 'recordtype' ) ) otherlv_1= '(' ( (lv_recordtypename_2_0= ruleRecordtypenames ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_fields_5_0= ruleField ) )* otherlv_6= '}' )
            // InternalDbdTextEditor.g:296:3: ( (lv_name_0_0= 'recordtype' ) ) otherlv_1= '(' ( (lv_recordtypename_2_0= ruleRecordtypenames ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_fields_5_0= ruleField ) )* otherlv_6= '}'
            {
            // InternalDbdTextEditor.g:296:3: ( (lv_name_0_0= 'recordtype' ) )
            // InternalDbdTextEditor.g:297:4: (lv_name_0_0= 'recordtype' )
            {
            // InternalDbdTextEditor.g:297:4: (lv_name_0_0= 'recordtype' )
            // InternalDbdTextEditor.g:298:5: lv_name_0_0= 'recordtype'
            {
            lv_name_0_0=(Token)match(input,18,FOLLOW_5); 

            					newLeafNode(lv_name_0_0, grammarAccess.getRecordtypeAccess().getNameRecordtypeKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRecordtypeRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "recordtype");
            				

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getRecordtypeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalDbdTextEditor.g:314:3: ( (lv_recordtypename_2_0= ruleRecordtypenames ) )
            // InternalDbdTextEditor.g:315:4: (lv_recordtypename_2_0= ruleRecordtypenames )
            {
            // InternalDbdTextEditor.g:315:4: (lv_recordtypename_2_0= ruleRecordtypenames )
            // InternalDbdTextEditor.g:316:5: lv_recordtypename_2_0= ruleRecordtypenames
            {

            					newCompositeNode(grammarAccess.getRecordtypeAccess().getRecordtypenameRecordtypenamesEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_7);
            lv_recordtypename_2_0=ruleRecordtypenames();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRecordtypeRule());
            					}
            					set(
            						current,
            						"recordtypename",
            						lv_recordtypename_2_0,
            						"org.csstudio.xtext.dbdtexteditor.DbdTextEditor.Recordtypenames");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_3, grammarAccess.getRecordtypeAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,14,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getRecordtypeAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalDbdTextEditor.g:341:3: ( (lv_fields_5_0= ruleField ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==19) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalDbdTextEditor.g:342:4: (lv_fields_5_0= ruleField )
            	    {
            	    // InternalDbdTextEditor.g:342:4: (lv_fields_5_0= ruleField )
            	    // InternalDbdTextEditor.g:343:5: lv_fields_5_0= ruleField
            	    {

            	    					newCompositeNode(grammarAccess.getRecordtypeAccess().getFieldsFieldParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_fields_5_0=ruleField();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRecordtypeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"fields",
            	    						lv_fields_5_0,
            	    						"org.csstudio.xtext.dbdtexteditor.DbdTextEditor.Field");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getRecordtypeAccess().getRightCurlyBracketKeyword_6());
            		

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
    // $ANTLR end "ruleRecordtype"


    // $ANTLR start "entryRuleField"
    // InternalDbdTextEditor.g:368:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalDbdTextEditor.g:368:46: (iv_ruleField= ruleField EOF )
            // InternalDbdTextEditor.g:369:2: iv_ruleField= ruleField EOF
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
    // InternalDbdTextEditor.g:375:1: ruleField returns [EObject current=null] : ( ( (lv_name_0_0= 'field' ) ) otherlv_1= '(' ( (lv_fieldname_2_0= ruleFieldnames ) ) otherlv_3= ',' ( (lv_dbf_4_0= ruleDbfnames ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_fieldattributes_7_0= ruleFieldattribute ) )* otherlv_8= '}' ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Enumerator lv_fieldname_2_0 = null;

        Enumerator lv_dbf_4_0 = null;

        EObject lv_fieldattributes_7_0 = null;



        	enterRule();

        try {
            // InternalDbdTextEditor.g:381:2: ( ( ( (lv_name_0_0= 'field' ) ) otherlv_1= '(' ( (lv_fieldname_2_0= ruleFieldnames ) ) otherlv_3= ',' ( (lv_dbf_4_0= ruleDbfnames ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_fieldattributes_7_0= ruleFieldattribute ) )* otherlv_8= '}' ) )
            // InternalDbdTextEditor.g:382:2: ( ( (lv_name_0_0= 'field' ) ) otherlv_1= '(' ( (lv_fieldname_2_0= ruleFieldnames ) ) otherlv_3= ',' ( (lv_dbf_4_0= ruleDbfnames ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_fieldattributes_7_0= ruleFieldattribute ) )* otherlv_8= '}' )
            {
            // InternalDbdTextEditor.g:382:2: ( ( (lv_name_0_0= 'field' ) ) otherlv_1= '(' ( (lv_fieldname_2_0= ruleFieldnames ) ) otherlv_3= ',' ( (lv_dbf_4_0= ruleDbfnames ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_fieldattributes_7_0= ruleFieldattribute ) )* otherlv_8= '}' )
            // InternalDbdTextEditor.g:383:3: ( (lv_name_0_0= 'field' ) ) otherlv_1= '(' ( (lv_fieldname_2_0= ruleFieldnames ) ) otherlv_3= ',' ( (lv_dbf_4_0= ruleDbfnames ) ) otherlv_5= ')' otherlv_6= '{' ( (lv_fieldattributes_7_0= ruleFieldattribute ) )* otherlv_8= '}'
            {
            // InternalDbdTextEditor.g:383:3: ( (lv_name_0_0= 'field' ) )
            // InternalDbdTextEditor.g:384:4: (lv_name_0_0= 'field' )
            {
            // InternalDbdTextEditor.g:384:4: (lv_name_0_0= 'field' )
            // InternalDbdTextEditor.g:385:5: lv_name_0_0= 'field'
            {
            lv_name_0_0=(Token)match(input,19,FOLLOW_5); 

            					newLeafNode(lv_name_0_0, grammarAccess.getFieldAccess().getNameFieldKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFieldRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "field");
            				

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getFieldAccess().getLeftParenthesisKeyword_1());
            		
            // InternalDbdTextEditor.g:401:3: ( (lv_fieldname_2_0= ruleFieldnames ) )
            // InternalDbdTextEditor.g:402:4: (lv_fieldname_2_0= ruleFieldnames )
            {
            // InternalDbdTextEditor.g:402:4: (lv_fieldname_2_0= ruleFieldnames )
            // InternalDbdTextEditor.g:403:5: lv_fieldname_2_0= ruleFieldnames
            {

            					newCompositeNode(grammarAccess.getFieldAccess().getFieldnameFieldnamesEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_11);
            lv_fieldname_2_0=ruleFieldnames();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFieldRule());
            					}
            					set(
            						current,
            						"fieldname",
            						lv_fieldname_2_0,
            						"org.csstudio.xtext.dbdtexteditor.DbdTextEditor.Fieldnames");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_16); 

            			newLeafNode(otherlv_3, grammarAccess.getFieldAccess().getCommaKeyword_3());
            		
            // InternalDbdTextEditor.g:424:3: ( (lv_dbf_4_0= ruleDbfnames ) )
            // InternalDbdTextEditor.g:425:4: (lv_dbf_4_0= ruleDbfnames )
            {
            // InternalDbdTextEditor.g:425:4: (lv_dbf_4_0= ruleDbfnames )
            // InternalDbdTextEditor.g:426:5: lv_dbf_4_0= ruleDbfnames
            {

            					newCompositeNode(grammarAccess.getFieldAccess().getDbfDbfnamesEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_dbf_4_0=ruleDbfnames();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFieldRule());
            					}
            					set(
            						current,
            						"dbf",
            						lv_dbf_4_0,
            						"org.csstudio.xtext.dbdtexteditor.DbdTextEditor.Dbfnames");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_5, grammarAccess.getFieldAccess().getRightParenthesisKeyword_5());
            		
            otherlv_6=(Token)match(input,14,FOLLOW_17); 

            			newLeafNode(otherlv_6, grammarAccess.getFieldAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalDbdTextEditor.g:451:3: ( (lv_fieldattributes_7_0= ruleFieldattribute ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==11||(LA5_0>=402 && LA5_0<=405)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalDbdTextEditor.g:452:4: (lv_fieldattributes_7_0= ruleFieldattribute )
            	    {
            	    // InternalDbdTextEditor.g:452:4: (lv_fieldattributes_7_0= ruleFieldattribute )
            	    // InternalDbdTextEditor.g:453:5: lv_fieldattributes_7_0= ruleFieldattribute
            	    {

            	    					newCompositeNode(grammarAccess.getFieldAccess().getFieldattributesFieldattributeParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_17);
            	    lv_fieldattributes_7_0=ruleFieldattribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFieldRule());
            	    					}
            	    					add(
            	    						current,
            	    						"fieldattributes",
            	    						lv_fieldattributes_7_0,
            	    						"org.csstudio.xtext.dbdtexteditor.DbdTextEditor.Fieldattribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_8=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getFieldAccess().getRightCurlyBracketKeyword_8());
            		

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


    // $ANTLR start "entryRuleFieldattribute"
    // InternalDbdTextEditor.g:478:1: entryRuleFieldattribute returns [EObject current=null] : iv_ruleFieldattribute= ruleFieldattribute EOF ;
    public final EObject entryRuleFieldattribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldattribute = null;


        try {
            // InternalDbdTextEditor.g:478:55: (iv_ruleFieldattribute= ruleFieldattribute EOF )
            // InternalDbdTextEditor.g:479:2: iv_ruleFieldattribute= ruleFieldattribute EOF
            {
             newCompositeNode(grammarAccess.getFieldattributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFieldattribute=ruleFieldattribute();

            state._fsp--;

             current =iv_ruleFieldattribute; 
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
    // $ANTLR end "entryRuleFieldattribute"


    // $ANTLR start "ruleFieldattribute"
    // InternalDbdTextEditor.g:485:1: ruleFieldattribute returns [EObject current=null] : ( ( (lv_fieldattribute_0_0= ruleFieldattributenames ) ) otherlv_1= '(' ( ( (lv_fieldattributestring_2_0= RULE_STRING ) ) | ( (lv_fieldattributeint_3_0= RULE_INT ) ) ) otherlv_4= ')' ) ;
    public final EObject ruleFieldattribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_fieldattributestring_2_0=null;
        Token lv_fieldattributeint_3_0=null;
        Token otherlv_4=null;
        Enumerator lv_fieldattribute_0_0 = null;



        	enterRule();

        try {
            // InternalDbdTextEditor.g:491:2: ( ( ( (lv_fieldattribute_0_0= ruleFieldattributenames ) ) otherlv_1= '(' ( ( (lv_fieldattributestring_2_0= RULE_STRING ) ) | ( (lv_fieldattributeint_3_0= RULE_INT ) ) ) otherlv_4= ')' ) )
            // InternalDbdTextEditor.g:492:2: ( ( (lv_fieldattribute_0_0= ruleFieldattributenames ) ) otherlv_1= '(' ( ( (lv_fieldattributestring_2_0= RULE_STRING ) ) | ( (lv_fieldattributeint_3_0= RULE_INT ) ) ) otherlv_4= ')' )
            {
            // InternalDbdTextEditor.g:492:2: ( ( (lv_fieldattribute_0_0= ruleFieldattributenames ) ) otherlv_1= '(' ( ( (lv_fieldattributestring_2_0= RULE_STRING ) ) | ( (lv_fieldattributeint_3_0= RULE_INT ) ) ) otherlv_4= ')' )
            // InternalDbdTextEditor.g:493:3: ( (lv_fieldattribute_0_0= ruleFieldattributenames ) ) otherlv_1= '(' ( ( (lv_fieldattributestring_2_0= RULE_STRING ) ) | ( (lv_fieldattributeint_3_0= RULE_INT ) ) ) otherlv_4= ')'
            {
            // InternalDbdTextEditor.g:493:3: ( (lv_fieldattribute_0_0= ruleFieldattributenames ) )
            // InternalDbdTextEditor.g:494:4: (lv_fieldattribute_0_0= ruleFieldattributenames )
            {
            // InternalDbdTextEditor.g:494:4: (lv_fieldattribute_0_0= ruleFieldattributenames )
            // InternalDbdTextEditor.g:495:5: lv_fieldattribute_0_0= ruleFieldattributenames
            {

            					newCompositeNode(grammarAccess.getFieldattributeAccess().getFieldattributeFieldattributenamesEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_5);
            lv_fieldattribute_0_0=ruleFieldattributenames();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFieldattributeRule());
            					}
            					set(
            						current,
            						"fieldattribute",
            						lv_fieldattribute_0_0,
            						"org.csstudio.xtext.dbdtexteditor.DbdTextEditor.Fieldattributenames");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getFieldattributeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalDbdTextEditor.g:516:3: ( ( (lv_fieldattributestring_2_0= RULE_STRING ) ) | ( (lv_fieldattributeint_3_0= RULE_INT ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_INT) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalDbdTextEditor.g:517:4: ( (lv_fieldattributestring_2_0= RULE_STRING ) )
                    {
                    // InternalDbdTextEditor.g:517:4: ( (lv_fieldattributestring_2_0= RULE_STRING ) )
                    // InternalDbdTextEditor.g:518:5: (lv_fieldattributestring_2_0= RULE_STRING )
                    {
                    // InternalDbdTextEditor.g:518:5: (lv_fieldattributestring_2_0= RULE_STRING )
                    // InternalDbdTextEditor.g:519:6: lv_fieldattributestring_2_0= RULE_STRING
                    {
                    lv_fieldattributestring_2_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

                    						newLeafNode(lv_fieldattributestring_2_0, grammarAccess.getFieldattributeAccess().getFieldattributestringSTRINGTerminalRuleCall_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFieldattributeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"fieldattributestring",
                    							lv_fieldattributestring_2_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalDbdTextEditor.g:536:4: ( (lv_fieldattributeint_3_0= RULE_INT ) )
                    {
                    // InternalDbdTextEditor.g:536:4: ( (lv_fieldattributeint_3_0= RULE_INT ) )
                    // InternalDbdTextEditor.g:537:5: (lv_fieldattributeint_3_0= RULE_INT )
                    {
                    // InternalDbdTextEditor.g:537:5: (lv_fieldattributeint_3_0= RULE_INT )
                    // InternalDbdTextEditor.g:538:6: lv_fieldattributeint_3_0= RULE_INT
                    {
                    lv_fieldattributeint_3_0=(Token)match(input,RULE_INT,FOLLOW_7); 

                    						newLeafNode(lv_fieldattributeint_3_0, grammarAccess.getFieldattributeAccess().getFieldattributeintINTTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFieldattributeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"fieldattributeint",
                    							lv_fieldattributeint_3_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getFieldattributeAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleFieldattribute"


    // $ANTLR start "ruleMenunames"
    // InternalDbdTextEditor.g:563:1: ruleMenunames returns [Enumerator current=null] : ( (enumLiteral_0= 'serialPRTY' ) | (enumLiteral_1= 'waveformPOST' ) | (enumLiteral_2= 'aaoPOST' ) | (enumLiteral_3= 'menuPriority' ) | (enumLiteral_4= 'serialSBIT' ) | (enumLiteral_5= 'calcoutDOPT' ) | (enumLiteral_6= 'SDIS' ) | (enumLiteral_7= 'menuOmsl' ) | (enumLiteral_8= 'menuFtype' ) | (enumLiteral_9= 'stringinPOST' ) | (enumLiteral_10= 'menuPini' ) | (enumLiteral_11= 'dfanoutSELM' ) | (enumLiteral_12= 'menuScan' ) | (enumLiteral_13= 'gpibACMD' ) | (enumLiteral_14= 'aSubLFLG' ) | (enumLiteral_15= 'asynTMOD' ) | (enumLiteral_16= 'scalerD1' ) | (enumLiteral_17= 'menuPost' ) | (enumLiteral_18= 'asynINTERFACE' ) | (enumLiteral_19= 'menuAlarmStat' ) | (enumLiteral_20= 'aoOIF' ) | (enumLiteral_21= 'bufferingALG' ) | (enumLiteral_22= 'aaiPOST' ) | (enumLiteral_23= 'epidFeedbackState' ) | (enumLiteral_24= 'calcoutINAV' ) | (enumLiteral_25= 'asynAUTOCONNECT' ) | (enumLiteral_26= 'asynFMT' ) | (enumLiteral_27= 'asynCONNECT' ) | (enumLiteral_28= 'gpibUCMD' ) | (enumLiteral_29= 'serialBAUD' ) | (enumLiteral_30= 'histogramCMD' ) | (enumLiteral_31= 'asynTRACE' ) | (enumLiteral_32= 'scalerG1' ) | (enumLiteral_33= 'asynEOMREASON' ) | (enumLiteral_34= 'scalerCONT' ) | (enumLiteral_35= 'menuIvoa' ) | (enumLiteral_36= 'stringoutPOST' ) | (enumLiteral_37= 'menuAlarmSevr' ) | (enumLiteral_38= 'serialMCTL' ) | (enumLiteral_39= 'serialFCTL' ) | (enumLiteral_40= 'menuSimm' ) | (enumLiteral_41= 'compressALG' ) | (enumLiteral_42= 'aSubEFLG' ) | (enumLiteral_43= 'fanoutSELM' ) | (enumLiteral_44= 'calcoutOOPT' ) | (enumLiteral_45= 'asynENABLE' ) | (enumLiteral_46= 'epidFeedbackMode' ) | (enumLiteral_47= 'menuConvert' ) | (enumLiteral_48= 'scalerCNT' ) | (enumLiteral_49= 'serialIX' ) | (enumLiteral_50= 'menuYesNo' ) | (enumLiteral_51= 'timestampTST' ) | (enumLiteral_52= 'serialDBIT' ) | (enumLiteral_53= 'selSELM' ) ) ;
    public final Enumerator ruleMenunames() throws RecognitionException {
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


        	enterRule();

        try {
            // InternalDbdTextEditor.g:569:2: ( ( (enumLiteral_0= 'serialPRTY' ) | (enumLiteral_1= 'waveformPOST' ) | (enumLiteral_2= 'aaoPOST' ) | (enumLiteral_3= 'menuPriority' ) | (enumLiteral_4= 'serialSBIT' ) | (enumLiteral_5= 'calcoutDOPT' ) | (enumLiteral_6= 'SDIS' ) | (enumLiteral_7= 'menuOmsl' ) | (enumLiteral_8= 'menuFtype' ) | (enumLiteral_9= 'stringinPOST' ) | (enumLiteral_10= 'menuPini' ) | (enumLiteral_11= 'dfanoutSELM' ) | (enumLiteral_12= 'menuScan' ) | (enumLiteral_13= 'gpibACMD' ) | (enumLiteral_14= 'aSubLFLG' ) | (enumLiteral_15= 'asynTMOD' ) | (enumLiteral_16= 'scalerD1' ) | (enumLiteral_17= 'menuPost' ) | (enumLiteral_18= 'asynINTERFACE' ) | (enumLiteral_19= 'menuAlarmStat' ) | (enumLiteral_20= 'aoOIF' ) | (enumLiteral_21= 'bufferingALG' ) | (enumLiteral_22= 'aaiPOST' ) | (enumLiteral_23= 'epidFeedbackState' ) | (enumLiteral_24= 'calcoutINAV' ) | (enumLiteral_25= 'asynAUTOCONNECT' ) | (enumLiteral_26= 'asynFMT' ) | (enumLiteral_27= 'asynCONNECT' ) | (enumLiteral_28= 'gpibUCMD' ) | (enumLiteral_29= 'serialBAUD' ) | (enumLiteral_30= 'histogramCMD' ) | (enumLiteral_31= 'asynTRACE' ) | (enumLiteral_32= 'scalerG1' ) | (enumLiteral_33= 'asynEOMREASON' ) | (enumLiteral_34= 'scalerCONT' ) | (enumLiteral_35= 'menuIvoa' ) | (enumLiteral_36= 'stringoutPOST' ) | (enumLiteral_37= 'menuAlarmSevr' ) | (enumLiteral_38= 'serialMCTL' ) | (enumLiteral_39= 'serialFCTL' ) | (enumLiteral_40= 'menuSimm' ) | (enumLiteral_41= 'compressALG' ) | (enumLiteral_42= 'aSubEFLG' ) | (enumLiteral_43= 'fanoutSELM' ) | (enumLiteral_44= 'calcoutOOPT' ) | (enumLiteral_45= 'asynENABLE' ) | (enumLiteral_46= 'epidFeedbackMode' ) | (enumLiteral_47= 'menuConvert' ) | (enumLiteral_48= 'scalerCNT' ) | (enumLiteral_49= 'serialIX' ) | (enumLiteral_50= 'menuYesNo' ) | (enumLiteral_51= 'timestampTST' ) | (enumLiteral_52= 'serialDBIT' ) | (enumLiteral_53= 'selSELM' ) ) )
            // InternalDbdTextEditor.g:570:2: ( (enumLiteral_0= 'serialPRTY' ) | (enumLiteral_1= 'waveformPOST' ) | (enumLiteral_2= 'aaoPOST' ) | (enumLiteral_3= 'menuPriority' ) | (enumLiteral_4= 'serialSBIT' ) | (enumLiteral_5= 'calcoutDOPT' ) | (enumLiteral_6= 'SDIS' ) | (enumLiteral_7= 'menuOmsl' ) | (enumLiteral_8= 'menuFtype' ) | (enumLiteral_9= 'stringinPOST' ) | (enumLiteral_10= 'menuPini' ) | (enumLiteral_11= 'dfanoutSELM' ) | (enumLiteral_12= 'menuScan' ) | (enumLiteral_13= 'gpibACMD' ) | (enumLiteral_14= 'aSubLFLG' ) | (enumLiteral_15= 'asynTMOD' ) | (enumLiteral_16= 'scalerD1' ) | (enumLiteral_17= 'menuPost' ) | (enumLiteral_18= 'asynINTERFACE' ) | (enumLiteral_19= 'menuAlarmStat' ) | (enumLiteral_20= 'aoOIF' ) | (enumLiteral_21= 'bufferingALG' ) | (enumLiteral_22= 'aaiPOST' ) | (enumLiteral_23= 'epidFeedbackState' ) | (enumLiteral_24= 'calcoutINAV' ) | (enumLiteral_25= 'asynAUTOCONNECT' ) | (enumLiteral_26= 'asynFMT' ) | (enumLiteral_27= 'asynCONNECT' ) | (enumLiteral_28= 'gpibUCMD' ) | (enumLiteral_29= 'serialBAUD' ) | (enumLiteral_30= 'histogramCMD' ) | (enumLiteral_31= 'asynTRACE' ) | (enumLiteral_32= 'scalerG1' ) | (enumLiteral_33= 'asynEOMREASON' ) | (enumLiteral_34= 'scalerCONT' ) | (enumLiteral_35= 'menuIvoa' ) | (enumLiteral_36= 'stringoutPOST' ) | (enumLiteral_37= 'menuAlarmSevr' ) | (enumLiteral_38= 'serialMCTL' ) | (enumLiteral_39= 'serialFCTL' ) | (enumLiteral_40= 'menuSimm' ) | (enumLiteral_41= 'compressALG' ) | (enumLiteral_42= 'aSubEFLG' ) | (enumLiteral_43= 'fanoutSELM' ) | (enumLiteral_44= 'calcoutOOPT' ) | (enumLiteral_45= 'asynENABLE' ) | (enumLiteral_46= 'epidFeedbackMode' ) | (enumLiteral_47= 'menuConvert' ) | (enumLiteral_48= 'scalerCNT' ) | (enumLiteral_49= 'serialIX' ) | (enumLiteral_50= 'menuYesNo' ) | (enumLiteral_51= 'timestampTST' ) | (enumLiteral_52= 'serialDBIT' ) | (enumLiteral_53= 'selSELM' ) )
            {
            // InternalDbdTextEditor.g:570:2: ( (enumLiteral_0= 'serialPRTY' ) | (enumLiteral_1= 'waveformPOST' ) | (enumLiteral_2= 'aaoPOST' ) | (enumLiteral_3= 'menuPriority' ) | (enumLiteral_4= 'serialSBIT' ) | (enumLiteral_5= 'calcoutDOPT' ) | (enumLiteral_6= 'SDIS' ) | (enumLiteral_7= 'menuOmsl' ) | (enumLiteral_8= 'menuFtype' ) | (enumLiteral_9= 'stringinPOST' ) | (enumLiteral_10= 'menuPini' ) | (enumLiteral_11= 'dfanoutSELM' ) | (enumLiteral_12= 'menuScan' ) | (enumLiteral_13= 'gpibACMD' ) | (enumLiteral_14= 'aSubLFLG' ) | (enumLiteral_15= 'asynTMOD' ) | (enumLiteral_16= 'scalerD1' ) | (enumLiteral_17= 'menuPost' ) | (enumLiteral_18= 'asynINTERFACE' ) | (enumLiteral_19= 'menuAlarmStat' ) | (enumLiteral_20= 'aoOIF' ) | (enumLiteral_21= 'bufferingALG' ) | (enumLiteral_22= 'aaiPOST' ) | (enumLiteral_23= 'epidFeedbackState' ) | (enumLiteral_24= 'calcoutINAV' ) | (enumLiteral_25= 'asynAUTOCONNECT' ) | (enumLiteral_26= 'asynFMT' ) | (enumLiteral_27= 'asynCONNECT' ) | (enumLiteral_28= 'gpibUCMD' ) | (enumLiteral_29= 'serialBAUD' ) | (enumLiteral_30= 'histogramCMD' ) | (enumLiteral_31= 'asynTRACE' ) | (enumLiteral_32= 'scalerG1' ) | (enumLiteral_33= 'asynEOMREASON' ) | (enumLiteral_34= 'scalerCONT' ) | (enumLiteral_35= 'menuIvoa' ) | (enumLiteral_36= 'stringoutPOST' ) | (enumLiteral_37= 'menuAlarmSevr' ) | (enumLiteral_38= 'serialMCTL' ) | (enumLiteral_39= 'serialFCTL' ) | (enumLiteral_40= 'menuSimm' ) | (enumLiteral_41= 'compressALG' ) | (enumLiteral_42= 'aSubEFLG' ) | (enumLiteral_43= 'fanoutSELM' ) | (enumLiteral_44= 'calcoutOOPT' ) | (enumLiteral_45= 'asynENABLE' ) | (enumLiteral_46= 'epidFeedbackMode' ) | (enumLiteral_47= 'menuConvert' ) | (enumLiteral_48= 'scalerCNT' ) | (enumLiteral_49= 'serialIX' ) | (enumLiteral_50= 'menuYesNo' ) | (enumLiteral_51= 'timestampTST' ) | (enumLiteral_52= 'serialDBIT' ) | (enumLiteral_53= 'selSELM' ) )
            int alt7=54;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt7=1;
                }
                break;
            case 21:
                {
                alt7=2;
                }
                break;
            case 22:
                {
                alt7=3;
                }
                break;
            case 23:
                {
                alt7=4;
                }
                break;
            case 24:
                {
                alt7=5;
                }
                break;
            case 25:
                {
                alt7=6;
                }
                break;
            case 26:
                {
                alt7=7;
                }
                break;
            case 27:
                {
                alt7=8;
                }
                break;
            case 28:
                {
                alt7=9;
                }
                break;
            case 29:
                {
                alt7=10;
                }
                break;
            case 30:
                {
                alt7=11;
                }
                break;
            case 31:
                {
                alt7=12;
                }
                break;
            case 32:
                {
                alt7=13;
                }
                break;
            case 33:
                {
                alt7=14;
                }
                break;
            case 34:
                {
                alt7=15;
                }
                break;
            case 35:
                {
                alt7=16;
                }
                break;
            case 36:
                {
                alt7=17;
                }
                break;
            case 37:
                {
                alt7=18;
                }
                break;
            case 38:
                {
                alt7=19;
                }
                break;
            case 39:
                {
                alt7=20;
                }
                break;
            case 40:
                {
                alt7=21;
                }
                break;
            case 41:
                {
                alt7=22;
                }
                break;
            case 42:
                {
                alt7=23;
                }
                break;
            case 43:
                {
                alt7=24;
                }
                break;
            case 44:
                {
                alt7=25;
                }
                break;
            case 45:
                {
                alt7=26;
                }
                break;
            case 46:
                {
                alt7=27;
                }
                break;
            case 47:
                {
                alt7=28;
                }
                break;
            case 48:
                {
                alt7=29;
                }
                break;
            case 49:
                {
                alt7=30;
                }
                break;
            case 50:
                {
                alt7=31;
                }
                break;
            case 51:
                {
                alt7=32;
                }
                break;
            case 52:
                {
                alt7=33;
                }
                break;
            case 53:
                {
                alt7=34;
                }
                break;
            case 54:
                {
                alt7=35;
                }
                break;
            case 55:
                {
                alt7=36;
                }
                break;
            case 56:
                {
                alt7=37;
                }
                break;
            case 57:
                {
                alt7=38;
                }
                break;
            case 58:
                {
                alt7=39;
                }
                break;
            case 59:
                {
                alt7=40;
                }
                break;
            case 60:
                {
                alt7=41;
                }
                break;
            case 61:
                {
                alt7=42;
                }
                break;
            case 62:
                {
                alt7=43;
                }
                break;
            case 63:
                {
                alt7=44;
                }
                break;
            case 64:
                {
                alt7=45;
                }
                break;
            case 65:
                {
                alt7=46;
                }
                break;
            case 66:
                {
                alt7=47;
                }
                break;
            case 67:
                {
                alt7=48;
                }
                break;
            case 68:
                {
                alt7=49;
                }
                break;
            case 69:
                {
                alt7=50;
                }
                break;
            case 70:
                {
                alt7=51;
                }
                break;
            case 71:
                {
                alt7=52;
                }
                break;
            case 72:
                {
                alt7=53;
                }
                break;
            case 73:
                {
                alt7=54;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalDbdTextEditor.g:571:3: (enumLiteral_0= 'serialPRTY' )
                    {
                    // InternalDbdTextEditor.g:571:3: (enumLiteral_0= 'serialPRTY' )
                    // InternalDbdTextEditor.g:572:4: enumLiteral_0= 'serialPRTY'
                    {
                    enumLiteral_0=(Token)match(input,20,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getSerialPRTYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMenunamesAccess().getSerialPRTYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDbdTextEditor.g:579:3: (enumLiteral_1= 'waveformPOST' )
                    {
                    // InternalDbdTextEditor.g:579:3: (enumLiteral_1= 'waveformPOST' )
                    // InternalDbdTextEditor.g:580:4: enumLiteral_1= 'waveformPOST'
                    {
                    enumLiteral_1=(Token)match(input,21,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getWaveformPOSTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMenunamesAccess().getWaveformPOSTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDbdTextEditor.g:587:3: (enumLiteral_2= 'aaoPOST' )
                    {
                    // InternalDbdTextEditor.g:587:3: (enumLiteral_2= 'aaoPOST' )
                    // InternalDbdTextEditor.g:588:4: enumLiteral_2= 'aaoPOST'
                    {
                    enumLiteral_2=(Token)match(input,22,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getAaoPOSTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getMenunamesAccess().getAaoPOSTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDbdTextEditor.g:595:3: (enumLiteral_3= 'menuPriority' )
                    {
                    // InternalDbdTextEditor.g:595:3: (enumLiteral_3= 'menuPriority' )
                    // InternalDbdTextEditor.g:596:4: enumLiteral_3= 'menuPriority'
                    {
                    enumLiteral_3=(Token)match(input,23,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getMenuPriorityEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getMenunamesAccess().getMenuPriorityEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDbdTextEditor.g:603:3: (enumLiteral_4= 'serialSBIT' )
                    {
                    // InternalDbdTextEditor.g:603:3: (enumLiteral_4= 'serialSBIT' )
                    // InternalDbdTextEditor.g:604:4: enumLiteral_4= 'serialSBIT'
                    {
                    enumLiteral_4=(Token)match(input,24,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getSerialSBITEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getMenunamesAccess().getSerialSBITEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalDbdTextEditor.g:611:3: (enumLiteral_5= 'calcoutDOPT' )
                    {
                    // InternalDbdTextEditor.g:611:3: (enumLiteral_5= 'calcoutDOPT' )
                    // InternalDbdTextEditor.g:612:4: enumLiteral_5= 'calcoutDOPT'
                    {
                    enumLiteral_5=(Token)match(input,25,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getCalcoutDOPTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getMenunamesAccess().getCalcoutDOPTEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalDbdTextEditor.g:619:3: (enumLiteral_6= 'SDIS' )
                    {
                    // InternalDbdTextEditor.g:619:3: (enumLiteral_6= 'SDIS' )
                    // InternalDbdTextEditor.g:620:4: enumLiteral_6= 'SDIS'
                    {
                    enumLiteral_6=(Token)match(input,26,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getSDISEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getMenunamesAccess().getSDISEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalDbdTextEditor.g:627:3: (enumLiteral_7= 'menuOmsl' )
                    {
                    // InternalDbdTextEditor.g:627:3: (enumLiteral_7= 'menuOmsl' )
                    // InternalDbdTextEditor.g:628:4: enumLiteral_7= 'menuOmsl'
                    {
                    enumLiteral_7=(Token)match(input,27,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getMenuOmslEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getMenunamesAccess().getMenuOmslEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalDbdTextEditor.g:635:3: (enumLiteral_8= 'menuFtype' )
                    {
                    // InternalDbdTextEditor.g:635:3: (enumLiteral_8= 'menuFtype' )
                    // InternalDbdTextEditor.g:636:4: enumLiteral_8= 'menuFtype'
                    {
                    enumLiteral_8=(Token)match(input,28,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getMenuFtypeEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getMenunamesAccess().getMenuFtypeEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalDbdTextEditor.g:643:3: (enumLiteral_9= 'stringinPOST' )
                    {
                    // InternalDbdTextEditor.g:643:3: (enumLiteral_9= 'stringinPOST' )
                    // InternalDbdTextEditor.g:644:4: enumLiteral_9= 'stringinPOST'
                    {
                    enumLiteral_9=(Token)match(input,29,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getStringinPOSTEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getMenunamesAccess().getStringinPOSTEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalDbdTextEditor.g:651:3: (enumLiteral_10= 'menuPini' )
                    {
                    // InternalDbdTextEditor.g:651:3: (enumLiteral_10= 'menuPini' )
                    // InternalDbdTextEditor.g:652:4: enumLiteral_10= 'menuPini'
                    {
                    enumLiteral_10=(Token)match(input,30,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getMenuPiniEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getMenunamesAccess().getMenuPiniEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalDbdTextEditor.g:659:3: (enumLiteral_11= 'dfanoutSELM' )
                    {
                    // InternalDbdTextEditor.g:659:3: (enumLiteral_11= 'dfanoutSELM' )
                    // InternalDbdTextEditor.g:660:4: enumLiteral_11= 'dfanoutSELM'
                    {
                    enumLiteral_11=(Token)match(input,31,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getDfanoutSELMEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getMenunamesAccess().getDfanoutSELMEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalDbdTextEditor.g:667:3: (enumLiteral_12= 'menuScan' )
                    {
                    // InternalDbdTextEditor.g:667:3: (enumLiteral_12= 'menuScan' )
                    // InternalDbdTextEditor.g:668:4: enumLiteral_12= 'menuScan'
                    {
                    enumLiteral_12=(Token)match(input,32,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getMenuScanEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getMenunamesAccess().getMenuScanEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalDbdTextEditor.g:675:3: (enumLiteral_13= 'gpibACMD' )
                    {
                    // InternalDbdTextEditor.g:675:3: (enumLiteral_13= 'gpibACMD' )
                    // InternalDbdTextEditor.g:676:4: enumLiteral_13= 'gpibACMD'
                    {
                    enumLiteral_13=(Token)match(input,33,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getGpibACMDEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getMenunamesAccess().getGpibACMDEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalDbdTextEditor.g:683:3: (enumLiteral_14= 'aSubLFLG' )
                    {
                    // InternalDbdTextEditor.g:683:3: (enumLiteral_14= 'aSubLFLG' )
                    // InternalDbdTextEditor.g:684:4: enumLiteral_14= 'aSubLFLG'
                    {
                    enumLiteral_14=(Token)match(input,34,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getASubLFLGEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getMenunamesAccess().getASubLFLGEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalDbdTextEditor.g:691:3: (enumLiteral_15= 'asynTMOD' )
                    {
                    // InternalDbdTextEditor.g:691:3: (enumLiteral_15= 'asynTMOD' )
                    // InternalDbdTextEditor.g:692:4: enumLiteral_15= 'asynTMOD'
                    {
                    enumLiteral_15=(Token)match(input,35,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getAsynTMODEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getMenunamesAccess().getAsynTMODEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalDbdTextEditor.g:699:3: (enumLiteral_16= 'scalerD1' )
                    {
                    // InternalDbdTextEditor.g:699:3: (enumLiteral_16= 'scalerD1' )
                    // InternalDbdTextEditor.g:700:4: enumLiteral_16= 'scalerD1'
                    {
                    enumLiteral_16=(Token)match(input,36,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getScalerD1EnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getMenunamesAccess().getScalerD1EnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalDbdTextEditor.g:707:3: (enumLiteral_17= 'menuPost' )
                    {
                    // InternalDbdTextEditor.g:707:3: (enumLiteral_17= 'menuPost' )
                    // InternalDbdTextEditor.g:708:4: enumLiteral_17= 'menuPost'
                    {
                    enumLiteral_17=(Token)match(input,37,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getMenuPostEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getMenunamesAccess().getMenuPostEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalDbdTextEditor.g:715:3: (enumLiteral_18= 'asynINTERFACE' )
                    {
                    // InternalDbdTextEditor.g:715:3: (enumLiteral_18= 'asynINTERFACE' )
                    // InternalDbdTextEditor.g:716:4: enumLiteral_18= 'asynINTERFACE'
                    {
                    enumLiteral_18=(Token)match(input,38,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getAsynINTERFACEEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getMenunamesAccess().getAsynINTERFACEEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalDbdTextEditor.g:723:3: (enumLiteral_19= 'menuAlarmStat' )
                    {
                    // InternalDbdTextEditor.g:723:3: (enumLiteral_19= 'menuAlarmStat' )
                    // InternalDbdTextEditor.g:724:4: enumLiteral_19= 'menuAlarmStat'
                    {
                    enumLiteral_19=(Token)match(input,39,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getMenuAlarmStatEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getMenunamesAccess().getMenuAlarmStatEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalDbdTextEditor.g:731:3: (enumLiteral_20= 'aoOIF' )
                    {
                    // InternalDbdTextEditor.g:731:3: (enumLiteral_20= 'aoOIF' )
                    // InternalDbdTextEditor.g:732:4: enumLiteral_20= 'aoOIF'
                    {
                    enumLiteral_20=(Token)match(input,40,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getAoOIFEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getMenunamesAccess().getAoOIFEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalDbdTextEditor.g:739:3: (enumLiteral_21= 'bufferingALG' )
                    {
                    // InternalDbdTextEditor.g:739:3: (enumLiteral_21= 'bufferingALG' )
                    // InternalDbdTextEditor.g:740:4: enumLiteral_21= 'bufferingALG'
                    {
                    enumLiteral_21=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getBufferingALGEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getMenunamesAccess().getBufferingALGEnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalDbdTextEditor.g:747:3: (enumLiteral_22= 'aaiPOST' )
                    {
                    // InternalDbdTextEditor.g:747:3: (enumLiteral_22= 'aaiPOST' )
                    // InternalDbdTextEditor.g:748:4: enumLiteral_22= 'aaiPOST'
                    {
                    enumLiteral_22=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getAaiPOSTEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getMenunamesAccess().getAaiPOSTEnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalDbdTextEditor.g:755:3: (enumLiteral_23= 'epidFeedbackState' )
                    {
                    // InternalDbdTextEditor.g:755:3: (enumLiteral_23= 'epidFeedbackState' )
                    // InternalDbdTextEditor.g:756:4: enumLiteral_23= 'epidFeedbackState'
                    {
                    enumLiteral_23=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getEpidFeedbackStateEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getMenunamesAccess().getEpidFeedbackStateEnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalDbdTextEditor.g:763:3: (enumLiteral_24= 'calcoutINAV' )
                    {
                    // InternalDbdTextEditor.g:763:3: (enumLiteral_24= 'calcoutINAV' )
                    // InternalDbdTextEditor.g:764:4: enumLiteral_24= 'calcoutINAV'
                    {
                    enumLiteral_24=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getCalcoutINAVEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getMenunamesAccess().getCalcoutINAVEnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalDbdTextEditor.g:771:3: (enumLiteral_25= 'asynAUTOCONNECT' )
                    {
                    // InternalDbdTextEditor.g:771:3: (enumLiteral_25= 'asynAUTOCONNECT' )
                    // InternalDbdTextEditor.g:772:4: enumLiteral_25= 'asynAUTOCONNECT'
                    {
                    enumLiteral_25=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getAsynAUTOCONNECTEnumLiteralDeclaration_25().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_25, grammarAccess.getMenunamesAccess().getAsynAUTOCONNECTEnumLiteralDeclaration_25());
                    			

                    }


                    }
                    break;
                case 27 :
                    // InternalDbdTextEditor.g:779:3: (enumLiteral_26= 'asynFMT' )
                    {
                    // InternalDbdTextEditor.g:779:3: (enumLiteral_26= 'asynFMT' )
                    // InternalDbdTextEditor.g:780:4: enumLiteral_26= 'asynFMT'
                    {
                    enumLiteral_26=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getAsynFMTEnumLiteralDeclaration_26().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_26, grammarAccess.getMenunamesAccess().getAsynFMTEnumLiteralDeclaration_26());
                    			

                    }


                    }
                    break;
                case 28 :
                    // InternalDbdTextEditor.g:787:3: (enumLiteral_27= 'asynCONNECT' )
                    {
                    // InternalDbdTextEditor.g:787:3: (enumLiteral_27= 'asynCONNECT' )
                    // InternalDbdTextEditor.g:788:4: enumLiteral_27= 'asynCONNECT'
                    {
                    enumLiteral_27=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getAsynCONNECTEnumLiteralDeclaration_27().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_27, grammarAccess.getMenunamesAccess().getAsynCONNECTEnumLiteralDeclaration_27());
                    			

                    }


                    }
                    break;
                case 29 :
                    // InternalDbdTextEditor.g:795:3: (enumLiteral_28= 'gpibUCMD' )
                    {
                    // InternalDbdTextEditor.g:795:3: (enumLiteral_28= 'gpibUCMD' )
                    // InternalDbdTextEditor.g:796:4: enumLiteral_28= 'gpibUCMD'
                    {
                    enumLiteral_28=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getGpibUCMDEnumLiteralDeclaration_28().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_28, grammarAccess.getMenunamesAccess().getGpibUCMDEnumLiteralDeclaration_28());
                    			

                    }


                    }
                    break;
                case 30 :
                    // InternalDbdTextEditor.g:803:3: (enumLiteral_29= 'serialBAUD' )
                    {
                    // InternalDbdTextEditor.g:803:3: (enumLiteral_29= 'serialBAUD' )
                    // InternalDbdTextEditor.g:804:4: enumLiteral_29= 'serialBAUD'
                    {
                    enumLiteral_29=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getSerialBAUDEnumLiteralDeclaration_29().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_29, grammarAccess.getMenunamesAccess().getSerialBAUDEnumLiteralDeclaration_29());
                    			

                    }


                    }
                    break;
                case 31 :
                    // InternalDbdTextEditor.g:811:3: (enumLiteral_30= 'histogramCMD' )
                    {
                    // InternalDbdTextEditor.g:811:3: (enumLiteral_30= 'histogramCMD' )
                    // InternalDbdTextEditor.g:812:4: enumLiteral_30= 'histogramCMD'
                    {
                    enumLiteral_30=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getHistogramCMDEnumLiteralDeclaration_30().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_30, grammarAccess.getMenunamesAccess().getHistogramCMDEnumLiteralDeclaration_30());
                    			

                    }


                    }
                    break;
                case 32 :
                    // InternalDbdTextEditor.g:819:3: (enumLiteral_31= 'asynTRACE' )
                    {
                    // InternalDbdTextEditor.g:819:3: (enumLiteral_31= 'asynTRACE' )
                    // InternalDbdTextEditor.g:820:4: enumLiteral_31= 'asynTRACE'
                    {
                    enumLiteral_31=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getAsynTRACEEnumLiteralDeclaration_31().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_31, grammarAccess.getMenunamesAccess().getAsynTRACEEnumLiteralDeclaration_31());
                    			

                    }


                    }
                    break;
                case 33 :
                    // InternalDbdTextEditor.g:827:3: (enumLiteral_32= 'scalerG1' )
                    {
                    // InternalDbdTextEditor.g:827:3: (enumLiteral_32= 'scalerG1' )
                    // InternalDbdTextEditor.g:828:4: enumLiteral_32= 'scalerG1'
                    {
                    enumLiteral_32=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getScalerG1EnumLiteralDeclaration_32().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_32, grammarAccess.getMenunamesAccess().getScalerG1EnumLiteralDeclaration_32());
                    			

                    }


                    }
                    break;
                case 34 :
                    // InternalDbdTextEditor.g:835:3: (enumLiteral_33= 'asynEOMREASON' )
                    {
                    // InternalDbdTextEditor.g:835:3: (enumLiteral_33= 'asynEOMREASON' )
                    // InternalDbdTextEditor.g:836:4: enumLiteral_33= 'asynEOMREASON'
                    {
                    enumLiteral_33=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getAsynEOMREASONEnumLiteralDeclaration_33().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_33, grammarAccess.getMenunamesAccess().getAsynEOMREASONEnumLiteralDeclaration_33());
                    			

                    }


                    }
                    break;
                case 35 :
                    // InternalDbdTextEditor.g:843:3: (enumLiteral_34= 'scalerCONT' )
                    {
                    // InternalDbdTextEditor.g:843:3: (enumLiteral_34= 'scalerCONT' )
                    // InternalDbdTextEditor.g:844:4: enumLiteral_34= 'scalerCONT'
                    {
                    enumLiteral_34=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getScalerCONTEnumLiteralDeclaration_34().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_34, grammarAccess.getMenunamesAccess().getScalerCONTEnumLiteralDeclaration_34());
                    			

                    }


                    }
                    break;
                case 36 :
                    // InternalDbdTextEditor.g:851:3: (enumLiteral_35= 'menuIvoa' )
                    {
                    // InternalDbdTextEditor.g:851:3: (enumLiteral_35= 'menuIvoa' )
                    // InternalDbdTextEditor.g:852:4: enumLiteral_35= 'menuIvoa'
                    {
                    enumLiteral_35=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getMenuIvoaEnumLiteralDeclaration_35().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_35, grammarAccess.getMenunamesAccess().getMenuIvoaEnumLiteralDeclaration_35());
                    			

                    }


                    }
                    break;
                case 37 :
                    // InternalDbdTextEditor.g:859:3: (enumLiteral_36= 'stringoutPOST' )
                    {
                    // InternalDbdTextEditor.g:859:3: (enumLiteral_36= 'stringoutPOST' )
                    // InternalDbdTextEditor.g:860:4: enumLiteral_36= 'stringoutPOST'
                    {
                    enumLiteral_36=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getStringoutPOSTEnumLiteralDeclaration_36().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_36, grammarAccess.getMenunamesAccess().getStringoutPOSTEnumLiteralDeclaration_36());
                    			

                    }


                    }
                    break;
                case 38 :
                    // InternalDbdTextEditor.g:867:3: (enumLiteral_37= 'menuAlarmSevr' )
                    {
                    // InternalDbdTextEditor.g:867:3: (enumLiteral_37= 'menuAlarmSevr' )
                    // InternalDbdTextEditor.g:868:4: enumLiteral_37= 'menuAlarmSevr'
                    {
                    enumLiteral_37=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getMenuAlarmSevrEnumLiteralDeclaration_37().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_37, grammarAccess.getMenunamesAccess().getMenuAlarmSevrEnumLiteralDeclaration_37());
                    			

                    }


                    }
                    break;
                case 39 :
                    // InternalDbdTextEditor.g:875:3: (enumLiteral_38= 'serialMCTL' )
                    {
                    // InternalDbdTextEditor.g:875:3: (enumLiteral_38= 'serialMCTL' )
                    // InternalDbdTextEditor.g:876:4: enumLiteral_38= 'serialMCTL'
                    {
                    enumLiteral_38=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getSerialMCTLEnumLiteralDeclaration_38().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_38, grammarAccess.getMenunamesAccess().getSerialMCTLEnumLiteralDeclaration_38());
                    			

                    }


                    }
                    break;
                case 40 :
                    // InternalDbdTextEditor.g:883:3: (enumLiteral_39= 'serialFCTL' )
                    {
                    // InternalDbdTextEditor.g:883:3: (enumLiteral_39= 'serialFCTL' )
                    // InternalDbdTextEditor.g:884:4: enumLiteral_39= 'serialFCTL'
                    {
                    enumLiteral_39=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getSerialFCTLEnumLiteralDeclaration_39().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_39, grammarAccess.getMenunamesAccess().getSerialFCTLEnumLiteralDeclaration_39());
                    			

                    }


                    }
                    break;
                case 41 :
                    // InternalDbdTextEditor.g:891:3: (enumLiteral_40= 'menuSimm' )
                    {
                    // InternalDbdTextEditor.g:891:3: (enumLiteral_40= 'menuSimm' )
                    // InternalDbdTextEditor.g:892:4: enumLiteral_40= 'menuSimm'
                    {
                    enumLiteral_40=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getMenuSimmEnumLiteralDeclaration_40().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_40, grammarAccess.getMenunamesAccess().getMenuSimmEnumLiteralDeclaration_40());
                    			

                    }


                    }
                    break;
                case 42 :
                    // InternalDbdTextEditor.g:899:3: (enumLiteral_41= 'compressALG' )
                    {
                    // InternalDbdTextEditor.g:899:3: (enumLiteral_41= 'compressALG' )
                    // InternalDbdTextEditor.g:900:4: enumLiteral_41= 'compressALG'
                    {
                    enumLiteral_41=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getCompressALGEnumLiteralDeclaration_41().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_41, grammarAccess.getMenunamesAccess().getCompressALGEnumLiteralDeclaration_41());
                    			

                    }


                    }
                    break;
                case 43 :
                    // InternalDbdTextEditor.g:907:3: (enumLiteral_42= 'aSubEFLG' )
                    {
                    // InternalDbdTextEditor.g:907:3: (enumLiteral_42= 'aSubEFLG' )
                    // InternalDbdTextEditor.g:908:4: enumLiteral_42= 'aSubEFLG'
                    {
                    enumLiteral_42=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getASubEFLGEnumLiteralDeclaration_42().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_42, grammarAccess.getMenunamesAccess().getASubEFLGEnumLiteralDeclaration_42());
                    			

                    }


                    }
                    break;
                case 44 :
                    // InternalDbdTextEditor.g:915:3: (enumLiteral_43= 'fanoutSELM' )
                    {
                    // InternalDbdTextEditor.g:915:3: (enumLiteral_43= 'fanoutSELM' )
                    // InternalDbdTextEditor.g:916:4: enumLiteral_43= 'fanoutSELM'
                    {
                    enumLiteral_43=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getFanoutSELMEnumLiteralDeclaration_43().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_43, grammarAccess.getMenunamesAccess().getFanoutSELMEnumLiteralDeclaration_43());
                    			

                    }


                    }
                    break;
                case 45 :
                    // InternalDbdTextEditor.g:923:3: (enumLiteral_44= 'calcoutOOPT' )
                    {
                    // InternalDbdTextEditor.g:923:3: (enumLiteral_44= 'calcoutOOPT' )
                    // InternalDbdTextEditor.g:924:4: enumLiteral_44= 'calcoutOOPT'
                    {
                    enumLiteral_44=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getCalcoutOOPTEnumLiteralDeclaration_44().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_44, grammarAccess.getMenunamesAccess().getCalcoutOOPTEnumLiteralDeclaration_44());
                    			

                    }


                    }
                    break;
                case 46 :
                    // InternalDbdTextEditor.g:931:3: (enumLiteral_45= 'asynENABLE' )
                    {
                    // InternalDbdTextEditor.g:931:3: (enumLiteral_45= 'asynENABLE' )
                    // InternalDbdTextEditor.g:932:4: enumLiteral_45= 'asynENABLE'
                    {
                    enumLiteral_45=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getAsynENABLEEnumLiteralDeclaration_45().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_45, grammarAccess.getMenunamesAccess().getAsynENABLEEnumLiteralDeclaration_45());
                    			

                    }


                    }
                    break;
                case 47 :
                    // InternalDbdTextEditor.g:939:3: (enumLiteral_46= 'epidFeedbackMode' )
                    {
                    // InternalDbdTextEditor.g:939:3: (enumLiteral_46= 'epidFeedbackMode' )
                    // InternalDbdTextEditor.g:940:4: enumLiteral_46= 'epidFeedbackMode'
                    {
                    enumLiteral_46=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getEpidFeedbackModeEnumLiteralDeclaration_46().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_46, grammarAccess.getMenunamesAccess().getEpidFeedbackModeEnumLiteralDeclaration_46());
                    			

                    }


                    }
                    break;
                case 48 :
                    // InternalDbdTextEditor.g:947:3: (enumLiteral_47= 'menuConvert' )
                    {
                    // InternalDbdTextEditor.g:947:3: (enumLiteral_47= 'menuConvert' )
                    // InternalDbdTextEditor.g:948:4: enumLiteral_47= 'menuConvert'
                    {
                    enumLiteral_47=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getMenuConvertEnumLiteralDeclaration_47().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_47, grammarAccess.getMenunamesAccess().getMenuConvertEnumLiteralDeclaration_47());
                    			

                    }


                    }
                    break;
                case 49 :
                    // InternalDbdTextEditor.g:955:3: (enumLiteral_48= 'scalerCNT' )
                    {
                    // InternalDbdTextEditor.g:955:3: (enumLiteral_48= 'scalerCNT' )
                    // InternalDbdTextEditor.g:956:4: enumLiteral_48= 'scalerCNT'
                    {
                    enumLiteral_48=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getScalerCNTEnumLiteralDeclaration_48().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_48, grammarAccess.getMenunamesAccess().getScalerCNTEnumLiteralDeclaration_48());
                    			

                    }


                    }
                    break;
                case 50 :
                    // InternalDbdTextEditor.g:963:3: (enumLiteral_49= 'serialIX' )
                    {
                    // InternalDbdTextEditor.g:963:3: (enumLiteral_49= 'serialIX' )
                    // InternalDbdTextEditor.g:964:4: enumLiteral_49= 'serialIX'
                    {
                    enumLiteral_49=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getSerialIXEnumLiteralDeclaration_49().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_49, grammarAccess.getMenunamesAccess().getSerialIXEnumLiteralDeclaration_49());
                    			

                    }


                    }
                    break;
                case 51 :
                    // InternalDbdTextEditor.g:971:3: (enumLiteral_50= 'menuYesNo' )
                    {
                    // InternalDbdTextEditor.g:971:3: (enumLiteral_50= 'menuYesNo' )
                    // InternalDbdTextEditor.g:972:4: enumLiteral_50= 'menuYesNo'
                    {
                    enumLiteral_50=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getMenuYesNoEnumLiteralDeclaration_50().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_50, grammarAccess.getMenunamesAccess().getMenuYesNoEnumLiteralDeclaration_50());
                    			

                    }


                    }
                    break;
                case 52 :
                    // InternalDbdTextEditor.g:979:3: (enumLiteral_51= 'timestampTST' )
                    {
                    // InternalDbdTextEditor.g:979:3: (enumLiteral_51= 'timestampTST' )
                    // InternalDbdTextEditor.g:980:4: enumLiteral_51= 'timestampTST'
                    {
                    enumLiteral_51=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getTimestampTSTEnumLiteralDeclaration_51().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_51, grammarAccess.getMenunamesAccess().getTimestampTSTEnumLiteralDeclaration_51());
                    			

                    }


                    }
                    break;
                case 53 :
                    // InternalDbdTextEditor.g:987:3: (enumLiteral_52= 'serialDBIT' )
                    {
                    // InternalDbdTextEditor.g:987:3: (enumLiteral_52= 'serialDBIT' )
                    // InternalDbdTextEditor.g:988:4: enumLiteral_52= 'serialDBIT'
                    {
                    enumLiteral_52=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getSerialDBITEnumLiteralDeclaration_52().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_52, grammarAccess.getMenunamesAccess().getSerialDBITEnumLiteralDeclaration_52());
                    			

                    }


                    }
                    break;
                case 54 :
                    // InternalDbdTextEditor.g:995:3: (enumLiteral_53= 'selSELM' )
                    {
                    // InternalDbdTextEditor.g:995:3: (enumLiteral_53= 'selSELM' )
                    // InternalDbdTextEditor.g:996:4: enumLiteral_53= 'selSELM'
                    {
                    enumLiteral_53=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getMenunamesAccess().getSelSELMEnumLiteralDeclaration_53().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_53, grammarAccess.getMenunamesAccess().getSelSELMEnumLiteralDeclaration_53());
                    			

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
    // $ANTLR end "ruleMenunames"


    // $ANTLR start "ruleChoicenames"
    // InternalDbdTextEditor.g:1006:1: ruleChoicenames returns [Enumerator current=null] : ( (enumLiteral_0= 'serialPRTY_unknown' ) | (enumLiteral_1= 'serialPRTY_None' ) | (enumLiteral_2= 'serialPRTY_Even' ) | (enumLiteral_3= 'serialPRTY_Odd' ) | (enumLiteral_4= 'waveformPOST_Always' ) | (enumLiteral_5= 'waveformPOST_OnChange' ) | (enumLiteral_6= 'aaoPOST_Always' ) | (enumLiteral_7= 'aaoPOST_OnChange' ) | (enumLiteral_8= 'menuPriorityLOW' ) | (enumLiteral_9= 'menuPriorityMEDIUM' ) | (enumLiteral_10= 'menuPriorityHIGH' ) | (enumLiteral_11= 'serialSBIT_unknown' ) | (enumLiteral_12= 'serialSBIT_1' ) | (enumLiteral_13= 'serialSBIT_2' ) | (enumLiteral_14= 'calcoutDOPT_Use_VAL' ) | (enumLiteral_15= 'calcoutDOPT_Use_OVAL' ) | (enumLiteral_16= 'menuOmslsupervisory' ) | (enumLiteral_17= 'menuOmslclosed_loop' ) | (enumLiteral_18= 'menuFtypeSTRING' ) | (enumLiteral_19= 'menuFtypeCHAR' ) | (enumLiteral_20= 'menuFtypeUCHAR' ) | (enumLiteral_21= 'menuFtypeSHORT' ) | (enumLiteral_22= 'menuFtypeUSHORT' ) | (enumLiteral_23= 'menuFtypeLONG' ) | (enumLiteral_24= 'menuFtypeULONG' ) | (enumLiteral_25= 'menuFtypeINT64' ) | (enumLiteral_26= 'menuFtypeUINT64' ) | (enumLiteral_27= 'menuFtypeFLOAT' ) | (enumLiteral_28= 'menuFtypeDOUBLE' ) | (enumLiteral_29= 'menuFtypeENUM' ) | (enumLiteral_30= 'stringinPOST_OnChange' ) | (enumLiteral_31= 'stringinPOST_Always' ) | (enumLiteral_32= 'menuPiniNO' ) | (enumLiteral_33= 'menuPiniYES' ) | (enumLiteral_34= 'menuPiniRUN' ) | (enumLiteral_35= 'menuPiniRUNNING' ) | (enumLiteral_36= 'menuPiniPAUSE' ) | (enumLiteral_37= 'menuPiniPAUSED' ) | (enumLiteral_38= 'dfanoutSELM_All' ) | (enumLiteral_39= 'dfanoutSELM_Specified' ) | (enumLiteral_40= 'dfanoutSELM_Mask' ) | (enumLiteral_41= 'menuScanPassive' ) | (enumLiteral_42= 'menuScanEvent' ) | (enumLiteral_43= 'menuScanI_O_Intr' ) | (enumLiteral_44= 'menuScan10_second' ) | (enumLiteral_45= 'menuScan5_second' ) | (enumLiteral_46= 'menuScan2_second' ) | (enumLiteral_47= 'menuScan1_second' ) | (enumLiteral_48= 'menuScan_5_second' ) | (enumLiteral_49= 'menuScan_2_second' ) | (enumLiteral_50= 'menuScan_1_second' ) | (enumLiteral_51= 'gpibACMD_None' ) | (enumLiteral_52= 'gpibACMD_Group_Execute_Trig___GET_' ) | (enumLiteral_53= 'gpibACMD_Go_To_Local__GTL_' ) | (enumLiteral_54= 'gpibACMD_Selected_Dev__Clear__SDC_' ) | (enumLiteral_55= 'gpibACMD_Take_Control__TCT_' ) | (enumLiteral_56= 'gpibACMD_Serial_Poll' ) | (enumLiteral_57= 'aSubLFLG_IGNORE' ) | (enumLiteral_58= 'aSubLFLG_READ' ) | (enumLiteral_59= 'asynTMOD_Write_Read' ) | (enumLiteral_60= 'asynTMOD_Write' ) | (enumLiteral_61= 'asynTMOD_Read' ) | (enumLiteral_62= 'asynTMOD_Flush' ) | (enumLiteral_63= 'asynTMOD_NoIO' ) | (enumLiteral_64= 'ipDRTO_unknown' ) | (enumLiteral_65= 'ipDRTO_No' ) | (enumLiteral_66= 'ipDRTO_Yes' ) | (enumLiteral_67= 'scalerD1_Up' ) | (enumLiteral_68= 'scalerD1_Dn' ) | (enumLiteral_69= 'menuPost_OnChange' ) | (enumLiteral_70= 'menuPost_Always' ) | (enumLiteral_71= 'asynINTERFACE_OCTET' ) | (enumLiteral_72= 'asynINTERFACE_INT32' ) | (enumLiteral_73= 'asynINTERFACE_UINT32' ) | (enumLiteral_74= 'asynINTERFACE_FLOAT64' ) | (enumLiteral_75= 'menuAlarmStatNO_ALARM' ) | (enumLiteral_76= 'menuAlarmStatREAD' ) | (enumLiteral_77= 'menuAlarmStatWRITE' ) | (enumLiteral_78= 'menuAlarmStatHIHI' ) | (enumLiteral_79= 'menuAlarmStatHIGH' ) | (enumLiteral_80= 'menuAlarmStatLOLO' ) | (enumLiteral_81= 'menuAlarmStatLOW' ) | (enumLiteral_82= 'menuAlarmStatSTATE' ) | (enumLiteral_83= 'menuAlarmStatCOS' ) | (enumLiteral_84= 'menuAlarmStatCOMM' ) | (enumLiteral_85= 'menuAlarmStatTIMEOUT' ) | (enumLiteral_86= 'menuAlarmStatHWLIMIT' ) | (enumLiteral_87= 'menuAlarmStatCALC' ) | (enumLiteral_88= 'menuAlarmStatSCAN' ) | (enumLiteral_89= 'menuAlarmStatLINK' ) | (enumLiteral_90= 'menuAlarmStatSOFT' ) | (enumLiteral_91= 'menuAlarmStatBAD_SUB' ) | (enumLiteral_92= 'menuAlarmStatUDF' ) | (enumLiteral_93= 'menuAlarmStatDISABLE' ) | (enumLiteral_94= 'menuAlarmStatSIMM' ) | (enumLiteral_95= 'menuAlarmStatREAD_ACCESS' ) | (enumLiteral_96= 'menuAlarmStatWRITE_ACCESS' ) | (enumLiteral_97= 'aoOIF_Full' ) | (enumLiteral_98= 'aoOIF_Incremental' ) | (enumLiteral_99= 'bufferingALG_FIFO' ) | (enumLiteral_100= 'bufferingALG_LIFO' ) | (enumLiteral_101= 'aaiPOST_Always' ) | (enumLiteral_102= 'aaiPOST_OnChange' ) | (enumLiteral_103= 'epidFeedbackState_Off' ) | (enumLiteral_104= 'epidFeedbackState_On' ) | (enumLiteral_105= 'calcoutINAV_EXT_NC' ) | (enumLiteral_106= 'calcoutINAV_EXT' ) | (enumLiteral_107= 'calcoutINAV_LOC' ) | (enumLiteral_108= 'calcoutINAV_CON' ) | (enumLiteral_109= 'asynAUTOCONNECT_noAutoConnect' ) | (enumLiteral_110= 'asynAUTOCONNECT_autoConnect' ) | (enumLiteral_111= 'asynFMT_ASCII' ) | (enumLiteral_112= 'asynFMT_Hybrid' ) | (enumLiteral_113= 'asynFMT_Binary' ) | (enumLiteral_114= 'seqSELM_All' ) | (enumLiteral_115= 'seqSELM_Specified' ) | (enumLiteral_116= 'seqSELM_Mask' ) | (enumLiteral_117= 'asynCONNECT_Disconnect' ) | (enumLiteral_118= 'asynCONNECT_Connect' ) | (enumLiteral_119= 'gpibUCMD_None' ) | (enumLiteral_120= 'gpibUCMD_Device_Clear__DCL_' ) | (enumLiteral_121= 'gpibUCMD_Local_Lockout__LL0_' ) | (enumLiteral_122= 'gpibUCMD_Serial_Poll_Disable__SPD_' ) | (enumLiteral_123= 'gpibUCMD_Serial_Poll_Enable__SPE_' ) | (enumLiteral_124= 'gpibUCMD_Unlisten__UNL_' ) | (enumLiteral_125= 'gpibUCMD_Untalk__UNT_' ) | (enumLiteral_126= 'serialBAUD_unknown' ) | (enumLiteral_127= 'serialBAUD_300' ) | (enumLiteral_128= 'serialBAUD_600' ) | (enumLiteral_129= 'serialBAUD_1200' ) | (enumLiteral_130= 'serialBAUD_2400' ) | (enumLiteral_131= 'serialBAUD_4800' ) | (enumLiteral_132= 'serialBAUD_9600' ) | (enumLiteral_133= 'serialBAUD_19200' ) | (enumLiteral_134= 'serialBAUD_38400' ) | (enumLiteral_135= 'serialBAUD_57600' ) | (enumLiteral_136= 'serialBAUD_115200' ) | (enumLiteral_137= 'serialBAUD_230400' ) | (enumLiteral_138= 'serialBAUD_460800' ) | (enumLiteral_139= 'serialBAUD_576000' ) | (enumLiteral_140= 'serialBAUD_921600' ) | (enumLiteral_141= 'serialBAUD_1152000' ) | (enumLiteral_142= 'histogramCMD_Read' ) | (enumLiteral_143= 'histogramCMD_Clear' ) | (enumLiteral_144= 'histogramCMD_Start' ) | (enumLiteral_145= 'histogramCMD_Stop' ) | (enumLiteral_146= 'asynTRACE_Off' ) | (enumLiteral_147= 'asynTRACE_On' ) | (enumLiteral_148= 'scalerG1_N' ) | (enumLiteral_149= 'scalerG1_Y' ) | (enumLiteral_150= 'asynEOMREASONNone' ) ) ;
    public final Enumerator ruleChoicenames() throws RecognitionException {
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
        Token enumLiteral_97=null;
        Token enumLiteral_98=null;
        Token enumLiteral_99=null;
        Token enumLiteral_100=null;
        Token enumLiteral_101=null;
        Token enumLiteral_102=null;
        Token enumLiteral_103=null;
        Token enumLiteral_104=null;
        Token enumLiteral_105=null;
        Token enumLiteral_106=null;
        Token enumLiteral_107=null;
        Token enumLiteral_108=null;
        Token enumLiteral_109=null;
        Token enumLiteral_110=null;
        Token enumLiteral_111=null;
        Token enumLiteral_112=null;
        Token enumLiteral_113=null;
        Token enumLiteral_114=null;
        Token enumLiteral_115=null;
        Token enumLiteral_116=null;
        Token enumLiteral_117=null;
        Token enumLiteral_118=null;
        Token enumLiteral_119=null;
        Token enumLiteral_120=null;
        Token enumLiteral_121=null;
        Token enumLiteral_122=null;
        Token enumLiteral_123=null;
        Token enumLiteral_124=null;
        Token enumLiteral_125=null;
        Token enumLiteral_126=null;
        Token enumLiteral_127=null;
        Token enumLiteral_128=null;
        Token enumLiteral_129=null;
        Token enumLiteral_130=null;
        Token enumLiteral_131=null;
        Token enumLiteral_132=null;
        Token enumLiteral_133=null;
        Token enumLiteral_134=null;
        Token enumLiteral_135=null;
        Token enumLiteral_136=null;
        Token enumLiteral_137=null;
        Token enumLiteral_138=null;
        Token enumLiteral_139=null;
        Token enumLiteral_140=null;
        Token enumLiteral_141=null;
        Token enumLiteral_142=null;
        Token enumLiteral_143=null;
        Token enumLiteral_144=null;
        Token enumLiteral_145=null;
        Token enumLiteral_146=null;
        Token enumLiteral_147=null;
        Token enumLiteral_148=null;
        Token enumLiteral_149=null;
        Token enumLiteral_150=null;


        	enterRule();

        try {
            // InternalDbdTextEditor.g:1012:2: ( ( (enumLiteral_0= 'serialPRTY_unknown' ) | (enumLiteral_1= 'serialPRTY_None' ) | (enumLiteral_2= 'serialPRTY_Even' ) | (enumLiteral_3= 'serialPRTY_Odd' ) | (enumLiteral_4= 'waveformPOST_Always' ) | (enumLiteral_5= 'waveformPOST_OnChange' ) | (enumLiteral_6= 'aaoPOST_Always' ) | (enumLiteral_7= 'aaoPOST_OnChange' ) | (enumLiteral_8= 'menuPriorityLOW' ) | (enumLiteral_9= 'menuPriorityMEDIUM' ) | (enumLiteral_10= 'menuPriorityHIGH' ) | (enumLiteral_11= 'serialSBIT_unknown' ) | (enumLiteral_12= 'serialSBIT_1' ) | (enumLiteral_13= 'serialSBIT_2' ) | (enumLiteral_14= 'calcoutDOPT_Use_VAL' ) | (enumLiteral_15= 'calcoutDOPT_Use_OVAL' ) | (enumLiteral_16= 'menuOmslsupervisory' ) | (enumLiteral_17= 'menuOmslclosed_loop' ) | (enumLiteral_18= 'menuFtypeSTRING' ) | (enumLiteral_19= 'menuFtypeCHAR' ) | (enumLiteral_20= 'menuFtypeUCHAR' ) | (enumLiteral_21= 'menuFtypeSHORT' ) | (enumLiteral_22= 'menuFtypeUSHORT' ) | (enumLiteral_23= 'menuFtypeLONG' ) | (enumLiteral_24= 'menuFtypeULONG' ) | (enumLiteral_25= 'menuFtypeINT64' ) | (enumLiteral_26= 'menuFtypeUINT64' ) | (enumLiteral_27= 'menuFtypeFLOAT' ) | (enumLiteral_28= 'menuFtypeDOUBLE' ) | (enumLiteral_29= 'menuFtypeENUM' ) | (enumLiteral_30= 'stringinPOST_OnChange' ) | (enumLiteral_31= 'stringinPOST_Always' ) | (enumLiteral_32= 'menuPiniNO' ) | (enumLiteral_33= 'menuPiniYES' ) | (enumLiteral_34= 'menuPiniRUN' ) | (enumLiteral_35= 'menuPiniRUNNING' ) | (enumLiteral_36= 'menuPiniPAUSE' ) | (enumLiteral_37= 'menuPiniPAUSED' ) | (enumLiteral_38= 'dfanoutSELM_All' ) | (enumLiteral_39= 'dfanoutSELM_Specified' ) | (enumLiteral_40= 'dfanoutSELM_Mask' ) | (enumLiteral_41= 'menuScanPassive' ) | (enumLiteral_42= 'menuScanEvent' ) | (enumLiteral_43= 'menuScanI_O_Intr' ) | (enumLiteral_44= 'menuScan10_second' ) | (enumLiteral_45= 'menuScan5_second' ) | (enumLiteral_46= 'menuScan2_second' ) | (enumLiteral_47= 'menuScan1_second' ) | (enumLiteral_48= 'menuScan_5_second' ) | (enumLiteral_49= 'menuScan_2_second' ) | (enumLiteral_50= 'menuScan_1_second' ) | (enumLiteral_51= 'gpibACMD_None' ) | (enumLiteral_52= 'gpibACMD_Group_Execute_Trig___GET_' ) | (enumLiteral_53= 'gpibACMD_Go_To_Local__GTL_' ) | (enumLiteral_54= 'gpibACMD_Selected_Dev__Clear__SDC_' ) | (enumLiteral_55= 'gpibACMD_Take_Control__TCT_' ) | (enumLiteral_56= 'gpibACMD_Serial_Poll' ) | (enumLiteral_57= 'aSubLFLG_IGNORE' ) | (enumLiteral_58= 'aSubLFLG_READ' ) | (enumLiteral_59= 'asynTMOD_Write_Read' ) | (enumLiteral_60= 'asynTMOD_Write' ) | (enumLiteral_61= 'asynTMOD_Read' ) | (enumLiteral_62= 'asynTMOD_Flush' ) | (enumLiteral_63= 'asynTMOD_NoIO' ) | (enumLiteral_64= 'ipDRTO_unknown' ) | (enumLiteral_65= 'ipDRTO_No' ) | (enumLiteral_66= 'ipDRTO_Yes' ) | (enumLiteral_67= 'scalerD1_Up' ) | (enumLiteral_68= 'scalerD1_Dn' ) | (enumLiteral_69= 'menuPost_OnChange' ) | (enumLiteral_70= 'menuPost_Always' ) | (enumLiteral_71= 'asynINTERFACE_OCTET' ) | (enumLiteral_72= 'asynINTERFACE_INT32' ) | (enumLiteral_73= 'asynINTERFACE_UINT32' ) | (enumLiteral_74= 'asynINTERFACE_FLOAT64' ) | (enumLiteral_75= 'menuAlarmStatNO_ALARM' ) | (enumLiteral_76= 'menuAlarmStatREAD' ) | (enumLiteral_77= 'menuAlarmStatWRITE' ) | (enumLiteral_78= 'menuAlarmStatHIHI' ) | (enumLiteral_79= 'menuAlarmStatHIGH' ) | (enumLiteral_80= 'menuAlarmStatLOLO' ) | (enumLiteral_81= 'menuAlarmStatLOW' ) | (enumLiteral_82= 'menuAlarmStatSTATE' ) | (enumLiteral_83= 'menuAlarmStatCOS' ) | (enumLiteral_84= 'menuAlarmStatCOMM' ) | (enumLiteral_85= 'menuAlarmStatTIMEOUT' ) | (enumLiteral_86= 'menuAlarmStatHWLIMIT' ) | (enumLiteral_87= 'menuAlarmStatCALC' ) | (enumLiteral_88= 'menuAlarmStatSCAN' ) | (enumLiteral_89= 'menuAlarmStatLINK' ) | (enumLiteral_90= 'menuAlarmStatSOFT' ) | (enumLiteral_91= 'menuAlarmStatBAD_SUB' ) | (enumLiteral_92= 'menuAlarmStatUDF' ) | (enumLiteral_93= 'menuAlarmStatDISABLE' ) | (enumLiteral_94= 'menuAlarmStatSIMM' ) | (enumLiteral_95= 'menuAlarmStatREAD_ACCESS' ) | (enumLiteral_96= 'menuAlarmStatWRITE_ACCESS' ) | (enumLiteral_97= 'aoOIF_Full' ) | (enumLiteral_98= 'aoOIF_Incremental' ) | (enumLiteral_99= 'bufferingALG_FIFO' ) | (enumLiteral_100= 'bufferingALG_LIFO' ) | (enumLiteral_101= 'aaiPOST_Always' ) | (enumLiteral_102= 'aaiPOST_OnChange' ) | (enumLiteral_103= 'epidFeedbackState_Off' ) | (enumLiteral_104= 'epidFeedbackState_On' ) | (enumLiteral_105= 'calcoutINAV_EXT_NC' ) | (enumLiteral_106= 'calcoutINAV_EXT' ) | (enumLiteral_107= 'calcoutINAV_LOC' ) | (enumLiteral_108= 'calcoutINAV_CON' ) | (enumLiteral_109= 'asynAUTOCONNECT_noAutoConnect' ) | (enumLiteral_110= 'asynAUTOCONNECT_autoConnect' ) | (enumLiteral_111= 'asynFMT_ASCII' ) | (enumLiteral_112= 'asynFMT_Hybrid' ) | (enumLiteral_113= 'asynFMT_Binary' ) | (enumLiteral_114= 'seqSELM_All' ) | (enumLiteral_115= 'seqSELM_Specified' ) | (enumLiteral_116= 'seqSELM_Mask' ) | (enumLiteral_117= 'asynCONNECT_Disconnect' ) | (enumLiteral_118= 'asynCONNECT_Connect' ) | (enumLiteral_119= 'gpibUCMD_None' ) | (enumLiteral_120= 'gpibUCMD_Device_Clear__DCL_' ) | (enumLiteral_121= 'gpibUCMD_Local_Lockout__LL0_' ) | (enumLiteral_122= 'gpibUCMD_Serial_Poll_Disable__SPD_' ) | (enumLiteral_123= 'gpibUCMD_Serial_Poll_Enable__SPE_' ) | (enumLiteral_124= 'gpibUCMD_Unlisten__UNL_' ) | (enumLiteral_125= 'gpibUCMD_Untalk__UNT_' ) | (enumLiteral_126= 'serialBAUD_unknown' ) | (enumLiteral_127= 'serialBAUD_300' ) | (enumLiteral_128= 'serialBAUD_600' ) | (enumLiteral_129= 'serialBAUD_1200' ) | (enumLiteral_130= 'serialBAUD_2400' ) | (enumLiteral_131= 'serialBAUD_4800' ) | (enumLiteral_132= 'serialBAUD_9600' ) | (enumLiteral_133= 'serialBAUD_19200' ) | (enumLiteral_134= 'serialBAUD_38400' ) | (enumLiteral_135= 'serialBAUD_57600' ) | (enumLiteral_136= 'serialBAUD_115200' ) | (enumLiteral_137= 'serialBAUD_230400' ) | (enumLiteral_138= 'serialBAUD_460800' ) | (enumLiteral_139= 'serialBAUD_576000' ) | (enumLiteral_140= 'serialBAUD_921600' ) | (enumLiteral_141= 'serialBAUD_1152000' ) | (enumLiteral_142= 'histogramCMD_Read' ) | (enumLiteral_143= 'histogramCMD_Clear' ) | (enumLiteral_144= 'histogramCMD_Start' ) | (enumLiteral_145= 'histogramCMD_Stop' ) | (enumLiteral_146= 'asynTRACE_Off' ) | (enumLiteral_147= 'asynTRACE_On' ) | (enumLiteral_148= 'scalerG1_N' ) | (enumLiteral_149= 'scalerG1_Y' ) | (enumLiteral_150= 'asynEOMREASONNone' ) ) )
            // InternalDbdTextEditor.g:1013:2: ( (enumLiteral_0= 'serialPRTY_unknown' ) | (enumLiteral_1= 'serialPRTY_None' ) | (enumLiteral_2= 'serialPRTY_Even' ) | (enumLiteral_3= 'serialPRTY_Odd' ) | (enumLiteral_4= 'waveformPOST_Always' ) | (enumLiteral_5= 'waveformPOST_OnChange' ) | (enumLiteral_6= 'aaoPOST_Always' ) | (enumLiteral_7= 'aaoPOST_OnChange' ) | (enumLiteral_8= 'menuPriorityLOW' ) | (enumLiteral_9= 'menuPriorityMEDIUM' ) | (enumLiteral_10= 'menuPriorityHIGH' ) | (enumLiteral_11= 'serialSBIT_unknown' ) | (enumLiteral_12= 'serialSBIT_1' ) | (enumLiteral_13= 'serialSBIT_2' ) | (enumLiteral_14= 'calcoutDOPT_Use_VAL' ) | (enumLiteral_15= 'calcoutDOPT_Use_OVAL' ) | (enumLiteral_16= 'menuOmslsupervisory' ) | (enumLiteral_17= 'menuOmslclosed_loop' ) | (enumLiteral_18= 'menuFtypeSTRING' ) | (enumLiteral_19= 'menuFtypeCHAR' ) | (enumLiteral_20= 'menuFtypeUCHAR' ) | (enumLiteral_21= 'menuFtypeSHORT' ) | (enumLiteral_22= 'menuFtypeUSHORT' ) | (enumLiteral_23= 'menuFtypeLONG' ) | (enumLiteral_24= 'menuFtypeULONG' ) | (enumLiteral_25= 'menuFtypeINT64' ) | (enumLiteral_26= 'menuFtypeUINT64' ) | (enumLiteral_27= 'menuFtypeFLOAT' ) | (enumLiteral_28= 'menuFtypeDOUBLE' ) | (enumLiteral_29= 'menuFtypeENUM' ) | (enumLiteral_30= 'stringinPOST_OnChange' ) | (enumLiteral_31= 'stringinPOST_Always' ) | (enumLiteral_32= 'menuPiniNO' ) | (enumLiteral_33= 'menuPiniYES' ) | (enumLiteral_34= 'menuPiniRUN' ) | (enumLiteral_35= 'menuPiniRUNNING' ) | (enumLiteral_36= 'menuPiniPAUSE' ) | (enumLiteral_37= 'menuPiniPAUSED' ) | (enumLiteral_38= 'dfanoutSELM_All' ) | (enumLiteral_39= 'dfanoutSELM_Specified' ) | (enumLiteral_40= 'dfanoutSELM_Mask' ) | (enumLiteral_41= 'menuScanPassive' ) | (enumLiteral_42= 'menuScanEvent' ) | (enumLiteral_43= 'menuScanI_O_Intr' ) | (enumLiteral_44= 'menuScan10_second' ) | (enumLiteral_45= 'menuScan5_second' ) | (enumLiteral_46= 'menuScan2_second' ) | (enumLiteral_47= 'menuScan1_second' ) | (enumLiteral_48= 'menuScan_5_second' ) | (enumLiteral_49= 'menuScan_2_second' ) | (enumLiteral_50= 'menuScan_1_second' ) | (enumLiteral_51= 'gpibACMD_None' ) | (enumLiteral_52= 'gpibACMD_Group_Execute_Trig___GET_' ) | (enumLiteral_53= 'gpibACMD_Go_To_Local__GTL_' ) | (enumLiteral_54= 'gpibACMD_Selected_Dev__Clear__SDC_' ) | (enumLiteral_55= 'gpibACMD_Take_Control__TCT_' ) | (enumLiteral_56= 'gpibACMD_Serial_Poll' ) | (enumLiteral_57= 'aSubLFLG_IGNORE' ) | (enumLiteral_58= 'aSubLFLG_READ' ) | (enumLiteral_59= 'asynTMOD_Write_Read' ) | (enumLiteral_60= 'asynTMOD_Write' ) | (enumLiteral_61= 'asynTMOD_Read' ) | (enumLiteral_62= 'asynTMOD_Flush' ) | (enumLiteral_63= 'asynTMOD_NoIO' ) | (enumLiteral_64= 'ipDRTO_unknown' ) | (enumLiteral_65= 'ipDRTO_No' ) | (enumLiteral_66= 'ipDRTO_Yes' ) | (enumLiteral_67= 'scalerD1_Up' ) | (enumLiteral_68= 'scalerD1_Dn' ) | (enumLiteral_69= 'menuPost_OnChange' ) | (enumLiteral_70= 'menuPost_Always' ) | (enumLiteral_71= 'asynINTERFACE_OCTET' ) | (enumLiteral_72= 'asynINTERFACE_INT32' ) | (enumLiteral_73= 'asynINTERFACE_UINT32' ) | (enumLiteral_74= 'asynINTERFACE_FLOAT64' ) | (enumLiteral_75= 'menuAlarmStatNO_ALARM' ) | (enumLiteral_76= 'menuAlarmStatREAD' ) | (enumLiteral_77= 'menuAlarmStatWRITE' ) | (enumLiteral_78= 'menuAlarmStatHIHI' ) | (enumLiteral_79= 'menuAlarmStatHIGH' ) | (enumLiteral_80= 'menuAlarmStatLOLO' ) | (enumLiteral_81= 'menuAlarmStatLOW' ) | (enumLiteral_82= 'menuAlarmStatSTATE' ) | (enumLiteral_83= 'menuAlarmStatCOS' ) | (enumLiteral_84= 'menuAlarmStatCOMM' ) | (enumLiteral_85= 'menuAlarmStatTIMEOUT' ) | (enumLiteral_86= 'menuAlarmStatHWLIMIT' ) | (enumLiteral_87= 'menuAlarmStatCALC' ) | (enumLiteral_88= 'menuAlarmStatSCAN' ) | (enumLiteral_89= 'menuAlarmStatLINK' ) | (enumLiteral_90= 'menuAlarmStatSOFT' ) | (enumLiteral_91= 'menuAlarmStatBAD_SUB' ) | (enumLiteral_92= 'menuAlarmStatUDF' ) | (enumLiteral_93= 'menuAlarmStatDISABLE' ) | (enumLiteral_94= 'menuAlarmStatSIMM' ) | (enumLiteral_95= 'menuAlarmStatREAD_ACCESS' ) | (enumLiteral_96= 'menuAlarmStatWRITE_ACCESS' ) | (enumLiteral_97= 'aoOIF_Full' ) | (enumLiteral_98= 'aoOIF_Incremental' ) | (enumLiteral_99= 'bufferingALG_FIFO' ) | (enumLiteral_100= 'bufferingALG_LIFO' ) | (enumLiteral_101= 'aaiPOST_Always' ) | (enumLiteral_102= 'aaiPOST_OnChange' ) | (enumLiteral_103= 'epidFeedbackState_Off' ) | (enumLiteral_104= 'epidFeedbackState_On' ) | (enumLiteral_105= 'calcoutINAV_EXT_NC' ) | (enumLiteral_106= 'calcoutINAV_EXT' ) | (enumLiteral_107= 'calcoutINAV_LOC' ) | (enumLiteral_108= 'calcoutINAV_CON' ) | (enumLiteral_109= 'asynAUTOCONNECT_noAutoConnect' ) | (enumLiteral_110= 'asynAUTOCONNECT_autoConnect' ) | (enumLiteral_111= 'asynFMT_ASCII' ) | (enumLiteral_112= 'asynFMT_Hybrid' ) | (enumLiteral_113= 'asynFMT_Binary' ) | (enumLiteral_114= 'seqSELM_All' ) | (enumLiteral_115= 'seqSELM_Specified' ) | (enumLiteral_116= 'seqSELM_Mask' ) | (enumLiteral_117= 'asynCONNECT_Disconnect' ) | (enumLiteral_118= 'asynCONNECT_Connect' ) | (enumLiteral_119= 'gpibUCMD_None' ) | (enumLiteral_120= 'gpibUCMD_Device_Clear__DCL_' ) | (enumLiteral_121= 'gpibUCMD_Local_Lockout__LL0_' ) | (enumLiteral_122= 'gpibUCMD_Serial_Poll_Disable__SPD_' ) | (enumLiteral_123= 'gpibUCMD_Serial_Poll_Enable__SPE_' ) | (enumLiteral_124= 'gpibUCMD_Unlisten__UNL_' ) | (enumLiteral_125= 'gpibUCMD_Untalk__UNT_' ) | (enumLiteral_126= 'serialBAUD_unknown' ) | (enumLiteral_127= 'serialBAUD_300' ) | (enumLiteral_128= 'serialBAUD_600' ) | (enumLiteral_129= 'serialBAUD_1200' ) | (enumLiteral_130= 'serialBAUD_2400' ) | (enumLiteral_131= 'serialBAUD_4800' ) | (enumLiteral_132= 'serialBAUD_9600' ) | (enumLiteral_133= 'serialBAUD_19200' ) | (enumLiteral_134= 'serialBAUD_38400' ) | (enumLiteral_135= 'serialBAUD_57600' ) | (enumLiteral_136= 'serialBAUD_115200' ) | (enumLiteral_137= 'serialBAUD_230400' ) | (enumLiteral_138= 'serialBAUD_460800' ) | (enumLiteral_139= 'serialBAUD_576000' ) | (enumLiteral_140= 'serialBAUD_921600' ) | (enumLiteral_141= 'serialBAUD_1152000' ) | (enumLiteral_142= 'histogramCMD_Read' ) | (enumLiteral_143= 'histogramCMD_Clear' ) | (enumLiteral_144= 'histogramCMD_Start' ) | (enumLiteral_145= 'histogramCMD_Stop' ) | (enumLiteral_146= 'asynTRACE_Off' ) | (enumLiteral_147= 'asynTRACE_On' ) | (enumLiteral_148= 'scalerG1_N' ) | (enumLiteral_149= 'scalerG1_Y' ) | (enumLiteral_150= 'asynEOMREASONNone' ) )
            {
            // InternalDbdTextEditor.g:1013:2: ( (enumLiteral_0= 'serialPRTY_unknown' ) | (enumLiteral_1= 'serialPRTY_None' ) | (enumLiteral_2= 'serialPRTY_Even' ) | (enumLiteral_3= 'serialPRTY_Odd' ) | (enumLiteral_4= 'waveformPOST_Always' ) | (enumLiteral_5= 'waveformPOST_OnChange' ) | (enumLiteral_6= 'aaoPOST_Always' ) | (enumLiteral_7= 'aaoPOST_OnChange' ) | (enumLiteral_8= 'menuPriorityLOW' ) | (enumLiteral_9= 'menuPriorityMEDIUM' ) | (enumLiteral_10= 'menuPriorityHIGH' ) | (enumLiteral_11= 'serialSBIT_unknown' ) | (enumLiteral_12= 'serialSBIT_1' ) | (enumLiteral_13= 'serialSBIT_2' ) | (enumLiteral_14= 'calcoutDOPT_Use_VAL' ) | (enumLiteral_15= 'calcoutDOPT_Use_OVAL' ) | (enumLiteral_16= 'menuOmslsupervisory' ) | (enumLiteral_17= 'menuOmslclosed_loop' ) | (enumLiteral_18= 'menuFtypeSTRING' ) | (enumLiteral_19= 'menuFtypeCHAR' ) | (enumLiteral_20= 'menuFtypeUCHAR' ) | (enumLiteral_21= 'menuFtypeSHORT' ) | (enumLiteral_22= 'menuFtypeUSHORT' ) | (enumLiteral_23= 'menuFtypeLONG' ) | (enumLiteral_24= 'menuFtypeULONG' ) | (enumLiteral_25= 'menuFtypeINT64' ) | (enumLiteral_26= 'menuFtypeUINT64' ) | (enumLiteral_27= 'menuFtypeFLOAT' ) | (enumLiteral_28= 'menuFtypeDOUBLE' ) | (enumLiteral_29= 'menuFtypeENUM' ) | (enumLiteral_30= 'stringinPOST_OnChange' ) | (enumLiteral_31= 'stringinPOST_Always' ) | (enumLiteral_32= 'menuPiniNO' ) | (enumLiteral_33= 'menuPiniYES' ) | (enumLiteral_34= 'menuPiniRUN' ) | (enumLiteral_35= 'menuPiniRUNNING' ) | (enumLiteral_36= 'menuPiniPAUSE' ) | (enumLiteral_37= 'menuPiniPAUSED' ) | (enumLiteral_38= 'dfanoutSELM_All' ) | (enumLiteral_39= 'dfanoutSELM_Specified' ) | (enumLiteral_40= 'dfanoutSELM_Mask' ) | (enumLiteral_41= 'menuScanPassive' ) | (enumLiteral_42= 'menuScanEvent' ) | (enumLiteral_43= 'menuScanI_O_Intr' ) | (enumLiteral_44= 'menuScan10_second' ) | (enumLiteral_45= 'menuScan5_second' ) | (enumLiteral_46= 'menuScan2_second' ) | (enumLiteral_47= 'menuScan1_second' ) | (enumLiteral_48= 'menuScan_5_second' ) | (enumLiteral_49= 'menuScan_2_second' ) | (enumLiteral_50= 'menuScan_1_second' ) | (enumLiteral_51= 'gpibACMD_None' ) | (enumLiteral_52= 'gpibACMD_Group_Execute_Trig___GET_' ) | (enumLiteral_53= 'gpibACMD_Go_To_Local__GTL_' ) | (enumLiteral_54= 'gpibACMD_Selected_Dev__Clear__SDC_' ) | (enumLiteral_55= 'gpibACMD_Take_Control__TCT_' ) | (enumLiteral_56= 'gpibACMD_Serial_Poll' ) | (enumLiteral_57= 'aSubLFLG_IGNORE' ) | (enumLiteral_58= 'aSubLFLG_READ' ) | (enumLiteral_59= 'asynTMOD_Write_Read' ) | (enumLiteral_60= 'asynTMOD_Write' ) | (enumLiteral_61= 'asynTMOD_Read' ) | (enumLiteral_62= 'asynTMOD_Flush' ) | (enumLiteral_63= 'asynTMOD_NoIO' ) | (enumLiteral_64= 'ipDRTO_unknown' ) | (enumLiteral_65= 'ipDRTO_No' ) | (enumLiteral_66= 'ipDRTO_Yes' ) | (enumLiteral_67= 'scalerD1_Up' ) | (enumLiteral_68= 'scalerD1_Dn' ) | (enumLiteral_69= 'menuPost_OnChange' ) | (enumLiteral_70= 'menuPost_Always' ) | (enumLiteral_71= 'asynINTERFACE_OCTET' ) | (enumLiteral_72= 'asynINTERFACE_INT32' ) | (enumLiteral_73= 'asynINTERFACE_UINT32' ) | (enumLiteral_74= 'asynINTERFACE_FLOAT64' ) | (enumLiteral_75= 'menuAlarmStatNO_ALARM' ) | (enumLiteral_76= 'menuAlarmStatREAD' ) | (enumLiteral_77= 'menuAlarmStatWRITE' ) | (enumLiteral_78= 'menuAlarmStatHIHI' ) | (enumLiteral_79= 'menuAlarmStatHIGH' ) | (enumLiteral_80= 'menuAlarmStatLOLO' ) | (enumLiteral_81= 'menuAlarmStatLOW' ) | (enumLiteral_82= 'menuAlarmStatSTATE' ) | (enumLiteral_83= 'menuAlarmStatCOS' ) | (enumLiteral_84= 'menuAlarmStatCOMM' ) | (enumLiteral_85= 'menuAlarmStatTIMEOUT' ) | (enumLiteral_86= 'menuAlarmStatHWLIMIT' ) | (enumLiteral_87= 'menuAlarmStatCALC' ) | (enumLiteral_88= 'menuAlarmStatSCAN' ) | (enumLiteral_89= 'menuAlarmStatLINK' ) | (enumLiteral_90= 'menuAlarmStatSOFT' ) | (enumLiteral_91= 'menuAlarmStatBAD_SUB' ) | (enumLiteral_92= 'menuAlarmStatUDF' ) | (enumLiteral_93= 'menuAlarmStatDISABLE' ) | (enumLiteral_94= 'menuAlarmStatSIMM' ) | (enumLiteral_95= 'menuAlarmStatREAD_ACCESS' ) | (enumLiteral_96= 'menuAlarmStatWRITE_ACCESS' ) | (enumLiteral_97= 'aoOIF_Full' ) | (enumLiteral_98= 'aoOIF_Incremental' ) | (enumLiteral_99= 'bufferingALG_FIFO' ) | (enumLiteral_100= 'bufferingALG_LIFO' ) | (enumLiteral_101= 'aaiPOST_Always' ) | (enumLiteral_102= 'aaiPOST_OnChange' ) | (enumLiteral_103= 'epidFeedbackState_Off' ) | (enumLiteral_104= 'epidFeedbackState_On' ) | (enumLiteral_105= 'calcoutINAV_EXT_NC' ) | (enumLiteral_106= 'calcoutINAV_EXT' ) | (enumLiteral_107= 'calcoutINAV_LOC' ) | (enumLiteral_108= 'calcoutINAV_CON' ) | (enumLiteral_109= 'asynAUTOCONNECT_noAutoConnect' ) | (enumLiteral_110= 'asynAUTOCONNECT_autoConnect' ) | (enumLiteral_111= 'asynFMT_ASCII' ) | (enumLiteral_112= 'asynFMT_Hybrid' ) | (enumLiteral_113= 'asynFMT_Binary' ) | (enumLiteral_114= 'seqSELM_All' ) | (enumLiteral_115= 'seqSELM_Specified' ) | (enumLiteral_116= 'seqSELM_Mask' ) | (enumLiteral_117= 'asynCONNECT_Disconnect' ) | (enumLiteral_118= 'asynCONNECT_Connect' ) | (enumLiteral_119= 'gpibUCMD_None' ) | (enumLiteral_120= 'gpibUCMD_Device_Clear__DCL_' ) | (enumLiteral_121= 'gpibUCMD_Local_Lockout__LL0_' ) | (enumLiteral_122= 'gpibUCMD_Serial_Poll_Disable__SPD_' ) | (enumLiteral_123= 'gpibUCMD_Serial_Poll_Enable__SPE_' ) | (enumLiteral_124= 'gpibUCMD_Unlisten__UNL_' ) | (enumLiteral_125= 'gpibUCMD_Untalk__UNT_' ) | (enumLiteral_126= 'serialBAUD_unknown' ) | (enumLiteral_127= 'serialBAUD_300' ) | (enumLiteral_128= 'serialBAUD_600' ) | (enumLiteral_129= 'serialBAUD_1200' ) | (enumLiteral_130= 'serialBAUD_2400' ) | (enumLiteral_131= 'serialBAUD_4800' ) | (enumLiteral_132= 'serialBAUD_9600' ) | (enumLiteral_133= 'serialBAUD_19200' ) | (enumLiteral_134= 'serialBAUD_38400' ) | (enumLiteral_135= 'serialBAUD_57600' ) | (enumLiteral_136= 'serialBAUD_115200' ) | (enumLiteral_137= 'serialBAUD_230400' ) | (enumLiteral_138= 'serialBAUD_460800' ) | (enumLiteral_139= 'serialBAUD_576000' ) | (enumLiteral_140= 'serialBAUD_921600' ) | (enumLiteral_141= 'serialBAUD_1152000' ) | (enumLiteral_142= 'histogramCMD_Read' ) | (enumLiteral_143= 'histogramCMD_Clear' ) | (enumLiteral_144= 'histogramCMD_Start' ) | (enumLiteral_145= 'histogramCMD_Stop' ) | (enumLiteral_146= 'asynTRACE_Off' ) | (enumLiteral_147= 'asynTRACE_On' ) | (enumLiteral_148= 'scalerG1_N' ) | (enumLiteral_149= 'scalerG1_Y' ) | (enumLiteral_150= 'asynEOMREASONNone' ) )
            int alt8=151;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt8=1;
                }
                break;
            case 75:
                {
                alt8=2;
                }
                break;
            case 76:
                {
                alt8=3;
                }
                break;
            case 77:
                {
                alt8=4;
                }
                break;
            case 78:
                {
                alt8=5;
                }
                break;
            case 79:
                {
                alt8=6;
                }
                break;
            case 80:
                {
                alt8=7;
                }
                break;
            case 81:
                {
                alt8=8;
                }
                break;
            case 82:
                {
                alt8=9;
                }
                break;
            case 83:
                {
                alt8=10;
                }
                break;
            case 84:
                {
                alt8=11;
                }
                break;
            case 85:
                {
                alt8=12;
                }
                break;
            case 86:
                {
                alt8=13;
                }
                break;
            case 87:
                {
                alt8=14;
                }
                break;
            case 88:
                {
                alt8=15;
                }
                break;
            case 89:
                {
                alt8=16;
                }
                break;
            case 90:
                {
                alt8=17;
                }
                break;
            case 91:
                {
                alt8=18;
                }
                break;
            case 92:
                {
                alt8=19;
                }
                break;
            case 93:
                {
                alt8=20;
                }
                break;
            case 94:
                {
                alt8=21;
                }
                break;
            case 95:
                {
                alt8=22;
                }
                break;
            case 96:
                {
                alt8=23;
                }
                break;
            case 97:
                {
                alt8=24;
                }
                break;
            case 98:
                {
                alt8=25;
                }
                break;
            case 99:
                {
                alt8=26;
                }
                break;
            case 100:
                {
                alt8=27;
                }
                break;
            case 101:
                {
                alt8=28;
                }
                break;
            case 102:
                {
                alt8=29;
                }
                break;
            case 103:
                {
                alt8=30;
                }
                break;
            case 104:
                {
                alt8=31;
                }
                break;
            case 105:
                {
                alt8=32;
                }
                break;
            case 106:
                {
                alt8=33;
                }
                break;
            case 107:
                {
                alt8=34;
                }
                break;
            case 108:
                {
                alt8=35;
                }
                break;
            case 109:
                {
                alt8=36;
                }
                break;
            case 110:
                {
                alt8=37;
                }
                break;
            case 111:
                {
                alt8=38;
                }
                break;
            case 112:
                {
                alt8=39;
                }
                break;
            case 113:
                {
                alt8=40;
                }
                break;
            case 114:
                {
                alt8=41;
                }
                break;
            case 115:
                {
                alt8=42;
                }
                break;
            case 116:
                {
                alt8=43;
                }
                break;
            case 117:
                {
                alt8=44;
                }
                break;
            case 118:
                {
                alt8=45;
                }
                break;
            case 119:
                {
                alt8=46;
                }
                break;
            case 120:
                {
                alt8=47;
                }
                break;
            case 121:
                {
                alt8=48;
                }
                break;
            case 122:
                {
                alt8=49;
                }
                break;
            case 123:
                {
                alt8=50;
                }
                break;
            case 124:
                {
                alt8=51;
                }
                break;
            case 125:
                {
                alt8=52;
                }
                break;
            case 126:
                {
                alt8=53;
                }
                break;
            case 127:
                {
                alt8=54;
                }
                break;
            case 128:
                {
                alt8=55;
                }
                break;
            case 129:
                {
                alt8=56;
                }
                break;
            case 130:
                {
                alt8=57;
                }
                break;
            case 131:
                {
                alt8=58;
                }
                break;
            case 132:
                {
                alt8=59;
                }
                break;
            case 133:
                {
                alt8=60;
                }
                break;
            case 134:
                {
                alt8=61;
                }
                break;
            case 135:
                {
                alt8=62;
                }
                break;
            case 136:
                {
                alt8=63;
                }
                break;
            case 137:
                {
                alt8=64;
                }
                break;
            case 138:
                {
                alt8=65;
                }
                break;
            case 139:
                {
                alt8=66;
                }
                break;
            case 140:
                {
                alt8=67;
                }
                break;
            case 141:
                {
                alt8=68;
                }
                break;
            case 142:
                {
                alt8=69;
                }
                break;
            case 143:
                {
                alt8=70;
                }
                break;
            case 144:
                {
                alt8=71;
                }
                break;
            case 145:
                {
                alt8=72;
                }
                break;
            case 146:
                {
                alt8=73;
                }
                break;
            case 147:
                {
                alt8=74;
                }
                break;
            case 148:
                {
                alt8=75;
                }
                break;
            case 149:
                {
                alt8=76;
                }
                break;
            case 150:
                {
                alt8=77;
                }
                break;
            case 151:
                {
                alt8=78;
                }
                break;
            case 152:
                {
                alt8=79;
                }
                break;
            case 153:
                {
                alt8=80;
                }
                break;
            case 154:
                {
                alt8=81;
                }
                break;
            case 155:
                {
                alt8=82;
                }
                break;
            case 156:
                {
                alt8=83;
                }
                break;
            case 157:
                {
                alt8=84;
                }
                break;
            case 158:
                {
                alt8=85;
                }
                break;
            case 159:
                {
                alt8=86;
                }
                break;
            case 160:
                {
                alt8=87;
                }
                break;
            case 161:
                {
                alt8=88;
                }
                break;
            case 162:
                {
                alt8=89;
                }
                break;
            case 163:
                {
                alt8=90;
                }
                break;
            case 164:
                {
                alt8=91;
                }
                break;
            case 165:
                {
                alt8=92;
                }
                break;
            case 166:
                {
                alt8=93;
                }
                break;
            case 167:
                {
                alt8=94;
                }
                break;
            case 168:
                {
                alt8=95;
                }
                break;
            case 169:
                {
                alt8=96;
                }
                break;
            case 170:
                {
                alt8=97;
                }
                break;
            case 171:
                {
                alt8=98;
                }
                break;
            case 172:
                {
                alt8=99;
                }
                break;
            case 173:
                {
                alt8=100;
                }
                break;
            case 174:
                {
                alt8=101;
                }
                break;
            case 175:
                {
                alt8=102;
                }
                break;
            case 176:
                {
                alt8=103;
                }
                break;
            case 177:
                {
                alt8=104;
                }
                break;
            case 178:
                {
                alt8=105;
                }
                break;
            case 179:
                {
                alt8=106;
                }
                break;
            case 180:
                {
                alt8=107;
                }
                break;
            case 181:
                {
                alt8=108;
                }
                break;
            case 182:
                {
                alt8=109;
                }
                break;
            case 183:
                {
                alt8=110;
                }
                break;
            case 184:
                {
                alt8=111;
                }
                break;
            case 185:
                {
                alt8=112;
                }
                break;
            case 186:
                {
                alt8=113;
                }
                break;
            case 187:
                {
                alt8=114;
                }
                break;
            case 188:
                {
                alt8=115;
                }
                break;
            case 189:
                {
                alt8=116;
                }
                break;
            case 190:
                {
                alt8=117;
                }
                break;
            case 191:
                {
                alt8=118;
                }
                break;
            case 192:
                {
                alt8=119;
                }
                break;
            case 193:
                {
                alt8=120;
                }
                break;
            case 194:
                {
                alt8=121;
                }
                break;
            case 195:
                {
                alt8=122;
                }
                break;
            case 196:
                {
                alt8=123;
                }
                break;
            case 197:
                {
                alt8=124;
                }
                break;
            case 198:
                {
                alt8=125;
                }
                break;
            case 199:
                {
                alt8=126;
                }
                break;
            case 200:
                {
                alt8=127;
                }
                break;
            case 201:
                {
                alt8=128;
                }
                break;
            case 202:
                {
                alt8=129;
                }
                break;
            case 203:
                {
                alt8=130;
                }
                break;
            case 204:
                {
                alt8=131;
                }
                break;
            case 205:
                {
                alt8=132;
                }
                break;
            case 206:
                {
                alt8=133;
                }
                break;
            case 207:
                {
                alt8=134;
                }
                break;
            case 208:
                {
                alt8=135;
                }
                break;
            case 209:
                {
                alt8=136;
                }
                break;
            case 210:
                {
                alt8=137;
                }
                break;
            case 211:
                {
                alt8=138;
                }
                break;
            case 212:
                {
                alt8=139;
                }
                break;
            case 213:
                {
                alt8=140;
                }
                break;
            case 214:
                {
                alt8=141;
                }
                break;
            case 215:
                {
                alt8=142;
                }
                break;
            case 216:
                {
                alt8=143;
                }
                break;
            case 217:
                {
                alt8=144;
                }
                break;
            case 218:
                {
                alt8=145;
                }
                break;
            case 219:
                {
                alt8=146;
                }
                break;
            case 220:
                {
                alt8=147;
                }
                break;
            case 221:
                {
                alt8=148;
                }
                break;
            case 222:
                {
                alt8=149;
                }
                break;
            case 223:
                {
                alt8=150;
                }
                break;
            case 224:
                {
                alt8=151;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalDbdTextEditor.g:1014:3: (enumLiteral_0= 'serialPRTY_unknown' )
                    {
                    // InternalDbdTextEditor.g:1014:3: (enumLiteral_0= 'serialPRTY_unknown' )
                    // InternalDbdTextEditor.g:1015:4: enumLiteral_0= 'serialPRTY_unknown'
                    {
                    enumLiteral_0=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialPRTY_unknownEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getChoicenamesAccess().getSerialPRTY_unknownEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDbdTextEditor.g:1022:3: (enumLiteral_1= 'serialPRTY_None' )
                    {
                    // InternalDbdTextEditor.g:1022:3: (enumLiteral_1= 'serialPRTY_None' )
                    // InternalDbdTextEditor.g:1023:4: enumLiteral_1= 'serialPRTY_None'
                    {
                    enumLiteral_1=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialPRTY_NoneEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getChoicenamesAccess().getSerialPRTY_NoneEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDbdTextEditor.g:1030:3: (enumLiteral_2= 'serialPRTY_Even' )
                    {
                    // InternalDbdTextEditor.g:1030:3: (enumLiteral_2= 'serialPRTY_Even' )
                    // InternalDbdTextEditor.g:1031:4: enumLiteral_2= 'serialPRTY_Even'
                    {
                    enumLiteral_2=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialPRTY_EvenEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getChoicenamesAccess().getSerialPRTY_EvenEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDbdTextEditor.g:1038:3: (enumLiteral_3= 'serialPRTY_Odd' )
                    {
                    // InternalDbdTextEditor.g:1038:3: (enumLiteral_3= 'serialPRTY_Odd' )
                    // InternalDbdTextEditor.g:1039:4: enumLiteral_3= 'serialPRTY_Odd'
                    {
                    enumLiteral_3=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialPRTY_OddEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getChoicenamesAccess().getSerialPRTY_OddEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDbdTextEditor.g:1046:3: (enumLiteral_4= 'waveformPOST_Always' )
                    {
                    // InternalDbdTextEditor.g:1046:3: (enumLiteral_4= 'waveformPOST_Always' )
                    // InternalDbdTextEditor.g:1047:4: enumLiteral_4= 'waveformPOST_Always'
                    {
                    enumLiteral_4=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getWaveformPOST_AlwaysEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getChoicenamesAccess().getWaveformPOST_AlwaysEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalDbdTextEditor.g:1054:3: (enumLiteral_5= 'waveformPOST_OnChange' )
                    {
                    // InternalDbdTextEditor.g:1054:3: (enumLiteral_5= 'waveformPOST_OnChange' )
                    // InternalDbdTextEditor.g:1055:4: enumLiteral_5= 'waveformPOST_OnChange'
                    {
                    enumLiteral_5=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getWaveformPOST_OnChangeEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getChoicenamesAccess().getWaveformPOST_OnChangeEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalDbdTextEditor.g:1062:3: (enumLiteral_6= 'aaoPOST_Always' )
                    {
                    // InternalDbdTextEditor.g:1062:3: (enumLiteral_6= 'aaoPOST_Always' )
                    // InternalDbdTextEditor.g:1063:4: enumLiteral_6= 'aaoPOST_Always'
                    {
                    enumLiteral_6=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAaoPOST_AlwaysEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getChoicenamesAccess().getAaoPOST_AlwaysEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalDbdTextEditor.g:1070:3: (enumLiteral_7= 'aaoPOST_OnChange' )
                    {
                    // InternalDbdTextEditor.g:1070:3: (enumLiteral_7= 'aaoPOST_OnChange' )
                    // InternalDbdTextEditor.g:1071:4: enumLiteral_7= 'aaoPOST_OnChange'
                    {
                    enumLiteral_7=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAaoPOST_OnChangeEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getChoicenamesAccess().getAaoPOST_OnChangeEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalDbdTextEditor.g:1078:3: (enumLiteral_8= 'menuPriorityLOW' )
                    {
                    // InternalDbdTextEditor.g:1078:3: (enumLiteral_8= 'menuPriorityLOW' )
                    // InternalDbdTextEditor.g:1079:4: enumLiteral_8= 'menuPriorityLOW'
                    {
                    enumLiteral_8=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuPriorityLOWEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getChoicenamesAccess().getMenuPriorityLOWEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalDbdTextEditor.g:1086:3: (enumLiteral_9= 'menuPriorityMEDIUM' )
                    {
                    // InternalDbdTextEditor.g:1086:3: (enumLiteral_9= 'menuPriorityMEDIUM' )
                    // InternalDbdTextEditor.g:1087:4: enumLiteral_9= 'menuPriorityMEDIUM'
                    {
                    enumLiteral_9=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuPriorityMEDIUMEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getChoicenamesAccess().getMenuPriorityMEDIUMEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalDbdTextEditor.g:1094:3: (enumLiteral_10= 'menuPriorityHIGH' )
                    {
                    // InternalDbdTextEditor.g:1094:3: (enumLiteral_10= 'menuPriorityHIGH' )
                    // InternalDbdTextEditor.g:1095:4: enumLiteral_10= 'menuPriorityHIGH'
                    {
                    enumLiteral_10=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuPriorityHIGHEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getChoicenamesAccess().getMenuPriorityHIGHEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalDbdTextEditor.g:1102:3: (enumLiteral_11= 'serialSBIT_unknown' )
                    {
                    // InternalDbdTextEditor.g:1102:3: (enumLiteral_11= 'serialSBIT_unknown' )
                    // InternalDbdTextEditor.g:1103:4: enumLiteral_11= 'serialSBIT_unknown'
                    {
                    enumLiteral_11=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialSBIT_unknownEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getChoicenamesAccess().getSerialSBIT_unknownEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalDbdTextEditor.g:1110:3: (enumLiteral_12= 'serialSBIT_1' )
                    {
                    // InternalDbdTextEditor.g:1110:3: (enumLiteral_12= 'serialSBIT_1' )
                    // InternalDbdTextEditor.g:1111:4: enumLiteral_12= 'serialSBIT_1'
                    {
                    enumLiteral_12=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialSBIT_1EnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getChoicenamesAccess().getSerialSBIT_1EnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalDbdTextEditor.g:1118:3: (enumLiteral_13= 'serialSBIT_2' )
                    {
                    // InternalDbdTextEditor.g:1118:3: (enumLiteral_13= 'serialSBIT_2' )
                    // InternalDbdTextEditor.g:1119:4: enumLiteral_13= 'serialSBIT_2'
                    {
                    enumLiteral_13=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialSBIT_2EnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getChoicenamesAccess().getSerialSBIT_2EnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalDbdTextEditor.g:1126:3: (enumLiteral_14= 'calcoutDOPT_Use_VAL' )
                    {
                    // InternalDbdTextEditor.g:1126:3: (enumLiteral_14= 'calcoutDOPT_Use_VAL' )
                    // InternalDbdTextEditor.g:1127:4: enumLiteral_14= 'calcoutDOPT_Use_VAL'
                    {
                    enumLiteral_14=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getCalcoutDOPT_Use_VALEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getChoicenamesAccess().getCalcoutDOPT_Use_VALEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalDbdTextEditor.g:1134:3: (enumLiteral_15= 'calcoutDOPT_Use_OVAL' )
                    {
                    // InternalDbdTextEditor.g:1134:3: (enumLiteral_15= 'calcoutDOPT_Use_OVAL' )
                    // InternalDbdTextEditor.g:1135:4: enumLiteral_15= 'calcoutDOPT_Use_OVAL'
                    {
                    enumLiteral_15=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getCalcoutDOPT_Use_OVALEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getChoicenamesAccess().getCalcoutDOPT_Use_OVALEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalDbdTextEditor.g:1142:3: (enumLiteral_16= 'menuOmslsupervisory' )
                    {
                    // InternalDbdTextEditor.g:1142:3: (enumLiteral_16= 'menuOmslsupervisory' )
                    // InternalDbdTextEditor.g:1143:4: enumLiteral_16= 'menuOmslsupervisory'
                    {
                    enumLiteral_16=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuOmslsupervisoryEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getChoicenamesAccess().getMenuOmslsupervisoryEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalDbdTextEditor.g:1150:3: (enumLiteral_17= 'menuOmslclosed_loop' )
                    {
                    // InternalDbdTextEditor.g:1150:3: (enumLiteral_17= 'menuOmslclosed_loop' )
                    // InternalDbdTextEditor.g:1151:4: enumLiteral_17= 'menuOmslclosed_loop'
                    {
                    enumLiteral_17=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuOmslclosed_loopEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getChoicenamesAccess().getMenuOmslclosed_loopEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalDbdTextEditor.g:1158:3: (enumLiteral_18= 'menuFtypeSTRING' )
                    {
                    // InternalDbdTextEditor.g:1158:3: (enumLiteral_18= 'menuFtypeSTRING' )
                    // InternalDbdTextEditor.g:1159:4: enumLiteral_18= 'menuFtypeSTRING'
                    {
                    enumLiteral_18=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuFtypeSTRINGEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getChoicenamesAccess().getMenuFtypeSTRINGEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalDbdTextEditor.g:1166:3: (enumLiteral_19= 'menuFtypeCHAR' )
                    {
                    // InternalDbdTextEditor.g:1166:3: (enumLiteral_19= 'menuFtypeCHAR' )
                    // InternalDbdTextEditor.g:1167:4: enumLiteral_19= 'menuFtypeCHAR'
                    {
                    enumLiteral_19=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuFtypeCHAREnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getChoicenamesAccess().getMenuFtypeCHAREnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalDbdTextEditor.g:1174:3: (enumLiteral_20= 'menuFtypeUCHAR' )
                    {
                    // InternalDbdTextEditor.g:1174:3: (enumLiteral_20= 'menuFtypeUCHAR' )
                    // InternalDbdTextEditor.g:1175:4: enumLiteral_20= 'menuFtypeUCHAR'
                    {
                    enumLiteral_20=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuFtypeUCHAREnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getChoicenamesAccess().getMenuFtypeUCHAREnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalDbdTextEditor.g:1182:3: (enumLiteral_21= 'menuFtypeSHORT' )
                    {
                    // InternalDbdTextEditor.g:1182:3: (enumLiteral_21= 'menuFtypeSHORT' )
                    // InternalDbdTextEditor.g:1183:4: enumLiteral_21= 'menuFtypeSHORT'
                    {
                    enumLiteral_21=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuFtypeSHORTEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getChoicenamesAccess().getMenuFtypeSHORTEnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalDbdTextEditor.g:1190:3: (enumLiteral_22= 'menuFtypeUSHORT' )
                    {
                    // InternalDbdTextEditor.g:1190:3: (enumLiteral_22= 'menuFtypeUSHORT' )
                    // InternalDbdTextEditor.g:1191:4: enumLiteral_22= 'menuFtypeUSHORT'
                    {
                    enumLiteral_22=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuFtypeUSHORTEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getChoicenamesAccess().getMenuFtypeUSHORTEnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalDbdTextEditor.g:1198:3: (enumLiteral_23= 'menuFtypeLONG' )
                    {
                    // InternalDbdTextEditor.g:1198:3: (enumLiteral_23= 'menuFtypeLONG' )
                    // InternalDbdTextEditor.g:1199:4: enumLiteral_23= 'menuFtypeLONG'
                    {
                    enumLiteral_23=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuFtypeLONGEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getChoicenamesAccess().getMenuFtypeLONGEnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalDbdTextEditor.g:1206:3: (enumLiteral_24= 'menuFtypeULONG' )
                    {
                    // InternalDbdTextEditor.g:1206:3: (enumLiteral_24= 'menuFtypeULONG' )
                    // InternalDbdTextEditor.g:1207:4: enumLiteral_24= 'menuFtypeULONG'
                    {
                    enumLiteral_24=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuFtypeULONGEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getChoicenamesAccess().getMenuFtypeULONGEnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalDbdTextEditor.g:1214:3: (enumLiteral_25= 'menuFtypeINT64' )
                    {
                    // InternalDbdTextEditor.g:1214:3: (enumLiteral_25= 'menuFtypeINT64' )
                    // InternalDbdTextEditor.g:1215:4: enumLiteral_25= 'menuFtypeINT64'
                    {
                    enumLiteral_25=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuFtypeINT64EnumLiteralDeclaration_25().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_25, grammarAccess.getChoicenamesAccess().getMenuFtypeINT64EnumLiteralDeclaration_25());
                    			

                    }


                    }
                    break;
                case 27 :
                    // InternalDbdTextEditor.g:1222:3: (enumLiteral_26= 'menuFtypeUINT64' )
                    {
                    // InternalDbdTextEditor.g:1222:3: (enumLiteral_26= 'menuFtypeUINT64' )
                    // InternalDbdTextEditor.g:1223:4: enumLiteral_26= 'menuFtypeUINT64'
                    {
                    enumLiteral_26=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuFtypeUINT64EnumLiteralDeclaration_26().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_26, grammarAccess.getChoicenamesAccess().getMenuFtypeUINT64EnumLiteralDeclaration_26());
                    			

                    }


                    }
                    break;
                case 28 :
                    // InternalDbdTextEditor.g:1230:3: (enumLiteral_27= 'menuFtypeFLOAT' )
                    {
                    // InternalDbdTextEditor.g:1230:3: (enumLiteral_27= 'menuFtypeFLOAT' )
                    // InternalDbdTextEditor.g:1231:4: enumLiteral_27= 'menuFtypeFLOAT'
                    {
                    enumLiteral_27=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuFtypeFLOATEnumLiteralDeclaration_27().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_27, grammarAccess.getChoicenamesAccess().getMenuFtypeFLOATEnumLiteralDeclaration_27());
                    			

                    }


                    }
                    break;
                case 29 :
                    // InternalDbdTextEditor.g:1238:3: (enumLiteral_28= 'menuFtypeDOUBLE' )
                    {
                    // InternalDbdTextEditor.g:1238:3: (enumLiteral_28= 'menuFtypeDOUBLE' )
                    // InternalDbdTextEditor.g:1239:4: enumLiteral_28= 'menuFtypeDOUBLE'
                    {
                    enumLiteral_28=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuFtypeDOUBLEEnumLiteralDeclaration_28().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_28, grammarAccess.getChoicenamesAccess().getMenuFtypeDOUBLEEnumLiteralDeclaration_28());
                    			

                    }


                    }
                    break;
                case 30 :
                    // InternalDbdTextEditor.g:1246:3: (enumLiteral_29= 'menuFtypeENUM' )
                    {
                    // InternalDbdTextEditor.g:1246:3: (enumLiteral_29= 'menuFtypeENUM' )
                    // InternalDbdTextEditor.g:1247:4: enumLiteral_29= 'menuFtypeENUM'
                    {
                    enumLiteral_29=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuFtypeENUMEnumLiteralDeclaration_29().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_29, grammarAccess.getChoicenamesAccess().getMenuFtypeENUMEnumLiteralDeclaration_29());
                    			

                    }


                    }
                    break;
                case 31 :
                    // InternalDbdTextEditor.g:1254:3: (enumLiteral_30= 'stringinPOST_OnChange' )
                    {
                    // InternalDbdTextEditor.g:1254:3: (enumLiteral_30= 'stringinPOST_OnChange' )
                    // InternalDbdTextEditor.g:1255:4: enumLiteral_30= 'stringinPOST_OnChange'
                    {
                    enumLiteral_30=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getStringinPOST_OnChangeEnumLiteralDeclaration_30().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_30, grammarAccess.getChoicenamesAccess().getStringinPOST_OnChangeEnumLiteralDeclaration_30());
                    			

                    }


                    }
                    break;
                case 32 :
                    // InternalDbdTextEditor.g:1262:3: (enumLiteral_31= 'stringinPOST_Always' )
                    {
                    // InternalDbdTextEditor.g:1262:3: (enumLiteral_31= 'stringinPOST_Always' )
                    // InternalDbdTextEditor.g:1263:4: enumLiteral_31= 'stringinPOST_Always'
                    {
                    enumLiteral_31=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getStringinPOST_AlwaysEnumLiteralDeclaration_31().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_31, grammarAccess.getChoicenamesAccess().getStringinPOST_AlwaysEnumLiteralDeclaration_31());
                    			

                    }


                    }
                    break;
                case 33 :
                    // InternalDbdTextEditor.g:1270:3: (enumLiteral_32= 'menuPiniNO' )
                    {
                    // InternalDbdTextEditor.g:1270:3: (enumLiteral_32= 'menuPiniNO' )
                    // InternalDbdTextEditor.g:1271:4: enumLiteral_32= 'menuPiniNO'
                    {
                    enumLiteral_32=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuPiniNOEnumLiteralDeclaration_32().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_32, grammarAccess.getChoicenamesAccess().getMenuPiniNOEnumLiteralDeclaration_32());
                    			

                    }


                    }
                    break;
                case 34 :
                    // InternalDbdTextEditor.g:1278:3: (enumLiteral_33= 'menuPiniYES' )
                    {
                    // InternalDbdTextEditor.g:1278:3: (enumLiteral_33= 'menuPiniYES' )
                    // InternalDbdTextEditor.g:1279:4: enumLiteral_33= 'menuPiniYES'
                    {
                    enumLiteral_33=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuPiniYESEnumLiteralDeclaration_33().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_33, grammarAccess.getChoicenamesAccess().getMenuPiniYESEnumLiteralDeclaration_33());
                    			

                    }


                    }
                    break;
                case 35 :
                    // InternalDbdTextEditor.g:1286:3: (enumLiteral_34= 'menuPiniRUN' )
                    {
                    // InternalDbdTextEditor.g:1286:3: (enumLiteral_34= 'menuPiniRUN' )
                    // InternalDbdTextEditor.g:1287:4: enumLiteral_34= 'menuPiniRUN'
                    {
                    enumLiteral_34=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuPiniRUNEnumLiteralDeclaration_34().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_34, grammarAccess.getChoicenamesAccess().getMenuPiniRUNEnumLiteralDeclaration_34());
                    			

                    }


                    }
                    break;
                case 36 :
                    // InternalDbdTextEditor.g:1294:3: (enumLiteral_35= 'menuPiniRUNNING' )
                    {
                    // InternalDbdTextEditor.g:1294:3: (enumLiteral_35= 'menuPiniRUNNING' )
                    // InternalDbdTextEditor.g:1295:4: enumLiteral_35= 'menuPiniRUNNING'
                    {
                    enumLiteral_35=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuPiniRUNNINGEnumLiteralDeclaration_35().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_35, grammarAccess.getChoicenamesAccess().getMenuPiniRUNNINGEnumLiteralDeclaration_35());
                    			

                    }


                    }
                    break;
                case 37 :
                    // InternalDbdTextEditor.g:1302:3: (enumLiteral_36= 'menuPiniPAUSE' )
                    {
                    // InternalDbdTextEditor.g:1302:3: (enumLiteral_36= 'menuPiniPAUSE' )
                    // InternalDbdTextEditor.g:1303:4: enumLiteral_36= 'menuPiniPAUSE'
                    {
                    enumLiteral_36=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuPiniPAUSEEnumLiteralDeclaration_36().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_36, grammarAccess.getChoicenamesAccess().getMenuPiniPAUSEEnumLiteralDeclaration_36());
                    			

                    }


                    }
                    break;
                case 38 :
                    // InternalDbdTextEditor.g:1310:3: (enumLiteral_37= 'menuPiniPAUSED' )
                    {
                    // InternalDbdTextEditor.g:1310:3: (enumLiteral_37= 'menuPiniPAUSED' )
                    // InternalDbdTextEditor.g:1311:4: enumLiteral_37= 'menuPiniPAUSED'
                    {
                    enumLiteral_37=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuPiniPAUSEDEnumLiteralDeclaration_37().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_37, grammarAccess.getChoicenamesAccess().getMenuPiniPAUSEDEnumLiteralDeclaration_37());
                    			

                    }


                    }
                    break;
                case 39 :
                    // InternalDbdTextEditor.g:1318:3: (enumLiteral_38= 'dfanoutSELM_All' )
                    {
                    // InternalDbdTextEditor.g:1318:3: (enumLiteral_38= 'dfanoutSELM_All' )
                    // InternalDbdTextEditor.g:1319:4: enumLiteral_38= 'dfanoutSELM_All'
                    {
                    enumLiteral_38=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getDfanoutSELM_AllEnumLiteralDeclaration_38().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_38, grammarAccess.getChoicenamesAccess().getDfanoutSELM_AllEnumLiteralDeclaration_38());
                    			

                    }


                    }
                    break;
                case 40 :
                    // InternalDbdTextEditor.g:1326:3: (enumLiteral_39= 'dfanoutSELM_Specified' )
                    {
                    // InternalDbdTextEditor.g:1326:3: (enumLiteral_39= 'dfanoutSELM_Specified' )
                    // InternalDbdTextEditor.g:1327:4: enumLiteral_39= 'dfanoutSELM_Specified'
                    {
                    enumLiteral_39=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getDfanoutSELM_SpecifiedEnumLiteralDeclaration_39().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_39, grammarAccess.getChoicenamesAccess().getDfanoutSELM_SpecifiedEnumLiteralDeclaration_39());
                    			

                    }


                    }
                    break;
                case 41 :
                    // InternalDbdTextEditor.g:1334:3: (enumLiteral_40= 'dfanoutSELM_Mask' )
                    {
                    // InternalDbdTextEditor.g:1334:3: (enumLiteral_40= 'dfanoutSELM_Mask' )
                    // InternalDbdTextEditor.g:1335:4: enumLiteral_40= 'dfanoutSELM_Mask'
                    {
                    enumLiteral_40=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getDfanoutSELM_MaskEnumLiteralDeclaration_40().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_40, grammarAccess.getChoicenamesAccess().getDfanoutSELM_MaskEnumLiteralDeclaration_40());
                    			

                    }


                    }
                    break;
                case 42 :
                    // InternalDbdTextEditor.g:1342:3: (enumLiteral_41= 'menuScanPassive' )
                    {
                    // InternalDbdTextEditor.g:1342:3: (enumLiteral_41= 'menuScanPassive' )
                    // InternalDbdTextEditor.g:1343:4: enumLiteral_41= 'menuScanPassive'
                    {
                    enumLiteral_41=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuScanPassiveEnumLiteralDeclaration_41().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_41, grammarAccess.getChoicenamesAccess().getMenuScanPassiveEnumLiteralDeclaration_41());
                    			

                    }


                    }
                    break;
                case 43 :
                    // InternalDbdTextEditor.g:1350:3: (enumLiteral_42= 'menuScanEvent' )
                    {
                    // InternalDbdTextEditor.g:1350:3: (enumLiteral_42= 'menuScanEvent' )
                    // InternalDbdTextEditor.g:1351:4: enumLiteral_42= 'menuScanEvent'
                    {
                    enumLiteral_42=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuScanEventEnumLiteralDeclaration_42().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_42, grammarAccess.getChoicenamesAccess().getMenuScanEventEnumLiteralDeclaration_42());
                    			

                    }


                    }
                    break;
                case 44 :
                    // InternalDbdTextEditor.g:1358:3: (enumLiteral_43= 'menuScanI_O_Intr' )
                    {
                    // InternalDbdTextEditor.g:1358:3: (enumLiteral_43= 'menuScanI_O_Intr' )
                    // InternalDbdTextEditor.g:1359:4: enumLiteral_43= 'menuScanI_O_Intr'
                    {
                    enumLiteral_43=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuScanI_O_IntrEnumLiteralDeclaration_43().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_43, grammarAccess.getChoicenamesAccess().getMenuScanI_O_IntrEnumLiteralDeclaration_43());
                    			

                    }


                    }
                    break;
                case 45 :
                    // InternalDbdTextEditor.g:1366:3: (enumLiteral_44= 'menuScan10_second' )
                    {
                    // InternalDbdTextEditor.g:1366:3: (enumLiteral_44= 'menuScan10_second' )
                    // InternalDbdTextEditor.g:1367:4: enumLiteral_44= 'menuScan10_second'
                    {
                    enumLiteral_44=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuScan10_secondEnumLiteralDeclaration_44().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_44, grammarAccess.getChoicenamesAccess().getMenuScan10_secondEnumLiteralDeclaration_44());
                    			

                    }


                    }
                    break;
                case 46 :
                    // InternalDbdTextEditor.g:1374:3: (enumLiteral_45= 'menuScan5_second' )
                    {
                    // InternalDbdTextEditor.g:1374:3: (enumLiteral_45= 'menuScan5_second' )
                    // InternalDbdTextEditor.g:1375:4: enumLiteral_45= 'menuScan5_second'
                    {
                    enumLiteral_45=(Token)match(input,119,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuScan5_secondEnumLiteralDeclaration_45().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_45, grammarAccess.getChoicenamesAccess().getMenuScan5_secondEnumLiteralDeclaration_45());
                    			

                    }


                    }
                    break;
                case 47 :
                    // InternalDbdTextEditor.g:1382:3: (enumLiteral_46= 'menuScan2_second' )
                    {
                    // InternalDbdTextEditor.g:1382:3: (enumLiteral_46= 'menuScan2_second' )
                    // InternalDbdTextEditor.g:1383:4: enumLiteral_46= 'menuScan2_second'
                    {
                    enumLiteral_46=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuScan2_secondEnumLiteralDeclaration_46().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_46, grammarAccess.getChoicenamesAccess().getMenuScan2_secondEnumLiteralDeclaration_46());
                    			

                    }


                    }
                    break;
                case 48 :
                    // InternalDbdTextEditor.g:1390:3: (enumLiteral_47= 'menuScan1_second' )
                    {
                    // InternalDbdTextEditor.g:1390:3: (enumLiteral_47= 'menuScan1_second' )
                    // InternalDbdTextEditor.g:1391:4: enumLiteral_47= 'menuScan1_second'
                    {
                    enumLiteral_47=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuScan1_secondEnumLiteralDeclaration_47().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_47, grammarAccess.getChoicenamesAccess().getMenuScan1_secondEnumLiteralDeclaration_47());
                    			

                    }


                    }
                    break;
                case 49 :
                    // InternalDbdTextEditor.g:1398:3: (enumLiteral_48= 'menuScan_5_second' )
                    {
                    // InternalDbdTextEditor.g:1398:3: (enumLiteral_48= 'menuScan_5_second' )
                    // InternalDbdTextEditor.g:1399:4: enumLiteral_48= 'menuScan_5_second'
                    {
                    enumLiteral_48=(Token)match(input,122,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuScan_5_secondEnumLiteralDeclaration_48().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_48, grammarAccess.getChoicenamesAccess().getMenuScan_5_secondEnumLiteralDeclaration_48());
                    			

                    }


                    }
                    break;
                case 50 :
                    // InternalDbdTextEditor.g:1406:3: (enumLiteral_49= 'menuScan_2_second' )
                    {
                    // InternalDbdTextEditor.g:1406:3: (enumLiteral_49= 'menuScan_2_second' )
                    // InternalDbdTextEditor.g:1407:4: enumLiteral_49= 'menuScan_2_second'
                    {
                    enumLiteral_49=(Token)match(input,123,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuScan_2_secondEnumLiteralDeclaration_49().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_49, grammarAccess.getChoicenamesAccess().getMenuScan_2_secondEnumLiteralDeclaration_49());
                    			

                    }


                    }
                    break;
                case 51 :
                    // InternalDbdTextEditor.g:1414:3: (enumLiteral_50= 'menuScan_1_second' )
                    {
                    // InternalDbdTextEditor.g:1414:3: (enumLiteral_50= 'menuScan_1_second' )
                    // InternalDbdTextEditor.g:1415:4: enumLiteral_50= 'menuScan_1_second'
                    {
                    enumLiteral_50=(Token)match(input,124,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuScan_1_secondEnumLiteralDeclaration_50().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_50, grammarAccess.getChoicenamesAccess().getMenuScan_1_secondEnumLiteralDeclaration_50());
                    			

                    }


                    }
                    break;
                case 52 :
                    // InternalDbdTextEditor.g:1422:3: (enumLiteral_51= 'gpibACMD_None' )
                    {
                    // InternalDbdTextEditor.g:1422:3: (enumLiteral_51= 'gpibACMD_None' )
                    // InternalDbdTextEditor.g:1423:4: enumLiteral_51= 'gpibACMD_None'
                    {
                    enumLiteral_51=(Token)match(input,125,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getGpibACMD_NoneEnumLiteralDeclaration_51().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_51, grammarAccess.getChoicenamesAccess().getGpibACMD_NoneEnumLiteralDeclaration_51());
                    			

                    }


                    }
                    break;
                case 53 :
                    // InternalDbdTextEditor.g:1430:3: (enumLiteral_52= 'gpibACMD_Group_Execute_Trig___GET_' )
                    {
                    // InternalDbdTextEditor.g:1430:3: (enumLiteral_52= 'gpibACMD_Group_Execute_Trig___GET_' )
                    // InternalDbdTextEditor.g:1431:4: enumLiteral_52= 'gpibACMD_Group_Execute_Trig___GET_'
                    {
                    enumLiteral_52=(Token)match(input,126,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getGpibACMD_Group_Execute_Trig___GET_EnumLiteralDeclaration_52().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_52, grammarAccess.getChoicenamesAccess().getGpibACMD_Group_Execute_Trig___GET_EnumLiteralDeclaration_52());
                    			

                    }


                    }
                    break;
                case 54 :
                    // InternalDbdTextEditor.g:1438:3: (enumLiteral_53= 'gpibACMD_Go_To_Local__GTL_' )
                    {
                    // InternalDbdTextEditor.g:1438:3: (enumLiteral_53= 'gpibACMD_Go_To_Local__GTL_' )
                    // InternalDbdTextEditor.g:1439:4: enumLiteral_53= 'gpibACMD_Go_To_Local__GTL_'
                    {
                    enumLiteral_53=(Token)match(input,127,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getGpibACMD_Go_To_Local__GTL_EnumLiteralDeclaration_53().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_53, grammarAccess.getChoicenamesAccess().getGpibACMD_Go_To_Local__GTL_EnumLiteralDeclaration_53());
                    			

                    }


                    }
                    break;
                case 55 :
                    // InternalDbdTextEditor.g:1446:3: (enumLiteral_54= 'gpibACMD_Selected_Dev__Clear__SDC_' )
                    {
                    // InternalDbdTextEditor.g:1446:3: (enumLiteral_54= 'gpibACMD_Selected_Dev__Clear__SDC_' )
                    // InternalDbdTextEditor.g:1447:4: enumLiteral_54= 'gpibACMD_Selected_Dev__Clear__SDC_'
                    {
                    enumLiteral_54=(Token)match(input,128,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getGpibACMD_Selected_Dev__Clear__SDC_EnumLiteralDeclaration_54().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_54, grammarAccess.getChoicenamesAccess().getGpibACMD_Selected_Dev__Clear__SDC_EnumLiteralDeclaration_54());
                    			

                    }


                    }
                    break;
                case 56 :
                    // InternalDbdTextEditor.g:1454:3: (enumLiteral_55= 'gpibACMD_Take_Control__TCT_' )
                    {
                    // InternalDbdTextEditor.g:1454:3: (enumLiteral_55= 'gpibACMD_Take_Control__TCT_' )
                    // InternalDbdTextEditor.g:1455:4: enumLiteral_55= 'gpibACMD_Take_Control__TCT_'
                    {
                    enumLiteral_55=(Token)match(input,129,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getGpibACMD_Take_Control__TCT_EnumLiteralDeclaration_55().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_55, grammarAccess.getChoicenamesAccess().getGpibACMD_Take_Control__TCT_EnumLiteralDeclaration_55());
                    			

                    }


                    }
                    break;
                case 57 :
                    // InternalDbdTextEditor.g:1462:3: (enumLiteral_56= 'gpibACMD_Serial_Poll' )
                    {
                    // InternalDbdTextEditor.g:1462:3: (enumLiteral_56= 'gpibACMD_Serial_Poll' )
                    // InternalDbdTextEditor.g:1463:4: enumLiteral_56= 'gpibACMD_Serial_Poll'
                    {
                    enumLiteral_56=(Token)match(input,130,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getGpibACMD_Serial_PollEnumLiteralDeclaration_56().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_56, grammarAccess.getChoicenamesAccess().getGpibACMD_Serial_PollEnumLiteralDeclaration_56());
                    			

                    }


                    }
                    break;
                case 58 :
                    // InternalDbdTextEditor.g:1470:3: (enumLiteral_57= 'aSubLFLG_IGNORE' )
                    {
                    // InternalDbdTextEditor.g:1470:3: (enumLiteral_57= 'aSubLFLG_IGNORE' )
                    // InternalDbdTextEditor.g:1471:4: enumLiteral_57= 'aSubLFLG_IGNORE'
                    {
                    enumLiteral_57=(Token)match(input,131,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getASubLFLG_IGNOREEnumLiteralDeclaration_57().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_57, grammarAccess.getChoicenamesAccess().getASubLFLG_IGNOREEnumLiteralDeclaration_57());
                    			

                    }


                    }
                    break;
                case 59 :
                    // InternalDbdTextEditor.g:1478:3: (enumLiteral_58= 'aSubLFLG_READ' )
                    {
                    // InternalDbdTextEditor.g:1478:3: (enumLiteral_58= 'aSubLFLG_READ' )
                    // InternalDbdTextEditor.g:1479:4: enumLiteral_58= 'aSubLFLG_READ'
                    {
                    enumLiteral_58=(Token)match(input,132,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getASubLFLG_READEnumLiteralDeclaration_58().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_58, grammarAccess.getChoicenamesAccess().getASubLFLG_READEnumLiteralDeclaration_58());
                    			

                    }


                    }
                    break;
                case 60 :
                    // InternalDbdTextEditor.g:1486:3: (enumLiteral_59= 'asynTMOD_Write_Read' )
                    {
                    // InternalDbdTextEditor.g:1486:3: (enumLiteral_59= 'asynTMOD_Write_Read' )
                    // InternalDbdTextEditor.g:1487:4: enumLiteral_59= 'asynTMOD_Write_Read'
                    {
                    enumLiteral_59=(Token)match(input,133,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynTMOD_Write_ReadEnumLiteralDeclaration_59().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_59, grammarAccess.getChoicenamesAccess().getAsynTMOD_Write_ReadEnumLiteralDeclaration_59());
                    			

                    }


                    }
                    break;
                case 61 :
                    // InternalDbdTextEditor.g:1494:3: (enumLiteral_60= 'asynTMOD_Write' )
                    {
                    // InternalDbdTextEditor.g:1494:3: (enumLiteral_60= 'asynTMOD_Write' )
                    // InternalDbdTextEditor.g:1495:4: enumLiteral_60= 'asynTMOD_Write'
                    {
                    enumLiteral_60=(Token)match(input,134,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynTMOD_WriteEnumLiteralDeclaration_60().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_60, grammarAccess.getChoicenamesAccess().getAsynTMOD_WriteEnumLiteralDeclaration_60());
                    			

                    }


                    }
                    break;
                case 62 :
                    // InternalDbdTextEditor.g:1502:3: (enumLiteral_61= 'asynTMOD_Read' )
                    {
                    // InternalDbdTextEditor.g:1502:3: (enumLiteral_61= 'asynTMOD_Read' )
                    // InternalDbdTextEditor.g:1503:4: enumLiteral_61= 'asynTMOD_Read'
                    {
                    enumLiteral_61=(Token)match(input,135,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynTMOD_ReadEnumLiteralDeclaration_61().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_61, grammarAccess.getChoicenamesAccess().getAsynTMOD_ReadEnumLiteralDeclaration_61());
                    			

                    }


                    }
                    break;
                case 63 :
                    // InternalDbdTextEditor.g:1510:3: (enumLiteral_62= 'asynTMOD_Flush' )
                    {
                    // InternalDbdTextEditor.g:1510:3: (enumLiteral_62= 'asynTMOD_Flush' )
                    // InternalDbdTextEditor.g:1511:4: enumLiteral_62= 'asynTMOD_Flush'
                    {
                    enumLiteral_62=(Token)match(input,136,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynTMOD_FlushEnumLiteralDeclaration_62().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_62, grammarAccess.getChoicenamesAccess().getAsynTMOD_FlushEnumLiteralDeclaration_62());
                    			

                    }


                    }
                    break;
                case 64 :
                    // InternalDbdTextEditor.g:1518:3: (enumLiteral_63= 'asynTMOD_NoIO' )
                    {
                    // InternalDbdTextEditor.g:1518:3: (enumLiteral_63= 'asynTMOD_NoIO' )
                    // InternalDbdTextEditor.g:1519:4: enumLiteral_63= 'asynTMOD_NoIO'
                    {
                    enumLiteral_63=(Token)match(input,137,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynTMOD_NoIOEnumLiteralDeclaration_63().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_63, grammarAccess.getChoicenamesAccess().getAsynTMOD_NoIOEnumLiteralDeclaration_63());
                    			

                    }


                    }
                    break;
                case 65 :
                    // InternalDbdTextEditor.g:1526:3: (enumLiteral_64= 'ipDRTO_unknown' )
                    {
                    // InternalDbdTextEditor.g:1526:3: (enumLiteral_64= 'ipDRTO_unknown' )
                    // InternalDbdTextEditor.g:1527:4: enumLiteral_64= 'ipDRTO_unknown'
                    {
                    enumLiteral_64=(Token)match(input,138,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getIpDRTO_unknownEnumLiteralDeclaration_64().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_64, grammarAccess.getChoicenamesAccess().getIpDRTO_unknownEnumLiteralDeclaration_64());
                    			

                    }


                    }
                    break;
                case 66 :
                    // InternalDbdTextEditor.g:1534:3: (enumLiteral_65= 'ipDRTO_No' )
                    {
                    // InternalDbdTextEditor.g:1534:3: (enumLiteral_65= 'ipDRTO_No' )
                    // InternalDbdTextEditor.g:1535:4: enumLiteral_65= 'ipDRTO_No'
                    {
                    enumLiteral_65=(Token)match(input,139,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getIpDRTO_NoEnumLiteralDeclaration_65().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_65, grammarAccess.getChoicenamesAccess().getIpDRTO_NoEnumLiteralDeclaration_65());
                    			

                    }


                    }
                    break;
                case 67 :
                    // InternalDbdTextEditor.g:1542:3: (enumLiteral_66= 'ipDRTO_Yes' )
                    {
                    // InternalDbdTextEditor.g:1542:3: (enumLiteral_66= 'ipDRTO_Yes' )
                    // InternalDbdTextEditor.g:1543:4: enumLiteral_66= 'ipDRTO_Yes'
                    {
                    enumLiteral_66=(Token)match(input,140,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getIpDRTO_YesEnumLiteralDeclaration_66().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_66, grammarAccess.getChoicenamesAccess().getIpDRTO_YesEnumLiteralDeclaration_66());
                    			

                    }


                    }
                    break;
                case 68 :
                    // InternalDbdTextEditor.g:1550:3: (enumLiteral_67= 'scalerD1_Up' )
                    {
                    // InternalDbdTextEditor.g:1550:3: (enumLiteral_67= 'scalerD1_Up' )
                    // InternalDbdTextEditor.g:1551:4: enumLiteral_67= 'scalerD1_Up'
                    {
                    enumLiteral_67=(Token)match(input,141,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getScalerD1_UpEnumLiteralDeclaration_67().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_67, grammarAccess.getChoicenamesAccess().getScalerD1_UpEnumLiteralDeclaration_67());
                    			

                    }


                    }
                    break;
                case 69 :
                    // InternalDbdTextEditor.g:1558:3: (enumLiteral_68= 'scalerD1_Dn' )
                    {
                    // InternalDbdTextEditor.g:1558:3: (enumLiteral_68= 'scalerD1_Dn' )
                    // InternalDbdTextEditor.g:1559:4: enumLiteral_68= 'scalerD1_Dn'
                    {
                    enumLiteral_68=(Token)match(input,142,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getScalerD1_DnEnumLiteralDeclaration_68().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_68, grammarAccess.getChoicenamesAccess().getScalerD1_DnEnumLiteralDeclaration_68());
                    			

                    }


                    }
                    break;
                case 70 :
                    // InternalDbdTextEditor.g:1566:3: (enumLiteral_69= 'menuPost_OnChange' )
                    {
                    // InternalDbdTextEditor.g:1566:3: (enumLiteral_69= 'menuPost_OnChange' )
                    // InternalDbdTextEditor.g:1567:4: enumLiteral_69= 'menuPost_OnChange'
                    {
                    enumLiteral_69=(Token)match(input,143,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuPost_OnChangeEnumLiteralDeclaration_69().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_69, grammarAccess.getChoicenamesAccess().getMenuPost_OnChangeEnumLiteralDeclaration_69());
                    			

                    }


                    }
                    break;
                case 71 :
                    // InternalDbdTextEditor.g:1574:3: (enumLiteral_70= 'menuPost_Always' )
                    {
                    // InternalDbdTextEditor.g:1574:3: (enumLiteral_70= 'menuPost_Always' )
                    // InternalDbdTextEditor.g:1575:4: enumLiteral_70= 'menuPost_Always'
                    {
                    enumLiteral_70=(Token)match(input,144,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuPost_AlwaysEnumLiteralDeclaration_70().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_70, grammarAccess.getChoicenamesAccess().getMenuPost_AlwaysEnumLiteralDeclaration_70());
                    			

                    }


                    }
                    break;
                case 72 :
                    // InternalDbdTextEditor.g:1582:3: (enumLiteral_71= 'asynINTERFACE_OCTET' )
                    {
                    // InternalDbdTextEditor.g:1582:3: (enumLiteral_71= 'asynINTERFACE_OCTET' )
                    // InternalDbdTextEditor.g:1583:4: enumLiteral_71= 'asynINTERFACE_OCTET'
                    {
                    enumLiteral_71=(Token)match(input,145,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynINTERFACE_OCTETEnumLiteralDeclaration_71().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_71, grammarAccess.getChoicenamesAccess().getAsynINTERFACE_OCTETEnumLiteralDeclaration_71());
                    			

                    }


                    }
                    break;
                case 73 :
                    // InternalDbdTextEditor.g:1590:3: (enumLiteral_72= 'asynINTERFACE_INT32' )
                    {
                    // InternalDbdTextEditor.g:1590:3: (enumLiteral_72= 'asynINTERFACE_INT32' )
                    // InternalDbdTextEditor.g:1591:4: enumLiteral_72= 'asynINTERFACE_INT32'
                    {
                    enumLiteral_72=(Token)match(input,146,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynINTERFACE_INT32EnumLiteralDeclaration_72().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_72, grammarAccess.getChoicenamesAccess().getAsynINTERFACE_INT32EnumLiteralDeclaration_72());
                    			

                    }


                    }
                    break;
                case 74 :
                    // InternalDbdTextEditor.g:1598:3: (enumLiteral_73= 'asynINTERFACE_UINT32' )
                    {
                    // InternalDbdTextEditor.g:1598:3: (enumLiteral_73= 'asynINTERFACE_UINT32' )
                    // InternalDbdTextEditor.g:1599:4: enumLiteral_73= 'asynINTERFACE_UINT32'
                    {
                    enumLiteral_73=(Token)match(input,147,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynINTERFACE_UINT32EnumLiteralDeclaration_73().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_73, grammarAccess.getChoicenamesAccess().getAsynINTERFACE_UINT32EnumLiteralDeclaration_73());
                    			

                    }


                    }
                    break;
                case 75 :
                    // InternalDbdTextEditor.g:1606:3: (enumLiteral_74= 'asynINTERFACE_FLOAT64' )
                    {
                    // InternalDbdTextEditor.g:1606:3: (enumLiteral_74= 'asynINTERFACE_FLOAT64' )
                    // InternalDbdTextEditor.g:1607:4: enumLiteral_74= 'asynINTERFACE_FLOAT64'
                    {
                    enumLiteral_74=(Token)match(input,148,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynINTERFACE_FLOAT64EnumLiteralDeclaration_74().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_74, grammarAccess.getChoicenamesAccess().getAsynINTERFACE_FLOAT64EnumLiteralDeclaration_74());
                    			

                    }


                    }
                    break;
                case 76 :
                    // InternalDbdTextEditor.g:1614:3: (enumLiteral_75= 'menuAlarmStatNO_ALARM' )
                    {
                    // InternalDbdTextEditor.g:1614:3: (enumLiteral_75= 'menuAlarmStatNO_ALARM' )
                    // InternalDbdTextEditor.g:1615:4: enumLiteral_75= 'menuAlarmStatNO_ALARM'
                    {
                    enumLiteral_75=(Token)match(input,149,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatNO_ALARMEnumLiteralDeclaration_75().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_75, grammarAccess.getChoicenamesAccess().getMenuAlarmStatNO_ALARMEnumLiteralDeclaration_75());
                    			

                    }


                    }
                    break;
                case 77 :
                    // InternalDbdTextEditor.g:1622:3: (enumLiteral_76= 'menuAlarmStatREAD' )
                    {
                    // InternalDbdTextEditor.g:1622:3: (enumLiteral_76= 'menuAlarmStatREAD' )
                    // InternalDbdTextEditor.g:1623:4: enumLiteral_76= 'menuAlarmStatREAD'
                    {
                    enumLiteral_76=(Token)match(input,150,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatREADEnumLiteralDeclaration_76().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_76, grammarAccess.getChoicenamesAccess().getMenuAlarmStatREADEnumLiteralDeclaration_76());
                    			

                    }


                    }
                    break;
                case 78 :
                    // InternalDbdTextEditor.g:1630:3: (enumLiteral_77= 'menuAlarmStatWRITE' )
                    {
                    // InternalDbdTextEditor.g:1630:3: (enumLiteral_77= 'menuAlarmStatWRITE' )
                    // InternalDbdTextEditor.g:1631:4: enumLiteral_77= 'menuAlarmStatWRITE'
                    {
                    enumLiteral_77=(Token)match(input,151,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatWRITEEnumLiteralDeclaration_77().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_77, grammarAccess.getChoicenamesAccess().getMenuAlarmStatWRITEEnumLiteralDeclaration_77());
                    			

                    }


                    }
                    break;
                case 79 :
                    // InternalDbdTextEditor.g:1638:3: (enumLiteral_78= 'menuAlarmStatHIHI' )
                    {
                    // InternalDbdTextEditor.g:1638:3: (enumLiteral_78= 'menuAlarmStatHIHI' )
                    // InternalDbdTextEditor.g:1639:4: enumLiteral_78= 'menuAlarmStatHIHI'
                    {
                    enumLiteral_78=(Token)match(input,152,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatHIHIEnumLiteralDeclaration_78().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_78, grammarAccess.getChoicenamesAccess().getMenuAlarmStatHIHIEnumLiteralDeclaration_78());
                    			

                    }


                    }
                    break;
                case 80 :
                    // InternalDbdTextEditor.g:1646:3: (enumLiteral_79= 'menuAlarmStatHIGH' )
                    {
                    // InternalDbdTextEditor.g:1646:3: (enumLiteral_79= 'menuAlarmStatHIGH' )
                    // InternalDbdTextEditor.g:1647:4: enumLiteral_79= 'menuAlarmStatHIGH'
                    {
                    enumLiteral_79=(Token)match(input,153,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatHIGHEnumLiteralDeclaration_79().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_79, grammarAccess.getChoicenamesAccess().getMenuAlarmStatHIGHEnumLiteralDeclaration_79());
                    			

                    }


                    }
                    break;
                case 81 :
                    // InternalDbdTextEditor.g:1654:3: (enumLiteral_80= 'menuAlarmStatLOLO' )
                    {
                    // InternalDbdTextEditor.g:1654:3: (enumLiteral_80= 'menuAlarmStatLOLO' )
                    // InternalDbdTextEditor.g:1655:4: enumLiteral_80= 'menuAlarmStatLOLO'
                    {
                    enumLiteral_80=(Token)match(input,154,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatLOLOEnumLiteralDeclaration_80().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_80, grammarAccess.getChoicenamesAccess().getMenuAlarmStatLOLOEnumLiteralDeclaration_80());
                    			

                    }


                    }
                    break;
                case 82 :
                    // InternalDbdTextEditor.g:1662:3: (enumLiteral_81= 'menuAlarmStatLOW' )
                    {
                    // InternalDbdTextEditor.g:1662:3: (enumLiteral_81= 'menuAlarmStatLOW' )
                    // InternalDbdTextEditor.g:1663:4: enumLiteral_81= 'menuAlarmStatLOW'
                    {
                    enumLiteral_81=(Token)match(input,155,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatLOWEnumLiteralDeclaration_81().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_81, grammarAccess.getChoicenamesAccess().getMenuAlarmStatLOWEnumLiteralDeclaration_81());
                    			

                    }


                    }
                    break;
                case 83 :
                    // InternalDbdTextEditor.g:1670:3: (enumLiteral_82= 'menuAlarmStatSTATE' )
                    {
                    // InternalDbdTextEditor.g:1670:3: (enumLiteral_82= 'menuAlarmStatSTATE' )
                    // InternalDbdTextEditor.g:1671:4: enumLiteral_82= 'menuAlarmStatSTATE'
                    {
                    enumLiteral_82=(Token)match(input,156,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatSTATEEnumLiteralDeclaration_82().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_82, grammarAccess.getChoicenamesAccess().getMenuAlarmStatSTATEEnumLiteralDeclaration_82());
                    			

                    }


                    }
                    break;
                case 84 :
                    // InternalDbdTextEditor.g:1678:3: (enumLiteral_83= 'menuAlarmStatCOS' )
                    {
                    // InternalDbdTextEditor.g:1678:3: (enumLiteral_83= 'menuAlarmStatCOS' )
                    // InternalDbdTextEditor.g:1679:4: enumLiteral_83= 'menuAlarmStatCOS'
                    {
                    enumLiteral_83=(Token)match(input,157,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatCOSEnumLiteralDeclaration_83().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_83, grammarAccess.getChoicenamesAccess().getMenuAlarmStatCOSEnumLiteralDeclaration_83());
                    			

                    }


                    }
                    break;
                case 85 :
                    // InternalDbdTextEditor.g:1686:3: (enumLiteral_84= 'menuAlarmStatCOMM' )
                    {
                    // InternalDbdTextEditor.g:1686:3: (enumLiteral_84= 'menuAlarmStatCOMM' )
                    // InternalDbdTextEditor.g:1687:4: enumLiteral_84= 'menuAlarmStatCOMM'
                    {
                    enumLiteral_84=(Token)match(input,158,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatCOMMEnumLiteralDeclaration_84().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_84, grammarAccess.getChoicenamesAccess().getMenuAlarmStatCOMMEnumLiteralDeclaration_84());
                    			

                    }


                    }
                    break;
                case 86 :
                    // InternalDbdTextEditor.g:1694:3: (enumLiteral_85= 'menuAlarmStatTIMEOUT' )
                    {
                    // InternalDbdTextEditor.g:1694:3: (enumLiteral_85= 'menuAlarmStatTIMEOUT' )
                    // InternalDbdTextEditor.g:1695:4: enumLiteral_85= 'menuAlarmStatTIMEOUT'
                    {
                    enumLiteral_85=(Token)match(input,159,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatTIMEOUTEnumLiteralDeclaration_85().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_85, grammarAccess.getChoicenamesAccess().getMenuAlarmStatTIMEOUTEnumLiteralDeclaration_85());
                    			

                    }


                    }
                    break;
                case 87 :
                    // InternalDbdTextEditor.g:1702:3: (enumLiteral_86= 'menuAlarmStatHWLIMIT' )
                    {
                    // InternalDbdTextEditor.g:1702:3: (enumLiteral_86= 'menuAlarmStatHWLIMIT' )
                    // InternalDbdTextEditor.g:1703:4: enumLiteral_86= 'menuAlarmStatHWLIMIT'
                    {
                    enumLiteral_86=(Token)match(input,160,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatHWLIMITEnumLiteralDeclaration_86().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_86, grammarAccess.getChoicenamesAccess().getMenuAlarmStatHWLIMITEnumLiteralDeclaration_86());
                    			

                    }


                    }
                    break;
                case 88 :
                    // InternalDbdTextEditor.g:1710:3: (enumLiteral_87= 'menuAlarmStatCALC' )
                    {
                    // InternalDbdTextEditor.g:1710:3: (enumLiteral_87= 'menuAlarmStatCALC' )
                    // InternalDbdTextEditor.g:1711:4: enumLiteral_87= 'menuAlarmStatCALC'
                    {
                    enumLiteral_87=(Token)match(input,161,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatCALCEnumLiteralDeclaration_87().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_87, grammarAccess.getChoicenamesAccess().getMenuAlarmStatCALCEnumLiteralDeclaration_87());
                    			

                    }


                    }
                    break;
                case 89 :
                    // InternalDbdTextEditor.g:1718:3: (enumLiteral_88= 'menuAlarmStatSCAN' )
                    {
                    // InternalDbdTextEditor.g:1718:3: (enumLiteral_88= 'menuAlarmStatSCAN' )
                    // InternalDbdTextEditor.g:1719:4: enumLiteral_88= 'menuAlarmStatSCAN'
                    {
                    enumLiteral_88=(Token)match(input,162,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatSCANEnumLiteralDeclaration_88().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_88, grammarAccess.getChoicenamesAccess().getMenuAlarmStatSCANEnumLiteralDeclaration_88());
                    			

                    }


                    }
                    break;
                case 90 :
                    // InternalDbdTextEditor.g:1726:3: (enumLiteral_89= 'menuAlarmStatLINK' )
                    {
                    // InternalDbdTextEditor.g:1726:3: (enumLiteral_89= 'menuAlarmStatLINK' )
                    // InternalDbdTextEditor.g:1727:4: enumLiteral_89= 'menuAlarmStatLINK'
                    {
                    enumLiteral_89=(Token)match(input,163,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatLINKEnumLiteralDeclaration_89().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_89, grammarAccess.getChoicenamesAccess().getMenuAlarmStatLINKEnumLiteralDeclaration_89());
                    			

                    }


                    }
                    break;
                case 91 :
                    // InternalDbdTextEditor.g:1734:3: (enumLiteral_90= 'menuAlarmStatSOFT' )
                    {
                    // InternalDbdTextEditor.g:1734:3: (enumLiteral_90= 'menuAlarmStatSOFT' )
                    // InternalDbdTextEditor.g:1735:4: enumLiteral_90= 'menuAlarmStatSOFT'
                    {
                    enumLiteral_90=(Token)match(input,164,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatSOFTEnumLiteralDeclaration_90().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_90, grammarAccess.getChoicenamesAccess().getMenuAlarmStatSOFTEnumLiteralDeclaration_90());
                    			

                    }


                    }
                    break;
                case 92 :
                    // InternalDbdTextEditor.g:1742:3: (enumLiteral_91= 'menuAlarmStatBAD_SUB' )
                    {
                    // InternalDbdTextEditor.g:1742:3: (enumLiteral_91= 'menuAlarmStatBAD_SUB' )
                    // InternalDbdTextEditor.g:1743:4: enumLiteral_91= 'menuAlarmStatBAD_SUB'
                    {
                    enumLiteral_91=(Token)match(input,165,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatBAD_SUBEnumLiteralDeclaration_91().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_91, grammarAccess.getChoicenamesAccess().getMenuAlarmStatBAD_SUBEnumLiteralDeclaration_91());
                    			

                    }


                    }
                    break;
                case 93 :
                    // InternalDbdTextEditor.g:1750:3: (enumLiteral_92= 'menuAlarmStatUDF' )
                    {
                    // InternalDbdTextEditor.g:1750:3: (enumLiteral_92= 'menuAlarmStatUDF' )
                    // InternalDbdTextEditor.g:1751:4: enumLiteral_92= 'menuAlarmStatUDF'
                    {
                    enumLiteral_92=(Token)match(input,166,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatUDFEnumLiteralDeclaration_92().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_92, grammarAccess.getChoicenamesAccess().getMenuAlarmStatUDFEnumLiteralDeclaration_92());
                    			

                    }


                    }
                    break;
                case 94 :
                    // InternalDbdTextEditor.g:1758:3: (enumLiteral_93= 'menuAlarmStatDISABLE' )
                    {
                    // InternalDbdTextEditor.g:1758:3: (enumLiteral_93= 'menuAlarmStatDISABLE' )
                    // InternalDbdTextEditor.g:1759:4: enumLiteral_93= 'menuAlarmStatDISABLE'
                    {
                    enumLiteral_93=(Token)match(input,167,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatDISABLEEnumLiteralDeclaration_93().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_93, grammarAccess.getChoicenamesAccess().getMenuAlarmStatDISABLEEnumLiteralDeclaration_93());
                    			

                    }


                    }
                    break;
                case 95 :
                    // InternalDbdTextEditor.g:1766:3: (enumLiteral_94= 'menuAlarmStatSIMM' )
                    {
                    // InternalDbdTextEditor.g:1766:3: (enumLiteral_94= 'menuAlarmStatSIMM' )
                    // InternalDbdTextEditor.g:1767:4: enumLiteral_94= 'menuAlarmStatSIMM'
                    {
                    enumLiteral_94=(Token)match(input,168,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatSIMMEnumLiteralDeclaration_94().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_94, grammarAccess.getChoicenamesAccess().getMenuAlarmStatSIMMEnumLiteralDeclaration_94());
                    			

                    }


                    }
                    break;
                case 96 :
                    // InternalDbdTextEditor.g:1774:3: (enumLiteral_95= 'menuAlarmStatREAD_ACCESS' )
                    {
                    // InternalDbdTextEditor.g:1774:3: (enumLiteral_95= 'menuAlarmStatREAD_ACCESS' )
                    // InternalDbdTextEditor.g:1775:4: enumLiteral_95= 'menuAlarmStatREAD_ACCESS'
                    {
                    enumLiteral_95=(Token)match(input,169,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatREAD_ACCESSEnumLiteralDeclaration_95().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_95, grammarAccess.getChoicenamesAccess().getMenuAlarmStatREAD_ACCESSEnumLiteralDeclaration_95());
                    			

                    }


                    }
                    break;
                case 97 :
                    // InternalDbdTextEditor.g:1782:3: (enumLiteral_96= 'menuAlarmStatWRITE_ACCESS' )
                    {
                    // InternalDbdTextEditor.g:1782:3: (enumLiteral_96= 'menuAlarmStatWRITE_ACCESS' )
                    // InternalDbdTextEditor.g:1783:4: enumLiteral_96= 'menuAlarmStatWRITE_ACCESS'
                    {
                    enumLiteral_96=(Token)match(input,170,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getMenuAlarmStatWRITE_ACCESSEnumLiteralDeclaration_96().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_96, grammarAccess.getChoicenamesAccess().getMenuAlarmStatWRITE_ACCESSEnumLiteralDeclaration_96());
                    			

                    }


                    }
                    break;
                case 98 :
                    // InternalDbdTextEditor.g:1790:3: (enumLiteral_97= 'aoOIF_Full' )
                    {
                    // InternalDbdTextEditor.g:1790:3: (enumLiteral_97= 'aoOIF_Full' )
                    // InternalDbdTextEditor.g:1791:4: enumLiteral_97= 'aoOIF_Full'
                    {
                    enumLiteral_97=(Token)match(input,171,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAoOIF_FullEnumLiteralDeclaration_97().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_97, grammarAccess.getChoicenamesAccess().getAoOIF_FullEnumLiteralDeclaration_97());
                    			

                    }


                    }
                    break;
                case 99 :
                    // InternalDbdTextEditor.g:1798:3: (enumLiteral_98= 'aoOIF_Incremental' )
                    {
                    // InternalDbdTextEditor.g:1798:3: (enumLiteral_98= 'aoOIF_Incremental' )
                    // InternalDbdTextEditor.g:1799:4: enumLiteral_98= 'aoOIF_Incremental'
                    {
                    enumLiteral_98=(Token)match(input,172,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAoOIF_IncrementalEnumLiteralDeclaration_98().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_98, grammarAccess.getChoicenamesAccess().getAoOIF_IncrementalEnumLiteralDeclaration_98());
                    			

                    }


                    }
                    break;
                case 100 :
                    // InternalDbdTextEditor.g:1806:3: (enumLiteral_99= 'bufferingALG_FIFO' )
                    {
                    // InternalDbdTextEditor.g:1806:3: (enumLiteral_99= 'bufferingALG_FIFO' )
                    // InternalDbdTextEditor.g:1807:4: enumLiteral_99= 'bufferingALG_FIFO'
                    {
                    enumLiteral_99=(Token)match(input,173,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getBufferingALG_FIFOEnumLiteralDeclaration_99().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_99, grammarAccess.getChoicenamesAccess().getBufferingALG_FIFOEnumLiteralDeclaration_99());
                    			

                    }


                    }
                    break;
                case 101 :
                    // InternalDbdTextEditor.g:1814:3: (enumLiteral_100= 'bufferingALG_LIFO' )
                    {
                    // InternalDbdTextEditor.g:1814:3: (enumLiteral_100= 'bufferingALG_LIFO' )
                    // InternalDbdTextEditor.g:1815:4: enumLiteral_100= 'bufferingALG_LIFO'
                    {
                    enumLiteral_100=(Token)match(input,174,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getBufferingALG_LIFOEnumLiteralDeclaration_100().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_100, grammarAccess.getChoicenamesAccess().getBufferingALG_LIFOEnumLiteralDeclaration_100());
                    			

                    }


                    }
                    break;
                case 102 :
                    // InternalDbdTextEditor.g:1822:3: (enumLiteral_101= 'aaiPOST_Always' )
                    {
                    // InternalDbdTextEditor.g:1822:3: (enumLiteral_101= 'aaiPOST_Always' )
                    // InternalDbdTextEditor.g:1823:4: enumLiteral_101= 'aaiPOST_Always'
                    {
                    enumLiteral_101=(Token)match(input,175,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAaiPOST_AlwaysEnumLiteralDeclaration_101().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_101, grammarAccess.getChoicenamesAccess().getAaiPOST_AlwaysEnumLiteralDeclaration_101());
                    			

                    }


                    }
                    break;
                case 103 :
                    // InternalDbdTextEditor.g:1830:3: (enumLiteral_102= 'aaiPOST_OnChange' )
                    {
                    // InternalDbdTextEditor.g:1830:3: (enumLiteral_102= 'aaiPOST_OnChange' )
                    // InternalDbdTextEditor.g:1831:4: enumLiteral_102= 'aaiPOST_OnChange'
                    {
                    enumLiteral_102=(Token)match(input,176,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAaiPOST_OnChangeEnumLiteralDeclaration_102().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_102, grammarAccess.getChoicenamesAccess().getAaiPOST_OnChangeEnumLiteralDeclaration_102());
                    			

                    }


                    }
                    break;
                case 104 :
                    // InternalDbdTextEditor.g:1838:3: (enumLiteral_103= 'epidFeedbackState_Off' )
                    {
                    // InternalDbdTextEditor.g:1838:3: (enumLiteral_103= 'epidFeedbackState_Off' )
                    // InternalDbdTextEditor.g:1839:4: enumLiteral_103= 'epidFeedbackState_Off'
                    {
                    enumLiteral_103=(Token)match(input,177,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getEpidFeedbackState_OffEnumLiteralDeclaration_103().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_103, grammarAccess.getChoicenamesAccess().getEpidFeedbackState_OffEnumLiteralDeclaration_103());
                    			

                    }


                    }
                    break;
                case 105 :
                    // InternalDbdTextEditor.g:1846:3: (enumLiteral_104= 'epidFeedbackState_On' )
                    {
                    // InternalDbdTextEditor.g:1846:3: (enumLiteral_104= 'epidFeedbackState_On' )
                    // InternalDbdTextEditor.g:1847:4: enumLiteral_104= 'epidFeedbackState_On'
                    {
                    enumLiteral_104=(Token)match(input,178,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getEpidFeedbackState_OnEnumLiteralDeclaration_104().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_104, grammarAccess.getChoicenamesAccess().getEpidFeedbackState_OnEnumLiteralDeclaration_104());
                    			

                    }


                    }
                    break;
                case 106 :
                    // InternalDbdTextEditor.g:1854:3: (enumLiteral_105= 'calcoutINAV_EXT_NC' )
                    {
                    // InternalDbdTextEditor.g:1854:3: (enumLiteral_105= 'calcoutINAV_EXT_NC' )
                    // InternalDbdTextEditor.g:1855:4: enumLiteral_105= 'calcoutINAV_EXT_NC'
                    {
                    enumLiteral_105=(Token)match(input,179,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getCalcoutINAV_EXT_NCEnumLiteralDeclaration_105().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_105, grammarAccess.getChoicenamesAccess().getCalcoutINAV_EXT_NCEnumLiteralDeclaration_105());
                    			

                    }


                    }
                    break;
                case 107 :
                    // InternalDbdTextEditor.g:1862:3: (enumLiteral_106= 'calcoutINAV_EXT' )
                    {
                    // InternalDbdTextEditor.g:1862:3: (enumLiteral_106= 'calcoutINAV_EXT' )
                    // InternalDbdTextEditor.g:1863:4: enumLiteral_106= 'calcoutINAV_EXT'
                    {
                    enumLiteral_106=(Token)match(input,180,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getCalcoutINAV_EXTEnumLiteralDeclaration_106().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_106, grammarAccess.getChoicenamesAccess().getCalcoutINAV_EXTEnumLiteralDeclaration_106());
                    			

                    }


                    }
                    break;
                case 108 :
                    // InternalDbdTextEditor.g:1870:3: (enumLiteral_107= 'calcoutINAV_LOC' )
                    {
                    // InternalDbdTextEditor.g:1870:3: (enumLiteral_107= 'calcoutINAV_LOC' )
                    // InternalDbdTextEditor.g:1871:4: enumLiteral_107= 'calcoutINAV_LOC'
                    {
                    enumLiteral_107=(Token)match(input,181,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getCalcoutINAV_LOCEnumLiteralDeclaration_107().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_107, grammarAccess.getChoicenamesAccess().getCalcoutINAV_LOCEnumLiteralDeclaration_107());
                    			

                    }


                    }
                    break;
                case 109 :
                    // InternalDbdTextEditor.g:1878:3: (enumLiteral_108= 'calcoutINAV_CON' )
                    {
                    // InternalDbdTextEditor.g:1878:3: (enumLiteral_108= 'calcoutINAV_CON' )
                    // InternalDbdTextEditor.g:1879:4: enumLiteral_108= 'calcoutINAV_CON'
                    {
                    enumLiteral_108=(Token)match(input,182,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getCalcoutINAV_CONEnumLiteralDeclaration_108().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_108, grammarAccess.getChoicenamesAccess().getCalcoutINAV_CONEnumLiteralDeclaration_108());
                    			

                    }


                    }
                    break;
                case 110 :
                    // InternalDbdTextEditor.g:1886:3: (enumLiteral_109= 'asynAUTOCONNECT_noAutoConnect' )
                    {
                    // InternalDbdTextEditor.g:1886:3: (enumLiteral_109= 'asynAUTOCONNECT_noAutoConnect' )
                    // InternalDbdTextEditor.g:1887:4: enumLiteral_109= 'asynAUTOCONNECT_noAutoConnect'
                    {
                    enumLiteral_109=(Token)match(input,183,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynAUTOCONNECT_noAutoConnectEnumLiteralDeclaration_109().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_109, grammarAccess.getChoicenamesAccess().getAsynAUTOCONNECT_noAutoConnectEnumLiteralDeclaration_109());
                    			

                    }


                    }
                    break;
                case 111 :
                    // InternalDbdTextEditor.g:1894:3: (enumLiteral_110= 'asynAUTOCONNECT_autoConnect' )
                    {
                    // InternalDbdTextEditor.g:1894:3: (enumLiteral_110= 'asynAUTOCONNECT_autoConnect' )
                    // InternalDbdTextEditor.g:1895:4: enumLiteral_110= 'asynAUTOCONNECT_autoConnect'
                    {
                    enumLiteral_110=(Token)match(input,184,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynAUTOCONNECT_autoConnectEnumLiteralDeclaration_110().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_110, grammarAccess.getChoicenamesAccess().getAsynAUTOCONNECT_autoConnectEnumLiteralDeclaration_110());
                    			

                    }


                    }
                    break;
                case 112 :
                    // InternalDbdTextEditor.g:1902:3: (enumLiteral_111= 'asynFMT_ASCII' )
                    {
                    // InternalDbdTextEditor.g:1902:3: (enumLiteral_111= 'asynFMT_ASCII' )
                    // InternalDbdTextEditor.g:1903:4: enumLiteral_111= 'asynFMT_ASCII'
                    {
                    enumLiteral_111=(Token)match(input,185,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynFMT_ASCIIEnumLiteralDeclaration_111().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_111, grammarAccess.getChoicenamesAccess().getAsynFMT_ASCIIEnumLiteralDeclaration_111());
                    			

                    }


                    }
                    break;
                case 113 :
                    // InternalDbdTextEditor.g:1910:3: (enumLiteral_112= 'asynFMT_Hybrid' )
                    {
                    // InternalDbdTextEditor.g:1910:3: (enumLiteral_112= 'asynFMT_Hybrid' )
                    // InternalDbdTextEditor.g:1911:4: enumLiteral_112= 'asynFMT_Hybrid'
                    {
                    enumLiteral_112=(Token)match(input,186,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynFMT_HybridEnumLiteralDeclaration_112().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_112, grammarAccess.getChoicenamesAccess().getAsynFMT_HybridEnumLiteralDeclaration_112());
                    			

                    }


                    }
                    break;
                case 114 :
                    // InternalDbdTextEditor.g:1918:3: (enumLiteral_113= 'asynFMT_Binary' )
                    {
                    // InternalDbdTextEditor.g:1918:3: (enumLiteral_113= 'asynFMT_Binary' )
                    // InternalDbdTextEditor.g:1919:4: enumLiteral_113= 'asynFMT_Binary'
                    {
                    enumLiteral_113=(Token)match(input,187,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynFMT_BinaryEnumLiteralDeclaration_113().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_113, grammarAccess.getChoicenamesAccess().getAsynFMT_BinaryEnumLiteralDeclaration_113());
                    			

                    }


                    }
                    break;
                case 115 :
                    // InternalDbdTextEditor.g:1926:3: (enumLiteral_114= 'seqSELM_All' )
                    {
                    // InternalDbdTextEditor.g:1926:3: (enumLiteral_114= 'seqSELM_All' )
                    // InternalDbdTextEditor.g:1927:4: enumLiteral_114= 'seqSELM_All'
                    {
                    enumLiteral_114=(Token)match(input,188,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSeqSELM_AllEnumLiteralDeclaration_114().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_114, grammarAccess.getChoicenamesAccess().getSeqSELM_AllEnumLiteralDeclaration_114());
                    			

                    }


                    }
                    break;
                case 116 :
                    // InternalDbdTextEditor.g:1934:3: (enumLiteral_115= 'seqSELM_Specified' )
                    {
                    // InternalDbdTextEditor.g:1934:3: (enumLiteral_115= 'seqSELM_Specified' )
                    // InternalDbdTextEditor.g:1935:4: enumLiteral_115= 'seqSELM_Specified'
                    {
                    enumLiteral_115=(Token)match(input,189,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSeqSELM_SpecifiedEnumLiteralDeclaration_115().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_115, grammarAccess.getChoicenamesAccess().getSeqSELM_SpecifiedEnumLiteralDeclaration_115());
                    			

                    }


                    }
                    break;
                case 117 :
                    // InternalDbdTextEditor.g:1942:3: (enumLiteral_116= 'seqSELM_Mask' )
                    {
                    // InternalDbdTextEditor.g:1942:3: (enumLiteral_116= 'seqSELM_Mask' )
                    // InternalDbdTextEditor.g:1943:4: enumLiteral_116= 'seqSELM_Mask'
                    {
                    enumLiteral_116=(Token)match(input,190,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSeqSELM_MaskEnumLiteralDeclaration_116().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_116, grammarAccess.getChoicenamesAccess().getSeqSELM_MaskEnumLiteralDeclaration_116());
                    			

                    }


                    }
                    break;
                case 118 :
                    // InternalDbdTextEditor.g:1950:3: (enumLiteral_117= 'asynCONNECT_Disconnect' )
                    {
                    // InternalDbdTextEditor.g:1950:3: (enumLiteral_117= 'asynCONNECT_Disconnect' )
                    // InternalDbdTextEditor.g:1951:4: enumLiteral_117= 'asynCONNECT_Disconnect'
                    {
                    enumLiteral_117=(Token)match(input,191,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynCONNECT_DisconnectEnumLiteralDeclaration_117().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_117, grammarAccess.getChoicenamesAccess().getAsynCONNECT_DisconnectEnumLiteralDeclaration_117());
                    			

                    }


                    }
                    break;
                case 119 :
                    // InternalDbdTextEditor.g:1958:3: (enumLiteral_118= 'asynCONNECT_Connect' )
                    {
                    // InternalDbdTextEditor.g:1958:3: (enumLiteral_118= 'asynCONNECT_Connect' )
                    // InternalDbdTextEditor.g:1959:4: enumLiteral_118= 'asynCONNECT_Connect'
                    {
                    enumLiteral_118=(Token)match(input,192,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynCONNECT_ConnectEnumLiteralDeclaration_118().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_118, grammarAccess.getChoicenamesAccess().getAsynCONNECT_ConnectEnumLiteralDeclaration_118());
                    			

                    }


                    }
                    break;
                case 120 :
                    // InternalDbdTextEditor.g:1966:3: (enumLiteral_119= 'gpibUCMD_None' )
                    {
                    // InternalDbdTextEditor.g:1966:3: (enumLiteral_119= 'gpibUCMD_None' )
                    // InternalDbdTextEditor.g:1967:4: enumLiteral_119= 'gpibUCMD_None'
                    {
                    enumLiteral_119=(Token)match(input,193,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getGpibUCMD_NoneEnumLiteralDeclaration_119().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_119, grammarAccess.getChoicenamesAccess().getGpibUCMD_NoneEnumLiteralDeclaration_119());
                    			

                    }


                    }
                    break;
                case 121 :
                    // InternalDbdTextEditor.g:1974:3: (enumLiteral_120= 'gpibUCMD_Device_Clear__DCL_' )
                    {
                    // InternalDbdTextEditor.g:1974:3: (enumLiteral_120= 'gpibUCMD_Device_Clear__DCL_' )
                    // InternalDbdTextEditor.g:1975:4: enumLiteral_120= 'gpibUCMD_Device_Clear__DCL_'
                    {
                    enumLiteral_120=(Token)match(input,194,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getGpibUCMD_Device_Clear__DCL_EnumLiteralDeclaration_120().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_120, grammarAccess.getChoicenamesAccess().getGpibUCMD_Device_Clear__DCL_EnumLiteralDeclaration_120());
                    			

                    }


                    }
                    break;
                case 122 :
                    // InternalDbdTextEditor.g:1982:3: (enumLiteral_121= 'gpibUCMD_Local_Lockout__LL0_' )
                    {
                    // InternalDbdTextEditor.g:1982:3: (enumLiteral_121= 'gpibUCMD_Local_Lockout__LL0_' )
                    // InternalDbdTextEditor.g:1983:4: enumLiteral_121= 'gpibUCMD_Local_Lockout__LL0_'
                    {
                    enumLiteral_121=(Token)match(input,195,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getGpibUCMD_Local_Lockout__LL0_EnumLiteralDeclaration_121().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_121, grammarAccess.getChoicenamesAccess().getGpibUCMD_Local_Lockout__LL0_EnumLiteralDeclaration_121());
                    			

                    }


                    }
                    break;
                case 123 :
                    // InternalDbdTextEditor.g:1990:3: (enumLiteral_122= 'gpibUCMD_Serial_Poll_Disable__SPD_' )
                    {
                    // InternalDbdTextEditor.g:1990:3: (enumLiteral_122= 'gpibUCMD_Serial_Poll_Disable__SPD_' )
                    // InternalDbdTextEditor.g:1991:4: enumLiteral_122= 'gpibUCMD_Serial_Poll_Disable__SPD_'
                    {
                    enumLiteral_122=(Token)match(input,196,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getGpibUCMD_Serial_Poll_Disable__SPD_EnumLiteralDeclaration_122().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_122, grammarAccess.getChoicenamesAccess().getGpibUCMD_Serial_Poll_Disable__SPD_EnumLiteralDeclaration_122());
                    			

                    }


                    }
                    break;
                case 124 :
                    // InternalDbdTextEditor.g:1998:3: (enumLiteral_123= 'gpibUCMD_Serial_Poll_Enable__SPE_' )
                    {
                    // InternalDbdTextEditor.g:1998:3: (enumLiteral_123= 'gpibUCMD_Serial_Poll_Enable__SPE_' )
                    // InternalDbdTextEditor.g:1999:4: enumLiteral_123= 'gpibUCMD_Serial_Poll_Enable__SPE_'
                    {
                    enumLiteral_123=(Token)match(input,197,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getGpibUCMD_Serial_Poll_Enable__SPE_EnumLiteralDeclaration_123().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_123, grammarAccess.getChoicenamesAccess().getGpibUCMD_Serial_Poll_Enable__SPE_EnumLiteralDeclaration_123());
                    			

                    }


                    }
                    break;
                case 125 :
                    // InternalDbdTextEditor.g:2006:3: (enumLiteral_124= 'gpibUCMD_Unlisten__UNL_' )
                    {
                    // InternalDbdTextEditor.g:2006:3: (enumLiteral_124= 'gpibUCMD_Unlisten__UNL_' )
                    // InternalDbdTextEditor.g:2007:4: enumLiteral_124= 'gpibUCMD_Unlisten__UNL_'
                    {
                    enumLiteral_124=(Token)match(input,198,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getGpibUCMD_Unlisten__UNL_EnumLiteralDeclaration_124().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_124, grammarAccess.getChoicenamesAccess().getGpibUCMD_Unlisten__UNL_EnumLiteralDeclaration_124());
                    			

                    }


                    }
                    break;
                case 126 :
                    // InternalDbdTextEditor.g:2014:3: (enumLiteral_125= 'gpibUCMD_Untalk__UNT_' )
                    {
                    // InternalDbdTextEditor.g:2014:3: (enumLiteral_125= 'gpibUCMD_Untalk__UNT_' )
                    // InternalDbdTextEditor.g:2015:4: enumLiteral_125= 'gpibUCMD_Untalk__UNT_'
                    {
                    enumLiteral_125=(Token)match(input,199,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getGpibUCMD_Untalk__UNT_EnumLiteralDeclaration_125().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_125, grammarAccess.getChoicenamesAccess().getGpibUCMD_Untalk__UNT_EnumLiteralDeclaration_125());
                    			

                    }


                    }
                    break;
                case 127 :
                    // InternalDbdTextEditor.g:2022:3: (enumLiteral_126= 'serialBAUD_unknown' )
                    {
                    // InternalDbdTextEditor.g:2022:3: (enumLiteral_126= 'serialBAUD_unknown' )
                    // InternalDbdTextEditor.g:2023:4: enumLiteral_126= 'serialBAUD_unknown'
                    {
                    enumLiteral_126=(Token)match(input,200,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialBAUD_unknownEnumLiteralDeclaration_126().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_126, grammarAccess.getChoicenamesAccess().getSerialBAUD_unknownEnumLiteralDeclaration_126());
                    			

                    }


                    }
                    break;
                case 128 :
                    // InternalDbdTextEditor.g:2030:3: (enumLiteral_127= 'serialBAUD_300' )
                    {
                    // InternalDbdTextEditor.g:2030:3: (enumLiteral_127= 'serialBAUD_300' )
                    // InternalDbdTextEditor.g:2031:4: enumLiteral_127= 'serialBAUD_300'
                    {
                    enumLiteral_127=(Token)match(input,201,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialBAUD_300EnumLiteralDeclaration_127().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_127, grammarAccess.getChoicenamesAccess().getSerialBAUD_300EnumLiteralDeclaration_127());
                    			

                    }


                    }
                    break;
                case 129 :
                    // InternalDbdTextEditor.g:2038:3: (enumLiteral_128= 'serialBAUD_600' )
                    {
                    // InternalDbdTextEditor.g:2038:3: (enumLiteral_128= 'serialBAUD_600' )
                    // InternalDbdTextEditor.g:2039:4: enumLiteral_128= 'serialBAUD_600'
                    {
                    enumLiteral_128=(Token)match(input,202,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialBAUD_600EnumLiteralDeclaration_128().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_128, grammarAccess.getChoicenamesAccess().getSerialBAUD_600EnumLiteralDeclaration_128());
                    			

                    }


                    }
                    break;
                case 130 :
                    // InternalDbdTextEditor.g:2046:3: (enumLiteral_129= 'serialBAUD_1200' )
                    {
                    // InternalDbdTextEditor.g:2046:3: (enumLiteral_129= 'serialBAUD_1200' )
                    // InternalDbdTextEditor.g:2047:4: enumLiteral_129= 'serialBAUD_1200'
                    {
                    enumLiteral_129=(Token)match(input,203,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialBAUD_1200EnumLiteralDeclaration_129().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_129, grammarAccess.getChoicenamesAccess().getSerialBAUD_1200EnumLiteralDeclaration_129());
                    			

                    }


                    }
                    break;
                case 131 :
                    // InternalDbdTextEditor.g:2054:3: (enumLiteral_130= 'serialBAUD_2400' )
                    {
                    // InternalDbdTextEditor.g:2054:3: (enumLiteral_130= 'serialBAUD_2400' )
                    // InternalDbdTextEditor.g:2055:4: enumLiteral_130= 'serialBAUD_2400'
                    {
                    enumLiteral_130=(Token)match(input,204,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialBAUD_2400EnumLiteralDeclaration_130().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_130, grammarAccess.getChoicenamesAccess().getSerialBAUD_2400EnumLiteralDeclaration_130());
                    			

                    }


                    }
                    break;
                case 132 :
                    // InternalDbdTextEditor.g:2062:3: (enumLiteral_131= 'serialBAUD_4800' )
                    {
                    // InternalDbdTextEditor.g:2062:3: (enumLiteral_131= 'serialBAUD_4800' )
                    // InternalDbdTextEditor.g:2063:4: enumLiteral_131= 'serialBAUD_4800'
                    {
                    enumLiteral_131=(Token)match(input,205,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialBAUD_4800EnumLiteralDeclaration_131().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_131, grammarAccess.getChoicenamesAccess().getSerialBAUD_4800EnumLiteralDeclaration_131());
                    			

                    }


                    }
                    break;
                case 133 :
                    // InternalDbdTextEditor.g:2070:3: (enumLiteral_132= 'serialBAUD_9600' )
                    {
                    // InternalDbdTextEditor.g:2070:3: (enumLiteral_132= 'serialBAUD_9600' )
                    // InternalDbdTextEditor.g:2071:4: enumLiteral_132= 'serialBAUD_9600'
                    {
                    enumLiteral_132=(Token)match(input,206,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialBAUD_9600EnumLiteralDeclaration_132().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_132, grammarAccess.getChoicenamesAccess().getSerialBAUD_9600EnumLiteralDeclaration_132());
                    			

                    }


                    }
                    break;
                case 134 :
                    // InternalDbdTextEditor.g:2078:3: (enumLiteral_133= 'serialBAUD_19200' )
                    {
                    // InternalDbdTextEditor.g:2078:3: (enumLiteral_133= 'serialBAUD_19200' )
                    // InternalDbdTextEditor.g:2079:4: enumLiteral_133= 'serialBAUD_19200'
                    {
                    enumLiteral_133=(Token)match(input,207,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialBAUD_19200EnumLiteralDeclaration_133().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_133, grammarAccess.getChoicenamesAccess().getSerialBAUD_19200EnumLiteralDeclaration_133());
                    			

                    }


                    }
                    break;
                case 135 :
                    // InternalDbdTextEditor.g:2086:3: (enumLiteral_134= 'serialBAUD_38400' )
                    {
                    // InternalDbdTextEditor.g:2086:3: (enumLiteral_134= 'serialBAUD_38400' )
                    // InternalDbdTextEditor.g:2087:4: enumLiteral_134= 'serialBAUD_38400'
                    {
                    enumLiteral_134=(Token)match(input,208,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialBAUD_38400EnumLiteralDeclaration_134().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_134, grammarAccess.getChoicenamesAccess().getSerialBAUD_38400EnumLiteralDeclaration_134());
                    			

                    }


                    }
                    break;
                case 136 :
                    // InternalDbdTextEditor.g:2094:3: (enumLiteral_135= 'serialBAUD_57600' )
                    {
                    // InternalDbdTextEditor.g:2094:3: (enumLiteral_135= 'serialBAUD_57600' )
                    // InternalDbdTextEditor.g:2095:4: enumLiteral_135= 'serialBAUD_57600'
                    {
                    enumLiteral_135=(Token)match(input,209,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialBAUD_57600EnumLiteralDeclaration_135().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_135, grammarAccess.getChoicenamesAccess().getSerialBAUD_57600EnumLiteralDeclaration_135());
                    			

                    }


                    }
                    break;
                case 137 :
                    // InternalDbdTextEditor.g:2102:3: (enumLiteral_136= 'serialBAUD_115200' )
                    {
                    // InternalDbdTextEditor.g:2102:3: (enumLiteral_136= 'serialBAUD_115200' )
                    // InternalDbdTextEditor.g:2103:4: enumLiteral_136= 'serialBAUD_115200'
                    {
                    enumLiteral_136=(Token)match(input,210,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialBAUD_115200EnumLiteralDeclaration_136().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_136, grammarAccess.getChoicenamesAccess().getSerialBAUD_115200EnumLiteralDeclaration_136());
                    			

                    }


                    }
                    break;
                case 138 :
                    // InternalDbdTextEditor.g:2110:3: (enumLiteral_137= 'serialBAUD_230400' )
                    {
                    // InternalDbdTextEditor.g:2110:3: (enumLiteral_137= 'serialBAUD_230400' )
                    // InternalDbdTextEditor.g:2111:4: enumLiteral_137= 'serialBAUD_230400'
                    {
                    enumLiteral_137=(Token)match(input,211,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialBAUD_230400EnumLiteralDeclaration_137().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_137, grammarAccess.getChoicenamesAccess().getSerialBAUD_230400EnumLiteralDeclaration_137());
                    			

                    }


                    }
                    break;
                case 139 :
                    // InternalDbdTextEditor.g:2118:3: (enumLiteral_138= 'serialBAUD_460800' )
                    {
                    // InternalDbdTextEditor.g:2118:3: (enumLiteral_138= 'serialBAUD_460800' )
                    // InternalDbdTextEditor.g:2119:4: enumLiteral_138= 'serialBAUD_460800'
                    {
                    enumLiteral_138=(Token)match(input,212,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialBAUD_460800EnumLiteralDeclaration_138().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_138, grammarAccess.getChoicenamesAccess().getSerialBAUD_460800EnumLiteralDeclaration_138());
                    			

                    }


                    }
                    break;
                case 140 :
                    // InternalDbdTextEditor.g:2126:3: (enumLiteral_139= 'serialBAUD_576000' )
                    {
                    // InternalDbdTextEditor.g:2126:3: (enumLiteral_139= 'serialBAUD_576000' )
                    // InternalDbdTextEditor.g:2127:4: enumLiteral_139= 'serialBAUD_576000'
                    {
                    enumLiteral_139=(Token)match(input,213,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialBAUD_576000EnumLiteralDeclaration_139().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_139, grammarAccess.getChoicenamesAccess().getSerialBAUD_576000EnumLiteralDeclaration_139());
                    			

                    }


                    }
                    break;
                case 141 :
                    // InternalDbdTextEditor.g:2134:3: (enumLiteral_140= 'serialBAUD_921600' )
                    {
                    // InternalDbdTextEditor.g:2134:3: (enumLiteral_140= 'serialBAUD_921600' )
                    // InternalDbdTextEditor.g:2135:4: enumLiteral_140= 'serialBAUD_921600'
                    {
                    enumLiteral_140=(Token)match(input,214,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialBAUD_921600EnumLiteralDeclaration_140().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_140, grammarAccess.getChoicenamesAccess().getSerialBAUD_921600EnumLiteralDeclaration_140());
                    			

                    }


                    }
                    break;
                case 142 :
                    // InternalDbdTextEditor.g:2142:3: (enumLiteral_141= 'serialBAUD_1152000' )
                    {
                    // InternalDbdTextEditor.g:2142:3: (enumLiteral_141= 'serialBAUD_1152000' )
                    // InternalDbdTextEditor.g:2143:4: enumLiteral_141= 'serialBAUD_1152000'
                    {
                    enumLiteral_141=(Token)match(input,215,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getSerialBAUD_1152000EnumLiteralDeclaration_141().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_141, grammarAccess.getChoicenamesAccess().getSerialBAUD_1152000EnumLiteralDeclaration_141());
                    			

                    }


                    }
                    break;
                case 143 :
                    // InternalDbdTextEditor.g:2150:3: (enumLiteral_142= 'histogramCMD_Read' )
                    {
                    // InternalDbdTextEditor.g:2150:3: (enumLiteral_142= 'histogramCMD_Read' )
                    // InternalDbdTextEditor.g:2151:4: enumLiteral_142= 'histogramCMD_Read'
                    {
                    enumLiteral_142=(Token)match(input,216,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getHistogramCMD_ReadEnumLiteralDeclaration_142().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_142, grammarAccess.getChoicenamesAccess().getHistogramCMD_ReadEnumLiteralDeclaration_142());
                    			

                    }


                    }
                    break;
                case 144 :
                    // InternalDbdTextEditor.g:2158:3: (enumLiteral_143= 'histogramCMD_Clear' )
                    {
                    // InternalDbdTextEditor.g:2158:3: (enumLiteral_143= 'histogramCMD_Clear' )
                    // InternalDbdTextEditor.g:2159:4: enumLiteral_143= 'histogramCMD_Clear'
                    {
                    enumLiteral_143=(Token)match(input,217,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getHistogramCMD_ClearEnumLiteralDeclaration_143().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_143, grammarAccess.getChoicenamesAccess().getHistogramCMD_ClearEnumLiteralDeclaration_143());
                    			

                    }


                    }
                    break;
                case 145 :
                    // InternalDbdTextEditor.g:2166:3: (enumLiteral_144= 'histogramCMD_Start' )
                    {
                    // InternalDbdTextEditor.g:2166:3: (enumLiteral_144= 'histogramCMD_Start' )
                    // InternalDbdTextEditor.g:2167:4: enumLiteral_144= 'histogramCMD_Start'
                    {
                    enumLiteral_144=(Token)match(input,218,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getHistogramCMD_StartEnumLiteralDeclaration_144().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_144, grammarAccess.getChoicenamesAccess().getHistogramCMD_StartEnumLiteralDeclaration_144());
                    			

                    }


                    }
                    break;
                case 146 :
                    // InternalDbdTextEditor.g:2174:3: (enumLiteral_145= 'histogramCMD_Stop' )
                    {
                    // InternalDbdTextEditor.g:2174:3: (enumLiteral_145= 'histogramCMD_Stop' )
                    // InternalDbdTextEditor.g:2175:4: enumLiteral_145= 'histogramCMD_Stop'
                    {
                    enumLiteral_145=(Token)match(input,219,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getHistogramCMD_StopEnumLiteralDeclaration_145().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_145, grammarAccess.getChoicenamesAccess().getHistogramCMD_StopEnumLiteralDeclaration_145());
                    			

                    }


                    }
                    break;
                case 147 :
                    // InternalDbdTextEditor.g:2182:3: (enumLiteral_146= 'asynTRACE_Off' )
                    {
                    // InternalDbdTextEditor.g:2182:3: (enumLiteral_146= 'asynTRACE_Off' )
                    // InternalDbdTextEditor.g:2183:4: enumLiteral_146= 'asynTRACE_Off'
                    {
                    enumLiteral_146=(Token)match(input,220,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynTRACE_OffEnumLiteralDeclaration_146().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_146, grammarAccess.getChoicenamesAccess().getAsynTRACE_OffEnumLiteralDeclaration_146());
                    			

                    }


                    }
                    break;
                case 148 :
                    // InternalDbdTextEditor.g:2190:3: (enumLiteral_147= 'asynTRACE_On' )
                    {
                    // InternalDbdTextEditor.g:2190:3: (enumLiteral_147= 'asynTRACE_On' )
                    // InternalDbdTextEditor.g:2191:4: enumLiteral_147= 'asynTRACE_On'
                    {
                    enumLiteral_147=(Token)match(input,221,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynTRACE_OnEnumLiteralDeclaration_147().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_147, grammarAccess.getChoicenamesAccess().getAsynTRACE_OnEnumLiteralDeclaration_147());
                    			

                    }


                    }
                    break;
                case 149 :
                    // InternalDbdTextEditor.g:2198:3: (enumLiteral_148= 'scalerG1_N' )
                    {
                    // InternalDbdTextEditor.g:2198:3: (enumLiteral_148= 'scalerG1_N' )
                    // InternalDbdTextEditor.g:2199:4: enumLiteral_148= 'scalerG1_N'
                    {
                    enumLiteral_148=(Token)match(input,222,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getScalerG1_NEnumLiteralDeclaration_148().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_148, grammarAccess.getChoicenamesAccess().getScalerG1_NEnumLiteralDeclaration_148());
                    			

                    }


                    }
                    break;
                case 150 :
                    // InternalDbdTextEditor.g:2206:3: (enumLiteral_149= 'scalerG1_Y' )
                    {
                    // InternalDbdTextEditor.g:2206:3: (enumLiteral_149= 'scalerG1_Y' )
                    // InternalDbdTextEditor.g:2207:4: enumLiteral_149= 'scalerG1_Y'
                    {
                    enumLiteral_149=(Token)match(input,223,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getScalerG1_YEnumLiteralDeclaration_149().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_149, grammarAccess.getChoicenamesAccess().getScalerG1_YEnumLiteralDeclaration_149());
                    			

                    }


                    }
                    break;
                case 151 :
                    // InternalDbdTextEditor.g:2214:3: (enumLiteral_150= 'asynEOMREASONNone' )
                    {
                    // InternalDbdTextEditor.g:2214:3: (enumLiteral_150= 'asynEOMREASONNone' )
                    // InternalDbdTextEditor.g:2215:4: enumLiteral_150= 'asynEOMREASONNone'
                    {
                    enumLiteral_150=(Token)match(input,224,FOLLOW_2); 

                    				current = grammarAccess.getChoicenamesAccess().getAsynEOMREASONNoneEnumLiteralDeclaration_150().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_150, grammarAccess.getChoicenamesAccess().getAsynEOMREASONNoneEnumLiteralDeclaration_150());
                    			

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
    // $ANTLR end "ruleChoicenames"


    // $ANTLR start "ruleRecordtypenames"
    // InternalDbdTextEditor.g:2225:1: ruleRecordtypenames returns [Enumerator current=null] : ( (enumLiteral_0= 'calcout' ) | (enumLiteral_1= 'state' ) | (enumLiteral_2= 'histogram' ) | (enumLiteral_3= 'lsi' ) | (enumLiteral_4= 'int64out' ) | (enumLiteral_5= 'seq' ) | (enumLiteral_6= 'stringout' ) | (enumLiteral_7= 'aai' ) | (enumLiteral_8= 'permissive' ) | (enumLiteral_9= 'bo' ) | (enumLiteral_10= 'dfanout' ) | (enumLiteral_11= 'mbbi' ) | (enumLiteral_12= 'event' ) | (enumLiteral_13= 'compress' ) | (enumLiteral_14= 'mbbo' ) | (enumLiteral_15= 'epid' ) | (enumLiteral_16= 'ao' ) | (enumLiteral_17= 'aao' ) | (enumLiteral_18= 'mbbiDirect' ) | (enumLiteral_19= 'asyn' ) | (enumLiteral_20= 'waveform' ) | (enumLiteral_21= 'scaler' ) | (enumLiteral_22= 'timestamp' ) | (enumLiteral_23= 'fanout' ) | (enumLiteral_24= 'longin' ) | (enumLiteral_25= 'printf' ) | (enumLiteral_26= 'sel' ) | (enumLiteral_27= 'bi' ) | (enumLiteral_28= 'lso' ) | (enumLiteral_29= 'subArray' ) | (enumLiteral_30= 'calc' ) | (enumLiteral_31= 'mbboDirect' ) | (enumLiteral_32= 'longout' ) | (enumLiteral_33= 'aSub' ) | (enumLiteral_34= 'sub' ) | (enumLiteral_35= 'int64in' ) | (enumLiteral_36= 'ai' ) ) ;
    public final Enumerator ruleRecordtypenames() throws RecognitionException {
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


        	enterRule();

        try {
            // InternalDbdTextEditor.g:2231:2: ( ( (enumLiteral_0= 'calcout' ) | (enumLiteral_1= 'state' ) | (enumLiteral_2= 'histogram' ) | (enumLiteral_3= 'lsi' ) | (enumLiteral_4= 'int64out' ) | (enumLiteral_5= 'seq' ) | (enumLiteral_6= 'stringout' ) | (enumLiteral_7= 'aai' ) | (enumLiteral_8= 'permissive' ) | (enumLiteral_9= 'bo' ) | (enumLiteral_10= 'dfanout' ) | (enumLiteral_11= 'mbbi' ) | (enumLiteral_12= 'event' ) | (enumLiteral_13= 'compress' ) | (enumLiteral_14= 'mbbo' ) | (enumLiteral_15= 'epid' ) | (enumLiteral_16= 'ao' ) | (enumLiteral_17= 'aao' ) | (enumLiteral_18= 'mbbiDirect' ) | (enumLiteral_19= 'asyn' ) | (enumLiteral_20= 'waveform' ) | (enumLiteral_21= 'scaler' ) | (enumLiteral_22= 'timestamp' ) | (enumLiteral_23= 'fanout' ) | (enumLiteral_24= 'longin' ) | (enumLiteral_25= 'printf' ) | (enumLiteral_26= 'sel' ) | (enumLiteral_27= 'bi' ) | (enumLiteral_28= 'lso' ) | (enumLiteral_29= 'subArray' ) | (enumLiteral_30= 'calc' ) | (enumLiteral_31= 'mbboDirect' ) | (enumLiteral_32= 'longout' ) | (enumLiteral_33= 'aSub' ) | (enumLiteral_34= 'sub' ) | (enumLiteral_35= 'int64in' ) | (enumLiteral_36= 'ai' ) ) )
            // InternalDbdTextEditor.g:2232:2: ( (enumLiteral_0= 'calcout' ) | (enumLiteral_1= 'state' ) | (enumLiteral_2= 'histogram' ) | (enumLiteral_3= 'lsi' ) | (enumLiteral_4= 'int64out' ) | (enumLiteral_5= 'seq' ) | (enumLiteral_6= 'stringout' ) | (enumLiteral_7= 'aai' ) | (enumLiteral_8= 'permissive' ) | (enumLiteral_9= 'bo' ) | (enumLiteral_10= 'dfanout' ) | (enumLiteral_11= 'mbbi' ) | (enumLiteral_12= 'event' ) | (enumLiteral_13= 'compress' ) | (enumLiteral_14= 'mbbo' ) | (enumLiteral_15= 'epid' ) | (enumLiteral_16= 'ao' ) | (enumLiteral_17= 'aao' ) | (enumLiteral_18= 'mbbiDirect' ) | (enumLiteral_19= 'asyn' ) | (enumLiteral_20= 'waveform' ) | (enumLiteral_21= 'scaler' ) | (enumLiteral_22= 'timestamp' ) | (enumLiteral_23= 'fanout' ) | (enumLiteral_24= 'longin' ) | (enumLiteral_25= 'printf' ) | (enumLiteral_26= 'sel' ) | (enumLiteral_27= 'bi' ) | (enumLiteral_28= 'lso' ) | (enumLiteral_29= 'subArray' ) | (enumLiteral_30= 'calc' ) | (enumLiteral_31= 'mbboDirect' ) | (enumLiteral_32= 'longout' ) | (enumLiteral_33= 'aSub' ) | (enumLiteral_34= 'sub' ) | (enumLiteral_35= 'int64in' ) | (enumLiteral_36= 'ai' ) )
            {
            // InternalDbdTextEditor.g:2232:2: ( (enumLiteral_0= 'calcout' ) | (enumLiteral_1= 'state' ) | (enumLiteral_2= 'histogram' ) | (enumLiteral_3= 'lsi' ) | (enumLiteral_4= 'int64out' ) | (enumLiteral_5= 'seq' ) | (enumLiteral_6= 'stringout' ) | (enumLiteral_7= 'aai' ) | (enumLiteral_8= 'permissive' ) | (enumLiteral_9= 'bo' ) | (enumLiteral_10= 'dfanout' ) | (enumLiteral_11= 'mbbi' ) | (enumLiteral_12= 'event' ) | (enumLiteral_13= 'compress' ) | (enumLiteral_14= 'mbbo' ) | (enumLiteral_15= 'epid' ) | (enumLiteral_16= 'ao' ) | (enumLiteral_17= 'aao' ) | (enumLiteral_18= 'mbbiDirect' ) | (enumLiteral_19= 'asyn' ) | (enumLiteral_20= 'waveform' ) | (enumLiteral_21= 'scaler' ) | (enumLiteral_22= 'timestamp' ) | (enumLiteral_23= 'fanout' ) | (enumLiteral_24= 'longin' ) | (enumLiteral_25= 'printf' ) | (enumLiteral_26= 'sel' ) | (enumLiteral_27= 'bi' ) | (enumLiteral_28= 'lso' ) | (enumLiteral_29= 'subArray' ) | (enumLiteral_30= 'calc' ) | (enumLiteral_31= 'mbboDirect' ) | (enumLiteral_32= 'longout' ) | (enumLiteral_33= 'aSub' ) | (enumLiteral_34= 'sub' ) | (enumLiteral_35= 'int64in' ) | (enumLiteral_36= 'ai' ) )
            int alt9=37;
            switch ( input.LA(1) ) {
            case 225:
                {
                alt9=1;
                }
                break;
            case 226:
                {
                alt9=2;
                }
                break;
            case 227:
                {
                alt9=3;
                }
                break;
            case 228:
                {
                alt9=4;
                }
                break;
            case 229:
                {
                alt9=5;
                }
                break;
            case 230:
                {
                alt9=6;
                }
                break;
            case 231:
                {
                alt9=7;
                }
                break;
            case 232:
                {
                alt9=8;
                }
                break;
            case 233:
                {
                alt9=9;
                }
                break;
            case 234:
                {
                alt9=10;
                }
                break;
            case 235:
                {
                alt9=11;
                }
                break;
            case 236:
                {
                alt9=12;
                }
                break;
            case 237:
                {
                alt9=13;
                }
                break;
            case 238:
                {
                alt9=14;
                }
                break;
            case 239:
                {
                alt9=15;
                }
                break;
            case 240:
                {
                alt9=16;
                }
                break;
            case 241:
                {
                alt9=17;
                }
                break;
            case 242:
                {
                alt9=18;
                }
                break;
            case 243:
                {
                alt9=19;
                }
                break;
            case 244:
                {
                alt9=20;
                }
                break;
            case 245:
                {
                alt9=21;
                }
                break;
            case 246:
                {
                alt9=22;
                }
                break;
            case 247:
                {
                alt9=23;
                }
                break;
            case 248:
                {
                alt9=24;
                }
                break;
            case 249:
                {
                alt9=25;
                }
                break;
            case 250:
                {
                alt9=26;
                }
                break;
            case 251:
                {
                alt9=27;
                }
                break;
            case 252:
                {
                alt9=28;
                }
                break;
            case 253:
                {
                alt9=29;
                }
                break;
            case 254:
                {
                alt9=30;
                }
                break;
            case 255:
                {
                alt9=31;
                }
                break;
            case 256:
                {
                alt9=32;
                }
                break;
            case 257:
                {
                alt9=33;
                }
                break;
            case 258:
                {
                alt9=34;
                }
                break;
            case 259:
                {
                alt9=35;
                }
                break;
            case 260:
                {
                alt9=36;
                }
                break;
            case 261:
                {
                alt9=37;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalDbdTextEditor.g:2233:3: (enumLiteral_0= 'calcout' )
                    {
                    // InternalDbdTextEditor.g:2233:3: (enumLiteral_0= 'calcout' )
                    // InternalDbdTextEditor.g:2234:4: enumLiteral_0= 'calcout'
                    {
                    enumLiteral_0=(Token)match(input,225,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getCalcoutEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getRecordtypenamesAccess().getCalcoutEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDbdTextEditor.g:2241:3: (enumLiteral_1= 'state' )
                    {
                    // InternalDbdTextEditor.g:2241:3: (enumLiteral_1= 'state' )
                    // InternalDbdTextEditor.g:2242:4: enumLiteral_1= 'state'
                    {
                    enumLiteral_1=(Token)match(input,226,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getStateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getRecordtypenamesAccess().getStateEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDbdTextEditor.g:2249:3: (enumLiteral_2= 'histogram' )
                    {
                    // InternalDbdTextEditor.g:2249:3: (enumLiteral_2= 'histogram' )
                    // InternalDbdTextEditor.g:2250:4: enumLiteral_2= 'histogram'
                    {
                    enumLiteral_2=(Token)match(input,227,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getHistogramEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getRecordtypenamesAccess().getHistogramEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDbdTextEditor.g:2257:3: (enumLiteral_3= 'lsi' )
                    {
                    // InternalDbdTextEditor.g:2257:3: (enumLiteral_3= 'lsi' )
                    // InternalDbdTextEditor.g:2258:4: enumLiteral_3= 'lsi'
                    {
                    enumLiteral_3=(Token)match(input,228,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getLsiEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getRecordtypenamesAccess().getLsiEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDbdTextEditor.g:2265:3: (enumLiteral_4= 'int64out' )
                    {
                    // InternalDbdTextEditor.g:2265:3: (enumLiteral_4= 'int64out' )
                    // InternalDbdTextEditor.g:2266:4: enumLiteral_4= 'int64out'
                    {
                    enumLiteral_4=(Token)match(input,229,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getInt64outEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getRecordtypenamesAccess().getInt64outEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalDbdTextEditor.g:2273:3: (enumLiteral_5= 'seq' )
                    {
                    // InternalDbdTextEditor.g:2273:3: (enumLiteral_5= 'seq' )
                    // InternalDbdTextEditor.g:2274:4: enumLiteral_5= 'seq'
                    {
                    enumLiteral_5=(Token)match(input,230,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getSeqEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getRecordtypenamesAccess().getSeqEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalDbdTextEditor.g:2281:3: (enumLiteral_6= 'stringout' )
                    {
                    // InternalDbdTextEditor.g:2281:3: (enumLiteral_6= 'stringout' )
                    // InternalDbdTextEditor.g:2282:4: enumLiteral_6= 'stringout'
                    {
                    enumLiteral_6=(Token)match(input,231,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getStringoutEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getRecordtypenamesAccess().getStringoutEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalDbdTextEditor.g:2289:3: (enumLiteral_7= 'aai' )
                    {
                    // InternalDbdTextEditor.g:2289:3: (enumLiteral_7= 'aai' )
                    // InternalDbdTextEditor.g:2290:4: enumLiteral_7= 'aai'
                    {
                    enumLiteral_7=(Token)match(input,232,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getAaiEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getRecordtypenamesAccess().getAaiEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalDbdTextEditor.g:2297:3: (enumLiteral_8= 'permissive' )
                    {
                    // InternalDbdTextEditor.g:2297:3: (enumLiteral_8= 'permissive' )
                    // InternalDbdTextEditor.g:2298:4: enumLiteral_8= 'permissive'
                    {
                    enumLiteral_8=(Token)match(input,233,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getPermissiveEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getRecordtypenamesAccess().getPermissiveEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalDbdTextEditor.g:2305:3: (enumLiteral_9= 'bo' )
                    {
                    // InternalDbdTextEditor.g:2305:3: (enumLiteral_9= 'bo' )
                    // InternalDbdTextEditor.g:2306:4: enumLiteral_9= 'bo'
                    {
                    enumLiteral_9=(Token)match(input,234,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getBoEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getRecordtypenamesAccess().getBoEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalDbdTextEditor.g:2313:3: (enumLiteral_10= 'dfanout' )
                    {
                    // InternalDbdTextEditor.g:2313:3: (enumLiteral_10= 'dfanout' )
                    // InternalDbdTextEditor.g:2314:4: enumLiteral_10= 'dfanout'
                    {
                    enumLiteral_10=(Token)match(input,235,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getDfanoutEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getRecordtypenamesAccess().getDfanoutEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalDbdTextEditor.g:2321:3: (enumLiteral_11= 'mbbi' )
                    {
                    // InternalDbdTextEditor.g:2321:3: (enumLiteral_11= 'mbbi' )
                    // InternalDbdTextEditor.g:2322:4: enumLiteral_11= 'mbbi'
                    {
                    enumLiteral_11=(Token)match(input,236,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getMbbiEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getRecordtypenamesAccess().getMbbiEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalDbdTextEditor.g:2329:3: (enumLiteral_12= 'event' )
                    {
                    // InternalDbdTextEditor.g:2329:3: (enumLiteral_12= 'event' )
                    // InternalDbdTextEditor.g:2330:4: enumLiteral_12= 'event'
                    {
                    enumLiteral_12=(Token)match(input,237,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getEventEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getRecordtypenamesAccess().getEventEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalDbdTextEditor.g:2337:3: (enumLiteral_13= 'compress' )
                    {
                    // InternalDbdTextEditor.g:2337:3: (enumLiteral_13= 'compress' )
                    // InternalDbdTextEditor.g:2338:4: enumLiteral_13= 'compress'
                    {
                    enumLiteral_13=(Token)match(input,238,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getCompressEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getRecordtypenamesAccess().getCompressEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalDbdTextEditor.g:2345:3: (enumLiteral_14= 'mbbo' )
                    {
                    // InternalDbdTextEditor.g:2345:3: (enumLiteral_14= 'mbbo' )
                    // InternalDbdTextEditor.g:2346:4: enumLiteral_14= 'mbbo'
                    {
                    enumLiteral_14=(Token)match(input,239,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getMbboEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getRecordtypenamesAccess().getMbboEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalDbdTextEditor.g:2353:3: (enumLiteral_15= 'epid' )
                    {
                    // InternalDbdTextEditor.g:2353:3: (enumLiteral_15= 'epid' )
                    // InternalDbdTextEditor.g:2354:4: enumLiteral_15= 'epid'
                    {
                    enumLiteral_15=(Token)match(input,240,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getEpidEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getRecordtypenamesAccess().getEpidEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalDbdTextEditor.g:2361:3: (enumLiteral_16= 'ao' )
                    {
                    // InternalDbdTextEditor.g:2361:3: (enumLiteral_16= 'ao' )
                    // InternalDbdTextEditor.g:2362:4: enumLiteral_16= 'ao'
                    {
                    enumLiteral_16=(Token)match(input,241,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getAoEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getRecordtypenamesAccess().getAoEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalDbdTextEditor.g:2369:3: (enumLiteral_17= 'aao' )
                    {
                    // InternalDbdTextEditor.g:2369:3: (enumLiteral_17= 'aao' )
                    // InternalDbdTextEditor.g:2370:4: enumLiteral_17= 'aao'
                    {
                    enumLiteral_17=(Token)match(input,242,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getAaoEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getRecordtypenamesAccess().getAaoEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalDbdTextEditor.g:2377:3: (enumLiteral_18= 'mbbiDirect' )
                    {
                    // InternalDbdTextEditor.g:2377:3: (enumLiteral_18= 'mbbiDirect' )
                    // InternalDbdTextEditor.g:2378:4: enumLiteral_18= 'mbbiDirect'
                    {
                    enumLiteral_18=(Token)match(input,243,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getMbbiDirectEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getRecordtypenamesAccess().getMbbiDirectEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalDbdTextEditor.g:2385:3: (enumLiteral_19= 'asyn' )
                    {
                    // InternalDbdTextEditor.g:2385:3: (enumLiteral_19= 'asyn' )
                    // InternalDbdTextEditor.g:2386:4: enumLiteral_19= 'asyn'
                    {
                    enumLiteral_19=(Token)match(input,244,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getAsynEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getRecordtypenamesAccess().getAsynEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalDbdTextEditor.g:2393:3: (enumLiteral_20= 'waveform' )
                    {
                    // InternalDbdTextEditor.g:2393:3: (enumLiteral_20= 'waveform' )
                    // InternalDbdTextEditor.g:2394:4: enumLiteral_20= 'waveform'
                    {
                    enumLiteral_20=(Token)match(input,245,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getWaveformEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getRecordtypenamesAccess().getWaveformEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalDbdTextEditor.g:2401:3: (enumLiteral_21= 'scaler' )
                    {
                    // InternalDbdTextEditor.g:2401:3: (enumLiteral_21= 'scaler' )
                    // InternalDbdTextEditor.g:2402:4: enumLiteral_21= 'scaler'
                    {
                    enumLiteral_21=(Token)match(input,246,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getScalerEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getRecordtypenamesAccess().getScalerEnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalDbdTextEditor.g:2409:3: (enumLiteral_22= 'timestamp' )
                    {
                    // InternalDbdTextEditor.g:2409:3: (enumLiteral_22= 'timestamp' )
                    // InternalDbdTextEditor.g:2410:4: enumLiteral_22= 'timestamp'
                    {
                    enumLiteral_22=(Token)match(input,247,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getTimestampEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getRecordtypenamesAccess().getTimestampEnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalDbdTextEditor.g:2417:3: (enumLiteral_23= 'fanout' )
                    {
                    // InternalDbdTextEditor.g:2417:3: (enumLiteral_23= 'fanout' )
                    // InternalDbdTextEditor.g:2418:4: enumLiteral_23= 'fanout'
                    {
                    enumLiteral_23=(Token)match(input,248,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getFanoutEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getRecordtypenamesAccess().getFanoutEnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalDbdTextEditor.g:2425:3: (enumLiteral_24= 'longin' )
                    {
                    // InternalDbdTextEditor.g:2425:3: (enumLiteral_24= 'longin' )
                    // InternalDbdTextEditor.g:2426:4: enumLiteral_24= 'longin'
                    {
                    enumLiteral_24=(Token)match(input,249,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getLonginEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getRecordtypenamesAccess().getLonginEnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalDbdTextEditor.g:2433:3: (enumLiteral_25= 'printf' )
                    {
                    // InternalDbdTextEditor.g:2433:3: (enumLiteral_25= 'printf' )
                    // InternalDbdTextEditor.g:2434:4: enumLiteral_25= 'printf'
                    {
                    enumLiteral_25=(Token)match(input,250,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getPrintfEnumLiteralDeclaration_25().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_25, grammarAccess.getRecordtypenamesAccess().getPrintfEnumLiteralDeclaration_25());
                    			

                    }


                    }
                    break;
                case 27 :
                    // InternalDbdTextEditor.g:2441:3: (enumLiteral_26= 'sel' )
                    {
                    // InternalDbdTextEditor.g:2441:3: (enumLiteral_26= 'sel' )
                    // InternalDbdTextEditor.g:2442:4: enumLiteral_26= 'sel'
                    {
                    enumLiteral_26=(Token)match(input,251,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getSelEnumLiteralDeclaration_26().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_26, grammarAccess.getRecordtypenamesAccess().getSelEnumLiteralDeclaration_26());
                    			

                    }


                    }
                    break;
                case 28 :
                    // InternalDbdTextEditor.g:2449:3: (enumLiteral_27= 'bi' )
                    {
                    // InternalDbdTextEditor.g:2449:3: (enumLiteral_27= 'bi' )
                    // InternalDbdTextEditor.g:2450:4: enumLiteral_27= 'bi'
                    {
                    enumLiteral_27=(Token)match(input,252,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getBiEnumLiteralDeclaration_27().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_27, grammarAccess.getRecordtypenamesAccess().getBiEnumLiteralDeclaration_27());
                    			

                    }


                    }
                    break;
                case 29 :
                    // InternalDbdTextEditor.g:2457:3: (enumLiteral_28= 'lso' )
                    {
                    // InternalDbdTextEditor.g:2457:3: (enumLiteral_28= 'lso' )
                    // InternalDbdTextEditor.g:2458:4: enumLiteral_28= 'lso'
                    {
                    enumLiteral_28=(Token)match(input,253,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getLsoEnumLiteralDeclaration_28().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_28, grammarAccess.getRecordtypenamesAccess().getLsoEnumLiteralDeclaration_28());
                    			

                    }


                    }
                    break;
                case 30 :
                    // InternalDbdTextEditor.g:2465:3: (enumLiteral_29= 'subArray' )
                    {
                    // InternalDbdTextEditor.g:2465:3: (enumLiteral_29= 'subArray' )
                    // InternalDbdTextEditor.g:2466:4: enumLiteral_29= 'subArray'
                    {
                    enumLiteral_29=(Token)match(input,254,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getSubArrayEnumLiteralDeclaration_29().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_29, grammarAccess.getRecordtypenamesAccess().getSubArrayEnumLiteralDeclaration_29());
                    			

                    }


                    }
                    break;
                case 31 :
                    // InternalDbdTextEditor.g:2473:3: (enumLiteral_30= 'calc' )
                    {
                    // InternalDbdTextEditor.g:2473:3: (enumLiteral_30= 'calc' )
                    // InternalDbdTextEditor.g:2474:4: enumLiteral_30= 'calc'
                    {
                    enumLiteral_30=(Token)match(input,255,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getCalcEnumLiteralDeclaration_30().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_30, grammarAccess.getRecordtypenamesAccess().getCalcEnumLiteralDeclaration_30());
                    			

                    }


                    }
                    break;
                case 32 :
                    // InternalDbdTextEditor.g:2481:3: (enumLiteral_31= 'mbboDirect' )
                    {
                    // InternalDbdTextEditor.g:2481:3: (enumLiteral_31= 'mbboDirect' )
                    // InternalDbdTextEditor.g:2482:4: enumLiteral_31= 'mbboDirect'
                    {
                    enumLiteral_31=(Token)match(input,256,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getMbboDirectEnumLiteralDeclaration_31().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_31, grammarAccess.getRecordtypenamesAccess().getMbboDirectEnumLiteralDeclaration_31());
                    			

                    }


                    }
                    break;
                case 33 :
                    // InternalDbdTextEditor.g:2489:3: (enumLiteral_32= 'longout' )
                    {
                    // InternalDbdTextEditor.g:2489:3: (enumLiteral_32= 'longout' )
                    // InternalDbdTextEditor.g:2490:4: enumLiteral_32= 'longout'
                    {
                    enumLiteral_32=(Token)match(input,257,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getLongoutEnumLiteralDeclaration_32().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_32, grammarAccess.getRecordtypenamesAccess().getLongoutEnumLiteralDeclaration_32());
                    			

                    }


                    }
                    break;
                case 34 :
                    // InternalDbdTextEditor.g:2497:3: (enumLiteral_33= 'aSub' )
                    {
                    // InternalDbdTextEditor.g:2497:3: (enumLiteral_33= 'aSub' )
                    // InternalDbdTextEditor.g:2498:4: enumLiteral_33= 'aSub'
                    {
                    enumLiteral_33=(Token)match(input,258,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getASubEnumLiteralDeclaration_33().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_33, grammarAccess.getRecordtypenamesAccess().getASubEnumLiteralDeclaration_33());
                    			

                    }


                    }
                    break;
                case 35 :
                    // InternalDbdTextEditor.g:2505:3: (enumLiteral_34= 'sub' )
                    {
                    // InternalDbdTextEditor.g:2505:3: (enumLiteral_34= 'sub' )
                    // InternalDbdTextEditor.g:2506:4: enumLiteral_34= 'sub'
                    {
                    enumLiteral_34=(Token)match(input,259,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getSubEnumLiteralDeclaration_34().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_34, grammarAccess.getRecordtypenamesAccess().getSubEnumLiteralDeclaration_34());
                    			

                    }


                    }
                    break;
                case 36 :
                    // InternalDbdTextEditor.g:2513:3: (enumLiteral_35= 'int64in' )
                    {
                    // InternalDbdTextEditor.g:2513:3: (enumLiteral_35= 'int64in' )
                    // InternalDbdTextEditor.g:2514:4: enumLiteral_35= 'int64in'
                    {
                    enumLiteral_35=(Token)match(input,260,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getInt64inEnumLiteralDeclaration_35().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_35, grammarAccess.getRecordtypenamesAccess().getInt64inEnumLiteralDeclaration_35());
                    			

                    }


                    }
                    break;
                case 37 :
                    // InternalDbdTextEditor.g:2521:3: (enumLiteral_36= 'ai' )
                    {
                    // InternalDbdTextEditor.g:2521:3: (enumLiteral_36= 'ai' )
                    // InternalDbdTextEditor.g:2522:4: enumLiteral_36= 'ai'
                    {
                    enumLiteral_36=(Token)match(input,261,FOLLOW_2); 

                    				current = grammarAccess.getRecordtypenamesAccess().getAiEnumLiteralDeclaration_36().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_36, grammarAccess.getRecordtypenamesAccess().getAiEnumLiteralDeclaration_36());
                    			

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
    // $ANTLR end "ruleRecordtypenames"


    // $ANTLR start "ruleFieldnames"
    // InternalDbdTextEditor.g:2532:1: ruleFieldnames returns [Enumerator current=null] : ( (enumLiteral_0= 'NAME' ) | (enumLiteral_1= 'DESC' ) | (enumLiteral_2= 'ASG' ) | (enumLiteral_3= 'SCAN' ) | (enumLiteral_4= 'PINI' ) | (enumLiteral_5= 'PHAS' ) | (enumLiteral_6= 'EVNT' ) | (enumLiteral_7= 'TSE' ) | (enumLiteral_8= 'TSEL' ) | (enumLiteral_9= 'DTYP' ) | (enumLiteral_10= 'DISV' ) | (enumLiteral_11= 'DISA' ) | (enumLiteral_12= 'SDIS' ) | (enumLiteral_13= 'MLOK' ) | (enumLiteral_14= 'MLIS' ) | (enumLiteral_15= 'BKLNK' ) | (enumLiteral_16= 'DISP' ) | (enumLiteral_17= 'PROC' ) | (enumLiteral_18= 'STAT' ) | (enumLiteral_19= 'SEVR' ) | (enumLiteral_20= 'NSTA' ) | (enumLiteral_21= 'NSEV' ) | (enumLiteral_22= 'ACKS' ) | (enumLiteral_23= 'ACKT' ) | (enumLiteral_24= 'DISS' ) | (enumLiteral_25= 'PACT' ) | (enumLiteral_26= 'PUTF' ) | (enumLiteral_27= 'RPRO' ) | (enumLiteral_28= 'ASP' ) | (enumLiteral_29= 'PPN' ) | (enumLiteral_30= 'PPNR' ) | (enumLiteral_31= 'SPVT' ) | (enumLiteral_32= 'RSET' ) | (enumLiteral_33= 'DSET' ) | (enumLiteral_34= 'DPVT' ) | (enumLiteral_35= 'RDES' ) | (enumLiteral_36= 'LSET' ) | (enumLiteral_37= 'PRIO' ) | (enumLiteral_38= 'TPRO' ) | (enumLiteral_39= 'BKPT' ) | (enumLiteral_40= 'UDF' ) | (enumLiteral_41= 'UDFS' ) | (enumLiteral_42= 'TIME' ) | (enumLiteral_43= 'FLNK' ) | (enumLiteral_44= 'RPVT' ) | (enumLiteral_45= 'VAL' ) | (enumLiteral_46= 'PVAL' ) | (enumLiteral_47= 'CALC' ) | (enumLiteral_48= 'CLCV' ) | (enumLiteral_49= 'INPA' ) | (enumLiteral_50= 'INPB' ) | (enumLiteral_51= 'INPC' ) | (enumLiteral_52= 'INPD' ) | (enumLiteral_53= 'INPE' ) | (enumLiteral_54= 'INPF' ) | (enumLiteral_55= 'INPG' ) | (enumLiteral_56= 'INPH' ) | (enumLiteral_57= 'INPI' ) | (enumLiteral_58= 'INPJ' ) | (enumLiteral_59= 'INPK' ) | (enumLiteral_60= 'INPL' ) | (enumLiteral_61= 'OUT' ) | (enumLiteral_62= 'INAV' ) | (enumLiteral_63= 'INBV' ) | (enumLiteral_64= 'INCV' ) | (enumLiteral_65= 'INDV' ) | (enumLiteral_66= 'INEV' ) | (enumLiteral_67= 'INFV' ) | (enumLiteral_68= 'INGV' ) | (enumLiteral_69= 'INHV' ) | (enumLiteral_70= 'INIV' ) | (enumLiteral_71= 'INJV' ) | (enumLiteral_72= 'INKV' ) | (enumLiteral_73= 'INLV' ) | (enumLiteral_74= 'OOPT' ) | (enumLiteral_75= 'DLYA' ) | (enumLiteral_76= 'DOPT' ) | (enumLiteral_77= 'OCAL' ) | (enumLiteral_78= 'OCLV' ) | (enumLiteral_79= 'OEVT' ) | (enumLiteral_80= 'EPVT' ) | (enumLiteral_81= 'IVOA' ) | (enumLiteral_82= 'IVOV' ) | (enumLiteral_83= 'PREC' ) | (enumLiteral_84= 'HOPR' ) | (enumLiteral_85= 'LOPR' ) | (enumLiteral_86= 'HIHI' ) | (enumLiteral_87= 'LOLO' ) | (enumLiteral_88= 'HIGH' ) | (enumLiteral_89= 'LOW' ) | (enumLiteral_90= 'HHSV' ) | (enumLiteral_91= 'LLSV' ) | (enumLiteral_92= 'HSV' ) | (enumLiteral_93= 'LSV' ) | (enumLiteral_94= 'HYST' ) | (enumLiteral_95= 'ADEL' ) | (enumLiteral_96= 'MDEL' ) | (enumLiteral_97= 'A' ) | (enumLiteral_98= 'B' ) | (enumLiteral_99= 'C' ) | (enumLiteral_100= 'D' ) | (enumLiteral_101= 'E' ) | (enumLiteral_102= 'F' ) | (enumLiteral_103= 'G' ) | (enumLiteral_104= 'H' ) | (enumLiteral_105= 'I' ) | (enumLiteral_106= 'J' ) | (enumLiteral_107= 'K' ) | (enumLiteral_108= 'L' ) | (enumLiteral_109= 'OVAL' ) | (enumLiteral_110= 'LA' ) | (enumLiteral_111= 'LB' ) | (enumLiteral_112= 'LC' ) | (enumLiteral_113= 'LD' ) | (enumLiteral_114= 'LE' ) | (enumLiteral_115= 'LF' ) | (enumLiteral_116= 'LG' ) | (enumLiteral_117= 'LH' ) | (enumLiteral_118= 'LI' ) | (enumLiteral_119= 'LJ' ) | (enumLiteral_120= 'LK' ) | (enumLiteral_121= 'LL' ) | (enumLiteral_122= 'POVL' ) | (enumLiteral_123= 'LALM' ) | (enumLiteral_124= 'ALST' ) | (enumLiteral_125= 'MLST' ) | (enumLiteral_126= 'RPCL' ) | (enumLiteral_127= 'ORPC' ) ) ;
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
        Token enumLiteral_97=null;
        Token enumLiteral_98=null;
        Token enumLiteral_99=null;
        Token enumLiteral_100=null;
        Token enumLiteral_101=null;
        Token enumLiteral_102=null;
        Token enumLiteral_103=null;
        Token enumLiteral_104=null;
        Token enumLiteral_105=null;
        Token enumLiteral_106=null;
        Token enumLiteral_107=null;
        Token enumLiteral_108=null;
        Token enumLiteral_109=null;
        Token enumLiteral_110=null;
        Token enumLiteral_111=null;
        Token enumLiteral_112=null;
        Token enumLiteral_113=null;
        Token enumLiteral_114=null;
        Token enumLiteral_115=null;
        Token enumLiteral_116=null;
        Token enumLiteral_117=null;
        Token enumLiteral_118=null;
        Token enumLiteral_119=null;
        Token enumLiteral_120=null;
        Token enumLiteral_121=null;
        Token enumLiteral_122=null;
        Token enumLiteral_123=null;
        Token enumLiteral_124=null;
        Token enumLiteral_125=null;
        Token enumLiteral_126=null;
        Token enumLiteral_127=null;


        	enterRule();

        try {
            // InternalDbdTextEditor.g:2538:2: ( ( (enumLiteral_0= 'NAME' ) | (enumLiteral_1= 'DESC' ) | (enumLiteral_2= 'ASG' ) | (enumLiteral_3= 'SCAN' ) | (enumLiteral_4= 'PINI' ) | (enumLiteral_5= 'PHAS' ) | (enumLiteral_6= 'EVNT' ) | (enumLiteral_7= 'TSE' ) | (enumLiteral_8= 'TSEL' ) | (enumLiteral_9= 'DTYP' ) | (enumLiteral_10= 'DISV' ) | (enumLiteral_11= 'DISA' ) | (enumLiteral_12= 'SDIS' ) | (enumLiteral_13= 'MLOK' ) | (enumLiteral_14= 'MLIS' ) | (enumLiteral_15= 'BKLNK' ) | (enumLiteral_16= 'DISP' ) | (enumLiteral_17= 'PROC' ) | (enumLiteral_18= 'STAT' ) | (enumLiteral_19= 'SEVR' ) | (enumLiteral_20= 'NSTA' ) | (enumLiteral_21= 'NSEV' ) | (enumLiteral_22= 'ACKS' ) | (enumLiteral_23= 'ACKT' ) | (enumLiteral_24= 'DISS' ) | (enumLiteral_25= 'PACT' ) | (enumLiteral_26= 'PUTF' ) | (enumLiteral_27= 'RPRO' ) | (enumLiteral_28= 'ASP' ) | (enumLiteral_29= 'PPN' ) | (enumLiteral_30= 'PPNR' ) | (enumLiteral_31= 'SPVT' ) | (enumLiteral_32= 'RSET' ) | (enumLiteral_33= 'DSET' ) | (enumLiteral_34= 'DPVT' ) | (enumLiteral_35= 'RDES' ) | (enumLiteral_36= 'LSET' ) | (enumLiteral_37= 'PRIO' ) | (enumLiteral_38= 'TPRO' ) | (enumLiteral_39= 'BKPT' ) | (enumLiteral_40= 'UDF' ) | (enumLiteral_41= 'UDFS' ) | (enumLiteral_42= 'TIME' ) | (enumLiteral_43= 'FLNK' ) | (enumLiteral_44= 'RPVT' ) | (enumLiteral_45= 'VAL' ) | (enumLiteral_46= 'PVAL' ) | (enumLiteral_47= 'CALC' ) | (enumLiteral_48= 'CLCV' ) | (enumLiteral_49= 'INPA' ) | (enumLiteral_50= 'INPB' ) | (enumLiteral_51= 'INPC' ) | (enumLiteral_52= 'INPD' ) | (enumLiteral_53= 'INPE' ) | (enumLiteral_54= 'INPF' ) | (enumLiteral_55= 'INPG' ) | (enumLiteral_56= 'INPH' ) | (enumLiteral_57= 'INPI' ) | (enumLiteral_58= 'INPJ' ) | (enumLiteral_59= 'INPK' ) | (enumLiteral_60= 'INPL' ) | (enumLiteral_61= 'OUT' ) | (enumLiteral_62= 'INAV' ) | (enumLiteral_63= 'INBV' ) | (enumLiteral_64= 'INCV' ) | (enumLiteral_65= 'INDV' ) | (enumLiteral_66= 'INEV' ) | (enumLiteral_67= 'INFV' ) | (enumLiteral_68= 'INGV' ) | (enumLiteral_69= 'INHV' ) | (enumLiteral_70= 'INIV' ) | (enumLiteral_71= 'INJV' ) | (enumLiteral_72= 'INKV' ) | (enumLiteral_73= 'INLV' ) | (enumLiteral_74= 'OOPT' ) | (enumLiteral_75= 'DLYA' ) | (enumLiteral_76= 'DOPT' ) | (enumLiteral_77= 'OCAL' ) | (enumLiteral_78= 'OCLV' ) | (enumLiteral_79= 'OEVT' ) | (enumLiteral_80= 'EPVT' ) | (enumLiteral_81= 'IVOA' ) | (enumLiteral_82= 'IVOV' ) | (enumLiteral_83= 'PREC' ) | (enumLiteral_84= 'HOPR' ) | (enumLiteral_85= 'LOPR' ) | (enumLiteral_86= 'HIHI' ) | (enumLiteral_87= 'LOLO' ) | (enumLiteral_88= 'HIGH' ) | (enumLiteral_89= 'LOW' ) | (enumLiteral_90= 'HHSV' ) | (enumLiteral_91= 'LLSV' ) | (enumLiteral_92= 'HSV' ) | (enumLiteral_93= 'LSV' ) | (enumLiteral_94= 'HYST' ) | (enumLiteral_95= 'ADEL' ) | (enumLiteral_96= 'MDEL' ) | (enumLiteral_97= 'A' ) | (enumLiteral_98= 'B' ) | (enumLiteral_99= 'C' ) | (enumLiteral_100= 'D' ) | (enumLiteral_101= 'E' ) | (enumLiteral_102= 'F' ) | (enumLiteral_103= 'G' ) | (enumLiteral_104= 'H' ) | (enumLiteral_105= 'I' ) | (enumLiteral_106= 'J' ) | (enumLiteral_107= 'K' ) | (enumLiteral_108= 'L' ) | (enumLiteral_109= 'OVAL' ) | (enumLiteral_110= 'LA' ) | (enumLiteral_111= 'LB' ) | (enumLiteral_112= 'LC' ) | (enumLiteral_113= 'LD' ) | (enumLiteral_114= 'LE' ) | (enumLiteral_115= 'LF' ) | (enumLiteral_116= 'LG' ) | (enumLiteral_117= 'LH' ) | (enumLiteral_118= 'LI' ) | (enumLiteral_119= 'LJ' ) | (enumLiteral_120= 'LK' ) | (enumLiteral_121= 'LL' ) | (enumLiteral_122= 'POVL' ) | (enumLiteral_123= 'LALM' ) | (enumLiteral_124= 'ALST' ) | (enumLiteral_125= 'MLST' ) | (enumLiteral_126= 'RPCL' ) | (enumLiteral_127= 'ORPC' ) ) )
            // InternalDbdTextEditor.g:2539:2: ( (enumLiteral_0= 'NAME' ) | (enumLiteral_1= 'DESC' ) | (enumLiteral_2= 'ASG' ) | (enumLiteral_3= 'SCAN' ) | (enumLiteral_4= 'PINI' ) | (enumLiteral_5= 'PHAS' ) | (enumLiteral_6= 'EVNT' ) | (enumLiteral_7= 'TSE' ) | (enumLiteral_8= 'TSEL' ) | (enumLiteral_9= 'DTYP' ) | (enumLiteral_10= 'DISV' ) | (enumLiteral_11= 'DISA' ) | (enumLiteral_12= 'SDIS' ) | (enumLiteral_13= 'MLOK' ) | (enumLiteral_14= 'MLIS' ) | (enumLiteral_15= 'BKLNK' ) | (enumLiteral_16= 'DISP' ) | (enumLiteral_17= 'PROC' ) | (enumLiteral_18= 'STAT' ) | (enumLiteral_19= 'SEVR' ) | (enumLiteral_20= 'NSTA' ) | (enumLiteral_21= 'NSEV' ) | (enumLiteral_22= 'ACKS' ) | (enumLiteral_23= 'ACKT' ) | (enumLiteral_24= 'DISS' ) | (enumLiteral_25= 'PACT' ) | (enumLiteral_26= 'PUTF' ) | (enumLiteral_27= 'RPRO' ) | (enumLiteral_28= 'ASP' ) | (enumLiteral_29= 'PPN' ) | (enumLiteral_30= 'PPNR' ) | (enumLiteral_31= 'SPVT' ) | (enumLiteral_32= 'RSET' ) | (enumLiteral_33= 'DSET' ) | (enumLiteral_34= 'DPVT' ) | (enumLiteral_35= 'RDES' ) | (enumLiteral_36= 'LSET' ) | (enumLiteral_37= 'PRIO' ) | (enumLiteral_38= 'TPRO' ) | (enumLiteral_39= 'BKPT' ) | (enumLiteral_40= 'UDF' ) | (enumLiteral_41= 'UDFS' ) | (enumLiteral_42= 'TIME' ) | (enumLiteral_43= 'FLNK' ) | (enumLiteral_44= 'RPVT' ) | (enumLiteral_45= 'VAL' ) | (enumLiteral_46= 'PVAL' ) | (enumLiteral_47= 'CALC' ) | (enumLiteral_48= 'CLCV' ) | (enumLiteral_49= 'INPA' ) | (enumLiteral_50= 'INPB' ) | (enumLiteral_51= 'INPC' ) | (enumLiteral_52= 'INPD' ) | (enumLiteral_53= 'INPE' ) | (enumLiteral_54= 'INPF' ) | (enumLiteral_55= 'INPG' ) | (enumLiteral_56= 'INPH' ) | (enumLiteral_57= 'INPI' ) | (enumLiteral_58= 'INPJ' ) | (enumLiteral_59= 'INPK' ) | (enumLiteral_60= 'INPL' ) | (enumLiteral_61= 'OUT' ) | (enumLiteral_62= 'INAV' ) | (enumLiteral_63= 'INBV' ) | (enumLiteral_64= 'INCV' ) | (enumLiteral_65= 'INDV' ) | (enumLiteral_66= 'INEV' ) | (enumLiteral_67= 'INFV' ) | (enumLiteral_68= 'INGV' ) | (enumLiteral_69= 'INHV' ) | (enumLiteral_70= 'INIV' ) | (enumLiteral_71= 'INJV' ) | (enumLiteral_72= 'INKV' ) | (enumLiteral_73= 'INLV' ) | (enumLiteral_74= 'OOPT' ) | (enumLiteral_75= 'DLYA' ) | (enumLiteral_76= 'DOPT' ) | (enumLiteral_77= 'OCAL' ) | (enumLiteral_78= 'OCLV' ) | (enumLiteral_79= 'OEVT' ) | (enumLiteral_80= 'EPVT' ) | (enumLiteral_81= 'IVOA' ) | (enumLiteral_82= 'IVOV' ) | (enumLiteral_83= 'PREC' ) | (enumLiteral_84= 'HOPR' ) | (enumLiteral_85= 'LOPR' ) | (enumLiteral_86= 'HIHI' ) | (enumLiteral_87= 'LOLO' ) | (enumLiteral_88= 'HIGH' ) | (enumLiteral_89= 'LOW' ) | (enumLiteral_90= 'HHSV' ) | (enumLiteral_91= 'LLSV' ) | (enumLiteral_92= 'HSV' ) | (enumLiteral_93= 'LSV' ) | (enumLiteral_94= 'HYST' ) | (enumLiteral_95= 'ADEL' ) | (enumLiteral_96= 'MDEL' ) | (enumLiteral_97= 'A' ) | (enumLiteral_98= 'B' ) | (enumLiteral_99= 'C' ) | (enumLiteral_100= 'D' ) | (enumLiteral_101= 'E' ) | (enumLiteral_102= 'F' ) | (enumLiteral_103= 'G' ) | (enumLiteral_104= 'H' ) | (enumLiteral_105= 'I' ) | (enumLiteral_106= 'J' ) | (enumLiteral_107= 'K' ) | (enumLiteral_108= 'L' ) | (enumLiteral_109= 'OVAL' ) | (enumLiteral_110= 'LA' ) | (enumLiteral_111= 'LB' ) | (enumLiteral_112= 'LC' ) | (enumLiteral_113= 'LD' ) | (enumLiteral_114= 'LE' ) | (enumLiteral_115= 'LF' ) | (enumLiteral_116= 'LG' ) | (enumLiteral_117= 'LH' ) | (enumLiteral_118= 'LI' ) | (enumLiteral_119= 'LJ' ) | (enumLiteral_120= 'LK' ) | (enumLiteral_121= 'LL' ) | (enumLiteral_122= 'POVL' ) | (enumLiteral_123= 'LALM' ) | (enumLiteral_124= 'ALST' ) | (enumLiteral_125= 'MLST' ) | (enumLiteral_126= 'RPCL' ) | (enumLiteral_127= 'ORPC' ) )
            {
            // InternalDbdTextEditor.g:2539:2: ( (enumLiteral_0= 'NAME' ) | (enumLiteral_1= 'DESC' ) | (enumLiteral_2= 'ASG' ) | (enumLiteral_3= 'SCAN' ) | (enumLiteral_4= 'PINI' ) | (enumLiteral_5= 'PHAS' ) | (enumLiteral_6= 'EVNT' ) | (enumLiteral_7= 'TSE' ) | (enumLiteral_8= 'TSEL' ) | (enumLiteral_9= 'DTYP' ) | (enumLiteral_10= 'DISV' ) | (enumLiteral_11= 'DISA' ) | (enumLiteral_12= 'SDIS' ) | (enumLiteral_13= 'MLOK' ) | (enumLiteral_14= 'MLIS' ) | (enumLiteral_15= 'BKLNK' ) | (enumLiteral_16= 'DISP' ) | (enumLiteral_17= 'PROC' ) | (enumLiteral_18= 'STAT' ) | (enumLiteral_19= 'SEVR' ) | (enumLiteral_20= 'NSTA' ) | (enumLiteral_21= 'NSEV' ) | (enumLiteral_22= 'ACKS' ) | (enumLiteral_23= 'ACKT' ) | (enumLiteral_24= 'DISS' ) | (enumLiteral_25= 'PACT' ) | (enumLiteral_26= 'PUTF' ) | (enumLiteral_27= 'RPRO' ) | (enumLiteral_28= 'ASP' ) | (enumLiteral_29= 'PPN' ) | (enumLiteral_30= 'PPNR' ) | (enumLiteral_31= 'SPVT' ) | (enumLiteral_32= 'RSET' ) | (enumLiteral_33= 'DSET' ) | (enumLiteral_34= 'DPVT' ) | (enumLiteral_35= 'RDES' ) | (enumLiteral_36= 'LSET' ) | (enumLiteral_37= 'PRIO' ) | (enumLiteral_38= 'TPRO' ) | (enumLiteral_39= 'BKPT' ) | (enumLiteral_40= 'UDF' ) | (enumLiteral_41= 'UDFS' ) | (enumLiteral_42= 'TIME' ) | (enumLiteral_43= 'FLNK' ) | (enumLiteral_44= 'RPVT' ) | (enumLiteral_45= 'VAL' ) | (enumLiteral_46= 'PVAL' ) | (enumLiteral_47= 'CALC' ) | (enumLiteral_48= 'CLCV' ) | (enumLiteral_49= 'INPA' ) | (enumLiteral_50= 'INPB' ) | (enumLiteral_51= 'INPC' ) | (enumLiteral_52= 'INPD' ) | (enumLiteral_53= 'INPE' ) | (enumLiteral_54= 'INPF' ) | (enumLiteral_55= 'INPG' ) | (enumLiteral_56= 'INPH' ) | (enumLiteral_57= 'INPI' ) | (enumLiteral_58= 'INPJ' ) | (enumLiteral_59= 'INPK' ) | (enumLiteral_60= 'INPL' ) | (enumLiteral_61= 'OUT' ) | (enumLiteral_62= 'INAV' ) | (enumLiteral_63= 'INBV' ) | (enumLiteral_64= 'INCV' ) | (enumLiteral_65= 'INDV' ) | (enumLiteral_66= 'INEV' ) | (enumLiteral_67= 'INFV' ) | (enumLiteral_68= 'INGV' ) | (enumLiteral_69= 'INHV' ) | (enumLiteral_70= 'INIV' ) | (enumLiteral_71= 'INJV' ) | (enumLiteral_72= 'INKV' ) | (enumLiteral_73= 'INLV' ) | (enumLiteral_74= 'OOPT' ) | (enumLiteral_75= 'DLYA' ) | (enumLiteral_76= 'DOPT' ) | (enumLiteral_77= 'OCAL' ) | (enumLiteral_78= 'OCLV' ) | (enumLiteral_79= 'OEVT' ) | (enumLiteral_80= 'EPVT' ) | (enumLiteral_81= 'IVOA' ) | (enumLiteral_82= 'IVOV' ) | (enumLiteral_83= 'PREC' ) | (enumLiteral_84= 'HOPR' ) | (enumLiteral_85= 'LOPR' ) | (enumLiteral_86= 'HIHI' ) | (enumLiteral_87= 'LOLO' ) | (enumLiteral_88= 'HIGH' ) | (enumLiteral_89= 'LOW' ) | (enumLiteral_90= 'HHSV' ) | (enumLiteral_91= 'LLSV' ) | (enumLiteral_92= 'HSV' ) | (enumLiteral_93= 'LSV' ) | (enumLiteral_94= 'HYST' ) | (enumLiteral_95= 'ADEL' ) | (enumLiteral_96= 'MDEL' ) | (enumLiteral_97= 'A' ) | (enumLiteral_98= 'B' ) | (enumLiteral_99= 'C' ) | (enumLiteral_100= 'D' ) | (enumLiteral_101= 'E' ) | (enumLiteral_102= 'F' ) | (enumLiteral_103= 'G' ) | (enumLiteral_104= 'H' ) | (enumLiteral_105= 'I' ) | (enumLiteral_106= 'J' ) | (enumLiteral_107= 'K' ) | (enumLiteral_108= 'L' ) | (enumLiteral_109= 'OVAL' ) | (enumLiteral_110= 'LA' ) | (enumLiteral_111= 'LB' ) | (enumLiteral_112= 'LC' ) | (enumLiteral_113= 'LD' ) | (enumLiteral_114= 'LE' ) | (enumLiteral_115= 'LF' ) | (enumLiteral_116= 'LG' ) | (enumLiteral_117= 'LH' ) | (enumLiteral_118= 'LI' ) | (enumLiteral_119= 'LJ' ) | (enumLiteral_120= 'LK' ) | (enumLiteral_121= 'LL' ) | (enumLiteral_122= 'POVL' ) | (enumLiteral_123= 'LALM' ) | (enumLiteral_124= 'ALST' ) | (enumLiteral_125= 'MLST' ) | (enumLiteral_126= 'RPCL' ) | (enumLiteral_127= 'ORPC' ) )
            int alt10=128;
            switch ( input.LA(1) ) {
            case 262:
                {
                alt10=1;
                }
                break;
            case 263:
                {
                alt10=2;
                }
                break;
            case 264:
                {
                alt10=3;
                }
                break;
            case 265:
                {
                alt10=4;
                }
                break;
            case 266:
                {
                alt10=5;
                }
                break;
            case 267:
                {
                alt10=6;
                }
                break;
            case 268:
                {
                alt10=7;
                }
                break;
            case 269:
                {
                alt10=8;
                }
                break;
            case 270:
                {
                alt10=9;
                }
                break;
            case 271:
                {
                alt10=10;
                }
                break;
            case 272:
                {
                alt10=11;
                }
                break;
            case 273:
                {
                alt10=12;
                }
                break;
            case 26:
                {
                alt10=13;
                }
                break;
            case 274:
                {
                alt10=14;
                }
                break;
            case 275:
                {
                alt10=15;
                }
                break;
            case 276:
                {
                alt10=16;
                }
                break;
            case 277:
                {
                alt10=17;
                }
                break;
            case 278:
                {
                alt10=18;
                }
                break;
            case 279:
                {
                alt10=19;
                }
                break;
            case 280:
                {
                alt10=20;
                }
                break;
            case 281:
                {
                alt10=21;
                }
                break;
            case 282:
                {
                alt10=22;
                }
                break;
            case 283:
                {
                alt10=23;
                }
                break;
            case 284:
                {
                alt10=24;
                }
                break;
            case 285:
                {
                alt10=25;
                }
                break;
            case 286:
                {
                alt10=26;
                }
                break;
            case 287:
                {
                alt10=27;
                }
                break;
            case 288:
                {
                alt10=28;
                }
                break;
            case 289:
                {
                alt10=29;
                }
                break;
            case 290:
                {
                alt10=30;
                }
                break;
            case 291:
                {
                alt10=31;
                }
                break;
            case 292:
                {
                alt10=32;
                }
                break;
            case 293:
                {
                alt10=33;
                }
                break;
            case 294:
                {
                alt10=34;
                }
                break;
            case 295:
                {
                alt10=35;
                }
                break;
            case 296:
                {
                alt10=36;
                }
                break;
            case 297:
                {
                alt10=37;
                }
                break;
            case 298:
                {
                alt10=38;
                }
                break;
            case 299:
                {
                alt10=39;
                }
                break;
            case 300:
                {
                alt10=40;
                }
                break;
            case 301:
                {
                alt10=41;
                }
                break;
            case 302:
                {
                alt10=42;
                }
                break;
            case 303:
                {
                alt10=43;
                }
                break;
            case 304:
                {
                alt10=44;
                }
                break;
            case 305:
                {
                alt10=45;
                }
                break;
            case 306:
                {
                alt10=46;
                }
                break;
            case 307:
                {
                alt10=47;
                }
                break;
            case 308:
                {
                alt10=48;
                }
                break;
            case 309:
                {
                alt10=49;
                }
                break;
            case 310:
                {
                alt10=50;
                }
                break;
            case 311:
                {
                alt10=51;
                }
                break;
            case 312:
                {
                alt10=52;
                }
                break;
            case 313:
                {
                alt10=53;
                }
                break;
            case 314:
                {
                alt10=54;
                }
                break;
            case 315:
                {
                alt10=55;
                }
                break;
            case 316:
                {
                alt10=56;
                }
                break;
            case 317:
                {
                alt10=57;
                }
                break;
            case 318:
                {
                alt10=58;
                }
                break;
            case 319:
                {
                alt10=59;
                }
                break;
            case 320:
                {
                alt10=60;
                }
                break;
            case 321:
                {
                alt10=61;
                }
                break;
            case 322:
                {
                alt10=62;
                }
                break;
            case 323:
                {
                alt10=63;
                }
                break;
            case 324:
                {
                alt10=64;
                }
                break;
            case 325:
                {
                alt10=65;
                }
                break;
            case 326:
                {
                alt10=66;
                }
                break;
            case 327:
                {
                alt10=67;
                }
                break;
            case 328:
                {
                alt10=68;
                }
                break;
            case 329:
                {
                alt10=69;
                }
                break;
            case 330:
                {
                alt10=70;
                }
                break;
            case 331:
                {
                alt10=71;
                }
                break;
            case 332:
                {
                alt10=72;
                }
                break;
            case 333:
                {
                alt10=73;
                }
                break;
            case 334:
                {
                alt10=74;
                }
                break;
            case 335:
                {
                alt10=75;
                }
                break;
            case 336:
                {
                alt10=76;
                }
                break;
            case 337:
                {
                alt10=77;
                }
                break;
            case 338:
                {
                alt10=78;
                }
                break;
            case 339:
                {
                alt10=79;
                }
                break;
            case 340:
                {
                alt10=80;
                }
                break;
            case 341:
                {
                alt10=81;
                }
                break;
            case 342:
                {
                alt10=82;
                }
                break;
            case 343:
                {
                alt10=83;
                }
                break;
            case 344:
                {
                alt10=84;
                }
                break;
            case 345:
                {
                alt10=85;
                }
                break;
            case 346:
                {
                alt10=86;
                }
                break;
            case 347:
                {
                alt10=87;
                }
                break;
            case 348:
                {
                alt10=88;
                }
                break;
            case 349:
                {
                alt10=89;
                }
                break;
            case 350:
                {
                alt10=90;
                }
                break;
            case 351:
                {
                alt10=91;
                }
                break;
            case 352:
                {
                alt10=92;
                }
                break;
            case 353:
                {
                alt10=93;
                }
                break;
            case 354:
                {
                alt10=94;
                }
                break;
            case 355:
                {
                alt10=95;
                }
                break;
            case 356:
                {
                alt10=96;
                }
                break;
            case 357:
                {
                alt10=97;
                }
                break;
            case 358:
                {
                alt10=98;
                }
                break;
            case 359:
                {
                alt10=99;
                }
                break;
            case 360:
                {
                alt10=100;
                }
                break;
            case 361:
                {
                alt10=101;
                }
                break;
            case 362:
                {
                alt10=102;
                }
                break;
            case 363:
                {
                alt10=103;
                }
                break;
            case 364:
                {
                alt10=104;
                }
                break;
            case 365:
                {
                alt10=105;
                }
                break;
            case 366:
                {
                alt10=106;
                }
                break;
            case 367:
                {
                alt10=107;
                }
                break;
            case 368:
                {
                alt10=108;
                }
                break;
            case 369:
                {
                alt10=109;
                }
                break;
            case 370:
                {
                alt10=110;
                }
                break;
            case 371:
                {
                alt10=111;
                }
                break;
            case 372:
                {
                alt10=112;
                }
                break;
            case 373:
                {
                alt10=113;
                }
                break;
            case 374:
                {
                alt10=114;
                }
                break;
            case 375:
                {
                alt10=115;
                }
                break;
            case 376:
                {
                alt10=116;
                }
                break;
            case 377:
                {
                alt10=117;
                }
                break;
            case 378:
                {
                alt10=118;
                }
                break;
            case 379:
                {
                alt10=119;
                }
                break;
            case 380:
                {
                alt10=120;
                }
                break;
            case 381:
                {
                alt10=121;
                }
                break;
            case 382:
                {
                alt10=122;
                }
                break;
            case 383:
                {
                alt10=123;
                }
                break;
            case 384:
                {
                alt10=124;
                }
                break;
            case 385:
                {
                alt10=125;
                }
                break;
            case 386:
                {
                alt10=126;
                }
                break;
            case 387:
                {
                alt10=127;
                }
                break;
            case 388:
                {
                alt10=128;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalDbdTextEditor.g:2540:3: (enumLiteral_0= 'NAME' )
                    {
                    // InternalDbdTextEditor.g:2540:3: (enumLiteral_0= 'NAME' )
                    // InternalDbdTextEditor.g:2541:4: enumLiteral_0= 'NAME'
                    {
                    enumLiteral_0=(Token)match(input,262,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getNAMEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getFieldnamesAccess().getNAMEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDbdTextEditor.g:2548:3: (enumLiteral_1= 'DESC' )
                    {
                    // InternalDbdTextEditor.g:2548:3: (enumLiteral_1= 'DESC' )
                    // InternalDbdTextEditor.g:2549:4: enumLiteral_1= 'DESC'
                    {
                    enumLiteral_1=(Token)match(input,263,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getDESCEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getFieldnamesAccess().getDESCEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDbdTextEditor.g:2556:3: (enumLiteral_2= 'ASG' )
                    {
                    // InternalDbdTextEditor.g:2556:3: (enumLiteral_2= 'ASG' )
                    // InternalDbdTextEditor.g:2557:4: enumLiteral_2= 'ASG'
                    {
                    enumLiteral_2=(Token)match(input,264,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getASGEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getFieldnamesAccess().getASGEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDbdTextEditor.g:2564:3: (enumLiteral_3= 'SCAN' )
                    {
                    // InternalDbdTextEditor.g:2564:3: (enumLiteral_3= 'SCAN' )
                    // InternalDbdTextEditor.g:2565:4: enumLiteral_3= 'SCAN'
                    {
                    enumLiteral_3=(Token)match(input,265,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSCANEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getFieldnamesAccess().getSCANEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDbdTextEditor.g:2572:3: (enumLiteral_4= 'PINI' )
                    {
                    // InternalDbdTextEditor.g:2572:3: (enumLiteral_4= 'PINI' )
                    // InternalDbdTextEditor.g:2573:4: enumLiteral_4= 'PINI'
                    {
                    enumLiteral_4=(Token)match(input,266,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getPINIEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getFieldnamesAccess().getPINIEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalDbdTextEditor.g:2580:3: (enumLiteral_5= 'PHAS' )
                    {
                    // InternalDbdTextEditor.g:2580:3: (enumLiteral_5= 'PHAS' )
                    // InternalDbdTextEditor.g:2581:4: enumLiteral_5= 'PHAS'
                    {
                    enumLiteral_5=(Token)match(input,267,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getPHASEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getFieldnamesAccess().getPHASEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalDbdTextEditor.g:2588:3: (enumLiteral_6= 'EVNT' )
                    {
                    // InternalDbdTextEditor.g:2588:3: (enumLiteral_6= 'EVNT' )
                    // InternalDbdTextEditor.g:2589:4: enumLiteral_6= 'EVNT'
                    {
                    enumLiteral_6=(Token)match(input,268,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getEVNTEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getFieldnamesAccess().getEVNTEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalDbdTextEditor.g:2596:3: (enumLiteral_7= 'TSE' )
                    {
                    // InternalDbdTextEditor.g:2596:3: (enumLiteral_7= 'TSE' )
                    // InternalDbdTextEditor.g:2597:4: enumLiteral_7= 'TSE'
                    {
                    enumLiteral_7=(Token)match(input,269,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getTSEEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getFieldnamesAccess().getTSEEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalDbdTextEditor.g:2604:3: (enumLiteral_8= 'TSEL' )
                    {
                    // InternalDbdTextEditor.g:2604:3: (enumLiteral_8= 'TSEL' )
                    // InternalDbdTextEditor.g:2605:4: enumLiteral_8= 'TSEL'
                    {
                    enumLiteral_8=(Token)match(input,270,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getTSELEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getFieldnamesAccess().getTSELEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalDbdTextEditor.g:2612:3: (enumLiteral_9= 'DTYP' )
                    {
                    // InternalDbdTextEditor.g:2612:3: (enumLiteral_9= 'DTYP' )
                    // InternalDbdTextEditor.g:2613:4: enumLiteral_9= 'DTYP'
                    {
                    enumLiteral_9=(Token)match(input,271,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getDTYPEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getFieldnamesAccess().getDTYPEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalDbdTextEditor.g:2620:3: (enumLiteral_10= 'DISV' )
                    {
                    // InternalDbdTextEditor.g:2620:3: (enumLiteral_10= 'DISV' )
                    // InternalDbdTextEditor.g:2621:4: enumLiteral_10= 'DISV'
                    {
                    enumLiteral_10=(Token)match(input,272,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getDISVEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getFieldnamesAccess().getDISVEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalDbdTextEditor.g:2628:3: (enumLiteral_11= 'DISA' )
                    {
                    // InternalDbdTextEditor.g:2628:3: (enumLiteral_11= 'DISA' )
                    // InternalDbdTextEditor.g:2629:4: enumLiteral_11= 'DISA'
                    {
                    enumLiteral_11=(Token)match(input,273,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getDISAEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getFieldnamesAccess().getDISAEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalDbdTextEditor.g:2636:3: (enumLiteral_12= 'SDIS' )
                    {
                    // InternalDbdTextEditor.g:2636:3: (enumLiteral_12= 'SDIS' )
                    // InternalDbdTextEditor.g:2637:4: enumLiteral_12= 'SDIS'
                    {
                    enumLiteral_12=(Token)match(input,26,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSDISEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getFieldnamesAccess().getSDISEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalDbdTextEditor.g:2644:3: (enumLiteral_13= 'MLOK' )
                    {
                    // InternalDbdTextEditor.g:2644:3: (enumLiteral_13= 'MLOK' )
                    // InternalDbdTextEditor.g:2645:4: enumLiteral_13= 'MLOK'
                    {
                    enumLiteral_13=(Token)match(input,274,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getMLOKEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getFieldnamesAccess().getMLOKEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalDbdTextEditor.g:2652:3: (enumLiteral_14= 'MLIS' )
                    {
                    // InternalDbdTextEditor.g:2652:3: (enumLiteral_14= 'MLIS' )
                    // InternalDbdTextEditor.g:2653:4: enumLiteral_14= 'MLIS'
                    {
                    enumLiteral_14=(Token)match(input,275,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getMLISEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getFieldnamesAccess().getMLISEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalDbdTextEditor.g:2660:3: (enumLiteral_15= 'BKLNK' )
                    {
                    // InternalDbdTextEditor.g:2660:3: (enumLiteral_15= 'BKLNK' )
                    // InternalDbdTextEditor.g:2661:4: enumLiteral_15= 'BKLNK'
                    {
                    enumLiteral_15=(Token)match(input,276,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getBKLNKEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getFieldnamesAccess().getBKLNKEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalDbdTextEditor.g:2668:3: (enumLiteral_16= 'DISP' )
                    {
                    // InternalDbdTextEditor.g:2668:3: (enumLiteral_16= 'DISP' )
                    // InternalDbdTextEditor.g:2669:4: enumLiteral_16= 'DISP'
                    {
                    enumLiteral_16=(Token)match(input,277,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getDISPEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getFieldnamesAccess().getDISPEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalDbdTextEditor.g:2676:3: (enumLiteral_17= 'PROC' )
                    {
                    // InternalDbdTextEditor.g:2676:3: (enumLiteral_17= 'PROC' )
                    // InternalDbdTextEditor.g:2677:4: enumLiteral_17= 'PROC'
                    {
                    enumLiteral_17=(Token)match(input,278,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getPROCEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getFieldnamesAccess().getPROCEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalDbdTextEditor.g:2684:3: (enumLiteral_18= 'STAT' )
                    {
                    // InternalDbdTextEditor.g:2684:3: (enumLiteral_18= 'STAT' )
                    // InternalDbdTextEditor.g:2685:4: enumLiteral_18= 'STAT'
                    {
                    enumLiteral_18=(Token)match(input,279,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSTATEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getFieldnamesAccess().getSTATEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalDbdTextEditor.g:2692:3: (enumLiteral_19= 'SEVR' )
                    {
                    // InternalDbdTextEditor.g:2692:3: (enumLiteral_19= 'SEVR' )
                    // InternalDbdTextEditor.g:2693:4: enumLiteral_19= 'SEVR'
                    {
                    enumLiteral_19=(Token)match(input,280,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSEVREnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getFieldnamesAccess().getSEVREnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalDbdTextEditor.g:2700:3: (enumLiteral_20= 'NSTA' )
                    {
                    // InternalDbdTextEditor.g:2700:3: (enumLiteral_20= 'NSTA' )
                    // InternalDbdTextEditor.g:2701:4: enumLiteral_20= 'NSTA'
                    {
                    enumLiteral_20=(Token)match(input,281,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getNSTAEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getFieldnamesAccess().getNSTAEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalDbdTextEditor.g:2708:3: (enumLiteral_21= 'NSEV' )
                    {
                    // InternalDbdTextEditor.g:2708:3: (enumLiteral_21= 'NSEV' )
                    // InternalDbdTextEditor.g:2709:4: enumLiteral_21= 'NSEV'
                    {
                    enumLiteral_21=(Token)match(input,282,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getNSEVEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getFieldnamesAccess().getNSEVEnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalDbdTextEditor.g:2716:3: (enumLiteral_22= 'ACKS' )
                    {
                    // InternalDbdTextEditor.g:2716:3: (enumLiteral_22= 'ACKS' )
                    // InternalDbdTextEditor.g:2717:4: enumLiteral_22= 'ACKS'
                    {
                    enumLiteral_22=(Token)match(input,283,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getACKSEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getFieldnamesAccess().getACKSEnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalDbdTextEditor.g:2724:3: (enumLiteral_23= 'ACKT' )
                    {
                    // InternalDbdTextEditor.g:2724:3: (enumLiteral_23= 'ACKT' )
                    // InternalDbdTextEditor.g:2725:4: enumLiteral_23= 'ACKT'
                    {
                    enumLiteral_23=(Token)match(input,284,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getACKTEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getFieldnamesAccess().getACKTEnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalDbdTextEditor.g:2732:3: (enumLiteral_24= 'DISS' )
                    {
                    // InternalDbdTextEditor.g:2732:3: (enumLiteral_24= 'DISS' )
                    // InternalDbdTextEditor.g:2733:4: enumLiteral_24= 'DISS'
                    {
                    enumLiteral_24=(Token)match(input,285,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getDISSEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getFieldnamesAccess().getDISSEnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalDbdTextEditor.g:2740:3: (enumLiteral_25= 'PACT' )
                    {
                    // InternalDbdTextEditor.g:2740:3: (enumLiteral_25= 'PACT' )
                    // InternalDbdTextEditor.g:2741:4: enumLiteral_25= 'PACT'
                    {
                    enumLiteral_25=(Token)match(input,286,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getPACTEnumLiteralDeclaration_25().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_25, grammarAccess.getFieldnamesAccess().getPACTEnumLiteralDeclaration_25());
                    			

                    }


                    }
                    break;
                case 27 :
                    // InternalDbdTextEditor.g:2748:3: (enumLiteral_26= 'PUTF' )
                    {
                    // InternalDbdTextEditor.g:2748:3: (enumLiteral_26= 'PUTF' )
                    // InternalDbdTextEditor.g:2749:4: enumLiteral_26= 'PUTF'
                    {
                    enumLiteral_26=(Token)match(input,287,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getPUTFEnumLiteralDeclaration_26().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_26, grammarAccess.getFieldnamesAccess().getPUTFEnumLiteralDeclaration_26());
                    			

                    }


                    }
                    break;
                case 28 :
                    // InternalDbdTextEditor.g:2756:3: (enumLiteral_27= 'RPRO' )
                    {
                    // InternalDbdTextEditor.g:2756:3: (enumLiteral_27= 'RPRO' )
                    // InternalDbdTextEditor.g:2757:4: enumLiteral_27= 'RPRO'
                    {
                    enumLiteral_27=(Token)match(input,288,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getRPROEnumLiteralDeclaration_27().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_27, grammarAccess.getFieldnamesAccess().getRPROEnumLiteralDeclaration_27());
                    			

                    }


                    }
                    break;
                case 29 :
                    // InternalDbdTextEditor.g:2764:3: (enumLiteral_28= 'ASP' )
                    {
                    // InternalDbdTextEditor.g:2764:3: (enumLiteral_28= 'ASP' )
                    // InternalDbdTextEditor.g:2765:4: enumLiteral_28= 'ASP'
                    {
                    enumLiteral_28=(Token)match(input,289,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getASPEnumLiteralDeclaration_28().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_28, grammarAccess.getFieldnamesAccess().getASPEnumLiteralDeclaration_28());
                    			

                    }


                    }
                    break;
                case 30 :
                    // InternalDbdTextEditor.g:2772:3: (enumLiteral_29= 'PPN' )
                    {
                    // InternalDbdTextEditor.g:2772:3: (enumLiteral_29= 'PPN' )
                    // InternalDbdTextEditor.g:2773:4: enumLiteral_29= 'PPN'
                    {
                    enumLiteral_29=(Token)match(input,290,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getPPNEnumLiteralDeclaration_29().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_29, grammarAccess.getFieldnamesAccess().getPPNEnumLiteralDeclaration_29());
                    			

                    }


                    }
                    break;
                case 31 :
                    // InternalDbdTextEditor.g:2780:3: (enumLiteral_30= 'PPNR' )
                    {
                    // InternalDbdTextEditor.g:2780:3: (enumLiteral_30= 'PPNR' )
                    // InternalDbdTextEditor.g:2781:4: enumLiteral_30= 'PPNR'
                    {
                    enumLiteral_30=(Token)match(input,291,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getPPNREnumLiteralDeclaration_30().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_30, grammarAccess.getFieldnamesAccess().getPPNREnumLiteralDeclaration_30());
                    			

                    }


                    }
                    break;
                case 32 :
                    // InternalDbdTextEditor.g:2788:3: (enumLiteral_31= 'SPVT' )
                    {
                    // InternalDbdTextEditor.g:2788:3: (enumLiteral_31= 'SPVT' )
                    // InternalDbdTextEditor.g:2789:4: enumLiteral_31= 'SPVT'
                    {
                    enumLiteral_31=(Token)match(input,292,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getSPVTEnumLiteralDeclaration_31().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_31, grammarAccess.getFieldnamesAccess().getSPVTEnumLiteralDeclaration_31());
                    			

                    }


                    }
                    break;
                case 33 :
                    // InternalDbdTextEditor.g:2796:3: (enumLiteral_32= 'RSET' )
                    {
                    // InternalDbdTextEditor.g:2796:3: (enumLiteral_32= 'RSET' )
                    // InternalDbdTextEditor.g:2797:4: enumLiteral_32= 'RSET'
                    {
                    enumLiteral_32=(Token)match(input,293,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getRSETEnumLiteralDeclaration_32().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_32, grammarAccess.getFieldnamesAccess().getRSETEnumLiteralDeclaration_32());
                    			

                    }


                    }
                    break;
                case 34 :
                    // InternalDbdTextEditor.g:2804:3: (enumLiteral_33= 'DSET' )
                    {
                    // InternalDbdTextEditor.g:2804:3: (enumLiteral_33= 'DSET' )
                    // InternalDbdTextEditor.g:2805:4: enumLiteral_33= 'DSET'
                    {
                    enumLiteral_33=(Token)match(input,294,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getDSETEnumLiteralDeclaration_33().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_33, grammarAccess.getFieldnamesAccess().getDSETEnumLiteralDeclaration_33());
                    			

                    }


                    }
                    break;
                case 35 :
                    // InternalDbdTextEditor.g:2812:3: (enumLiteral_34= 'DPVT' )
                    {
                    // InternalDbdTextEditor.g:2812:3: (enumLiteral_34= 'DPVT' )
                    // InternalDbdTextEditor.g:2813:4: enumLiteral_34= 'DPVT'
                    {
                    enumLiteral_34=(Token)match(input,295,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getDPVTEnumLiteralDeclaration_34().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_34, grammarAccess.getFieldnamesAccess().getDPVTEnumLiteralDeclaration_34());
                    			

                    }


                    }
                    break;
                case 36 :
                    // InternalDbdTextEditor.g:2820:3: (enumLiteral_35= 'RDES' )
                    {
                    // InternalDbdTextEditor.g:2820:3: (enumLiteral_35= 'RDES' )
                    // InternalDbdTextEditor.g:2821:4: enumLiteral_35= 'RDES'
                    {
                    enumLiteral_35=(Token)match(input,296,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getRDESEnumLiteralDeclaration_35().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_35, grammarAccess.getFieldnamesAccess().getRDESEnumLiteralDeclaration_35());
                    			

                    }


                    }
                    break;
                case 37 :
                    // InternalDbdTextEditor.g:2828:3: (enumLiteral_36= 'LSET' )
                    {
                    // InternalDbdTextEditor.g:2828:3: (enumLiteral_36= 'LSET' )
                    // InternalDbdTextEditor.g:2829:4: enumLiteral_36= 'LSET'
                    {
                    enumLiteral_36=(Token)match(input,297,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLSETEnumLiteralDeclaration_36().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_36, grammarAccess.getFieldnamesAccess().getLSETEnumLiteralDeclaration_36());
                    			

                    }


                    }
                    break;
                case 38 :
                    // InternalDbdTextEditor.g:2836:3: (enumLiteral_37= 'PRIO' )
                    {
                    // InternalDbdTextEditor.g:2836:3: (enumLiteral_37= 'PRIO' )
                    // InternalDbdTextEditor.g:2837:4: enumLiteral_37= 'PRIO'
                    {
                    enumLiteral_37=(Token)match(input,298,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getPRIOEnumLiteralDeclaration_37().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_37, grammarAccess.getFieldnamesAccess().getPRIOEnumLiteralDeclaration_37());
                    			

                    }


                    }
                    break;
                case 39 :
                    // InternalDbdTextEditor.g:2844:3: (enumLiteral_38= 'TPRO' )
                    {
                    // InternalDbdTextEditor.g:2844:3: (enumLiteral_38= 'TPRO' )
                    // InternalDbdTextEditor.g:2845:4: enumLiteral_38= 'TPRO'
                    {
                    enumLiteral_38=(Token)match(input,299,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getTPROEnumLiteralDeclaration_38().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_38, grammarAccess.getFieldnamesAccess().getTPROEnumLiteralDeclaration_38());
                    			

                    }


                    }
                    break;
                case 40 :
                    // InternalDbdTextEditor.g:2852:3: (enumLiteral_39= 'BKPT' )
                    {
                    // InternalDbdTextEditor.g:2852:3: (enumLiteral_39= 'BKPT' )
                    // InternalDbdTextEditor.g:2853:4: enumLiteral_39= 'BKPT'
                    {
                    enumLiteral_39=(Token)match(input,300,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getBKPTEnumLiteralDeclaration_39().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_39, grammarAccess.getFieldnamesAccess().getBKPTEnumLiteralDeclaration_39());
                    			

                    }


                    }
                    break;
                case 41 :
                    // InternalDbdTextEditor.g:2860:3: (enumLiteral_40= 'UDF' )
                    {
                    // InternalDbdTextEditor.g:2860:3: (enumLiteral_40= 'UDF' )
                    // InternalDbdTextEditor.g:2861:4: enumLiteral_40= 'UDF'
                    {
                    enumLiteral_40=(Token)match(input,301,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getUDFEnumLiteralDeclaration_40().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_40, grammarAccess.getFieldnamesAccess().getUDFEnumLiteralDeclaration_40());
                    			

                    }


                    }
                    break;
                case 42 :
                    // InternalDbdTextEditor.g:2868:3: (enumLiteral_41= 'UDFS' )
                    {
                    // InternalDbdTextEditor.g:2868:3: (enumLiteral_41= 'UDFS' )
                    // InternalDbdTextEditor.g:2869:4: enumLiteral_41= 'UDFS'
                    {
                    enumLiteral_41=(Token)match(input,302,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getUDFSEnumLiteralDeclaration_41().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_41, grammarAccess.getFieldnamesAccess().getUDFSEnumLiteralDeclaration_41());
                    			

                    }


                    }
                    break;
                case 43 :
                    // InternalDbdTextEditor.g:2876:3: (enumLiteral_42= 'TIME' )
                    {
                    // InternalDbdTextEditor.g:2876:3: (enumLiteral_42= 'TIME' )
                    // InternalDbdTextEditor.g:2877:4: enumLiteral_42= 'TIME'
                    {
                    enumLiteral_42=(Token)match(input,303,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getTIMEEnumLiteralDeclaration_42().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_42, grammarAccess.getFieldnamesAccess().getTIMEEnumLiteralDeclaration_42());
                    			

                    }


                    }
                    break;
                case 44 :
                    // InternalDbdTextEditor.g:2884:3: (enumLiteral_43= 'FLNK' )
                    {
                    // InternalDbdTextEditor.g:2884:3: (enumLiteral_43= 'FLNK' )
                    // InternalDbdTextEditor.g:2885:4: enumLiteral_43= 'FLNK'
                    {
                    enumLiteral_43=(Token)match(input,304,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getFLNKEnumLiteralDeclaration_43().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_43, grammarAccess.getFieldnamesAccess().getFLNKEnumLiteralDeclaration_43());
                    			

                    }


                    }
                    break;
                case 45 :
                    // InternalDbdTextEditor.g:2892:3: (enumLiteral_44= 'RPVT' )
                    {
                    // InternalDbdTextEditor.g:2892:3: (enumLiteral_44= 'RPVT' )
                    // InternalDbdTextEditor.g:2893:4: enumLiteral_44= 'RPVT'
                    {
                    enumLiteral_44=(Token)match(input,305,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getRPVTEnumLiteralDeclaration_44().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_44, grammarAccess.getFieldnamesAccess().getRPVTEnumLiteralDeclaration_44());
                    			

                    }


                    }
                    break;
                case 46 :
                    // InternalDbdTextEditor.g:2900:3: (enumLiteral_45= 'VAL' )
                    {
                    // InternalDbdTextEditor.g:2900:3: (enumLiteral_45= 'VAL' )
                    // InternalDbdTextEditor.g:2901:4: enumLiteral_45= 'VAL'
                    {
                    enumLiteral_45=(Token)match(input,306,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getVALEnumLiteralDeclaration_45().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_45, grammarAccess.getFieldnamesAccess().getVALEnumLiteralDeclaration_45());
                    			

                    }


                    }
                    break;
                case 47 :
                    // InternalDbdTextEditor.g:2908:3: (enumLiteral_46= 'PVAL' )
                    {
                    // InternalDbdTextEditor.g:2908:3: (enumLiteral_46= 'PVAL' )
                    // InternalDbdTextEditor.g:2909:4: enumLiteral_46= 'PVAL'
                    {
                    enumLiteral_46=(Token)match(input,307,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getPVALEnumLiteralDeclaration_46().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_46, grammarAccess.getFieldnamesAccess().getPVALEnumLiteralDeclaration_46());
                    			

                    }


                    }
                    break;
                case 48 :
                    // InternalDbdTextEditor.g:2916:3: (enumLiteral_47= 'CALC' )
                    {
                    // InternalDbdTextEditor.g:2916:3: (enumLiteral_47= 'CALC' )
                    // InternalDbdTextEditor.g:2917:4: enumLiteral_47= 'CALC'
                    {
                    enumLiteral_47=(Token)match(input,308,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getCALCEnumLiteralDeclaration_47().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_47, grammarAccess.getFieldnamesAccess().getCALCEnumLiteralDeclaration_47());
                    			

                    }


                    }
                    break;
                case 49 :
                    // InternalDbdTextEditor.g:2924:3: (enumLiteral_48= 'CLCV' )
                    {
                    // InternalDbdTextEditor.g:2924:3: (enumLiteral_48= 'CLCV' )
                    // InternalDbdTextEditor.g:2925:4: enumLiteral_48= 'CLCV'
                    {
                    enumLiteral_48=(Token)match(input,309,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getCLCVEnumLiteralDeclaration_48().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_48, grammarAccess.getFieldnamesAccess().getCLCVEnumLiteralDeclaration_48());
                    			

                    }


                    }
                    break;
                case 50 :
                    // InternalDbdTextEditor.g:2932:3: (enumLiteral_49= 'INPA' )
                    {
                    // InternalDbdTextEditor.g:2932:3: (enumLiteral_49= 'INPA' )
                    // InternalDbdTextEditor.g:2933:4: enumLiteral_49= 'INPA'
                    {
                    enumLiteral_49=(Token)match(input,310,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPAEnumLiteralDeclaration_49().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_49, grammarAccess.getFieldnamesAccess().getINPAEnumLiteralDeclaration_49());
                    			

                    }


                    }
                    break;
                case 51 :
                    // InternalDbdTextEditor.g:2940:3: (enumLiteral_50= 'INPB' )
                    {
                    // InternalDbdTextEditor.g:2940:3: (enumLiteral_50= 'INPB' )
                    // InternalDbdTextEditor.g:2941:4: enumLiteral_50= 'INPB'
                    {
                    enumLiteral_50=(Token)match(input,311,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPBEnumLiteralDeclaration_50().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_50, grammarAccess.getFieldnamesAccess().getINPBEnumLiteralDeclaration_50());
                    			

                    }


                    }
                    break;
                case 52 :
                    // InternalDbdTextEditor.g:2948:3: (enumLiteral_51= 'INPC' )
                    {
                    // InternalDbdTextEditor.g:2948:3: (enumLiteral_51= 'INPC' )
                    // InternalDbdTextEditor.g:2949:4: enumLiteral_51= 'INPC'
                    {
                    enumLiteral_51=(Token)match(input,312,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPCEnumLiteralDeclaration_51().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_51, grammarAccess.getFieldnamesAccess().getINPCEnumLiteralDeclaration_51());
                    			

                    }


                    }
                    break;
                case 53 :
                    // InternalDbdTextEditor.g:2956:3: (enumLiteral_52= 'INPD' )
                    {
                    // InternalDbdTextEditor.g:2956:3: (enumLiteral_52= 'INPD' )
                    // InternalDbdTextEditor.g:2957:4: enumLiteral_52= 'INPD'
                    {
                    enumLiteral_52=(Token)match(input,313,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPDEnumLiteralDeclaration_52().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_52, grammarAccess.getFieldnamesAccess().getINPDEnumLiteralDeclaration_52());
                    			

                    }


                    }
                    break;
                case 54 :
                    // InternalDbdTextEditor.g:2964:3: (enumLiteral_53= 'INPE' )
                    {
                    // InternalDbdTextEditor.g:2964:3: (enumLiteral_53= 'INPE' )
                    // InternalDbdTextEditor.g:2965:4: enumLiteral_53= 'INPE'
                    {
                    enumLiteral_53=(Token)match(input,314,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPEEnumLiteralDeclaration_53().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_53, grammarAccess.getFieldnamesAccess().getINPEEnumLiteralDeclaration_53());
                    			

                    }


                    }
                    break;
                case 55 :
                    // InternalDbdTextEditor.g:2972:3: (enumLiteral_54= 'INPF' )
                    {
                    // InternalDbdTextEditor.g:2972:3: (enumLiteral_54= 'INPF' )
                    // InternalDbdTextEditor.g:2973:4: enumLiteral_54= 'INPF'
                    {
                    enumLiteral_54=(Token)match(input,315,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPFEnumLiteralDeclaration_54().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_54, grammarAccess.getFieldnamesAccess().getINPFEnumLiteralDeclaration_54());
                    			

                    }


                    }
                    break;
                case 56 :
                    // InternalDbdTextEditor.g:2980:3: (enumLiteral_55= 'INPG' )
                    {
                    // InternalDbdTextEditor.g:2980:3: (enumLiteral_55= 'INPG' )
                    // InternalDbdTextEditor.g:2981:4: enumLiteral_55= 'INPG'
                    {
                    enumLiteral_55=(Token)match(input,316,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPGEnumLiteralDeclaration_55().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_55, grammarAccess.getFieldnamesAccess().getINPGEnumLiteralDeclaration_55());
                    			

                    }


                    }
                    break;
                case 57 :
                    // InternalDbdTextEditor.g:2988:3: (enumLiteral_56= 'INPH' )
                    {
                    // InternalDbdTextEditor.g:2988:3: (enumLiteral_56= 'INPH' )
                    // InternalDbdTextEditor.g:2989:4: enumLiteral_56= 'INPH'
                    {
                    enumLiteral_56=(Token)match(input,317,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPHEnumLiteralDeclaration_56().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_56, grammarAccess.getFieldnamesAccess().getINPHEnumLiteralDeclaration_56());
                    			

                    }


                    }
                    break;
                case 58 :
                    // InternalDbdTextEditor.g:2996:3: (enumLiteral_57= 'INPI' )
                    {
                    // InternalDbdTextEditor.g:2996:3: (enumLiteral_57= 'INPI' )
                    // InternalDbdTextEditor.g:2997:4: enumLiteral_57= 'INPI'
                    {
                    enumLiteral_57=(Token)match(input,318,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPIEnumLiteralDeclaration_57().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_57, grammarAccess.getFieldnamesAccess().getINPIEnumLiteralDeclaration_57());
                    			

                    }


                    }
                    break;
                case 59 :
                    // InternalDbdTextEditor.g:3004:3: (enumLiteral_58= 'INPJ' )
                    {
                    // InternalDbdTextEditor.g:3004:3: (enumLiteral_58= 'INPJ' )
                    // InternalDbdTextEditor.g:3005:4: enumLiteral_58= 'INPJ'
                    {
                    enumLiteral_58=(Token)match(input,319,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPJEnumLiteralDeclaration_58().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_58, grammarAccess.getFieldnamesAccess().getINPJEnumLiteralDeclaration_58());
                    			

                    }


                    }
                    break;
                case 60 :
                    // InternalDbdTextEditor.g:3012:3: (enumLiteral_59= 'INPK' )
                    {
                    // InternalDbdTextEditor.g:3012:3: (enumLiteral_59= 'INPK' )
                    // InternalDbdTextEditor.g:3013:4: enumLiteral_59= 'INPK'
                    {
                    enumLiteral_59=(Token)match(input,320,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPKEnumLiteralDeclaration_59().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_59, grammarAccess.getFieldnamesAccess().getINPKEnumLiteralDeclaration_59());
                    			

                    }


                    }
                    break;
                case 61 :
                    // InternalDbdTextEditor.g:3020:3: (enumLiteral_60= 'INPL' )
                    {
                    // InternalDbdTextEditor.g:3020:3: (enumLiteral_60= 'INPL' )
                    // InternalDbdTextEditor.g:3021:4: enumLiteral_60= 'INPL'
                    {
                    enumLiteral_60=(Token)match(input,321,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINPLEnumLiteralDeclaration_60().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_60, grammarAccess.getFieldnamesAccess().getINPLEnumLiteralDeclaration_60());
                    			

                    }


                    }
                    break;
                case 62 :
                    // InternalDbdTextEditor.g:3028:3: (enumLiteral_61= 'OUT' )
                    {
                    // InternalDbdTextEditor.g:3028:3: (enumLiteral_61= 'OUT' )
                    // InternalDbdTextEditor.g:3029:4: enumLiteral_61= 'OUT'
                    {
                    enumLiteral_61=(Token)match(input,322,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getOUTEnumLiteralDeclaration_61().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_61, grammarAccess.getFieldnamesAccess().getOUTEnumLiteralDeclaration_61());
                    			

                    }


                    }
                    break;
                case 63 :
                    // InternalDbdTextEditor.g:3036:3: (enumLiteral_62= 'INAV' )
                    {
                    // InternalDbdTextEditor.g:3036:3: (enumLiteral_62= 'INAV' )
                    // InternalDbdTextEditor.g:3037:4: enumLiteral_62= 'INAV'
                    {
                    enumLiteral_62=(Token)match(input,323,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINAVEnumLiteralDeclaration_62().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_62, grammarAccess.getFieldnamesAccess().getINAVEnumLiteralDeclaration_62());
                    			

                    }


                    }
                    break;
                case 64 :
                    // InternalDbdTextEditor.g:3044:3: (enumLiteral_63= 'INBV' )
                    {
                    // InternalDbdTextEditor.g:3044:3: (enumLiteral_63= 'INBV' )
                    // InternalDbdTextEditor.g:3045:4: enumLiteral_63= 'INBV'
                    {
                    enumLiteral_63=(Token)match(input,324,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINBVEnumLiteralDeclaration_63().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_63, grammarAccess.getFieldnamesAccess().getINBVEnumLiteralDeclaration_63());
                    			

                    }


                    }
                    break;
                case 65 :
                    // InternalDbdTextEditor.g:3052:3: (enumLiteral_64= 'INCV' )
                    {
                    // InternalDbdTextEditor.g:3052:3: (enumLiteral_64= 'INCV' )
                    // InternalDbdTextEditor.g:3053:4: enumLiteral_64= 'INCV'
                    {
                    enumLiteral_64=(Token)match(input,325,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINCVEnumLiteralDeclaration_64().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_64, grammarAccess.getFieldnamesAccess().getINCVEnumLiteralDeclaration_64());
                    			

                    }


                    }
                    break;
                case 66 :
                    // InternalDbdTextEditor.g:3060:3: (enumLiteral_65= 'INDV' )
                    {
                    // InternalDbdTextEditor.g:3060:3: (enumLiteral_65= 'INDV' )
                    // InternalDbdTextEditor.g:3061:4: enumLiteral_65= 'INDV'
                    {
                    enumLiteral_65=(Token)match(input,326,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINDVEnumLiteralDeclaration_65().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_65, grammarAccess.getFieldnamesAccess().getINDVEnumLiteralDeclaration_65());
                    			

                    }


                    }
                    break;
                case 67 :
                    // InternalDbdTextEditor.g:3068:3: (enumLiteral_66= 'INEV' )
                    {
                    // InternalDbdTextEditor.g:3068:3: (enumLiteral_66= 'INEV' )
                    // InternalDbdTextEditor.g:3069:4: enumLiteral_66= 'INEV'
                    {
                    enumLiteral_66=(Token)match(input,327,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINEVEnumLiteralDeclaration_66().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_66, grammarAccess.getFieldnamesAccess().getINEVEnumLiteralDeclaration_66());
                    			

                    }


                    }
                    break;
                case 68 :
                    // InternalDbdTextEditor.g:3076:3: (enumLiteral_67= 'INFV' )
                    {
                    // InternalDbdTextEditor.g:3076:3: (enumLiteral_67= 'INFV' )
                    // InternalDbdTextEditor.g:3077:4: enumLiteral_67= 'INFV'
                    {
                    enumLiteral_67=(Token)match(input,328,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINFVEnumLiteralDeclaration_67().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_67, grammarAccess.getFieldnamesAccess().getINFVEnumLiteralDeclaration_67());
                    			

                    }


                    }
                    break;
                case 69 :
                    // InternalDbdTextEditor.g:3084:3: (enumLiteral_68= 'INGV' )
                    {
                    // InternalDbdTextEditor.g:3084:3: (enumLiteral_68= 'INGV' )
                    // InternalDbdTextEditor.g:3085:4: enumLiteral_68= 'INGV'
                    {
                    enumLiteral_68=(Token)match(input,329,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINGVEnumLiteralDeclaration_68().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_68, grammarAccess.getFieldnamesAccess().getINGVEnumLiteralDeclaration_68());
                    			

                    }


                    }
                    break;
                case 70 :
                    // InternalDbdTextEditor.g:3092:3: (enumLiteral_69= 'INHV' )
                    {
                    // InternalDbdTextEditor.g:3092:3: (enumLiteral_69= 'INHV' )
                    // InternalDbdTextEditor.g:3093:4: enumLiteral_69= 'INHV'
                    {
                    enumLiteral_69=(Token)match(input,330,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINHVEnumLiteralDeclaration_69().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_69, grammarAccess.getFieldnamesAccess().getINHVEnumLiteralDeclaration_69());
                    			

                    }


                    }
                    break;
                case 71 :
                    // InternalDbdTextEditor.g:3100:3: (enumLiteral_70= 'INIV' )
                    {
                    // InternalDbdTextEditor.g:3100:3: (enumLiteral_70= 'INIV' )
                    // InternalDbdTextEditor.g:3101:4: enumLiteral_70= 'INIV'
                    {
                    enumLiteral_70=(Token)match(input,331,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINIVEnumLiteralDeclaration_70().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_70, grammarAccess.getFieldnamesAccess().getINIVEnumLiteralDeclaration_70());
                    			

                    }


                    }
                    break;
                case 72 :
                    // InternalDbdTextEditor.g:3108:3: (enumLiteral_71= 'INJV' )
                    {
                    // InternalDbdTextEditor.g:3108:3: (enumLiteral_71= 'INJV' )
                    // InternalDbdTextEditor.g:3109:4: enumLiteral_71= 'INJV'
                    {
                    enumLiteral_71=(Token)match(input,332,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINJVEnumLiteralDeclaration_71().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_71, grammarAccess.getFieldnamesAccess().getINJVEnumLiteralDeclaration_71());
                    			

                    }


                    }
                    break;
                case 73 :
                    // InternalDbdTextEditor.g:3116:3: (enumLiteral_72= 'INKV' )
                    {
                    // InternalDbdTextEditor.g:3116:3: (enumLiteral_72= 'INKV' )
                    // InternalDbdTextEditor.g:3117:4: enumLiteral_72= 'INKV'
                    {
                    enumLiteral_72=(Token)match(input,333,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINKVEnumLiteralDeclaration_72().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_72, grammarAccess.getFieldnamesAccess().getINKVEnumLiteralDeclaration_72());
                    			

                    }


                    }
                    break;
                case 74 :
                    // InternalDbdTextEditor.g:3124:3: (enumLiteral_73= 'INLV' )
                    {
                    // InternalDbdTextEditor.g:3124:3: (enumLiteral_73= 'INLV' )
                    // InternalDbdTextEditor.g:3125:4: enumLiteral_73= 'INLV'
                    {
                    enumLiteral_73=(Token)match(input,334,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getINLVEnumLiteralDeclaration_73().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_73, grammarAccess.getFieldnamesAccess().getINLVEnumLiteralDeclaration_73());
                    			

                    }


                    }
                    break;
                case 75 :
                    // InternalDbdTextEditor.g:3132:3: (enumLiteral_74= 'OOPT' )
                    {
                    // InternalDbdTextEditor.g:3132:3: (enumLiteral_74= 'OOPT' )
                    // InternalDbdTextEditor.g:3133:4: enumLiteral_74= 'OOPT'
                    {
                    enumLiteral_74=(Token)match(input,335,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getOOPTEnumLiteralDeclaration_74().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_74, grammarAccess.getFieldnamesAccess().getOOPTEnumLiteralDeclaration_74());
                    			

                    }


                    }
                    break;
                case 76 :
                    // InternalDbdTextEditor.g:3140:3: (enumLiteral_75= 'DLYA' )
                    {
                    // InternalDbdTextEditor.g:3140:3: (enumLiteral_75= 'DLYA' )
                    // InternalDbdTextEditor.g:3141:4: enumLiteral_75= 'DLYA'
                    {
                    enumLiteral_75=(Token)match(input,336,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getDLYAEnumLiteralDeclaration_75().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_75, grammarAccess.getFieldnamesAccess().getDLYAEnumLiteralDeclaration_75());
                    			

                    }


                    }
                    break;
                case 77 :
                    // InternalDbdTextEditor.g:3148:3: (enumLiteral_76= 'DOPT' )
                    {
                    // InternalDbdTextEditor.g:3148:3: (enumLiteral_76= 'DOPT' )
                    // InternalDbdTextEditor.g:3149:4: enumLiteral_76= 'DOPT'
                    {
                    enumLiteral_76=(Token)match(input,337,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getDOPTEnumLiteralDeclaration_76().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_76, grammarAccess.getFieldnamesAccess().getDOPTEnumLiteralDeclaration_76());
                    			

                    }


                    }
                    break;
                case 78 :
                    // InternalDbdTextEditor.g:3156:3: (enumLiteral_77= 'OCAL' )
                    {
                    // InternalDbdTextEditor.g:3156:3: (enumLiteral_77= 'OCAL' )
                    // InternalDbdTextEditor.g:3157:4: enumLiteral_77= 'OCAL'
                    {
                    enumLiteral_77=(Token)match(input,338,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getOCALEnumLiteralDeclaration_77().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_77, grammarAccess.getFieldnamesAccess().getOCALEnumLiteralDeclaration_77());
                    			

                    }


                    }
                    break;
                case 79 :
                    // InternalDbdTextEditor.g:3164:3: (enumLiteral_78= 'OCLV' )
                    {
                    // InternalDbdTextEditor.g:3164:3: (enumLiteral_78= 'OCLV' )
                    // InternalDbdTextEditor.g:3165:4: enumLiteral_78= 'OCLV'
                    {
                    enumLiteral_78=(Token)match(input,339,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getOCLVEnumLiteralDeclaration_78().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_78, grammarAccess.getFieldnamesAccess().getOCLVEnumLiteralDeclaration_78());
                    			

                    }


                    }
                    break;
                case 80 :
                    // InternalDbdTextEditor.g:3172:3: (enumLiteral_79= 'OEVT' )
                    {
                    // InternalDbdTextEditor.g:3172:3: (enumLiteral_79= 'OEVT' )
                    // InternalDbdTextEditor.g:3173:4: enumLiteral_79= 'OEVT'
                    {
                    enumLiteral_79=(Token)match(input,340,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getOEVTEnumLiteralDeclaration_79().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_79, grammarAccess.getFieldnamesAccess().getOEVTEnumLiteralDeclaration_79());
                    			

                    }


                    }
                    break;
                case 81 :
                    // InternalDbdTextEditor.g:3180:3: (enumLiteral_80= 'EPVT' )
                    {
                    // InternalDbdTextEditor.g:3180:3: (enumLiteral_80= 'EPVT' )
                    // InternalDbdTextEditor.g:3181:4: enumLiteral_80= 'EPVT'
                    {
                    enumLiteral_80=(Token)match(input,341,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getEPVTEnumLiteralDeclaration_80().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_80, grammarAccess.getFieldnamesAccess().getEPVTEnumLiteralDeclaration_80());
                    			

                    }


                    }
                    break;
                case 82 :
                    // InternalDbdTextEditor.g:3188:3: (enumLiteral_81= 'IVOA' )
                    {
                    // InternalDbdTextEditor.g:3188:3: (enumLiteral_81= 'IVOA' )
                    // InternalDbdTextEditor.g:3189:4: enumLiteral_81= 'IVOA'
                    {
                    enumLiteral_81=(Token)match(input,342,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getIVOAEnumLiteralDeclaration_81().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_81, grammarAccess.getFieldnamesAccess().getIVOAEnumLiteralDeclaration_81());
                    			

                    }


                    }
                    break;
                case 83 :
                    // InternalDbdTextEditor.g:3196:3: (enumLiteral_82= 'IVOV' )
                    {
                    // InternalDbdTextEditor.g:3196:3: (enumLiteral_82= 'IVOV' )
                    // InternalDbdTextEditor.g:3197:4: enumLiteral_82= 'IVOV'
                    {
                    enumLiteral_82=(Token)match(input,343,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getIVOVEnumLiteralDeclaration_82().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_82, grammarAccess.getFieldnamesAccess().getIVOVEnumLiteralDeclaration_82());
                    			

                    }


                    }
                    break;
                case 84 :
                    // InternalDbdTextEditor.g:3204:3: (enumLiteral_83= 'PREC' )
                    {
                    // InternalDbdTextEditor.g:3204:3: (enumLiteral_83= 'PREC' )
                    // InternalDbdTextEditor.g:3205:4: enumLiteral_83= 'PREC'
                    {
                    enumLiteral_83=(Token)match(input,344,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getPRECEnumLiteralDeclaration_83().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_83, grammarAccess.getFieldnamesAccess().getPRECEnumLiteralDeclaration_83());
                    			

                    }


                    }
                    break;
                case 85 :
                    // InternalDbdTextEditor.g:3212:3: (enumLiteral_84= 'HOPR' )
                    {
                    // InternalDbdTextEditor.g:3212:3: (enumLiteral_84= 'HOPR' )
                    // InternalDbdTextEditor.g:3213:4: enumLiteral_84= 'HOPR'
                    {
                    enumLiteral_84=(Token)match(input,345,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getHOPREnumLiteralDeclaration_84().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_84, grammarAccess.getFieldnamesAccess().getHOPREnumLiteralDeclaration_84());
                    			

                    }


                    }
                    break;
                case 86 :
                    // InternalDbdTextEditor.g:3220:3: (enumLiteral_85= 'LOPR' )
                    {
                    // InternalDbdTextEditor.g:3220:3: (enumLiteral_85= 'LOPR' )
                    // InternalDbdTextEditor.g:3221:4: enumLiteral_85= 'LOPR'
                    {
                    enumLiteral_85=(Token)match(input,346,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLOPREnumLiteralDeclaration_85().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_85, grammarAccess.getFieldnamesAccess().getLOPREnumLiteralDeclaration_85());
                    			

                    }


                    }
                    break;
                case 87 :
                    // InternalDbdTextEditor.g:3228:3: (enumLiteral_86= 'HIHI' )
                    {
                    // InternalDbdTextEditor.g:3228:3: (enumLiteral_86= 'HIHI' )
                    // InternalDbdTextEditor.g:3229:4: enumLiteral_86= 'HIHI'
                    {
                    enumLiteral_86=(Token)match(input,347,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getHIHIEnumLiteralDeclaration_86().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_86, grammarAccess.getFieldnamesAccess().getHIHIEnumLiteralDeclaration_86());
                    			

                    }


                    }
                    break;
                case 88 :
                    // InternalDbdTextEditor.g:3236:3: (enumLiteral_87= 'LOLO' )
                    {
                    // InternalDbdTextEditor.g:3236:3: (enumLiteral_87= 'LOLO' )
                    // InternalDbdTextEditor.g:3237:4: enumLiteral_87= 'LOLO'
                    {
                    enumLiteral_87=(Token)match(input,348,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLOLOEnumLiteralDeclaration_87().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_87, grammarAccess.getFieldnamesAccess().getLOLOEnumLiteralDeclaration_87());
                    			

                    }


                    }
                    break;
                case 89 :
                    // InternalDbdTextEditor.g:3244:3: (enumLiteral_88= 'HIGH' )
                    {
                    // InternalDbdTextEditor.g:3244:3: (enumLiteral_88= 'HIGH' )
                    // InternalDbdTextEditor.g:3245:4: enumLiteral_88= 'HIGH'
                    {
                    enumLiteral_88=(Token)match(input,349,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getHIGHEnumLiteralDeclaration_88().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_88, grammarAccess.getFieldnamesAccess().getHIGHEnumLiteralDeclaration_88());
                    			

                    }


                    }
                    break;
                case 90 :
                    // InternalDbdTextEditor.g:3252:3: (enumLiteral_89= 'LOW' )
                    {
                    // InternalDbdTextEditor.g:3252:3: (enumLiteral_89= 'LOW' )
                    // InternalDbdTextEditor.g:3253:4: enumLiteral_89= 'LOW'
                    {
                    enumLiteral_89=(Token)match(input,350,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLOWEnumLiteralDeclaration_89().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_89, grammarAccess.getFieldnamesAccess().getLOWEnumLiteralDeclaration_89());
                    			

                    }


                    }
                    break;
                case 91 :
                    // InternalDbdTextEditor.g:3260:3: (enumLiteral_90= 'HHSV' )
                    {
                    // InternalDbdTextEditor.g:3260:3: (enumLiteral_90= 'HHSV' )
                    // InternalDbdTextEditor.g:3261:4: enumLiteral_90= 'HHSV'
                    {
                    enumLiteral_90=(Token)match(input,351,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getHHSVEnumLiteralDeclaration_90().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_90, grammarAccess.getFieldnamesAccess().getHHSVEnumLiteralDeclaration_90());
                    			

                    }


                    }
                    break;
                case 92 :
                    // InternalDbdTextEditor.g:3268:3: (enumLiteral_91= 'LLSV' )
                    {
                    // InternalDbdTextEditor.g:3268:3: (enumLiteral_91= 'LLSV' )
                    // InternalDbdTextEditor.g:3269:4: enumLiteral_91= 'LLSV'
                    {
                    enumLiteral_91=(Token)match(input,352,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLLSVEnumLiteralDeclaration_91().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_91, grammarAccess.getFieldnamesAccess().getLLSVEnumLiteralDeclaration_91());
                    			

                    }


                    }
                    break;
                case 93 :
                    // InternalDbdTextEditor.g:3276:3: (enumLiteral_92= 'HSV' )
                    {
                    // InternalDbdTextEditor.g:3276:3: (enumLiteral_92= 'HSV' )
                    // InternalDbdTextEditor.g:3277:4: enumLiteral_92= 'HSV'
                    {
                    enumLiteral_92=(Token)match(input,353,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getHSVEnumLiteralDeclaration_92().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_92, grammarAccess.getFieldnamesAccess().getHSVEnumLiteralDeclaration_92());
                    			

                    }


                    }
                    break;
                case 94 :
                    // InternalDbdTextEditor.g:3284:3: (enumLiteral_93= 'LSV' )
                    {
                    // InternalDbdTextEditor.g:3284:3: (enumLiteral_93= 'LSV' )
                    // InternalDbdTextEditor.g:3285:4: enumLiteral_93= 'LSV'
                    {
                    enumLiteral_93=(Token)match(input,354,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLSVEnumLiteralDeclaration_93().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_93, grammarAccess.getFieldnamesAccess().getLSVEnumLiteralDeclaration_93());
                    			

                    }


                    }
                    break;
                case 95 :
                    // InternalDbdTextEditor.g:3292:3: (enumLiteral_94= 'HYST' )
                    {
                    // InternalDbdTextEditor.g:3292:3: (enumLiteral_94= 'HYST' )
                    // InternalDbdTextEditor.g:3293:4: enumLiteral_94= 'HYST'
                    {
                    enumLiteral_94=(Token)match(input,355,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getHYSTEnumLiteralDeclaration_94().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_94, grammarAccess.getFieldnamesAccess().getHYSTEnumLiteralDeclaration_94());
                    			

                    }


                    }
                    break;
                case 96 :
                    // InternalDbdTextEditor.g:3300:3: (enumLiteral_95= 'ADEL' )
                    {
                    // InternalDbdTextEditor.g:3300:3: (enumLiteral_95= 'ADEL' )
                    // InternalDbdTextEditor.g:3301:4: enumLiteral_95= 'ADEL'
                    {
                    enumLiteral_95=(Token)match(input,356,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getADELEnumLiteralDeclaration_95().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_95, grammarAccess.getFieldnamesAccess().getADELEnumLiteralDeclaration_95());
                    			

                    }


                    }
                    break;
                case 97 :
                    // InternalDbdTextEditor.g:3308:3: (enumLiteral_96= 'MDEL' )
                    {
                    // InternalDbdTextEditor.g:3308:3: (enumLiteral_96= 'MDEL' )
                    // InternalDbdTextEditor.g:3309:4: enumLiteral_96= 'MDEL'
                    {
                    enumLiteral_96=(Token)match(input,357,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getMDELEnumLiteralDeclaration_96().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_96, grammarAccess.getFieldnamesAccess().getMDELEnumLiteralDeclaration_96());
                    			

                    }


                    }
                    break;
                case 98 :
                    // InternalDbdTextEditor.g:3316:3: (enumLiteral_97= 'A' )
                    {
                    // InternalDbdTextEditor.g:3316:3: (enumLiteral_97= 'A' )
                    // InternalDbdTextEditor.g:3317:4: enumLiteral_97= 'A'
                    {
                    enumLiteral_97=(Token)match(input,358,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getAEnumLiteralDeclaration_97().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_97, grammarAccess.getFieldnamesAccess().getAEnumLiteralDeclaration_97());
                    			

                    }


                    }
                    break;
                case 99 :
                    // InternalDbdTextEditor.g:3324:3: (enumLiteral_98= 'B' )
                    {
                    // InternalDbdTextEditor.g:3324:3: (enumLiteral_98= 'B' )
                    // InternalDbdTextEditor.g:3325:4: enumLiteral_98= 'B'
                    {
                    enumLiteral_98=(Token)match(input,359,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getBEnumLiteralDeclaration_98().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_98, grammarAccess.getFieldnamesAccess().getBEnumLiteralDeclaration_98());
                    			

                    }


                    }
                    break;
                case 100 :
                    // InternalDbdTextEditor.g:3332:3: (enumLiteral_99= 'C' )
                    {
                    // InternalDbdTextEditor.g:3332:3: (enumLiteral_99= 'C' )
                    // InternalDbdTextEditor.g:3333:4: enumLiteral_99= 'C'
                    {
                    enumLiteral_99=(Token)match(input,360,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getCEnumLiteralDeclaration_99().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_99, grammarAccess.getFieldnamesAccess().getCEnumLiteralDeclaration_99());
                    			

                    }


                    }
                    break;
                case 101 :
                    // InternalDbdTextEditor.g:3340:3: (enumLiteral_100= 'D' )
                    {
                    // InternalDbdTextEditor.g:3340:3: (enumLiteral_100= 'D' )
                    // InternalDbdTextEditor.g:3341:4: enumLiteral_100= 'D'
                    {
                    enumLiteral_100=(Token)match(input,361,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getDEnumLiteralDeclaration_100().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_100, grammarAccess.getFieldnamesAccess().getDEnumLiteralDeclaration_100());
                    			

                    }


                    }
                    break;
                case 102 :
                    // InternalDbdTextEditor.g:3348:3: (enumLiteral_101= 'E' )
                    {
                    // InternalDbdTextEditor.g:3348:3: (enumLiteral_101= 'E' )
                    // InternalDbdTextEditor.g:3349:4: enumLiteral_101= 'E'
                    {
                    enumLiteral_101=(Token)match(input,362,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getEEnumLiteralDeclaration_101().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_101, grammarAccess.getFieldnamesAccess().getEEnumLiteralDeclaration_101());
                    			

                    }


                    }
                    break;
                case 103 :
                    // InternalDbdTextEditor.g:3356:3: (enumLiteral_102= 'F' )
                    {
                    // InternalDbdTextEditor.g:3356:3: (enumLiteral_102= 'F' )
                    // InternalDbdTextEditor.g:3357:4: enumLiteral_102= 'F'
                    {
                    enumLiteral_102=(Token)match(input,363,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getFEnumLiteralDeclaration_102().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_102, grammarAccess.getFieldnamesAccess().getFEnumLiteralDeclaration_102());
                    			

                    }


                    }
                    break;
                case 104 :
                    // InternalDbdTextEditor.g:3364:3: (enumLiteral_103= 'G' )
                    {
                    // InternalDbdTextEditor.g:3364:3: (enumLiteral_103= 'G' )
                    // InternalDbdTextEditor.g:3365:4: enumLiteral_103= 'G'
                    {
                    enumLiteral_103=(Token)match(input,364,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getGEnumLiteralDeclaration_103().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_103, grammarAccess.getFieldnamesAccess().getGEnumLiteralDeclaration_103());
                    			

                    }


                    }
                    break;
                case 105 :
                    // InternalDbdTextEditor.g:3372:3: (enumLiteral_104= 'H' )
                    {
                    // InternalDbdTextEditor.g:3372:3: (enumLiteral_104= 'H' )
                    // InternalDbdTextEditor.g:3373:4: enumLiteral_104= 'H'
                    {
                    enumLiteral_104=(Token)match(input,365,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getHEnumLiteralDeclaration_104().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_104, grammarAccess.getFieldnamesAccess().getHEnumLiteralDeclaration_104());
                    			

                    }


                    }
                    break;
                case 106 :
                    // InternalDbdTextEditor.g:3380:3: (enumLiteral_105= 'I' )
                    {
                    // InternalDbdTextEditor.g:3380:3: (enumLiteral_105= 'I' )
                    // InternalDbdTextEditor.g:3381:4: enumLiteral_105= 'I'
                    {
                    enumLiteral_105=(Token)match(input,366,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getIEnumLiteralDeclaration_105().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_105, grammarAccess.getFieldnamesAccess().getIEnumLiteralDeclaration_105());
                    			

                    }


                    }
                    break;
                case 107 :
                    // InternalDbdTextEditor.g:3388:3: (enumLiteral_106= 'J' )
                    {
                    // InternalDbdTextEditor.g:3388:3: (enumLiteral_106= 'J' )
                    // InternalDbdTextEditor.g:3389:4: enumLiteral_106= 'J'
                    {
                    enumLiteral_106=(Token)match(input,367,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getJEnumLiteralDeclaration_106().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_106, grammarAccess.getFieldnamesAccess().getJEnumLiteralDeclaration_106());
                    			

                    }


                    }
                    break;
                case 108 :
                    // InternalDbdTextEditor.g:3396:3: (enumLiteral_107= 'K' )
                    {
                    // InternalDbdTextEditor.g:3396:3: (enumLiteral_107= 'K' )
                    // InternalDbdTextEditor.g:3397:4: enumLiteral_107= 'K'
                    {
                    enumLiteral_107=(Token)match(input,368,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getKEnumLiteralDeclaration_107().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_107, grammarAccess.getFieldnamesAccess().getKEnumLiteralDeclaration_107());
                    			

                    }


                    }
                    break;
                case 109 :
                    // InternalDbdTextEditor.g:3404:3: (enumLiteral_108= 'L' )
                    {
                    // InternalDbdTextEditor.g:3404:3: (enumLiteral_108= 'L' )
                    // InternalDbdTextEditor.g:3405:4: enumLiteral_108= 'L'
                    {
                    enumLiteral_108=(Token)match(input,369,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLEnumLiteralDeclaration_108().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_108, grammarAccess.getFieldnamesAccess().getLEnumLiteralDeclaration_108());
                    			

                    }


                    }
                    break;
                case 110 :
                    // InternalDbdTextEditor.g:3412:3: (enumLiteral_109= 'OVAL' )
                    {
                    // InternalDbdTextEditor.g:3412:3: (enumLiteral_109= 'OVAL' )
                    // InternalDbdTextEditor.g:3413:4: enumLiteral_109= 'OVAL'
                    {
                    enumLiteral_109=(Token)match(input,370,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getOVALEnumLiteralDeclaration_109().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_109, grammarAccess.getFieldnamesAccess().getOVALEnumLiteralDeclaration_109());
                    			

                    }


                    }
                    break;
                case 111 :
                    // InternalDbdTextEditor.g:3420:3: (enumLiteral_110= 'LA' )
                    {
                    // InternalDbdTextEditor.g:3420:3: (enumLiteral_110= 'LA' )
                    // InternalDbdTextEditor.g:3421:4: enumLiteral_110= 'LA'
                    {
                    enumLiteral_110=(Token)match(input,371,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLAEnumLiteralDeclaration_110().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_110, grammarAccess.getFieldnamesAccess().getLAEnumLiteralDeclaration_110());
                    			

                    }


                    }
                    break;
                case 112 :
                    // InternalDbdTextEditor.g:3428:3: (enumLiteral_111= 'LB' )
                    {
                    // InternalDbdTextEditor.g:3428:3: (enumLiteral_111= 'LB' )
                    // InternalDbdTextEditor.g:3429:4: enumLiteral_111= 'LB'
                    {
                    enumLiteral_111=(Token)match(input,372,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLBEnumLiteralDeclaration_111().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_111, grammarAccess.getFieldnamesAccess().getLBEnumLiteralDeclaration_111());
                    			

                    }


                    }
                    break;
                case 113 :
                    // InternalDbdTextEditor.g:3436:3: (enumLiteral_112= 'LC' )
                    {
                    // InternalDbdTextEditor.g:3436:3: (enumLiteral_112= 'LC' )
                    // InternalDbdTextEditor.g:3437:4: enumLiteral_112= 'LC'
                    {
                    enumLiteral_112=(Token)match(input,373,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLCEnumLiteralDeclaration_112().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_112, grammarAccess.getFieldnamesAccess().getLCEnumLiteralDeclaration_112());
                    			

                    }


                    }
                    break;
                case 114 :
                    // InternalDbdTextEditor.g:3444:3: (enumLiteral_113= 'LD' )
                    {
                    // InternalDbdTextEditor.g:3444:3: (enumLiteral_113= 'LD' )
                    // InternalDbdTextEditor.g:3445:4: enumLiteral_113= 'LD'
                    {
                    enumLiteral_113=(Token)match(input,374,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLDEnumLiteralDeclaration_113().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_113, grammarAccess.getFieldnamesAccess().getLDEnumLiteralDeclaration_113());
                    			

                    }


                    }
                    break;
                case 115 :
                    // InternalDbdTextEditor.g:3452:3: (enumLiteral_114= 'LE' )
                    {
                    // InternalDbdTextEditor.g:3452:3: (enumLiteral_114= 'LE' )
                    // InternalDbdTextEditor.g:3453:4: enumLiteral_114= 'LE'
                    {
                    enumLiteral_114=(Token)match(input,375,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLEEnumLiteralDeclaration_114().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_114, grammarAccess.getFieldnamesAccess().getLEEnumLiteralDeclaration_114());
                    			

                    }


                    }
                    break;
                case 116 :
                    // InternalDbdTextEditor.g:3460:3: (enumLiteral_115= 'LF' )
                    {
                    // InternalDbdTextEditor.g:3460:3: (enumLiteral_115= 'LF' )
                    // InternalDbdTextEditor.g:3461:4: enumLiteral_115= 'LF'
                    {
                    enumLiteral_115=(Token)match(input,376,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLFEnumLiteralDeclaration_115().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_115, grammarAccess.getFieldnamesAccess().getLFEnumLiteralDeclaration_115());
                    			

                    }


                    }
                    break;
                case 117 :
                    // InternalDbdTextEditor.g:3468:3: (enumLiteral_116= 'LG' )
                    {
                    // InternalDbdTextEditor.g:3468:3: (enumLiteral_116= 'LG' )
                    // InternalDbdTextEditor.g:3469:4: enumLiteral_116= 'LG'
                    {
                    enumLiteral_116=(Token)match(input,377,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLGEnumLiteralDeclaration_116().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_116, grammarAccess.getFieldnamesAccess().getLGEnumLiteralDeclaration_116());
                    			

                    }


                    }
                    break;
                case 118 :
                    // InternalDbdTextEditor.g:3476:3: (enumLiteral_117= 'LH' )
                    {
                    // InternalDbdTextEditor.g:3476:3: (enumLiteral_117= 'LH' )
                    // InternalDbdTextEditor.g:3477:4: enumLiteral_117= 'LH'
                    {
                    enumLiteral_117=(Token)match(input,378,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLHEnumLiteralDeclaration_117().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_117, grammarAccess.getFieldnamesAccess().getLHEnumLiteralDeclaration_117());
                    			

                    }


                    }
                    break;
                case 119 :
                    // InternalDbdTextEditor.g:3484:3: (enumLiteral_118= 'LI' )
                    {
                    // InternalDbdTextEditor.g:3484:3: (enumLiteral_118= 'LI' )
                    // InternalDbdTextEditor.g:3485:4: enumLiteral_118= 'LI'
                    {
                    enumLiteral_118=(Token)match(input,379,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLIEnumLiteralDeclaration_118().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_118, grammarAccess.getFieldnamesAccess().getLIEnumLiteralDeclaration_118());
                    			

                    }


                    }
                    break;
                case 120 :
                    // InternalDbdTextEditor.g:3492:3: (enumLiteral_119= 'LJ' )
                    {
                    // InternalDbdTextEditor.g:3492:3: (enumLiteral_119= 'LJ' )
                    // InternalDbdTextEditor.g:3493:4: enumLiteral_119= 'LJ'
                    {
                    enumLiteral_119=(Token)match(input,380,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLJEnumLiteralDeclaration_119().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_119, grammarAccess.getFieldnamesAccess().getLJEnumLiteralDeclaration_119());
                    			

                    }


                    }
                    break;
                case 121 :
                    // InternalDbdTextEditor.g:3500:3: (enumLiteral_120= 'LK' )
                    {
                    // InternalDbdTextEditor.g:3500:3: (enumLiteral_120= 'LK' )
                    // InternalDbdTextEditor.g:3501:4: enumLiteral_120= 'LK'
                    {
                    enumLiteral_120=(Token)match(input,381,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLKEnumLiteralDeclaration_120().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_120, grammarAccess.getFieldnamesAccess().getLKEnumLiteralDeclaration_120());
                    			

                    }


                    }
                    break;
                case 122 :
                    // InternalDbdTextEditor.g:3508:3: (enumLiteral_121= 'LL' )
                    {
                    // InternalDbdTextEditor.g:3508:3: (enumLiteral_121= 'LL' )
                    // InternalDbdTextEditor.g:3509:4: enumLiteral_121= 'LL'
                    {
                    enumLiteral_121=(Token)match(input,382,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLLEnumLiteralDeclaration_121().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_121, grammarAccess.getFieldnamesAccess().getLLEnumLiteralDeclaration_121());
                    			

                    }


                    }
                    break;
                case 123 :
                    // InternalDbdTextEditor.g:3516:3: (enumLiteral_122= 'POVL' )
                    {
                    // InternalDbdTextEditor.g:3516:3: (enumLiteral_122= 'POVL' )
                    // InternalDbdTextEditor.g:3517:4: enumLiteral_122= 'POVL'
                    {
                    enumLiteral_122=(Token)match(input,383,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getPOVLEnumLiteralDeclaration_122().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_122, grammarAccess.getFieldnamesAccess().getPOVLEnumLiteralDeclaration_122());
                    			

                    }


                    }
                    break;
                case 124 :
                    // InternalDbdTextEditor.g:3524:3: (enumLiteral_123= 'LALM' )
                    {
                    // InternalDbdTextEditor.g:3524:3: (enumLiteral_123= 'LALM' )
                    // InternalDbdTextEditor.g:3525:4: enumLiteral_123= 'LALM'
                    {
                    enumLiteral_123=(Token)match(input,384,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getLALMEnumLiteralDeclaration_123().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_123, grammarAccess.getFieldnamesAccess().getLALMEnumLiteralDeclaration_123());
                    			

                    }


                    }
                    break;
                case 125 :
                    // InternalDbdTextEditor.g:3532:3: (enumLiteral_124= 'ALST' )
                    {
                    // InternalDbdTextEditor.g:3532:3: (enumLiteral_124= 'ALST' )
                    // InternalDbdTextEditor.g:3533:4: enumLiteral_124= 'ALST'
                    {
                    enumLiteral_124=(Token)match(input,385,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getALSTEnumLiteralDeclaration_124().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_124, grammarAccess.getFieldnamesAccess().getALSTEnumLiteralDeclaration_124());
                    			

                    }


                    }
                    break;
                case 126 :
                    // InternalDbdTextEditor.g:3540:3: (enumLiteral_125= 'MLST' )
                    {
                    // InternalDbdTextEditor.g:3540:3: (enumLiteral_125= 'MLST' )
                    // InternalDbdTextEditor.g:3541:4: enumLiteral_125= 'MLST'
                    {
                    enumLiteral_125=(Token)match(input,386,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getMLSTEnumLiteralDeclaration_125().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_125, grammarAccess.getFieldnamesAccess().getMLSTEnumLiteralDeclaration_125());
                    			

                    }


                    }
                    break;
                case 127 :
                    // InternalDbdTextEditor.g:3548:3: (enumLiteral_126= 'RPCL' )
                    {
                    // InternalDbdTextEditor.g:3548:3: (enumLiteral_126= 'RPCL' )
                    // InternalDbdTextEditor.g:3549:4: enumLiteral_126= 'RPCL'
                    {
                    enumLiteral_126=(Token)match(input,387,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getRPCLEnumLiteralDeclaration_126().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_126, grammarAccess.getFieldnamesAccess().getRPCLEnumLiteralDeclaration_126());
                    			

                    }


                    }
                    break;
                case 128 :
                    // InternalDbdTextEditor.g:3556:3: (enumLiteral_127= 'ORPC' )
                    {
                    // InternalDbdTextEditor.g:3556:3: (enumLiteral_127= 'ORPC' )
                    // InternalDbdTextEditor.g:3557:4: enumLiteral_127= 'ORPC'
                    {
                    enumLiteral_127=(Token)match(input,388,FOLLOW_2); 

                    				current = grammarAccess.getFieldnamesAccess().getORPCEnumLiteralDeclaration_127().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_127, grammarAccess.getFieldnamesAccess().getORPCEnumLiteralDeclaration_127());
                    			

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


    // $ANTLR start "ruleDbfnames"
    // InternalDbdTextEditor.g:3567:1: ruleDbfnames returns [Enumerator current=null] : ( (enumLiteral_0= 'DBF_STRING' ) | (enumLiteral_1= 'DBF_MENU' ) | (enumLiteral_2= 'DBF_INLINK' ) | (enumLiteral_3= 'DBF_FWDLINK' ) | (enumLiteral_4= 'DBF_SHORT' ) | (enumLiteral_5= 'DBF_DEVICE' ) | (enumLiteral_6= 'DBF_NOACCESS' ) | (enumLiteral_7= 'DBF_UCHAR' ) | (enumLiteral_8= 'DBF_OUTLINK' ) | (enumLiteral_9= 'DBF_USHORT' ) | (enumLiteral_10= 'DBF_DOUBLE' ) | (enumLiteral_11= 'DBF_ULONG' ) | (enumLiteral_12= 'INT64' ) ) ;
    public final Enumerator ruleDbfnames() throws RecognitionException {
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


        	enterRule();

        try {
            // InternalDbdTextEditor.g:3573:2: ( ( (enumLiteral_0= 'DBF_STRING' ) | (enumLiteral_1= 'DBF_MENU' ) | (enumLiteral_2= 'DBF_INLINK' ) | (enumLiteral_3= 'DBF_FWDLINK' ) | (enumLiteral_4= 'DBF_SHORT' ) | (enumLiteral_5= 'DBF_DEVICE' ) | (enumLiteral_6= 'DBF_NOACCESS' ) | (enumLiteral_7= 'DBF_UCHAR' ) | (enumLiteral_8= 'DBF_OUTLINK' ) | (enumLiteral_9= 'DBF_USHORT' ) | (enumLiteral_10= 'DBF_DOUBLE' ) | (enumLiteral_11= 'DBF_ULONG' ) | (enumLiteral_12= 'INT64' ) ) )
            // InternalDbdTextEditor.g:3574:2: ( (enumLiteral_0= 'DBF_STRING' ) | (enumLiteral_1= 'DBF_MENU' ) | (enumLiteral_2= 'DBF_INLINK' ) | (enumLiteral_3= 'DBF_FWDLINK' ) | (enumLiteral_4= 'DBF_SHORT' ) | (enumLiteral_5= 'DBF_DEVICE' ) | (enumLiteral_6= 'DBF_NOACCESS' ) | (enumLiteral_7= 'DBF_UCHAR' ) | (enumLiteral_8= 'DBF_OUTLINK' ) | (enumLiteral_9= 'DBF_USHORT' ) | (enumLiteral_10= 'DBF_DOUBLE' ) | (enumLiteral_11= 'DBF_ULONG' ) | (enumLiteral_12= 'INT64' ) )
            {
            // InternalDbdTextEditor.g:3574:2: ( (enumLiteral_0= 'DBF_STRING' ) | (enumLiteral_1= 'DBF_MENU' ) | (enumLiteral_2= 'DBF_INLINK' ) | (enumLiteral_3= 'DBF_FWDLINK' ) | (enumLiteral_4= 'DBF_SHORT' ) | (enumLiteral_5= 'DBF_DEVICE' ) | (enumLiteral_6= 'DBF_NOACCESS' ) | (enumLiteral_7= 'DBF_UCHAR' ) | (enumLiteral_8= 'DBF_OUTLINK' ) | (enumLiteral_9= 'DBF_USHORT' ) | (enumLiteral_10= 'DBF_DOUBLE' ) | (enumLiteral_11= 'DBF_ULONG' ) | (enumLiteral_12= 'INT64' ) )
            int alt11=13;
            switch ( input.LA(1) ) {
            case 389:
                {
                alt11=1;
                }
                break;
            case 390:
                {
                alt11=2;
                }
                break;
            case 391:
                {
                alt11=3;
                }
                break;
            case 392:
                {
                alt11=4;
                }
                break;
            case 393:
                {
                alt11=5;
                }
                break;
            case 394:
                {
                alt11=6;
                }
                break;
            case 395:
                {
                alt11=7;
                }
                break;
            case 396:
                {
                alt11=8;
                }
                break;
            case 397:
                {
                alt11=9;
                }
                break;
            case 398:
                {
                alt11=10;
                }
                break;
            case 399:
                {
                alt11=11;
                }
                break;
            case 400:
                {
                alt11=12;
                }
                break;
            case 401:
                {
                alt11=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalDbdTextEditor.g:3575:3: (enumLiteral_0= 'DBF_STRING' )
                    {
                    // InternalDbdTextEditor.g:3575:3: (enumLiteral_0= 'DBF_STRING' )
                    // InternalDbdTextEditor.g:3576:4: enumLiteral_0= 'DBF_STRING'
                    {
                    enumLiteral_0=(Token)match(input,389,FOLLOW_2); 

                    				current = grammarAccess.getDbfnamesAccess().getDBF_STRINGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDbfnamesAccess().getDBF_STRINGEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDbdTextEditor.g:3583:3: (enumLiteral_1= 'DBF_MENU' )
                    {
                    // InternalDbdTextEditor.g:3583:3: (enumLiteral_1= 'DBF_MENU' )
                    // InternalDbdTextEditor.g:3584:4: enumLiteral_1= 'DBF_MENU'
                    {
                    enumLiteral_1=(Token)match(input,390,FOLLOW_2); 

                    				current = grammarAccess.getDbfnamesAccess().getDBF_MENUEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDbfnamesAccess().getDBF_MENUEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDbdTextEditor.g:3591:3: (enumLiteral_2= 'DBF_INLINK' )
                    {
                    // InternalDbdTextEditor.g:3591:3: (enumLiteral_2= 'DBF_INLINK' )
                    // InternalDbdTextEditor.g:3592:4: enumLiteral_2= 'DBF_INLINK'
                    {
                    enumLiteral_2=(Token)match(input,391,FOLLOW_2); 

                    				current = grammarAccess.getDbfnamesAccess().getDBF_INLINKEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDbfnamesAccess().getDBF_INLINKEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDbdTextEditor.g:3599:3: (enumLiteral_3= 'DBF_FWDLINK' )
                    {
                    // InternalDbdTextEditor.g:3599:3: (enumLiteral_3= 'DBF_FWDLINK' )
                    // InternalDbdTextEditor.g:3600:4: enumLiteral_3= 'DBF_FWDLINK'
                    {
                    enumLiteral_3=(Token)match(input,392,FOLLOW_2); 

                    				current = grammarAccess.getDbfnamesAccess().getDBF_FWDLINKEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDbfnamesAccess().getDBF_FWDLINKEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDbdTextEditor.g:3607:3: (enumLiteral_4= 'DBF_SHORT' )
                    {
                    // InternalDbdTextEditor.g:3607:3: (enumLiteral_4= 'DBF_SHORT' )
                    // InternalDbdTextEditor.g:3608:4: enumLiteral_4= 'DBF_SHORT'
                    {
                    enumLiteral_4=(Token)match(input,393,FOLLOW_2); 

                    				current = grammarAccess.getDbfnamesAccess().getDBF_SHORTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getDbfnamesAccess().getDBF_SHORTEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalDbdTextEditor.g:3615:3: (enumLiteral_5= 'DBF_DEVICE' )
                    {
                    // InternalDbdTextEditor.g:3615:3: (enumLiteral_5= 'DBF_DEVICE' )
                    // InternalDbdTextEditor.g:3616:4: enumLiteral_5= 'DBF_DEVICE'
                    {
                    enumLiteral_5=(Token)match(input,394,FOLLOW_2); 

                    				current = grammarAccess.getDbfnamesAccess().getDBF_DEVICEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getDbfnamesAccess().getDBF_DEVICEEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalDbdTextEditor.g:3623:3: (enumLiteral_6= 'DBF_NOACCESS' )
                    {
                    // InternalDbdTextEditor.g:3623:3: (enumLiteral_6= 'DBF_NOACCESS' )
                    // InternalDbdTextEditor.g:3624:4: enumLiteral_6= 'DBF_NOACCESS'
                    {
                    enumLiteral_6=(Token)match(input,395,FOLLOW_2); 

                    				current = grammarAccess.getDbfnamesAccess().getDBF_NOACCESSEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getDbfnamesAccess().getDBF_NOACCESSEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalDbdTextEditor.g:3631:3: (enumLiteral_7= 'DBF_UCHAR' )
                    {
                    // InternalDbdTextEditor.g:3631:3: (enumLiteral_7= 'DBF_UCHAR' )
                    // InternalDbdTextEditor.g:3632:4: enumLiteral_7= 'DBF_UCHAR'
                    {
                    enumLiteral_7=(Token)match(input,396,FOLLOW_2); 

                    				current = grammarAccess.getDbfnamesAccess().getDBF_UCHAREnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getDbfnamesAccess().getDBF_UCHAREnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalDbdTextEditor.g:3639:3: (enumLiteral_8= 'DBF_OUTLINK' )
                    {
                    // InternalDbdTextEditor.g:3639:3: (enumLiteral_8= 'DBF_OUTLINK' )
                    // InternalDbdTextEditor.g:3640:4: enumLiteral_8= 'DBF_OUTLINK'
                    {
                    enumLiteral_8=(Token)match(input,397,FOLLOW_2); 

                    				current = grammarAccess.getDbfnamesAccess().getDBF_OUTLINKEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getDbfnamesAccess().getDBF_OUTLINKEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalDbdTextEditor.g:3647:3: (enumLiteral_9= 'DBF_USHORT' )
                    {
                    // InternalDbdTextEditor.g:3647:3: (enumLiteral_9= 'DBF_USHORT' )
                    // InternalDbdTextEditor.g:3648:4: enumLiteral_9= 'DBF_USHORT'
                    {
                    enumLiteral_9=(Token)match(input,398,FOLLOW_2); 

                    				current = grammarAccess.getDbfnamesAccess().getDBF_USHORTEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getDbfnamesAccess().getDBF_USHORTEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalDbdTextEditor.g:3655:3: (enumLiteral_10= 'DBF_DOUBLE' )
                    {
                    // InternalDbdTextEditor.g:3655:3: (enumLiteral_10= 'DBF_DOUBLE' )
                    // InternalDbdTextEditor.g:3656:4: enumLiteral_10= 'DBF_DOUBLE'
                    {
                    enumLiteral_10=(Token)match(input,399,FOLLOW_2); 

                    				current = grammarAccess.getDbfnamesAccess().getDBF_DOUBLEEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getDbfnamesAccess().getDBF_DOUBLEEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalDbdTextEditor.g:3663:3: (enumLiteral_11= 'DBF_ULONG' )
                    {
                    // InternalDbdTextEditor.g:3663:3: (enumLiteral_11= 'DBF_ULONG' )
                    // InternalDbdTextEditor.g:3664:4: enumLiteral_11= 'DBF_ULONG'
                    {
                    enumLiteral_11=(Token)match(input,400,FOLLOW_2); 

                    				current = grammarAccess.getDbfnamesAccess().getDBF_ULONGEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getDbfnamesAccess().getDBF_ULONGEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalDbdTextEditor.g:3671:3: (enumLiteral_12= 'INT64' )
                    {
                    // InternalDbdTextEditor.g:3671:3: (enumLiteral_12= 'INT64' )
                    // InternalDbdTextEditor.g:3672:4: enumLiteral_12= 'INT64'
                    {
                    enumLiteral_12=(Token)match(input,401,FOLLOW_2); 

                    				current = grammarAccess.getDbfnamesAccess().getINT64EnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getDbfnamesAccess().getINT64EnumLiteralDeclaration_12());
                    			

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
    // $ANTLR end "ruleDbfnames"


    // $ANTLR start "ruleFieldattributenames"
    // InternalDbdTextEditor.g:3682:1: ruleFieldattributenames returns [Enumerator current=null] : ( (enumLiteral_0= 'size' ) | (enumLiteral_1= 'prompt' ) | (enumLiteral_2= 'promptgroup' ) | (enumLiteral_3= 'menu' ) | (enumLiteral_4= 'interest' ) ) ;
    public final Enumerator ruleFieldattributenames() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalDbdTextEditor.g:3688:2: ( ( (enumLiteral_0= 'size' ) | (enumLiteral_1= 'prompt' ) | (enumLiteral_2= 'promptgroup' ) | (enumLiteral_3= 'menu' ) | (enumLiteral_4= 'interest' ) ) )
            // InternalDbdTextEditor.g:3689:2: ( (enumLiteral_0= 'size' ) | (enumLiteral_1= 'prompt' ) | (enumLiteral_2= 'promptgroup' ) | (enumLiteral_3= 'menu' ) | (enumLiteral_4= 'interest' ) )
            {
            // InternalDbdTextEditor.g:3689:2: ( (enumLiteral_0= 'size' ) | (enumLiteral_1= 'prompt' ) | (enumLiteral_2= 'promptgroup' ) | (enumLiteral_3= 'menu' ) | (enumLiteral_4= 'interest' ) )
            int alt12=5;
            switch ( input.LA(1) ) {
            case 402:
                {
                alt12=1;
                }
                break;
            case 403:
                {
                alt12=2;
                }
                break;
            case 404:
                {
                alt12=3;
                }
                break;
            case 11:
                {
                alt12=4;
                }
                break;
            case 405:
                {
                alt12=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalDbdTextEditor.g:3690:3: (enumLiteral_0= 'size' )
                    {
                    // InternalDbdTextEditor.g:3690:3: (enumLiteral_0= 'size' )
                    // InternalDbdTextEditor.g:3691:4: enumLiteral_0= 'size'
                    {
                    enumLiteral_0=(Token)match(input,402,FOLLOW_2); 

                    				current = grammarAccess.getFieldattributenamesAccess().getSizeEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getFieldattributenamesAccess().getSizeEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDbdTextEditor.g:3698:3: (enumLiteral_1= 'prompt' )
                    {
                    // InternalDbdTextEditor.g:3698:3: (enumLiteral_1= 'prompt' )
                    // InternalDbdTextEditor.g:3699:4: enumLiteral_1= 'prompt'
                    {
                    enumLiteral_1=(Token)match(input,403,FOLLOW_2); 

                    				current = grammarAccess.getFieldattributenamesAccess().getPromptEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getFieldattributenamesAccess().getPromptEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDbdTextEditor.g:3706:3: (enumLiteral_2= 'promptgroup' )
                    {
                    // InternalDbdTextEditor.g:3706:3: (enumLiteral_2= 'promptgroup' )
                    // InternalDbdTextEditor.g:3707:4: enumLiteral_2= 'promptgroup'
                    {
                    enumLiteral_2=(Token)match(input,404,FOLLOW_2); 

                    				current = grammarAccess.getFieldattributenamesAccess().getPromptgroupEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getFieldattributenamesAccess().getPromptgroupEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDbdTextEditor.g:3714:3: (enumLiteral_3= 'menu' )
                    {
                    // InternalDbdTextEditor.g:3714:3: (enumLiteral_3= 'menu' )
                    // InternalDbdTextEditor.g:3715:4: enumLiteral_3= 'menu'
                    {
                    enumLiteral_3=(Token)match(input,11,FOLLOW_2); 

                    				current = grammarAccess.getFieldattributenamesAccess().getMenuEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getFieldattributenamesAccess().getMenuEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDbdTextEditor.g:3722:3: (enumLiteral_4= 'interest' )
                    {
                    // InternalDbdTextEditor.g:3722:3: (enumLiteral_4= 'interest' )
                    // InternalDbdTextEditor.g:3723:4: enumLiteral_4= 'interest'
                    {
                    enumLiteral_4=(Token)match(input,405,FOLLOW_2); 

                    				current = grammarAccess.getFieldattributenamesAccess().getInterestEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getFieldattributenamesAccess().getInterestEnumLiteralDeclaration_4());
                    			

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
    // $ANTLR end "ruleFieldattributenames"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000040802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0xFFFFFFFFFFF00000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0xFFFFFFFFFFFFFC00L,0xFFFFFFFFFFFFFFFFL,0x00000001FFFFFFFFL});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0xFFFFFFFE00000000L,0x000000000000003FL});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000004000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0xFFFFFFFFFFFFFFC0L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000000003FFE0L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000008800L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x00000000003C0000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000030L});

}