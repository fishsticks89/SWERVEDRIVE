<script lang="ts">
    export let wheelOrientation: number;
    export let robotOrientation: number;
    export let robotX: number;
    export let robotY: number;
    export let wheelIndex: number;
    function to_rad(num: number) {
        return (num * Math.PI) / 180.0;
    }
    $: location = {
        x: robotX + Math.cos(to_rad(robotOrientation + 45 + wheelIndex * 90)),
        y: robotY - Math.sin(to_rad(robotOrientation + 45 + wheelIndex * 90)),
    };
    let prevlocation = { x: 0, y: 0 };
    let diffangle = 0;
    let mag = 0;
    function getSlopeAngle(s1: number, s2: number) {
        return (Math.atan((s1) / (s2)) * 180) / Math.PI;
    }
    function getMagnitude(d1:number, d2: number) {
        return Math.sqrt(d1 * d1 + d2 * d2)
    }
    $: {
        const difflocation = {
            x: prevlocation.x - location.x,
            y: prevlocation.y - location.y,
        };
        diffangle = getSlopeAngle(difflocation.y, difflocation.x);
        mag = getMagnitude(difflocation.x, difflocation.y);
        prevlocation = location;
    }
</script>

<div
    style:left={location.x * 100 + "px"}
    style:top={location.y * 100 + "px"}
    style:transform={"rotate(" + -wheelOrientation + "deg)"}
/>

<div
    style:left={(location.x + 3) * 100 + "px"}
    style:top={location.y * 100 + "px"}
    style:border-right={"none"}
    style:background-color="blue"
    style:width={mag * 2000 + "px"}
    style:transform={"rotate(" +
        (diffangle >= 0 ? "" : "-") +
        Math.abs(diffangle) +
        "deg)"}
/>

<style>
    div {
        border-right: 1px solid red;
        position: fixed;
        background-color: gray;
        width: 20px;
        height: 6px;
    }
</style>
