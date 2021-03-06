/**
 */
package benchmarkdp.datagenerator.model.PSMDocx.util;

import benchmarkdp.datagenerator.model.PSMDocx.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage
 * @generated
 */
public class PSMDocxAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PSMDocxPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PSMDocxAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PSMDocxPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PSMDocxSwitch<Adapter> modelSwitch =
		new PSMDocxSwitch<Adapter>() {
			@Override
			public Adapter caseDocument(Document object) {
				return createDocumentAdapter();
			}
			@Override
			public Adapter casePage(Page object) {
				return createPageAdapter();
			}
			@Override
			public Adapter caseElement(Element object) {
				return createElementAdapter();
			}
			@Override
			public Adapter caseTextContainer(TextContainer object) {
				return createTextContainerAdapter();
			}
			@Override
			public Adapter caseTextBox(TextBox object) {
				return createTextBoxAdapter();
			}
			@Override
			public Adapter caseParagraph(Paragraph object) {
				return createParagraphAdapter();
			}
			@Override
			public Adapter caseControlBox(ControlBox object) {
				return createControlBoxAdapter();
			}
			@Override
			public Adapter caseText(Text object) {
				return createTextAdapter();
			}
			@Override
			public Adapter caseSimpleText(SimpleText object) {
				return createSimpleTextAdapter();
			}
			@Override
			public Adapter caseHyperLink(HyperLink object) {
				return createHyperLinkAdapter();
			}
			@Override
			public Adapter caseTableImpl(TableImpl object) {
				return createTableImplAdapter();
			}
			@Override
			public Adapter caseRow(Row object) {
				return createRowAdapter();
			}
			@Override
			public Adapter caseCell(Cell object) {
				return createCellAdapter();
			}
			@Override
			public Adapter caseImage(Image object) {
				return createImageAdapter();
			}
			@Override
			public Adapter caseEmbeddedExcel(EmbeddedExcel object) {
				return createEmbeddedExcelAdapter();
			}
			@Override
			public Adapter caseWordTable(WordTable object) {
				return createWordTableAdapter();
			}
			@Override
			public Adapter caseParagraphImpl(ParagraphImpl object) {
				return createParagraphImplAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link benchmarkdp.datagenerator.model.PSMDocx.Document <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Document
	 * @generated
	 */
	public Adapter createDocumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link benchmarkdp.datagenerator.model.PSMDocx.Page <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Page
	 * @generated
	 */
	public Adapter createPageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link benchmarkdp.datagenerator.model.PSMDocx.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link benchmarkdp.datagenerator.model.PSMDocx.TextContainer <em>Text Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.TextContainer
	 * @generated
	 */
	public Adapter createTextContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link benchmarkdp.datagenerator.model.PSMDocx.TextBox <em>Text Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.TextBox
	 * @generated
	 */
	public Adapter createTextBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link benchmarkdp.datagenerator.model.PSMDocx.Paragraph <em>Paragraph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Paragraph
	 * @generated
	 */
	public Adapter createParagraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link benchmarkdp.datagenerator.model.PSMDocx.ControlBox <em>Control Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.ControlBox
	 * @generated
	 */
	public Adapter createControlBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link benchmarkdp.datagenerator.model.PSMDocx.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Text
	 * @generated
	 */
	public Adapter createTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link benchmarkdp.datagenerator.model.PSMDocx.SimpleText <em>Simple Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.SimpleText
	 * @generated
	 */
	public Adapter createSimpleTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link benchmarkdp.datagenerator.model.PSMDocx.HyperLink <em>Hyper Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.HyperLink
	 * @generated
	 */
	public Adapter createHyperLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link benchmarkdp.datagenerator.model.PSMDocx.TableImpl <em>Table Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.TableImpl
	 * @generated
	 */
	public Adapter createTableImplAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link benchmarkdp.datagenerator.model.PSMDocx.Row <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Row
	 * @generated
	 */
	public Adapter createRowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link benchmarkdp.datagenerator.model.PSMDocx.Cell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Cell
	 * @generated
	 */
	public Adapter createCellAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link benchmarkdp.datagenerator.model.PSMDocx.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.Image
	 * @generated
	 */
	public Adapter createImageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link benchmarkdp.datagenerator.model.PSMDocx.EmbeddedExcel <em>Embedded Excel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.EmbeddedExcel
	 * @generated
	 */
	public Adapter createEmbeddedExcelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link benchmarkdp.datagenerator.model.PSMDocx.WordTable <em>Word Table</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.WordTable
	 * @generated
	 */
	public Adapter createWordTableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link benchmarkdp.datagenerator.model.PSMDocx.ParagraphImpl <em>Paragraph Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see benchmarkdp.datagenerator.model.PSMDocx.ParagraphImpl
	 * @generated
	 */
	public Adapter createParagraphImplAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //PSMDocxAdapterFactory
