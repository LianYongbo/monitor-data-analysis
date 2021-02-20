package com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.conversion;

import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.business.WorkSpace;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.standard.WorkSpaceUpdateStandard;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.view.WorkSpaceUpdateView;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.verification.WorkSpaceInfoManagementVerifyIntegrity;
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
    public WorkSpace conversion(WorkSpaceUpdateStandard workSpaceUpdateStandard) {
        if (!workSpaceInfoManagementVerifyIntegrity.verify(workSpaceUpdateStandard)) {
            System.out.println("修改工区信息接口 - 入参转换业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        WorkSpace workSpace = new WorkSpace();
        workSpace.setWorkSpaceId(workSpaceUpdateStandard.getWorkSpaceId());
        workSpace.setWorkSpaceName(workSpaceUpdateStandard.getWorkSpaceName());
        workSpace.setWorkSpaceContact(workSpaceUpdateStandard.getWorkSpaceContact());
        workSpace.setWorkSpaceAddress(workSpaceUpdateStandard.getWorkSpaceAddress());
        workSpace.setWorkSpaceRemark(workSpaceUpdateStandard.getWorkSpaceRemark());
        return workSpace;
    }

    /**
     * 修改工区信息接口业务对象转换为入参
     *
     * @param workSpace 修改工区信息业务对象
     * @return 转换后的出参
     */
    public WorkSpaceUpdateView conversion(WorkSpace workSpace) {
        int type = 2;
        if (!workSpaceInfoManagementVerifyIntegrity.verifyUpdate(workSpace, type)) {
            System.out.println("修改工区信息接口 - 业务对象转换出参 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        WorkSpaceUpdateView workSpaceUpdateView = new WorkSpaceUpdateView();
        workSpaceUpdateView.setWorkSpaceId(workSpace.getWorkSpaceId());
        workSpaceUpdateView.setWorkSpaceParentId(workSpace.getWorkSpaceParentId());
        workSpaceUpdateView.setWorkSpaceName(workSpace.getWorkSpaceName());
        workSpaceUpdateView.setWorkSpaceAddress(workSpace.getWorkSpaceAddress());
        workSpaceUpdateView.setWorkSpaceContact(workSpace.getWorkSpaceContact());
        workSpaceUpdateView.setWorkSpacePeopleNumber(workSpace.getWorkSpacePeopleNumber());
        workSpaceUpdateView.setWorkSpaceRemark(workSpace.getWorkSpaceRemark());
        return workSpaceUpdateView;
    }
}
