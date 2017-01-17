/**
 */
package benchmarkdp.datagenerator.model.PSMLibre;

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
 * @see benchmarkdp.datagenerator.model.PSMLibre.PSMLibreFactory
 * @model kind="package"
 * @generated
 */
public interface PSMLibrePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PSMLibre";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://benchmarkdp.datagenerator.model.PSMLibre";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "benchmarkdp.datagenerator.model.PSMLibre";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PSMLibrePackage eINSTANCE = benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl.init();

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.DocumentImpl <em>Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.DocumentImpl
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getDocument()
	 * @generated
	 */
	int DOCUMENT = 0;

	/**
	 * The feature id for the '<em><b>Pages</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__PAGES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__AUTHOR = 2;

	/**
	 * The feature id for the '<em><b>Num Colum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__NUM_COLUM = 3;

	/**
	 * The feature id for the '<em><b>Document Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__DOCUMENT_FORMAT = 4;

	/**
	 * The feature id for the '<em><b>Document Platform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__DOCUMENT_PLATFORM = 5;

	/**
	 * The number of structural features of the '<em>Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.PageImpl <em>Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PageImpl
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getPage()
	 * @generated
	 */
	int PAGE = 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
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
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.ElementImpl
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Parent ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__PARENT_ID = 1;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.TextContainerImpl <em>Text Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.TextContainerImpl
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getTextContainer()
	 * @generated
	 */
	int TEXT_CONTAINER = 3;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_CONTAINER__ID = ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Parent ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_CONTAINER__PARENT_ID = ELEMENT__PARENT_ID;

	/**
	 * The feature id for the '<em><b>Words</b></em>' reference list.
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
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.ParagraphImpl <em>Paragraph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.ParagraphImpl
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getParagraph()
	 * @generated
	 */
	int PARAGRAPH = 4;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__ID = TEXT_CONTAINER__ID;

	/**
	 * The feature id for the '<em><b>Parent ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__PARENT_ID = TEXT_CONTAINER__PARENT_ID;

	/**
	 * The feature id for the '<em><b>Words</b></em>' reference list.
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
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.TextImpl <em>Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.TextImpl
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getText()
	 * @generated
	 */
	int TEXT = 5;

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
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.SimpleTextImpl <em>Simple Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.SimpleTextImpl
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getSimpleText()
	 * @generated
	 */
	int SIMPLE_TEXT = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TEXT__VALUE = TEXT__VALUE;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TEXT__FONT_FAMILY = TEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TEXT__FONT_COLOR = TEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Font Background</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TEXT__FONT_BACKGROUND = TEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Font Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TEXT__FONT_SIZE = TEXT_FEATURE_COUNT + 3;

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
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.TableImpl
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 7;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__ID = ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Parent ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__PARENT_ID = ELEMENT__PARENT_ID;

	/**
	 * The feature id for the '<em><b>Num Rows</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__NUM_ROWS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Num Col</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__NUM_COL = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Row</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__ROW = ELEMENT_FEATURE_COUNT + 2;

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
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.RowImpl <em>Row</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.RowImpl
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getRow()
	 * @generated
	 */
	int ROW = 8;

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
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.CellImpl <em>Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.CellImpl
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getCell()
	 * @generated
	 */
	int CELL = 9;

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
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.ImageImpl <em>Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.ImageImpl
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 10;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__ID = ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Parent ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__PARENT_ID = ELEMENT__PARENT_ID;

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
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMLibre.FontFamily <em>Font Family</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMLibre.FontFamily
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getFontFamily()
	 * @generated
	 */
	int FONT_FAMILY = 11;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMLibre.Color <em>Color</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Color
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getColor()
	 * @generated
	 */
	int COLOR = 12;


	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMLibre.Document <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Document
	 * @generated
	 */
	EClass getDocument();

	/**
	 * Returns the meta object for the reference list '{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getPages <em>Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Pages</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Document#getPages()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Pages();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Document#getName()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_Name();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Document#getAuthor()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_Author();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getNumColum <em>Num Colum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Colum</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Document#getNumColum()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_NumColum();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getDocumentFormat <em>Document Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Document Format</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Document#getDocumentFormat()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_DocumentFormat();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.Document#getDocumentPlatform <em>Document Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Document Platform</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Document#getDocumentPlatform()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_DocumentPlatform();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMLibre.Page <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Page
	 * @generated
	 */
	EClass getPage();

	/**
	 * Returns the meta object for the reference list '{@link benchmarkdp.datagenerator.model.PSMLibre.Page#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Page#getElements()
	 * @see #getPage()
	 * @generated
	 */
	EReference getPage_Elements();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMLibre.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.Element#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Element#getID()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_ID();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.Element#getParentID <em>Parent ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent ID</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Element#getParentID()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_ParentID();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMLibre.TextContainer <em>Text Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Container</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.TextContainer
	 * @generated
	 */
	EClass getTextContainer();

	/**
	 * Returns the meta object for the reference list '{@link benchmarkdp.datagenerator.model.PSMLibre.TextContainer#getWords <em>Words</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Words</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.TextContainer#getWords()
	 * @see #getTextContainer()
	 * @generated
	 */
	EReference getTextContainer_Words();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMLibre.Paragraph <em>Paragraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Paragraph</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Paragraph
	 * @generated
	 */
	EClass getParagraph();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.Paragraph#getParagraphSpacing <em>Paragraph Spacing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Paragraph Spacing</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Paragraph#getParagraphSpacing()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_ParagraphSpacing();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.Paragraph#getLineSpacing <em>Line Spacing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Spacing</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Paragraph#getLineSpacing()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_LineSpacing();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.Paragraph#getIndent <em>Indent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indent</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Paragraph#getIndent()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_Indent();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMLibre.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Text
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.Text#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Text#getValue()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_Value();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMLibre.SimpleText <em>Simple Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Text</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.SimpleText
	 * @generated
	 */
	EClass getSimpleText();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.SimpleText#getFontFamily <em>Font Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Family</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.SimpleText#getFontFamily()
	 * @see #getSimpleText()
	 * @generated
	 */
	EAttribute getSimpleText_FontFamily();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.SimpleText#getFontColor <em>Font Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Color</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.SimpleText#getFontColor()
	 * @see #getSimpleText()
	 * @generated
	 */
	EAttribute getSimpleText_FontColor();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.SimpleText#getFontBackground <em>Font Background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Background</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.SimpleText#getFontBackground()
	 * @see #getSimpleText()
	 * @generated
	 */
	EAttribute getSimpleText_FontBackground();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.SimpleText#getFontSize <em>Font Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Size</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.SimpleText#getFontSize()
	 * @see #getSimpleText()
	 * @generated
	 */
	EAttribute getSimpleText_FontSize();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMLibre.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.Table#getNumRows <em>Num Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Rows</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Table#getNumRows()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_NumRows();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.Table#getNumCol <em>Num Col</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Col</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Table#getNumCol()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_NumCol();

	/**
	 * Returns the meta object for the reference list '{@link benchmarkdp.datagenerator.model.PSMLibre.Table#getRow <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Row</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Table#getRow()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Row();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMLibre.Row <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Row</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Row
	 * @generated
	 */
	EClass getRow();

	/**
	 * Returns the meta object for the containment reference list '{@link benchmarkdp.datagenerator.model.PSMLibre.Row#getCell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cell</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Row#getCell()
	 * @see #getRow()
	 * @generated
	 */
	EReference getRow_Cell();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMLibre.Cell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cell</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Cell
	 * @generated
	 */
	EClass getCell();

	/**
	 * Returns the meta object for the containment reference list '{@link benchmarkdp.datagenerator.model.PSMLibre.Cell#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Cell#getElements()
	 * @see #getCell()
	 * @generated
	 */
	EReference getCell_Elements();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMLibre.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Image
	 * @generated
	 */
	EClass getImage();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.Image#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Image#getHeight()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Height();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.Image#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Image#getWidth()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Width();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMLibre.Image#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Image#getType()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Type();

	/**
	 * Returns the meta object for enum '{@link benchmarkdp.datagenerator.model.PSMLibre.FontFamily <em>Font Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Font Family</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.FontFamily
	 * @generated
	 */
	EEnum getFontFamily();

	/**
	 * Returns the meta object for enum '{@link benchmarkdp.datagenerator.model.PSMLibre.Color <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Color</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMLibre.Color
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
	PSMLibreFactory getPSMLibreFactory();

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
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.DocumentImpl <em>Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.DocumentImpl
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getDocument()
		 * @generated
		 */
		EClass DOCUMENT = eINSTANCE.getDocument();

		/**
		 * The meta object literal for the '<em><b>Pages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__PAGES = eINSTANCE.getDocument_Pages();

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
		 * The meta object literal for the '<em><b>Document Platform</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT__DOCUMENT_PLATFORM = eINSTANCE.getDocument_DocumentPlatform();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.PageImpl <em>Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PageImpl
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getPage()
		 * @generated
		 */
		EClass PAGE = eINSTANCE.getPage();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE__ELEMENTS = eINSTANCE.getPage_Elements();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.ElementImpl
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__ID = eINSTANCE.getElement_ID();

		/**
		 * The meta object literal for the '<em><b>Parent ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__PARENT_ID = eINSTANCE.getElement_ParentID();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.TextContainerImpl <em>Text Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.TextContainerImpl
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getTextContainer()
		 * @generated
		 */
		EClass TEXT_CONTAINER = eINSTANCE.getTextContainer();

		/**
		 * The meta object literal for the '<em><b>Words</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT_CONTAINER__WORDS = eINSTANCE.getTextContainer_Words();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.ParagraphImpl <em>Paragraph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.ParagraphImpl
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getParagraph()
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
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.TextImpl <em>Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.TextImpl
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getText()
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
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.SimpleTextImpl <em>Simple Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.SimpleTextImpl
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getSimpleText()
		 * @generated
		 */
		EClass SIMPLE_TEXT = eINSTANCE.getSimpleText();

		/**
		 * The meta object literal for the '<em><b>Font Family</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_TEXT__FONT_FAMILY = eINSTANCE.getSimpleText_FontFamily();

		/**
		 * The meta object literal for the '<em><b>Font Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_TEXT__FONT_COLOR = eINSTANCE.getSimpleText_FontColor();

		/**
		 * The meta object literal for the '<em><b>Font Background</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_TEXT__FONT_BACKGROUND = eINSTANCE.getSimpleText_FontBackground();

		/**
		 * The meta object literal for the '<em><b>Font Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_TEXT__FONT_SIZE = eINSTANCE.getSimpleText_FontSize();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.TableImpl
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

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
		 * The meta object literal for the '<em><b>Row</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__ROW = eINSTANCE.getTable_Row();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.RowImpl <em>Row</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.RowImpl
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getRow()
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
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.CellImpl <em>Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.CellImpl
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getCell()
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
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.ImageImpl <em>Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.ImageImpl
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getImage()
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
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMLibre.FontFamily <em>Font Family</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMLibre.FontFamily
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getFontFamily()
		 * @generated
		 */
		EEnum FONT_FAMILY = eINSTANCE.getFontFamily();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMLibre.Color <em>Color</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMLibre.Color
		 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getColor()
		 * @generated
		 */
		EEnum COLOR = eINSTANCE.getColor();

	}

} //PSMLibrePackage
