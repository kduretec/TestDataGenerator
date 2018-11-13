/**
 */
package benchmarkdp.datagenerator.model.PSMDocx;

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
 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxFactory
 * @model kind="package"
 * @generated
 */
public interface PSMDocxPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PSMDocx";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://benchmarkdp.datagenerator.model.PSMDocx";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "benchmarkdp.datagenerator.model.PSMDocx";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PSMDocxPackage eINSTANCE = benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl.init();

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.DocumentImpl <em>Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.DocumentImpl
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getDocument()
	 * @generated
	 */
	int DOCUMENT = 0;

	/**
	 * The feature id for the '<em><b>Document Background</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__DOCUMENT_BACKGROUND = 0;

	/**
	 * The feature id for the '<em><b>Document Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__DOCUMENT_FORMAT = 1;

	/**
	 * The feature id for the '<em><b>Document Format Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__DOCUMENT_FORMAT_CODE = 2;

	/**
	 * The feature id for the '<em><b>Pages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__PAGES = 3;

	/**
	 * The feature id for the '<em><b>Software</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__SOFTWARE = 4;

	/**
	 * The feature id for the '<em><b>Operating System</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__OPERATING_SYSTEM = 5;

	/**
	 * The feature id for the '<em><b>Calc Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__CALC_LAYOUT = 6;

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
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.PageImpl <em>Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PageImpl
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getPage()
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
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.ElementImpl
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getElement()
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
	 * The feature id for the '<em><b>Background Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__BACKGROUND_COLOR = 2;

	/**
	 * The feature id for the '<em><b>Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__ALIGNMENT = 3;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.TextContainerImpl <em>Text Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.TextContainerImpl
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getTextContainer()
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
	 * The feature id for the '<em><b>Background Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_CONTAINER__BACKGROUND_COLOR = ELEMENT__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_CONTAINER__ALIGNMENT = ELEMENT__ALIGNMENT;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_CONTAINER__FONT_COLOR = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_CONTAINER__FONT_FAMILY = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Text Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_CONTAINER_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Text Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_CONTAINER_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.ParagraphImplImpl <em>Paragraph Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.ParagraphImplImpl
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getParagraphImpl()
	 * @generated
	 */
	int PARAGRAPH_IMPL = 16;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH_IMPL__ID = TEXT_CONTAINER__ID;

	/**
	 * The feature id for the '<em><b>Parent ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH_IMPL__PARENT_ID = TEXT_CONTAINER__PARENT_ID;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH_IMPL__BACKGROUND_COLOR = TEXT_CONTAINER__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH_IMPL__ALIGNMENT = TEXT_CONTAINER__ALIGNMENT;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH_IMPL__FONT_COLOR = TEXT_CONTAINER__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH_IMPL__FONT_FAMILY = TEXT_CONTAINER__FONT_FAMILY;

	/**
	 * The feature id for the '<em><b>Text</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH_IMPL__TEXT = TEXT_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Paragraph Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH_IMPL_FEATURE_COUNT = TEXT_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Paragraph Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH_IMPL_OPERATION_COUNT = TEXT_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.TextBoxImpl <em>Text Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.TextBoxImpl
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getTextBox()
	 * @generated
	 */
	int TEXT_BOX = 4;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BOX__ID = PARAGRAPH_IMPL__ID;

	/**
	 * The feature id for the '<em><b>Parent ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BOX__PARENT_ID = PARAGRAPH_IMPL__PARENT_ID;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BOX__BACKGROUND_COLOR = PARAGRAPH_IMPL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BOX__ALIGNMENT = PARAGRAPH_IMPL__ALIGNMENT;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BOX__FONT_COLOR = PARAGRAPH_IMPL__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BOX__FONT_FAMILY = PARAGRAPH_IMPL__FONT_FAMILY;

	/**
	 * The feature id for the '<em><b>Text</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BOX__TEXT = PARAGRAPH_IMPL__TEXT;

	/**
	 * The number of structural features of the '<em>Text Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BOX_FEATURE_COUNT = PARAGRAPH_IMPL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Text Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_BOX_OPERATION_COUNT = PARAGRAPH_IMPL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.ParagraphImpl <em>Paragraph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.ParagraphImpl
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getParagraph()
	 * @generated
	 */
	int PARAGRAPH = 5;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__ID = PARAGRAPH_IMPL__ID;

	/**
	 * The feature id for the '<em><b>Parent ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__PARENT_ID = PARAGRAPH_IMPL__PARENT_ID;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__BACKGROUND_COLOR = PARAGRAPH_IMPL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__ALIGNMENT = PARAGRAPH_IMPL__ALIGNMENT;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__FONT_COLOR = PARAGRAPH_IMPL__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__FONT_FAMILY = PARAGRAPH_IMPL__FONT_FAMILY;

	/**
	 * The feature id for the '<em><b>Text</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__TEXT = PARAGRAPH_IMPL__TEXT;

	/**
	 * The feature id for the '<em><b>Indent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__INDENT = PARAGRAPH_IMPL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Paragraph Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__PARAGRAPH_SPACING = PARAGRAPH_IMPL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__LINE_SPACING = PARAGRAPH_IMPL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Paragraph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH_FEATURE_COUNT = PARAGRAPH_IMPL_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Paragraph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH_OPERATION_COUNT = PARAGRAPH_IMPL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.ControlBoxImpl <em>Control Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.ControlBoxImpl
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getControlBox()
	 * @generated
	 */
	int CONTROL_BOX = 6;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_BOX__ID = PARAGRAPH_IMPL__ID;

	/**
	 * The feature id for the '<em><b>Parent ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_BOX__PARENT_ID = PARAGRAPH_IMPL__PARENT_ID;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_BOX__BACKGROUND_COLOR = PARAGRAPH_IMPL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_BOX__ALIGNMENT = PARAGRAPH_IMPL__ALIGNMENT;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_BOX__FONT_COLOR = PARAGRAPH_IMPL__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_BOX__FONT_FAMILY = PARAGRAPH_IMPL__FONT_FAMILY;

	/**
	 * The feature id for the '<em><b>Text</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_BOX__TEXT = PARAGRAPH_IMPL__TEXT;

	/**
	 * The number of structural features of the '<em>Control Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_BOX_FEATURE_COUNT = PARAGRAPH_IMPL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Control Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_BOX_OPERATION_COUNT = PARAGRAPH_IMPL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.TextImpl <em>Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.TextImpl
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getText()
	 * @generated
	 */
	int TEXT = 7;

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
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.SimpleTextImpl <em>Simple Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.SimpleTextImpl
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getSimpleText()
	 * @generated
	 */
	int SIMPLE_TEXT = 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TEXT__VALUE = TEXT__VALUE;

	/**
	 * The number of structural features of the '<em>Simple Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TEXT_FEATURE_COUNT = TEXT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Simple Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TEXT_OPERATION_COUNT = TEXT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.HyperLinkImpl <em>Hyper Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.HyperLinkImpl
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getHyperLink()
	 * @generated
	 */
	int HYPER_LINK = 9;

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
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.TableImplImpl <em>Table Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.TableImplImpl
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getTableImpl()
	 * @generated
	 */
	int TABLE_IMPL = 10;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_IMPL__ID = TEXT_CONTAINER__ID;

	/**
	 * The feature id for the '<em><b>Parent ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_IMPL__PARENT_ID = TEXT_CONTAINER__PARENT_ID;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_IMPL__BACKGROUND_COLOR = TEXT_CONTAINER__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_IMPL__ALIGNMENT = TEXT_CONTAINER__ALIGNMENT;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_IMPL__FONT_COLOR = TEXT_CONTAINER__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_IMPL__FONT_FAMILY = TEXT_CONTAINER__FONT_FAMILY;

	/**
	 * The feature id for the '<em><b>Row</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_IMPL__ROW = TEXT_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Num Rows</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_IMPL__NUM_ROWS = TEXT_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Num Col</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_IMPL__NUM_COL = TEXT_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_IMPL__TYPE = TEXT_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Table Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_IMPL_FEATURE_COUNT = TEXT_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Table Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_IMPL_OPERATION_COUNT = TEXT_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.RowImpl <em>Row</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.RowImpl
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getRow()
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
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.CellImpl <em>Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.CellImpl
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getCell()
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
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.ImageImpl <em>Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.ImageImpl
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 13;

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
	 * The feature id for the '<em><b>Background Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__BACKGROUND_COLOR = ELEMENT__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__ALIGNMENT = ELEMENT__ALIGNMENT;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__WIDTH = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__HEIGHT = ELEMENT_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.EmbeddedExcelImpl <em>Embedded Excel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.EmbeddedExcelImpl
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getEmbeddedExcel()
	 * @generated
	 */
	int EMBEDDED_EXCEL = 14;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_EXCEL__ID = TABLE_IMPL__ID;

	/**
	 * The feature id for the '<em><b>Parent ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_EXCEL__PARENT_ID = TABLE_IMPL__PARENT_ID;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_EXCEL__BACKGROUND_COLOR = TABLE_IMPL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_EXCEL__ALIGNMENT = TABLE_IMPL__ALIGNMENT;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_EXCEL__FONT_COLOR = TABLE_IMPL__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_EXCEL__FONT_FAMILY = TABLE_IMPL__FONT_FAMILY;

	/**
	 * The feature id for the '<em><b>Row</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_EXCEL__ROW = TABLE_IMPL__ROW;

	/**
	 * The feature id for the '<em><b>Num Rows</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_EXCEL__NUM_ROWS = TABLE_IMPL__NUM_ROWS;

	/**
	 * The feature id for the '<em><b>Num Col</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_EXCEL__NUM_COL = TABLE_IMPL__NUM_COL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_EXCEL__TYPE = TABLE_IMPL__TYPE;

	/**
	 * The number of structural features of the '<em>Embedded Excel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_EXCEL_FEATURE_COUNT = TABLE_IMPL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Embedded Excel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDED_EXCEL_OPERATION_COUNT = TABLE_IMPL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.WordTableImpl <em>Word Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.WordTableImpl
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getWordTable()
	 * @generated
	 */
	int WORD_TABLE = 15;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_TABLE__ID = TABLE_IMPL__ID;

	/**
	 * The feature id for the '<em><b>Parent ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_TABLE__PARENT_ID = TABLE_IMPL__PARENT_ID;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_TABLE__BACKGROUND_COLOR = TABLE_IMPL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Alignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_TABLE__ALIGNMENT = TABLE_IMPL__ALIGNMENT;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_TABLE__FONT_COLOR = TABLE_IMPL__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_TABLE__FONT_FAMILY = TABLE_IMPL__FONT_FAMILY;

	/**
	 * The feature id for the '<em><b>Row</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_TABLE__ROW = TABLE_IMPL__ROW;

	/**
	 * The feature id for the '<em><b>Num Rows</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_TABLE__NUM_ROWS = TABLE_IMPL__NUM_ROWS;

	/**
	 * The feature id for the '<em><b>Num Col</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_TABLE__NUM_COL = TABLE_IMPL__NUM_COL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_TABLE__TYPE = TABLE_IMPL__TYPE;

	/**
	 * The number of structural features of the '<em>Word Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_TABLE_FEATURE_COUNT = TABLE_IMPL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Word Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_TABLE_OPERATION_COUNT = TABLE_IMPL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.FontFamily <em>Font Family</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.FontFamily
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getFontFamily()
	 * @generated
	 */
	int FONT_FAMILY = 17;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.Color <em>Color</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Color
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getColor()
	 * @generated
	 */
	int COLOR = 18;

	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.Alignment <em>Alignment</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Alignment
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getAlignment()
	 * @generated
	 */
	int ALIGNMENT = 19;


	/**
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMDocx.TableType <em>Table Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMDocx.TableType
	 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getTableType()
	 * @generated
	 */
	int TABLE_TYPE = 20;


	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDocx.Document <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Document
	 * @generated
	 */
	EClass getDocument();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.Document#getDocumentBackground <em>Document Background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Document Background</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Document#getDocumentBackground()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_DocumentBackground();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.Document#getDocumentFormat <em>Document Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Document Format</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Document#getDocumentFormat()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_DocumentFormat();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.Document#getDocumentFormatCode <em>Document Format Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Document Format Code</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Document#getDocumentFormatCode()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_DocumentFormatCode();

	/**
	 * Returns the meta object for the containment reference list '{@link benchmarkdp.datagenerator.model.PSMDocx.Document#getPages <em>Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pages</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Document#getPages()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Pages();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.Document#getSoftware <em>Software</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Software</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Document#getSoftware()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_Software();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.Document#getOperatingSystem <em>Operating System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operating System</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Document#getOperatingSystem()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_OperatingSystem();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.Document#isCalcLayout <em>Calc Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Calc Layout</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Document#isCalcLayout()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_CalcLayout();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDocx.Page <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Page
	 * @generated
	 */
	EClass getPage();

	/**
	 * Returns the meta object for the containment reference list '{@link benchmarkdp.datagenerator.model.PSMDocx.Page#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Page#getElements()
	 * @see #getPage()
	 * @generated
	 */
	EReference getPage_Elements();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDocx.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.Element#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Element#getID()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_ID();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.Element#getParentID <em>Parent ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent ID</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Element#getParentID()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_ParentID();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.Element#getBackgroundColor <em>Background Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Background Color</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Element#getBackgroundColor()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_BackgroundColor();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.Element#getAlignment <em>Alignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alignment</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Element#getAlignment()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Alignment();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDocx.TextContainer <em>Text Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Container</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.TextContainer
	 * @generated
	 */
	EClass getTextContainer();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.TextContainer#getFontColor <em>Font Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Color</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.TextContainer#getFontColor()
	 * @see #getTextContainer()
	 * @generated
	 */
	EAttribute getTextContainer_FontColor();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.TextContainer#getFontFamily <em>Font Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Family</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.TextContainer#getFontFamily()
	 * @see #getTextContainer()
	 * @generated
	 */
	EAttribute getTextContainer_FontFamily();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDocx.TextBox <em>Text Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Box</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.TextBox
	 * @generated
	 */
	EClass getTextBox();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDocx.Paragraph <em>Paragraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Paragraph</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Paragraph
	 * @generated
	 */
	EClass getParagraph();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.Paragraph#getIndent <em>Indent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indent</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Paragraph#getIndent()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_Indent();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.Paragraph#getParagraphSpacing <em>Paragraph Spacing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Paragraph Spacing</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Paragraph#getParagraphSpacing()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_ParagraphSpacing();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.Paragraph#getLineSpacing <em>Line Spacing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Spacing</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Paragraph#getLineSpacing()
	 * @see #getParagraph()
	 * @generated
	 */
	EAttribute getParagraph_LineSpacing();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDocx.ControlBox <em>Control Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Box</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.ControlBox
	 * @generated
	 */
	EClass getControlBox();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDocx.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Text
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.Text#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Text#getValue()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_Value();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDocx.SimpleText <em>Simple Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Text</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.SimpleText
	 * @generated
	 */
	EClass getSimpleText();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDocx.HyperLink <em>Hyper Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hyper Link</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.HyperLink
	 * @generated
	 */
	EClass getHyperLink();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.HyperLink#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.HyperLink#getUrl()
	 * @see #getHyperLink()
	 * @generated
	 */
	EAttribute getHyperLink_Url();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDocx.TableImpl <em>Table Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table Impl</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.TableImpl
	 * @generated
	 */
	EClass getTableImpl();

	/**
	 * Returns the meta object for the containment reference list '{@link benchmarkdp.datagenerator.model.PSMDocx.TableImpl#getRow <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Row</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.TableImpl#getRow()
	 * @see #getTableImpl()
	 * @generated
	 */
	EReference getTableImpl_Row();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.TableImpl#getNumRows <em>Num Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Rows</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.TableImpl#getNumRows()
	 * @see #getTableImpl()
	 * @generated
	 */
	EAttribute getTableImpl_NumRows();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.TableImpl#getNumCol <em>Num Col</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Col</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.TableImpl#getNumCol()
	 * @see #getTableImpl()
	 * @generated
	 */
	EAttribute getTableImpl_NumCol();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.TableImpl#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.TableImpl#getType()
	 * @see #getTableImpl()
	 * @generated
	 */
	EAttribute getTableImpl_Type();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDocx.Row <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Row</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Row
	 * @generated
	 */
	EClass getRow();

	/**
	 * Returns the meta object for the containment reference list '{@link benchmarkdp.datagenerator.model.PSMDocx.Row#getCell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cell</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Row#getCell()
	 * @see #getRow()
	 * @generated
	 */
	EReference getRow_Cell();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDocx.Cell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cell</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Cell
	 * @generated
	 */
	EClass getCell();

	/**
	 * Returns the meta object for the containment reference list '{@link benchmarkdp.datagenerator.model.PSMDocx.Cell#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Cell#getElements()
	 * @see #getCell()
	 * @generated
	 */
	EReference getCell_Elements();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDocx.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Image
	 * @generated
	 */
	EClass getImage();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.Image#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Image#getWidth()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Width();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.Image#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Image#getHeight()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Height();

	/**
	 * Returns the meta object for the attribute '{@link benchmarkdp.datagenerator.model.PSMDocx.Image#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Image#getType()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Type();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDocx.EmbeddedExcel <em>Embedded Excel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Embedded Excel</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.EmbeddedExcel
	 * @generated
	 */
	EClass getEmbeddedExcel();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDocx.WordTable <em>Word Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Word Table</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.WordTable
	 * @generated
	 */
	EClass getWordTable();

	/**
	 * Returns the meta object for class '{@link benchmarkdp.datagenerator.model.PSMDocx.ParagraphImpl <em>Paragraph Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Paragraph Impl</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.ParagraphImpl
	 * @generated
	 */
	EClass getParagraphImpl();

	/**
	 * Returns the meta object for the containment reference list '{@link benchmarkdp.datagenerator.model.PSMDocx.ParagraphImpl#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Text</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.ParagraphImpl#getText()
	 * @see #getParagraphImpl()
	 * @generated
	 */
	EReference getParagraphImpl_Text();

	/**
	 * Returns the meta object for enum '{@link benchmarkdp.datagenerator.model.PSMDocx.FontFamily <em>Font Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Font Family</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.FontFamily
	 * @generated
	 */
	EEnum getFontFamily();

	/**
	 * Returns the meta object for enum '{@link benchmarkdp.datagenerator.model.PSMDocx.Color <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Color</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Color
	 * @generated
	 */
	EEnum getColor();

	/**
	 * Returns the meta object for enum '{@link benchmarkdp.datagenerator.model.PSMDocx.Alignment <em>Alignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Alignment</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Alignment
	 * @generated
	 */
	EEnum getAlignment();

	/**
	 * Returns the meta object for enum '{@link benchmarkdp.datagenerator.model.PSMDocx.TableType <em>Table Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Table Type</em>'.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.TableType
	 * @generated
	 */
	EEnum getTableType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PSMDocxFactory getPSMDocxFactory();

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
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.DocumentImpl <em>Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.DocumentImpl
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getDocument()
		 * @generated
		 */
		EClass DOCUMENT = eINSTANCE.getDocument();

		/**
		 * The meta object literal for the '<em><b>Document Background</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT__DOCUMENT_BACKGROUND = eINSTANCE.getDocument_DocumentBackground();

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
		 * The meta object literal for the '<em><b>Software</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT__SOFTWARE = eINSTANCE.getDocument_Software();

		/**
		 * The meta object literal for the '<em><b>Operating System</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT__OPERATING_SYSTEM = eINSTANCE.getDocument_OperatingSystem();

		/**
		 * The meta object literal for the '<em><b>Calc Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT__CALC_LAYOUT = eINSTANCE.getDocument_CalcLayout();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.PageImpl <em>Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PageImpl
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getPage()
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
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.ElementImpl
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getElement()
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
		 * The meta object literal for the '<em><b>Background Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__BACKGROUND_COLOR = eINSTANCE.getElement_BackgroundColor();

		/**
		 * The meta object literal for the '<em><b>Alignment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__ALIGNMENT = eINSTANCE.getElement_Alignment();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.TextContainerImpl <em>Text Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.TextContainerImpl
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getTextContainer()
		 * @generated
		 */
		EClass TEXT_CONTAINER = eINSTANCE.getTextContainer();

		/**
		 * The meta object literal for the '<em><b>Font Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_CONTAINER__FONT_COLOR = eINSTANCE.getTextContainer_FontColor();

		/**
		 * The meta object literal for the '<em><b>Font Family</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_CONTAINER__FONT_FAMILY = eINSTANCE.getTextContainer_FontFamily();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.TextBoxImpl <em>Text Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.TextBoxImpl
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getTextBox()
		 * @generated
		 */
		EClass TEXT_BOX = eINSTANCE.getTextBox();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.ParagraphImpl <em>Paragraph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.ParagraphImpl
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getParagraph()
		 * @generated
		 */
		EClass PARAGRAPH = eINSTANCE.getParagraph();

		/**
		 * The meta object literal for the '<em><b>Indent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAGRAPH__INDENT = eINSTANCE.getParagraph_Indent();

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
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.ControlBoxImpl <em>Control Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.ControlBoxImpl
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getControlBox()
		 * @generated
		 */
		EClass CONTROL_BOX = eINSTANCE.getControlBox();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.TextImpl <em>Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.TextImpl
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getText()
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
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.SimpleTextImpl <em>Simple Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.SimpleTextImpl
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getSimpleText()
		 * @generated
		 */
		EClass SIMPLE_TEXT = eINSTANCE.getSimpleText();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.HyperLinkImpl <em>Hyper Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.HyperLinkImpl
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getHyperLink()
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
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.TableImplImpl <em>Table Impl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.TableImplImpl
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getTableImpl()
		 * @generated
		 */
		EClass TABLE_IMPL = eINSTANCE.getTableImpl();

		/**
		 * The meta object literal for the '<em><b>Row</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_IMPL__ROW = eINSTANCE.getTableImpl_Row();

		/**
		 * The meta object literal for the '<em><b>Num Rows</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_IMPL__NUM_ROWS = eINSTANCE.getTableImpl_NumRows();

		/**
		 * The meta object literal for the '<em><b>Num Col</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_IMPL__NUM_COL = eINSTANCE.getTableImpl_NumCol();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_IMPL__TYPE = eINSTANCE.getTableImpl_Type();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.RowImpl <em>Row</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.RowImpl
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getRow()
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
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.CellImpl <em>Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.CellImpl
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getCell()
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
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.ImageImpl <em>Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.ImageImpl
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getImage()
		 * @generated
		 */
		EClass IMAGE = eINSTANCE.getImage();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__WIDTH = eINSTANCE.getImage_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__HEIGHT = eINSTANCE.getImage_Height();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__TYPE = eINSTANCE.getImage_Type();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.EmbeddedExcelImpl <em>Embedded Excel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.EmbeddedExcelImpl
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getEmbeddedExcel()
		 * @generated
		 */
		EClass EMBEDDED_EXCEL = eINSTANCE.getEmbeddedExcel();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.WordTableImpl <em>Word Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.WordTableImpl
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getWordTable()
		 * @generated
		 */
		EClass WORD_TABLE = eINSTANCE.getWordTable();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.impl.ParagraphImplImpl <em>Paragraph Impl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.ParagraphImplImpl
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getParagraphImpl()
		 * @generated
		 */
		EClass PARAGRAPH_IMPL = eINSTANCE.getParagraphImpl();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAGRAPH_IMPL__TEXT = eINSTANCE.getParagraphImpl_Text();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.FontFamily <em>Font Family</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.FontFamily
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getFontFamily()
		 * @generated
		 */
		EEnum FONT_FAMILY = eINSTANCE.getFontFamily();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.Color <em>Color</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.Color
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getColor()
		 * @generated
		 */
		EEnum COLOR = eINSTANCE.getColor();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.Alignment <em>Alignment</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.Alignment
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getAlignment()
		 * @generated
		 */
		EEnum ALIGNMENT = eINSTANCE.getAlignment();

		/**
		 * The meta object literal for the '{@link benchmarkdp.datagenerator.model.PSMDocx.TableType <em>Table Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see benchmarkdp.datagenerator.model.PSMDocx.TableType
		 * @see benchmarkdp.datagenerator.model.PSMDocx.impl.PSMDocxPackageImpl#getTableType()
		 * @generated
		 */
		EEnum TABLE_TYPE = eINSTANCE.getTableType();

	}

} //PSMDocxPackage
