package com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.conversion;

import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.business.Workspace;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.standard.WorkSpaceFindByIdStandard;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.view.WorkSpaceFindByIdView;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.verification.WorkSpaceInfoManagementVerifyIntegrity;
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
    public Workspace conversion(WorkSpaceFindByIdStandard workSpaceFindByIdStandard) {
        if (!workSpaceInfoManagementVerifyIntegrity.verify(workSpaceFindByIdStandard)) {
            System.out.println("根据组织编号查找工区接口 - 入参转换业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        Workspace workSpace = new Workspace();
        workSpace.setWorkspaceId(workSpaceFindByIdStandard.getWorkSpaceId());
        workSpace.setWorkspaceParentId(workSpaceFindByIdStandard.getWorkSpaceParentId());
        return workSpace;
    }

    /**
     * 根据工区编号查找工区接口业务对象转换为入参
     *
     * @param workSpace 根据工区编号查找工区业务对象
     * @return 转换后的出参
     */
    public WorkSpaceFindByIdView conversion(Workspace workSpace) {
        int type = 2;
        if (!workSpaceInfoManagementVerifyIntegrity.verifyFindByParentId(workSpace, type)) {
            System.out.println("根据工区编号查找工区接口 - 业务对象转换出参 - " + new Date() + " - 业务对象有误！");
        }
        WorkSpaceFindByIdView workSpaceFindByIdView = new WorkSpaceFindByIdView();
        workSpaceFindByIdView.setWorkSpaceId(workSpace.getWorkspaceId());
        workSpaceFindByIdView.setWorkSpaceParentId(workSpace.getWorkspaceParentId());
        workSpaceFindByIdView.setWorkSpaceName(workSpace.getWorkspaceName());
        workSpaceFindByIdView.setWorkSpaceAddress(workSpace.getWorkspaceAddress());
        workSpaceFindByIdView.setWorkSpaceContact(workSpace.getWorkspaceContact());
        workSpaceFindByIdView.setWorkSpacePeopleNumber(workSpace.getWorkspacePeopleNumber());
        workSpaceFindByIdView.setWorkSpaceRemark(workSpace.getWorkspaceRemark());
        return workSpaceFindByIdView;
    }
}
