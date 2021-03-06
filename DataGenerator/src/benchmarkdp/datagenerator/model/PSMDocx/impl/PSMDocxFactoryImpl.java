/**
 */
package benchmarkdp.datagenerator.model.PSMDocx.impl;

import benchmarkdp.datagenerator.model.PSMDocx.Alignment;
import benchmarkdp.datagenerator.model.PSMDocx.Cell;
import benchmarkdp.datagenerator.model.PSMDocx.Color;
import benchmarkdp.datagenerator.model.PSMDocx.ControlBox;
import benchmarkdp.datagenerator.model.PSMDocx.Document;
import benchmarkdp.datagenerator.model.PSMDocx.EmbeddedExcel;
import benchmarkdp.datagenerator.model.PSMDocx.FontFamily;
import benchmarkdp.datagenerator.model.PSMDocx.HyperLink;
import benchmarkdp.datagenerator.model.PSMDocx.Image;
import benchmarkdp.datagenerator.model.PSMDocx.PSMDocxFactory;
import benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage;
import benchmarkdp.datagenerator.model.PSMDocx.Page;
import benchmarkdp.datagenerator.model.PSMDocx.Paragraph;
import benchmarkdp.datagenerator.model.PSMDocx.Row;
import benchmarkdp.datagenerator.model.PSMDocx.SimpleText;
import benchmarkdp.datagenerator.model.PSMDocx.TableType;
import benchmarkdp.datagenerator.model.PSMDocx.TextBox;
import benchmarkdp.datagenerator.model.PSMDocx.WordTable;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PSMDocxFactoryImpl extends EFactoryImpl implements PSMDocxFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PSMDocxFactory init() {
		try {
			PSMDocxFactory thePSMDocxFactory = (PSMDocxFactory)EPackage.Registry.INSTANCE.getEFactory(PSMDocxPackage.eNS_URI);
			if (thePSMDocxFactory != null) {
				return thePSMDocxFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PSMDocxFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PSMDocxFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PSMDocxPackage.DOCUMENT: return createDocument();
			case PSMDocxPackage.PAGE: return createPage();
			case PSMDocxPackage.TEXT_BOX: return createTextBox();
			case PSMDocxPackage.PARAGRAPH: return createParagraph();
			case PSMDocxPackage.CONTROL_BOX: return createControlBox();
			case PSMDocxPackage.SIMPLE_TEXT: return createSimpleText();
			case PSMDocxPackage.HYPER_LINK: return createHyperLink();
			case PSMDocxPackage.ROW: return createRow();
			case PSMDocxPackage.CELL: return createCell();
			case PSMDocxPackage.IMAGE: return createImage();
			case PSMDocxPackage.EMBEDDED_EXCEL: return createEmbeddedExcel();
			case PSMDocxPackage.WORD_TABLE: return createWordTable();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case PSMDocxPackage.FONT_FAMILY:
				return createFontFamilyFromString(eDataType, initialValue);
			case PSMDocxPackage.COLOR:
				return createColorFromString(eDataType, initialValue);
			case PSMDocxPackage.ALIGNMENT:
				return createAlignmentFromString(eDataType, initialValue);
			case PSMDocxPackage.TABLE_TYPE:
				return createTableTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case PSMDocxPackage.FONT_FAMILY:
				return convertFontFamilyToString(eDataType, instanceValue);
			case PSMDocxPackage.COLOR:
				return convertColorToString(eDataType, instanceValue);
			case PSMDocxPackage.ALIGNMENT:
				return convertAlignmentToString(eDataType, instanceValue);
			case PSMDocxPackage.TABLE_TYPE:
				return convertTableTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Document createDocument() {
		DocumentImpl document = new DocumentImpl();
		return document;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Page createPage() {
		PageImpl page = new PageImpl();
		return page;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextBox createTextBox() {
		TextBoxImpl textBox = new TextBoxImpl();
		return textBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Paragraph createParagraph() {
		ParagraphImpl paragraph = new ParagraphImpl();
		return paragraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlBox createControlBox() {
		ControlBoxImpl controlBox = new ControlBoxImpl();
		return controlBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleText createSimpleText() {
		SimpleTextImpl simpleText = new SimpleTextImpl();
		return simpleText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyperLink createHyperLink() {
		HyperLinkImpl hyperLink = new HyperLinkImpl();
		return hyperLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Row createRow() {
		RowImpl row = new RowImpl();
		return row;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Cell createCell() {
		CellImpl cell = new CellImpl();
		return cell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Image createImage() {
		ImageImpl image = new ImageImpl();
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmbeddedExcel createEmbeddedExcel() {
		EmbeddedExcelImpl embeddedExcel = new EmbeddedExcelImpl();
		return embeddedExcel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WordTable createWordTable() {
		WordTableImpl wordTable = new WordTableImpl();
		return wordTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontFamily createFontFamilyFromString(EDataType eDataType, String initialValue) {
		FontFamily result = FontFamily.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFontFamilyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color createColorFromString(EDataType eDataType, String initialValue) {
		Color result = Color.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertColorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alignment createAlignmentFromString(EDataType eDataType, String initialValue) {
		Alignment result = Alignment.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAlignmentToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableType createTableTypeFromString(EDataType eDataType, String initialValue) {
		TableType result = TableType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTableTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PSMDocxPackage getPSMDocxPackage() {
		return (PSMDocxPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PSMDocxPackage getPackage() {
		return PSMDocxPackage.eINSTANCE;
	}

} //PSMDocxFactoryImpl
