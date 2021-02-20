package com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.conversion;

import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.business.WorkSpace;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.standard.WorkSpaceDeleteStandard;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.view.WorkSpaceDeleteView;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.verification.WorkSpaceInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 删除工区接口数据结构转换
 *
 * @author Lian
 * @date 2021/2/20 9:44
 **/
@Component
public class WorkSpaceDeleteConversion {
    private final WorkSpaceInfoManagementVerifyIntegrity workSpaceInfoManagementVerifyIntegrity;

    public WorkSpaceDeleteConversion(WorkSpaceInfoManagementVerifyIntegrity workSpaceInfoManagementVerifyIntegrity) {
        this.workSpaceInfoManagementVerifyIntegrity = workSpaceInfoManagementVerifyIntegrity;
    }

    /**
     * 删除工区接口入参转换为业务对象
     *
     * @param workSpaceDeleteStandard 删除工区入参
     * @return 转换后的业务对象
     */
    public WorkSpace conversion(WorkSpaceDeleteStandard workSpaceDeleteStandard) {
        if (!workSpaceInfoManagementVerifyIntegrity.verify(workSpaceDeleteStandard)) {
            System.out.println("删除工区接口 - 入参转换业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        WorkSpace workSpace = new WorkSpace();
        workSpace.setWorkSpaceId(workSpaceDeleteStandard.getWorkSpaceId());
        return workSpace;
    }

    /**
     * 删除工区接口业务对象转换为入参
     *
     * @param workSpace 删除工区业务对象
     * @return 转换后的出参
     */
    public WorkSpaceDeleteView conversion(WorkSpace workSpace) {
        int type = 2;
        if (!workSpaceInfoManagementVerifyIntegrity.verifyDelete(workSpace, type)) {
            System.out.println("删除工区接口 - 业务对象转换出参 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        WorkSpaceDeleteView workSpaceDeleteView = new WorkSpaceDeleteView();
        workSpaceDeleteView.setWorkSpaceId(workSpace.getWorkSpaceId());
        workSpaceDeleteView.setWorkSpaceDeleted(workSpace.getWorkSpaceDeleted());
        return workSpaceDeleteView;
    }
}
