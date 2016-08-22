/**
 */
package benchmarkdp.datagenerator.model.PSMDoc;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see benchmarkdp.datagenerator.model.PSMDoc.PSMDocFactory
 * @model kind="package"
 * @generated
 */
public interface PSMDocPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PSMDoc";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://benchmarkdp.datagenerator.model.PSMDoc";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "benchmarkdp.datagenerator.model.PSMDoc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PSMDocPackage eINSTANCE = benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl.init();

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.DocumentImpl <em>Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.DocumentImpl
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getDocument()
	 * @generated
	 */
	int DOCUMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__AUTHOR = 1;

	/**
	 * The feature id for the '<em><b>Num Colum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__NUM_COLUM = 2;

	/**
	 * The feature id for the '<em><b>Document Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__DOCUMENT_FORMAT = 3;

	/**
	 * The feature id for the '<em><b>Document Format Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__DOCUMENT_FORMAT_CODE = 4;

	/**
	 * The feature id for the '<em><b>Pages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__PAGES = 5;

	/**
	 * The feature id for the '<em><b>Document Platform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__DOCUMENT_PLATFORM = 6;

	/**
	 * The number of structural features of the '<em>Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.PageImpl <em>Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PageImpl
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getPage()
	 * @generated
	 */
	int PAGE = 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__ELEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.ElementImpl
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 2;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.TextContainerImpl <em>Text Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.TextContainerImpl
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getTextContainer()
	 * @generated
	 */
	int TEXT_CONTAINER = 3;

	/**
	 * The feature id for the '<em><b>Words</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_CONTAINER__WORDS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_CONTAINER_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Text Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_CONTAINER_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.TextImpl <em>Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.TextImpl
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getText()
	 * @generated
	 */
	int TEXT = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.TableImpl
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 5;

	/**
	 * The feature id for the '<em><b>Row</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__ROW = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Num Rows</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__NUM_ROWS = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Num Col</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__NUM_COL = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.ImageImpl <em>Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.ImageImpl
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 6;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__HEIGHT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__WIDTH = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__TYPE = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.TextBoxImpl <em>Text Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.TextBoxImpl
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getTextBox()
	 * @generated
	 */
	int TEXT_BOX = 7;

	/**
	 * The feature id for the '<em><b>Words</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BOX__WORDS = TEXT_CONTAINER__WORDS;

	/**
	 * The number of structural features of the '<em>Text Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BOX_FEATURE_COUNT = TEXT_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Text Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BOX_OPERATION_COUNT = TEXT_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.ParagraphImpl <em>Paragraph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.ParagraphImpl
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getParagraph()
	 * @generated
	 */
	int PARAGRAPH = 8;

	/**
	 * The feature id for the '<em><b>Words</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__WORDS = TEXT_CONTAINER__WORDS;

	/**
	 * The feature id for the '<em><b>Paragraph Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__PARAGRAPH_SPACING = TEXT_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__LINE_SPACING = TEXT_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Indent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__INDENT = TEXT_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Paragraph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH_FEATURE_COUNT = TEXT_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Paragraph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH_OPERATION_COUNT = TEXT_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.SimpleTextImpl <em>Simple Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.SimpleTextImpl
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getSimpleText()
	 * @generated
	 */
	int SIMPLE_TEXT = 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TEXT__VALUE = TEXT__VALUE;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TEXT__SIZE = TEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TEXT__COLOR = TEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Background</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TEXT__BACKGROUND = TEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TEXT__FONT_FAMILY = TEXT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Simple Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TEXT_FEATURE_COUNT = TEXT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Simple Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TEXT_OPERATION_COUNT = TEXT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.HyperLinkImpl <em>Hyper Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.HyperLinkImpl
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getHyperLink()
	 * @generated
	 */
	int HYPER_LINK = 10;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPER_LINK__VALUE = TEXT__VALUE;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPER_LINK__URL = TEXT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Hyper Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPER_LINK_FEATURE_COUNT = TEXT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Hyper Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPER_LINK_OPERATION_COUNT = TEXT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.RowImpl <em>Row</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.RowImpl
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getRow()
	 * @generated
	 */
	int ROW = 11;

	/**
	 * The feature id for the '<em><b>Cell</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__CELL = 0;

	/**
	 * The number of structural features of the '<em>Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.CellImpl <em>Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.CellImpl
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getCell()
	 * @generated
	 */
	int CELL = 12;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL__ELEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDoc.FontFamily <em>Font Family</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDoc.FontFamily
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getFontFamily()
	 * @generated
	 */
	int FONT_FAMILY = 13;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDoc.Color <em>Color</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Color
	 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getColor()
	 * @generated
	 */
	int COLOR = 14;


	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDoc.Document <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Document
	 * @generated
	 */
	EClass getDocument();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.Document#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Document#getName()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_Name();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.Document#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Document#getAuthor()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_Author();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.Document#getNumColum <em>Num Colum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Colum</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Document#getNumColum()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_NumColum();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.Document#getDocumentFormat <em>Document Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Document Format</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Document#getDocumentFormat()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_DocumentFormat();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.Document#getDocumentFormatCode <em>Document Format Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Document Format Code</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Document#getDocumentFormatCode()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_DocumentFormatCode();

	/**
	 * Returns the meta object for the containment reference list '{@link benchmarkdp.datagenerator.model.PSMDoc.Document#getPages <em>Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pages</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Document#getPages()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Pages();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.Document#getDocumentPlatform <em>Document Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Document Platform</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Document#getDocumentPlatform()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_DocumentPlatform();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDoc.Page <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Page
	 * @generated
	 */
	EClass getPage();

	/**
	 * Returns the meta object for the containment reference list '{@link benchmarkdp.datagenerator.model.PSMDoc.Page#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Page#getElements()
	 * @see #getPage()
	 * @generated
	 */
	EReference getPage_Elements();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDoc.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDoc.TextContainer <em>Text Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Container</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.TextContainer
	 * @generated
	 */
	EClass getTextContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link benchmarkdp.datagenerator.model.PSMDoc.TextContainer#getWords <em>Words</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Words</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.TextContainer#getWords()
	 * @see #getTextContainer()
	 * @generated
	 */
	EReference getTextContainer_Words();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDoc.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Text
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.Text#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Text#getValue()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_Value();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDoc.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the containment reference list '{@link benchmarkdp.datagenerator.model.PSMDoc.Table#getRow <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Row</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Table#getRow()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Row();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.Table#getNumRows <em>Num Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Rows</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Table#getNumRows()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_NumRows();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.Table#getNumCol <em>Num Col</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Col</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Table#getNumCol()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_NumCol();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDoc.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Image
	 * @generated
	 */
	EClass getImage();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.Image#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Image#getHeight()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Height();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.Image#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Image#getWidth()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Width();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.Image#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Image#getType()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Type();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDoc.TextBox <em>Text Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Box</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.TextBox
	 * @generated
	 */
	EClass getTextBox();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDoc.Paragraph <em>Paragraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Paragraph</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Paragraph
	 * @generated
	 */
	EClass getParagraph();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.Paragraph#getParagraphSpacing <em>Paragraph Spacing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Paragraph Spacing</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Paragraph#getParagraphSpacing()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_ParagraphSpacing();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.Paragraph#getLineSpacing <em>Line Spacing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Spacing</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Paragraph#getLineSpacing()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_LineSpacing();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.Paragraph#getIndent <em>Indent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indent</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Paragraph#getIndent()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_Indent();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDoc.SimpleText <em>Simple Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Text</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.SimpleText
	 * @generated
	 */
	EClass getSimpleText();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.SimpleText#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.SimpleText#getSize()
	 * @see #getSimpleText()
	 * @generated
	 */
	EAttribute getSimpleText_Size();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.SimpleText#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.SimpleText#getColor()
	 * @see #getSimpleText()
	 * @generated
	 */
	EAttribute getSimpleText_Color();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.SimpleText#getBackground <em>Background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Background</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.SimpleText#getBackground()
	 * @see #getSimpleText()
	 * @generated
	 */
	EAttribute getSimpleText_Background();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.SimpleText#getFontFamily <em>Font Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Family</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.SimpleText#getFontFamily()
	 * @see #getSimpleText()
	 * @generated
	 */
	EAttribute getSimpleText_FontFamily();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDoc.HyperLink <em>Hyper Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hyper Link</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.HyperLink
	 * @generated
	 */
	EClass getHyperLink();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDoc.HyperLink#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.HyperLink#getUrl()
	 * @see #getHyperLink()
	 * @generated
	 */
	EAttribute getHyperLink_Url();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDoc.Row <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Row</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Row
	 * @generated
	 */
	EClass getRow();

	/**
	 * Returns the meta object for the containment reference list '{@link benchmarkdp.datagenerator.model.PSMDoc.Row#getCell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cell</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Row#getCell()
	 * @see #getRow()
	 * @generated
	 */
	EReference getRow_Cell();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDoc.Cell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cell</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Cell
	 * @generated
	 */
	EClass getCell();

	/**
	 * Returns the meta object for the containment reference list '{@link benchmarkdp.datagenerator.model.PSMDoc.Cell#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Cell#getElements()
	 * @see #getCell()
	 * @generated
	 */
	EReference getCell_Elements();

	/**
	 * Returns the meta object for enum '{@link benchmarkdp.datagenerator.model.PSMDoc.FontFamily <em>Font Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Font Family</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.FontFamily
	 * @generated
	 */
	EEnum getFontFamily();

	/**
	 * Returns the meta object for enum '{@link benchmarkdp.datagenerator.model.PSMDoc.Color <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Color</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDoc.Color
	 * @generated
	 */
	EEnum getColor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PSMDocFactory getPSMDocFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.DocumentImpl <em>Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.DocumentImpl
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getDocument()
		 * @generated
		 */
		EClass DOCUMENT = eINSTANCE.getDocument();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT__NAME = eINSTANCE.getDocument_Name();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT__AUTHOR = eINSTANCE.getDocument_Author();

		/**
		 * The meta object literal for the '<em><b>Num Colum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT__NUM_COLUM = eINSTANCE.getDocument_NumColum();

		/**
		 * The meta object literal for the '<em><b>Document Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT__DOCUMENT_FORMAT = eINSTANCE.getDocument_DocumentFormat();

		/**
		 * The meta object literal for the '<em><b>Document Format Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT__DOCUMENT_FORMAT_CODE = eINSTANCE.getDocument_DocumentFormatCode();

		/**
		 * The meta object literal for the '<em><b>Pages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__PAGES = eINSTANCE.getDocument_Pages();

		/**
		 * The meta object literal for the '<em><b>Document Platform</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT__DOCUMENT_PLATFORM = eINSTANCE.getDocument_DocumentPlatform();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.PageImpl <em>Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PageImpl
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getPage()
		 * @generated
		 */
		EClass PAGE = eINSTANCE.getPage();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE__ELEMENTS = eINSTANCE.getPage_Elements();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.ElementImpl
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.TextContainerImpl <em>Text Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.TextContainerImpl
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getTextContainer()
		 * @generated
		 */
		EClass TEXT_CONTAINER = eINSTANCE.getTextContainer();

		/**
		 * The meta object literal for the '<em><b>Words</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT_CONTAINER__WORDS = eINSTANCE.getTextContainer_Words();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.TextImpl <em>Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.TextImpl
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getText()
		 * @generated
		 */
		EClass TEXT = eINSTANCE.getText();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__VALUE = eINSTANCE.getText_Value();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.TableImpl
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em><b>Row</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__ROW = eINSTANCE.getTable_Row();

		/**
		 * The meta object literal for the '<em><b>Num Rows</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE__NUM_ROWS = eINSTANCE.getTable_NumRows();

		/**
		 * The meta object literal for the '<em><b>Num Col</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE__NUM_COL = eINSTANCE.getTable_NumCol();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.ImageImpl <em>Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.ImageImpl
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getImage()
		 * @generated
		 */
		EClass IMAGE = eINSTANCE.getImage();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__HEIGHT = eINSTANCE.getImage_Height();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__WIDTH = eINSTANCE.getImage_Width();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__TYPE = eINSTANCE.getImage_Type();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.TextBoxImpl <em>Text Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.TextBoxImpl
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getTextBox()
		 * @generated
		 */
		EClass TEXT_BOX = eINSTANCE.getTextBox();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.ParagraphImpl <em>Paragraph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.ParagraphImpl
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getParagraph()
		 * @generated
		 */
		EClass PARAGRAPH = eINSTANCE.getParagraph();

		/**
		 * The meta object literal for the '<em><b>Paragraph Spacing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__PARAGRAPH_SPACING = eINSTANCE.getParagraph_ParagraphSpacing();

		/**
		 * The meta object literal for the '<em><b>Line Spacing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__LINE_SPACING = eINSTANCE.getParagraph_LineSpacing();

		/**
		 * The meta object literal for the '<em><b>Indent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__INDENT = eINSTANCE.getParagraph_Indent();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.SimpleTextImpl <em>Simple Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.SimpleTextImpl
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getSimpleText()
		 * @generated
		 */
		EClass SIMPLE_TEXT = eINSTANCE.getSimpleText();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_TEXT__SIZE = eINSTANCE.getSimpleText_Size();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_TEXT__COLOR = eINSTANCE.getSimpleText_Color();

		/**
		 * The meta object literal for the '<em><b>Background</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_TEXT__BACKGROUND = eINSTANCE.getSimpleText_Background();

		/**
		 * The meta object literal for the '<em><b>Font Family</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_TEXT__FONT_FAMILY = eINSTANCE.getSimpleText_FontFamily();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.HyperLinkImpl <em>Hyper Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.HyperLinkImpl
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getHyperLink()
		 * @generated
		 */
		EClass HYPER_LINK = eINSTANCE.getHyperLink();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HYPER_LINK__URL = eINSTANCE.getHyperLink_Url();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.RowImpl <em>Row</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.RowImpl
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getRow()
		 * @generated
		 */
		EClass ROW = eINSTANCE.getRow();

		/**
		 * The meta object literal for the '<em><b>Cell</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROW__CELL = eINSTANCE.getRow_Cell();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDoc.impl.CellImpl <em>Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.CellImpl
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getCell()
		 * @generated
		 */
		EClass CELL = eINSTANCE.getCell();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CELL__ELEMENTS = eINSTANCE.getCell_Elements();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDoc.FontFamily <em>Font Family</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDoc.FontFamily
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getFontFamily()
		 * @generated
		 */
		EEnum FONT_FAMILY = eINSTANCE.getFontFamily();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDoc.Color <em>Color</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDoc.Color
		 * @see benchmarkdp.datagenerator.model.PSMDoc.impl.PSMDocPackageImpl#getColor()
		 * @generated
		 */
		EEnum COLOR = eINSTANCE.getColor();

	}

} //PSMDocPackage
