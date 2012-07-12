package view;

import model.ConnectionManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Bernhard
 * Date: 07.07.12
 * Time: 13:36
 * To change this template use File | Settings | File Templates.
 */
public class MainForm extends JFrame{
    private JButton logoutButton;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;
    private JTextField consoleTextField;
    private JButton consoleSendButton;
    private JComboBox comboBox1;
    private JTable table1;
    private JButton objectEditorApplyButton;
    private JButton objectEditorReloadDataButton;
    private JButton objectEditorSaveButton;
    private JComboBox comboBox2;
    private JTable table2;
    private JButton stateEditorApplyButton;
    private JButton stateEditorReloadDataButton;
    private JButton stateEditorSaveButton;
    private JButton restartMatchButton;
    private JButton drawButton;
    private JButton extendTimelimitButton;
    private JButton pauseButton;
    private JButton unpauseButton;
    private JTextField broadcastMessageTextField;
    private JButton broadcastMessageSendButton;
    private JButton loadMapButton;
    private JButton uploadMapButton;
    private JButton mapRotationButton;
    private JButton nextMapButton;
    private JTextField xpMultiplierTextField;
    private JTextField xpOnConnectTextField;
    private JTextField honorTextField;
    private JTextField skillTextField;
    private JTextField heroTextField;
    private JTextField legendTextField;
    private JTextField playerBuildTextField;
    private JTextField repairTextField;
    private JTextField mineTextField;
    private JTextField killNPCTextField;
    private JTextField killWorkerTextField;
    private JTextField killPlayerTextField;
    private JTextField killSiegeTextField;
    private JTextField killItemTextField;
    private JTextField hitBuildingTextField;
    private JTextField lastHitOnBuildingTextField;
    private JTextField healPlayerTextField;
    private JTextField revivePlayerTextField;
    private JTextField orderGivenTextField;
    private JTextField orderFollowedTextField;
    private JTextField resourcesGatheredTextField;
    private JTextField powerupGivenTextField;
    private JTextField commanderBuildTextField;
    private JTextField researchTextField;
    private JTextField destroyEnemyBuildingTextField;
    private JTextField specAccelerationTextField;
    private JTextField playerSpeedTextField;
    private JTextField gravityTextField;
    private JTextField frictionTextField;
    private JTextField airControlTextField;
    private JTextField sprintBurstTextField;
    private JTextField sprintSpeedTextField;
    private JTextField stepHeightTextField;
    private JTextField jumpHeightTextField;
    private JTextField jumpStaminaCostTextField;
    private JTextField leapStaminaCostTextField;
    private JTextField staminaDepleteSpeedTextField;
    private JTextField sprintRegenSlowTextField;
    private JTextField sprintRegenFastTextField;
    private JTextField sprintDeadZoneTextField;
    private JTextField sprintRegainDelayTextField;
    private JTextField sprintRegainLandDelayTextField;
    private JTextField maxBlockTimeTextField;
    private JTextField blockSpeedTextField;
    private JTextField slowWeaponAttackTextField;
    private JTextField attackingSpeedTextField;
    private JTextField minSlopeTextField;
    private JTextField minFallDamage;
    private JTextField maxPushTextField;
    private JTextField uphillLeapTimeTextField;
    private JTextField pushRangeTextField;
    private JTextField pushForceTextField;
    private JTextField grabRangeTextField;
    private JTextField throwForceTextField;
    private JTextField quakeMultiplierTextField;
    private JCheckBox allowVotingCheckBox;
    private JCheckBox concedeVotesCheckBox;
    private JCheckBox drawVotesCheckBox;
    private JCheckBox electVotesCheckBox;
    private JCheckBox impeachVotesCheckBox;
    private JCheckBox kickVotesCheckBox;
    private JCheckBox mapVotesCheckBox;
    private JCheckBox messageVotesCheckBox;
    private JCheckBox muteVotesCheckBox;
    private JCheckBox nextMapVotesCheckBox;
    private JCheckBox pauseVotesCheckBox;
    private JCheckBox unpauseVotesCheckBox;
    private JCheckBox raceVotesCheckBox;
    private JCheckBox refVotesCheckBox;
    private JCheckBox restartVotesCheckBox;
    private JCheckBox shuffleVotesCheckBox;
    private JCheckBox timeVotesCheckBox;
    private JTextField voteDurationTextField;
    private JTextField minVotePercentTextField;
    private JTextField forceCommanderPlayerLimitTextField;
    private JCheckBox enableGoodieBagsCheckBox;
    private JComboBox allowPickupComboBox;
    private JTextField durationTextField;
    private JTextField playerOnlyTimeTextField;
    private JTextField maxValueTextField;
    private JTextField jackpotChanceTextField;
    private JTextField ammoChanceTextField;
    private JCheckBox allowWorkAnimationsCheckBox;
    private JCheckBox allowMineDepletionCheckBox;
    private JCheckBox allowTaxChangeCheckBox;
    private JCheckBox buyStuffForFreeCheckBox;
    private JTextField startingStoneTextField;
    private JTextField startingGoldTextField;
    private JButton upButton;
    private JButton downButton;
    private JButton leftButton;
    private JButton rightButton;
    private JButton leftButton2;
    private JButton rightButton1;
    private JButton upButton2;
    private JButton downButton2;
    private JButton kickButton;
    private JButton banButton;
    private JButton muteButton;
    private JButton unmuteButton;
    private JButton setCommanderButton;
    private JButton promoteButton;
    private JButton demoteButton;
    private JButton shuffleEvenTeamsButton;
    private JComboBox comboBox4;
    private JButton applyButton2;
    private JTable table3;
    private JButton settingsReloadDataButton;
    private JButton settingsApplyButton;
    private JButton generalReloadDataButton;
    private JButton generalApplyButton;
    private JButton advanced1ReloadDataButton;
    private JButton votesReloadDataButton;
    private JButton votesApplyButton;
    private JButton resourcesReloadDataButton;
    private JButton resourcesApplyButton;
    private JButton experienceReloadDataButton;
    private JButton experienceApplyButton;
    private JButton physicsReloadDataButton;
    private JButton physicsApplyButton;
    private JTextField serverNameTextField;
    private JComboBox team1ComboBox;
    private JComboBox team2ComboBox;
    private JComboBox team3ComboBox;
    private JComboBox team4ComboBox;
    private JTextField motd1TextField;
    private JTextField motd2TextField;
    private JTextField motd3TextField;
    private JTextField motd4TextField;
    private JTextField motd5TextField;
    private JTextField motd6TextField;
    private JTextField joinPasswordTextField;
    private JTextField adminPasswordTextField;
    private JTextField refereePasswordTextField;
    private JTextField godRefPasswordTextField;
    private JTextField maxPlayersTextField;
    private JTextField serverNotesTextField;
    private JCheckBox balancedTeamsCheckBox;
    private JTextField connectMoneyTextField;
    private JTextField maxMoneyTextField;
    private JTextField reviveMoneyRewardTextField;
    private JTextField readyPercentTextField;
    private JCheckBox allowSpawningAtAllCheckBox;
    private JCheckBox infiniteGoldAtWarmupCheckBox;
    private JCheckBox enableAllTechsAtWarmupCheckBox;
    private JCheckBox allowAnyoneCheckBox;
    private JCheckBox allowOfficersCheckBox;
    private JCheckBox allowCommandersCheckBox;
    private JCheckBox allowGlobalVOIPChattingCheckBox;
    private JCheckBox allowTeamVOIPChattingCheckBox;
    private JCheckBox allowSquadVOIPChattingCheckBox;
    private JTextField maxStreamTimeTextField;
    private JTextField streamWaitTimeTextField;
    private JCheckBox broadcastServerCheckBox;
    private JCheckBox sendStatsCheckBox;
    private JButton advanced1ApplyButton;
    private JCheckBox enableSquadsCheckBox;
    private JCheckBox squadAutoAssignCheckBox;
    private JTextField maxOfficerTextField;
    private JTextField clientsPerOfficerTextField;
    private JTextField autoSquadMinimumTextField;
    private JTextField squadMembersPerSquadOfficerTextField;
    private JTextField teamSwitchDelayTextField;
    private JTextField teamSwitchFreedomTextField;
    private JTextField respawnTimeTextField;
    private JTextField resurrectTimeTextField;
    private JTextField invincibleTimeTextField;
    private JTextField invincibleTimeRespawnFactorTextField;
    private JTextField skillfullKillDistanceTextField;
    private JTextField blockArcMultiplierTextField;
    private JButton advanced2ReloadDataButton;
    private JButton advanced2ApplyButton;
    private JCheckBox claimableBuildingsCheckBox;
    private JCheckBox repairCostsCheckBox;
    private JCheckBox overtimeDecayCheckBox;
    private JTextField buildingTestScaleTextField;
    private JTextField minClaimIntervalTextField;
    private JTextField repairCostFactorTextField;
    private JTextField buildingDamageRateTextField;
    private JTextField decayRateTextField;
    private JTextField minBuildingHPTextField;
    private JTextField maintainBuildingHPCostTextField;
    private JCheckBox preventRelocExploitsCheckBox;
    private JCheckBox allowItemDropActionCheckBox;
    private JCheckBox allowItemDropOnDeathCheckBox;
    private JCheckBox allowToPickupEnemyCheckBox;
    private JTextField minLandmineDistanceTextField;
    private JTextField bouncingProjectileRestVelocityTextField;
    private JTextField bouncingProjectileRestSlopeTextField;
    private JTextField droppedItemExpiryTimeTextField;
    private JTextField droppedItemPickupDistanceTextField;
    private JCheckBox allowTeamDamageCheckBox;
    private JCheckBox allowMeleeTeamDamageCheckBox;
    private JCheckBox allowWeaponTeamDamageCheckBox;
    private JCheckBox allowSiegeTeamDamageCheckBox;
    private JCheckBox allowTowerTeamDamageCheckBox;
    private JTextField teamDamagePercentTextField;
    private JCheckBox allowDemoListingCheckBox;
    private JTextField replayFolderTextField;
    private JTextField demoFolderTextField;
    private JCheckBox demoRecordVotesCheckBox;
    private JCheckBox demoReplayVotesCheckBox;
    private JButton reloadDataButton10;
    private JTextField specSpeedTextField;
    private JPanel contentPane;
    private JCheckBox fallingDamageCheckBox;
    private JCheckBox uphillLeapCheckBox;
    private JPanel mapsImagePanel;
    private JLabel currentMapTextField;
    private JLabel nextMapTextField;
    private JButton reloadDataButton;
    private JButton reloadDataButton1;
    private JCheckBox allowItemTeamDamageCheckBox;
    private JCheckBox replayDemosCheckBox;
    private JCheckBox recordDemosCheckBox;
    private ConnectionManager cman;

    public MainForm(ConnectionManager cman) {
        setTitle("Login");
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.cman=cman;
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLogOut();
            }
        });
        pack();
        setVisible(true);
        extendTimelimitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onExtendTime();
            }
        });
        broadcastMessageSendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBroadcastMessageSend();
            }
        });
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDraw();
            }
        });
        restartMatchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRestartMatch();
            }
        });
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPause();
            }
        });
        unpauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onUnpause();
            }
        });
        nextMapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onNextMap();
            }
        });
        generalApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onGeneralApply();
            }
        });
        generalReloadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onGeneralReloadData();
            }
        });
        advanced1ApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAdvanced1Apply();
            }
        });
        advanced1ReloadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAdvanced1ReloadData();
            }
        });
        advanced2ApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAdvanced2Apply();
            }
        });
        recordDemosCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                onRecordDemos();
            }
        });
        replayDemosCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                onReplayDemos();
            }
        });
        advanced2ReloadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAdvanced2ReloadData();
            }
        });
        allowTeamDamageCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                onTeamDamage();
            }
        });
    }

    private void onTeamDamage() {
        if (allowTeamDamageCheckBox.isSelected()) {
            allowMeleeTeamDamageCheckBox.setEnabled(true);
            allowWeaponTeamDamageCheckBox.setEnabled(true);
            allowSiegeTeamDamageCheckBox.setEnabled(true);
            allowTowerTeamDamageCheckBox.setEnabled(true);
            allowItemTeamDamageCheckBox.setEnabled(true);
        }
        else {
            allowMeleeTeamDamageCheckBox.setEnabled(false);
            allowWeaponTeamDamageCheckBox.setEnabled(false);
            allowSiegeTeamDamageCheckBox.setEnabled(false);
            allowTowerTeamDamageCheckBox.setEnabled(false);
            allowItemTeamDamageCheckBox.setEnabled(false);
        }

    }

    private void onReplayDemos() {
        if (replayDemosCheckBox.isSelected()) recordDemosCheckBox.setSelected(false);
    }

    private void onRecordDemos() {
        if (recordDemosCheckBox.isSelected()) replayDemosCheckBox.setSelected(false);
    }

    private void onAdvanced2ReloadData() {
        String[] names={
            "sv_placebuildingtestscale",
            "sv_claimableBuildings",
            "sv_minClaimInterval",
            "sv_repairCost",
            "sv_repairMult",
            "sv_buildingDmgScale",
            "sv_overtime_decay",
            "sv_zeroRelocVelocity",
            "sv_landminedistance",
            "sv_projRestVelocity",
            "sv_projRestSlope",
            "sv_allowItemDropAction",
            "sv_allowItemDropDeath",
            "sv_allowItemPickEnemy",
            "sv_itemDropDuration",
            "sv_itemPickDistance",
            "sv_teamDamage",
            "sv_teamMeleeDamage",
            "sv_teamWeaponDamage",
            "sv_teamSiegeDamage",
            "sv_teamBuildingDamage",
            "sv_teamItemDamage",
            "sv_teamDamagePercent",
            "serverdemos_recordserver",
            "serverdemos_replayserver",
            "sv_allowlistdemos",
            "serverdemos_dir",
            "serverdemos_savedir"
        };
        HashMap<String,String> config=cman.get(names);
        buildingTestScaleTextField.setText(config.get("sv_placebuildingtestscale"));
        if (config.get("sv_claimableBuildings").equals("1")) claimableBuildingsCheckBox.setSelected(true);
        else claimableBuildingsCheckBox.setSelected(false);
        minClaimIntervalTextField.setText(config.get("sv_minClaimInterval"));
        if (config.get("sv_repairCost").equals("1")) repairCostsCheckBox.setSelected(true);
        else repairCostsCheckBox.setSelected(false);
        repairCostFactorTextField.setText(config.get("sv_repairMult"));
        buildingDamageRateTextField.setText(config.get("sv_buildingDmgScale"));
        if (config.get("sv_overtime_decay").equals("1")) overtimeDecayCheckBox.setSelected(true);
        else overtimeDecayCheckBox.setSelected(false);
        if (config.get("sv_zeroRelocVelocity").equals("1")) preventRelocExploitsCheckBox.setSelected(true);
        else preventRelocExploitsCheckBox.setSelected(false);
        minLandmineDistanceTextField.setText(config.get("sv_landminedistance"));
        bouncingProjectileRestVelocityTextField.setText(config.get("sv_projRestVelocity"));
        bouncingProjectileRestSlopeTextField.setText(config.get("sv_projRestSlope"));
        if (config.get("sv_allowItemDropAction").equals("1")) allowItemDropActionCheckBox.setSelected(true);
        else allowItemDropActionCheckBox.setSelected(false);
        if (config.get("sv_allowItemDropDeath").equals("1")) allowItemDropOnDeathCheckBox.setSelected(true);
        else allowItemDropOnDeathCheckBox.setSelected(false);
        if (config.get("sv_allowItemPickEnemy").equals("1")) allowToPickupEnemyCheckBox.setSelected(true);
        else allowToPickupEnemyCheckBox.setSelected(false);
        droppedItemExpiryTimeTextField.setText(config.get("sv_itemDropDuration"));
        droppedItemPickupDistanceTextField.setText(config.get("sv_itemPickDistance"));
        if (config.get("sv_teamDamage").equals("1")) allowTeamDamageCheckBox.setSelected(true);
        else allowTeamDamageCheckBox.setSelected(false);
        if (config.get("sv_teamMeleeDamage").equals("1")) allowMeleeTeamDamageCheckBox.setSelected(true);
        else allowMeleeTeamDamageCheckBox.setSelected(false);
        if (config.get("sv_teamWeaponDamage").equals("1")) allowWeaponTeamDamageCheckBox.setSelected(true);
        else allowWeaponTeamDamageCheckBox.setSelected(false);
        if (config.get("sv_teamSiegeDamage").equals("1")) allowSiegeTeamDamageCheckBox.setSelected(true);
        else allowSiegeTeamDamageCheckBox.setSelected(false);
        if (config.get("sv_teamBuildingDamage").equals("1")) allowTowerTeamDamageCheckBox.setSelected(true);
        else allowTowerTeamDamageCheckBox.setSelected(false);
        if (config.get("sv_teamItemDamage").equals("1")) allowItemTeamDamageCheckBox.setSelected(true);
        else allowItemTeamDamageCheckBox.setSelected(false);
        teamDamagePercentTextField.setText(config.get("sv_teamDamagePercent"));
        if (config.get("serverdemos_recordserver").equals("1")) recordDemosCheckBox.setSelected(true);
        else recordDemosCheckBox.setSelected(false);
        if (config.get("serverdemos_replayserver").equals("1")) replayDemosCheckBox.setSelected(true);
        else replayDemosCheckBox.setSelected(false);
        if (config.get("sv_allowlistdemos").equals("1")) allowDemoListingCheckBox.setSelected(true);
        else allowDemoListingCheckBox.setSelected(false);
        replayFolderTextField.setText(config.get("serverdemos_dir"));
        demoFolderTextField.setText(config.get("serverdemos_savedir"));
    }

    private void onAdvanced2Apply() {
        HashMap<String,String> config=new HashMap<String, String>();
        config.put("sv_placebuildingtestscale",buildingTestScaleTextField.getText());
        config.put("sv_claimableBuildings",claimableBuildingsCheckBox.isSelected()?"1":"0");
        config.put("sv_minClaimInterval",minClaimIntervalTextField.getText());
        config.put("sv_repairCost",repairCostsCheckBox.isSelected()?"1":"0");
        config.put("sv_repairMult",repairCostFactorTextField.getText());
        config.put("sv_buildingDmgScale",buildingDamageRateTextField.getText());
        config.put("sv_overtime_decay",overtimeDecayCheckBox.isSelected()?"1":"0");
        config.put("sv_zeroRelocVelocity",preventRelocExploitsCheckBox.isSelected()?"1":"0");
        config.put("sv_landminedistance",minLandmineDistanceTextField.getText());
        config.put("sv_projRestVelocity",bouncingProjectileRestVelocityTextField.getText());
        config.put("sv_projRestSlope",bouncingProjectileRestSlopeTextField.getText());
        config.put("sv_allowItemDropAction",allowItemDropActionCheckBox.isSelected()?"1":"0");
        config.put("sv_allowItemDropDeath",allowItemDropOnDeathCheckBox.isSelected()?"1":"0");
        config.put("sv_allowItemPickEnemy",allowToPickupEnemyCheckBox.isSelected()?"1":"0");
        config.put("sv_itemDropDuration",droppedItemExpiryTimeTextField.getText());
        config.put("sv_itemPickDistance",droppedItemPickupDistanceTextField.getText());
        config.put("sv_teamDamage",allowTeamDamageCheckBox.isSelected()?"1":"0");
        config.put("sv_teamMeleeDamage",allowMeleeTeamDamageCheckBox.isSelected()?"1":"0");
        config.put("sv_teamWeaponDamage",allowWeaponTeamDamageCheckBox.isSelected()?"1":"0");
        config.put("sv_teamSiegeDamage",allowSiegeTeamDamageCheckBox.isSelected()?"1":"0");
        config.put("sv_teamBuildingDamage",allowTowerTeamDamageCheckBox.isSelected()?"1":"0");
        config.put("sv_teamItemDamage",allowItemTeamDamageCheckBox.isSelected()?"1":"0");
        config.put("sv_teamDamagePercent",teamDamagePercentTextField.getText());
        config.put("serverdemos_recordserver",recordDemosCheckBox.isSelected()?"1":"0");
        config.put("serverdemos_replayserver",replayDemosCheckBox.isSelected()?"1":"0");
        config.put("sv_allowlistdemos",allowDemoListingCheckBox.isSelected()?"1":"0");
        config.put("serverdemos_dir",replayFolderTextField.getText());
        config.put("serverdemos_savedir",demoFolderTextField.getText());
        cman.set(config);
    }

    private void onAdvanced1ReloadData() {
        String[] names={
                "sv_readyPercent",
                "sv_allowWarmupAllSpawnLocs",
                "sv_allowWarmupInfiniteGold",
                "svr_voipAllowAnyone",
                "svr_voipAllowOfficer",
                "svr_voipAllowCommander",
                "svr_voipTargetGlobal",
                "svr_voipTargetTeam",
                "svr_voipTargetSquad",
                "svr_voipStreamTime",
                "svr_voipStreamWait",
                "g_maxofficers",
                "g_clientsperofficer",
                "sv_enablesquads",
                "sv_autoSquadClients",
                "sv_autoSquadMinimum",
                "g_squadminperofficer",
                "sv_teamSwitchDelay",
                "sv_teamSwitchConnectFreedom",
                "sv_respawntime",
                "sv_ressurectTime",
                "sv_invincibleTime",
                "sv_invincibleTime_respawn",
                "sv_skillfullKillDist",
                "sv_blockArcMult"
        };
        HashMap<String,String> config=cman.get(names);
        readyPercentTextField.setText(config.get("sv_readyPercent"));
        if (config.get("sv_allowWarmupAllSpawnLocs").equals("1")) allowSpawningAtAllCheckBox.setSelected(true);
        else allowSpawningAtAllCheckBox.setSelected(false);
        if (config.get("sv_allowWarmupInfiniteGold").equals("1")) infiniteGoldAtWarmupCheckBox.setSelected(true);
        else infiniteGoldAtWarmupCheckBox.setSelected(false);
        if (config.get("svr_voipAllowAnyone").equals("1")) allowAnyoneCheckBox.setSelected(true);
        else allowAnyoneCheckBox.setSelected(false);
        if (config.get("svr_voipAllowOfficer").equals("1")) allowOfficersCheckBox.setSelected(true);
        else allowOfficersCheckBox.setSelected(false);
        if (config.get("svr_voipAllowCommander").equals("1")) allowCommandersCheckBox.setSelected(true);
        else allowCommandersCheckBox.setSelected(false);
        if (config.get("svr_voipTargetGlobal").equals("1")) allowGlobalVOIPChattingCheckBox.setSelected(true);
        else allowGlobalVOIPChattingCheckBox.setSelected(false);
        if (config.get("svr_voipTargetTeam").equals("1")) allowTeamVOIPChattingCheckBox.setSelected(true);
        else allowTeamVOIPChattingCheckBox.setSelected(false);
        if (config.get("svr_voipTargetSquad").equals("1")) allowSquadVOIPChattingCheckBox.setSelected(true);
        else allowSquadVOIPChattingCheckBox.setSelected(false);
        maxStreamTimeTextField.setText(config.get("svr_voipStreamTime"));
        streamWaitTimeTextField.setText(config.get("svr_voipStreamWait"));
        maxOfficerTextField.setText(config.get("g_maxofficers"));
        clientsPerOfficerTextField.setText(config.get("g_clientsperofficer"));
        if (config.get("sv_enablesquads").equals("1")) enableSquadsCheckBox.setSelected(true);
        else enableSquadsCheckBox.setSelected(false);
        if (config.get("sv_autoSquadClients").equals("1")) squadAutoAssignCheckBox.setSelected(true);
        else squadAutoAssignCheckBox.setSelected(false);
        autoSquadMinimumTextField.setText(config.get("sv_autoSquadMinimum"));
        squadMembersPerSquadOfficerTextField.setText(config.get("g_squadminperofficer"));
        teamSwitchDelayTextField.setText(config.get("sv_teamSwitchDelay"));
        teamSwitchFreedomTextField.setText(config.get("sv_teamSwitchConnectFreedom"));
        respawnTimeTextField.setText(config.get("sv_respawntime"));
        resurrectTimeTextField.setText(config.get("sv_ressurectTime"));
        invincibleTimeTextField.setText(config.get("sv_invincibleTime"));
        invincibleTimeRespawnFactorTextField.setText(config.get("sv_invincibleTime_respawn"));
        skillfullKillDistanceTextField.setText(config.get("sv_skillfullKillDist"));
        blockArcMultiplierTextField.setText(config.get("sv_blockArcMult"));
    }

    private void onAdvanced1Apply() {
        HashMap<String,String> config=new HashMap<String, String>();
        config.put("sv_readyPercent",readyPercentTextField.getText());
        config.put("sv_allowWarmupAllSpawnLocs",allowSpawningAtAllCheckBox.isSelected()?"1":"0");
        config.put("sv_allowWarmupInfiniteGold",infiniteGoldAtWarmupCheckBox.isSelected()?"1":"0");
        config.put("svr_voipAllowAnyone",allowAnyoneCheckBox.isSelected()?"1":"0");
        config.put("svr_voipAllowOfficer",allowOfficersCheckBox.isSelected()?"1":"0");
        config.put("svr_voipAllowCommander",allowCommandersCheckBox.isSelected()?"1":"0");
        config.put("svr_voipTargetGlobal",allowGlobalVOIPChattingCheckBox.isSelected()?"1":"0");
        config.put("svr_voipTargetTeam",allowTeamVOIPChattingCheckBox.isSelected()?"1":"0");
        config.put("svr_voipTargetSquad",allowSquadVOIPChattingCheckBox.isSelected()?"1":"0");
        config.put("svr_voipStreamTime",maxStreamTimeTextField.getText());
        config.put("svr_voipStreamWait",streamWaitTimeTextField.getText());
        config.put("g_maxofficers",maxOfficerTextField.getText());
        config.put("g_clientsperofficer",clientsPerOfficerTextField.getText());
        config.put("sv_enablesquads",enableSquadsCheckBox.isSelected()?"1":"0");
        config.put("sv_autoSquadClients",squadAutoAssignCheckBox.isSelected()?"1":"0");
        config.put("sv_autoSquadMinimum",autoSquadMinimumTextField.getText());
        config.put("g_squadminperofficer",squadMembersPerSquadOfficerTextField.getText());
        config.put("sv_teamSwitchDelay",teamSwitchDelayTextField.getText());
        config.put("sv_teamSwitchConnectFreedom",teamSwitchFreedomTextField.getText());
        config.put("sv_respawntime",respawnTimeTextField.getText());
        config.put("sv_ressurectTime",resurrectTimeTextField.getText()); //TODO: Schauen ob Variable nicht sv_resurrectTime stattdessen heißt!
        config.put("sv_invincibleTime",invincibleTimeTextField.getText());
        config.put("sv_invincibleTime_respawn",invincibleTimeRespawnFactorTextField.getText());
        config.put("sv_skillfullKillDist",skillfullKillDistanceTextField.getText());
        config.put("sv_blockArcMult",blockArcMultiplierTextField.getText());
        cman.set(config);
    }

    private void onGeneralReloadData() {
        String[] names={
                "svr_name",
                "sv_serverNotes",
                "svr_maxclients",
                "sv_balancedTeams",
                "svr_broadcast",
                "sv_sendStatsSEP",
                "svr_password",
                "svr_PasswordNoVIP",
                "svr_adminpassword",
                "sv_refereePassword",
                "sv_refGodPassword",
                "sv_team1race",
                "sv_team2race",
                "sv_team3race",
                "sv_team4race",
                "sv_team5race",
                "sv_team6race",
                "sv_motd1",
                "sv_motd2",
                "sv_motd3",
                "sv_motd4",
                "sv_motd5",
                "sv_motd6",
        };
        HashMap<String,String> config=cman.get(names);
        serverNameTextField.setText(config.get("svr_name"));
        serverNotesTextField.setText(config.get("sv_serverNotes"));
        maxPlayersTextField.setText(config.get("svr_maxclients"));
        if (config.get("sv_balancedTeams").equals("1")) balancedTeamsCheckBox.setSelected(true);
        else balancedTeamsCheckBox.setSelected(false);
        if (config.get("svr_broadcast").equals("1")) broadcastServerCheckBox.setSelected(true);
        else broadcastServerCheckBox.setSelected(false);
        if (config.get("sv_sendStatsSEP").equals("1")) sendStatsCheckBox.setSelected(true);
        else sendStatsCheckBox.setSelected(false);
        joinPasswordTextField.setText(config.get("svr_password"));
        adminPasswordTextField.setText(config.get("svr_adminpassword"));
        refereePasswordTextField.setText(config.get("sv_refereePassword"));
        godRefPasswordTextField.setText("sv_refGodPassword");
        if (config.get("sv_team1race").equals("beast")) team1ComboBox.setSelectedIndex(0);
        else team1ComboBox.setSelectedIndex(1);
        if (config.get("sv_team2race").equals("beast")) team2ComboBox.setSelectedIndex(0);
        else team2ComboBox.setSelectedIndex(1);
        if (config.get("sv_team3race").equals("beast")) team3ComboBox.setSelectedIndex(0);
        else team3ComboBox.setSelectedIndex(1);
        if (config.get("sv_team4race").equals("beast")) team4ComboBox.setSelectedIndex(0);
        else team4ComboBox.setSelectedIndex(1);
        motd1TextField.setText(config.get("sv_motd1"));
        motd2TextField.setText(config.get("sv_motd2"));
        motd3TextField.setText(config.get("sv_motd3"));
        motd4TextField.setText(config.get("sv_motd4"));
        motd5TextField.setText(config.get("sv_motd5"));
        motd6TextField.setText(config.get("sv_motd6"));
    }

    private void onGeneralApply() {
        HashMap<String,String> config=new HashMap<String,String>();
        config.put("svr_name",serverNameTextField.getText());
        config.put("sv_serverNotes",serverNotesTextField.getText());
        config.put("svr_maxclients",maxPlayersTextField.getText());
        config.put("sv_balancedTeams",balancedTeamsCheckBox.isSelected()?"1":"0");
        config.put("svr_broadcast",broadcastServerCheckBox.isSelected()?"1":"0");
        config.put("sv_sendStatsSEP",sendStatsCheckBox.isSelected()?"1":"0");
        config.put("svr_password",joinPasswordTextField.getText());
        config.put("svr_PasswordNoVIP",joinPasswordTextField.getText());
        config.put("svr_adminpassword",adminPasswordTextField.getText());
        config.put("sv_refereePassword",refereePasswordTextField.getText());
        config.put("sv_refGodPassword",godRefPasswordTextField.getText());
        if (team1ComboBox.getSelectedIndex()==0) config.put("sv_team1race","beast");
        else config.put("sv_team1race","human");
        if (team2ComboBox.getSelectedIndex()==0) config.put("sv_team2race","beast");
        else config.put("sv_team2race","human");
        if (team3ComboBox.getSelectedIndex()==0) config.put("sv_team3race","beast");
        else config.put("sv_team3race","human");
        if (team4ComboBox.getSelectedIndex()==0) config.put("sv_team4race","beast");
        else config.put("sv_team4race","human");
        config.put("sv_motd1",motd1TextField.getText());
        config.put("sv_motd2",motd2TextField.getText());
        config.put("sv_motd3",motd3TextField.getText());
        config.put("sv_motd4",motd4TextField.getText());
        config.put("sv_motd5",motd5TextField.getText());
        config.put("sv_motd6",motd6TextField.getText());
        cman.set(config);
    }

    private void onNextMap() {
        cman.execute("nextmap");
    }

    private void onUnpause() {
        cman.execute("unpause");
    }

    private void onPause() {
        cman.execute("pause");
    }

    private void onRestartMatch() {
        cman.execute("restartmatch");
    }

    private void onLogOut() {
        cman=null;
        dispose();
        new LoginForm();
    }

    private void onExtendTime() {
       cman.execute("time");
    }

    private void onDraw() {
        cman.execute("draw");
    }

    private void onBroadcastMessageSend() {
        cman.execute("svchat \""+broadcastMessageTextField.getText()+"\"");
    }
}
