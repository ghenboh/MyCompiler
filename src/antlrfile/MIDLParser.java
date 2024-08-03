package antlrfile;

// Generated from MIDL.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MIDLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, INTEGER=42, FLOATING_PT=43, CHAR=44, STRING=45, 
		BOOLEAN=46, ID=47, WS=48;
	public static final int
		RULE_specification = 0, RULE_definition = 1, RULE_module = 2, RULE_type_decl = 3, 
		RULE_struct_type = 4, RULE_member_list = 5, RULE_type_spec = 6, RULE_scoped_name = 7, 
		RULE_base_type_spec = 8, RULE_floating_pt_type = 9, RULE_integer_type = 10, 
		RULE_signed_int = 11, RULE_unsigned_int = 12, RULE_declarators = 13, RULE_declarator = 14, 
		RULE_simple_declarator = 15, RULE_array_declarator = 16, RULE_exp_list = 17, 
		RULE_or_expr = 18, RULE_xor_expr = 19, RULE_and_expr = 20, RULE_shift_expr = 21, 
		RULE_add_expr = 22, RULE_mult_expr = 23, RULE_unary_expr = 24, RULE_literal = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"specification", "definition", "module", "type_decl", "struct_type", 
			"member_list", "type_spec", "scoped_name", "base_type_spec", "floating_pt_type", 
			"integer_type", "signed_int", "unsigned_int", "declarators", "declarator", 
			"simple_declarator", "array_declarator", "exp_list", "or_expr", "xor_expr", 
			"and_expr", "shift_expr", "add_expr", "mult_expr", "unary_expr", "literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'module'", "'{'", "'}'", "'struct'", "'::'", "'char'", 
			"'string'", "'boolean'", "'float'", "'double'", "'long double'", "'short'", 
			"'int16'", "'long'", "'int32'", "'long long'", "'int64'", "'int8'", "'unsigned short'", 
			"'uint16'", "'unsigned long'", "'uint32'", "'unsigned long long'", "'uint64'", 
			"'uint8'", "','", "'='", "'['", "']'", "'|'", "'^'", "'&'", "'>>'", "'<<'", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'~'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "INTEGER", "FLOATING_PT", "CHAR", 
			"STRING", "BOOLEAN", "ID", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MIDL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MIDLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SpecificationContext extends ParserRuleContext {
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public SpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitSpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecificationContext specification() throws RecognitionException {
		SpecificationContext _localctx = new SpecificationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(52);
				definition();
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 || _la==T__4 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionContext extends ParserRuleContext {
		public Type_declContext type_decl() {
			return getRuleContext(Type_declContext.class,0);
		}
		public ModuleContext module() {
			return getRuleContext(ModuleContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definition);
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				type_decl();
				setState(58);
				match(T__0);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				module();
				setState(61);
				match(T__0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModuleContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MIDLParser.ID, 0); }
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterModule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitModule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitModule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(T__1);
			setState(66);
			match(ID);
			setState(67);
			match(T__2);
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				definition();
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 || _la==T__4 );
			setState(73);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_declContext extends ParserRuleContext {
		public Struct_typeContext struct_type() {
			return getRuleContext(Struct_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MIDLParser.ID, 0); }
		public Type_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterType_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitType_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitType_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_declContext type_decl() throws RecognitionException {
		Type_declContext _localctx = new Type_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type_decl);
		try {
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				struct_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(T__4);
				setState(77);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Struct_typeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MIDLParser.ID, 0); }
		public Member_listContext member_list() {
			return getRuleContext(Member_listContext.class,0);
		}
		public Struct_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterStruct_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitStruct_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitStruct_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_typeContext struct_type() throws RecognitionException {
		Struct_typeContext _localctx = new Struct_typeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_struct_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__4);
			setState(81);
			match(ID);
			setState(82);
			match(T__2);
			setState(83);
			member_list();
			setState(84);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Member_listContext extends ParserRuleContext {
		public List<Type_specContext> type_spec() {
			return getRuleContexts(Type_specContext.class);
		}
		public Type_specContext type_spec(int i) {
			return getRuleContext(Type_specContext.class,i);
		}
		public List<DeclaratorsContext> declarators() {
			return getRuleContexts(DeclaratorsContext.class);
		}
		public DeclaratorsContext declarators(int i) {
			return getRuleContext(DeclaratorsContext.class,i);
		}
		public Member_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterMember_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitMember_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitMember_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Member_listContext member_list() throws RecognitionException {
		Member_listContext _localctx = new Member_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_member_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << ID))) != 0)) {
				{
				{
				setState(86);
				type_spec();
				setState(87);
				declarators();
				setState(88);
				match(T__0);
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_specContext extends ParserRuleContext {
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Base_type_specContext base_type_spec() {
			return getRuleContext(Base_type_specContext.class,0);
		}
		public Struct_typeContext struct_type() {
			return getRuleContext(Struct_typeContext.class,0);
		}
		public Type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterType_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitType_spec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitType_spec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_specContext type_spec() throws RecognitionException {
		Type_specContext _localctx = new Type_specContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type_spec);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				scoped_name();
				}
				break;
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				base_type_spec();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				struct_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Scoped_nameContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(MIDLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MIDLParser.ID, i);
		}
		public Scoped_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scoped_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterScoped_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitScoped_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitScoped_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Scoped_nameContext scoped_name() throws RecognitionException {
		Scoped_nameContext _localctx = new Scoped_nameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_scoped_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(100);
				match(T__5);
				}
			}

			setState(103);
			match(ID);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(104);
				match(T__5);
				setState(105);
				match(ID);
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_type_specContext extends ParserRuleContext {
		public Floating_pt_typeContext floating_pt_type() {
			return getRuleContext(Floating_pt_typeContext.class,0);
		}
		public Integer_typeContext integer_type() {
			return getRuleContext(Integer_typeContext.class,0);
		}
		public Base_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterBase_type_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitBase_type_spec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitBase_type_spec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Base_type_specContext base_type_spec() throws RecognitionException {
		Base_type_specContext _localctx = new Base_type_specContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_base_type_spec);
		try {
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__10:
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				floating_pt_type();
				}
				break;
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				integer_type();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				match(T__6);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				match(T__7);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(115);
				match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Floating_pt_typeContext extends ParserRuleContext {
		public Floating_pt_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floating_pt_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterFloating_pt_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitFloating_pt_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitFloating_pt_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Floating_pt_typeContext floating_pt_type() throws RecognitionException {
		Floating_pt_typeContext _localctx = new Floating_pt_typeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_floating_pt_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Integer_typeContext extends ParserRuleContext {
		public Signed_intContext signed_int() {
			return getRuleContext(Signed_intContext.class,0);
		}
		public Unsigned_intContext unsigned_int() {
			return getRuleContext(Unsigned_intContext.class,0);
		}
		public Integer_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterInteger_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitInteger_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitInteger_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Integer_typeContext integer_type() throws RecognitionException {
		Integer_typeContext _localctx = new Integer_typeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_integer_type);
		try {
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				signed_int();
				}
				break;
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				unsigned_int();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Signed_intContext extends ParserRuleContext {
		public Signed_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_int; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterSigned_int(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitSigned_int(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitSigned_int(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Signed_intContext signed_int() throws RecognitionException {
		Signed_intContext _localctx = new Signed_intContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_signed_int);
		int _la;
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				_la = _input.LA(1);
				if ( !(_la==T__14 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__16:
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				_la = _input.LA(1);
				if ( !(_la==T__16 || _la==T__17) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 4);
				{
				setState(127);
				match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unsigned_intContext extends ParserRuleContext {
		public Unsigned_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_int; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterUnsigned_int(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitUnsigned_int(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitUnsigned_int(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unsigned_intContext unsigned_int() throws RecognitionException {
		Unsigned_intContext _localctx = new Unsigned_intContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_unsigned_int);
		int _la;
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__21:
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				_la = _input.LA(1);
				if ( !(_la==T__21 || _la==T__22) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__23:
			case T__24:
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				_la = _input.LA(1);
				if ( !(_la==T__23 || _la==T__24) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 4);
				{
				setState(133);
				match(T__25);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaratorsContext extends ParserRuleContext {
		public List<DeclaratorContext> declarator() {
			return getRuleContexts(DeclaratorContext.class);
		}
		public DeclaratorContext declarator(int i) {
			return getRuleContext(DeclaratorContext.class,i);
		}
		public DeclaratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterDeclarators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitDeclarators(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitDeclarators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratorsContext declarators() throws RecognitionException {
		DeclaratorsContext _localctx = new DeclaratorsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_declarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			declarator();
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__26) {
				{
				{
				setState(137);
				match(T__26);
				setState(138);
				declarator();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaratorContext extends ParserRuleContext {
		public Simple_declaratorContext simple_declarator() {
			return getRuleContext(Simple_declaratorContext.class,0);
		}
		public Array_declaratorContext array_declarator() {
			return getRuleContext(Array_declaratorContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_declarator);
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				simple_declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				array_declarator();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_declaratorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MIDLParser.ID, 0); }
		public Or_exprContext or_expr() {
			return getRuleContext(Or_exprContext.class,0);
		}
		public Simple_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterSimple_declarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitSimple_declarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitSimple_declarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_declaratorContext simple_declarator() throws RecognitionException {
		Simple_declaratorContext _localctx = new Simple_declaratorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_simple_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(ID);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__27) {
				{
				setState(149);
				match(T__27);
				setState(150);
				or_expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_declaratorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MIDLParser.ID, 0); }
		public Or_exprContext or_expr() {
			return getRuleContext(Or_exprContext.class,0);
		}
		public Exp_listContext exp_list() {
			return getRuleContext(Exp_listContext.class,0);
		}
		public Array_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterArray_declarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitArray_declarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitArray_declarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_declaratorContext array_declarator() throws RecognitionException {
		Array_declaratorContext _localctx = new Array_declaratorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_array_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(ID);
			setState(154);
			match(T__28);
			setState(155);
			or_expr();
			setState(156);
			match(T__29);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__27) {
				{
				setState(157);
				match(T__27);
				setState(158);
				exp_list();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exp_listContext extends ParserRuleContext {
		public List<Or_exprContext> or_expr() {
			return getRuleContexts(Or_exprContext.class);
		}
		public Or_exprContext or_expr(int i) {
			return getRuleContext(Or_exprContext.class,i);
		}
		public Exp_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterExp_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitExp_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitExp_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_listContext exp_list() throws RecognitionException {
		Exp_listContext _localctx = new Exp_listContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_exp_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(T__28);
			setState(162);
			or_expr();
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__26) {
				{
				{
				setState(163);
				match(T__26);
				setState(164);
				or_expr();
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
			match(T__29);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Or_exprContext extends ParserRuleContext {
		public List<Xor_exprContext> xor_expr() {
			return getRuleContexts(Xor_exprContext.class);
		}
		public Xor_exprContext xor_expr(int i) {
			return getRuleContext(Xor_exprContext.class,i);
		}
		public Or_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterOr_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitOr_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitOr_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Or_exprContext or_expr() throws RecognitionException {
		Or_exprContext _localctx = new Or_exprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_or_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			xor_expr();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__30) {
				{
				{
				setState(173);
				match(T__30);
				setState(174);
				xor_expr();
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Xor_exprContext extends ParserRuleContext {
		public List<And_exprContext> and_expr() {
			return getRuleContexts(And_exprContext.class);
		}
		public And_exprContext and_expr(int i) {
			return getRuleContext(And_exprContext.class,i);
		}
		public Xor_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xor_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterXor_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitXor_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitXor_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Xor_exprContext xor_expr() throws RecognitionException {
		Xor_exprContext _localctx = new Xor_exprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_xor_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			and_expr();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__31) {
				{
				{
				setState(181);
				match(T__31);
				setState(182);
				and_expr();
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class And_exprContext extends ParserRuleContext {
		public List<Shift_exprContext> shift_expr() {
			return getRuleContexts(Shift_exprContext.class);
		}
		public Shift_exprContext shift_expr(int i) {
			return getRuleContext(Shift_exprContext.class,i);
		}
		public And_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterAnd_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitAnd_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitAnd_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final And_exprContext and_expr() throws RecognitionException {
		And_exprContext _localctx = new And_exprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_and_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			shift_expr();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__32) {
				{
				{
				setState(189);
				match(T__32);
				setState(190);
				shift_expr();
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Shift_exprContext extends ParserRuleContext {
		public List<Add_exprContext> add_expr() {
			return getRuleContexts(Add_exprContext.class);
		}
		public Add_exprContext add_expr(int i) {
			return getRuleContext(Add_exprContext.class,i);
		}
		public Shift_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterShift_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitShift_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitShift_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shift_exprContext shift_expr() throws RecognitionException {
		Shift_exprContext _localctx = new Shift_exprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_shift_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			add_expr();
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__33 || _la==T__34) {
				{
				{
				setState(197);
				_la = _input.LA(1);
				if ( !(_la==T__33 || _la==T__34) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(198);
				add_expr();
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Add_exprContext extends ParserRuleContext {
		public List<Mult_exprContext> mult_expr() {
			return getRuleContexts(Mult_exprContext.class);
		}
		public Mult_exprContext mult_expr(int i) {
			return getRuleContext(Mult_exprContext.class,i);
		}
		public Add_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterAdd_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitAdd_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitAdd_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Add_exprContext add_expr() throws RecognitionException {
		Add_exprContext _localctx = new Add_exprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_add_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			mult_expr();
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__35 || _la==T__36) {
				{
				{
				setState(205);
				_la = _input.LA(1);
				if ( !(_la==T__35 || _la==T__36) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(206);
				mult_expr();
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mult_exprContext extends ParserRuleContext {
		public List<Unary_exprContext> unary_expr() {
			return getRuleContexts(Unary_exprContext.class);
		}
		public Unary_exprContext unary_expr(int i) {
			return getRuleContext(Unary_exprContext.class,i);
		}
		public Mult_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterMult_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitMult_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitMult_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mult_exprContext mult_expr() throws RecognitionException {
		Mult_exprContext _localctx = new Mult_exprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_mult_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			unary_expr();
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) {
				{
				{
				setState(213);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(214);
				unary_expr();
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_exprContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Unary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterUnary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitUnary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitUnary_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_exprContext unary_expr() throws RecognitionException {
		Unary_exprContext _localctx = new Unary_exprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_unary_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__40))) != 0)) {
				{
				setState(220);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__40))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(223);
			literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(MIDLParser.INTEGER, 0); }
		public TerminalNode FLOATING_PT() { return getToken(MIDLParser.FLOATING_PT, 0); }
		public TerminalNode CHAR() { return getToken(MIDLParser.CHAR, 0); }
		public TerminalNode STRING() { return getToken(MIDLParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(MIDLParser.BOOLEAN, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLListener ) ((MIDLListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLVisitor ) return ((MIDLVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOATING_PT) | (1L << CHAR) | (1L << STRING) | (1L << BOOLEAN))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\62\u00e6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\6\28\n\2\r\2\16\29\3\3\3\3\3\3\3\3\3\3\3\3\5"+
		"\3B\n\3\3\4\3\4\3\4\3\4\6\4H\n\4\r\4\16\4I\3\4\3\4\3\5\3\5\3\5\5\5Q\n"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7]\n\7\f\7\16\7`\13\7\3\b"+
		"\3\b\3\b\5\be\n\b\3\t\5\th\n\t\3\t\3\t\3\t\7\tm\n\t\f\t\16\tp\13\t\3\n"+
		"\3\n\3\n\3\n\3\n\5\nw\n\n\3\13\3\13\3\f\3\f\5\f}\n\f\3\r\3\r\3\r\3\r\5"+
		"\r\u0083\n\r\3\16\3\16\3\16\3\16\5\16\u0089\n\16\3\17\3\17\3\17\7\17\u008e"+
		"\n\17\f\17\16\17\u0091\13\17\3\20\3\20\5\20\u0095\n\20\3\21\3\21\3\21"+
		"\5\21\u009a\n\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00a2\n\22\3\23\3"+
		"\23\3\23\3\23\7\23\u00a8\n\23\f\23\16\23\u00ab\13\23\3\23\3\23\3\24\3"+
		"\24\3\24\7\24\u00b2\n\24\f\24\16\24\u00b5\13\24\3\25\3\25\3\25\7\25\u00ba"+
		"\n\25\f\25\16\25\u00bd\13\25\3\26\3\26\3\26\7\26\u00c2\n\26\f\26\16\26"+
		"\u00c5\13\26\3\27\3\27\3\27\7\27\u00ca\n\27\f\27\16\27\u00cd\13\27\3\30"+
		"\3\30\3\30\7\30\u00d2\n\30\f\30\16\30\u00d5\13\30\3\31\3\31\3\31\7\31"+
		"\u00da\n\31\f\31\16\31\u00dd\13\31\3\32\5\32\u00e0\n\32\3\32\3\32\3\33"+
		"\3\33\3\33\2\2\34\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\2\16\3\2\f\16\3\2\17\20\3\2\21\22\3\2\23\24\3\2\26\27\3\2\30\31\3"+
		"\2\32\33\3\2$%\3\2&\'\3\2(*\4\2&\'++\3\2,\60\2\u00eb\2\67\3\2\2\2\4A\3"+
		"\2\2\2\6C\3\2\2\2\bP\3\2\2\2\nR\3\2\2\2\f^\3\2\2\2\16d\3\2\2\2\20g\3\2"+
		"\2\2\22v\3\2\2\2\24x\3\2\2\2\26|\3\2\2\2\30\u0082\3\2\2\2\32\u0088\3\2"+
		"\2\2\34\u008a\3\2\2\2\36\u0094\3\2\2\2 \u0096\3\2\2\2\"\u009b\3\2\2\2"+
		"$\u00a3\3\2\2\2&\u00ae\3\2\2\2(\u00b6\3\2\2\2*\u00be\3\2\2\2,\u00c6\3"+
		"\2\2\2.\u00ce\3\2\2\2\60\u00d6\3\2\2\2\62\u00df\3\2\2\2\64\u00e3\3\2\2"+
		"\2\668\5\4\3\2\67\66\3\2\2\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:\3\3\2\2"+
		"\2;<\5\b\5\2<=\7\3\2\2=B\3\2\2\2>?\5\6\4\2?@\7\3\2\2@B\3\2\2\2A;\3\2\2"+
		"\2A>\3\2\2\2B\5\3\2\2\2CD\7\4\2\2DE\7\61\2\2EG\7\5\2\2FH\5\4\3\2GF\3\2"+
		"\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7\6\2\2L\7\3\2\2\2MQ\5"+
		"\n\6\2NO\7\7\2\2OQ\7\61\2\2PM\3\2\2\2PN\3\2\2\2Q\t\3\2\2\2RS\7\7\2\2S"+
		"T\7\61\2\2TU\7\5\2\2UV\5\f\7\2VW\7\6\2\2W\13\3\2\2\2XY\5\16\b\2YZ\5\34"+
		"\17\2Z[\7\3\2\2[]\3\2\2\2\\X\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\r"+
		"\3\2\2\2`^\3\2\2\2ae\5\20\t\2be\5\22\n\2ce\5\n\6\2da\3\2\2\2db\3\2\2\2"+
		"dc\3\2\2\2e\17\3\2\2\2fh\7\b\2\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2\2in\7\61"+
		"\2\2jk\7\b\2\2km\7\61\2\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\21"+
		"\3\2\2\2pn\3\2\2\2qw\5\24\13\2rw\5\26\f\2sw\7\t\2\2tw\7\n\2\2uw\7\13\2"+
		"\2vq\3\2\2\2vr\3\2\2\2vs\3\2\2\2vt\3\2\2\2vu\3\2\2\2w\23\3\2\2\2xy\t\2"+
		"\2\2y\25\3\2\2\2z}\5\30\r\2{}\5\32\16\2|z\3\2\2\2|{\3\2\2\2}\27\3\2\2"+
		"\2~\u0083\t\3\2\2\177\u0083\t\4\2\2\u0080\u0083\t\5\2\2\u0081\u0083\7"+
		"\25\2\2\u0082~\3\2\2\2\u0082\177\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0081"+
		"\3\2\2\2\u0083\31\3\2\2\2\u0084\u0089\t\6\2\2\u0085\u0089\t\7\2\2\u0086"+
		"\u0089\t\b\2\2\u0087\u0089\7\34\2\2\u0088\u0084\3\2\2\2\u0088\u0085\3"+
		"\2\2\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\33\3\2\2\2\u008a"+
		"\u008f\5\36\20\2\u008b\u008c\7\35\2\2\u008c\u008e\5\36\20\2\u008d\u008b"+
		"\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\35\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0095\5 \21\2\u0093\u0095\5\"\22"+
		"\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\37\3\2\2\2\u0096\u0099"+
		"\7\61\2\2\u0097\u0098\7\36\2\2\u0098\u009a\5&\24\2\u0099\u0097\3\2\2\2"+
		"\u0099\u009a\3\2\2\2\u009a!\3\2\2\2\u009b\u009c\7\61\2\2\u009c\u009d\7"+
		"\37\2\2\u009d\u009e\5&\24\2\u009e\u00a1\7 \2\2\u009f\u00a0\7\36\2\2\u00a0"+
		"\u00a2\5$\23\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2#\3\2\2\2"+
		"\u00a3\u00a4\7\37\2\2\u00a4\u00a9\5&\24\2\u00a5\u00a6\7\35\2\2\u00a6\u00a8"+
		"\5&\24\2\u00a7\u00a5\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\7 "+
		"\2\2\u00ad%\3\2\2\2\u00ae\u00b3\5(\25\2\u00af\u00b0\7!\2\2\u00b0\u00b2"+
		"\5(\25\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\'\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00bb\5*\26\2"+
		"\u00b7\u00b8\7\"\2\2\u00b8\u00ba\5*\26\2\u00b9\u00b7\3\2\2\2\u00ba\u00bd"+
		"\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc)\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00be\u00c3\5,\27\2\u00bf\u00c0\7#\2\2\u00c0\u00c2\5,\27"+
		"\2\u00c1\u00bf\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4"+
		"\3\2\2\2\u00c4+\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00cb\5.\30\2\u00c7"+
		"\u00c8\t\t\2\2\u00c8\u00ca\5.\30\2\u00c9\u00c7\3\2\2\2\u00ca\u00cd\3\2"+
		"\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc-\3\2\2\2\u00cd\u00cb"+
		"\3\2\2\2\u00ce\u00d3\5\60\31\2\u00cf\u00d0\t\n\2\2\u00d0\u00d2\5\60\31"+
		"\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4"+
		"\3\2\2\2\u00d4/\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00db\5\62\32\2\u00d7"+
		"\u00d8\t\13\2\2\u00d8\u00da\5\62\32\2\u00d9\u00d7\3\2\2\2\u00da\u00dd"+
		"\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\61\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00de\u00e0\t\f\2\2\u00df\u00de\3\2\2\2\u00df\u00e0\3\2"+
		"\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\5\64\33\2\u00e2\63\3\2\2\2\u00e3"+
		"\u00e4\t\r\2\2\u00e4\65\3\2\2\2\329AIP^dgnv|\u0082\u0088\u008f\u0094\u0099"+
		"\u00a1\u00a9\u00b3\u00bb\u00c3\u00cb\u00d3\u00db\u00df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}