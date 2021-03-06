package com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.conversion;

import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.business.Workspace;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.standard.WorkSpaceFindByParentIdStandard;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.view.WorkSpaceFindByParentIdView;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.verification.WorkSpaceInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 根据父组织编号查找工区数据结构转换
 *
 * @author Lian
 * @date 2021/2/20 9:46
 **/
@Component
public class WorkSpaceFindByParentIdConversion {
    private final WorkSpaceInfoManagementVerifyIntegrity workSpaceInfoManagementVerifyIntegrity;

    public WorkSpaceFindByParentIdConversion(WorkSpaceInfoManagementVerifyIntegrity workSpaceInfoManagementVerifyIntegrity) {
        this.workSpaceInfoManagementVerifyIntegrity = workSpaceInfoManagementVerifyIntegrity;
    }

    /**
     * 根据父组织编号查找工区接口入参转换为业务对象
     *
     * @param workSpaceFindByParentIdStandard 根据父组织编号查找工区入参
     * @return 转换后的业务对象
     */
    public Workspace conversion(WorkSpaceFindByParentIdStandard workSpaceFindByParentIdStandard) {
        if (!workSpaceInfoManagementVerifyIntegrity.verify(workSpaceFindByParentIdStandard)) {
            System.out.println("根据父组织编号查找工区接口 - 入参转换业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        Workspace workSpace = new Workspace();
        workSpace.setWorkspaceParentId(workSpaceFindByParentIdStandard.getWorkSpaceParentId());
        return workSpace;
    }

    /**
     * 根据父组织编号查找工区接口业务对象转换为入参
     *
     * @param workSpace 根据父组织编号查找工区业务对象
     * @return 转换后的出参
     */
    public WorkSpaceFindByParentIdView conversion(Workspace workSpace) {
        int type = 2;
        if (!workSpaceInfoManagementVerifyIntegrity.verifyFindByParentId(workSpace, type)) {
            System.out.println("根据父组织编号查找工区接口 - 业务对象转换出参 - " + new Date() + " - 业务对象有误！");
        }
        WorkSpaceFindByParentIdView workSpaceFindByParentIdView = new WorkSpaceFindByParentIdView();
        workSpaceFindByParentIdView.setWorkSpaceId(workSpace.getWorkspaceId());
        workSpaceFindByParentIdView.setWorkSpaceParentId(workSpace.getWorkspaceParentId());
        workSpaceFindByParentIdView.setWorkSpaceName(workSpace.getWorkspaceName());
        workSpaceFindByParentIdView.setWorkSpaceAddress(workSpace.getWorkspaceAddress());
        workSpaceFindByParentIdView.setWorkSpaceContact(workSpace.getWorkspaceContact());
        workSpaceFindByParentIdView.setWorkSpacePeopleNumber(workSpace.getWorkspacePeopleNumber());
        workSpaceFindByParentIdView.setWorkSpaceRemark(workSpace.getWorkspaceRemark());
        return workSpaceFindByParentIdView;
    }
}
