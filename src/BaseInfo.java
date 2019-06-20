import org.apache.poi.hssf.usermodel.*;

public class BaseInfo {
    //线程标志量
    private boolean flag = true;

    //文件名
    private String FileName;
    //编号
    private String Id;
    //消火栓名称
    private String FireHydrant;
    //消火栓地址
    private String FireHydrantAdress;
    //地理坐标
    private String Coordinates;
    //所属路段
    private String Road;
    //所在地消防机构
    private String FireFightingInstitutions;
    //放置形式
    private String PlacementForm;
    //联系方式
    private String PhoneNumber;
    //所属管网
    private String Departments;
    //取水形式
    private String WaterFrom;
    //管网直径
    private String Diameter;
    //水源动态
    private String WaterSourceDy;
    //管网压力
    private String Pressure;
    //归属
    private String Attribution;
    //管网形式
    private String PipeNetwork;
    //可用状态
    private String AvailableState;
    //供水单位
    private String Watersupply;
    //接口形式
    private String InterfaceForm;
    //建成日期
    private String DateOfCompletion;
    //检查记录
    private String Inspectionrecord;
    //备注
    private String Remarks;

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFireHydrant() {
        return FireHydrant;
    }

    public void setFireHydrant(String fireHydrant) {
        FireHydrant = fireHydrant;
    }

    public String getFireHydrantAdress() {
        return FireHydrantAdress;
    }

    public void setFireHydrantAdress(String fireHydrantAdress) {
        FireHydrantAdress = fireHydrantAdress;
    }

    public String getCoordinates() {
        return Coordinates;
    }

    public void setCoordinates(String coordinates) {
        Coordinates = coordinates;
    }

    public String getRoad() {
        return Road;
    }

    public void setRoad(String road) {
        Road = road;
    }

    public String getPlacementForm() {
        return PlacementForm;
    }

    public void setPlacementForm(String placementForm) {
        PlacementForm = placementForm;
    }

    public String getInterfaceForm() {
        return InterfaceForm;
    }

    public void setInterfaceForm(String interfaceForm) {
        InterfaceForm = interfaceForm;
    }

    public String getWaterFrom() {
        return WaterFrom;
    }

    public void setWaterFrom(String waterFrom) {
        WaterFrom = waterFrom;
    }

    public String getDepartments() {
        return Departments;
    }

    public void setDepartments(String departments) {
        Departments = departments;
    }

    public String getPipeNetwork() {
        return PipeNetwork;
    }

    public void setPipeNetwork(String pipeNetwork) {
        PipeNetwork = pipeNetwork;
    }

    public String getDiameter() {
        return Diameter;
    }

    public void setDiameter(String diameter) {
        Diameter = diameter;
    }

    public String getPressure() {
        return Pressure;
    }

    public void setPressure(String pressure) {
        Pressure = pressure;
    }

    public String getWatersupply() {
        return Watersupply;
    }

    public void setWatersupply(String watersupply) {
        Watersupply = watersupply;
    }

    public String getInspectionrecord() {
        return Inspectionrecord;
    }

    public void setInspectionrecord(String inspectionrecord) {
        Inspectionrecord = inspectionrecord;
    }

    public String getFireFightingInstitutions() {
        return FireFightingInstitutions;
    }

    public void setFireFightingInstitutions(String fireFightingInstitutions) {
        FireFightingInstitutions = fireFightingInstitutions;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    public String getWaterSourceDy() {
        return WaterSourceDy;
    }

    public void setWaterSourceDy(String waterSourceDy) {
        WaterSourceDy = waterSourceDy;
    }
    public String getAttribution() {
        return Attribution;
    }

    public void setAttribution(String attribution) {
        Attribution = attribution;
    }

    public String getAvailableState() {
        return AvailableState;
    }

    public void setAvailableState(String availableState) {
        AvailableState = availableState;
    }

    public String getDateOfCompletion() {
        return DateOfCompletion;
    }

    public void setDateOfCompletion(String dateOfCompletion) {
        DateOfCompletion = dateOfCompletion;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public synchronized void set(String FileName,
                                 String Id,
                                 String FireHydrant,
                                 String FireHydrantAdress,
                                 String Coordinates,
                                 String Road,
                                 String FireFightingInstitutions,
                                 String PlacementForm,
                                 String PhoneNumber,
                                 String Departments,
                                 String WaterFrom,
                                 String Diameter,
                                 String WaterSourceDy,
                                 String Pressure,
                                 String Attribution,
                                 String PipeNetwork,
                                 String AvailableState,
                                 String Watersupply,
                                 String InterfaceForm,
                                 String DateOfCompletion,
                                 String Inspectionrecord,
                                 String Remarks){
        if (!flag){
            try{
                super.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //文件名
        this.setFileName(FileName);
        //编号
        this.setId(Id);
        //名称
        this.setFireHydrant(FireHydrant);
        //地址
        this.setFireHydrantAdress(FireHydrantAdress);
        //地理坐标
        this.setCoordinates(Coordinates);
        //所属路段
        this.setRoad(Road);
        //管辖机构
        this.setFireFightingInstitutions(FireFightingInstitutions);
        //放置形式
        this.setPlacementForm(PlacementForm);
        //联系方式
        this.setPhoneNumber(PhoneNumber);
        //所属管网
        this.setDepartments(Departments);
        //取水形式
        this.setWaterFrom(WaterFrom);
        //管网直径
        this.setDiameter(Diameter);
        //水源动态
        this.setWaterSourceDy(WaterSourceDy);
        //管网压力
        this.setPressure(Pressure);
        //归属
        this.setAttribution(Attribution);
        //管网形式
        this.setPipeNetwork(PipeNetwork);
        //可用状态
        this.setAvailableState(AvailableState);
        //供水单位
        this.setWatersupply(Watersupply);
        //接口形式
        this.setInterfaceForm(InterfaceForm);
        //建造日期
        this.setDateOfCompletion(DateOfCompletion);
        //最近一次检查时间
        this.setInspectionrecord(Inspectionrecord);
        //备注
        this.setRemarks(Remarks);

        flag = false;
        super.notify();
    }


    public synchronized BaseInfo get(){
        if (flag){
            try{
                super.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        BaseInfo newinfo = new BaseInfo();
        newinfo.setFileName(this.getFileName());
        newinfo.setId(this.getId());
        newinfo.setFireHydrant(this.getFireHydrant());
        newinfo.setFireHydrantAdress(this.getFireHydrantAdress());
        newinfo.setCoordinates(this.getCoordinates());
        newinfo.setRoad(this.getRoad());
        newinfo.setFireFightingInstitutions(this.getFireFightingInstitutions());
        newinfo.setPlacementForm(this.getPlacementForm());
        newinfo.setPhoneNumber(this.getPhoneNumber());
        newinfo.setDepartments(this.getDepartments());
        newinfo.setWaterFrom(this.getWaterFrom());
        newinfo.setDiameter(this.getDiameter());
        newinfo.setWaterSourceDy(this.getWaterSourceDy());
        newinfo.setPressure(this.getPressure());
        newinfo.setAttribution(this.getAttribution());
        newinfo.setPipeNetwork(this.getPipeNetwork());
        newinfo.setAvailableState(this.getAvailableState());
        newinfo.setWatersupply(this.getWatersupply());
        newinfo.setInterfaceForm(this.getInterfaceForm());
        newinfo.setDateOfCompletion(this.getDateOfCompletion());
        newinfo.setInspectionrecord(this.getInspectionrecord());
        newinfo.setRemarks(this.getRemarks());


        System.out.println("FileName:" + this.getFileName());
        System.out.println("Id:" + this.getId());
        System.out.println("FireHydran:" + this.getFireHydrant());
        System.out.println("FireHydrantAdress:" + this.getFireHydrantAdress());
        System.out.println("Coordinates:" + this.getCoordinates());
        System.out.println("Road:" + this.getRoad());
        System.out.println("FireFightingInstitutions:" + this.getFireFightingInstitutions());
        System.out.println("PlacementForm:" + this.getPlacementForm());
        System.out.println("PhoneNumber:" + this.getPhoneNumber());
        System.out.println("Departments:" + this.getDepartments());
        System.out.println("WaterFrom:" + this.getWaterFrom());
        System.out.println("Diameter:" + this.getDiameter());
        System.out.println("WaterSourceDy:" + this.getWaterSourceDy());
        System.out.println("Pressure:" + this.getPressure());
        System.out.println("Attribution:" + this.getAttribution());
        System.out.println("PipeNetwork:" + this.getPipeNetwork());
        System.out.println("AvailableState:" + this.getAvailableState());
        System.out.println("Watersupply:" + this.getWatersupply());
        System.out.println("InterfaceForm:" + this.getInterfaceForm());
        System.out.println("DateOfCompletion:" + this.getDateOfCompletion());
        System.out.println("Inspectionrecord:" + this.getInspectionrecord());
        System.out.println("Remarks:" + this.getRemarks());
        System.out.println("********************************************************************");

        flag = true;
        super.notify();

        return newinfo;

    }

}
