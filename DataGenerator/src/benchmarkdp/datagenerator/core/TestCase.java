package benchmarkdp.datagenerator.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import benchmarkdp.datagenerator.generator.utils.Utils;
import benchmarkdp.datagenerator.properties.ExperimentProperties;

public class TestCase {

    private String ID;

    private String testCaseName;

    private TestFeature testFeature;

    private TestModel testModel;

    private Metadata metadata;

    private TextElements textElements;

    private IGeneratedCode generatedCode;

    private boolean status = false;

    private String testCaseState;

    private String initModelPath;

    private String pimModelPath;

    private String psmModelPath;

    private String generatedDocument;

    private String modelMetadata;

    private String modelText;

    private String generatedMetadata;

    private String generatedText;

    private String fitsFile;

    private String metadataFile;

    private String textFile;

    private String platform;

    private double timeToGen;

    public TestCase() {
        ID = UUID.randomUUID().toString();
        testCaseName = ID.replace("-", "");
        metadata = new Metadata();
        textElements = new TextElements();
        testModel = new TestModel();
        testCaseState = "NULL";
    }

    public TestCase(String tName) {
        this();
        testCaseName = tName;
    }

    public TestCase(TestModel tm) {
        this();
        testModel = tm;
    }

    public TestCase(TestCase tC) {
        this();
        metadata.add(tC.getMetadata());
        textElements.addText(tC.getTextElements());
        testFeature = tC.getTestFeature();
        testModel.setParent(tC.getTestModel());
    }

    public String getID() {
        return ID;
    }

    @XmlElement(name = "name")
    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public TestFeature getTestFeature() {
        return testFeature;
    }

    public void setStatus(boolean st) {
        status = st;
    }

    // @XmlElement(name="")
    public void setTestFeature(TestFeature testFeature) {
        if (testFeature.getName() != null) {
            this.testCaseName = testFeature.getName();
        }
        this.testFeature = testFeature;
    }

    public TestModel getTestModel() {
        return testModel;
    }

    @XmlTransient // causes an exception if not set
    public void setTestModel(TestModel tM) {
        testModel = tM;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    @XmlTransient
    public void setMetadata(Metadata m) {
        metadata.add(m);
    }

    public TextElements getTextElements() {
        return textElements;
    }

    public void setGeneratedCode(IGeneratedCode gC) {
        generatedCode = gC;
        platform = generatedCode.getPlatform();
    }

    public String getTestCaseState() {
        return testCaseState;
    }

    @XmlElement(name = "testCaseState")
    public void setTestCaseState(String testCaseState) {
        this.testCaseState = testCaseState;
    }

    public String getInitModelPath() {
        return initModelPath;
    }

    @XmlElement(name = "initModelPath")
    public void setInitModelPath(String initModelPath) {
        this.initModelPath = initModelPath;
    }

    public String getPimModelPath() {
        return pimModelPath;
    }

    @XmlElement(name = "pimModelPath")
    public void setPimModelPath(String pimModelPath) {
        this.pimModelPath = pimModelPath;
    }

    public String getPsmModelPath() {
        return psmModelPath;
    }

    @XmlElement(name = "psmModelPath")
    public void setPsmModelPath(String psmModelPath) {
        this.psmModelPath = psmModelPath;
    }

    public String getGeneratedDocument() {
        return generatedDocument;
    }

    @XmlElement(name = "generatedDocument")
    public void setGeneratedDocument(String generatedDocument) {
        this.generatedDocument = generatedDocument;
    }

    public String getGeneratedMetadata() {
        return generatedMetadata;
    }

    @XmlElement(name = "generatedMetadata")
    public void setGeneratedMetadata(String generatedMetadata) {
        this.generatedMetadata = generatedMetadata;
    }

    public String getGeneratedText() {
        return generatedText;
    }

    @XmlElement(name = "generatedText")
    public void setGeneratedText(String generatedText) {
        this.generatedText = generatedText;
    }

    public String getFitsFile() {
        return fitsFile;
    }

    @XmlElement(name = "fitsFile")
    public void setFitsFile(String fitsFile) {
        this.fitsFile = fitsFile;
    }

    public String getModelMetadata() {
        return modelMetadata;
    }

    @XmlElement(name = "modelMetadata")
    public void setModelMetadata(String modelMetadata) {
        this.modelMetadata = modelMetadata;
    }

    public String getModelText() {
        return modelText;
    }

    @XmlElement(name = "modelText")
    public void setModelText(String modelText) {
        this.modelText = modelText;
    }

    public String getMetadataFile() {
        return metadataFile;
    }

    @XmlElement(name = "metadataFile")
    public void setMetadataFile(String metadataFile) {
        this.metadataFile = metadataFile;
    }

    public String getTextFile() {
        return textFile;
    }

    @XmlElement(name = "textFile")
    public void setTextFile(String textFile) {
        this.textFile = textFile;
    }

    public String getPlatform() {
        return platform;
    }

    @XmlElement(name = "platform")
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public double getTimeToGen() {
        return timeToGen;
    }

    @XmlElement(name = "secToGenerate")
    public void setTimeToGen(double timeToGen) {
        this.timeToGen = timeToGen;
    }

    public void saveTestCaseComponents(ExperimentProperties ep) {

        String basePath = ep.getFullFolderPath();
        String modelPath = basePath + "/" + ep.getModelsFolder() + "/";
        if (testModel != null) {
            testModel.saveModelToFile(modelPath, testCaseName);
        }

        String codePath = basePath + "/" + ep.getMacroFolder() + "/";
        if (generatedCode != null) {
            generatedCode.saveToFile(codePath, testCaseName);
        }

        String metadataPath = basePath + "/" + ep.getModelMetadataFolder() + "/";
        String textPath = basePath + "/" + ep.getModelTextFolder() + "/";
        if (testCaseState.compareTo("FITS_DONE") == 0) {
            // if (ep.getExperimentState().compareTo("FINALIZED") == 0) {
            metadataPath = basePath + "/" + ep.getMetadataFolder() + "/";
            textPath = basePath + "/" + ep.getTextFolder() + "/";
        }
        if (metadata != null) {
            metadata.saveToXML(metadataPath, testCaseName);
        }

        if (textElements != null) {
            textElements.saveToXML(textPath, testCaseName);
        }
    }

    public void saveTestCaseComponents(String metadataPath, String textPath, boolean flag) {

        if (flag) {
            if (testModel != null) {
                testModel.saveModelToFile(Utils.modelsPath, testCaseName);
            }

            if (generatedCode != null) {
                generatedCode.saveToFile(Utils.macroPath, testCaseName);
            }
        }

        if (metadata != null) {
            metadata.saveToXML(metadataPath, testCaseName);
        }
        if (textElements != null) {
            textElements.saveToXML(textPath, testCaseName);
        }

        File f = new File(Utils.basePath + "testcases.tsv");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            bw.write(testCaseName + "\t" + status + "\n");
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void load(ExperimentProperties ep) {
        // if (true){
        if (testCaseState == "INITIALIZED") {
            testModel = new TestModel(initModelPath, ModelType.PIM);
        } else {
            String pimPath = ep.getFullFolderPath() + "/" + pimModelPath;
            TestModel pimModel = new TestModel(pimPath, ModelType.PIM);

            String psmPath = ep.getFullFolderPath() + "/" + psmModelPath;
            TestModel psmModel = new TestModel(psmPath, null);

            psmModel.setParent(pimModel);

            testModel = psmModel;
        }
    }

}
