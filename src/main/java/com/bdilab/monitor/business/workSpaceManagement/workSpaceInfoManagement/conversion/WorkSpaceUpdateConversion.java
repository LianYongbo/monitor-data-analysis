package com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.conversion;

import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.business.Workspace;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.standard.WorkSpaceUpdateStandard;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.view.WorkSpaceUpdateView;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.verification.WorkSpaceInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 修改工区信息接口数据结构转换
 *
 * @author Lian
 * @date 2021/2/20 9:43
 **/
@Component
public class WorkSpaceUpdateConversion {
    private final WorkSpaceInfoManagementVerifyIntegrity workSpaceInfoManagementVerifyIntegrity;

    public WorkSpaceUpdateConversion(WorkSpaceInfoManagementVerifyIntegrity workSpaceInfoManagementVerifyIntegrity) {
        this.workSpaceInfoManagementVerifyIntegrity = workSpaceInfoManagementVerifyIntegrity;
    }

    /**
     * 修改工区信息接口入参转换为业务对象
     *
     * @param workSpaceUpdateStandard 修改工区信息入参
     * @return 转换后的业务对象
     */
    public Workspace conversion(WorkSpaceUpdateStandard workSpaceUpdateStandard) {
        if (!workSpaceInfoManagementVerifyIntegrity.verify(workSpaceUpdateStandard)) {
            System.out.println("修改工区信息接口 - 入参转换业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        Workspace workSpace = new Workspace();
        workSpace.setWorkspaceId(workSpaceUpdateStandard.getWorkSpaceId());
        workSpace.setWorkspaceName(workSpaceUpdateStandard.getWorkSpaceName());
        workSpace.setWorkspaceContact(workSpaceUpdateStandard.getWorkSpaceContact());
        workSpace.setWorkspaceAddress(workSpaceUpdateStandard.getWorkSpaceAddress());
        workSpace.setWorkspaceRemark(workSpaceUpdateStandard.getWorkSpaceRemark());
        return workSpace;
    }

    /**
     * 修改工区信息接口业务对象转换为入参
     *
     * @param workSpace 修改工区信息业务对象
     * @return 转换后的出参
     */
    public WorkSpaceUpdateView conversion(Workspace workSpace) {
        int type = 2;
        if (!workSpaceInfoManagementVerifyIntegrity.verifyUpdate(workSpace, type)) {
            System.out.println("修改工区信息接口 - 业务对象转换出参 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        WorkSpaceUpdateView workSpaceUpdateView = new WorkSpaceUpdateView();
        workSpaceUpdateView.setWorkSpaceId(workSpace.getWorkspaceId());
        workSpaceUpdateView.setWorkSpaceParentId(workSpace.getWorkspaceParentId());
        workSpaceUpdateView.setWorkSpaceName(workSpace.getWorkspaceName());
        workSpaceUpdateView.setWorkSpaceAddress(workSpace.getWorkspaceAddress());
        workSpaceUpdateView.setWorkSpaceContact(workSpace.getWorkspaceContact());
        workSpaceUpdateView.setWorkSpacePeopleNumber(workSpace.getWorkspacePeopleNumber());
        workSpaceUpdateView.setWorkSpaceRemark(workSpace.getWorkspaceRemark());
        return workSpaceUpdateView;
    }
}
