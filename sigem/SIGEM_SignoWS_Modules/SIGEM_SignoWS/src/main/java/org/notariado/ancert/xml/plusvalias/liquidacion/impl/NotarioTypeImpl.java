//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v@@BUILD_VERSION@@ 
// 	See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 	Any modifications to this file will be lost upon recompilation of the source schema. 
// 	Generated on: 2011.07.04 en 12:38:50 CEST 
//


package org.notariado.ancert.xml.plusvalias.liquidacion.impl;

public class NotarioTypeImpl implements org.notariado.ancert.xml.plusvalias.liquidacion.NotarioType, com.sun.xml.bind.JAXBObject, org.notariado.ancert.xml.plusvalias.liquidacion.impl.runtime.UnmarshallableObject, org.notariado.ancert.xml.plusvalias.liquidacion.impl.runtime.XMLSerializable, org.notariado.ancert.xml.plusvalias.liquidacion.impl.runtime.ValidatableObject
{

    protected java.lang.String _APELLIDO2;
    protected java.lang.String _NOMBRE;
    protected java.lang.String _CODIGO;
    protected java.lang.String _APELLIDO1;
    public final static java.lang.Class version = (org.notariado.ancert.xml.plusvalias.liquidacion.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (org.notariado.ancert.xml.plusvalias.liquidacion.NotarioType.class);
    }

    public java.lang.String getAPELLIDO2() {
        return _APELLIDO2;
    }

    public void setAPELLIDO2(java.lang.String value) {
        _APELLIDO2 = value;
    }

    public java.lang.String getNOMBRE() {
        return _NOMBRE;
    }

    public void setNOMBRE(java.lang.String value) {
        _NOMBRE = value;
    }

    public java.lang.String getCODIGO() {
        return _CODIGO;
    }

    public void setCODIGO(java.lang.String value) {
        _CODIGO = value;
    }

    public java.lang.String getAPELLIDO1() {
        return _APELLIDO1;
    }

    public void setAPELLIDO1(java.lang.String value) {
        _APELLIDO1 = value;
    }

    public org.notariado.ancert.xml.plusvalias.liquidacion.impl.runtime.UnmarshallingEventHandler createUnmarshaller(org.notariado.ancert.xml.plusvalias.liquidacion.impl.runtime.UnmarshallingContext context) {
        return new org.notariado.ancert.xml.plusvalias.liquidacion.impl.NotarioTypeImpl.Unmarshaller(context);
    }

    public void serializeBody(org.notariado.ancert.xml.plusvalias.liquidacion.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        context.startElement("http://ancert.notariado.org/XML/Plusvalias/Liquidacion", "CODIGO");
        context.endNamespaceDecls();
        context.endAttributes();
        try {
            context.text(((java.lang.String) _CODIGO), "CODIGO");
        } catch (java.lang.Exception e) {
            org.notariado.ancert.xml.plusvalias.liquidacion.impl.runtime.Util.handlePrintConversionException(this, e, context);
        }
        context.endElement();
        context.startElement("http://ancert.notariado.org/XML/Plusvalias/Liquidacion", "NOMBRE");
        context.endNamespaceDecls();
        context.endAttributes();
        try {
            context.text(((java.lang.String) _NOMBRE), "NOMBRE");
        } catch (java.lang.Exception e) {
            org.notariado.ancert.xml.plusvalias.liquidacion.impl.runtime.Util.handlePrintConversionException(this, e, context);
        }
        context.endElement();
        context.startElement("http://ancert.notariado.org/XML/Plusvalias/Liquidacion", "APELLIDO1");
        context.endNamespaceDecls();
        context.endAttributes();
        try {
            context.text(((java.lang.String) _APELLIDO1), "APELLIDO1");
        } catch (java.lang.Exception e) {
            org.notariado.ancert.xml.plusvalias.liquidacion.impl.runtime.Util.handlePrintConversionException(this, e, context);
        }
        context.endElement();
        if (_APELLIDO2 != null) {
            context.startElement("http://ancert.notariado.org/XML/Plusvalias/Liquidacion", "APELLIDO2");
            context.endNamespaceDecls();
            context.endAttributes();
            try {
                context.text(((java.lang.String) _APELLIDO2), "APELLIDO2");
            } catch (java.lang.Exception e) {
                org.notariado.ancert.xml.plusvalias.liquidacion.impl.runtime.Util.handlePrintConversionException(this, e, context);
            }
            context.endElement();
        }
    }

    public void serializeAttributes(org.notariado.ancert.xml.plusvalias.liquidacion.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
    }

    public void serializeURIs(org.notariado.ancert.xml.plusvalias.liquidacion.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
    }

    public java.lang.Class getPrimaryInterface() {
        return (org.notariado.ancert.xml.plusvalias.liquidacion.NotarioType.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.su"
+"n.msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1t\u0000 Lcom/sun/msv/gra"
+"mmar/Expression;L\u0000\u0004exp2q\u0000~\u0000\u0002xr\u0000\u001ecom.sun.msv.grammar.Expressi"
+"on\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0002L\u0000\u0013epsilonReducibilityt\u0000\u0013Ljava/lang/Boolean;L\u0000\u000b"
+"expandedExpq\u0000~\u0000\u0002xpppsq\u0000~\u0000\u0000ppsq\u0000~\u0000\u0000ppsr\u0000\'com.sun.msv.grammar."
+"trex.ElementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\tnameClasst\u0000\u001fLcom/sun/msv/gr"
+"ammar/NameClass;xr\u0000\u001ecom.sun.msv.grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000"
+"\u0002Z\u0000\u001aignoreUndeclaredAttributesL\u0000\fcontentModelq\u0000~\u0000\u0002xq\u0000~\u0000\u0003pp\u0000s"
+"q\u0000~\u0000\u0000ppsr\u0000\u001bcom.sun.msv.grammar.DataExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002dtt\u0000\u001fLor"
+"g/relaxng/datatype/Datatype;L\u0000\u0006exceptq\u0000~\u0000\u0002L\u0000\u0004namet\u0000\u001dLcom/sun"
+"/msv/util/StringPair;xq\u0000~\u0000\u0003ppsr\u0000%com.sun.msv.datatype.xsd.Pa"
+"tternFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001[\u0000\bpatternst\u0000\u0013[Ljava/lang/String;xr\u0000;co"
+"m.sun.msv.datatype.xsd.DataTypeWithLexicalConstraintFacetT\u0090\u001c"
+">\u001azb\u00ea\u0002\u0000\u0000xr\u0000*com.sun.msv.datatype.xsd.DataTypeWithFacet\u0000\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0001\u0002\u0000\u0005Z\u0000\fisFacetFixedZ\u0000\u0012needValueCheckFlagL\u0000\bbaseTypet\u0000)Lcom/"
+"sun/msv/datatype/xsd/XSDatatypeImpl;L\u0000\fconcreteTypet\u0000\'Lcom/s"
+"un/msv/datatype/xsd/ConcreteType;L\u0000\tfacetNamet\u0000\u0012Ljava/lang/S"
+"tring;xr\u0000\'com.sun.msv.datatype.xsd.XSDatatypeImpl\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003"
+"L\u0000\fnamespaceUriq\u0000~\u0000\u0017L\u0000\btypeNameq\u0000~\u0000\u0017L\u0000\nwhiteSpacet\u0000.Lcom/sun"
+"/msv/datatype/xsd/WhiteSpaceProcessor;xpt\u00006http://ancert.not"
+"ariado.org/XML/Plusvalias/Liquidaciont\u0000\u0012CODIGO_NOTARIOTypesr"
+"\u00005com.sun.msv.datatype.xsd.WhiteSpaceProcessor$Preserve\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000,com.sun.msv.datatype.xsd.WhiteSpaceProcessor\u0000\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0001\u0002\u0000\u0000xp\u0000\u0000sr\u0000#com.sun.msv.datatype.xsd.StringType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001Z"
+"\u0000\risAlwaysValidxr\u0000*com.sun.msv.datatype.xsd.BuiltinAtomicTyp"
+"e\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv.datatype.xsd.ConcreteType\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
+"\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0018t\u0000 http://www.w3.org/2001/XMLSchemat\u0000\u0006stringq\u0000~\u0000\u001f\u0001"
+"q\u0000~\u0000#t\u0000\u0007patternur\u0000\u0013[Ljava.lang.String;\u00ad\u00d2V\u00e7\u00e9\u001d{G\u0002\u0000\u0000xp\u0000\u0000\u0000\u0001t\u0000\b[0"
+"-9]{7}sr\u00000com.sun.msv.grammar.Expression$NullSetExpression\u0000\u0000"
+"\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003sr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000ps"
+"r\u0000\u001bcom.sun.msv.util.StringPair\u00d0t\u001ejB\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u0017L\u0000"
+"\fnamespaceURIq\u0000~\u0000\u0017xpq\u0000~\u0000\u001cq\u0000~\u0000\u001bsr\u0000\u001dcom.sun.msv.grammar.Choice"
+"Exp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0001ppsr\u0000 com.sun.msv.grammar.AttributeExp\u0000\u0000"
+"\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0002L\u0000\tnameClassq\u0000~\u0000\txq\u0000~\u0000\u0003q\u0000~\u0000-psq\u0000~\u0000\rppsr\u0000"
+"\"com.sun.msv.datatype.xsd.QnameType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000!q\u0000~\u0000$t\u0000\u0005"
+"QNamesr\u00005com.sun.msv.datatype.xsd.WhiteSpaceProcessor$Collap"
+"se\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u001eq\u0000~\u0000+sq\u0000~\u0000.q\u0000~\u00007q\u0000~\u0000$sr\u0000#com.sun.msv.gram"
+"mar.SimpleNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u0017L\u0000\fnamespaceU"
+"RIq\u0000~\u0000\u0017xr\u0000\u001dcom.sun.msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpt\u0000\u0004type"
+"t\u0000)http://www.w3.org/2001/XMLSchema-instancesr\u00000com.sun.msv."
+"grammar.Expression$EpsilonExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003sq\u0000~\u0000,\u0001"
+"q\u0000~\u0000Asq\u0000~\u0000;t\u0000\u0006CODIGOq\u0000~\u0000\u001bsq\u0000~\u0000\bpp\u0000sq\u0000~\u0000\u0000ppsq\u0000~\u0000\rppsr\u0000\'com.su"
+"n.msv.datatype.xsd.MaxLengthFacet\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001I\u0000\tmaxLengthxr\u00009"
+"com.sun.msv.datatype.xsd.DataTypeWithValueConstraintFacet\"\u00a7R"
+"o\u00ca\u00c7\u008aT\u0002\u0000\u0000xq\u0000~\u0000\u0014q\u0000~\u0000\u001bt\u0000\u0012NOMBRE_NOTARIOTypeq\u0000~\u0000\u001f\u0000\u0000sq\u0000~\u0000\u0011q\u0000~\u0000\u001bt\u0000"
+"\nSTRINGTypeq\u0000~\u0000\u001f\u0000\u0000q\u0000~\u0000#q\u0000~\u0000#q\u0000~\u0000&uq\u0000~\u0000\'\u0000\u0000\u0000\u0001t\u0000\n[^\\r\\n\\t]*q\u0000~\u0000"
+"#t\u0000\tmaxLength\u0000\u0000\u0000Aq\u0000~\u0000+sq\u0000~\u0000.q\u0000~\u0000Kq\u0000~\u0000\u001bsq\u0000~\u00000ppsq\u0000~\u00002q\u0000~\u0000-pq\u0000"
+"~\u00004q\u0000~\u0000=q\u0000~\u0000Asq\u0000~\u0000;t\u0000\u0006NOMBREq\u0000~\u0000\u001bsq\u0000~\u0000\bpp\u0000sq\u0000~\u0000\u0000ppsq\u0000~\u0000\rppsq"
+"\u0000~\u0000Hq\u0000~\u0000\u001bt\u0000\u0015APELLIDOS_NOTARIOTypeq\u0000~\u0000\u001f\u0000\u0000q\u0000~\u0000Lq\u0000~\u0000#q\u0000~\u0000P\u0000\u0000\u00002q"
+"\u0000~\u0000+sq\u0000~\u0000.q\u0000~\u0000Zq\u0000~\u0000\u001bsq\u0000~\u00000ppsq\u0000~\u00002q\u0000~\u0000-pq\u0000~\u00004q\u0000~\u0000=q\u0000~\u0000Asq\u0000~\u0000"
+";t\u0000\tAPELLIDO1q\u0000~\u0000\u001bsq\u0000~\u00000ppsq\u0000~\u0000\bq\u0000~\u0000-p\u0000sq\u0000~\u0000\u0000ppq\u0000~\u0000Xsq\u0000~\u00000pp"
+"sq\u0000~\u00002q\u0000~\u0000-pq\u0000~\u00004q\u0000~\u0000=q\u0000~\u0000Asq\u0000~\u0000;t\u0000\tAPELLIDO2q\u0000~\u0000\u001bq\u0000~\u0000Asr\u0000\"c"
+"om.sun.msv.grammar.ExpressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lc"
+"om/sun/msv/grammar/ExpressionPool$ClosedHash;xpsr\u0000-com.sun.m"
+"sv.grammar.ExpressionPool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0003\u0000\u0003I\u0000\u0005countB\u0000\rst"
+"reamVersionL\u0000\u0006parentt\u0000$Lcom/sun/msv/grammar/ExpressionPool;x"
+"p\u0000\u0000\u0000\f\u0001pq\u0000~\u0000Wq\u0000~\u0000bq\u0000~\u0000`q\u0000~\u0000\fq\u0000~\u0000\u0005q\u0000~\u0000\u0007q\u0000~\u0000\u0006q\u0000~\u00001q\u0000~\u0000Rq\u0000~\u0000\\q\u0000~"
+"\u0000cq\u0000~\u0000Fx"));
        }
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends org.notariado.ancert.xml.plusvalias.liquidacion.impl.runtime.AbstractUnmarshallingEventHandlerImpl
    {


        public Unmarshaller(org.notariado.ancert.xml.plusvalias.liquidacion.impl.runtime.UnmarshallingContext context) {
            super(context, "-------------");
        }

        protected Unmarshaller(org.notariado.ancert.xml.plusvalias.liquidacion.impl.runtime.UnmarshallingContext context, int startState) {
            this(context);
            state = startState;
        }

        public java.lang.Object owner() {
            return org.notariado.ancert.xml.plusvalias.liquidacion.impl.NotarioTypeImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname, org.xml.sax.Attributes __atts)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  0 :
                        if (("CODIGO" == ___local)&&("http://ancert.notariado.org/XML/Plusvalias/Liquidacion" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 1;
                            return ;
                        }
                        break;
                    case  3 :
                        if (("NOMBRE" == ___local)&&("http://ancert.notariado.org/XML/Plusvalias/Liquidacion" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 4;
                            return ;
                        }
                        break;
                    case  6 :
                        if (("APELLIDO1" == ___local)&&("http://ancert.notariado.org/XML/Plusvalias/Liquidacion" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 7;
                            return ;
                        }
                        break;
                    case  12 :
                        revertToParentFromEnterElement(___uri, ___local, ___qname, __atts);
                        return ;
                    case  9 :
                        if (("APELLIDO2" == ___local)&&("http://ancert.notariado.org/XML/Plusvalias/Liquidacion" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 10;
                            return ;
                        }
                        state = 12;
                        continue outer;
                }
                super.enterElement(___uri, ___local, ___qname, __atts);
                break;
            }
        }

        public void leaveElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  8 :
                        if (("APELLIDO1" == ___local)&&("http://ancert.notariado.org/XML/Plusvalias/Liquidacion" == ___uri)) {
                            context.popAttributes();
                            state = 9;
                            return ;
                        }
                        break;
                    case  11 :
                        if (("APELLIDO2" == ___local)&&("http://ancert.notariado.org/XML/Plusvalias/Liquidacion" == ___uri)) {
                            context.popAttributes();
                            state = 12;
                            return ;
                        }
                        break;
                    case  2 :
                        if (("CODIGO" == ___local)&&("http://ancert.notariado.org/XML/Plusvalias/Liquidacion" == ___uri)) {
                            context.popAttributes();
                            state = 3;
                            return ;
                        }
                        break;
                    case  5 :
                        if (("NOMBRE" == ___local)&&("http://ancert.notariado.org/XML/Plusvalias/Liquidacion" == ___uri)) {
                            context.popAttributes();
                            state = 6;
                            return ;
                        }
                        break;
                    case  12 :
                        revertToParentFromLeaveElement(___uri, ___local, ___qname);
                        return ;
                    case  9 :
                        state = 12;
                        continue outer;
                }
                super.leaveElement(___uri, ___local, ___qname);
                break;
            }
        }

        public void enterAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  12 :
                        revertToParentFromEnterAttribute(___uri, ___local, ___qname);
                        return ;
                    case  9 :
                        state = 12;
                        continue outer;
                }
                super.enterAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void leaveAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  12 :
                        revertToParentFromLeaveAttribute(___uri, ___local, ___qname);
                        return ;
                    case  9 :
                        state = 12;
                        continue outer;
                }
                super.leaveAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void handleText(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                try {
                    switch (state) {
                        case  1 :
                            eatText1(value);
                            state = 2;
                            return ;
                        case  7 :
                            eatText2(value);
                            state = 8;
                            return ;
                        case  12 :
                            revertToParentFromText(value);
                            return ;
                        case  9 :
                            state = 12;
                            continue outer;
                        case  10 :
                            eatText3(value);
                            state = 11;
                            return ;
                        case  4 :
                            eatText4(value);
                            state = 5;
                            return ;
                    }
                } catch (java.lang.RuntimeException e) {
                    handleUnexpectedTextException(value, e);
                }
                break;
            }
        }

        private void eatText1(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _CODIGO = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText2(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _APELLIDO1 = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText3(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _APELLIDO2 = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText4(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _NOMBRE = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

    }

}
