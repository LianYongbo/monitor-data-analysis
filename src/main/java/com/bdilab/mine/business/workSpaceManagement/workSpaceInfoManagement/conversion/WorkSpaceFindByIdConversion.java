package com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.conversion;

import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.business.WorkSpace;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.standard.WorkSpaceFindByIdStandard;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.view.WorkSpaceFindByIdView;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.verification.WorkSpaceInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 根据工区编号查找工区数据结构转换
 *
 * @author Lian
 * @date 2021/2/20 9:45
 **/
@Component
public class WorkSpaceFindByIdConversion {
    private final WorkSpaceInfoManagementVerifyIntegrity workSpaceInfoManagementVerifyIntegrity;

    public WorkSpaceFindByIdConversion(WorkSpaceInfoManagementVerifyIntegrity workSpaceInfoManagementVerifyIntegrity) {
        this.workSpaceInfoManagementVerifyIntegrity = workSpaceInfoManagementVerifyIntegrity;
    }

    /**
     * 根据工区编号查找工区接口入参转换为业务对象
     *
     * @param workSpaceFindByIdStandard 根据工区编号查找工区入参
     * @return 转换后的业务对象
     */
    public WorkSpace conversion(WorkSpaceFindByIdStandard workSpaceFindByIdStandard) {
        if (!workSpaceInfoManagementVerifyIntegrity.verify(workSpaceFindByIdStandard)) {
            System.out.println("根据组织编号查找工区接口 - 入参转换业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        WorkSpace workSpace = new WorkSpace();
        workSpace.setWorkSpaceId(workSpaceFindByIdStandard.getWorkSpaceId());
        workSpace.setWorkSpaceParentId(workSpaceFindByIdStandard.getWorkSpaceParentId());
        return workSpace;
    }

    /**
     * 根据工区编号查找工区接口业务对象转换为入参
     *
     * @param workSpace 根据工区编号查找工区业务对象
     * @return 转换后的出参
     */
    public WorkSpaceFindByIdView conversion(WorkSpace workSpace) {
        int type = 2;
        if (!workSpaceInfoManagementVerifyIntegrity.verifyFindByParentId(workSpace, type)) {
            System.out.println("根据工区编号查找工区接口 - 业务对象转换出参 - " + new Date() + " - 业务对象有误！");
        }
        WorkSpaceFindByIdView workSpaceFindByIdView = new WorkSpaceFindByIdView();
        workSpaceFindByIdView.setWorkSpaceId(workSpace.getWorkSpaceId());
        workSpaceFindByIdView.setWorkSpaceParentId(workSpace.getWorkSpaceParentId());
        workSpaceFindByIdView.setWorkSpaceName(workSpace.getWorkSpaceName());
        workSpaceFindByIdView.setWorkSpaceAddress(workSpace.getWorkSpaceAddress());
        workSpaceFindByIdView.setWorkSpaceContact(workSpace.getWorkSpaceContact());
        workSpaceFindByIdView.setWorkSpacePeopleNumber(workSpace.getWorkSpacePeopleNumber());
        workSpaceFindByIdView.setWorkSpaceRemark(workSpace.getWorkSpaceRemark());
        return workSpaceFindByIdView;
    }
}
