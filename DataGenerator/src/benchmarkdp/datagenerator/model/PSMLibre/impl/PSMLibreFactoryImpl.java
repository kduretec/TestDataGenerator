/**
 */
package benchmarkdp.datagenerator.model.PSMLibre.impl;

import benchmarkdp.datagenerator.model.PSMLibre.*;

import org.eclipse.emf.ecore.EClass;
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
public class PSMLibreFactoryImpl extends EFactoryImpl implements PSMLibreFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PSMLibreFactory init() {
		try {
			PSMLibreFactory thePSMLibreFactory = (PSMLibreFactory)EPackage.Registry.INSTANCE.getEFactory(PSMLibrePackage.eNS_URI);
			if (thePSMLibreFactory != null) {
				return thePSMLibreFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PSMLibreFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PSMLibreFactoryImpl() {
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
			case PSMLibrePackage.DOCUMENT: return createDocument();
			case PSMLibrePackage.PAGE: return createPage();
			case PSMLibrePackage.ELEMENT: return createElement();
			case PSMLibrePackage.TEXT_CONTAINER: return createTextContainer();
			case PSMLibrePackage.PARAGRAPH: return createParagraph();
			case PSMLibrePackage.TEXT: return createText();
			case PSMLibrePackage.SIMPLE_TEXT: return createSimpleText();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
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
	public Element createElement() {
		ElementImpl element = new ElementImpl();
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextContainer createTextContainer() {
		TextContainerImpl textContainer = new TextContainerImpl();
		return textContainer;
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
	public Text createText() {
		TextImpl text = new TextImpl();
		return text;
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
	public PSMLibrePackage getPSMLibrePackage() {
		return (PSMLibrePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PSMLibrePackage getPackage() {
		return PSMLibrePackage.eINSTANCE;
	}

} //PSMLibreFactoryImpl
