package view;

import model.ConnectionManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JTextField textField1;
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
    private JTextField textField2;
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
    private JTextField invincibleTimeRespawnTextField;
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
    private JCheckBox allowItemDropOnCheckBox;
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
    private JRadioButton recordDemosRadioButton;
    private JRadioButton replayDemosRadioButton;
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
    }

    private void onLogOut() {
        cman.destroy();
        dispose();
        new LoginForm();
    }

    private void onExtendTime() {
       cman.execute("time");
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
