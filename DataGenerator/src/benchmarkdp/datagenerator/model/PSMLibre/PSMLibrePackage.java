/**
 */
package benchmarkdp.datagenerator.model.PSMLibre;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
	 * The number of structural features of the '<em>Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_FEATURE_COUNT = 2;

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
	 * The meta object id for the '{@link benchmarkdp.datagenerator.model.PSMLibre.impl.TextContainerImpl <em>Text Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.TextContainerImpl
	 * @see benchmarkdp.datagenerator.model.PSMLibre.impl.PSMLibrePackageImpl#getTextContainer()
	 * @generated
	 */
	int TEXT_CONTAINER = 3;

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
	 * The feature id for the '<em><b>Words</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH__WORDS = TEXT_CONTAINER__WORDS;

	/**
	 * The number of structural features of the '<em>Paragraph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAGRAPH_FEATURE_COUNT = TEXT_CONTAINER_FEATURE_COUNT + 0;

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

	}

} //PSMLibrePackage